package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocumentFacadeIdDTO implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = -8737549624573690787L;
    /**
     * 文件编号
     */
    private String docsId;
}
