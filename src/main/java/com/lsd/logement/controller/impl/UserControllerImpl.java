package com.lsd.logement.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsd.logement.controller.UserController;
import com.lsd.logement.dto.UserDTO;
import com.lsd.logement.entity.personnel.AppUser;
import com.lsd.logement.mapper.UserMapper;
import com.lsd.logement.model.ApiResponse;
import com.lsd.logement.service.UserService;

@RequestMapping("/api/AppUser")
@RestController
public class UserControllerImpl implements UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserControllerImpl(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    @PostMapping
    public ResponseEntity<ApiResponse<?>> save(@RequestBody UserDTO userDTO) {
        try {
            AppUser appUser = userMapper.asEntity(userDTO);
            return ResponseEntity.ok(
                    new ApiResponse<>(userMapper.asDTO(userService.save(appUser)))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> findById(@PathVariable("id") Integer id) {
        try {
            AppUser appUser = userService.findById(id).orElse(null);
            return ResponseEntity.ok(
                    new ApiResponse<>(userMapper.asDTO(appUser))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable("id") Integer id) {
        try {
            userService.deleteById(id);
            return ResponseEntity.ok(new ApiResponse<>("User deleted successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.from(e));
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<ApiResponse<?>> list() {
        try {
            return ResponseEntity.ok(
                    new ApiResponse<>(userMapper.asDTOList(userService.findAll()))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @PatchMapping("/enable")
    public ResponseEntity<ApiResponse<?>> enable(Integer id) {
        try {
            return ResponseEntity.ok(
                    new ApiResponse<>(userMapper.asDTO(userService.enableUser(id)))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @GetMapping("/page-query")
    public ResponseEntity<ApiResponse<?>> pageQuery(Pageable pageable) {
        try {
            Page<AppUser> userPage = userService.findAll(pageable);
            List<UserDTO> dtoList = userPage
                    .stream()
                    .map(userMapper::asDTO).collect(Collectors.toList());
            return ResponseEntity.ok(
                    new ApiResponse<>(new PageImpl<>(dtoList, pageable, userPage.getTotalElements()))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> update(@RequestBody UserDTO userDTO, @PathVariable("id") Integer id) {
        try {
            AppUser appUser = userMapper.asEntity(userDTO);
            return ResponseEntity.ok(
                    new ApiResponse<>(userMapper.asDTO(userService.update(appUser, id)))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }
}
