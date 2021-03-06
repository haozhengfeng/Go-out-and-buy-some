package org.haozf.security.manager;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.haozf.mybatis.common.BaseLogger;
import org.haozf.security.model.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * session控制器
 */
@Component
public class SessionManager<T extends Realm> extends BaseLogger{
    
    public final static String SESSION_MEMBER="_SESSION_MEMBER_";
    public final static String SESSION_MEMBER_ID="_SESSION_MEMBER_ID_";
    
    @Autowired  
    private HttpSession session;  
      
    @Autowired  
    private HttpServletRequest request;  

    public T getRealm(){
        T member = (T)session.getAttribute(SESSION_MEMBER);
        return member;
    }
    
    public void setSession(Realm realm){
        realm.setToken(UUID.randomUUID().toString());
        session.setAttribute(SESSION_MEMBER_ID, realm.getToken());
        session.setAttribute(SESSION_MEMBER, realm);
    }
    
    public void clean(){
        session.invalidate();
    }
    
}
