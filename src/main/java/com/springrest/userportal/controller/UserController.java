package com.springrest.userportal.controller;

import com.springrest.userportal.model.User;
import com.springrest.userportal.repository.UserRepository;
import com.springrest.userportal.validator.AuthValidator;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/rest")
@Slf4j
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthValidator authValidator;

    @GetMapping("/users")
    public Iterable<User> getAllUsers( @RequestHeader(value = "Authorization", required = false) String authorization){

       authValidator.validateAuthorization(authorization);

       return userRepository.findAll();
    }

    @PostMapping("/saveUser")
    public Iterable<User> saveUser(@RequestBody User user, @RequestHeader(value = "Authorization", required = false) String authorization){

        authValidator.validateAuthorization(authorization);

        userRepository.save(user);

        return userRepository.findAll();
    }


    @GetMapping("/getUser/{id}")
    public Optional<User> getUser(@PathVariable String id,@RequestHeader(value = "Authorization", required = false) String authorization){

       authValidator.validateAuthorization(authorization);

      return userRepository.findById(id);
    }
}
