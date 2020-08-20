package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocumentFacadeOutDTO implements Serializable {
    /**
     * 文件状态
     */
    private Integer state;
}
