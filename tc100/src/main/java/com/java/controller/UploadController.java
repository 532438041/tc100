package com.java.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.java.common.entity.BaseResult;
import com.java.service.UploadService;

@RestController
public class UploadController {

	@Autowired
	private UploadService uploadService;

	@RequestMapping(value = "/image/uploadImg")
	public BaseResult uploadImg(@RequestParam("file") MultipartFile[] files, String userId) {
		Map<String, Object> map = uploadService.uploadImg(files, userId);
		return new BaseResult().success(map);
	}

}
