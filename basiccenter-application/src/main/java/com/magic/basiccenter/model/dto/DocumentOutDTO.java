package com.magic.basiccenter.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 文档发布流程状态
 */
@Data
public class DocumentOutDTO implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = -1010740371761668157L;
    /**
     * 文件修改状态码 (0 成功，2 失败)
     */
    private Integer state;
}
