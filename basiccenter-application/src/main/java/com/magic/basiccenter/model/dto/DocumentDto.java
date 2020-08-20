package com.magic.basiccenter.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 文档数据
 * @author YNET
 */
@Data
@Accessors(chain = true)
public class DocumentDto implements Serializable {
    /**
     * 文档编号
     */
    private Integer docsId;
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
    private Integer documentPermissions;
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

}
