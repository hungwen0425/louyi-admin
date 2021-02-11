 

package com.louyi.modules.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.louyi.modules.job.entity.ScheduleJobLogEntity;
import com.louyi.common.utils.PageUtils;

import java.util.Map;

/**
 * 定时任务日志
   
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

	PageUtils queryPage(Map<String, Object> params);
	
}
