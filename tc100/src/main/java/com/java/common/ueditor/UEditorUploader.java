/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
package com.java.common.ueditor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.baidu.ueditor.define.State;
import com.baidu.ueditor.upload.Base64Uploader;

public class UEditorUploader {
	private HttpServletRequest request = null;
	private Map<String, Object> conf = null;

	public UEditorUploader(HttpServletRequest request, Map<String, Object> conf) {
		this.request = request;
		this.conf = conf;
	}

	public final State doExec() {
		String filedName = (String) this.conf.get("fieldName");
		State state = null;

		if ("true".equals(this.conf.get("isBase64")))
			state = Base64Uploader.save(this.request.getParameter(filedName), this.conf);
		else {
			state = UEditorBinaryUploader.save(this.request, this.conf);
		}

		return state;
	}
}