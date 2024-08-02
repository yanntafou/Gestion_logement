package com.lsd.logement.dto;

import java.time.ZonedDateTime;

public class UserDTO extends AbstractDTO<Integer> {

    private Integer id;
    private String username;
    private String password;
    private ZonedDateTime createdAt;
    private ZonedDateTime lastUpdatedAt;
    private ZonedDateTime connectedAt;
    private boolean enabled;
    private String firstname;
    private String lastname;
    private String phone;
    private String address;
    private String email;
    private String roles;

    public UserDTO() {
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setCreatedAt(java.time.ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public java.time.ZonedDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setLastUpdatedAt(java.time.ZonedDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public java.time.ZonedDateTime getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public void setConnectedAt(java.time.ZonedDateTime connectedAt) {
        this.connectedAt = connectedAt;
    }

    public java.time.ZonedDateTime getConnectedAt() {
        return this.connectedAt;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getRoles() {
        return this.roles;
    }

    @Override
    public String toString() {
        return "UserDTO{"
                + "id=" + id
                + ", username='" + username + '\''
                + ", password='" + password + '\''
                + ", createdAt=" + createdAt
                + ", lastUpdatedAt=" + lastUpdatedAt
                + ", connectedAt=" + connectedAt
                + ", enabled=" + enabled
                + ", firstname='" + firstname + '\''
                + ", lastname='" + lastname + '\''
                + ", phone='" + phone + '\''
                + ", address='" + address + '\''
                + ", email='" + email + '\''
                + ", roles='" + roles + '\''
                + '}';
    }

}
