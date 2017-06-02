package cn.zhouyafeng.common.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.zhouyafeng.common.service.IFileService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/file")
public class FileController {

	@Autowired
	private IFileService fileService;

	/**
	 * 上传文件
	 * 
	 * @date 2017年5月22日 上午12:24:05
	 * @param userName
	 * @param password
	 * @param multiFile
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/put", method = RequestMethod.POST)
	@ResponseBody
	String uploadFile(String username, String password, @RequestParam("file") MultipartFile multiFile)
			throws IOException {
		boolean res = fileService.saveUserQrPic(username, password, multiFile);
		if (res) {
			return "OK";
		}
		return "ERROR";
	}
}
