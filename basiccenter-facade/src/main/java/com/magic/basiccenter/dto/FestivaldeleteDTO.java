package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FestivaldeleteDTO implements Serializable {


    private static final long serialVersionUID = 6795076424207975139L;
    /*
    *   删除节假日的日期
    */
    private String festivalDeploy;

    private String festivalId;
}
