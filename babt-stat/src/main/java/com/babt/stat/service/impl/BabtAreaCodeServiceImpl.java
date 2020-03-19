package com.babt.stat.service.impl;

import com.babt.stat.entity.BabtAreaCode;
import com.babt.stat.mapper.BabtAreaCodeDao;
import com.babt.stat.service.IBabtAreaCodeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 编号-地域-经纬度对应表  服务实现类
 * </p>
 *
 * @author denglianyong
 * @since 2018-05-21
 */
@Service
public class BabtAreaCodeServiceImpl extends ServiceImpl<BabtAreaCodeDao, BabtAreaCode> implements IBabtAreaCodeService {

	@Override
	public List<BabtAreaCode> showProvinceInCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BabtAreaCode> showCityInProvince(String province) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BabtAreaCode> showDistrictInProvinceCity(String province, String city) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
