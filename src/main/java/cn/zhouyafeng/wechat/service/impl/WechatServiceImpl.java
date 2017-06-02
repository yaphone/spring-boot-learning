package cn.zhouyafeng.wechat.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.zhouyafeng.wechat.service.IWechatService;
import cn.zhouyafeng.wechat.utils.MessageUtil;
import cn.zhouyafeng.wechat.utils.TextMessage;

/**
 * wechat服务实现类
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年6月2日 下午10:11:34
 * @version 1.0
 *
 */
@Service
public class WechatServiceImpl implements IWechatService {
	private static final Logger LOG = LoggerFactory.getLogger(WechatServiceImpl.class);

	@Override
	public String postHandler(HttpServletRequest request) {
		String respMessage = null;
		try {
			Map<String, String> requestMap = MessageUtil.xmlToMap(request);
			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			// 消息内容
			String content = requestMap.get("Content");

			// LOG.info("FromUserName is:" + fromUserName + ", ToUserName is:" +
			// toUserName + ", MsgType is:" + msgType
			// + ", Content is: " + content);

			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				if (content.equals("xxx")) {

				}

				// 自动回复
				TextMessage text = new TextMessage();
				text.setContent("the text is" + content);
				text.setToUserName(fromUserName);
				text.setFromUserName(toUserName);
				text.setCreateTime(new Date().getTime() + "");
				text.setMsgType(msgType);

				respMessage = MessageUtil.textMessageToXml(text);
				LOG.info(respMessage);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respMessage;
	}

}
