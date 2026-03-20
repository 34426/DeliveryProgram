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
 * 菜品配送
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-19 19:21:34
 */
@TableName("caipinpeisong")
public class CaipinpeisongEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CaipinpeisongEntity() {
		
	}
	
	public CaipinpeisongEntity(T t) {
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
	 * 订单编号
	 */
					
	private String orderid;
	
	/**
	 * 购买数量
	 */
					
	private String buynumber;
	
	/**
	 * 商家名称
	 */
					
	private String shangjiamingcheng;
	
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
	 * 设置：订单编号
	 */
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	/**
	 * 获取：订单编号
	 */
	public String getOrderid() {
		return orderid;
	}
	/**
	 * 设置：购买数量
	 */
	public void setBuynumber(String buynumber) {
		this.buynumber = buynumber;
	}
	/**
	 * 获取：购买数量
	 */
	public String getBuynumber() {
		return buynumber;
	}
	/**
	 * 设置：商家名称
	 */
	public void setShangjiamingcheng(String shangjiamingcheng) {
		this.shangjiamingcheng = shangjiamingcheng;
	}
	/**
	 * 获取：商家名称
	 */
	public String getShangjiamingcheng() {
		return shangjiamingcheng;
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
