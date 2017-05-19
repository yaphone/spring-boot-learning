package cn.zhouyafeng.wechat.base;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class BaseConfig {

	private static String token = "yaphone";

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
		List<String> args = Arrays.asList(token, timestamp, nonce);
		Collections.sort(args);
		StringBuilder sb = new StringBuilder();
		for (String arg : args) {
			sb.append(arg);
		}
		if (DigestUtils.shaHex(sb.toString()).equals(signature)) {
			return echostr;
		}
		return echostr;

	}

	@RequestMapping("/hello/{myName}")
	String index(@PathVariable String myName) {
		return "Hello " + myName + "!!!";
	}

}
