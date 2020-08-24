package com.magic.basiccenter.model.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>广告配置列表查询基础交互入参DTO</P>
 *
 * @author jianggq@belink.com
 * @version 0.0.1
 * @className AdvertSelDTO
 * @sine 2020/8/21 17:12
 */
@Data
@Accessors(chain = true)
public class SelAdvertInfoDTO implements Serializable {
	private static final long serialVersionUID = -906160292097290577L;

	/**当前页*/
	private long currentPage;
	
	/**一页显示记录数*/
	private long turnPageShowNum;

	/**广告主题*/
    private String advertTheme;
    
    /**广告状态*/
    private Integer advertStatus;
}
