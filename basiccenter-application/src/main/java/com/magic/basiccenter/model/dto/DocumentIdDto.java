package com.magic.basiccenter.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocumentIdDto implements Serializable {
    /**
     * 文件编号
     */
    private Integer docsId;
}
