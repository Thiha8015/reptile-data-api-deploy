package com.ai.api.object.dto;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 结果 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** 状态码 */
  private Integer code;

  /** 提示信息 */
  private String message;

  /** 具体内容 */
  private T data;

  /**
   * 成功
   *
   * @return 结果
   * @param <T> 具体内容类型
   */
  public static <T> Result<T> success() {
    return success(null);
  }

  /**
   * 成功
   *
   * @param data 具体内容
   * @return 结果
   * @param <T> 具体内容类型
   */
  public static <T> Result<T> success(T data) {
    Result<T> result = new Result<>();
    result.setCode(200);
    result.setMessage("success");
    result.setData(data);
    return result;
  }

  /**
   * 失败
   *
   * @param code 状态码
   * @return 结果
   * @param <T> 具体内容类型
   */
  public static <T> Result<T> error(Integer code) {
    return error(code, "error");
  }

  /**
   * 失败
   *
   * @param message 提示信息
   * @return 结果
   * @param <T> 具体内容类型
   */
  public static <T> Result<T> error(String message) {
    return error(500, message);
  }

  /**
   * 失败
   *
   * @param code 状态码
   * @param message 提示信息
   * @return 结果
   * @param <T> 具体内容类型
   */
  public static <T> Result<T> error(Integer code, String message) {
    Result<T> result = new Result<>();
    result.setCode(code);
    result.setMessage(message);
    return result;
  }
}
