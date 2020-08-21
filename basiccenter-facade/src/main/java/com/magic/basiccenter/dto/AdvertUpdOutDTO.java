package com.magic.basiccenter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * <p>广告配置修改出参</P>
 *
 * @author luolf@belink.com
 * @version 0.0.1
 * @className AdvertUpdOutDTO
 * @sine 2020/8/19 16:18
 */
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer", "fieldHandler"})
public class AdvertUpdOutDTO implements Serializable {
    private static final long serialVersionUID = -7893564187004910203L;
}
