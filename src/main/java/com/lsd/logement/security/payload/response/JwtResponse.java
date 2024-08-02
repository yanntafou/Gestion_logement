package com.lsd.logement.security.payload.response;

import java.util.List;

import com.lsd.logement.entity.personnel.AppUser;

public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private final List<String> roles;
    private AppUser userDetails;

    public JwtResponse(String accessToken, AppUser userDetail, List<String> roles) {
        this.token = accessToken;
        this.userDetails = userDetail;
        this.roles = roles;
    }

    public JwtResponse(int i, String message) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getToken() {
        return token;
    }

    public JwtResponse setToken(String token) {
        this.token = token;
        return this;
    }

    public String getType() {
        return type;
    }

    public JwtResponse setType(String type) {
        this.type = type;
        return this;
    }

    public AppUser getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(AppUser userDetails) {
        this.userDetails = userDetails;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setStatusCode(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setError(String message) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getStatusCode() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getError() {
        throw new UnsupportedOperationException("Unimplemented method 'getError'");
    }

}
