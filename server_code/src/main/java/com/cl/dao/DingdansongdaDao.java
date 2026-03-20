package com.cl.dao;

import com.cl.entity.DingdansongdaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DingdansongdaView;


/**
 * 订单送达
 * 
 * @author 
 * @email 
 * @date 2025-04-19 19:21:34
 */
public interface DingdansongdaDao extends BaseMapper<DingdansongdaEntity> {
	
	List<DingdansongdaView> selectListView(@Param("ew") Wrapper<DingdansongdaEntity> wrapper);

	List<DingdansongdaView> selectListView(Pagination page,@Param("ew") Wrapper<DingdansongdaEntity> wrapper);
	
	DingdansongdaView selectView(@Param("ew") Wrapper<DingdansongdaEntity> wrapper);


}
