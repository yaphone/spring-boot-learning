package cn.zhouyafeng.wechat.service;

/**
 * 微信基础服务接口
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年5月23日 下午10:27:18
 * @version 1.0
 *
 */
public interface IBaseService {

	/**
	 * 接入验证
	 * 
	 * @date 2017年5月23日 下午10:44:29
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	public String checkSignature(String signature, String timestamp, String nonce, String echostr);

}
