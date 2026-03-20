package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.CaipinpeisongEntity;
import com.cl.entity.view.CaipinpeisongView;

import com.cl.service.CaipinpeisongService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 菜品配送
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-19 19:21:34
 */
@RestController
@RequestMapping("/caipinpeisong")
public class CaipinpeisongController {
    @Autowired
    private CaipinpeisongService caipinpeisongService;









    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CaipinpeisongEntity caipinpeisong,
                                                                                                                                                                        HttpServletRequest request){
                    String tableName = request.getSession().getAttribute("tableName").toString();
                                                                                                    if(tableName.equals("shangjia")) {
                    caipinpeisong.setShangjiamingcheng((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                                                        if(tableName.equals("yonghu")) {
                    caipinpeisong.setZhanghao((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                                        EntityWrapper<CaipinpeisongEntity> ew = new EntityWrapper<CaipinpeisongEntity>();
                                                                                                                                                                                                                                                            
        
        
        PageUtils page = caipinpeisongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caipinpeisong), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CaipinpeisongEntity caipinpeisong,
		HttpServletRequest request){
        EntityWrapper<CaipinpeisongEntity> ew = new EntityWrapper<CaipinpeisongEntity>();

		PageUtils page = caipinpeisongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caipinpeisong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CaipinpeisongEntity caipinpeisong){
       	EntityWrapper<CaipinpeisongEntity> ew = new EntityWrapper<CaipinpeisongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( caipinpeisong, "caipinpeisong")); 
        return R.ok().put("data", caipinpeisongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CaipinpeisongEntity caipinpeisong){
        EntityWrapper< CaipinpeisongEntity> ew = new EntityWrapper< CaipinpeisongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( caipinpeisong, "caipinpeisong")); 
		CaipinpeisongView caipinpeisongView =  caipinpeisongService.selectView(ew);
		return R.ok("查询菜品配送成功").put("data", caipinpeisongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CaipinpeisongEntity caipinpeisong = caipinpeisongService.selectById(id);
		caipinpeisong = caipinpeisongService.selectView(new EntityWrapper<CaipinpeisongEntity>().eq("id", id));
        return R.ok().put("data", caipinpeisong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CaipinpeisongEntity caipinpeisong = caipinpeisongService.selectById(id);
		caipinpeisong = caipinpeisongService.selectView(new EntityWrapper<CaipinpeisongEntity>().eq("id", id));
        return R.ok().put("data", caipinpeisong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CaipinpeisongEntity caipinpeisong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(caipinpeisong);
        caipinpeisongService.insert(caipinpeisong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CaipinpeisongEntity caipinpeisong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(caipinpeisong);
        caipinpeisongService.insert(caipinpeisong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CaipinpeisongEntity caipinpeisong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caipinpeisong);
        caipinpeisongService.updateById(caipinpeisong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        caipinpeisongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
