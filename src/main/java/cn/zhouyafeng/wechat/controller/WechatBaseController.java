package cn.zhouyafeng.wechat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static Logger LOG = LoggerFactory.getLogger(WechatBaseController.class);

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
	// @RequestMapping("/wechat")
	// String verification(String signature, String timestamp, String nonce,
	// String echostr) {
	// return baseService.checkSignature(signature, timestamp, nonce, echostr);
	// }
	@RequestMapping("/index")
	public String wechat(HttpServletRequest request, HttpServletResponse response) {
		if (request.getMethod().equals("GET")) { // 处理GET请求
			String signature = request.getParameter("signature");
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("echostr");
			String echostr = request.getParameter("echostr");
			return baseService.checkSignature(signature, timestamp, nonce, echostr);
		} else { // 处理POST请求
			LOG.info(request.getParameter("body"));
			return "POST";
		}
	}

	@RequestMapping("/hello/{myName}")
	String index(@PathVariable String myName) {
		return "Hello " + myName + "!!!";
	}

}
