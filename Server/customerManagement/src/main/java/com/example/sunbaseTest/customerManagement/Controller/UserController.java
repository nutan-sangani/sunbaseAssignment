package com.example.sunbaseTest.customerManagement.Controller;

import com.example.sunbaseTest.customerManagement.Model.AccessToken;
import com.example.sunbaseTest.customerManagement.Model.UserLoginCredentials;
import com.example.sunbaseTest.customerManagement.Repository.UserRepository;
import com.example.sunbaseTest.customerManagement.Utils.JwtUtils;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("login")
    public ResponseEntity<String> userLogin(@RequestBody UserLoginCredentials user)
    {
        String response = userRepository.userLogin(user);
        if(response.equals("unauthorized"))
        {
            return new ResponseEntity<>("Unauthorized user", HttpStatus.UNAUTHORIZED);
        }
        else return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
