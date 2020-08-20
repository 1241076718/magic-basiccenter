package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocmentFacadeUpdataDto implements Serializable {
    /**
     * 修改状态
     */
    private Integer documentUpdataStat;
}
