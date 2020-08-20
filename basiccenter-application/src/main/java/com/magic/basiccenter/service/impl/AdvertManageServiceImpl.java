package com.magic.basiccenter.service.impl;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.application.infrastructure.service.dto.data.RespHeader;
import com.magic.basiccenter.dto.AdvertAddDTO;
import com.magic.basiccenter.dto.AdvertAddOutDTO;
import com.magic.basiccenter.dto.DelAdvertDTO;
import com.magic.basiccenter.dto.DelAdvertOutDTO;
import com.magic.basiccenter.error.AdvertErrorEnum;
import com.magic.basiccenter.model.dto.AddAdvertInfoDTO;
import com.magic.basiccenter.model.dto.AddAdvertInfoOutDTO;
import com.magic.basiccenter.model.dto.DelAdvertInfoDTO;
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
     */
    @Override
    public MagicOutDTO<AdvertAddOutDTO> addAdvertInfo(MagicDTO<AdvertAddDTO> requestDTO) {
        AdvertAddOutDTO outData = new AdvertAddOutDTO();
        MagicOutDTO<AdvertAddOutDTO> magicOutDTO = new MagicOutDTO<>(outData);

        RespHeader respHeader = new RespHeader();
        magicOutDTO.setHeader(respHeader);

        try {
            //int aiAdvId = requestDTO.getBody().getAiAdvId();
            AddAdvertInfoDTO addAdvertInfoDTO = new AddAdvertInfoDTO();
            BeanUtils.copyProperties(requestDTO.getBody(), addAdvertInfoDTO);
            AddAdvertInfoOutDTO addAdvertInfoOutDTO = advertService.addAdvertInfo(addAdvertInfoDTO);
            BeanUtils.copyProperties(addAdvertInfoOutDTO, outData);
            respHeader.setErrorCode(AdvertErrorEnum.SUCCESS.code());
            respHeader.setErrorMsg(AdvertErrorEnum.SUCCESS.msg());
        } catch (Exception e) {
            e.printStackTrace();
            respHeader.setErrorCode("-1");
            respHeader.setErrorMsg(e.getMessage());
        }

        return magicOutDTO;
    }

	@Override
	public MagicOutDTO<DelAdvertOutDTO>deleteAdvert(MagicDTO<DelAdvertDTO> dto) {
		DelAdvertOutDTO bodyDTO=new DelAdvertOutDTO();
		MagicOutDTO<DelAdvertOutDTO> magicOutDTO = new MagicOutDTO<>(bodyDTO);
		RespHeader header = new RespHeader();
		magicOutDTO.setHeader(header);
		try{
			Integer advId = dto.getBody().getAiAdvId();
			DelAdvertInfoDTO advertNoticeDTO = new DelAdvertInfoDTO();
			advertNoticeDTO.setAiAdvId(advId);
			advertService.deleteAdvert(advertNoticeDTO);
			header.setErrorCode(AdvertErrorEnum.SUCCESS.code());
			header.setErrorMsg(AdvertErrorEnum.SUCCESS.msg());
		}catch(Exception e){
			e.getStackTrace();
			header.setErrorCode("-1");
			header.setErrorMsg(e.getMessage());
		}
		return magicOutDTO;
	}

	
}
