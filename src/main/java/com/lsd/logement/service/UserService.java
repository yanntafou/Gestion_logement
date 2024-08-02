package com.lsd.logement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lsd.logement.entity.personnel.AppUser;
import com.lsd.logement.security.payload.response.JwtResponse;

public interface UserService extends GenericService<AppUser, Integer> {

    boolean checkAdmin();

    JwtResponse login(AppUser appUser);

    AppUser enableUser(Integer id);

    Page<AppUser> findAllUser(Pageable pageable);

    void register(AppUser appUser);
}
