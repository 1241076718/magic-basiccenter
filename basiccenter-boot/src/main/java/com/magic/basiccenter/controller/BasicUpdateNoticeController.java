package com.magic.basiccenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoInDTO;
import com.magic.basiccenter.dto.UpdateNoticeInfoOutDTO;
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
	 * 修改数据返回
	 * @param requestDTO
	 * @return
	 */
	@PostMapping("/notice/updateNotice")
	public MagicOutDTO<UpdateNoticeInfoOutDTO> updateNoticeData(@RequestBody MagicDTO<QueryNoticeInfoInDTO> requestDTO) {
		return updateNoticeService.updateNotice(requestDTO);
	}
}
