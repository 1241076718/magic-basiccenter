package com.magic.basiccenter.model.dto;

import java.io.Serializable;
import java.util.List;

import com.magic.basiccenter.dto.AdvertInfBean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>广告配置列表查询基础交互出参DTO</P>
 *
 * @author jianggq@belink.com
 * @version 0.0.1
 * @className AdvertSelDTO
 * @sine 2020/8/21 17:16
 */
@Data
@Accessors(chain = true)
public class SelAdvertInfoOutDTO implements Serializable {
	private static final long serialVersionUID = -7154895539493619006L;
	
	/**一页显示记录数*/
	private long turnPageTotalNum;
	
	/**当前页码*/
    private Long currentPage;    
    
    /**总行数(通过查询获得)*/
    private Long totalNum;
    
    /**当前页记录*/
    private List<AdvertInfBean> bannerList;
}
