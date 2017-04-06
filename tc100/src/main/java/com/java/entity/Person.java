package com.java.entity;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.java.servlet.JsonDateSerializer;

public class Person {
	private String id;

	private String userId;

	private String addName;

	private String title;

	private String remark;

	private String lineType;

	private String createBy;

	private Date createTime;

	private String updateBy;

	private Date updateTime;

	public String getId() {
		return id == null ? "" : id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId == null ? "" : userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title == null ? "" : title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRemark() {
		return remark == null ? "" : remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateBy() {
		return createBy == null ? "" : createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy == null ? "" : updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getAddName() {
		return addName;
	}

	public void setAddName(String addName) {
		this.addName = addName;
	}

	public String getLineType() {
		return lineType;
	}

	public void setLineType(String lineType) {
		this.lineType = lineType;
	}
}