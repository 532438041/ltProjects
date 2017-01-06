package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.ArticleCategoryDao;
import com.java.entity.ArticleCategory;

@Repository
public class ArticleCategoryDaoImpl extends BaseDaoImpl<ArticleCategory>implements ArticleCategoryDao {
	@Override
	public List<ArticleCategory> getArticleCategoryList() {
		return this.getSqlSession().selectList(getStateMentName("getArticleCategoryList"));
	}

	@Override
	public List<ArticleCategory> getCateByPid(ArticleCategory reqParam) {
		return this.getSqlSession().selectList(getStateMentName("getCateByPid"), reqParam);
	}
}
