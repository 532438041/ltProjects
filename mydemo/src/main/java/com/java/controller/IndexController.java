package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.common.entity.PageResult;
import com.java.entity.Article;
import com.java.service.ArticleService;

@RestController
public class IndexController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "/articleList")
	public BaseResult getUserList(@RequestBody PageParam<Article> pageParam) {
		PageResult<Article> list = articleService.getArticleList(pageParam);
		return new BaseResult().success(list);
	}
}
