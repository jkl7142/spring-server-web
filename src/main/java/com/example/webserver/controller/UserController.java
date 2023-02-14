package com.example.webserver.controller;

import com.example.webserver.model.User;
import com.example.webserver.service.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Value("${myId}")
    String myId;

    @Autowired
    InformationService informationService;

    @RequestMapping(value = "/user"
        , consumes = MediaType.APPLICATION_JSON_VALUE
        , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // return user;
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/info"
        , consumes = MediaType.APPLICATION_JSON_VALUE
        , produces = MediaType.APPLICATION_JSON_VALUE
        , method = RequestMethod.GET
    )
    public ResponseEntity<User> PrintUser() {
        ResponseEntity<User> res = new ResponseEntity<>(informationService.selectOne(myId), HttpStatus.OK);
        return res;
    }

}
