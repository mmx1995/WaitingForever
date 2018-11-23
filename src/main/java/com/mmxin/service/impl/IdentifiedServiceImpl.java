package com.mmxin.service.impl;

import com.mmxin.mapper.IdentifyMapper;
import com.mmxin.pojo.Identify;
import com.mmxin.service.IdentifiedService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class IdentifiedServiceImpl implements IdentifiedService {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    IdentifyMapper mapper;



    @Transactional
    @Override
    public int save(Identify identified) throws SQLException {
        return this.mapper.insertSelective(identified);
    }

    @Override
    public Identify getByEmail(String email) {
        return this.mapper.selectByEmail(email);
    }
}
