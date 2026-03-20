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

import com.cl.entity.DingdanjiedanEntity;
import com.cl.entity.view.DingdanjiedanView;

import com.cl.service.DingdanjiedanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 订单接单
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-19 19:21:34
 */
@RestController
@RequestMapping("/dingdanjiedan")
public class DingdanjiedanController {
    @Autowired
    private DingdanjiedanService dingdanjiedanService;









    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DingdanjiedanEntity dingdanjiedan,
                                                                                                                                            HttpServletRequest request){
                    String tableName = request.getSession().getAttribute("tableName").toString();
                                                                                                    if(tableName.equals("peisongyuan")) {
                    dingdanjiedan.setGonghao((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                                                                                    if(tableName.equals("yonghu")) {
                    dingdanjiedan.setZhanghao((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                                        EntityWrapper<DingdanjiedanEntity> ew = new EntityWrapper<DingdanjiedanEntity>();
                                                                                                                                                                                                                        
        
        
        PageUtils page = dingdanjiedanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanjiedan), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DingdanjiedanEntity dingdanjiedan,
		HttpServletRequest request){
        EntityWrapper<DingdanjiedanEntity> ew = new EntityWrapper<DingdanjiedanEntity>();

		PageUtils page = dingdanjiedanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanjiedan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DingdanjiedanEntity dingdanjiedan){
       	EntityWrapper<DingdanjiedanEntity> ew = new EntityWrapper<DingdanjiedanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dingdanjiedan, "dingdanjiedan")); 
        return R.ok().put("data", dingdanjiedanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DingdanjiedanEntity dingdanjiedan){
        EntityWrapper< DingdanjiedanEntity> ew = new EntityWrapper< DingdanjiedanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dingdanjiedan, "dingdanjiedan")); 
		DingdanjiedanView dingdanjiedanView =  dingdanjiedanService.selectView(ew);
		return R.ok("查询订单接单成功").put("data", dingdanjiedanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DingdanjiedanEntity dingdanjiedan = dingdanjiedanService.selectById(id);
		dingdanjiedan = dingdanjiedanService.selectView(new EntityWrapper<DingdanjiedanEntity>().eq("id", id));
        return R.ok().put("data", dingdanjiedan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DingdanjiedanEntity dingdanjiedan = dingdanjiedanService.selectById(id);
		dingdanjiedan = dingdanjiedanService.selectView(new EntityWrapper<DingdanjiedanEntity>().eq("id", id));
        return R.ok().put("data", dingdanjiedan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DingdanjiedanEntity dingdanjiedan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(dingdanjiedan);
        dingdanjiedanService.insert(dingdanjiedan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DingdanjiedanEntity dingdanjiedan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(dingdanjiedan);
        dingdanjiedanService.insert(dingdanjiedan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DingdanjiedanEntity dingdanjiedan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dingdanjiedan);
        dingdanjiedanService.updateById(dingdanjiedan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dingdanjiedanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
