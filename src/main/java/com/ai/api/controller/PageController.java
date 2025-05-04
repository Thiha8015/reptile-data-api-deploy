package com.ai.api.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.idev.excel.FastExcel;
import com.ai.api.object.domain.UserData;
import com.ai.api.object.dto.Page;
import com.ai.api.object.dto.Result;
import com.ai.api.object.vo.UserDataVo;
import com.ai.api.service.UserDataService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domain")
public class PageController {

  @Resource private UserDataService userDataService;

  /**
   * 查询爬虫数据
   *
   * @return 返回信息
   */
  @GetMapping("/page")
  public Result<Page<UserDataVo>> listReptileData(
      @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
    try {
      Page<UserData> userDataPage = userDataService.page(page, size);
      List<UserDataVo> list =
          userDataPage.getResults().stream()
              .map(u -> BeanUtil.copyProperties(u, UserDataVo.class))
              .toList();
      Page<UserDataVo> pager = new Page<>();
      BeanUtil.copyProperties(userDataPage, pager, "results");
      pager.setResults(list);
      return Result.success(pager);
    } catch (Exception e) {
      return Result.error(501, "查询失败");
    }
  }

  /**
   * 导出爬虫数据
   *
   * @param response 响应对象
   * @throws IOException IO异常
   */
  @GetMapping("/export")
  public void export(HttpServletResponse response) throws IOException {
    List<UserData> data = userDataService.list();
    List<UserDataVo> list =
        data.stream().map(u -> BeanUtil.copyProperties(u, UserDataVo.class)).toList();

    exportHandler(response, list);
  }

  private void exportHandler(HttpServletResponse response, List<UserDataVo> list)
      throws IOException {
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setCharacterEncoding("utf-8");

    String fileName =
        URLEncoder.encode(
                "export-" + DateUtil.formatDateTime(DateUtil.date()), StandardCharsets.UTF_8)
            .replaceAll("\\+", "%20");
    response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
    FastExcel.write(response.getOutputStream(), UserDataVo.class).sheet("数据").doWrite(list);
  }

  /**
   * 导出当前页数据
   *
   * @param response 响应对象
   * @param page 页码
   * @param size 每页大小
   * @throws IOException IO异常
   */
  @GetMapping("/exportThisPage")
  public void exportThisPage(
      HttpServletResponse response,
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int size)
      throws IOException {
    List<UserData> data = userDataService.listByPage(page, size);
    List<UserDataVo> list =
        data.stream().map(u -> BeanUtil.copyProperties(u, UserDataVo.class)).toList();

    exportHandler(response, list);
  }
}
