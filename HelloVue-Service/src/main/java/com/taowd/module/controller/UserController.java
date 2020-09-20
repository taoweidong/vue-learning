package com.taowd.module.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.taowd.module.entity.User;
import com.taowd.module.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.taowd.base.RestResponseBo;
import com.taowd.module.service.IUserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 前端控制器
 *
 * @author Taoweidong
 * @since 2019-08-16
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

  /**
   * ITestService.
   */
  @Autowired
  private IUserService iUserService;

  /**
   * ITestService.
   */
  @Autowired
  private UserMapper userMapper;

  /**
   * 查询功能
   *
   * @return 查询结果
   */
  @PostMapping("/query")
  public RestResponseBo<?> query(int pageNumber, int pageSize, String name) {
    IPage<User> page = new Page<>(pageNumber, pageSize);
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.like("name", name);

    page = userMapper.selectPage(page, queryWrapper);
    return RestResponseBo.ok(page);
  }


  /**
   * 查询功能
   *
   * @return 查询结果
   */
  @PostMapping("/update")
  public RestResponseBo<?> update(@RequestBody Map<String, Object> map) {
    List<User> users = JSON.parseArray(JSON.toJSONString(map.getOrDefault("selectionInfo", "[]")), User.class);
    String status = map.getOrDefault("status", "").toString();
    String remark = map.getOrDefault("remark", "").toString();
    users.stream().forEach(x -> {
      x.setStatus(status);
      x.setRemark(remark);
      x.setUpdateTime(LocalDateTime.now());
      userMapper.updateById(x);
    });
    return RestResponseBo.ok(0);
  }

}
