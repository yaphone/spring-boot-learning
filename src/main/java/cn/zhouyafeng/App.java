package cn.zhouyafeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

@SpringBootApplication
@MapperScan("cn.zhouyfeng.common.mapper")
public class App implements EmbeddedServletContainerCustomizer {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	/**
	 * 设置80端口
	 */
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(80);
	}
}
