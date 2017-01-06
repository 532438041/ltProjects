package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.base.impl.BaseServiceImpl;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dao.ArticleDao;
import com.java.dto.ArticleDto;
import com.java.entity.Article;
import com.java.service.ArticleService;
import com.java.utils.PageUtil;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article>implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Override
	public PageResult<ArticleDto> getArticleList(PageParam<ArticleDto> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(articleDao.getArticList(pageParam.getReqParam()));
	}
	
	@Override
	public PageResult<ArticleDto> getArticleListByCateId(PageParam<ArticleDto> pageParam,String cateid) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(articleDao.getArticListByCateId(cateid));
	}

	@Override
	public PageResult<ArticleDto> getArticleListByUserId(PageParam<ArticleDto> pageParam, String userId) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(articleDao.getArticListByUserId(userId));
	}

	@Override
	public ArticleDto getArticle(String id) {
		return articleDao.getArticle(id);
	}
}
