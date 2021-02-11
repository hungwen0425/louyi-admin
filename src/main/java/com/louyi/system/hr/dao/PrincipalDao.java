package com.louyi.system.hr.dao;

import com.louyi.system.hr.entity.PrincipalEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 員工基本資料
 * 
 * @author Hungwen Tseng
 * @email alex@louyiai.com
 * @date 2021-02-04 08:54:28
 */
@Mapper
public interface PrincipalDao extends BaseMapper<PrincipalEntity> {
	
}
