package com.cl.dao;

import com.cl.entity.CaipinpeisongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CaipinpeisongView;


/**
 * 菜品配送
 * 
 * @author 
 * @email 
 * @date 2025-04-19 19:21:34
 */
public interface CaipinpeisongDao extends BaseMapper<CaipinpeisongEntity> {
	
	List<CaipinpeisongView> selectListView(@Param("ew") Wrapper<CaipinpeisongEntity> wrapper);

	List<CaipinpeisongView> selectListView(Pagination page,@Param("ew") Wrapper<CaipinpeisongEntity> wrapper);
	
	CaipinpeisongView selectView(@Param("ew") Wrapper<CaipinpeisongEntity> wrapper);


}
