package com.vti.blog_app01.service;

import com.vti.blog_app01.dto.UserDto;
import com.vti.blog_app01.entity.Role;
import com.vti.blog_app01.form.UserCreateForm;
import com.vti.blog_app01.mapper.UserMapper;
import com.vti.blog_app01.repository.RoleRepository;
import com.vti.blog_app01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service
public class UserServiceImp implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    //tao doi tuong de ma hoa mat khau
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDto create(UserCreateForm form) {
        var user = UserMapper.map(form);
        var encodedPassword=passwordEncoder.encode(form.getPassword());
        user.setPassword(encodedPassword);
        //
        var role = roleRepository.findByType(form.getRole());
        user.setRoles(Set.of(role));
        var savedUser = userRepository.save(user);
        return UserMapper.map(savedUser);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        var authorities = new ArrayList<GrantedAuthority>();
        var roles = user.getRoles();
        for (Role role : roles) {
            var type = role.getType().toString();
            var authority = new SimpleGrantedAuthority(type);
            authorities.add(authority);
        }
        return new User(
                username,
                user.getPassword(),
                authorities
        );
    }
}
