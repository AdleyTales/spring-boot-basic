package com.studymybatis.hello.service;

import com.studymybatis.hello.mapper.UserMapper;
import com.studymybatis.hello.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  // 获取用户列表
  public List<User> getUsers() {
    // var list = new ArrayList<User>();
    // list.add(new User(1, "Hadley", 20));
    // list.add(new User(2, "Wang Sir", 30));

    var list = userMapper.queryUserList();

    return list;
  }
}
