package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

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
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.RenzhifenggeEntity;
import com.cl.entity.view.RenzhifenggeView;

import com.cl.service.RenzhifenggeService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 认知风格
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-24 21:40:44
 */
@RestController
@RequestMapping("/renzhifengge")
public class RenzhifenggeController {
    @Autowired
    private RenzhifenggeService renzhifenggeService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RenzhifenggeEntity renzhifengge,
		HttpServletRequest request){
        EntityWrapper<RenzhifenggeEntity> ew = new EntityWrapper<RenzhifenggeEntity>();

		PageUtils page = renzhifenggeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renzhifengge), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RenzhifenggeEntity renzhifengge, 
		HttpServletRequest request){
        EntityWrapper<RenzhifenggeEntity> ew = new EntityWrapper<RenzhifenggeEntity>();

		PageUtils page = renzhifenggeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renzhifengge), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RenzhifenggeEntity renzhifengge){
       	EntityWrapper<RenzhifenggeEntity> ew = new EntityWrapper<RenzhifenggeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( renzhifengge, "renzhifengge")); 
        return R.ok().put("data", renzhifenggeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RenzhifenggeEntity renzhifengge){
        EntityWrapper< RenzhifenggeEntity> ew = new EntityWrapper< RenzhifenggeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( renzhifengge, "renzhifengge")); 
		RenzhifenggeView renzhifenggeView =  renzhifenggeService.selectView(ew);
		return R.ok("查询认知风格成功").put("data", renzhifenggeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RenzhifenggeEntity renzhifengge = renzhifenggeService.selectById(id);
		renzhifengge = renzhifenggeService.selectView(new EntityWrapper<RenzhifenggeEntity>().eq("id", id));
        return R.ok().put("data", renzhifengge);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RenzhifenggeEntity renzhifengge = renzhifenggeService.selectById(id);
		renzhifengge = renzhifenggeService.selectView(new EntityWrapper<RenzhifenggeEntity>().eq("id", id));
        return R.ok().put("data", renzhifengge);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RenzhifenggeEntity renzhifengge, HttpServletRequest request){
    	renzhifengge.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(renzhifengge);
        renzhifenggeService.insert(renzhifengge);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RenzhifenggeEntity renzhifengge, HttpServletRequest request){
    	renzhifengge.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(renzhifengge);
        renzhifenggeService.insert(renzhifengge);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RenzhifenggeEntity renzhifengge, HttpServletRequest request){
        //ValidatorUtils.validateEntity(renzhifengge);
        renzhifenggeService.updateById(renzhifengge);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        renzhifenggeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
