package com.magic.basiccenter.error;

import java.util.HashMap;
import java.util.Map;

public enum BasicErrorEnum {
    //    文档域
    SUCCESS("0", "交易成功"),
    FAIL("2", "交易失败"),
    ADD("BAS0040", "新增成功"),
    ADDFATL("BAS004001", "新增失败"),
    REFER("BAS0040", "查询成功"),
    REFERFATL("BAS004002", "查询失败"),
    MODIFY("BAS0040", "修改成功"),
    MODIFYFATL("BAS004003", "修改失败"),
    SHELVES("BAS0040", "上架成功"),
    SHELVESFATL("BAS004004", "上架失败"),
    THEAHWLVES("BAS0040", "下架成功"),
    THESHELVESFATL("BAS004005", "下架失败"),
    DELETE("BAS0040", "删除成功"),
    DeleteFATL("BAS004006", "删除失败"),

    //    公告域
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
