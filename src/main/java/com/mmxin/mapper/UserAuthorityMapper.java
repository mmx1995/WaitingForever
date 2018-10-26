package com.mmxin.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserAuthorityMapper {

    int insert(@Param("userId") Long userId, @Param("authorityId") Long authorityId);

}