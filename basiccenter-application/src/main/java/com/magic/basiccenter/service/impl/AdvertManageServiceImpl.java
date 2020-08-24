package com.magic.basiccenter.service.impl;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.application.infrastructure.service.dto.data.ReqHeader;
import com.magic.application.infrastructure.service.dto.data.RespHeader;
import com.magic.application.infrastructure.utils.ApplicationServiceUtil;
import com.magic.basiccenter.dto.AdvertAddDTO;
import com.magic.basiccenter.dto.AdvertAddOutDTO;
import com.magic.basiccenter.dto.AdvertSelPageDTO;
import com.magic.basiccenter.dto.AdvertSelPageOutDTO;
import com.magic.basiccenter.dto.AdvertUpdDTO;
import com.magic.basiccenter.dto.AdvertUpdOutDTO;
import com.magic.basiccenter.dto.AdvertDelDTO;
import com.magic.basiccenter.dto.AdvertDelOutDTO;
import com.magic.basiccenter.error.AdvertErrorEnum;
import com.magic.basiccenter.model.dto.AddAdvertInfoDTO;
import com.magic.basiccenter.model.dto.AddAdvertInfoOutDTO;
import com.magic.basiccenter.model.dto.DelAdvertInfoDTO;
import com.magic.basiccenter.model.dto.SelAdvertInfoPageDTO;
import com.magic.basiccenter.model.dto.SelAdvertInfoPageOutDTO;
import com.magic.basiccenter.model.dto.UpdAdvertInfoDTO;
import com.magic.basiccenter.model.dto.UpdAdvertInfoOutDTO;
import com.magic.basiccenter.model.service.IAdvertService;
import com.magic.basiccenter.service.IAdvertManageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>广告管理接口实现类</P>
 *
 * @author laiqx@belink.com
 * @version 0.0.1
 * @className AdvertManageServiceImpl
 * @sine 2020/8/19 10:18
 */
@Service
public class AdvertManageServiceImpl implements IAdvertManageService {
    /**
     * 广告配置表数据交互服务
     */
    @Autowired
    private IAdvertService advertService;

    /**
     * 广告配置新增
     * @param requestDTO
     * @return
     * @author laiqx@belink.com
     */
    @Override
    public MagicOutDTO<AdvertAddOutDTO> addAdvertInfo(MagicDTO<AdvertAddDTO> requestDTO) {
        AdvertAddOutDTO outData = new AdvertAddOutDTO();
        MagicOutDTO<AdvertAddOutDTO> magicOutDTO = new MagicOutDTO<>(outData);

        RespHeader respHeader = new RespHeader();
        magicOutDTO.setHeader(respHeader);

        try {
            AddAdvertInfoDTO addAdvertInfoDTO = new AddAdvertInfoDTO();
            BeanUtils.copyProperties(requestDTO.getBody(), addAdvertInfoDTO);
            AddAdvertInfoOutDTO addAdvertInfoOutDTO = advertService.addAdvertInfo(addAdvertInfoDTO);
            BeanUtils.copyProperties(addAdvertInfoOutDTO, outData);
            respHeader.setErrorCode(AdvertErrorEnum.SUCCESS.code());
            respHeader.setErrorMsg(AdvertErrorEnum.SUCCESS.msg());
        } catch (Exception e) {
            e.printStackTrace();
            respHeader.setErrorCode(AdvertErrorEnum.ADDFAIL.code());
            respHeader.setErrorMsg(AdvertErrorEnum.ADDFAIL.msg());
        }

        return magicOutDTO;
    }

