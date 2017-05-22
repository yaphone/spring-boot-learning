package cn.zhouyafeng.common.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取配置文件组件
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年5月22日 下午10:03:26
 * @version 1.0
 *
 */
@ConfigurationProperties(locations = "classpath:config/base.properties", prefix = "base")
@Component
public class Configurations {
	private String name;
	private String qrPath;

	public String getQrPath() {
		return qrPath;
	}

	public void setQrPath(String qrPath) {
		this.qrPath = qrPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
