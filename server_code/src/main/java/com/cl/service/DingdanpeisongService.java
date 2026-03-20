package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DingdanpeisongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DingdanpeisongView;


/**
 * 订单配送
 *
 * @author 
 * @email 
 * @date 2025-04-19 19:21:34
 */
public interface DingdanpeisongService extends IService<DingdanpeisongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DingdanpeisongView> selectListView(Wrapper<DingdanpeisongEntity> wrapper);
   	
   	DingdanpeisongView selectView(@Param("ew") Wrapper<DingdanpeisongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DingdanpeisongEntity> wrapper);
   	
   
    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<DingdanpeisongEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<DingdanpeisongEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<DingdanpeisongEntity> wrapper);



}

