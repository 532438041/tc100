package com.java.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.common.ueditor.UEditorActionEnter;

@RestController
public class UEditorController {

	@RequestMapping(value = "/uEditorController")
	public void uEditorController(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "text/html");
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		response.getWriter().write(new UEditorActionEnter(request, rootPath).exec());
	}
}
