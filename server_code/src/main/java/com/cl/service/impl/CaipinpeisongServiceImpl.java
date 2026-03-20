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


import com.cl.dao.CaipinpeisongDao;
import com.cl.entity.CaipinpeisongEntity;
import com.cl.service.CaipinpeisongService;
import com.cl.entity.view.CaipinpeisongView;

@Service("caipinpeisongService")
public class CaipinpeisongServiceImpl extends ServiceImpl<CaipinpeisongDao, CaipinpeisongEntity> implements CaipinpeisongService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CaipinpeisongEntity> page = this.selectPage(
                new Query<CaipinpeisongEntity>(params).getPage(),
                new EntityWrapper<CaipinpeisongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CaipinpeisongEntity> wrapper) {
		  Page<CaipinpeisongView> page =new Query<CaipinpeisongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<CaipinpeisongView> selectListView(Wrapper<CaipinpeisongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CaipinpeisongView selectView(Wrapper<CaipinpeisongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	


}
