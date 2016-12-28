package com.java.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.Image;

public interface UploadService {

	Map<String, Object> uploadImg(MultipartFile[] files);

	PageResult<Image> getImageList(PageParam<Image> pageParam);

}
