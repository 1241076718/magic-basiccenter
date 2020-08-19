package com.magic.basiccenter.application.error;

import java.util.HashMap;
import java.util.Map;

public enum FestivalModifyMessageEnum {
	/**
	 * 修改成功
	 */
	SUCCESS("修改成功", "SUCCESS"), 
	/**
	 * 修改失败,节假日无效
	 */
	FAIL_FESTIVAL_INVALID("修改失败", "节假日无效"),
	/**
	 * 修改失败,节假日日期冲突
	 */
	FAIL_FESTIVAL_CONFLICT("修改失败", "节假日日期冲突");

	private Map<String, String> map = new HashMap<>();

	FestivalModifyMessageEnum(String code, String msg) {
		this.map.put("status", code);
		this.map.put("inf", msg);
	}

	public String getStatus() {
		return this.map.get("status");
	}

	public String getInf() {
		return this.map.get("inf");
	}

}
