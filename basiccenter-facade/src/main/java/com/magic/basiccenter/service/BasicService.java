package com.magic.basiccenter.service;



import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.*;

/**
 * 前端接口
 */

public interface BasicService {
    /**
     * 文档数据回显
     * @param requestDTO
     * @return
     */
    MagicOutDTO<DocumentFacadeDTO> queryData(MagicDTO<DocumentFacadeIdDTO> requestDTO);

    /**
     * 文档数据修改
     * @param requestDTO
     * @return
     */
    MagicOutDTO<DocmentFacadeUpdataDTO> queryModify(MagicDTO<DocumentFacadeDTO> requestDTO);

    /**
     * 文档发布
     * @param requestDTO
     * @return
     */
    MagicOutDTO<DocumentFacadeOutDTO> publish(MagicDTO<DocumentFacadeInputDTO> requestDTO);

    /**
     * 文档删除
     * @param requestDTO
     * @return
     */
    MagicOutDTO<DocmentFacadeUpdataDTO> delete (MagicDTO<DocumentFacadeIdDTO> requestDTO);
    /**
     * 查询文档列表
     * @param requestDTO
     * @return
     */

    MagicOutDTO<QueryDocumentListOutDTO> queryDocumentList(MagicDTO<QueryDocumentListDTO> requestDTO);

    /**
     * 新增文档状态
     * @param requestDTO
     * @return
     */
    MagicOutDTO<DocmentFacadeUpdataDTO> addDocumentState(MagicDTO<DocumentFacadeDTO> requestDTO);


}
