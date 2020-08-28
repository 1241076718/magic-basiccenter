package com.magic.basiccenter.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 节假日添加功能传入实体类
 * @author ChenFeiYang
 */
@Data
public class FestivalAddDTO implements Serializable {

    /**
     * 节假日名称
     */
    private String festivalName;

    /**
     * 节假日年份
     */
    private String festivalYear;

    /**
     * 日期配置
     */
    private String festivalDeploy;


    /**
     * 节假日开始时期
     */
    private Date festivalStartTime;


    /**
     * 节假日结束时间
     */
    private Date festivalEndTime;


    /**
     * 节假日类型
     */
    private String festivalType;

    /**
     * 发布时间
     */
    private Date festivalPutTime;

    /**
     * eCIFID,用作发布人
     */
    private String eCIFID;


    public String geteCIFID() {
        return eCIFID;
    }

    public void seteCIFID(String eCIFID) {
        this.eCIFID = eCIFID;
    }
}
