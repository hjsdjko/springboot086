package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.RenzhifenggeEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenzhifenggeView;


/**
 * 认知风格
 *
 * @author 
 * @email 
 * @date 2024-03-24 21:40:44
 */
public interface RenzhifenggeService extends IService<RenzhifenggeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RenzhifenggeView> selectListView(Wrapper<RenzhifenggeEntity> wrapper);
   	
   	RenzhifenggeView selectView(@Param("ew") Wrapper<RenzhifenggeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RenzhifenggeEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<RenzhifenggeEntity> wrapper);

}

