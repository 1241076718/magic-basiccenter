package com.magic.basiccenter.error;

import java.util.HashMap;
import java.util.Map;
/**
 * @author ：goupc1@belink.com
 * @date ：Created in 2020/8/620 9:54
 * @description：  返回信息枚举类
 * @modified By：
 * @version: $1.0.0
 */

public enum BasicErrorEnum {

    SUCCESS("0", "成功"),
    FAIL("2", "失败"),
    QFAIL("BAS001001", "查询失败"),
    IFAIL("BAS001003", "新增失败"),
    CFAIL("BAS001005", "修改失败"),
    DFAIL("BAS001007", "删除失败"),
    UFAIL("BAS001009", "删除失败");

    private final Map<String, String> errorMap = new HashMap<String, String>();

    BasicErrorEnum(String code, String msg) {
        this.errorMap.put("errorCode", code);
        this.errorMap.put("errorMsg", msg);
    }

    public String code() {
        return this.errorMap.get("errorCode");
    }

    public String msg() {
        return this.errorMap.get("errorMsg");
    }

    public static BasicErrorEnum getErrorCodeMsgEnum(String code) {
        for (BasicErrorEnum errorEnum : BasicErrorEnum.values()) {
            if (code.equals(errorEnum.code())) {
                return errorEnum;
            }
        }
        return null;
    }

}
