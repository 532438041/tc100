package com.java.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.common.entity.ImageFileConfig;
import com.java.service.UploadService;
import com.java.utils.ToolsUtil;

import cn.jiguang.commom.utils.StringUtils;

@Service
public class UploadServiceImpl implements UploadService {

	@Override
	public Map<String, Object> uploadImg(MultipartFile[] files, String userId) {
		String path = "";
		String url = "";

		Map<String, Object> map = new HashMap<>();

		// 图片空间 分组管理
		if (StringUtils.isNotEmpty(userId)) {
			path = ImageFileConfig.uploadFilePath + "/" + userId;
			url = ImageFileConfig.imagePrefix + "/" + userId;
		} else {
			path = ImageFileConfig.uploadFilePath;
			url = ImageFileConfig.imagePrefix;
		}

		// 获取文件上传的真实路径
		try {
			// 上传文件过程
			for (MultipartFile file : files) {
				String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
				int length = ImageFileConfig.allowSuffix.indexOf(suffix);
				if (length == -1) {
					return null;
				}
				File destFile = new File(path);
				if (!destFile.exists()) {
					destFile.mkdirs();
				}
				String fileIdNew = ToolsUtil.getUUID();
				String fileNameNew = fileIdNew + "." + suffix;
				url += "/" + fileNameNew;
				File f = new File(destFile.getAbsoluteFile() + File.separator + fileNameNew);
				if (f.exists()) {
					continue;
				}
				file.transferTo(f);
				f.createNewFile();

				map.put("imgName", file.getOriginalFilename());
				map.put("imgUrl", url);

			}
		} catch (Exception ex) {

		}
		return map;
	}

}
