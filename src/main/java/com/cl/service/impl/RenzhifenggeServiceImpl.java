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


import com.cl.dao.RenzhifenggeDao;
import com.cl.entity.RenzhifenggeEntity;
import com.cl.service.RenzhifenggeService;
import com.cl.entity.view.RenzhifenggeView;

@Service("renzhifenggeService")
public class RenzhifenggeServiceImpl extends ServiceImpl<RenzhifenggeDao, RenzhifenggeEntity> implements RenzhifenggeService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<RenzhifenggeEntity> wrapper) {
		Page<RenzhifenggeView> page =new Query<RenzhifenggeView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RenzhifenggeEntity> page = this.selectPage(
                new Query<RenzhifenggeEntity>(params).getPage(),
                new EntityWrapper<RenzhifenggeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RenzhifenggeEntity> wrapper) {
		  Page<RenzhifenggeView> page =new Query<RenzhifenggeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<RenzhifenggeView> selectListView(Wrapper<RenzhifenggeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RenzhifenggeView selectView(Wrapper<RenzhifenggeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
