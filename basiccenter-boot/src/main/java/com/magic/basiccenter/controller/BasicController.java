package com.magic.basiccenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.AdvertSelDTO;
import com.magic.basiccenter.dto.AdvertSelOutPageDTO;
import com.magic.basiccenter.service.IAdvertSelCond;


/**
 * <p>基础中心--控制器</P>
 *
 * @author zhuzh@belink.com
 * @version 0.0.1
 * @className basicController
 * @sine 2020/8/17 9:13
 */
@RestController
@RequestMapping("advert")
public class BasicController {
	
	@Autowired
	private IAdvertSelCond advertSelCond;
	
	@PostMapping("advertSelCond")
	public MagicOutDTO<AdvertSelOutPageDTO> advertSelCond(@RequestBody MagicDTO<AdvertSelDTO> requestDTO){
		return advertSelCond.advertSelCond(requestDTO);
	}
	
	@GetMapping("test")
	public String testC(String hello) {
		return hello;
	}
	
}
