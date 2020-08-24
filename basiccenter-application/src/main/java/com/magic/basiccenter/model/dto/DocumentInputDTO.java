package com.magic.basiccenter.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocumentInputDTO implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 5819729677068562274L;
    /**
     * 文件编号
     */
    private String docsId;
    /**
     * 文件状态码
     */
    private Integer state;
}
