package com.magic.basiccenter.error;

import java.util.HashMap;
import java.util.Map;

public enum AdvertErrorEnum {

    SUCCESS("0","执行成功"),
    FAIL("2","执行失败"),
	ERROR("-1","执行异常");

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
