 

package com.louyi.modules.oss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.louyi.common.utils.PageUtils;
import com.louyi.modules.oss.entity.SysOssEntity;

import java.util.Map;

/**
 * 文件上传
   
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
