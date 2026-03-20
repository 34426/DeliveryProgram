package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 订单接单
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-19 19:21:34
 */
@TableName("dingdanjiedan")
public class DingdanjiedanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DingdanjiedanEntity() {
		
	}
	
	public DingdanjiedanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 取餐号
	 */
					
	private String qucanhao;
	
	/**
	 * 取餐时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date qucanshijian;
	
	/**
	 * 工号
	 */
					
	private String gonghao;
	
	/**
	 * 配送员姓名
	 */
					
	private String peisongyuanxingming;
	
	/**
	 * 商家地址
	 */
					
	private String shangjiadizhi;
	
	/**
	 * 收货地址
	 */
					
	private String address;
	
	/**
	 * 收货人
	 */
					
	private String zhanghao;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	/**
	 * 订单详情
	 */
					
	private String dingdanxiangqing;
	

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：取餐号
	 */
	public void setQucanhao(String qucanhao) {
		this.qucanhao = qucanhao;
	}
	/**
	 * 获取：取餐号
	 */
	public String getQucanhao() {
		return qucanhao;
	}
	/**
	 * 设置：取餐时间
	 */
	public void setQucanshijian(Date qucanshijian) {
		this.qucanshijian = qucanshijian;
	}
	/**
	 * 获取：取餐时间
	 */
	public Date getQucanshijian() {
		return qucanshijian;
	}
	/**
	 * 设置：工号
	 */
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}
	/**
	 * 获取：工号
	 */
	public String getGonghao() {
		return gonghao;
	}
	/**
	 * 设置：配送员姓名
	 */
	public void setPeisongyuanxingming(String peisongyuanxingming) {
		this.peisongyuanxingming = peisongyuanxingming;
	}
	/**
	 * 获取：配送员姓名
	 */
	public String getPeisongyuanxingming() {
		return peisongyuanxingming;
	}
	/**
	 * 设置：商家地址
	 */
	public void setShangjiadizhi(String shangjiadizhi) {
		this.shangjiadizhi = shangjiadizhi;
	}
	/**
	 * 获取：商家地址
	 */
	public String getShangjiadizhi() {
		return shangjiadizhi;
	}
	/**
	 * 设置：收货地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：收货地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：收货人
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：收货人
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
	/**
	 * 设置：订单详情
	 */
	public void setDingdanxiangqing(String dingdanxiangqing) {
		this.dingdanxiangqing = dingdanxiangqing;
	}
	/**
	 * 获取：订单详情
	 */
	public String getDingdanxiangqing() {
		return dingdanxiangqing;
	}

}
