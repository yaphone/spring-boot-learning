package cn.zhouyafeng.common.service.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.zhouyafeng.common.component.Configurations;
import cn.zhouyafeng.common.model.UserEntity;
import cn.zhouyafeng.common.service.IFileService;
import cn.zhouyafeng.common.service.IUserService;

/**
 * 文件服务实现类
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年5月20日 下午11:06:08
 * @version 1.0
 *
 */
@Service
public class FileServiceImpl implements IFileService {

	@Autowired
	private Configurations configurations;
	@Autowired
	private IUserService userService;

	@Override
	public boolean saveUserQrPic(String username, String password, MultipartFile multiFile) {
		String qrPath = configurations.getQrPath();
		UserEntity user = userService.getUserEntityByUsername(username);
		if (user != null) {
			if (user.getPassword().equals(password)) { // 这里只是做一个简单的处理，比较用户名和密码一致即认为验证成功
				File localFile = new File(qrPath + File.separator + username + ".jpg"); // 以用户名作为文件名
				try {
					multiFile.transferTo(localFile); // 保存用户登陆图片到本地
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return false;
	}

}
