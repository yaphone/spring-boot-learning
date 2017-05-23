package cn.zhouyafeng.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zhouyafeng.wechat.service.IBaseService;

/**
 * 微信基本配置
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年5月19日 下午11:49:29
 * @version 1.0
 *
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/wechat")
public class WechatBaseController {

	@Autowired
	private IBaseService baseService;

	@RequestMapping("/test")
	String home() {
		return "test";
	}

	/**
	 * 微信认证 1）将token、timestamp、nonce三个参数进行字典序排序 2）将三个参数字符串拼接成一个字符串进行sha1加密
	 * 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
	 * 
	 * @author https://github.com/yaphone
	 * @date 2017年5月20日 上午12:04:24
	 * @return
	 */
	@RequestMapping("/wechat/verification")
	String verification(String signature, String timestamp, String nonce, String echostr) {
		return baseService.checkSignature(signature, timestamp, nonce, echostr);
	}

	@RequestMapping("/hello/{myName}")
	String index(@PathVariable String myName) {
		return "Hello " + myName + "!!!";
	}

}
