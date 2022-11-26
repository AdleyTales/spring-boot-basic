package com.studymybatis.hello.controller;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.studymybatis.hello.controller.vo.UserVo;
import com.studymybatis.hello.pojo.User;
import com.studymybatis.hello.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class Hello {
  private static final Logger logger = LoggerFactory.getLogger(Hello.class);

  @Autowired
  private UserService userService;

  @GetMapping("/hello")
  public String hello() {
    return "hello springBoot";
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    var list =  userService.getUsers();
    System.out.println(list);
    logger.info("user list: {} !",  list);

    return list;
  }
}
