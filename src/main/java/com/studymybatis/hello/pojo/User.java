package com.studymybatis.hello.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"id"}) // 实体中属性不返回给前端
public class User {
  private Integer id;
  private String name;
  private Integer age;
}
