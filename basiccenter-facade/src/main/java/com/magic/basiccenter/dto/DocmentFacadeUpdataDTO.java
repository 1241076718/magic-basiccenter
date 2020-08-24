package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocmentFacadeUpdataDTO implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 1392051448080490641L;
    /**
     * 修改状态
     */
    private Integer documentUpdataStat;
}
