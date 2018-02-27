package org.haozf.security.manager;

import java.util.HashSet;
import java.util.Set;

import org.haozf.mybatis.common.BaseLogger;
import org.haozf.security.model.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecurityManager<T extends Realm> extends BaseLogger{
    
    @Autowired
    SessionManager<T> sessionManager;
    
    @Autowired
    RoleManager<T> roleManager;
    
    @Autowired
    AuthorityManager<T> authorityManager;
    
    public T getSubject(){
        return sessionManager.getRealm();
    }
    
    public void login(T member){
        sessionManager.setSession(member);
        Set<String> roles = new HashSet<String>();
        roleManager.addRole(member,roles);
        Set<String> authoritys = new HashSet<String>();
        authorityManager.addAuthority(member,authoritys);
    }
    
    public void logout(){
        sessionManager.clean();
    }
    
}
