package com.magic.basiccenter.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Accessors(chain = true)
public class AdvertSelOutPageDTO<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2792854549171171307L;
	/**
	 * 
	 */
	/**当前页码*/
	private Long currentPage;
	/**页面大小*/
	private Long turnPageShowNum;
	/**总行数(通过查询获得)*/
	private Long totalNum;
	/**总页数(通过计算获得)*/
	//private Long pageCount;
	/**当前页记录*/
	private List<T> bannerList;
	
	
	
	public AdvertSelOutPageDTO(){}
	public AdvertSelOutPageDTO(Long currentPage, Long turnPageShowNum, Long totalNum, List<T> bannerList) {
		super();
		this.currentPage = currentPage;
		this.turnPageShowNum = turnPageShowNum;
		this.totalNum = totalNum;
		this.bannerList = bannerList;
		//        this.pageCount=rowCount/pageSize;
		//        if(rowCount%pageSize!=0) {
		//                pageCount++;
		//        }
		//		this.pageCount=(rowCount-1)/pageSize+1;
	}
	
}

