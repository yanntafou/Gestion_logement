package com.lsd.logement.entity.personnel;

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.lsd.logement.entity.AbstractEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AppUser implements AbstractEntity<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private String phone;
    private String address;
    private String email;
    private String username;
    private String password;
    private String roles;
    private boolean enabled;
    private ZonedDateTime createdAt;
    private ZonedDateTime lastUpdatedAt;
    private ZonedDateTime connectedAt;

    public AppUser() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getEnabled() {
        return enabled;
    }

    @Override
    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public ZonedDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    @Override
    public void setLastUpdatedAt(ZonedDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public ZonedDateTime getConnectedAt() {
        return connectedAt;
    }

    public void setConnectedAt(ZonedDateTime connectedAt) {
        this.connectedAt = connectedAt;
    }

    @Override
    public String toString() {
        return "AppUser{"
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
