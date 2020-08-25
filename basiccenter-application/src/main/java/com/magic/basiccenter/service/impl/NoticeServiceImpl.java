package com.magic.basiccenter.service.impl;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.application.infrastructure.service.dto.data.ReqHeader;
import com.magic.application.infrastructure.service.dto.data.RespHeader;
import com.magic.basiccenter.dto.*;
import com.magic.basiccenter.error.BasicErrorEnum;
import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.dto.QueryNoticeOutDTO;
import com.magic.basiccenter.model.service.NoticeAppService;
import com.magic.basiccenter.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


 /**
 * @author ：goupc1@belink.com
 * @date ：Created in 2020/8/620 9:54
 * @description：   公告application层实现类
 * @modified By：
 * @version: $1.0.0
 */

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired(required = false)
    NoticeAppService service;


    /**
     * 公告查询
     * @param requestDTO
     * @return
     */
    @Override
    public MagicOutDTO<QueryNoticeInfoOutDTO> queryNoticeList(MagicDTO<QueryNoticeInfoDTO> requestDTO) {

        MagicOutDTO<QueryNoticeInfoOutDTO> result = new MagicOutDTO<>();
        QueryNoticeDTO queryNoticeDTO = new QueryNoticeDTO();

        QueryNoticeInfoDTO body = requestDTO.getBody();

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

    /**
     * 公告新增
     * @param requestDTO
     * @return
     */
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
        //判断执行结果
        if (rows!=null && rows>0){
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
     * 公告编辑
     * @param requestDTO
     * @return
     */

    @Override
    public MagicOutDTO<UpdateNoticeInfoOutDTO> updateNotice(MagicDTO<QueryNoticeInfoDTO> requestDTO) {
        //1.返回DTO构造
        UpdateNoticeInfoOutDTO appNoticeOutDTO = new UpdateNoticeInfoOutDTO();
        MagicOutDTO<UpdateNoticeInfoOutDTO> magicOutDTO = new MagicOutDTO<>();
        //2.获取请求数据
        QueryNoticeInfoDTO body = requestDTO.getBody();
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


    /**
     * 公告删除与上下架
     * @param requestDTO
     * @return
     */

    @Override
    public MagicOutDTO<QueryNoticeInfoOutDTO> changeNoticeStatus(MagicDTO<QueryNoticeInfoDTO> requestDTO) {
        QueryNoticeInfoOutDTO queryNoticeInfoOutDTO = new QueryNoticeInfoOutDTO();
        MagicOutDTO<QueryNoticeInfoOutDTO> magicOutDTO = new MagicOutDTO<>(queryNoticeInfoOutDTO);

        RespHeader respHeader = new RespHeader();
        QueryNoticeInfoDTO body = requestDTO.getBody();

        QueryNoticeOutDTO changeNoticeStatus = service.changeNoticeStatus(body);

        int i = changeNoticeStatus.getNiNtcCount();
        if(i > 0){
            respHeader.setErrorCode(BasicErrorEnum.SUCCESS.code());
            respHeader.setErrorMsg(BasicErrorEnum.SUCCESS.msg());
        }else {
            respHeader.setErrorCode(BasicErrorEnum.DFAIL.code());
            respHeader.setErrorMsg(BasicErrorEnum.DFAIL.msg());
        }
        magicOutDTO.setHeader(respHeader);
        return magicOutDTO;
    }


}
