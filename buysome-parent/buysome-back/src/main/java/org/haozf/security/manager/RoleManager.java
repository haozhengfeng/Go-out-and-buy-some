package org.haozf.security.manager;

import java.util.Set;

import org.haozf.common.BaseLogger;
import org.haozf.security.model.Realm;
import org.springframework.stereotype.Component;

/**
 * 角色控制器
 */
@Component
public class RoleManager<T extends Realm> extends BaseLogger{
    
    public Set<String> role(T realm){
        log.info("获取当前用户角色");
        return realm.getRoles();
    }
    
    public void addRole(T realm,Set<String> role){
        if(role==null) return;
        log.info("为当前用户添加角色");
        realm.getRoles().addAll(role);
    }
    
    public void removeRole(T realm,String role){
        log.info("当前用户删除角色");
        realm.getRoles().remove(role);
    }
    
    public void clean(T realm){
        log.info("清空角色");
        realm.getRoles().clear();
    }
    
}
