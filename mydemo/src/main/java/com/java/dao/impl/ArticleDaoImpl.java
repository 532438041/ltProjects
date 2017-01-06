package com.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.ArticleDao;
import com.java.dto.ArticleDto;
import com.java.entity.Article;

@Repository
public class ArticleDaoImpl extends BaseDaoImpl<Article>implements ArticleDao {
	@Override
	public List<ArticleDto> getArticList(ArticleDto articleDto) {
		return this.getSqlSession().selectList(getStateMentName("getArticleList"), articleDto);
	}

	@Override
	public ArticleDto getArticle(String id) {
		return this.getSqlSession().selectOne(getStateMentName("getArticleById"), id);
	}

	@Override
	public List<ArticleDto> getArticListByUserId(String userId) {
		return this.getSqlSession().selectList(getStateMentName("getArticleListByUserId"), userId);
	}

	@Override
	public List<ArticleDto> getArticListByCateId(String cateid) {
		return this.getSqlSession().selectList(getStateMentName("getArticleListByCateId"), cateid);
	}
}
