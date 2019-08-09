package com.taowd.module.controller;

import com.github.javafaker.Faker;
import com.taowd.base.RestResponseBo;
import com.taowd.module.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.taowd.module.service.IUserService;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

/**
 * 前端控制器
 * @author Taoweidong
 * @since 2019-08-09
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private static final Faker FAKER = new Faker(Locale.CHINA);

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

		List<User> userList = iUserService.list(null);

		userList.forEach(x -> {
			x.setId(UUID.randomUUID().toString().toUpperCase());
			x.setAddress(FAKER.address().fullAddress());
			x.setBirthday(FAKER.date().birthday(15, 50).toInstant().atZone(ZoneId.systemDefault())
					.toLocalDateTime());
			x.setName(FAKER.name().fullName());
			x.setSex(FAKER.random().nextInt(1, 2).toString());
		});

		System.out.println(userList);

		iUserService.saveOrUpdateBatch(userList);

		return RestResponseBo.ok(iUserService.list(null));
	}

}
