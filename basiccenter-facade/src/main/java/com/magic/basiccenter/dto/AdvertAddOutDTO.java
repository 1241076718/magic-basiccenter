package com.magic.basiccenter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * <p>广告配置新增出参</P>
 *
 * @author laiqx@belink.com
 * @version 0.0.1
 * @className AdvertAddOutDTO
 * @sine 2020/8/19 10:18
 */
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer", "fieldHandler"})
public class AdvertAddOutDTO implements Serializable {
    private static final long serialVersionUID = -8278034840540334568L;
}
