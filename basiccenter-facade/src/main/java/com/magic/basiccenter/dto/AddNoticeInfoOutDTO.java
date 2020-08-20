package com.magic.basiccenter.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class AddNoticeInfoOutDTO<T> implements Serializable {

    private static final long serialVersionUID = 8652422328176953328L;

    private Integer code;

    private String msg;

    private Integer total;
}
