package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 当前年份节假日查询传入DTO
 * @author ChenFeiYang
 */
@Data
public class FestivalQueryListDTO implements Serializable {
    private static final long serialVersionUID = 7071853071142390819L;

    /**
     * 传入信息
     */
    private String festivalQueryMessge;

}
