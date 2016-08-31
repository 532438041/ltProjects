package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.Image;

public interface ImageDao extends BaseDao<Image> {

	List<Image> getImageList();

}