package com.magic.basiccenter.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AdvertSelDTO implements Serializable{
	private static final long serialVersionUID = -3069633218115029451L;

	/**当前页码*/
    private Integer currentPage;
    
    /**页面大小*/
    private Integer turnPageShowNum;
    
    /**广告主题*/
    private String advertTheme;
    
    /**广告状态*/
    private Integer advertStatus;
}
