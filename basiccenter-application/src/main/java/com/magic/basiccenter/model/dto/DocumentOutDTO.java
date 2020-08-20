package com.magic.basiccenter.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocumentOutDTO implements Serializable {
    /**
     * 文件状态
     */
    private Integer state;
}
