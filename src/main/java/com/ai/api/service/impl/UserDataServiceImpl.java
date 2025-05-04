package com.ai.api.service.impl;

import cn.hutool.crypto.digest.MD5;
import cn.xbatis.core.sql.executor.chain.QueryChain;
import cn.xbatis.core.sql.executor.chain.UpdateChain;
import com.ai.api.mapper.UserDataMapper;
import com.ai.api.object.domain.UserData;
import com.ai.api.object.dto.Page;
import com.ai.api.service.UserDataService;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 业务 - 用户数据 Service实现 */
@Transactional
@Service
public class UserDataServiceImpl implements UserDataService {

  @Resource private UserDataMapper userDataMapper;

  /**
   * 添加用户数据
   *
   * @param userData 用户数据
   * @return 添加结果
   */
  @Override
  public boolean addUserData(UserData userData) {
    if (userData.getMd5() == null) {
      userData.setMd5(MD5.create().digestHex(userData.getUrl()));
    }
    if (hasUserDataByMD5(userData.getMd5())) return false;
    return userDataMapper.save(userData) > 0;
  }

  /**
   * 判断是否存在用户数据
   *
   * @param md5 MD5值
   * @return 是否存在
   */
  @Override
  public boolean hasUserDataByMD5(String md5) {
    return QueryChain.of(userDataMapper).eq(UserData::getMd5, md5).count() > 0;
  }

  /**
   * 判断是否存在用户数据
   *
   * @param name 用户名
   * @param address 地址
   * @return 是否存在
   */
  @Override
  public boolean hasUserData(String name, String address) {
    return QueryChain.of(userDataMapper)
            .eq(UserData::getName, name)
            .eq(UserData::getAddress, address)
            .count()
        > 0;
  }

  /**
   * 分页查询用户数据
   *
   * @param page 页码
   * @param size 每页数量
   * @return 分页结果
   */
  @Override
  public Page<UserData> page(int page, int size) {
    Page<UserData> pager = new Page<>();
    pager.setCurrent(page);
    pager.setSize(size);
    return QueryChain.of(userDataMapper).orderBy(UserData::getCreateTime).paging(pager);
  }

  /**
   * 判断是否存在用户数据
   *
   * @param url URL 地址
   * @return 是否存在
   */
  @Transactional()
  @Override
  public boolean hasUserData(String url) {
    return QueryChain.of(userDataMapper).eq(UserData::getUrl, url).count() > 0;
  }

  /**
   * 获取所有用户数据
   *
   * @return 用户数据列表
   */
  @Override
  public List<UserData> list() {
    return QueryChain.of(userDataMapper).list();
  }

  /**
   * 分页查询用户数据
   *
   * @param page 页码
   * @param size 每页数量
   * @return 用户数据分页结果
   */
  @Override
  public List<UserData> listByPage(int page, int size) {
    return page(page, size).getResults();
  }

  /**
   * 根据 ID 更新用户数据
   *
   * @param userData 用户数据
   */
  @Override
  public void updateById(UserData userData) {
    UpdateChain.of(userDataMapper)
        .update(UserData.class)
        .set(UserData::getMd5, userData.getMd5())
        .eq(UserData::getId, userData.getId())
        .execute();
  }

  /**
   * 获取所有用户数据的 MD5 列表
   *
   * @return MD5 列表
   */
  @Override
  public List<String> listMd5() {
    return QueryChain.of(userDataMapper).select(UserData::getMd5).returnType(String.class).list();
  }
}
