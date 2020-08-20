package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询节假日列表输出DTO
 */
@Data
public class FestivalQueryListOutDTO implements Serializable {


    private static final long serialVersionUID = 8783796895765523093L;
    /**
     * 节假日名称
     */
    private String festivalName;

    /**
     * 节假日年份
     */
    private String festivalYear;

    /**
     * 节假日类型
     */
    private String festivalType;

    /**
     * 节假日配置
     */
    private String festivalDeploy;

    /**
     * 发布时间
     */
    private Date festivalPutTime;

    /**
     * 发布人
     */
    private String festivalPutPerson;
}
