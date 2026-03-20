package com.cl.entity.view;

import com.cl.entity.CaipinpeisongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 菜品配送
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-19 19:21:34
 */
@TableName("caipinpeisong")
public class CaipinpeisongView  extends CaipinpeisongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CaipinpeisongView(){
	}
 
 	public CaipinpeisongView(CaipinpeisongEntity caipinpeisongEntity){
 	try {
			BeanUtils.copyProperties(this, caipinpeisongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}



}
