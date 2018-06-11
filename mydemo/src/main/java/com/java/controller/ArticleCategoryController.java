package com.java.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.annotation.SysLog;
import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.entity.ArticleCategory;
import com.java.service.ArticleCategoryService;
import com.java.utils.ToolsUtil;

@RestController
@RequestMapping(value = "/cate")
public class ArticleCategoryController {

	@Autowired
	private ArticleCategoryService articleCategoryService;

	@RequestMapping(value = "/getCateTree")
	public BaseResult getCateTree() {
		BaseResult baseResult = new BaseResult();
		baseResult.setData(articleCategoryService.getArticleCategoryList());
		return baseResult.success();
	}

	@RequestMapping(value = "/getCateByPid")
	public BaseResult getCateByPid(@RequestBody PageParam<ArticleCategory> pageParam) {
		if (ToolsUtil.isNull(pageParam.getReqParam().getPid()))
			pageParam.getReqParam().setPid("0");
		BaseResult baseResult = new BaseResult();
		baseResult.setData(articleCategoryService.getCateByPid(pageParam));
		return baseResult;
	}

	@RequestMapping(value = "/saveCate")
	@SysLog(operationType = "add/update", operationName = "添加、编辑文章分类")
	public BaseResult saveCate(@RequestBody BaseParam<ArticleCategory> baseParam, @CookieValue("userId") String userId) {
		baseParam.getParam().setUpdateBy(userId);
		baseParam.getParam().setUpdateTime(new Date());
		BaseResult baseResult = new BaseResult();
		int status = 0;
		if (ToolsUtil.isNotNull(baseParam.getParam().getId())) {
			// 编辑
			status = articleCategoryService.updateByPrimaryKeySelective(baseParam.getParam());
		} else {
			// 添加
			baseParam.getParam().setId(ToolsUtil.getUUID());
			baseParam.getParam().setState("1");
			baseParam.getParam().setCreateBy(userId);
			baseParam.getParam().setCreateTime(new Date());
			status = articleCategoryService.insert(baseParam.getParam());
		}
		baseResult.setStatus(status);
		baseResult.setMsg(status == 0 ? "操作失败！" : "操作成功！");
		return baseResult;
	}

	@RequestMapping(value = "/deleteCate")
	@SysLog(operationType = "delete", operationName = "删除文章分类")
	public BaseResult deleteArticleCategory(String cateId, @CookieValue("userId") String userId) {
		BaseResult baseResult = new BaseResult();
		ArticleCategory articleCategory = new ArticleCategory();
		articleCategory.setId(cateId);
		articleCategory.setUpdateBy(userId);
		articleCategory.setUpdateTime(new Date());
		articleCategory.setState("0");
		int status = articleCategoryService.updateByPrimaryKeySelective(articleCategory);
		baseResult.setStatus(status);
		baseResult.setMsg(status == 0 ? "操作失败！" : "操作成功！");
		return baseResult;
	}

	@RequestMapping(value = "/getCateById")
	public BaseResult getArticleCategoryById(String cateId) {
		return new BaseResult().success(articleCategoryService.selectByPrimaryKey(cateId));
	}

}
