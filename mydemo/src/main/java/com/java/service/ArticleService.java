package com.java.service;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.Article;

public interface ArticleService extends BaseService<Article>{

	PageResult<Article> getArticleList(PageParam<Article> pageParam);
}
