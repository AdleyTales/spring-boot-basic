package com.studymybatis.hello.controller;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.studymybatis.hello.controller.vo.UserVo;
import com.studymybatis.hello.pojo.User;
import com.studymybatis.hello.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
  public List<User> getUsers(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
    var list = userService.getUsers(pageNum, pageSize);
    System.out.println(list);
    logger.info("user list: {} !", list);

    return list;
  }

  @GetMapping("/user")
  public User getUserById(@RequestParam(value = "id") Integer id) {
    return userService.getUserById(id);
  }

  @PostMapping("/addUser")
  public Integer addUser(@RequestBody User user) {
    logger.info("新增用户，收到客户端参数: {} !", user);
    return userService.addUser(user);
  }
}
