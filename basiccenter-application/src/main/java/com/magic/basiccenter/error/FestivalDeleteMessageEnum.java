package com.magic.basiccenter.error;

import java.util.HashMap;
import java.util.Map;

public enum FestivalDeleteMessageEnum {

	SUCCESS("1","删除成功"),
    FAIL("0","删除失败");
    
    
    private final Map<String, String> errorMap = new HashMap<String, String>();

	FestivalDeleteMessageEnum(String code, String msg) {
        this.errorMap.put("errorCode", code);
        this.errorMap.put("errorMsg", msg);
    }
    public String code(){
        return this.errorMap.get("errorCode");
    }
    public String msg(){
        return this.errorMap.get("errorMsg");
    }

    public static FestivalDeleteMessageEnum getErrorCodeMsgEnum(String code){
        for(FestivalDeleteMessageEnum errorEnum : FestivalDeleteMessageEnum.values()){
            if(code.equals(errorEnum.code())){
                return errorEnum;
            }
        }
        return null;
    }
	
}
