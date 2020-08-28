package com.magic.basiccenter.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
/**
 * <p>广告栏位信息</P>
 *
 * @author jianggq@belink.com
 * @version 0.0.1
 * @className ColumnInfBean
 * @sine 2020/8/28 17:12
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ColumnInfBean implements Serializable{
	private static final long serialVersionUID = -316088509230924658L;
	
	/**
     * 栏位ID
     */
    private String bsCode;
    
    /**
     * 栏位名称
     */
    private String bsCodeName;
}
