package com.java.service;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.Article;

public interface ArticleService extends BaseService<Article>{

	PageResult<Article> getArticleList(PageParam<Article> pageParam);
	
	PageResult<Article> getArticleListByUserId(PageParam<Article> pageParam,String userId);
	
	Article getArticle(String id);
	
}
