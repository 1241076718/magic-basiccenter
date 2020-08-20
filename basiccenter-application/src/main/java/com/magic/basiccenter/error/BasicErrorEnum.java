package com.magic.basiccenter.error;

import java.util.HashMap;
import java.util.Map;

public enum BasicErrorEnum {

	SUCCESS("0","交易成功"),
    FAIL("2","交易失败");
    
    
    private final Map<String, String> errorMap = new HashMap<String, String>();

	BasicErrorEnum(String code, String msg) {
        this.errorMap.put("errorCode", code);
        this.errorMap.put("errorMsg", msg);
    }
    public String code(){
        return this.errorMap.get("errorCode");
    }
    public String msg(){
        return this.errorMap.get("errorMsg");
    }

    public static BasicErrorEnum getErrorCodeMsgEnum(String code){
        for(BasicErrorEnum errorEnum : BasicErrorEnum.values()){
            if(code.equals(errorEnum.code())){
                return errorEnum;
            }
        }
        return null;
    }
	
}
