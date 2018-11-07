package com.mmxin.service.impl;

import com.mmxin.mapper.IdentifiedMapper;
import com.mmxin.pojo.Identified;
import com.mmxin.service.IdentifiedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentifiedServiceImpl implements IdentifiedService {

    @Autowired
    IdentifiedMapper mapper ;

    @Override
    public int save(Identified identified) {
        return mapper.insert(identified);
    }
}
