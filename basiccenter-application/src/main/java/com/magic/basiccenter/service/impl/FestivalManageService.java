package com.magic.basiccenter.service.impl;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.application.infrastructure.service.dto.data.RespHeader;
import com.magic.application.infrastructure.utils.ApplicationServiceUtil;
import com.magic.basiccenter.dto.*;
import com.magic.basiccenter.error.FestivalMessageEnum;
import com.magic.basiccenter.model.service.FestivalService;
import com.magic.basiccenter.service.IFestivalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Calendar;


/**
 * 节假日管理服务实现类
 */
@Slf4j
@Service
public class FestivalManageService implements IFestivalService {
    

    @Autowired(required = false)
    private FestivalService festivalService;



    /**
     * 添加节日
     * @param magicDTO
     * @return
     */
    @Override
    public MagicOutDTO<FestivalAddOutDTO> addFestival(MagicDTO<FestivalAddDTO> magicDTO) {

        //获取响应体
        FestivalAddDTO body = magicDTO.getBody();

        //定义输出对象
        MagicOutDTO<FestivalAddOutDTO> magicOutDTO= new MagicOutDTO<>();
        FestivalAddOutDTO festivalAddOutDTO = new FestivalAddOutDTO();
        RespHeader respHeader=new RespHeader();
        ApplicationServiceUtil.supplementaryRespHeader(magicDTO.getHeader(), respHeader);



        //判断数据库中是否有冲突节日
        if(festivalService.festivalSelectNameYear(body.getFestivalName(),body.getFestivalYear())){
            //无冲突则添加
            festivalService.festivalAdd(body);
            respHeader.setErrorCode(FestivalMessageEnum.SUCCESS.code());
            respHeader.setErrorMsg(FestivalMessageEnum.SUCCESS.msg());
        }else {
            //有冲突则返回失败
            respHeader.setErrorCode(FestivalMessageEnum.FAIL_FESTIVAL_ADD_CONFLICT.code());
            respHeader.setErrorMsg(FestivalMessageEnum.FAIL_FESTIVAL_ADD_CONFLICT.msg());
        }

        //magicOutDTO = new MagicOutDTO<>(festivalAddOutDTO);
        magicOutDTO.setBody(festivalAddOutDTO);
        magicOutDTO.setHeader(respHeader);
        return magicOutDTO;
    }



    /**
     * 查询节假日列表
     * @param magicDTO
     * @return
     */
    @Override
    public MagicOutDTO<FestivalQueryListOutDTO> queryFestivalList(MagicDTO<FestivalQueryListDTO> magicDTO) {

        //定义输出对象
        MagicOutDTO<FestivalQueryListOutDTO> magicOutDTO=new MagicOutDTO<FestivalQueryListOutDTO>();
        RespHeader respHeader=new RespHeader();
        ApplicationServiceUtil.supplementaryRespHeader(magicDTO.getHeader(), respHeader);

        //获取当前时间年份
        Calendar now = Calendar.getInstance();
        String year = String.valueOf(now.get(Calendar.YEAR));

        FestivalQueryListOutDTO result = festivalService.festivalQueryByYear(year);

        //封装输出对象
        magicOutDTO.setBody(result);
        respHeader.setErrorCode(FestivalMessageEnum.SUCCESS.code());
        respHeader.setErrorMsg(FestivalMessageEnum.SUCCESS.msg());
        magicOutDTO.setHeader(respHeader);
        return magicOutDTO;
    }


    /**
     * 根据节假日年份查询节假日列表
     * @param magicDTO
     * @return
     */
    @Override
    public MagicOutDTO<FestivalQueryListOutDTO> queryFestival(MagicDTO<FestivalQueryDTO> magicDTO) {

        //获取请求体
        FestivalQueryDTO body = magicDTO.getBody();
        //定义输出对象
        MagicOutDTO<FestivalQueryListOutDTO> magicOutDTO=new MagicOutDTO<FestivalQueryListOutDTO>();
        RespHeader respHeader=new RespHeader();
        ApplicationServiceUtil.supplementaryRespHeader(magicDTO.getHeader(), respHeader);

        FestivalQueryListOutDTO result = festivalService.festivalQueryByYear(body.getFestivalYear());

        //封装输出对象
        magicOutDTO.setBody(result);
        respHeader.setErrorCode(FestivalMessageEnum.SUCCESS.code());
        respHeader.setErrorMsg(FestivalMessageEnum.SUCCESS.msg());
        magicOutDTO.setHeader(respHeader);
        return magicOutDTO;
    }

    /**
     * 删除功能
     * @param magicDTO
     * @return
     */
    @Override
    public MagicOutDTO<FestivaldeleteOutDTO> deleteFestival(@RequestBody MagicDTO<FestivaldeleteDTO> magicDTO) {
        MagicOutDTO<FestivaldeleteOutDTO> magicOutDTO = festivalService.festivalDelete(magicDTO);
        return magicOutDTO;

    }


    /**
     * 节假日修改日期
     * @param magicDTO
     * @return
     */
    @Override
    public MagicOutDTO<FestivalModifyOutDTO> modifyFestival(MagicDTO<FestivalModifyDTO> magicDTO) {
        // 获取输入类
        FestivalModifyDTO festivalModifyDTO = magicDTO.getBody();

        // 定义输出类
        MagicOutDTO<FestivalModifyOutDTO> magicOutDTO = new MagicOutDTO<>();
        RespHeader respHeader = new RespHeader();
        ApplicationServiceUtil.supplementaryRespHeader(magicDTO.getHeader(), respHeader);

        // 非空校验
        if (festivalModifyDTO.getFestivalDeploy() == null) {
            respHeader.setErrorCode(FestivalMessageEnum.FAIL_FESTIVAL_INVALID.code());
            respHeader.setErrorMsg(FestivalMessageEnum.FAIL_FESTIVAL_INVALID.msg());
            magicOutDTO.setHeader(respHeader);
            return magicOutDTO;
        }


        //修改节假日信息,获取响应头
        respHeader = festivalService.festivalModify(festivalModifyDTO);

        magicOutDTO.setHeader(respHeader);
        return magicOutDTO;
    }
}
