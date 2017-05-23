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
	private String appid;
	private String appsecret;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
