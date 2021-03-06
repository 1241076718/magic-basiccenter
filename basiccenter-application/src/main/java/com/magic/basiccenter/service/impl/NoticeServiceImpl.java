package com.magic.basiccenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.application.infrastructure.service.dto.data.ReqHeader;
import com.magic.application.infrastructure.service.dto.data.RespHeader;
import com.magic.basiccenter.dto.AddNoticeInfoInDTO;
import com.magic.basiccenter.dto.AddNoticeInfoOutDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoOutDTO;
import com.magic.basiccenter.dto.UpdateNoticeInfoOutDTO;
import com.magic.basiccenter.dto.entity.NoticeBean;
import com.magic.basiccenter.error.NoticeErrorEnum;
import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.dto.QueryNoticeOutDTO;
import com.magic.basiccenter.model.service.NoticeAppService;
import com.magic.basiccenter.service.NoticeService;

import lombok.extern.slf4j.Slf4j;



/**
 * @author ：goupc1@belink.com
 * @date ：Created in 2020/8/620 9:54
 * @description： 公告application层实现类
 * @modified By：
 * @version: $1.0.0
 */

@Service
@Slf4j
public class NoticeServiceImpl implements NoticeService {

    @Autowired(required = false)
    NoticeAppService service;



    /**
     * 公告查询
     *
     * @param requestDTO
     * @return MagicOutDTO<QueryNoticeInfoOutDTO>
     * @author goupc1@belink.com
     */
    @Override
    public MagicOutDTO<QueryNoticeInfoOutDTO> queryNoticeList(MagicDTO<QueryNoticeInfoDTO> requestDTO) {
        //定义输出
        MagicOutDTO<QueryNoticeInfoOutDTO> result = new MagicOutDTO<>();
        QueryNoticeDTO queryNoticeDTO = new QueryNoticeDTO();
        RespHeader respHeader = new RespHeader();
        //获取请求数据
        ReqHeader reqHead = requestDTO.getHeader();
        QueryNoticeInfoDTO body = requestDTO.getBody();
        try {
            //定义查询数据
            queryNoticeDTO.setNiNtcCreator(body.getNiNtcCreator());

            queryNoticeDTO.setNiNtcId(body.getNiNtcId());

            queryNoticeDTO.setNiNtcName(body.getNiNtcName());

            queryNoticeDTO.setNiNtcStatus(body.getNiNtcStatus());

            queryNoticeDTO.setNiNtcStartTime(body.getNiNtcStartTime());

            queryNoticeDTO.setNiNtcEndTime(body.getNiNtcEndTime());

            if (body.getCurrentPage() > 0) {
                queryNoticeDTO.setNowsPage(((body.getCurrentPage() - 1) * body.getTurnPageShowNum()));
                queryNoticeDTO.setPageSize(body.getTurnPageShowNum());
            }
            //查询数据
            List<NoticeBean> queryNoticeOutDTOS = service.queryNotice(queryNoticeDTO);

            if (!queryNoticeOutDTOS.isEmpty()) {
                Integer totalNotices = service.queryNoticeTotalNum(queryNoticeDTO);
                //封装返回数据
                QueryNoticeInfoOutDTO outDTOd = new QueryNoticeInfoOutDTO();
                respHeader.setErrorCode(NoticeErrorEnum.SUCCESS.code());
                respHeader.setErrorMsg(NoticeErrorEnum.SUCCESS.msg());
                if (totalNotices != null) {
                    outDTOd.setTurnPageTotalNum(totalNotices);
                }
                outDTOd.setData(queryNoticeOutDTOS);
                result.setBody(outDTOd);
            } else if(queryNoticeOutDTOS.isEmpty()){
                respHeader.setErrorCode(NoticeErrorEnum.QNFAIL.code());
                respHeader.setErrorMsg(NoticeErrorEnum.QNFAIL.msg());
            }
            result.setHeader(respHeader);
            return result;

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            respHeader.setErrorCode(NoticeErrorEnum.FAIL.code());
            respHeader.setErrorMsg(NoticeErrorEnum.FAIL.msg());
            result.setHeader(respHeader);
            return result;
        }
    }

