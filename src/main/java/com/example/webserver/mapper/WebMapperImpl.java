package com.example.webserver.mapper;

import javax.annotation.Resource;

import com.example.webserver.model.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class WebMapperImpl implements WebMapper {
    @Resource(name = "webDBSqlSessionTemplate")
    SqlSession sqlSession;

    @Override
    public User userSelect(String uid) {
        return sqlSession.selectOne("userSelect", uid);
    }
}
