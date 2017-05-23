package cn.zhouyafeng.wechat.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.zhouyafeng.wechat.utils.enums.WechatUrlEnum;
import okhttp3.Response;

/**
 * 定时任务
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年5月23日 下午11:29:20
 * @version 1.0
 *
 */
@EnableScheduling
@Component
public class WechatScheduleTask {

	private static Logger LOG = LoggerFactory.getLogger(WechatScheduleTask.class);

	@Autowired
	private WechatInfoStorage wechatInfoStorage;
	@Autowired
	private WechatConfigurations wechatConfigurations;
	@Autowired
	private MyOkHttpClient myOkHttpClient;

	/**
	 * 每100分钟定时更新access_token
	 * 
	 * @date 2017年5月23日 下午11:31:48
	 */
	// @Scheduled(cron = "40 */1 * * * ?") // 每100分钟执行一次
	@Scheduled(cron = "0/5 * * * * ?") // 每100分钟执行一次
	public void accessTokenScheduler() {
		String appId = wechatConfigurations.getAppid();
		String appSecret = wechatConfigurations.getAppsecret();
		String url = String.format(WechatUrlEnum.ACCESS_TOKEN.getUrl(), appId, appSecret);
		Response response = myOkHttpClient.doGet(url, null);
	}

}
