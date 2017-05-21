package cn.zhouyafeng.common.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@EnableAutoConfiguration
@RequestMapping("/file")
public class FileController {

	private static String filePath = "D://itchat4j/test";

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
	String uploadFile(@RequestParam("userName") String userName, String password,
			@RequestParam("file") MultipartFile multiFile) throws IOException {
		File localFile = new File(filePath + File.separator + userName + ".jpg");
		multiFile.transferTo(localFile);
		return "OK";
	}

}
