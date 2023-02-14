package com.example.webserver.controller;

import com.example.webserver.model.User;
import com.google.api.client.googleapis.auth.clientlogin.ClientLogin.Response;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    
    @RequestMapping(value = "/user"
        , consumes = MediaType.APPLICATION_JSON_VALUE
        , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody User user) {
        // return user;
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
