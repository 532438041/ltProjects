package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.entity.Log;
import com.java.service.LogService;

@RestController
@RequestMapping(value = "/log")
public class LogController {

	@Autowired
	private LogService logService;

	@RequestMapping(value = "/getLogList")
	public BaseResult getLogList(@RequestBody PageParam<Log> pageParam) {
		return new BaseResult().success(logService.getLogList(pageParam));
	}

	@RequestMapping(value = "/getLogById")
	public BaseResult getLogById(String logId) {
		return new BaseResult().success(logService.selectByPrimaryKey(logId));
	}

}
