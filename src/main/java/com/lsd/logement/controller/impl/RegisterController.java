package com.lsd.logement.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsd.logement.entity.personnel.AppUser;
import com.lsd.logement.mapper.UserMapper;
import com.lsd.logement.model.ApiResponse;
import com.lsd.logement.service.UserService;

@RestController
@RequestMapping("/auth")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<?>> registerUser(@RequestBody AppUser appUser) {
        try {
            userService.register(appUser);
            return ResponseEntity.ok(new ApiResponse<>("User registered successfully"));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.from(e));
        }
    }

}
