package com.mmxin.service.impl;

import com.mmxin.mapper.RequestLogMapper;
import com.mmxin.pojo.RequestLog;
import com.mmxin.service.RequestLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : mmxin
 * @className : RequestLogServiceImpl
 * @date : 2018/10/26 11:33
 */
@Service
public class RequestLogServiceImpl implements RequestLogService {

    @Autowired
    private RequestLogMapper mapper ;

    @Override
    public void save(RequestLog requestLog) {
        mapper.insert(requestLog);
    }
}
