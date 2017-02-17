package com.java.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.entity.BaseResult;
import com.java.utils.ToolsUtil;

@RestController
public class SendMsgController {

	/**
	 * 发送短信
	 * 
	 * @param @param mobile 手机号
	 * @param @param tempCode 短信模板号
	 * @param @param code 验证码
	 * @param @return
	 * @return BaseResult
	 */
	@RequestMapping(value = "/sendMsg")
	public BaseResult sendMsg(String mobile, String tempCode) {
		String vCode = ToolsUtil.getUUID(6).toString();
		String url = "";
		String appkey = "";
		String secret = "";
		/*TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("阿里大于");
		req.setSmsParamString("{\"code\":\"1234\",\"product\":\"alidayu\"}");
		req.setRecNum("13000000000");
		req.setSmsTemplateCode("SMS_585014");
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);*/
		return new BaseResult().success(vCode);
	}

}
