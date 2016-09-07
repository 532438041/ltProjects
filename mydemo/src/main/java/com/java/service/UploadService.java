package com.java.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.java.common.entity.PageResult;
import com.java.entity.Image;

public interface UploadService {

	void upload(MultipartFile[] files, String destDir, HttpServletRequest request, HttpServletResponse response);

	PageResult<Image> getImageList(Integer pageNum, Integer pageSize);

}
