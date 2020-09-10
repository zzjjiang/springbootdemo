package com.jone.controller.vo;

import java.util.List;

public class PageVO<T> {
	/**
	 * 接口状态
	 */
	private int code;
	/**
	 * 提示文本
	 */
	private String msg;
	/**
	 * 数据长度
	 */
	private int count;
	/**
	 * 数据列表
	 */
	private List<T> data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}