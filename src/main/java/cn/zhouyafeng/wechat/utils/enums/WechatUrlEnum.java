package cn.zhouyafeng.wechat.utils.enums;

/**
 * 微信URL枚举类
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年5月23日 下午10:59:38
 * @version 1.0
 *
 */
public enum WechatUrlEnum {

	ACCESS_TOKEN("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",
			"获取access_toke");

	private String url;
	private String desc;

	WechatUrlEnum(String url, String desc) {
		this.url = url;
		this.desc = desc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
