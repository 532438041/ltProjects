/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
package com.java.common.ueditor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baidu.ueditor.PathFormat;
import com.baidu.ueditor.define.BaseState;
import com.baidu.ueditor.define.FileType;
import com.baidu.ueditor.define.State;
import com.baidu.ueditor.upload.StorageManager;

public class UEditorBinaryUploader {
	public static final State save(HttpServletRequest request, Map<String, Object> conf) {
		MultipartFile file = null;
		boolean isAjaxUpload = request.getHeader("X_Requested_With") != null;

		if (!(ServletFileUpload.isMultipartContent(request))) {
			return new BaseState(false, 5);
		}

		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());

		if (isAjaxUpload) {
			upload.setHeaderEncoding("UTF-8");
		}
		try {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator<String> iterator = multiRequest.getFileNames();

			while (iterator.hasNext()) {
				file = multiRequest.getFile(iterator.next().toString());
			}

			if (file == null) {
				return new BaseState(false, 7);
			}

			String savePath = (String) conf.get("savePath");
			String originFileName = file.getOriginalFilename();
			String suffix = FileType.getSuffixByFilename(originFileName);

			originFileName = originFileName.substring(0, originFileName.length() - suffix.length());
			savePath = savePath + suffix;

			long maxSize = ((Long) conf.get("maxSize")).longValue();

			if (!(validType(suffix, (String[]) conf.get("allowFiles")))) {
				return new BaseState(false, 8);
			}

			String physicalPath = PathFormat.parse(savePath, originFileName);
			String prefixPath = physicalPath.replace((String) conf.get("replacePrefix"), "");

			InputStream is = file.getInputStream();
			State storageState = StorageManager.saveFileByInputStream(is, physicalPath, maxSize);
			is.close();

			if (storageState.isSuccess()) {
				storageState.putInfo("url", prefixPath);
				storageState.putInfo("type", suffix);
				storageState.putInfo("original", originFileName + suffix);
			}

			return storageState;
		} catch (IOException localIOException) {

		}
		return new BaseState(false, 4);
	}

	private static boolean validType(String type, String[] allowTypes) {
		List<String> list = Arrays.asList(allowTypes);

		return list.contains(type);
	}
}