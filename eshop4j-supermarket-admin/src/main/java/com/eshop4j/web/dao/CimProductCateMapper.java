package com.eshop4j.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.eshop4j.core.datatable.DataTable;
import com.eshop4j.core.generic.GenericDao;
import com.eshop4j.core.orm.paging.Page;
import com.eshop4j.web.model.CimProductCate;
import com.eshop4j.web.model.CimProductCateManager;
import com.eshop4j.web.request.ProductCateDataRequest;

 /**
 * 
 * @描述： Dao接口
 * 
 * @创建人： liqi
 * 
 * @创建时间：2016年07月14日 18:23:34
 * 
 * Copyright (c) 深圳领会科技有限公司-版权所有
 */
public interface CimProductCateMapper extends GenericDao<CimProductCate,Long>{
	
	 /**
     * 封装DataTable对象查询
     * @param dt
     * @param page
     * @return
     */
	List<CimProductCate> selectBySearchInfo(@Param("dt")DataTable dt,RowBounds page);

	/**
	 * 查询产品分类列表
	 * @param productCateDataRequest
	 * @param page
	 * @return
	 */
	List<CimProductCateManager> getCimProductCates(@Param("query")ProductCateDataRequest productCateDataRequest,Page<CimProductCateManager> page);
}