package com.vti.blog_app01.service;

import com.vti.blog_app01.dto.UserDto;
import com.vti.blog_app01.form.UserCreateForm;
import com.vti.blog_app01.mapper.UserMapper;
import com.vti.blog_app01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    //tao doi tuong de ma hoa mat khau
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto create(UserCreateForm form) {
        var user = UserMapper.map(form);
        var encodedPassword=passwordEncoder.encode(form.getPassword());
        user.setPassword(encodedPassword);
        var savedUser = userRepository.save(user);
        return UserMapper.map(savedUser);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new User(
                username,
                user.getPassword(),
                AuthorityUtils.NO_AUTHORITIES
        );
    }
}
