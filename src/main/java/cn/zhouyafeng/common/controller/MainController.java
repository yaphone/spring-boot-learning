package cn.zhouyafeng.common.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年6月4日 上午12:12:33
 * @version 1.0
 *
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/")
public class MainController {
	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("/index");
		return modelAndView;
	}

	@RequestMapping("regist")
	public ModelAndView regist() {
		ModelAndView modelAndView = new ModelAndView("/regist");
		return modelAndView;
	}

}
