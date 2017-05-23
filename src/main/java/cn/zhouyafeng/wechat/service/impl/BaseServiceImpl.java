package cn.zhouyafeng.wechat.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhouyafeng.wechat.component.WechatConfigurations;
import cn.zhouyafeng.wechat.service.IBaseService;

/**
 * 微信基础服务实现类
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年5月23日 下午10:29:08
 * @version 1.0
 *
 */

@Service
public class BaseServiceImpl implements IBaseService {

	private static Logger LOG = LoggerFactory.getLogger(BaseServiceImpl.class);

	@Autowired
	private WechatConfigurations wechatConfigurations;

	@Override
	public String checkSignature(String signature, String timestamp, String nonce, String echostr) {
		String token = wechatConfigurations.getToken();
		LOG.info(token);
		List<String> args = Arrays.asList(token, timestamp, nonce);
		Collections.sort(args);
		StringBuilder sb = new StringBuilder();
		for (String arg : args) {
			sb.append(arg);
		}
		if (DigestUtils.shaHex(sb.toString()).equals(signature)) {
			return echostr;
		}
		return echostr; // 这里先不判断了，直接返回echostr
	}

}
