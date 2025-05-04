package com.ai.api.object.dto;

import cn.xbatis.page.IPager;
import cn.xbatis.page.PagerField;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/** 分页基类 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
public class Page<T> implements IPager<T>, Serializable {

  /** 数据集合 */
  private List<T> results;

  /** 数据总数 */
  private Integer total;

  /** 分页size */
  private Integer size;

  /** 当前页码 */
  private Integer current;

  public Page() {
    results = Collections.emptyList();
    total = 0;
    size = 0;
    current = 0;
  }

  public Page(int current, int size) {
    this(current, size, 0);
  }

  public Page(int current, int size, int total) {
    this(current, size, total, null);
  }

  public Page(int current, int size, int total, List<T> records) {
    this(current, size, total, records, false);
  }

  public Page(int current, int size, int total, List<T> results, Boolean executeCount) {
    setCurrent(current).setSize(size).setTotal(total).setResults(results);
  }

  @Override
  public <V> V get(PagerField<V> field) {
    if (PagerField.IS_EXECUTE_COUNT == field) {
      // 兼容 boolean 和 Boolean 类型
      if (!boolean.class.equals(field.getType()) && !Boolean.class.equals(field.getType())) {
        throw new RuntimeException("not support field: " + field);
      }
      return (V) Boolean.TRUE;
    }
    if (PagerField.NUMBER == field) {
      return (V) current;
    }
    if (PagerField.SIZE == field) {
      return (V) size;
    }
    throw new RuntimeException("not support field: " + field);
  }

  @Override
  public <V> void set(PagerField<V> field, V value) {
    if (PagerField.TOTAL == field) {
      // 设置总条数
      this.setTotal((Integer) value);
      return;
    }
    if (PagerField.RESULTS == field) {
      // 设置List结果
      this.setResults((List) value);
      return;
    }
    throw new RuntimeException("not support field: " + field);
  }
}
