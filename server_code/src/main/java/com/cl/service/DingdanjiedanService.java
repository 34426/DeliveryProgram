package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DingdanjiedanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DingdanjiedanView;


/**
 * 订单接单
 *
 * @author 
 * @email 
 * @date 2025-04-19 19:21:34
 */
public interface DingdanjiedanService extends IService<DingdanjiedanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DingdanjiedanView> selectListView(Wrapper<DingdanjiedanEntity> wrapper);
   	
   	DingdanjiedanView selectView(@Param("ew") Wrapper<DingdanjiedanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DingdanjiedanEntity> wrapper);
   	
   
}

