package com.magic.basiccenter.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 后端数据回调封装
 */
@Data
public class DocumentStateDTO implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 714215318134516808L;
    /**
     * 文档编号
     */
    private String docsId;
    /**
     * 修改状态（0 成功， 1 失败）
     */
    private Integer state;
}
