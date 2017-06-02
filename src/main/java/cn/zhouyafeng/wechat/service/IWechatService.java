package cn.zhouyafeng.wechat.service;

import javax.servlet.http.HttpServletRequest;

/**
 * wechat服务接口
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年6月2日 下午10:11:12
 * @version 1.0
 *
 */
public interface IWechatService {
	public String postHandler(HttpServletRequest request);
}
