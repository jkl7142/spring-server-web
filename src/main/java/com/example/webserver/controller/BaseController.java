package com.example.webserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public String getCallback(@RequestParam String code) {
        return code;
    }

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String healthCheck() {
        return "{\"status\":\"UP\"}";
    }

}