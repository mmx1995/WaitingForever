package com.mmxin.mapper;

import com.mmxin.pojo.RequestLog;
import com.mmxin.pojo.RequestLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RequestLogMapper {
    int countByExample(RequestLogExample example);

    int deleteByExample(RequestLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RequestLog record);

    int insertSelective(RequestLog record);

    List<RequestLog> selectByExample(RequestLogExample example);

    RequestLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RequestLog record, @Param("example") RequestLogExample example);

    int updateByExample(@Param("record") RequestLog record, @Param("example") RequestLogExample example);

    int updateByPrimaryKeySelective(RequestLog record);

    int updateByPrimaryKey(RequestLog record);
}