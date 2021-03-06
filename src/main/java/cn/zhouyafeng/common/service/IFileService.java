package cn.zhouyafeng.common.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务接口
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年5月20日 下午10:59:51
 * @version 1.0
 *
 */
public interface IFileService {
	public boolean saveUserQrPic(String username, String password, MultipartFile multiFile);
}
