package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.ImageDao;
import com.java.entity.Image;

@Repository
public class ImageDaoImpl extends BaseDaoImpl<Image>implements ImageDao {

	@Override
	public List<Image> getImageList() {
		return this.getSqlSession().selectList(getStateMentName("getImageList"));
	}

}
