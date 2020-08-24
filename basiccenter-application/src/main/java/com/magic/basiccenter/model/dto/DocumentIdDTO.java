package com.magic.basiccenter.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据回显
 */
@Data
public class DocumentIdDTO implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 1333502404570143765L;
    /**
     * 文件编号
     */
    private String docsId;
}
