package com.magic.basiccenter.error;

import java.util.HashMap;
import java.util.Map;

public enum FestivalMessageEnum {
	/**
	 * 修改成功
	 */
	SUCCESS("0", "操作成功"),
	/**
	 * 修改成功
	 */
	FAIL("-1", "操作失败"),
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
	 * 删除失败,传入的修改日期无效
	 */
	FAIL_FESTIVAL_DELETE_INVALID("BAS003004", "删除失败,传入的修改日期无效"),
	/**
	 * 添加失败，已有新增的节点日
	 */
	FAIL_FESTIVAL_ADD_NAMECONFLICT("BAS003005","添加失败，已有该节假日"),

	/**
     * 添加失败，传入日期无效
	 */
	FAIL_FESTIVAL_ADD_INVALID("BAS003006","添加失败，传入日期无效"),

    /**
     * 添加失败，传入日期配置冲突
	 */
	FAIL_FESTIVAL_ADD_DEPLOYCONFLICT("BAS003007","添加失败，传入日期配置冲突"),
	/**
	 * 查询失败，未传入查询年份
	 */
	FAIL_FESTIVAL_QUERY_INVALID("BAS003008","查询失败，未传入查询年份");


	private Map<String, String> map = new HashMap<>();

	FestivalMessageEnum(String code, String msg) {
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
