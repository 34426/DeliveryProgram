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

import com.cl.entity.PeisongyuanEntity;
import com.cl.entity.view.PeisongyuanView;

import com.cl.service.PeisongyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 配送员
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-19 19:21:33
 */
@RestController
@RequestMapping("/peisongyuan")
public class PeisongyuanController {
    @Autowired
    private PeisongyuanService peisongyuanService;



	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		PeisongyuanEntity u = peisongyuanService.selectOne(new EntityWrapper<PeisongyuanEntity>().eq("gonghao", username));
        if(u==null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"peisongyuan",  "管理员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody PeisongyuanEntity peisongyuan){
    	//ValidatorUtils.validateEntity(peisongyuan);
                            PeisongyuanEntity u = peisongyuanService.selectOne(new EntityWrapper<PeisongyuanEntity>().eq("gonghao", peisongyuan.getGonghao()));
                                                		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		peisongyuan.setId(uId);
        peisongyuanService.insert(peisongyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        return R.ok().put("data", peisongyuanService.selectView(new EntityWrapper<PeisongyuanEntity>().eq("id", id)));
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	PeisongyuanEntity u = peisongyuanService.selectOne(new EntityWrapper<PeisongyuanEntity>().eq("gonghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        peisongyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }






    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PeisongyuanEntity peisongyuan,
                                                                                                    HttpServletRequest request){
                                    EntityWrapper<PeisongyuanEntity> ew = new EntityWrapper<PeisongyuanEntity>();
                                                                                                                                                
        
        
        PageUtils page = peisongyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peisongyuan), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PeisongyuanEntity peisongyuan,
		HttpServletRequest request){
        EntityWrapper<PeisongyuanEntity> ew = new EntityWrapper<PeisongyuanEntity>();

		PageUtils page = peisongyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peisongyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PeisongyuanEntity peisongyuan){
       	EntityWrapper<PeisongyuanEntity> ew = new EntityWrapper<PeisongyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( peisongyuan, "peisongyuan")); 
        return R.ok().put("data", peisongyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PeisongyuanEntity peisongyuan){
        EntityWrapper< PeisongyuanEntity> ew = new EntityWrapper< PeisongyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( peisongyuan, "peisongyuan")); 
		PeisongyuanView peisongyuanView =  peisongyuanService.selectView(ew);
		return R.ok("查询配送员成功").put("data", peisongyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PeisongyuanEntity peisongyuan = peisongyuanService.selectById(id);
		peisongyuan = peisongyuanService.selectView(new EntityWrapper<PeisongyuanEntity>().eq("id", id));
        return R.ok().put("data", peisongyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PeisongyuanEntity peisongyuan = peisongyuanService.selectById(id);
		peisongyuan = peisongyuanService.selectView(new EntityWrapper<PeisongyuanEntity>().eq("id", id));
        return R.ok().put("data", peisongyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PeisongyuanEntity peisongyuan, HttpServletRequest request){
        if(peisongyuanService.selectCount(new EntityWrapper<PeisongyuanEntity>().eq("gonghao", peisongyuan.getGonghao()))>0) {
            return R.error("工号已存在");
        }
    	peisongyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peisongyuan);
        PeisongyuanEntity u = peisongyuanService.selectOne(new EntityWrapper<PeisongyuanEntity>().eq("gonghao", peisongyuan.getGonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		peisongyuan.setId(new Date().getTime());
        peisongyuanService.insert(peisongyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PeisongyuanEntity peisongyuan, HttpServletRequest request){
        if(peisongyuanService.selectCount(new EntityWrapper<PeisongyuanEntity>().eq("gonghao", peisongyuan.getGonghao()))>0) {
            return R.error("工号已存在");
        }
    	peisongyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peisongyuan);
        PeisongyuanEntity u = peisongyuanService.selectOne(new EntityWrapper<PeisongyuanEntity>().eq("gonghao", peisongyuan.getGonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		peisongyuan.setId(new Date().getTime());
        peisongyuanService.insert(peisongyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PeisongyuanEntity peisongyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peisongyuan);
        peisongyuanService.updateById(peisongyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        peisongyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
