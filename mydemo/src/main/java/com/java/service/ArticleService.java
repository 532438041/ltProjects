package com.java.service;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dto.ArticleDto;
import com.java.entity.Article;

public interface ArticleService extends BaseService<Article>{

	PageResult<ArticleDto> getArticleList(PageParam<ArticleDto> pageParam);
	
	PageResult<ArticleDto> getArticleListByCateId(PageParam<ArticleDto> pageParam,String cateid);
	
	PageResult<ArticleDto> getArticleListByUserId(PageParam<ArticleDto> pageParam,String userId);
	
	ArticleDto getArticle(String id);
	
}
