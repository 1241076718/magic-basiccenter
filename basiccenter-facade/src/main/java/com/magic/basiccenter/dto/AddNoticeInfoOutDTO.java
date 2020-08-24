package com.magic.basiccenter.dto;

import lombok.Data;
import java.io.Serializable;

/**

 * @author ：goupc1@belink.com
 * @date ：
 * @description* 公告新增返回数据
 * @modified By：
 * @version: $
 */

@Data
public class AddNoticeInfoOutDTO implements Serializable {


    private static final long serialVersionUID = 322192239362305089L;

    /**
     * 插入数目
     */
    private Integer total;
}
