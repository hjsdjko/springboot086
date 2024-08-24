package com.cl.entity.view;

import com.cl.entity.RenzhifenggeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 认知风格
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-24 21:40:44
 */
@TableName("renzhifengge")
public class RenzhifenggeView  extends RenzhifenggeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public RenzhifenggeView(){
	}
 
 	public RenzhifenggeView(RenzhifenggeEntity renzhifenggeEntity){
 	try {
			BeanUtils.copyProperties(this, renzhifenggeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
