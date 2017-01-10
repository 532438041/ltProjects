package com.java.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.dto.ArticleDto;
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

	/**
	 * 文章列表
	 * @param pageParam
	 * @return
	 */
	@RequestMapping(value = "/articleList")
	public BaseResult getArticleList(@RequestBody PageParam<ArticleDto> pageParam) {
		PageResult<ArticleDto> list = articleService.getArticleList(pageParam);
		return new BaseResult().success(list);
	}

	/**
	 * 文章列表 文章分类id
	 * @param pageParam
	 * @param cateid
	 * @return
	 */
	@RequestMapping(value = "/articleList/{cateid}")
	public BaseResult getArticleByCateIdList(@RequestBody PageParam<ArticleDto> pageParam, @PathVariable String cateid) {
		PageResult<ArticleDto> list = articleService.getArticleListByCateId(pageParam, cateid);
		return new BaseResult().success(list);
	}

	/**
	 * 文章详情 文章id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/article/{id}")
	public BaseResult getArticleById(@PathVariable String id) {
		ArticleDto article = articleService.getArticle(id);
		return new BaseResult().success(article);
	}

	/**
	 * 文章分类列表
	 * @param pageParam
	 * @return
	 */
	@RequestMapping(value = "/user/articleCate",method = RequestMethod.POST)
	public BaseResult getArticleCategoryList(@RequestBody PageParam<ArticleCategory> pageParam) {
		PageResult<ArticleCategory> list = articleCategoryService.getArticleCategoryOnceList(pageParam);
		return new BaseResult().success(list);
	}

	/**
	 * 用户发布文章
	 * @param article
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/user/articleAdd")
	public BaseResult articleAdd(@RequestBody BaseParam<Article> article, @CookieValue("userId") String userId) {
		article.getParam().setId(ToolsUtil.getUUID());
		article.getParam().setState("1");
		article.getParam().setCreateTime(new Date());
		article.getParam().setIsRecommend("0");
		article.getParam().setPublishTime(new Date());
		article.getParam().setUpdateTime(new Date());
		article.getParam().setUserId(userId);

		articleService.insert(article.getParam());
		return new BaseResult().success(1, "");
	}

	/**
	 * 用户文章列表
	 * @param pageParam
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/user/articleList")
	public BaseResult articleListByUserId(@RequestBody PageParam<ArticleDto> pageParam, @CookieValue("userId") String userId) {
		PageResult<ArticleDto> list = articleService.getArticleListByUserId(pageParam, userId);
		return new BaseResult().success(list);
	}
	/**
	 * 文章审核
	 * @param baseParam
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/article/checkArticle")
	public BaseResult checkArticle(@RequestBody BaseParam<Article> baseParam, @CookieValue("userId") String userId) {
		BaseResult baseResult = new BaseResult();
		baseParam.getParam().setCheckBy(userId);
		baseParam.getParam().setCheckTime(new Date());
		int status = articleService.updateByPrimaryKeySelective(baseParam.getParam());
		baseResult.setStatus(status);
		baseResult.setMsg(status == 0 ? "操作失败！" : "操作成功！");
		return baseResult;
	}

	@RequestMapping(value = "/article/recommendArticle")
	public BaseResult recommendArticle(String articleId) {
		Article article = new Article();
		article.setId(articleId);
		article.setIsRecommend("1");
		articleService.updateByPrimaryKeySelective(article);
		return new BaseResult().success();
	}
}
