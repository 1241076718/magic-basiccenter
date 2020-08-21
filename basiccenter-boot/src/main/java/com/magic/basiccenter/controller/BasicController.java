package com.magic.basiccenter.controller;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.*;
import com.magic.basiccenter.model.entity.DocumentEntity;
import com.magic.basiccenter.service.ModifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/cst")
public class BasicController {
    @Autowired
    ModifyService basicService;

    /**
     * 文档回显
     * @param requestDTO
     * @return
     */
    @PostMapping("/doucment/queryData")
    public MagicOutDTO<DocumentFacadeDto> queryData(@RequestBody MagicDTO<DocumentFacadeIdDto> requestDTO){
        return basicService.queryData(requestDTO);
    }

    /**
     * 文档修改
     * @param requestDTO
     * @return
     */
    @PostMapping("/doucment/modify")
    public MagicOutDTO<DocmentFacadeUpdataDto> queryModify(@RequestBody MagicDTO<DocumentFacadeDto> requestDTO){
        return basicService.queryModify(requestDTO);
    }

    /**
     * 文档上架
     * @param requestDTO
     * @return
     */
    @PostMapping("/doucment/upShelf")
    public MagicOutDTO<DocumentFacadeOutDTO> upShelf( @RequestBody MagicDTO<DocumentFacadeInputDto> requestDTO){
        return basicService.publish(requestDTO);
    }
    /**
     * 文档下架
     * @param requestDTO
     * @return
     */
    @PostMapping("/doucment/downShelf")
    public MagicOutDTO<DocumentFacadeOutDTO> downShelf(@RequestBody MagicDTO<DocumentFacadeInputDto> requestDTO){
        return basicService.publish(requestDTO);
    }

    /**
     * 文档删除
     * @param requestDTO
     * @return
     */
    @PostMapping("/doucment/remove")
    public MagicOutDTO<DocmentFacadeUpdataDto> delete (@RequestBody MagicDTO<DocumentFacadeIdDto> requestDTO){
        return basicService.delete(requestDTO);
    }
    /**
     * 查询文档列表
     * @param requestDTO
     * @return
     */
    @PostMapping("document/queryDocumentList")
    public MagicOutDTO<QueryDocumentListOutDTO> queryDocumentList(@RequestBody MagicDTO<QueryDocumentListDTO> requestDTO){
        return basicService.queryDocumentList(requestDTO);
    }

    /**
     * 新增
     * @param requestDTO
     * @return
     */
    @PostMapping("/document/addDocumentState")
    public MagicOutDTO<DocmentFacadeUpdataDto> addDocumentState(@RequestBody MagicDTO<DocumentFacadeDto> requestDTO){
        return basicService.addDocumentState(requestDTO);
    }
}
