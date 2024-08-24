package com.cl.dao;

import com.cl.entity.XueshengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueshengView;


/**
 * 学生
 * 
 * @author 
 * @email 
 * @date 2024-03-24 21:40:44
 */
public interface XueshengDao extends BaseMapper<XueshengEntity> {
	
	List<XueshengView> selectListView(@Param("ew") Wrapper<XueshengEntity> wrapper);

	List<XueshengView> selectListView(Pagination page,@Param("ew") Wrapper<XueshengEntity> wrapper);
	
	XueshengView selectView(@Param("ew") Wrapper<XueshengEntity> wrapper);
	
	List<XueshengView> selectGroupBy(Pagination page,@Param("ew") Wrapper<XueshengEntity> wrapper);

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XueshengEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XueshengEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XueshengEntity> wrapper);



}
