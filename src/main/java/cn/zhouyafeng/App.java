package cn.zhouyafeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

@SpringBootApplication
public class App implements EmbeddedServletContainerCustomizer {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	/**
	 * 设置443端口
	 */
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(80);
	}
}
