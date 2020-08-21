package com.magic.basiccenter.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocmentUpdataDto implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 714215318134516808L;
    /**
     * 修改状态
     */
    private Integer documentUpdataStat;
}
