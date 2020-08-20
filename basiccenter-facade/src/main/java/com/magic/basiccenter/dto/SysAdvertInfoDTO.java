package com.magic.basiccenter.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
@Data
public class SysAdvertInfoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5465139675083197370L;
	private Integer advertId;
	private Integer advertStatus;
	private String advertTheme;
	private String advertDesc;
	private String advertColu;
	private Integer advertColuId;
	private String advertWordLeft;
	private String advertWordRight;
	private String advertUrl;
	private String advertCover;
	private LocalDateTime advertCreateTime;
	private LocalDateTime advertUpdateTime;
}
