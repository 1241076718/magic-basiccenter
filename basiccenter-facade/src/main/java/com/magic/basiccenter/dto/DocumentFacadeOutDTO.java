package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocumentFacadeOutDTO implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = -1605564007467731102L;
    /**
     * 文件状态
     */
    private Integer state;
}
