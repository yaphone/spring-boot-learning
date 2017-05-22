package cn.zhouyafeng.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.zhouyafeng.common.model.UserEntity;
import cn.zhouyafeng.common.service.IUserService;

/**
 * 用户控制器
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年5月22日 上午12:58:37
 * @version 1.0
 *
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	String test(String username) {
		UserEntity user = userService.getUserEntityByUsername(username);
		System.out.println(user.getUsername() + "--" + user.getPassword());
		return user.getUsername() + "--" + user.getPassword();
	}

}
