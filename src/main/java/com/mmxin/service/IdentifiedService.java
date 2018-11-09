package com.mmxin.service;

import com.mmxin.pojo.Identify;

import java.sql.SQLException;

public interface IdentifiedService {

    int save(Identify identified) throws SQLException;

    Identify getByEmail(String email) ;

}
