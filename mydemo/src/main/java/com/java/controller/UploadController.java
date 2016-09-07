package com.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.common.entity.PageResult;
import com.java.entity.Image;
import com.java.service.UploadService;

import net.sf.json.JSONObject;

@Controller
public class UploadController {

	@Autowired
	private UploadService uploadService;

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload() {
		return "upload/uploadFile";
	}

	@RequestMapping(value = "/image/getImageList")
	@ResponseBody
	public String getImageList(Integer pageNum, Integer pageSize) {
		PageResult<Image> list = uploadService.getImageList(pageNum, pageSize);
		return JSONObject.fromObject(list).toString();
	}

	@RequestMapping(value = "/uploadFile")
	@ResponseBody
	public void upload(@RequestParam("file") MultipartFile[] files, String destDir, HttpServletRequest request, HttpServletResponse response) {
		uploadService.upload(files, destDir, request, response);
	}

}