    /**
     * 广告列表查询
     * @param requestDTO
     * @return
     * @author jianggq@belink.com
     */
    @Override
    public MagicOutDTO<AdvertSelPageOutDTO> advertSelCond(MagicDTO<AdvertSelPageDTO> requestDTO) {
        //定义出参
        AdvertSelPageOutDTO advertSelOutPageDTO = new AdvertSelPageOutDTO();
        MagicOutDTO<AdvertSelPageOutDTO> magicOutDTO = new MagicOutDTO<>(advertSelOutPageDTO);

        //定义返回头
        RespHeader respHeader = new RespHeader();
        magicOutDTO.setHeader(respHeader);

        //获取请求头
        ReqHeader reqHead = requestDTO.getHeader();

        //转换请求DTO
        AdvertSelPageDTO reqBody = requestDTO.getBody();
        SelAdvertInfoPageDTO selAdvertInfoPageDTO = new SelAdvertInfoPageDTO();
        BeanUtils.copyProperties(reqBody,selAdvertInfoPageDTO);

        try {
            //执行查询
            SelAdvertInfoPageOutDTO selAdvertInfoPageOutDTO = advertService.advertSelPageCond(selAdvertInfoPageDTO);
            //转换返回DTO
            BeanUtils.copyProperties(selAdvertInfoPageOutDTO,advertSelOutPageDTO);
            //封装返回的数据
            respHeader.setErrorCode(AdvertErrorEnum.SUCCESS.code());
            respHeader.setErrorMsg(AdvertErrorEnum.SUCCESS.msg());
            magicOutDTO.setBody(advertSelOutPageDTO);
            ApplicationServiceUtil.supplementaryRespHeader(reqHead, respHeader);
        } catch (Exception e) {
            e.printStackTrace();
            respHeader.setErrorCode(AdvertErrorEnum.SELFAIL.code());
            respHeader.setErrorMsg(AdvertErrorEnum.SELFAIL.msg());
        }
        return magicOutDTO;
    }

    /**
     * 通过主键id删除广告
     * @param requestDTO
     * @return
     * @author tangw@belink.com
     */
	@Override
	public MagicOutDTO<AdvertDelOutDTO> delAdvertInfo(MagicDTO<AdvertDelDTO> requestDTO) {
		AdvertDelOutDTO delOutDTO = new AdvertDelOutDTO();
        MagicOutDTO<AdvertDelOutDTO> magicOutDTO = new MagicOutDTO<>(delOutDTO);
        RespHeader respHeader = new RespHeader();
        magicOutDTO.setHeader(respHeader);
		try{
			String advId = requestDTO.getBody().getAiAdvId();
			DelAdvertInfoDTO delAdvertInfoDTO = new DelAdvertInfoDTO();
            delAdvertInfoDTO.setAiAdvId(advId);
			advertService.delAdvertInfo(delAdvertInfoDTO);
            respHeader.setErrorCode(AdvertErrorEnum.SUCCESS.code());
            respHeader.setErrorMsg(AdvertErrorEnum.SUCCESS.msg());
		} catch (Exception e) {
			e.getStackTrace();
            respHeader.setErrorCode(AdvertErrorEnum.DELFAIL.code());
            respHeader.setErrorMsg(AdvertErrorEnum.DELFAIL.msg());
		}
		return magicOutDTO;
	}

    /**
     * 广告配置修改
     * @param requestDTO
     * @return
     * @author luolf@belink.com
     */
    @Override
    public MagicOutDTO<AdvertUpdOutDTO> updAdvertInfo(MagicDTO<AdvertUpdDTO> requestDTO) {
        AdvertUpdOutDTO updOutData = new AdvertUpdOutDTO();
        MagicOutDTO<AdvertUpdOutDTO> magicOutDTO = new MagicOutDTO<>(updOutData);

        RespHeader respHeader = new RespHeader();
        magicOutDTO.setHeader(respHeader);

        try {
            UpdAdvertInfoDTO updAdvertInfoDTO = new UpdAdvertInfoDTO();
            BeanUtils.copyProperties(requestDTO.getBody(), updAdvertInfoDTO);
            UpdAdvertInfoOutDTO updAdvertInfoOutDTO = advertService.updAdvertInfo(updAdvertInfoDTO);
            BeanUtils.copyProperties(updAdvertInfoOutDTO, updOutData);
            respHeader.setErrorCode(AdvertErrorEnum.SUCCESS.code());
            respHeader.setErrorMsg(AdvertErrorEnum.SUCCESS.msg());
        } catch (Exception e) {
            e.printStackTrace();
            Integer advertStatus = requestDTO.getBody().getAiAdvStatus();
            if (1 == advertStatus) {
                respHeader.setErrorCode(AdvertErrorEnum.PUTFAIL.code());
                respHeader.setErrorMsg(AdvertErrorEnum.PUTFAIL.msg());
            } else if (2 == advertStatus) {
                respHeader.setErrorCode(AdvertErrorEnum.SOLDFAIL.code());
                respHeader.setErrorMsg(AdvertErrorEnum.SOLDFAIL.msg());
            } else {
                respHeader.setErrorCode(AdvertErrorEnum.UPDFAIL.code());
                respHeader.setErrorMsg(AdvertErrorEnum.UPDFAIL.msg());
            }
        }

        return magicOutDTO;
    }

}
