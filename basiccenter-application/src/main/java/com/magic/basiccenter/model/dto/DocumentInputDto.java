package com.magic.basiccenter.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocumentInputDto implements Serializable {
    /**
     * 文件编号
     */
    private Integer docsId;
    /**
     * 文件状态码
     */
    private Integer state;
}
