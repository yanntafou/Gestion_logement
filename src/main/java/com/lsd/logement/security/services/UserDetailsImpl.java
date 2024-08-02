package com.lsd.logement.security.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsd.logement.entity.personnel.AppUser;

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String ref;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private final boolean enabled;
    @JsonIgnore
    private String password;

    private final Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(AppUser appUser, Collection<? extends GrantedAuthority> authorities) {
        this.firstName = appUser.getFirstname();
        this.lastName = appUser.getLastname();
        this.username = appUser.getUsername();
        this.password = appUser.getPassword();
        this.email = appUser.getEmail();
        this.authorities = authorities;
        System.out.println("Enable : " + appUser.getEnabled());
        this.enabled = appUser.getEnabled();
    }

    public static UserDetailsImpl build(AppUser appUser) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(appUser.getRoles());
        authorities.add(authority);

        return new UserDetailsImpl(appUser, authorities);
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
