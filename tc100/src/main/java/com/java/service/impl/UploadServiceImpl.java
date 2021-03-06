package com.java.service.impl;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.common.entity.ImageFileConfig;
import com.java.service.UploadService;
import com.java.utils.ToolsUtil;

import cn.jiguang.commom.utils.StringUtils;
import net.coobird.thumbnailator.Thumbnails;

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
				// 判断目录是否存在
				File destFile = new File(path);
				if (!destFile.exists()) {
					destFile.mkdirs();
				}
				String fileIdNew = ToolsUtil.getUUID();
				String fileNameNew = fileIdNew + "." + suffix;
				url += "/" + fileNameNew;
				String filePath = destFile.getAbsoluteFile() + File.separator + fileNameNew;
				
				File f = new File(filePath);
				if (f.exists()) {
					continue;
				}
				file.transferTo(f);
				f.createNewFile();
				
				// 压缩
				long size = file.getSize();
		        double scale = 1.0d ;
		        if(size >= 1*1000*1024){
		            if(size > 0){
		                scale = (1*1000*1024f) / size;
		            }
		        }
		        Thumbnails.of(filePath).scale(scale).outputQuality(scale).outputFormat(suffix).toFile(filePath);

				map.put("imgName", file.getOriginalFilename());
				map.put("imgUrl", url);

			}
		} catch (Exception ex) {

		}
		return map;
	}
	
	public Map<String, Object> uploadFile(MultipartFile[] files) {
		String path = ImageFileConfig.uploadFilePath;
		String url = "";

		Map<String, Object> map = new HashMap<>();

		// 获取文件上传的真实路径
		try {
			// 上传文件过程
			for (MultipartFile file : files) {
				// 判断目录是否存在
				File destFile = new File(path);
				if (!destFile.exists()) {
					destFile.mkdirs();
				}
				url += "/" + file.getOriginalFilename();
				String filePath = destFile.getAbsoluteFile() + File.separator + file.getOriginalFilename();
				
				File f = new File(filePath);
				file.transferTo(f);
				f.createNewFile();
				
				map.put("fileUrl", url);

			}
		} catch (Exception ex) {

		}
		return map;
	}

	/**
	 * 根据设置的宽高等比例压缩图片文件<br>
	 * 先保存原文件，再压缩、上传
	 * 
	 * @param oldFile
	 *            要进行压缩的文件
	 * @param newFile
	 *            新文件
	 * @param width
	 *            宽度 //设置宽度时（高度传入0，等比例缩放）
	 * @param height
	 *            高度 //设置高度时（宽度传入0，等比例缩放）
	 * @param quality
	 *            质量
	 * @return 返回压缩后的文件的全路径
	 */
	public static String zipImageFile(File oldFile, File newFile, int width, int height, float quality) {
		if (oldFile == null) {
			return null;
		}
		try {
			/** 对服务器上的临时文件进行处理 */
			Image srcFile = ImageIO.read(oldFile);
			int w = srcFile.getWidth(null);
			int h = srcFile.getHeight(null);
			double bili;
			if (width > 0) {
				bili = width / (double) w;
				height = (int) (h * bili);
			} else {
				if (height > 0) {
					bili = height / (double) h;
					width = (int) (w * bili);
				}
			}

			String srcImgPath = newFile.getAbsoluteFile().toString();
			System.out.println(srcImgPath);
			String subfix = "jpg";
			subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".") + 1, srcImgPath.length());

			BufferedImage buffImg = null;
			if (subfix.equals("png")) {
				buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			} else {
				buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			}

			Graphics2D graphics = buffImg.createGraphics();
			graphics.setBackground(new Color(255, 255, 255));
			graphics.setColor(new Color(255, 255, 255));
			graphics.fillRect(0, 0, width, height);
			graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

			ImageIO.write(buffImg, subfix, new File(srcImgPath));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newFile.getAbsolutePath();
	}

	/**
	 * 按设置的宽度高度压缩图片文件<br>
	 * 先保存原文件，再压缩、上传
	 * 
	 * @param oldFile
	 *            要进行压缩的文件全路径
	 * @param newFile
	 *            新文件
	 * @param width
	 *            宽度
	 * @param height
	 *            高度
	 * @param quality
	 *            质量
	 * @return 返回压缩后的文件的全路径
	 */
	public static String zipWidthHeightImageFile(File oldFile, File newFile, int width, int height, float quality) {
		if (oldFile == null) {
			return null;
		}
		String newImage = null;
		try {
			/** 对服务器上的临时文件进行处理 */
			Image srcFile = ImageIO.read(oldFile);

			String srcImgPath = newFile.getAbsoluteFile().toString();
			System.out.println(srcImgPath);
			String subfix = "jpg";
			subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".") + 1, srcImgPath.length());

			BufferedImage buffImg = null;
			if (subfix.equals("png")) {
				buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			} else {
				buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			}

			Graphics2D graphics = buffImg.createGraphics();
			graphics.setBackground(new Color(255, 255, 255));
			graphics.setColor(new Color(255, 255, 255));
			graphics.fillRect(0, 0, width, height);
			graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

			ImageIO.write(buffImg, subfix, new File(srcImgPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newImage;
	}

}
