package com.magic.basiccenter.dto;

import com.magic.application.infrastructure.service.dto.SelectPageDTO;
import com.magic.application.infrastructure.service.dto.SelectPageOutDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 公告查询列表
 * 返回数据
 *
 * @author ：wzr
 * @date ：
 * @description
 * @modified By：
 * @version: $
 */


@Data
public class QueryNoticeInfoOutDTO<T>  extends SelectPageOutDTO implements Serializable {


    private static final long serialVersionUID = -39884965805778633L;
    /**
     * 返回数据集合
     */

    private List<T> data;



}
