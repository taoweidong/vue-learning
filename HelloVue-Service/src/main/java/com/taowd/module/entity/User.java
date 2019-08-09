package com.taowd.module.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>
 * </p>
 * @author Taoweidong
 * @since 2019-08-09
 */
@TableName("pms_user")
public class User extends Model<User> {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.UUID)
	private String id;

	private String name;

	private String sex;

	private Integer age;

	/**
	 * 生日
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 入参格式化
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 出参格式化
	private LocalDateTime birthday;

	/**
	 * 住址
	 */
	private String address;

	public String getId() {

		return id;
	}

	public void setId(String id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getSex() {

		return sex;
	}

	public void setSex(String sex) {

		this.sex = sex;
	}

	public Integer getAge() {

		return age;
	}

	public void setAge(Integer age) {

		this.age = age;
	}

	public LocalDateTime getBirthday() {

		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {

		this.birthday = birthday;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {

		this.address = address;
	}

	@Override
	protected Serializable pkVal() {

		return this.id;
	}

	@Override
	public String toString() {

		return "User{" + "id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age
				+ ", birthday=" + birthday + ", address=" + address + "}";
	}
}
