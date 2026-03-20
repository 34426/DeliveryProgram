package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DingdanjiedanDao;
import com.cl.entity.DingdanjiedanEntity;
import com.cl.service.DingdanjiedanService;
import com.cl.entity.view.DingdanjiedanView;

@Service("dingdanjiedanService")
public class DingdanjiedanServiceImpl extends ServiceImpl<DingdanjiedanDao, DingdanjiedanEntity> implements DingdanjiedanService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DingdanjiedanEntity> page = this.selectPage(
                new Query<DingdanjiedanEntity>(params).getPage(),
                new EntityWrapper<DingdanjiedanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DingdanjiedanEntity> wrapper) {
		  Page<DingdanjiedanView> page =new Query<DingdanjiedanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DingdanjiedanView> selectListView(Wrapper<DingdanjiedanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DingdanjiedanView selectView(Wrapper<DingdanjiedanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	


}
