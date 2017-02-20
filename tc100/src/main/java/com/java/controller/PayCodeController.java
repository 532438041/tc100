package com.java.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseResult;
import com.java.entity.PayCode;
import com.java.service.PayCodeService;
import com.java.utils.ToolsUtil;

@RestController
public class PayCodeController {

	@Autowired
	private PayCodeService payCodeService;

	/**
	 * 获取未使用的推荐码
	 * 
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/getPayCodeList")
	public BaseResult getPayCodeList() {
		return new BaseResult().success(payCodeService.getPayCodeList(null));
	}

	/**
	 * 生成num个推荐码
	 * 
	 * @param @param num
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/createPayCode")
	public BaseResult createPayCode(int num) {
		if (ToolsUtil.isNotNull(num)) {
			for (int i = 0; i < num; i++) {
				PayCode payCode = new PayCode();
				payCode.setId(ToolsUtil.getUUID());
				payCode.setCode(ToolsUtil.randomCode(6));
				payCode.setCreateTime(new Date());
				payCode.setState("1");
				payCodeService.insert(payCode);
			}
		}
		return new BaseResult().success();
	}

	@RequestMapping(value = "/checkPayCode")
	public BaseResult checkPayCode(String payCode) {
		if(ToolsUtil.isNull(payCode)){
			return new BaseResult().failed(0, "推荐码为空！");
		}
		List<PayCode> list = payCodeService.getPayCodeList(payCode);
		if (list.size() > 0) {
			return new BaseResult().success(list.get(0));
		} else {
			return new BaseResult().failed(0, "推荐码不可用！");
		}
	}

	@RequestMapping(value = "/usePayCode")
	public BaseResult usePayCode(String actId, String payCodeId) {
		PayCode payCode = new PayCode();
		payCode.setId(payCodeId);
		payCode.setActId(actId);
		payCode.setState("2");
		return new BaseResult().success(payCodeService.updateByPrimaryKeySelective(payCode));
	}

}