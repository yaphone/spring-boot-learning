package cn.zhouyafeng.wechat.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信配置信息
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年5月23日 下午11:09:53
 * @version 1.0
 *
 */
@ConfigurationProperties(locations = "classpath:config/wechat.properties", prefix = "wechat")
@Component
public class WechatConfigurations {
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
