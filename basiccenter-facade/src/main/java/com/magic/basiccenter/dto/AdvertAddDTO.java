package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>广告配置新增入参</P>
 *
 * @author laiqx@belink.com
 * @version 0.0.1
 * @className AdvertAddDTO
 * @sine 2020/8/19 10:18
 */
@Data
public class AdvertAddDTO implements Serializable {
    private static final long serialVersionUID = -8981375388526054929L;

    /**
     * 广告编号
     */
    private String aiAdvId;
    /**
     * 广告主题
     */
    private String aiAdvTheme;
    /**
     * 广告状态
     */
    private Integer aiAdvStatus;
    /**
     * 广告描述
     */
    private String aiAdvDesc;
    /**
     * 广告栏位
     */
    private String aiAdvColu;
    /**
     * 栏位序号
     */
    private Integer aiAdvColuId;
    /**
     * 左上广告词
     */
    private String aiAdvWordLeft;
    /**
     * 右上广告词
     */
    private String aiAdvWordRight;
    /**
     * 广告链接
     */
    private String aiAdvUrl;
    /**
     * 广告封面
     */
    private String aiAdvCover;
    /**
     * 广告创建人
     */
    private String aiAdvCreateUser;
    /**
     * 广告创建时间
     */
    private LocalDateTime aiAdvCreateTime;
    /**
     * 广告修改人
     */
    private String aiAdvUpdateUser;
    /**
     * 广告修改时间
     */
    private LocalDateTime aiAdvUpdateTime;
}
