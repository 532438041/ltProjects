package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.base.impl.BaseServiceImpl;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dao.ArticleCategoryDao;
import com.java.entity.ArticleCategory;
import com.java.service.ArticleCategoryService;
import com.java.utils.PageUtil;

@Service
public class ArticleCategoryServiceImpl extends BaseServiceImpl<ArticleCategory>implements ArticleCategoryService {

	@Autowired
	private ArticleCategoryDao articleCateDao;

	@Override
	public PageResult<ArticleCategory> getArticleCategoryList(PageParam<ArticleCategory> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(articleCateDao.getArticleCategoryList());
	}

	@Override
	public List<ArticleCategory> getArticleCategoryList() {
		return articleCateDao.getArticleCategoryList();
	}

	@Override
	public PageResult<ArticleCategory> getCateByPid(PageParam<ArticleCategory> pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return PageUtil.toPagedResult(articleCateDao.getCateByPid(pageParam.getReqParam()));
	}
}
