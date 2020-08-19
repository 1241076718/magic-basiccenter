package com.magic.basiccenter.dto.mock;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：wzr
 * @date ：Created in 2020/7/20 15:42
 * @description：从核心系统查询账户信息
 * @modified By：
 * @version: $
 */
@Data
public class QueryMockAccountInfoOutDTO implements Serializable {

    private static final long serialVersionUID = 6423428630334377205L;
    /**
     * 币种
     */
    private String HBZL;
    /**
     * 可用余额
     */
    private String KYYE;

}
