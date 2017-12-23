package org.haozf.security.manager;

import java.util.Set;

import org.haozf.common.BaseLogger;
import org.haozf.security.model.Realm;
import org.springframework.stereotype.Component;

/**
 * 权限控制器
 */
@Component
public class AuthorityManager<T extends Realm> extends BaseLogger{
    
    public Set<String> authority(T realm){
        log.info("获取当前用户权限");
        return realm.getAuthoritys();
    }
    
    public void addAuthority(T realm,Set<String> authority){
        if(authority==null) return;
        log.info("为当前用户设置权限");
        realm.getAuthoritys().addAll(authority);
    }
    
    public void removeAuthority(T realm,String authority){
        log.info("当前用户删除权限");
        realm.getAuthoritys().remove(authority);
    }
    
    public void clean(T realm){
        log.info("清空权限");
        realm.getAuthoritys().clear();
    }
}
