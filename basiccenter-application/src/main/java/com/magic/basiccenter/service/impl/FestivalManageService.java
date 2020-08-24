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
    public MagicOutDTO<FestivalAddOutDTO> AddFestival(MagicDTO<FestivalAddDTO> magicDTO) {

        //定义实体对象
        FestivalAddDTO body = magicDTO.getBody();

        //定义输出对象
        FestivalAddOutDTO festivalAddOutDTO = new FestivalAddOutDTO();
        RespHeader respHeader=new RespHeader();
        MagicOutDTO<FestivalAddOutDTO> magicOutDTO;
        ApplicationServiceUtil.supplementaryRespHeader(magicDTO.getHeader(), respHeader);

        if(festivalService.FestivalSelectNameYear(body.getFestivalName(),body.getFestivalYear())){
            //无冲突则添加
            festivalService.FestivalAdd(body);
            respHeader.setErrorCode(FestivalMessageEnum.SUCCESS.code());
            respHeader.setErrorMsg(FestivalMessageEnum.SUCCESS.msg());
        }else {
            //有冲突则返回失败
            respHeader.setErrorCode(FestivalMessageEnum.FAIL_FESTIVAL_ADD_CONFLICT.code());
            respHeader.setErrorMsg(FestivalMessageEnum.FAIL_FESTIVAL_ADD_CONFLICT.msg());
        }

        magicOutDTO = new MagicOutDTO<>(festivalAddOutDTO);
        magicOutDTO.setHeader(respHeader);
        return magicOutDTO;
    }



    /**
     * 查询节假日列表
     * @param magicDTO
     * @return
     */
    @Override
    public MagicOutDTO<FestivalQueryListOutDTO> QueryFestivalList(MagicDTO<FestivalQueryListDTO> magicDTO) {

        MagicOutDTO<FestivalQueryListOutDTO> magicOutDTO=new MagicOutDTO<FestivalQueryListOutDTO>();
        FestivalQueryListOutDTO result = festivalService.FestivalQuery();
        magicOutDTO.setBody(result);
        RespHeader respHeader=new RespHeader();
        ApplicationServiceUtil.supplementaryRespHeader(magicDTO.getHeader(), respHeader);
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
    public MagicOutDTO<FestivalQueryListOutDTO> QueryFestival(MagicDTO<FestivalQueryDTO> magicDTO) {

        FestivalQueryDTO body = magicDTO.getBody();
        MagicOutDTO<FestivalQueryListOutDTO> magicOutDTO=new MagicOutDTO<FestivalQueryListOutDTO>();
        FestivalQueryListOutDTO result = festivalService.FestivalQueryForYear(body.getFestivalYear());
        magicOutDTO.setBody(result);
        RespHeader respHeader=new RespHeader();
        ApplicationServiceUtil.supplementaryRespHeader(magicDTO.getHeader(), respHeader);
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
    public MagicOutDTO<FestivaldeleteOutDTO> DeleteFestival(@RequestBody MagicDTO<FestivaldeleteDTO> magicDTO) {
        MagicOutDTO<FestivaldeleteOutDTO> magicOutDTO = festivalService.FestivalDelete(magicDTO);
        return magicOutDTO;

    }



    /**
     * 节假日修改日期冲突检查
     * @param magicDTO
     * @return
     */
    @Override
    public MagicOutDTO<FestivalManageModifyOutDTO> ModifyFestival(MagicDTO<FestivalManageModifyDTO> magicDTO) {
        // 获取输入类
        FestivalManageModifyDTO festivalModifyDTO = magicDTO.getBody();

        // 获取输出类
        MagicOutDTO<FestivalManageModifyOutDTO> magicOutDTO = new MagicOutDTO<>();

        RespHeader respHeader = new RespHeader();
        ApplicationServiceUtil.supplementaryRespHeader(magicDTO.getHeader(), respHeader);

        if (festivalModifyDTO.getFestivalDeploy() == null) {
            respHeader.setErrorCode(FestivalMessageEnum.FAIL_FESTIVAL_INVALID.code());
            respHeader.setErrorMsg(FestivalMessageEnum.FAIL_FESTIVAL_INVALID.msg());
            magicOutDTO.setHeader(respHeader);
            return magicOutDTO;
        }


        //修改节假日信息,获取响应头
        respHeader = festivalService.FestivalModify(festivalModifyDTO);

        magicOutDTO.setHeader(respHeader);
        return magicOutDTO;
    }
}
