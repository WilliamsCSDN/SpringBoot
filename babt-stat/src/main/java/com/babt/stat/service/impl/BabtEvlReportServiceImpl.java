package com.babt.stat.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.babt.stat.entity.BabtEvlReport;
import com.babt.stat.mapper.BabtEvlReportDao;
import com.babt.stat.service.IBabtEvlReportService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
@Service
public class BabtEvlReportServiceImpl extends ServiceImpl<BabtEvlReportDao, BabtEvlReport> implements IBabtEvlReportService {
	public List<BabtEvlReport> queryBabtEvlReport(){
		return baseMapper.queryBabtEvlReport();
	}

}
