package com.java.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error")
public class ExceptionController {

	private static Logger logger = Logger.getLogger(ExceptionController.class);

	@RequestMapping(value = "/404")
	public ModelAndView e404(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		logger.error("Catch Exception: ", ex);// 把漏网的异常信息记入日志
		return new ModelAndView("/error/404");
	}

	@RequestMapping(value = "/500")
	public ModelAndView e500(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		logger.error("Catch Exception: ", ex);// 把漏网的异常信息记入日志
		return new ModelAndView("/error/500");
	}
}