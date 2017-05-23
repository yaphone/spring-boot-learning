package yaphone.spring_boot_learning.wechat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.zhouyafeng.App;
import cn.zhouyafeng.wechat.service.IBaseService;

/**
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年5月23日 下午11:20:11
 * @version 1.0
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class WechatTest {

	@Autowired
	private IBaseService baseService;

	@Test
	public void test1() {
		String echostr = baseService.checkSignature("1", "1", "1", "1");
		System.out.println(echostr);
	}

}
