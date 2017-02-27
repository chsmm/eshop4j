package com.eshop4j.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.eshop4j.api.response.acc.AcAccountTypeReponse;
import com.eshop4j.core.datatable.DataTable;
import com.eshop4j.core.generic.GenericDao;
import com.eshop4j.web.model.acc.AcAccountType;

 /**
 * 
 * @描述： Dao接口
 * 
 * @创建人： chenjl
 * 
 * @创建时间：2016年08月03日 14:35:08
 * 
 * Copyright (c) 深圳领会科技有限公司-版权所有
 */
public interface AcAccountTypeMapper extends GenericDao<AcAccountType,Long>{
	
	 /**
     * 封装DataTable对象查询
     * @param dt
     * @param page
     * @return
     */
	List<AcAccountType> selectBySearchInfo(@Param("dt")DataTable dt,RowBounds page);
	
	/**
     * 查询账户类型
     */
	List<AcAccountTypeReponse> queryAllAccountType(@Param("userType")String userType);
}
