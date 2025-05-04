package com.ai.api.object.vo;

import cn.idev.excel.annotation.ExcelProperty;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/** 业务 - 用户数据 */
@Data
public class UserDataVo implements Serializable {

  /** 链接 */
  @ExcelProperty(value = "链接", index = 0)
  private String url;

  /** 姓名 */
  @ExcelProperty(value = "姓名", index = 1)
  private String name;

  /** 性别 */
  @ExcelProperty(value = "性别", index = 2)
  private String gender;

  /** 出生日期 */
  @ExcelProperty(value = "出生日期", index = 3)
  private String born;

  /** 年龄 */
  @ExcelProperty(value = "年龄", index = 4)
  private Integer age;

  /** 手机号 */
  @ExcelProperty(value = "手机号", index = 5)
  private String phone;

  /** 邮箱 */
  @ExcelProperty(value = "邮箱", index = 6)
  private String email;

  /** 居住时间 */
  @ExcelProperty(value = "居住时间", index = 7)
  private String residenceTime;

  /** 邮编 */
  @ExcelProperty(value = "邮编", index = 8)
  private String zipCode;

  /** 州 */
  @ExcelProperty(value = "州", index = 9)
  private String state;

  /** 城市 */
  @ExcelProperty(value = "城市", index = 10)
  private String city;

  /** 地址 */
  @ExcelProperty(value = "地址", index = 11)
  private String address;

  /** 房屋面积 */
  @ExcelProperty(value = "房屋面积", index = 12)
  private String squareFoot;

  /** 建筑时间 */
  @ExcelProperty(value = "建筑时间", index = 13)
  private String built;

  /** 估值 */
  @ExcelProperty(value = "估值", index = 14)
  private String estimatedValue;

  @Serial private static final long serialVersionUID = 1L;
}
