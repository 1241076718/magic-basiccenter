package com.magic.basiccenter.constants;


/**
 * @author ：goupc1@belink.com
 * @date ：Created in 2020/8/620 9:54
 * @description： 序列IDpublic_id_segment表实体类
 * @modified By：
 * @version: $1.0.0
 */

public class Constant {

    //公告ID获取常量
    public static final String CU_NOTICE_ID = "cu_notice_id";
    /**
     * 节日Id
     */
    public static final String FESTIVAL_BIZ_TAG = "festival_biz_tag";

    /**
     * 文档Id
     */
    public static final String DOC_ID = "document_id";

	/**
     * 生效的广告栏位
     */
    public static final Integer ADVERT_COLUMN_ISLIVE = 0 ;
	/**
     * 广告栏位类型
     */
    public static final String ADVERT_COLUMN_TYPE = "advert_column_type";
	
    /**
     * 广告编号
     */
    public static final String ADVERT_ID_TAG = "advert_id";

    /**
     * 广告新建状态码
     */
    public static final Integer ADVERT_ADD_STATUS_CODE = 0;

    /**
     * 广告已上架状态码
     */
    public static final Integer ADVERT_PUT_STATUS_CODE = 1;

    /**
     * 广告已下架状态码
     */
    public static final Integer ADVERT_SOLD_STATUS_CODE = 2;

    /**
     * 广告已删除状态码
     */
    public static final Integer ADVERT_DELETE_STATUS_CODE = 3;

}
