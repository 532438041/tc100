package com.java.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

	Map<String, Object> uploadImg(MultipartFile[] files, String userId);
	
	Map<String, Object> uploadFile(MultipartFile[] files);

}
