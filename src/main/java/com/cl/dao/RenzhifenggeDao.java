package com.cl.dao;

import com.cl.entity.RenzhifenggeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenzhifenggeView;


/**
 * 认知风格
 * 
 * @author 
 * @email 
 * @date 2024-03-24 21:40:44
 */
public interface RenzhifenggeDao extends BaseMapper<RenzhifenggeEntity> {
	
	List<RenzhifenggeView> selectListView(@Param("ew") Wrapper<RenzhifenggeEntity> wrapper);

	List<RenzhifenggeView> selectListView(Pagination page,@Param("ew") Wrapper<RenzhifenggeEntity> wrapper);
	
	RenzhifenggeView selectView(@Param("ew") Wrapper<RenzhifenggeEntity> wrapper);
	
	List<RenzhifenggeView> selectGroupBy(Pagination page,@Param("ew") Wrapper<RenzhifenggeEntity> wrapper);

}
