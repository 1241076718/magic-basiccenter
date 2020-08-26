package com.magic.basiccenter.dto;

import com.magic.application.infrastructure.service.dto.SelectPageOutDTO;
import com.magic.basiccenter.dto.entity.NoticeBean;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**

 * @author ：goupc1@belink.com
 * @date ：
 * @description* 公告查询列表返回数据
 * @modified By：
 * @version: $
 */


@Data
public class QueryNoticeInfoOutDTO extends SelectPageOutDTO implements Serializable {


    private static final long serialVersionUID = -39884965805778633L;



    /**
     * 返回数据集合
     */
    private List<NoticeBean> data;



}
