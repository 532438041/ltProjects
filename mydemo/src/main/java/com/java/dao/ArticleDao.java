package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.dto.ArticleDto;
import com.java.entity.Article;

public interface ArticleDao extends BaseDao<Article>{
	public List<ArticleDto> getArticList(ArticleDto articleDto);
	
	public List<ArticleDto> getArticListByCateId(String cateid);
	
	public List<ArticleDto> getArticListByUserId(String userId);
	
	public ArticleDto getArticle(String id);
}