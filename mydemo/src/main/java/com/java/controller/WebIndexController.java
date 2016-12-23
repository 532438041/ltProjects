package com.java.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseResult;

@RestController
public class WebIndexController {
	
	@RequestMapping(value = "/index")
	public BaseResult getWebIndex() {
		return new BaseResult().success();
	}

}
