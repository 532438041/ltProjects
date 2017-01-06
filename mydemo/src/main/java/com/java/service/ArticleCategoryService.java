package com.java.service;

import java.util.List;

import com.java.base.BaseService;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.ArticleCategory;

public interface ArticleCategoryService extends BaseService<ArticleCategory>{

	PageResult<ArticleCategory> getArticleCategoryList(PageParam<ArticleCategory> pageParam);
	
	PageResult<ArticleCategory> getArticleCategoryOnceList(PageParam<ArticleCategory> pageParam);

	List<ArticleCategory> getArticleCategoryList();

	PageResult<ArticleCategory> getCateByPid(PageParam<ArticleCategory> pageParam);
	
}
