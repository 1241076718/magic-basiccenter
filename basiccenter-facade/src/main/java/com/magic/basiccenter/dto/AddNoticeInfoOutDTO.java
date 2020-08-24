package com.magic.basiccenter.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * 公告新增方法传出DTO
 * @param <T>
 */
@Data
public class AddNoticeInfoOutDTO implements Serializable {


    private static final long serialVersionUID = 322192239362305089L;

    /**
     * 插入数目
     */
    private Integer total;
}
