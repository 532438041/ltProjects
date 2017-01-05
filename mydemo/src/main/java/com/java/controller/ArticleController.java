package com.java.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.Article;
import com.java.entity.ArticleCategory;
import com.java.service.ArticleCategoryService;
import com.java.service.ArticleService;
import com.java.utils.ToolsUtil;

//文章
@RestController
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleCategoryService articleCategoryService;

	//文章列表
	@RequestMapping(value = "/articleList")
	public BaseResult getArticleList(@RequestBody PageParam<Article> pageParam) {
		PageResult<Article> list = articleService.getArticleList(pageParam);
		return new BaseResult().success(list);
	}
	//文章列表  文章分类id
	@RequestMapping(value = "/articleList/{cateid}")
	public BaseResult getArticleByCateIdList(@PathVariable String cateid) {
		Article article = articleService.getArticle(cateid);
		return new BaseResult().success(article);
	}
	//文章详情 文章id
	@RequestMapping(value = "/article/{id}")
	public BaseResult getArticleById(@PathVariable String id) {
		Article article = articleService.getArticle(id);
		return new BaseResult().success(article);
	}
	//文章分类列表
	@RequestMapping(value = "/user/articleCate")
	public BaseResult getArticleCategoryList(@RequestBody PageParam<ArticleCategory> pageParam) {
		PageResult<ArticleCategory> list  = articleCategoryService.getArticleCategoryList(pageParam);
		return new BaseResult().success(list);
	}
	
	//用户发布文章
	@RequestMapping(value = "/user/articleAdd")
	public BaseResult articleAdd(@RequestBody BaseParam<Article> article,@CookieValue("userId") String userId) {
		article.getParam().setId(ToolsUtil.getUUID());
		article.getParam().setState("1");
		article.getParam().setCreateTime(new Date());
		article.getParam().setIsRecommend("0");
		article.getParam().setPublishTime(new Date());
		article.getParam().setUpdateTime(new Date());
		article.getParam().setUserId(userId);
		
		articleService.insert(article.getParam());
		return new BaseResult().success(1,"");
	}
	//用户文章列表
	@RequestMapping(value = "/user/articleList")
	public BaseResult articleListByUserId(@RequestBody PageParam<Article> pageParam, @CookieValue("userId") String userId) {
		PageResult<Article> list = articleService.getArticleListByUserId(pageParam, userId);
		return new BaseResult().success(list);
	}
}
