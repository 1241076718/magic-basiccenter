package com.magic.basiccenter.application.error;

public enum FestivalDeleteMessageEnum {
    SUCCESS("删除成功"),FALL("删除失败");

    private String deleteResult;

    FestivalDeleteMessageEnum(String result){
        this.deleteResult=result;
    }
    public String getDeleteResult(){
        return deleteResult;
    }


}
