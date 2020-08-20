package com.magic.basiccenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.AppNoticeStateDTO;
import com.magic.basiccenter.dto.AppNoticeStateOutDTO;
import com.magic.basiccenter.service.IBasicUpdateNoticeService;

/**
 * <p>基础中心--控制器</P>
 *
 * @author zhuzh@belink.com
 * @version 0.0.1
 * @className basicController
 * @sine 2020/8/17 9:13
 */
@RequestMapping("basic")
@RestController
public class BasicUpdateNoticeController {
	@Autowired
	private IBasicUpdateNoticeService updateNoticeService;
	/**
	 * 根据主键id查询数据
	 * @return
	 */
	@PostMapping("/notice/selectById")
	public MagicOutDTO<AppNoticeStateOutDTO> selectNoticeById(@RequestBody MagicDTO<AppNoticeStateDTO> requestDTO) {
		return updateNoticeService.selectNoticeById(requestDTO);
	}
	
	/**
	 * 修改数据返回
	 * @param requestDTO
	 * @return
	 */
	@PostMapping("/notice/updateNotice")
	public MagicOutDTO<AppNoticeStateOutDTO> updateNoticeData(@RequestBody MagicDTO<AppNoticeStateDTO> requestDTO) {
		return updateNoticeService.updateNotice(requestDTO);
	}
}
