package com.eshop4j.web.service.impl;

import java.util.List;
import java.lang.Long;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.eshop4j.core.datatable.DataTable;
import com.eshop4j.core.datatable.DataTableReturn;
import com.eshop4j.core.generic.GenericDao;
import com.eshop4j.core.generic.GenericServiceImpl;
import com.eshop4j.core.orm.paging.Page;

import com.eshop4j.web.model.SmFeedback;
import com.eshop4j.web.response.FeedbackResponse;
import com.eshop4j.web.dao.SmFeedbackMapper;
import com.eshop4j.web.service.SmFeedbackService;
import com.eshop4j.web.service.impl.SmFeedbackServiceImpl;


 /**
 * 
 * @描述：SmFeedbackService 服务实现类
 * 
 * @创建人： Mignet
 * 
 * @创建时间：2016年07月28日 10:43:04
 * 
 * Copyright (c) 深圳领会科技有限公司-版权所有
 */
@Service("smFeedbackService")
public class SmFeedbackServiceImpl extends GenericServiceImpl<SmFeedback, Long> implements SmFeedbackService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SmFeedbackServiceImpl.class);
	
	@Resource
	private SmFeedbackMapper smFeedbackMapper;
	
	@Override
    public GenericDao<SmFeedback, Long> getDao() {
        return smFeedbackMapper;
    }
    
    @Override
	public DataTableReturn selectByDatatables(DataTable dt) {
		DataTableReturn tableReturn = new DataTableReturn();
		tableReturn.setDraw(dt.getDraw()+1);
		LOGGER.debug(" -- SmFeedback -- 排序和模糊查询 ");
		Page<SmFeedback> page = new Page<SmFeedback>(dt.getStart()/dt.getLength()+1,dt.getLength());
		List<SmFeedback> list = this.smFeedbackMapper.selectBySearchInfo(dt,page);
		tableReturn.setData(list);
		tableReturn.setRecordsFiltered(page.getTotalCount());
		tableReturn.setRecordsTotal(page.getTotalCount());
		return tableReturn;
	}

	@Override
	public DataTableReturn selectByDatatablesRepUidByMob(DataTable dt) {
		DataTableReturn tableReturn = new DataTableReturn();
		tableReturn.setDraw(dt.getDraw()+1);
		LOGGER.debug(" -- SmFeedback -- 排序和模糊查询 ");
		Page<FeedbackResponse> page = new Page<FeedbackResponse>(dt.getStart()/dt.getLength()+1,dt.getLength());
		List<FeedbackResponse> list = this.smFeedbackMapper.selectBySearchInfoRes(dt,page);
		tableReturn.setData(list);
		tableReturn.setRecordsFiltered(page.getTotalCount());
		tableReturn.setRecordsTotal(page.getTotalCount());
		return tableReturn;
	}

}
