package com.studymybatis.hello.service;

import com.github.pagehelper.PageHelper;
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
  public List<User> getUsers(int pageNum, int pageSize) {
    // var list = new ArrayList<User>();
    // list.add(new User(1, "Hadley", 20));
    // list.add(new User(2, "Wang Sir", 30));

    PageHelper.startPage(pageNum, pageSize);

    var list = userMapper.queryUserList();

    return list;
  }

  // 获取用户
  public User getUserById(Integer id) {
    User user = userMapper.queryUserById(id);
    return user;
  }

  // 新增用户
  public Integer addUser(User user) {
    return userMapper.addUser(user);
  }
}
