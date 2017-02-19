package com.java.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseParam;
import com.java.common.entity.BaseResult;
import com.java.common.entity.PageParam;
import com.java.entity.Feedback;
import com.java.service.FeedbackService;
import com.java.utils.ToolsUtil;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@RequestMapping(value = "/getFbList")
	public BaseResult getFbList(@RequestBody PageParam<Feedback> pageParam) {
		return new BaseResult().success(feedbackService.getFbList(pageParam));
	}

	@RequestMapping(value = "/saveFb")
	public BaseResult saveFb(@RequestBody BaseParam<Feedback> baseParam) {
		baseParam.getParam().setId(ToolsUtil.getUUID());
		baseParam.getParam().setCreateTime(new Date());
		return new BaseResult().success(feedbackService.insert(baseParam.getParam()));
	}

}