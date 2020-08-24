package com.magic.basiccenter.service.impl;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.application.infrastructure.service.dto.data.ReqHeader;
import com.magic.application.infrastructure.service.dto.data.RespHeader;
import com.magic.basiccenter.dto.*;
import com.magic.basiccenter.error.BasicErrorEnum;
import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.dto.QueryNoticeOutDTO;
import com.magic.basiccenter.model.service.INoticeService;
import com.magic.basiccenter.service.IBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: GPC
 * Date: 2020/08/21 13:53
 * Description:
 * Version: V1.0
 */


@Service
public class BasicServiceImpl implements IBasicService {

    @Autowired(required = false)
    INoticeService service;



    /**
     * <p>查询公告方法</P>
     *
     * @author goupc1@belink.com
     * @version 0.0.1
     * @className basicCenterApplication
     * @sine 2020/8/17 9:15
     */

    @Override
    public MagicOutDTO<QueryNoticeInfoOutDTO> queryNoticeList(MagicDTO<QueryNoticeInfoInDTO> requestDTO) {

        System.out.println(requestDTO + ")==========================queryNoticeList=======================11================");
        System.out.println(requestDTO.getBody());
        MagicOutDTO<QueryNoticeInfoOutDTO> result = new MagicOutDTO<>();
        QueryNoticeDTO queryNoticeDTO = new QueryNoticeDTO();

        QueryNoticeInfoInDTO body = requestDTO.getBody();

        queryNoticeDTO.setNiNtcCreator(body.getNiNtcCreator());

        queryNoticeDTO.setNiNtcId(body.getNiNtcId());

        queryNoticeDTO.setNiNtcName(body.getNiNtcName());

        queryNoticeDTO.setNiNtcStatus(body.getNiNtcStatus());

        queryNoticeDTO.setNiNtcStartTime(body.getNiNtcStartTime());

        queryNoticeDTO.setNiNtcEndTime(body.getNiNtcEndTime());
        if(body.getCurrentPage()>=0){
            queryNoticeDTO.setNowsPage(((body.getCurrentPage() - 1) * body.getTurnPageShowNum()));

            queryNoticeDTO.setPageSize(body.getTurnPageShowNum());

        }

        List<QueryNoticeOutDTO> queryNoticeOutDTOS = service.queryNotice(queryNoticeDTO);

        RespHeader respHeader = new RespHeader();
        if (!queryNoticeOutDTOS.isEmpty()) {
            List<QueryNoticeOutDTO> totalNotices=null;
            if(queryNoticeDTO.getNowsPage()>=0){
                queryNoticeDTO.setPageSize(null);
                 totalNotices = service.queryNotice(queryNoticeDTO);
            }
            QueryNoticeInfoOutDTO outDTOd = new QueryNoticeInfoOutDTO();
            respHeader.setErrorCode(BasicErrorEnum.SUCCESS.code());
            respHeader.setErrorMsg(BasicErrorEnum.SUCCESS.msg());
            if(totalNotices!=null) {
                outDTOd.setTurnPageTotalNum(totalNotices.size());
            }
            outDTOd.setData(queryNoticeOutDTOS);
            result.setBody(outDTOd);
        } else {
            respHeader.setErrorCode(BasicErrorEnum.QFAIL.code());
            respHeader.setErrorMsg(BasicErrorEnum.QFAIL.msg());
        }
        result.setHeader(respHeader);
        return result;
    }



    @Override
    public MagicOutDTO<AddNoticeInfoOutDTO> addNoticeInfo(MagicDTO<AddNoticeInfoInDTO> requestDTO) {
        //定义输出
        AddNoticeInfoOutDTO addNoticeDTO = new AddNoticeInfoOutDTO();
        MagicOutDTO<AddNoticeInfoOutDTO> magicOutDTO = new MagicOutDTO<>(addNoticeDTO);
        RespHeader respHead = new RespHeader();
        //请求头
        ReqHeader reqHead = requestDTO.getHeader();
        AddNoticeInfoInDTO body = requestDTO.getBody();
        AddNoticeInfoOutDTO addNoticeInfoOutDTO = service.addNotice(body);
        Integer rows = addNoticeInfoOutDTO.getTotal();
        if (rows>=1){
            respHead.setErrorCode(BasicErrorEnum.SUCCESS.code());
            respHead.setErrorMsg(BasicErrorEnum.SUCCESS.msg());
            magicOutDTO.setBody(addNoticeInfoOutDTO);
        }else{
            respHead.setErrorCode(BasicErrorEnum.IFAIL.code());
            respHead.setErrorMsg(BasicErrorEnum.IFAIL.msg());
        }
        magicOutDTO.setHeader(respHead);
        return magicOutDTO;

    }

