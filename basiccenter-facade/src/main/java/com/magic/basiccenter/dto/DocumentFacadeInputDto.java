package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocumentFacadeInputDto implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 237854697375976405L;
    /**
     * 文件编号
     */
    private String docsId;
    /**
     * 文件状态码
     */
    private Integer state;
}
