package com.magic.basiccenter.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 文档数据
 * @author YNET
 */
@Data
@Accessors(chain = true)
public class DocumentFacadeDTO implements Serializable {
    /**
     * 文档编号
     */
    private static final long serialVersionUID = 1396306900926885526L;
    /**
     * 文档编号
     */
    private String docsId;
    /**
     * 文档标题
     */
    private String docsName;
    /**
     * 文档类型
     */
    private String catalogName;
    /**
     * 文档内容
     */
    private String docsContents;
    /**
     * 发布人
     */
    private String docsCreateUser;
    /**
     * 文档状态
     */
    private Integer state;
    /**
     * 发布日期
     */
    private String documentPubdate;
    /**
     * 权限
     */
    private String documentPermissions;
    /**
     * 创建人
     */
    private String documentFounder;
    /**
     * 创建时间
     */
    private String documentCtime;
    /**
     * 修改人
     */

    private String documentReviser;
    /**
     * 修改时间
     */
    private String documentMtime;
    /**
     * 数据生命状态
     */
    private String docLife;

}
