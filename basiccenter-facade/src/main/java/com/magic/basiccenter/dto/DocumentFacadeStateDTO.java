package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocumentFacadeStateDTO implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 1392051448080490641L;
    /**
     * 文档编号
     */
    private String docsId;
    /**
     * 修改状态
     */
    private Integer state;
}
