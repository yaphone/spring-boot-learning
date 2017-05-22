package yaphone.spring_boot_learning;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.zhouyafeng.App;
import cn.zhouyafeng.common.component.Configurations;
import cn.zhouyafeng.common.model.UserEntity;
import cn.zhouyafeng.common.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class HelloWorld {

	@Autowired
	private IUserService userService;
	@Autowired
	private Configurations configurations;

	// @Test
	public void userTest() {
		UserEntity entity = userService.getUserEntityByUsername("yaphone");
		System.out.println(JSON.toJSONString(entity));
	}

	@Test
	public void configurationTest() {
		String qrPath = configurations.getQrPath();
		System.out.println(qrPath);
	}

}
