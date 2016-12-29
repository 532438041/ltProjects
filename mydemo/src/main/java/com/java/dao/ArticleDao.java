package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.Article;

public interface ArticleDao extends BaseDao<Article>{
	public List<Article> getArticList();
	
	public Article getArticle(String id);
}