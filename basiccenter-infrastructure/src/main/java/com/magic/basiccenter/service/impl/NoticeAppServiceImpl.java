package com.magic.basiccenter.service.impl;

import com.gift.domain.sequence.factory.SequenceFactory;
import com.magic.basiccenter.constants.Constant;
import com.magic.basiccenter.dto.AddNoticeInfoInDTO;
import com.magic.basiccenter.dto.AddNoticeInfoOutDTO;

import com.magic.basiccenter.dto.QueryNoticeInfoDTO;

import com.magic.basiccenter.dto.entity.NoticeBean;
import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.dto.QueryNoticeOutDTO;
import com.magic.basiccenter.model.entity.BsNoticeInf;
import com.magic.basiccenter.model.service.IBsNoticeInfService;
import com.magic.basiccenter.model.service.NoticeAppService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;



/**
 * @author ：goupc1@belink.com
 * @date ：Created in 2020/8/620 9:54
 * @description：  数据层service实现类
 * @modified By：
 * @version: $1.0.0
 */

@Service
public class NoticeAppServiceImpl implements NoticeAppService {


    /**
     * 获取序列id工具类
     *
     */
    @Autowired(required = false)
    SequenceFactory sequenceFactory;
    /**
     * 数据交互层服务IBsNoticeInfService接口
     *
     */
    @Autowired(required = false)
    IBsNoticeInfService iBService;
    /**
     * 查询公告方法
     * @param inputDTO
     * @return
     */
    @Override
    public List<NoticeBean> queryNotice(QueryNoticeDTO inputDTO) {
        List<NoticeBean> cuNoticeInfs =iBService.selectNotice(inputDTO);
        return cuNoticeInfs;

    }


    /**
     * 新增公告方法
     * @param inputDTO
     * @return
     */

    @Override
    public AddNoticeInfoOutDTO addNotice(AddNoticeInfoInDTO inputDTO) {
        AddNoticeInfoOutDTO addNoticeInfoOutDTO = new AddNoticeInfoOutDTO();
        BsNoticeInf bsNoticeInf = new BsNoticeInf();
        //DTO转换为entity
        BeanUtils.copyProperties(inputDTO, bsNoticeInf);
        String noticeId = sequenceFactory.getSegmentDateId(Constant.CU_NOTICE_ID);
        bsNoticeInf.setNiNtcId(noticeId);
        bsNoticeInf.setNiNtcGmtCreate(new Date());
        boolean flag = iBService.save(bsNoticeInf);
        addNoticeInfoOutDTO.setFlag(flag);
        return addNoticeInfoOutDTO;
    }



    /**
     * 公告删除和上下架方法
     * @param inputDTO
     * @return
     */


    @Override
    public QueryNoticeOutDTO changeNoticeStatus(QueryNoticeInfoDTO inputDTO) {
        QueryNoticeOutDTO changeNoticeStatus = new QueryNoticeOutDTO();
        BsNoticeInf bsNoticeInf = new BsNoticeInf();
        BeanUtils.copyProperties(inputDTO, bsNoticeInf);
        boolean update = iBService.updateById(bsNoticeInf);
        changeNoticeStatus.setUpdate(update);
        return changeNoticeStatus;
    }

    @Override
    public Integer queryNoticeTotalNum(QueryNoticeDTO queryNoticeDTO) {

             return iBService.queryNoticeTotalNum(queryNoticeDTO);
    }

    /**
     * 修改公告管理列表
     * @param requestDTO
     * @return
     */
    @Override
    public QueryNoticeOutDTO updateNotice(QueryNoticeDTO requestDTO) {
        QueryNoticeOutDTO outDTO = new QueryNoticeOutDTO();
        BsNoticeInf entity = new BsNoticeInf();
        entity.setNiNtcName(requestDTO.getNiNtcName())
                .setNiNtcId(requestDTO.getNiNtcId())
                .setNiNtcText(requestDTO.getNiNtcText())
                .setNiNtcCount(requestDTO.getNiNtcCount())
                .setNiNtcEndTime(requestDTO.getNiNtcEndTime())
                .setNiNtcStartTime(requestDTO.getNiNtcStartTime())
                .setNiNtcStatus(requestDTO.getNiNtcStatus());

        iBService.updateById(entity);

        BsNoticeInf notice = iBService.getById(requestDTO.getNiNtcId());

        outDTO.setNiNtcName(notice.getNiNtcName())
                .setNiNtcText(notice.getNiNtcText())
                .setNiNtcCount(notice.getNiNtcCount())
                .setNiNtcEndTime(notice.getNiNtcEndTime())
                .setNiNtcStartTime(notice.getNiNtcStartTime())
                .setNiNtcStatus(notice.getNiNtcStatus());
        return outDTO;
    }


}
