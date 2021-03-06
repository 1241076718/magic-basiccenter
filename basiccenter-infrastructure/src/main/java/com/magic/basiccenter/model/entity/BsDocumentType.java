package com.magic.basiccenter.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 文档类型数据
 * @author 36344
 *
 */
@Data
@TableName(value = "bs_document_type")
@Accessors(chain = true)
public class BsDocumentType implements Serializable {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -93330929627933638L;
	
	/**
	 * 文档类型ID
	 */
	@TableId(value = "DOC_TYPE_ID")
	private String docTypeId;

	/**
	 * 文档类型
	 */
	@TableField(value = "DOC_TYPE")
	private String docType;
	/**
	 * 文档类型是否失效(否：0，是：1)
	 */
	@TableField(value = "DOC_TYPE_INVALID")
	private String invalid;

    /**
     * 创建人
     */
    /**
     * 创建时间
     */
    /**
     * 修改人
     */
    /**
     * 修改时间
     */
    /**
     * 生命状态
     */

}
