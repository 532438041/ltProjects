package com.java.dao.impl;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.ArticleDao;
import com.java.entity.Article;

@Repository
public class ArticleDaoImpl extends BaseDaoImpl<Article>implements ArticleDao {

}
