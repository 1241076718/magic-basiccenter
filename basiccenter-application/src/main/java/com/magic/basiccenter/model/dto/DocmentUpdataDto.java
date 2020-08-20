package com.magic.basiccenter.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocmentUpdataDto implements Serializable {
    /**
     * 修改状态
     */
    private Integer documentUpdataStat;
}
