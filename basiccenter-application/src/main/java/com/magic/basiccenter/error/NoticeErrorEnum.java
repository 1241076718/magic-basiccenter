package com.magic.basiccenter.error;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: goupc1@belink.com
 * @date: 2020/08/26 10:49
 * @description:
 * @modifined By:
 * @version: 1.0.0
 */
public enum NoticeErrorEnum {


    //    公告域
    SUCCESS("0", "成功"),
    FAIL("2", "系统错误"),
    QFAIL("BAS001001", "查询失败"),
    QNFAIL("BAS001002", "数据不存在"),
    IFAIL("BAS001003", "新增失败"),
    CFAIL("BAS001005", "修改失败"),
    DFAIL("BAS001007", "删除失败"),
    UFAIL("BAS001009", "上架失败"),
    SFATL("BAS001011", "下架失败");


    private final Map<String, String> errorMap = new HashMap<String, String>();

    NoticeErrorEnum(String code, String msg) {
        this.errorMap.put("errorCode", code);
        this.errorMap.put("errorMsg", msg);
    }

    public String code() {
        return this.errorMap.get("errorCode");
    }

    public String msg() {
        return this.errorMap.get("errorMsg");
    }

    public static NoticeErrorEnum getErrorCodeMsgEnum(String code) {
        for (NoticeErrorEnum errorEnum : NoticeErrorEnum.values()) {
            if (code.equals(errorEnum.code())) {
                return errorEnum;
            }
        }
        return null;
    }

}
