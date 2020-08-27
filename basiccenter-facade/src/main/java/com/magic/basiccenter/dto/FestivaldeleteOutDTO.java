package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 节假日删除功能传出DTO
 * @author GaoHua
 */
@Data
public class FestivaldeleteOutDTO implements Serializable {

    private static final long serialVersionUID = -2802561937882243387L;

    /**
     * 删除功能的结果信息
     */
    private String deleteResult;
}
