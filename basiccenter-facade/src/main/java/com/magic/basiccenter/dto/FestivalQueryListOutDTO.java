package com.magic.basiccenter.dto;

import com.magic.basiccenter.entity.FestivalQueryListInf;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 查询节假日列表输出DTO
 * @author ChenFeiYang
 */
@Data
public class FestivalQueryListOutDTO implements Serializable {


    private static final long serialVersionUID = 8783796895765523093L;


    /**
     * 节假日列表输出对象
     */
    private List<FestivalQueryListInf> festivalQueryListInfs;

}
