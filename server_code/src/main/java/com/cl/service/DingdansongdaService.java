package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DingdansongdaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DingdansongdaView;


/**
 * 订单送达
 *
 * @author 
 * @email 
 * @date 2025-04-19 19:21:34
 */
public interface DingdansongdaService extends IService<DingdansongdaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DingdansongdaView> selectListView(Wrapper<DingdansongdaEntity> wrapper);
   	
   	DingdansongdaView selectView(@Param("ew") Wrapper<DingdansongdaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DingdansongdaEntity> wrapper);
   	
   
}

