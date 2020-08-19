package com.magic.basiccenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.FestivalModifyDTO;
import com.magic.basiccenter.dto.FestivalModifyOutDTO;
import com.magic.basiccenter.service.impl.FestivalDateChackServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>基础中心--控制器</P>
 *
 * @author zhuzh@belink.com
 * @version 0.0.1
 * @className basicController
 * @sine 2020/8/17 9:13
 */

@RestController
@Slf4j
@RequestMapping("Festival-manage")
public class FestivalServiceController {
	@Autowired
	private FestivalDateChackServiceImpl festivalServiceImpl;
	/**
	 * 节假日管理--修改
	 */
	@PostMapping("/modify")
	public MagicOutDTO<FestivalModifyOutDTO> festivalManageModify(@RequestBody MagicDTO<FestivalModifyDTO> magicDTO){
		return festivalServiceImpl.FestivalDateChack(magicDTO);
	}
}
