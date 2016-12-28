package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.ArticleDao;
import com.java.entity.Article;

@Repository
public class ArticleDaoImpl extends BaseDaoImpl<Article>implements ArticleDao {
	@Override
	public List<Article> getArticList() {
		return this.getSqlSession().selectList(getStateMentName("getArticleList"));
	}
}
