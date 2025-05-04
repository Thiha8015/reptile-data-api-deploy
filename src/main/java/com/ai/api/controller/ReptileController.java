package com.ai.api.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.MD5;
import com.ai.api.object.domain.UserData;
import com.ai.api.object.dto.Result;
import com.ai.api.object.vo.UserDataVo;
import com.ai.api.service.UserDataService;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/** 爬虫 Controller */
@RestController
@RequestMapping("/api/reptile")
public class ReptileController {

  @Resource private UserDataService userDataService;

  @Resource private OllamaService ollamaService;

  /**
   * 测试接口
   *
   * @return 返回信息
   */
  @SaIgnore
  @RequestMapping("/hello")
  public String hello() {
    return "Hello World!";
  }

  /**
   * 添加爬虫数据
   *
   * @return 返回信息
   */
  @SaIgnore
  @PostMapping("/add")
  public Result<Boolean> addReptileData(@RequestBody UserDataVo userDataVo) {
    try {
      UserData userData = BeanUtil.copyProperties(userDataVo, UserData.class);
      if (userDataService.addUserData(userData)) {
        return Result.success(true);
      }
      return Result.error(500, "添加失败");
    } catch (Exception e) {
      return Result.error(501, "添加失败");
    }
  }

  /**
   * 判断爬虫数据是否存在
   *
   * @return 返回信息
   */
  @SaIgnore
  @GetMapping("/has")
  public Result<Boolean> hasReptileData(@RequestParam String url) {
    try {
      String md5 = MD5.create().digestHex(url);
      if (userDataService.hasUserDataByMD5(md5)) {
        return Result.success(true);
      } else {
        return Result.success(false);
      }
    } catch (Exception e) {
      return Result.error(501, "查询失败");
    }
  }

  /**
   * 批量判断爬虫数据是否存在
   *
   * @param urls url列表
   * @return 返回信息
   */
  @SaIgnore
  @PostMapping("/hasBath")
  public Result<List<String>> hasReptileDataBath(@RequestBody List<String> urls) {
    List<String> md5s1 = userDataService.listMd5();
    try {
      List<String> md5s =
          new java.util.ArrayList<>(urls.stream().map(url -> MD5.create().digestHex(url)).toList());
      md5s.removeAll(md5s1);
      return Result.success(md5s);
    } catch (Exception e) {
      return Result.error(501, "查询失败");
    }
  }

  /**
   * 查询爬虫数据
   *
   * @return 返回信息
   */
  @SaIgnore
  @GetMapping("/existData")
  public Result<List<String>> existData() {
    try {
      List<String> md5List = userDataService.listMd5();
      return Result.success(md5List);
    } catch (Exception e) {
      return Result.error(501, "查询失败");
    }
  }
}
