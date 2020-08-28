package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 节假日添加功能传出实体类
 * @author ChenFeiYang
 */
@Data
public class FestivalAddOutDTO implements Serializable {

    private static final long serialVersionUID = 2156259868631512248L;

    /**
     * 添加节日返回结果
     */
    private String festivalAddResult;

}
