package com.magic.basiccenter.dto.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 展示页面需要获取的封装对象
 */
@Data
public class FestivalQueryListInf implements Serializable {

    private static final long serialVersionUID = -2577777207720933437L;
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