    /**
     * 公告新增
     *
     * @param requestDTO
     * @return
     */
    @Override
    public MagicOutDTO<AddNoticeInfoOutDTO> addNoticeInfo(MagicDTO<AddNoticeInfoInDTO> requestDTO) {
        //定义输出
        AddNoticeInfoOutDTO addNoticeDTO = new AddNoticeInfoOutDTO();
        MagicOutDTO<AddNoticeInfoOutDTO> magicOutDTO = new MagicOutDTO<>(addNoticeDTO);
        RespHeader respHead = new RespHeader();
       try {
           //请求头
           ReqHeader reqHead = requestDTO.getHeader();
           AddNoticeInfoInDTO body = requestDTO.getBody();
           AddNoticeInfoOutDTO addNoticeInfoOutDTO = service.addNotice(body);
           Boolean flag = addNoticeInfoOutDTO.getFlag();
           //判断执行结果
           if (flag) {
               respHead.setErrorCode(NoticeErrorEnum.SUCCESS.code());
               respHead.setErrorMsg(NoticeErrorEnum.SUCCESS.msg());
               magicOutDTO.setBody(addNoticeInfoOutDTO);
           } else {
               respHead.setErrorCode(NoticeErrorEnum.IFAIL.code());
               respHead.setErrorMsg(NoticeErrorEnum.IFAIL.msg());
           }
       }catch (Exception e){
               e.printStackTrace();
           respHead.setErrorCode(NoticeErrorEnum.FAIL.code());
           respHead.setErrorMsg(NoticeErrorEnum.FAIL.msg());
           }
        String errorMsg_addNotice = respHead.getErrorMsg();
        String errorCode_addNotice = respHead.getErrorCode();
        log.info("新增公告,errorMsg_addNotice{},errorCode_addNotice{}",errorMsg_addNotice,errorCode_addNotice);
        magicOutDTO.setHeader(respHead);
        return magicOutDTO;
    }


    /**
     * 公告编辑
     *
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
        System.out.println("测试1:"+body);
        //3构建实体对象
        QueryNoticeDTO updateNoticeDTO = new QueryNoticeDTO();
        updateNoticeDTO.setNiNtcId(body.getNiNtcId())
                .setNiNtcName(body.getNiNtcName())
                .setNiNtcText(body.getNiNtcText())
                .setNiNtcCount(body.getNiNtcCount())
                .setNiNtcEndTime(body.getNiNtcEndTime())
                .setNiNtcStartTime(body.getNiNtcStartTime())
                .setNiNtcRemindStatus(body.getNiNtcRemindStatus())
                .setNiNtcGmtModifier(body.getECIFID());
        System.out.println("测试:"+body.getECIFID());
        QueryNoticeOutDTO queryNoticeOutDTO = service.updateNotice(updateNoticeDTO);
        RespHeader respHeader = new RespHeader();
        if (queryNoticeOutDTO != null) {
            respHeader.setErrorCode(NoticeErrorEnum.SUCCESS.code());
            respHeader.setErrorMsg(NoticeErrorEnum.SUCCESS.msg());
            appNoticeOutDTO.setNiNtcName(updateNoticeDTO.getNiNtcName())
                    .setNiNtcText(updateNoticeDTO.getNiNtcText())
                    .setNiNtcRemindStatus(updateNoticeDTO.getNiNtcRemindStatus())
                    .setNiNtcCount(updateNoticeDTO.getNiNtcCount())
                    .setNiNtcStartTime(updateNoticeDTO.getNiNtcStartTime())
                    .setNiNtcEndTime(updateNoticeDTO.getNiNtcEndTime());
            magicOutDTO.setBody(appNoticeOutDTO);
        } else {
            respHeader.setErrorCode(NoticeErrorEnum.CFAIL.code());
            respHeader.setErrorMsg(NoticeErrorEnum.CFAIL.msg());
        }
        magicOutDTO.setHeader(respHeader);
        log.info("返回数据:{}", magicOutDTO);
        return magicOutDTO;
    }


    /**
     * 通过主键id上下架、删除广告
     *
     * @param requestDTO
     * @return magicOutDTO
     * @author kangjx1@belink.com
     */
    @Override
    public MagicOutDTO<AddNoticeInfoOutDTO> changeNoticeStatus(MagicDTO<AddNoticeInfoInDTO> requestDTO) {
        //定义出参
        AddNoticeInfoOutDTO infoOutDTO = new AddNoticeInfoOutDTO();
        MagicOutDTO<AddNoticeInfoOutDTO> magicOutDTO = new MagicOutDTO<>(infoOutDTO);
        //定义返回头
        RespHeader respHeader = new RespHeader();
        AddNoticeInfoInDTO body = requestDTO.getBody();
        AddNoticeInfoOutDTO outDTO = service.changeNoticeStatus(body);
        Boolean update = outDTO.getUpdate();

        try {
            //判断是否更改
            if (update) {
                //统一操作成功返回消息
                respHeader.setErrorCode(NoticeErrorEnum.SUCCESS.code());
                respHeader.setErrorMsg(NoticeErrorEnum.SUCCESS.msg());
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
            }catch(Exception e){
                //统一异常处理
                e.printStackTrace();
                respHeader.setErrorMsg(NoticeErrorEnum.FAIL.msg());
                respHeader.setErrorCode(NoticeErrorEnum.FAIL.code());
            }
        String errorMsg = respHeader.getErrorMsg();
        String errorCode = respHeader.getErrorCode();
        log.info("公告上下架和删除-日志打印：errorCode:{},errorMsg:{}",errorCode,errorMsg);
        magicOutDTO.setHeader(respHeader);
        magicOutDTO.setBody(outDTO);
        return magicOutDTO;
    }

}
