package com.ai.api.service;

import com.ai.api.object.domain.UserData;
import com.ai.api.object.dto.Page;
import java.util.List;

/** 业务 - 用户数据 Service */
public interface UserDataService {

  /**
   * 添加用户数据
   *
   * @param userData 用户数据
   * @return 是否添加成功
   */
  boolean addUserData(UserData userData);

  /**
   * 判断是否存在指定MD5的用户数据
   *
   * @param md5 MD5值
   * @return 是否存在
   */
  boolean hasUserDataByMD5(String md5);

  /**
   * 判断是否存在指定URL的用户数据
   *
   * @param name 用户名
   * @param address 地址
   * @return 是否存在
   */
  boolean hasUserData(String name, String address);

  /**
   * 分页查询用户数据
   *
   * @param page 页码
   * @param size 每页数量
   * @return 用户数据分页结果
   */
  Page<UserData> page(int page, int size);

  /**
   * 判断是否存在指定URL的用户数据
   *
   * @param url URL
   * @return 是否存在
   */
  boolean hasUserData(String url);

  /**
   * 查询所有用户数据
   *
   * @return 用户数据列表
   */
  List<UserData> list();

  /**
   * 分页查询用户数据
   *
   * @param page 页码
   * @param size 每页数量
   * @return 用户数据分页结果
   */
  List<UserData> listByPage(int page, int size);

  /**
   * 根据ID更新用户数据
   *
   * @param userData 用户数据
   */
  void updateById(UserData userData);

  /**
   * 查询所有MD5值
   *
   * @return MD5值列表
   */
  List<String> listMd5();
}
