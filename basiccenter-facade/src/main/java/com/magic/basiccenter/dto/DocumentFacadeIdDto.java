package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocumentFacadeIdDto implements Serializable {
    /**
     * 文件编号
     */
    private Integer docsId;
}
