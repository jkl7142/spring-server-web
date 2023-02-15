package com.example.webserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.webserver.model.User;
import com.example.webserver.service.InformationService;

@RestController
public class UserController {
    
    @Value("${myId}")
    String myId;

    @Autowired
    InformationService informationService;

    // Request with json
    @RequestMapping(value = "/user"
        , consumes = MediaType.APPLICATION_JSON_VALUE
        , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // return user;
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Request with param
    @RequestMapping(value = "/user"
        , method = RequestMethod.GET)
    public ResponseEntity<User> getUserByParam(@RequestParam String uid) {
        ResponseEntity<User> res = new ResponseEntity<>(informationService.selectOne(uid), HttpStatus.OK);
        return res;
    }

    // Request with path variable
    @RequestMapping(value = "/user/{uid}"
        , method = RequestMethod.GET)
    public ResponseEntity<User> getUserByPath(@PathVariable("uid") String uid) {
        ResponseEntity<User> res = new ResponseEntity<>(informationService.selectOne(uid), HttpStatus.OK);
        return res;
    }

    // Request with property    // uid: jkl410907
    @RequestMapping(value = "/user/info"
        , method = RequestMethod.GET
    )
    public ResponseEntity<User> PrintUser() {
        ResponseEntity<User> res = new ResponseEntity<>(informationService.selectOne(myId), HttpStatus.OK);
        return res;
    }

}
