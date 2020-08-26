package com.magic.basiccenter.service.impl;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.application.infrastructure.service.dto.data.ReqHeader;
import com.magic.application.infrastructure.service.dto.data.RespHeader;
import com.magic.basiccenter.dto.*;
import com.magic.basiccenter.dto.entity.NoticeBean;
import com.magic.basiccenter.error.NoticeErrorEnum;
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
     * @return MagicOutDTO<QueryNoticeInfoOutDTO>
     * @author goupc1@belink.com
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

       List<NoticeBean> queryNoticeOutDTOS = service.queryNotice(queryNoticeDTO);

       RespHeader respHeader = new RespHeader();
       if (!queryNoticeOutDTOS.isEmpty()) {
           Integer  totalNotices = service.queryNoticeTotalNum(queryNoticeDTO);
           QueryNoticeInfoOutDTO outDTOd = new QueryNoticeInfoOutDTO();
           respHeader.setErrorCode(NoticeErrorEnum.SUCCESS.code());
           respHeader.setErrorMsg(NoticeErrorEnum.SUCCESS.msg());
           if(totalNotices!=null) {
               outDTOd.setTurnPageTotalNum(totalNotices);
           }
           outDTOd.setData(queryNoticeOutDTOS);
           result.setBody(outDTOd);
       } else {
           respHeader.setErrorCode(NoticeErrorEnum.QFAIL.code());
           respHeader.setErrorMsg(NoticeErrorEnum.QFAIL.msg());
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
       Boolean flag = addNoticeInfoOutDTO.getFlag();
       //判断执行结果
       if (flag){
           respHead.setErrorCode(NoticeErrorEnum.SUCCESS.code());
           respHead.setErrorMsg(NoticeErrorEnum.SUCCESS.msg());
           magicOutDTO.setBody(addNoticeInfoOutDTO);
       }else{
           respHead.setErrorCode(NoticeErrorEnum.IFAIL.code());
           respHead.setErrorMsg(NoticeErrorEnum.IFAIL.msg());
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
               .setNiNtcRemindStatus(body.getNiNtcRemindStatus());
       QueryNoticeOutDTO queryNoticeOutDTO = service.updateNotice(updateNoticeDTO);
       RespHeader respHeader = new RespHeader();
       if(queryNoticeOutDTO !=null){
           respHeader.setErrorCode(NoticeErrorEnum.SUCCESS.code());
           respHeader.setErrorMsg(NoticeErrorEnum.SUCCESS.msg());
           appNoticeOutDTO.setNiNtcName(updateNoticeDTO.getNiNtcName())
                   .setNiNtcText(updateNoticeDTO.getNiNtcText())
                   .setNiNtcRemindStatus(updateNoticeDTO.getNiNtcRemindStatus())
                   .setNiNtcCount(updateNoticeDTO.getNiNtcCount())
                   .setNiNtcStartTime(updateNoticeDTO.getNiNtcStartTime())
                   .setNiNtcEndTime(updateNoticeDTO.getNiNtcEndTime());
           magicOutDTO.setBody(appNoticeOutDTO);
       }else {
           respHeader.setErrorCode(NoticeErrorEnum.CFAIL.code());
           respHeader.setErrorMsg(NoticeErrorEnum.CFAIL.msg());
       }
       magicOutDTO.setHeader(respHeader);
       return magicOutDTO;
   }



    /**
     * 通过主键id上下架、删除广告
     * @param requestDTO
     * @return magicOutDTO
     * @author kangjx1@belink.com
     */
   @Override
   public MagicOutDTO<AddNoticeInfoOutDTO> changeNoticeStatus(MagicDTO<AddNoticeInfoInDTO> requestDTO) {
       AddNoticeInfoOutDTO infoOutDTO = new AddNoticeInfoOutDTO();
       MagicOutDTO<AddNoticeInfoOutDTO> magicOutDTO = new MagicOutDTO<>(infoOutDTO);

       RespHeader respHeader = new RespHeader();
       AddNoticeInfoInDTO body = requestDTO.getBody();

       AddNoticeInfoOutDTO outDTO = service.changeNoticeStatus(body);

       Boolean update = outDTO.getUpdate();
       //判断是否更改
       if (update) {
           if (requestDTO.getBody().getNiNtcStatus() == 1) {
               //删除成功返回消息
               respHeader.setErrorCode(NoticeErrorEnum.SUCCESS.code());
               respHeader.setErrorMsg(NoticeErrorEnum.SUCCESS.msg());
           } else if (requestDTO.getBody().getNiNtcStatus() == 4) {
               //上架成功返回消息
               respHeader.setErrorCode(NoticeErrorEnum.SUCCESS.code());
               respHeader.setErrorMsg(NoticeErrorEnum.SUCCESS.msg());
           } else if (requestDTO.getBody().getNiNtcStatus() == 5) {
               //下架成功返回消息
               respHeader.setErrorCode(NoticeErrorEnum.SUCCESS.code());
               respHeader.setErrorMsg(NoticeErrorEnum.SUCCESS.msg());
           }
       } else {
           if (requestDTO.getBody().getNiNtcStatus() == 1) {
               //删除失败返回消息
               respHeader.setErrorCode(NoticeErrorEnum.DFAIL.code());
               respHeader.setErrorMsg(NoticeErrorEnum.DFAIL.msg());
           } else if (requestDTO.getBody().getNiNtcStatus() == 4) {
               //上架失败返回消息
               respHeader.setErrorCode(NoticeErrorEnum.UFAIL.code());
               respHeader.setErrorMsg(NoticeErrorEnum.UFAIL.msg());
           } else if (requestDTO.getBody().getNiNtcStatus() == 5) {
               //下架失败返回消息
               respHeader.setErrorCode(NoticeErrorEnum.SFATL.code());
               respHeader.setErrorMsg(NoticeErrorEnum.SFATL.msg());
           }
       }
           magicOutDTO.setHeader(respHeader);
           magicOutDTO.setBody(outDTO);
       return magicOutDTO;
       }

}
