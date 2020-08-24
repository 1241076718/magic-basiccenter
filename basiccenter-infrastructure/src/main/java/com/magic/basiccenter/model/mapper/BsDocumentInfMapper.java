package com.magic.basiccenter.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.magic.basiccenter.model.entity.BsDocumentInf;

@Mapper
public interface BsDocumentInfMapper extends BaseMapper<BsDocumentInf> {
	
	
	//根据条件查询文档列表
	List<BsDocumentInf> selectDocumentList(@Param("startIndex") Integer startIndex,
										   @Param("turnPageShowNum") Integer turnPageShowNum,
										   @Param("docTitle") String docTitle,
										   @Param("docType") String docType,
										   @Param("startTime") String startTime,
										   @Param("endTime") String endTime);
	//根据条件查询列表总数
	Integer getTotal(@Param("docTitle") String docTitle,
			   		 @Param("docType") String docType,
			   		 @Param("startTime") String startTime,
			   		 @Param("endTime") String endTime);
	
}
