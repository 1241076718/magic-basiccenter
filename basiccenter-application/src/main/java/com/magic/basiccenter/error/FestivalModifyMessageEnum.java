package com.magic.basiccenter.error;

import java.util.HashMap;
import java.util.Map;

public enum FestivalModifyMessageEnum {
	/**
	 * 修改成功
	 */
	SUCCESS("0", "修改成功"),
	/**
	 * 修改成功
	 */
	FAIL("-1", "修改失败"),
	/**
	 * 修改失败,节假日无效
	 */
	FAIL_FESTIVAL_INVALID("BAS003001", "修改失败,所选节假日无效"),
	/**
	 * 修改失败,节假日日期冲突
	 */
	FAIL_FESTIVAL_CONFLICT("BAS003002", "修改失败,节假日日期冲突"),
	/**
	 * 修改失败,传入的修改日期无效
	 */
	FAIL_IN_FESTIVAL_INVALID("BAS003003", "修改失败,传入的修改日期无效"),


	/**
	 * 添加失败，已有新增的节点日
	 */
	FAIL_FESTIVAL_ADD_CONFLICT("BAS003004","添加失败，已有新增的节点日");

	private Map<String, String> map = new HashMap<>();

	FestivalModifyMessageEnum(String code, String msg) {
		this.map.put("code", code);
		this.map.put("msg", msg);
	}

	public String code() {
		return this.map.get("code");
	}

	public String msg() {
		return this.map.get("msg");
	}

}
