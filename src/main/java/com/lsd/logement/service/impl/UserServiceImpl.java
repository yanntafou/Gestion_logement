package com.lsd.logement.service.impl;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lsd.logement.entity.personnel.AppUser;
import com.lsd.logement.exception.GeneralBaseException;
import com.lsd.logement.exception.NotFoundMessage;
import com.lsd.logement.exception.UserExceptionMessage;
import com.lsd.logement.repository.UserRepository;
import com.lsd.logement.security.jwt.JwtUtils;
import com.lsd.logement.security.payload.response.JwtResponse;
import com.lsd.logement.security.services.UserDetailsImpl;
import com.lsd.logement.service.CaisseService;
import com.lsd.logement.service.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final CaisseService caisseService;

    public UserServiceImpl(UserRepository repository, JwtUtils jwtUtils, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, CaisseService caisseService) {
        this.repository = repository;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.caisseService = caisseService;
    }

    @Override
    public AppUser save(AppUser entity) {
        ZonedDateTime currentDate = ZonedDateTime.now();
        entity.setCreatedAt(currentDate);
        entity.setLastUpdatedAt(currentDate);
        entity.setPassword(this.passwordEncoder.encode(entity.getPassword()));
        if (entity.getRoles() == null || entity.getRoles().isEmpty()) {
            entity.setRoles("ROLE_USER");
        }
        return repository.save(entity);
    }

    @Override
    public List<AppUser> save(List<AppUser> entity) {
        return (List<AppUser>) repository.saveAll(entity);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AppUser> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<AppUser> findAll() {
        return (List<AppUser>) repository.findAll();
    }

    @Override
    public Page<AppUser> findAll(Pageable pageable) {
        Page<AppUser> entityPage = repository.findAll(pageable);
        List<AppUser> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AppUser update(AppUser entity, Integer id) {
        Optional<AppUser> optional = findById(id);
        if (optional.isPresent()) {
            entity.setId(optional.get().getId());
            entity.setLastUpdatedAt(ZonedDateTime.now());
            return save(entity);
        }
        return null;
    }

    @Override
    public JwtResponse login(AppUser appUser) {
        try {
            Authentication authentication = this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwtToken = jwtUtils.generateToken((UserDetails) authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            if (!userDetails.getEnabled()) {
                throw new GeneralBaseException(UserExceptionMessage.USER_IS_DISABLED);
            }

            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            AppUser tmpUser = repository.findByUsername(userDetails.getUsername());

            tmpUser.setConnectedAt(ZonedDateTime.now());
            tmpUser = repository.save(tmpUser);
            return new JwtResponse(jwtToken, tmpUser, roles);
        } catch (BadCredentialsException e) {
            throw new GeneralBaseException(404, "Invalid username or password");
        } catch (GeneralBaseException | AuthenticationException e) {
            throw new GeneralBaseException(403, "An unexpected error occurred");
        }
    }

    @Override
    public void register(AppUser appUser) {

        Optional<AppUser> existingUser = repository.findByEmail(appUser.getEmail());
        if (existingUser.isPresent()) {
            throw new GeneralBaseException(409, "Email already in use");
        }

        try {
            AppUser addUser = new AppUser();
            addUser.setFirstname(appUser.getFirstname());
            addUser.setLastname(appUser.getLastname());
            addUser.setPhone(appUser.getPhone());
            addUser.setAddress(appUser.getAddress());
            addUser.setEmail(appUser.getEmail());
            addUser.setUsername(appUser.getUsername());
            addUser.setRoles(appUser.getRoles());
            addUser.setPassword(passwordEncoder.encode(appUser.getPassword()));

            repository.save(addUser);

        } catch (Exception e) {
            throw new RuntimeException("Failed to register user", e);
        }

    }

    @Override
    public AppUser enableUser(Integer id) {
        Optional<AppUser> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new GeneralBaseException(NotFoundMessage.USER_NOT_FOUND);
        }
        AppUser AppUser = optional.get();
        AppUser.setEnabled(true);
        AppUser.setLastUpdatedAt(ZonedDateTime.now());
        return repository.save(AppUser);
    }

    @Override
    public Page<AppUser> findAllUser(Pageable pageable) {
        return repository.findAllByRolesIsNot("ROLE_ADMIN", pageable);
    }

    @Override
    public boolean checkAdmin() {
        return repository.existsByRoles("ROLE_ADMIN");
    }

    public CaisseService getCaisseService() {
        return caisseService;
    }

}
