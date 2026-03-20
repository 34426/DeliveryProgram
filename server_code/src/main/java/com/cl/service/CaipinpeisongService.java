package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CaipinpeisongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CaipinpeisongView;


/**
 * 菜品配送
 *
 * @author 
 * @email 
 * @date 2025-04-19 19:21:34
 */
public interface CaipinpeisongService extends IService<CaipinpeisongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CaipinpeisongView> selectListView(Wrapper<CaipinpeisongEntity> wrapper);
   	
   	CaipinpeisongView selectView(@Param("ew") Wrapper<CaipinpeisongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CaipinpeisongEntity> wrapper);
   	
   
}

