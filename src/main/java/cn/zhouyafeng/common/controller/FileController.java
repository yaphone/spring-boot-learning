package cn.zhouyafeng.common.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@EnableAutoConfiguration
@RequestMapping("/file")
public class FileController {
	private static String filePath = "D://itchat4j/test";
	private static int BUFFER_SIZE = 8192;

	@RequestMapping(value = "/put", method = RequestMethod.PUT)
	@ResponseBody
	String test(MultipartFile multipartFile) {
		System.out.println(multipartFile.getName());
		System.out.println(multipartFile.getSize());
		return "OK";
	}

}
