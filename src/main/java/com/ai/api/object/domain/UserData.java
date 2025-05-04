package com.ai.api.object.domain;

import cn.xbatis.core.incrementer.IdentifierGeneratorType;
import cn.xbatis.db.IdAutoType;
import cn.xbatis.db.annotations.Table;
import cn.xbatis.db.annotations.TableField;
import cn.xbatis.db.annotations.TableId;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/** 业务 - 用户数据 */
@Table(value = "b_user_data")
@Data
public class UserData implements Serializable {
  /** ID */
  @TableId(value = IdAutoType.GENERATOR, generatorName = IdentifierGeneratorType.DEFAULT)
  private String id;

  /** 链接 */
  @TableField(value = "url")
  private String url;

  /** md5 */
  @TableField(value = "md5")
  private String md5;

  /** 姓名 */
  @TableField(value = "name")
  private String name;

  /** 性别 */
  @TableField(value = "gender")
  private String gender;

  /** 出生日期 */
  @TableField(value = "born")
  private String born;

  /** 年龄 */
  @TableField(value = "age")
  private Integer age;

  /** 手机号 */
  @TableField(value = "phone")
  private String phone;

  /** 邮箱 */
  @TableField(value = "email")
  private String email;

  /** 居住时间 */
  @TableField(value = "residence_time")
  private String residenceTime;

  /** 邮编 */
  @TableField(value = "zip_code")
  private String zipCode;

  /** 州 */
  @TableField(value = "state")
  private String state;

  /** 城市 */
  @TableField(value = "city")
  private String city;

  /** 地址 */
  @TableField(value = "address")
  private String address;

  /** 房屋面积 */
  @TableField(value = "square_foot")
  private String squareFoot;

  /** 建筑时间 */
  @TableField(value = "built")
  private String built;

  /** 估值 */
  @TableField(value = "estimated_value")
  private String estimatedValue;

  /** 状态：0：未采集；1：已采集 */
  @TableField(value = "`status`", defaultValue = "0")
  private Integer status;

  /** 创建时间 */
  @TableField(value = "create_time", defaultValue = "{NOW}")
  private LocalDateTime createTime;

  /** 更新时间 */
  @TableField(value = "update_time", defaultValue = "{NOW}", updateDefaultValue = "{NOW}")
  private LocalDateTime updateTime;

  @Serial private static final long serialVersionUID = 1L;
}
