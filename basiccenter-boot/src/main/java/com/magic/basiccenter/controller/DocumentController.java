package com.magic.basiccenter.controller;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.*;
import com.magic.basiccenter.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 文档管理控制器
 * </P>
 *
 * @author zhuzh@belink.com
 * @version 0.0.1
 * @className DocumentController
 * @sine 2020/8/25 8:38
 */
@RestController
public class DocumentController {

	@Autowired
	DocumentService documentService;

	/**
	 * 文档回显
	 * 
	 * @param requestDTO
	 * @return
	 */
	@PostMapping("/document/queryData")
	public MagicOutDTO<DocumentFacadeDTO> queryData(@RequestBody MagicDTO<DocumentFacadeIdDTO> requestDTO) {
		return documentService.queryData(requestDTO);
	}

	/**
	 * 文档修改
	 * 
	 * @param requestDTO
	 * @return
	 */
	@PostMapping("/document/modify")
	public MagicOutDTO<DocumentFacadeStateDTO> queryModify(@RequestBody MagicDTO<DocumentFacadeDTO> requestDTO) {
		return documentService.queryModify(requestDTO);
	}

	/**
	 * 文档上架
	 * 
	 * @param requestDTO
	 * @return
	 */
	@PostMapping("/document/upShelf")
	public MagicOutDTO<DocumentFacadeStateDTO> upShelf(@RequestBody MagicDTO<DocumentFacadeInputDTO> requestDTO) {
		return documentService.publish(requestDTO);
	}

	/**
	 * 文档下架
	 * 
	 * @param requestDTO
	 * @return
	 */
	@PostMapping("/document/downShelf")
	public MagicOutDTO<DocumentFacadeStateDTO> downShelf(@RequestBody MagicDTO<DocumentFacadeInputDTO> requestDTO) {
		return documentService.publish(requestDTO);
	}

	/**
	 * 文档删除
	 * 
	 * @param requestDTO
	 * @return
	 */
	@PostMapping("/document/remove")
	public MagicOutDTO<DocumentFacadeStateDTO> delete(@RequestBody MagicDTO<DocumentFacadeIdDTO> requestDTO) {
		return documentService.delete(requestDTO);
	}

	/**
	 * 查询文档列表
	 * 
	 * @param requestDTO
	 * @return
	 */
	@PostMapping("document/queryDocumentList")
	public MagicOutDTO<QueryDocumentListOutDTO> queryDocumentList(
			@RequestBody MagicDTO<QueryDocumentListDTO> requestDTO) {
		return documentService.queryDocumentList(requestDTO);
	}

	/**
	 * 新增
	 * 
	 * @param requestDTO
	 * @return
	 */
	@PostMapping("/document/addDocumentState")
	public MagicOutDTO<DocumentFacadeStateDTO> addDocumentState(@RequestBody MagicDTO<DocumentFacadeDTO> requestDTO) {
		return documentService.addDocumentState(requestDTO);
	}
}
