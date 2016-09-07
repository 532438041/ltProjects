package com.java.service.impl;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.java.common.entity.ImageFileConfig;
import com.java.common.entity.PageResult;
import com.java.dao.ImageDao;
import com.java.entity.Image;
import com.java.service.UploadService;
import com.java.utils.PageUtil;
import com.java.utils.ToolsUtil;

import cn.jiguang.commom.utils.StringUtils;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	private ImageDao imageDao;

	@Override
	public void upload(MultipartFile[] files, String destDir, HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		String url = "";
		String userId = "1";

		// 图片空间 分组管理
		if (StringUtils.isNotEmpty(userId)) {
			path = ImageFileConfig.uploadFilePath + "/" + userId;
			url = ImageFileConfig.imagePrefix + "/" + userId;
		} else {
			path = ImageFileConfig.uploadFilePath;
			url = ImageFileConfig.imagePrefix;
		}

		// 获取文件上传的真实路径
		try {
			String[] fileNames = new String[files.length];
			int index = 0;
			// 上传文件过程
			for (MultipartFile file : files) {
				String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
				int length = ImageFileConfig.allowSuffix.indexOf(suffix);
				if (length == -1) {
					return;
				}
				File destFile = new File(path);
				if (!destFile.exists()) {
					destFile.mkdirs();
				}
				String fileIdNew = ToolsUtil.getUUID();
				String fileNameNew = fileIdNew + "." + suffix;
				url += "/" + fileNameNew;
				File f = new File(destFile.getAbsoluteFile() + File.separator + fileNameNew);
				if (f.exists()) {
					continue;
				}
				file.transferTo(f);
				f.createNewFile();
				fileNames[index++] = destDir + fileNameNew;

				Image image = new Image();
				image.setId(ToolsUtil.getUUID());
				image.setImgName(file.getOriginalFilename());
				image.setImgUrl(url);
				image.setUserId("1");
				image.setCreateBy("1");
				image.setCreateTime(new Date());
				image.setUpdateBy("1");
				image.setUpdateTime(new Date());
				imageDao.insert(image);
			}
		} catch (Exception ex) {
			
		}
	}

	@Override
	public PageResult<Image> getImageList(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return PageUtil.toPagedResult(imageDao.getImageList());
	}

}
