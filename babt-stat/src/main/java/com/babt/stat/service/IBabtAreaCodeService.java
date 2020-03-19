package com.babt.stat.service;

import java.util.List;

import com.babt.stat.entity.BabtAreaCode;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author denglianyong
 * @since 2018-05-21
 */
public interface IBabtAreaCodeService extends IService<BabtAreaCode> {

	public List<BabtAreaCode> showProvinceInCountry();

	public List<BabtAreaCode> showCityInProvince(String province);

	public List<BabtAreaCode> showDistrictInProvinceCity(String province, String city);
	
}
