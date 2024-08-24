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

import com.cl.entity.XuexiziyuanEntity;
import com.cl.entity.view.XuexiziyuanView;

import com.cl.service.XuexiziyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 学习资源
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-24 21:40:44
 */
@RestController
@RequestMapping("/xuexiziyuan")
public class XuexiziyuanController {
    @Autowired
    private XuexiziyuanService xuexiziyuanService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XuexiziyuanEntity xuexiziyuan,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date faburiqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date faburiqiend,
		HttpServletRequest request){
        EntityWrapper<XuexiziyuanEntity> ew = new EntityWrapper<XuexiziyuanEntity>();
                if(faburiqistart!=null) ew.ge("faburiqi", faburiqistart);
                if(faburiqiend!=null) ew.le("faburiqi", faburiqiend);

		PageUtils page = xuexiziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuexiziyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XuexiziyuanEntity xuexiziyuan, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date faburiqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date faburiqiend,
		HttpServletRequest request){
        EntityWrapper<XuexiziyuanEntity> ew = new EntityWrapper<XuexiziyuanEntity>();
                if(faburiqistart!=null) ew.ge("faburiqi", faburiqistart);
                if(faburiqiend!=null) ew.le("faburiqi", faburiqiend);

		PageUtils page = xuexiziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuexiziyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XuexiziyuanEntity xuexiziyuan){
       	EntityWrapper<XuexiziyuanEntity> ew = new EntityWrapper<XuexiziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xuexiziyuan, "xuexiziyuan")); 
        return R.ok().put("data", xuexiziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XuexiziyuanEntity xuexiziyuan){
        EntityWrapper< XuexiziyuanEntity> ew = new EntityWrapper< XuexiziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xuexiziyuan, "xuexiziyuan")); 
		XuexiziyuanView xuexiziyuanView =  xuexiziyuanService.selectView(ew);
		return R.ok("查询学习资源成功").put("data", xuexiziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XuexiziyuanEntity xuexiziyuan = xuexiziyuanService.selectById(id);
		xuexiziyuan.setClicktime(new Date());
		xuexiziyuanService.updateById(xuexiziyuan);
		xuexiziyuan = xuexiziyuanService.selectView(new EntityWrapper<XuexiziyuanEntity>().eq("id", id));
        return R.ok().put("data", xuexiziyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XuexiziyuanEntity xuexiziyuan = xuexiziyuanService.selectById(id);
		xuexiziyuan.setClicktime(new Date());
		xuexiziyuanService.updateById(xuexiziyuan);
		xuexiziyuan = xuexiziyuanService.selectView(new EntityWrapper<XuexiziyuanEntity>().eq("id", id));
        return R.ok().put("data", xuexiziyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XuexiziyuanEntity xuexiziyuan, HttpServletRequest request){
    	xuexiziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuexiziyuan);
        xuexiziyuanService.insert(xuexiziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XuexiziyuanEntity xuexiziyuan, HttpServletRequest request){
    	xuexiziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuexiziyuan);
        xuexiziyuanService.insert(xuexiziyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XuexiziyuanEntity xuexiziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuexiziyuan);
        xuexiziyuanService.updateById(xuexiziyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xuexiziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,XuexiziyuanEntity xuexiziyuan, HttpServletRequest request,String pre){
        EntityWrapper<XuexiziyuanEntity> ew = new EntityWrapper<XuexiziyuanEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = xuexiziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuexiziyuan), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 按收藏推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,XuexiziyuanEntity xuexiziyuan, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "renzhifengge";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "xuexiziyuan").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<XuexiziyuanEntity> xuexiziyuanList = new ArrayList<XuexiziyuanEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                xuexiziyuanList.addAll(xuexiziyuanService.selectList(new EntityWrapper<XuexiziyuanEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<XuexiziyuanEntity> ew = new EntityWrapper<XuexiziyuanEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = xuexiziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuexiziyuan), params), params));
        List<XuexiziyuanEntity> pageList = (List<XuexiziyuanEntity>)page.getList();
        if(xuexiziyuanList.size()<limit) {
            int toAddNum = (limit-xuexiziyuanList.size())<=pageList.size()?(limit-xuexiziyuanList.size()):pageList.size();
            for(XuexiziyuanEntity o1 : pageList) {
                boolean addFlag = true;
                for(XuexiziyuanEntity o2 : xuexiziyuanList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    xuexiziyuanList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(xuexiziyuanList.size()>limit) {
            xuexiziyuanList = xuexiziyuanList.subList(0, limit);
        }
        page.setList(xuexiziyuanList);
        return R.ok().put("data", page);
    }







}
