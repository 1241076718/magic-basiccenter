package com.magic.basiccenter.error;

import java.util.HashMap;
import java.util.Map;

public enum AdvertErrorEnum {

    SUCCESS("0","执行成功"),
    FAIL("2","执行失败"),
	ERROR("-1","执行异常"),
    ADDFAIL("BAS001001", "新增失败"),
    SELFAIL("BAS001002", "查询失败"),
    UPDFAIL("BAS001003", "修改失败"),
    PUTFAIL("BAS001004", "上架失败"),
    SOLDFAIL("BAS001005", "下架失败"),
    DELFAIL("BAS001006", "删除失败");

    private final Map<String, String> errorMap = new HashMap<String, String>();

    AdvertErrorEnum(String code, String msg) {
        this.errorMap.put("errorCode", code);
        this.errorMap.put("errorMsg", msg);
    }

    public String code() {
        return this.errorMap.get("errorCode");
    }

    public String msg() {
        return this.errorMap.get("errorMsg");
    }

    public static AdvertErrorEnum getErrorCodeMsgEnum(String code) {
        for (AdvertErrorEnum errorEnum : AdvertErrorEnum.values()) {
            if(code.equals(errorEnum.code())) {
                return errorEnum;
            }
        }
        return null;
    }

}
