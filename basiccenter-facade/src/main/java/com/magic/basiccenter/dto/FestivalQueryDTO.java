package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 节假日查询功能传入实体类
 * @author ChenFeiYang
 */
@Data
public class FestivalQueryDTO implements Serializable {

    private static final long serialVersionUID = 6968481962616237401L;

    /**
     * 查询的年份
     */
    private String festivalYear;
}
