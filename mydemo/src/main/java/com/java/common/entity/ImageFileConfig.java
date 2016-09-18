package com.java.common.entity;

/**
 * File 基础配置类.
 *
 * @author luolin
 */
public class ImageFileConfig {

	public static final String allowSuffix = "jpg,png,gif,jpeg";

	/** The Constant uploadFilePath. */
	public static final String uploadFilePath = "E:/Service/Tomcat/apache-tomcat-7.0.69/webapps/mydemo/static/upload/images";

	/** The Constant maxUploadSize. */
	public static final long maxUploadSize = 4194304;

	/** The Constant imagePrefix. */
	public static final String imagePrefix = "/static/upload/images";

	/** The Constant imageServer. */
	public static final String imageServer = "http://localhost/";

	/** The Constant imageCatalog. */
	public static final String imageCatalog = "img";

	/** The Constant height. */
	public static final int height = 768;

	/** The width. */
	public final int width = 1024;

	/** The watermark image. */
	public final String watermarkImage = "watermarkImage.png";

}
