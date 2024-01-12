package com.example.sunbaseTest.customerManagement.Utils;

import com.example.sunbaseTest.customerManagement.Model.UserLoginCredentials;
import com.example.sunbaseTest.customerManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserLoginCredentials user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("no user found");
        }
        return new CustomUserDetails(user);
    }
}
