package com.example.webserver.service;

import com.example.webserver.model.*;
import com.example.webserver.mapper.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class InformationService {

    @Autowired
    WebMapperImpl webMapper;

    public User selectOne(String uid) {
        return webMapper.userSelect(uid);
    }
}
