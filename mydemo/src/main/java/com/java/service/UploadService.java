package com.java.service;

import org.springframework.web.multipart.MultipartFile;

import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.Image;

public interface UploadService {

	void upload(MultipartFile[] files, String destDir);

	PageResult<Image> getImageList(PageParam<Image> pageParam);

}
