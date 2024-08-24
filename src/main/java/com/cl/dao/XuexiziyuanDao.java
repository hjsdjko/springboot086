package com.cl.dao;

import com.cl.entity.XuexiziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XuexiziyuanView;


/**
 * 学习资源
 * 
 * @author 
 * @email 
 * @date 2024-03-24 21:40:44
 */
public interface XuexiziyuanDao extends BaseMapper<XuexiziyuanEntity> {
	
	List<XuexiziyuanView> selectListView(@Param("ew") Wrapper<XuexiziyuanEntity> wrapper);

	List<XuexiziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<XuexiziyuanEntity> wrapper);
	
	XuexiziyuanView selectView(@Param("ew") Wrapper<XuexiziyuanEntity> wrapper);
	
	List<XuexiziyuanView> selectGroupBy(Pagination page,@Param("ew") Wrapper<XuexiziyuanEntity> wrapper);

}
