package com.magic.basiccenter.dto;

import java.io.Serializable;

import com.magic.application.infrastructure.service.dto.SelectPageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>广告配置列表查询入参</P>
 *
 * @author jianggq@belink.com
 * @version 0.0.1
 * @className AdvertSelDTO
 * @sine 2020/8/21 17:12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdvertSelDTO extends SelectPageDTO {
    private static final long serialVersionUID = -5614916005362433547L;

    /**广告主题*/
    private String advertTheme;

    /**广告状态*/
    private Integer advertStatus;
}
