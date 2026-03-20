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


import com.cl.dao.DingdansongdaDao;
import com.cl.entity.DingdansongdaEntity;
import com.cl.service.DingdansongdaService;
import com.cl.entity.view.DingdansongdaView;

@Service("dingdansongdaService")
public class DingdansongdaServiceImpl extends ServiceImpl<DingdansongdaDao, DingdansongdaEntity> implements DingdansongdaService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DingdansongdaEntity> page = this.selectPage(
                new Query<DingdansongdaEntity>(params).getPage(),
                new EntityWrapper<DingdansongdaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DingdansongdaEntity> wrapper) {
		  Page<DingdansongdaView> page =new Query<DingdansongdaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DingdansongdaView> selectListView(Wrapper<DingdansongdaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DingdansongdaView selectView(Wrapper<DingdansongdaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	


}
