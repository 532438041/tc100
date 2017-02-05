package com.java.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.annotation.SysLog;
import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.entity.Category;
import com.java.service.CategoryService;
import com.java.utils.ToolsUtil;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/getCateTree")
	public BaseResult getCateTree() {
		BaseResult baseResult = new BaseResult();
		baseResult.setData(categoryService.getCategoryList());
		return baseResult.success();
	}

	@RequestMapping(value = "/getCateByPid")
	public BaseResult getCateByPid(@RequestBody PageParam<Category> pageParam) {
		if (ToolsUtil.isNull(pageParam.getReqParam().getPid()))
			pageParam.getReqParam().setPid("0");
		BaseResult baseResult = new BaseResult();
		baseResult.setData(categoryService.getCateByPid(pageParam));
		return baseResult;
	}

	@RequestMapping(value = "/saveCate")
	@SysLog(operationType = "add/update", operationName = "添加、编辑分类")
	public BaseResult saveCate(@RequestBody BaseParam<Category> baseParam, String userId) {
		baseParam.getParam().setUpdateBy(userId);
		baseParam.getParam().setUpdateTime(new Date());
		BaseResult baseResult = new BaseResult();
		int status = 0;
		if (ToolsUtil.isNotNull(baseParam.getParam().getId())) {
			// 编辑
			status = categoryService.updateByPrimaryKeySelective(baseParam.getParam());
		} else {
			// 添加
			baseParam.getParam().setId(ToolsUtil.getUUID());
			baseParam.getParam().setState("1");
			baseParam.getParam().setCreateBy(userId);
			baseParam.getParam().setCreateTime(new Date());
			status = categoryService.insert(baseParam.getParam());
		}
		baseResult.setStatus(status);
		baseResult.setMsg(status == 0 ? "操作失败！" : "操作成功！");
		return baseResult;
	}

	@RequestMapping(value = "/deleteCate")
	@SysLog(operationType = "delete", operationName = "删除分类")
	public BaseResult deleteCategory(String cateId, String userId) {
		BaseResult baseResult = new BaseResult();
		Category category = new Category();
		category.setId(cateId);
		category.setUpdateBy(userId);
		category.setUpdateTime(new Date());
		category.setState("0");
		int status = categoryService.updateByPrimaryKeySelective(category);
		baseResult.setStatus(status);
		baseResult.setMsg(status == 0 ? "操作失败！" : "操作成功！");
		return baseResult;
	}

	@RequestMapping(value = "/getCateById")
	public BaseResult getCategoryById(String cateId) {
		return new BaseResult().success(categoryService.selectByPrimaryKey(cateId));
	}

}
