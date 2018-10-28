package com.mmxin.mapper;

import com.mmxin.pojo.Identified;
import com.mmxin.pojo.IdentifiedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IdentifiedMapper {
    int countByExample(IdentifiedExample example);

    int deleteByExample(IdentifiedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Identified record);

    int insertSelective(Identified record);

    List<Identified> selectByExample(IdentifiedExample example);

    Identified selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Identified record, @Param("example") IdentifiedExample example);

    int updateByExample(@Param("record") Identified record, @Param("example") IdentifiedExample example);

    int updateByPrimaryKeySelective(Identified record);

    int updateByPrimaryKey(Identified record);
}