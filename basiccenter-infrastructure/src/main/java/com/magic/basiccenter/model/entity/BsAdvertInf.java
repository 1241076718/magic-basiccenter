package com.magic.basiccenter.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>广告配置表实体类</P>
 *
 * @author laiqx@belink.com
 * @version 0.0.1
 * @className BsAdvertInf
 * @sine 2020/8/19 10:18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("bs_advert_inf")
public class BsAdvertInf implements Serializable {
    private static final long serialVersionUID = -92765490547192088L;

    /**
     * 广告编号
     */
    @TableId("AI_ADV_ID")
    private String aiAdvId;
    /**
     * 广告主题
     */
    @TableField("AI_ADV_THEME")
    private String aiAdvTheme;
    /**
     * 广告状态（0：新建；1：已上架；2：已下架；3：已删除）
     */
    @TableField("AI_ADV_STATUS")
    private Integer aiAdvStatus;
    /**
     * 广告描述
     */
    @TableField("AI_ADV_DESC")
    private String aiAdvDesc;
    /**
     * 广告栏位
     */
    @TableField("AI_ADV_COLU")
    private String aiAdvColu;
    /**
     * 栏位序号
     */
    @TableField("AI_ADV_COLU_ID")
    private Integer aiAdvColuId;
    /**
     * 左上广告词
     */
    @TableField("AI_ADV_WORD_LEFT")
    private String aiAdvWordLeft;
    /**
     * 右下广告词
     */
    @TableField("AI_ADV_WORD_RIGHT")
    private String aiAdvWordRight;
    /**
     * 广告链接
     */
    @TableField("AI_ADV_URL")
    private String aiAdvUrl;
    /**
     * 广告封面
     */
    @TableField("AI_ADV_COVER")
    private String aiAdvCover;
    /**
     * 广告创建人
     */
    @TableField("AI_ADV_CREATE_USER")
    private String aiAdvCreateUser;
    /**
     * 广告创建时间
     */
    @TableField("AI_ADV_CREATE_TIME")
    private LocalDateTime aiAdvCreateTime;
    /**
     * 广告修改人
     */
    @TableField("AI_ADV_UPDATE_USER")
    private String aiAdvUpdateUser;
    /**
     * 广告修改时间
     */
    @TableField("AI_ADV_UPDATE_TIME")
    private LocalDateTime aiAdvUpdateTime;
}
