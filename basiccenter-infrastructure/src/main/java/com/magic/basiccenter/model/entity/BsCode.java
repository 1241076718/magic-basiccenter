package com.magic.basiccenter.model.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>广告栏目实体类</P>
 *
 * @author jianggq@belink.com
 * @version 0.0.1
 * @className BsCode
 * @sine 2020/8/28 10:18
 */
@Data
@Accessors(chain = true)
@TableName("bs_code")
public class BsCode implements Serializable{	
	private static final long serialVersionUID = 2791877219881864961L;
	/**
     * 类型
     */
    @TableField("BS_CODE_TYPE")
    private String bsCodeType;
    /**
     * 类型描述
     */
    @TableField("BS_CODE_ALIAS")
    private String bsCodeAlias;
    
    /**
     * 
     */
    @TableField("BS_CODE")
    private String bsCode;
    
    /**
     * 名称
     */
    @TableField("BS_CODE_NAME")
    private String bsCodeName;
    
    /**
     * 其他code
     */
    @TableField("BS_OTHER_CODE")
    private String bsOtherCode;
    
    /**
     * 其他名称
     */
    @TableField("BS_OTHER_NAME")
    private String bsOtherName;
    
    /**
     * 创建时间
     */
    @TableField("BS_CREATE_TIME")
    private String bsCreateTime ;
    
    /**
     * 创建人
     */
    @TableField("BS_CREATE_USER")
    private String bsCreateUser ;
    
    /**
     * 修改时间
     */
    @TableField("BS_MODIFY_TIME")
    private String bsModifyTime ;
    
    /**
     * 修改人
     */
    @TableField("BS_MODIFY_USER")
    private String bsModifyUser ;
    
    @TableField("BS_LIFE")
    private Character bsLife ;
}
