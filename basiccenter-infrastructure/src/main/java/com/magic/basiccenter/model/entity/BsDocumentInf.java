package com.magic.basiccenter.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 文档数据
 * @author YNET
 */
@Data
@TableName(value = "bs_document_inf")
@Accessors(chain = true)
public class BsDocumentInf implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 1195123312782859431L;
    /**
     * 文档编号
     */
    @TableId(value = "DOC_ID")
    private String docsId;
    /**
     * 文档标题
     */
    @TableField(value = "DOC_TITLE")
    private String docsName;
    /**
     * 文档类型
     */
    @TableField(value = "DOC_TYPE")
    private String catalogName;
    /**
     * 文档内容
     */
    @TableField(value = "DOC_CONTENT")
    private String docsContents;
    /**
     * 发布人
     */
    @TableField(value = "DOC_PUBLISHER")
    private String docsCreateUser;
    /**
     * 文档状态
     */
    @TableField(value = "DOC_STATE")
    private Integer state;
    /**
     * 发布日期
     */
    @TableField(value = "DOC_PUBDATE")
    private String documentPubdate;
    /**
     * 权限
     */
    @TableField(value = "DOC_PERMISSIONS")
    private Integer documentPermissions;
    /**
     * 创建人
     */
    @TableField(value = "DOC_FOUNDER")
    private String documentFounder;
    /**
     * 创建时间
     */
    @TableField(value = "DOC_CTIME")
    private String documentCtime;
    /**
     * 修改人
     */
    @TableField(value = "DOC_REVISER")
    private String documentReviser;
    /**
     * 修改时间
     */
    @TableField(value = "DOC_MTIME")
    private String documentMtime;

}
