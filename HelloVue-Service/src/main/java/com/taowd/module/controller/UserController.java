package com.taowd.module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taowd.base.RestResponseBo;
import com.taowd.module.service.IUserService;

/**
 * 前端控制器
 * @author Taoweidong
 * @since 2019-08-09
 */
@RestController
@RequestMapping("/user")
public class UserController {

	/**
	 * ITestService.
	 */
	@Autowired
	private IUserService iUserService;

	/**
	 * 查询功能
	 * @return 查询结果
	 */
	@PostMapping("/query")
	public RestResponseBo<?> query() {

		return RestResponseBo.ok(iUserService.list());
	}

}
