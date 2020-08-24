package com.magic.basiccenter.dto;

import java.util.List;

import com.magic.application.infrastructure.service.dto.SelectPageOutDTO;
 
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>广告配置列表查询出参</P>
 *
 * @author jianggq@belink.com
 * @version 0.0.1
 * @className AdvertSelDTO
 * @sine 2020/8/21 17:16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AdvertSelOutDTO extends SelectPageOutDTO {
    private static final long serialVersionUID = 8259207203485282299L;

    /**当前页码*/
    private Long currentPage;

    /**总行数(通过查询获得)*/
    private Long totalNum;

    /**当前页记录*/
    private List<AdvertInfBean> bannerList;
}
