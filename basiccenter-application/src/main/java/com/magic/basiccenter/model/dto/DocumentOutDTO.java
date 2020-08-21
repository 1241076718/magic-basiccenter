package com.magic.basiccenter.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocumentOutDTO implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = -1010740371761668157L;
    /**
     * 文件状态
     */
    private Integer state;
}
