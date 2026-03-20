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

import com.cl.entity.DingdansongdaEntity;
import com.cl.entity.view.DingdansongdaView;

import com.cl.service.DingdansongdaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 订单送达
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-19 19:21:34
 */
@RestController
@RequestMapping("/dingdansongda")
public class DingdansongdaController {
    @Autowired
    private DingdansongdaService dingdansongdaService;









    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DingdansongdaEntity dingdansongda,
                                                                                                                                            HttpServletRequest request){
                    String tableName = request.getSession().getAttribute("tableName").toString();
                                                                                                    if(tableName.equals("peisongyuan")) {
                    dingdansongda.setGonghao((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                                                                                    if(tableName.equals("yonghu")) {
                    dingdansongda.setZhanghao((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                                        EntityWrapper<DingdansongdaEntity> ew = new EntityWrapper<DingdansongdaEntity>();
                                                                                                                                                                                                                        
        
        
        PageUtils page = dingdansongdaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdansongda), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DingdansongdaEntity dingdansongda,
		HttpServletRequest request){
        EntityWrapper<DingdansongdaEntity> ew = new EntityWrapper<DingdansongdaEntity>();

		PageUtils page = dingdansongdaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdansongda), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DingdansongdaEntity dingdansongda){
       	EntityWrapper<DingdansongdaEntity> ew = new EntityWrapper<DingdansongdaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dingdansongda, "dingdansongda")); 
        return R.ok().put("data", dingdansongdaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DingdansongdaEntity dingdansongda){
        EntityWrapper< DingdansongdaEntity> ew = new EntityWrapper< DingdansongdaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dingdansongda, "dingdansongda")); 
		DingdansongdaView dingdansongdaView =  dingdansongdaService.selectView(ew);
		return R.ok("查询订单送达成功").put("data", dingdansongdaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DingdansongdaEntity dingdansongda = dingdansongdaService.selectById(id);
		dingdansongda = dingdansongdaService.selectView(new EntityWrapper<DingdansongdaEntity>().eq("id", id));
        return R.ok().put("data", dingdansongda);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DingdansongdaEntity dingdansongda = dingdansongdaService.selectById(id);
		dingdansongda = dingdansongdaService.selectView(new EntityWrapper<DingdansongdaEntity>().eq("id", id));
        return R.ok().put("data", dingdansongda);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DingdansongdaEntity dingdansongda, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(dingdansongda);
        dingdansongdaService.insert(dingdansongda);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DingdansongdaEntity dingdansongda, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(dingdansongda);
        dingdansongdaService.insert(dingdansongda);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DingdansongdaEntity dingdansongda, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dingdansongda);
        dingdansongdaService.updateById(dingdansongda);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dingdansongdaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
