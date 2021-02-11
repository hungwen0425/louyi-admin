package com.louyi.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.louyi.modules.sys.entity.SysConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 系統配置信息

 */
@Mapper
public interface SysConfigDao extends BaseMapper<SysConfigEntity> {

	/**
	 * 根據key，查詢value
	 */
	SysConfigEntity queryByKey(String paramKey);

	/**
	 * 根據key，更新value
	 */
	int updateValueByKey(@Param("paramKey") String paramKey, @Param("paramValue") String paramValue);

}
