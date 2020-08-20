package com.magic.basiccenter.dto;

import com.magic.basiccenter.dto.entity.Bs_notice_inf;
import com.magic.basiccenter.dto.entity.Notice;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 公告查询列表
 * 返回数据
 *
 * @author ：wzr
 * @date ：Created in 2020/7/20 15:45
 * @description：查询账户信息
 * @modified By：
 * @version: $
 */


@Data
public class QueryNoticeInfoOutDTO implements Serializable {

    private Integer code;
    private String msg;
    private Integer tatal;
    private List<Bs_notice_inf> notice_infs;

}
