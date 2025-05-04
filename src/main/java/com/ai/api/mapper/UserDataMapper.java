package com.ai.api.mapper;

import cn.xbatis.core.mybatis.mapper.MybatisMapper;
import com.ai.api.object.domain.UserData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/** 业务 - 用户数据 Mapper */
@Mapper
public interface UserDataMapper extends MybatisMapper<UserData> {

  /**
   * 根据URL查询用户数据数量
   *
   * @param url URL
   * @return 用户数据数量
   */
  @Select("SELECT COUNT(*) FROM b_user_data WHERE url = #{url}")
  int countByUrl(String url);
}
