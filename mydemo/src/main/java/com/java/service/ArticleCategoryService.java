package com.java.service;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.ArticleCategory;

public interface ArticleCategoryService extends BaseService<ArticleCategory>{

	PageResult<ArticleCategory> getArticleCategoryList(PageParam<ArticleCategory> pageParam);
	
}
