package cn.zhouyafeng.wechat.component;

import org.springframework.stereotype.Component;

/**
 * 微信信息存储，全局只保存一份
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年5月23日 下午11:35:05
 * @version 1.0
 *
 */
@Component
public class WechatInfoStorage {
	private String accessToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
