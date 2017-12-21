package org.haozf.member.model;

import org.haozf.security.model.Realm;

public class Member extends Realm{
    
    private static final long serialVersionUID = 8887424219718604254L;
    
    private String id;
    private String name;
    private String password;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
