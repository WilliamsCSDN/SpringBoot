package com.babt.stat.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 编号-地域-经纬度对应表
 * </p>
 *
 * @author denglianyong
 * @since 2018-05-21
 */
@TableName("babt_area_code")
public class BabtAreaCode extends Model {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value="ID")
	private Integer id;
	/**
	 * 行政代码（身份证前6位）
	 */
	@TableField(value="Code")
	private String code;
	/**
	 * 省市区名称
	 */
	@TableField(value="Area")
	private String area;
	/**
	 * 省
	 */
	@TableField(value="Province")
	private String province;
	/**
	 * 市
	 */
	@TableField(value="City")
	private String city;
	/**
	 * 区
	 */
	@TableField(value="District")
	private String district;
	/**
	 * 省份简称
	 */
	@TableField(value="Abbreviation")
	private String abbreviation;
	/**
	 * 电话区号
	 */
	@TableField(value="TelCode")
	private String telcode;
	/**
	 * 邮编
	 */
	@TableField(value="ZipCode")
	private String zipcode;
	/**
	 * 经度
	 */
	@TableField(value="Longitude")
	private Double longitude;
	/**
	 * 纬度
	 */
	@TableField(value="Latitude")
	private Double latitude;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getTelcode() {
		return telcode;
	}

	public void setTelcode(String telcode) {
		this.telcode = telcode;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