    /**
     * 修改公告管理列表
     * @param requestDTO
     * @return
     */
    @Override
    public MagicOutDTO<UpdateNoticeInfoOutDTO> updateNotice(MagicDTO<QueryNoticeInfoInDTO> requestDTO) {
        //1.返回DTO构造
        UpdateNoticeInfoOutDTO appNoticeOutDTO = new UpdateNoticeInfoOutDTO();
        MagicOutDTO<UpdateNoticeInfoOutDTO> magicOutDTO = new MagicOutDTO<>();
        //2.获取请求数据
        QueryNoticeInfoInDTO body = requestDTO.getBody();
        //3.1构建实体对象
        QueryNoticeDTO updateNoticeDTO = new QueryNoticeDTO();
        updateNoticeDTO.setNiNtcId(body.getNiNtcId())
                .setNiNtcName(body.getNiNtcName())
                .setNiNtcText(body.getNiNtcText())
                .setNiNtcCount(body.getNiNtcCount())
                .setNiNtcEndTime(body.getNiNtcEndTime())
                .setNiNtcStartTime(body.getNiNtcStartTime())
                .setNiNtcStatus(body.getNiNtcStatus());
        QueryNoticeOutDTO queryNoticeOutDTO = service.updateNotice(updateNoticeDTO);
        RespHeader respHeader = new RespHeader();
        if(queryNoticeOutDTO !=null){
            respHeader.setErrorCode(BasicErrorEnum.SUCCESS.code());
            respHeader.setErrorMsg(BasicErrorEnum.SUCCESS.msg());
            appNoticeOutDTO.setNiNtcName(updateNoticeDTO.getNiNtcName())
                    .setNiNtcText(updateNoticeDTO.getNiNtcText())
                    .setNiNtcRemindStatus(updateNoticeDTO.getNiNtcStatus())
                    .setNiNtcCount(updateNoticeDTO.getNiNtcCount())
                    .setNiNtcStartTime(updateNoticeDTO.getNiNtcStartTime())
                    .setNiNtcEndTime(updateNoticeDTO.getNiNtcEndTime());
            magicOutDTO.setBody(appNoticeOutDTO);
        }else {
            respHeader.setErrorCode(BasicErrorEnum.CFAIL.code());
            respHeader.setErrorMsg(BasicErrorEnum.CFAIL.msg());
        }
        magicOutDTO.setHeader(respHeader);
        return magicOutDTO;
    }




    @Override
    public MagicOutDTO<QueryNoticeInfoOutDTO> changeNoticeStatus(MagicDTO<QueryNoticeInfoInDTO> requestDTO) {
        QueryNoticeInfoOutDTO queryNoticeInfoOutDTO = new QueryNoticeInfoOutDTO();
        MagicOutDTO<QueryNoticeInfoOutDTO> magicOutDTO = new MagicOutDTO<>(queryNoticeInfoOutDTO);

        RespHeader respHeader = new RespHeader();
        QueryNoticeInfoInDTO body = requestDTO.getBody();

        QueryNoticeOutDTO changeNoticeStatus = service.changeNoticeStatus(body);

        int i = changeNoticeStatus.getNiNtcCount();
        if(i > 0){
            respHeader.setErrorCode(BasicErrorEnum.SUCCESS.code());
            respHeader.setErrorMsg(BasicErrorEnum.SUCCESS.msg());
        }else {
            respHeader.setErrorCode(BasicErrorEnum.FAIL.code());
            respHeader.setErrorMsg(BasicErrorEnum.FAIL.msg());
        }
        magicOutDTO.setHeader(respHeader);
        return magicOutDTO;
    }


}
