package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.ArticleCategory;

public interface ArticleCategoryDao extends BaseDao<ArticleCategory> {
	
	public List<ArticleCategory> getArticleCategoryList();

	public List<ArticleCategory> getCateByPid(ArticleCategory reqParam);

}