package org.haozf.security.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Realm implements Serializable{
    
    private static final long serialVersionUID = -398249604523488656L;
    
    private String token;
    private Set<String> roles;
    private Set<String> authoritys;
    private Object member;

    public Realm(){
        this.roles = new HashSet<String>();
        this.authoritys = new HashSet<String>();
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getAuthoritys() {
        return authoritys;
    }

    public void setAuthoritys(Set<String> authoritys) {
        this.authoritys = authoritys;
    }
    
    public Object getMember() {
        return member;
    }

    public void setMember(Object member) {
        this.member = member;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
