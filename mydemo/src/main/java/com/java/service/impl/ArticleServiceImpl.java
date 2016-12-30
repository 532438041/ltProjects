package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.base.impl.BaseServiceImpl;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dao.ArticleDao;
import com.java.entity.Article;
import com.java.service.ArticleService;
import com.java.utils.PageUtil;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article>implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Override
	public PageResult<Article> getArticleList(PageParam<Article> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(articleDao.getArticList());
	}
	
	@Override
	public PageResult<Article> getArticleListByUserId(PageParam<Article> pageParam,String userId){
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(articleDao.getArticListByUserId(userId));
	}

	@Override
	public Article getArticle(String id) {
		return articleDao.getArticle(id);
	}
}
