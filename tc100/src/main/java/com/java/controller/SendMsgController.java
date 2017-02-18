package com.java.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import com.java.common.entity.BaseResult;
import com.java.utils.ToolsUtil;

@RestController
public class SendMsgController {

	/**
	 * 发送短信
	 * 
	 * @param @param mobile 手机号
	 * @param @param tempCode 短信模板号
	 * @param @return
	 * @return BaseResult
	 * @throws ApiException
	 */
	@RequestMapping(value = "/sendMsg")
	public BaseResult sendMsg(String mobile, String tempCode) {
		String vCode = ToolsUtil.randomCode(6).toString();
		BaseResult baseResult = new BaseResult();
		try {
			IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "your accessKey", "your accessSecret");
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms", "sms.aliyuncs.com");
			IAcsClient client = new DefaultAcsClient(profile);
			SingleSendSmsRequest request = new SingleSendSmsRequest();
			request.setSignName("测试签名");// 控制台创建的签名名称
			request.setTemplateCode(tempCode);// 控制台创建的模板CODE
			request.setParamString("{\"code\":\"" + vCode + "\"}");// 短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
			request.setRecNum(mobile);// 接收号码
			SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
			baseResult.setData(vCode);
			return baseResult.success(1, "发送成功！");
		} catch (ServerException e) {
			e.printStackTrace();
			return baseResult.success(-1, "发送失败！");
		} catch (ClientException e) {
			e.printStackTrace();
			return baseResult.success(-1, "发送失败！");
		}
	}

}
