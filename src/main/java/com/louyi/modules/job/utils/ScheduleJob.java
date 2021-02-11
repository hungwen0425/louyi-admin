

package com.louyi.modules.job.utils;

import com.louyi.common.utils.SpringContextUtils;
import com.louyi.modules.job.entity.ScheduleJobEntity;
import com.louyi.modules.job.entity.ScheduleJobLogEntity;
import com.louyi.modules.job.service.ScheduleJobLogService;
import org.apache.commons.lang.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.Method;
import java.util.Date;


/**
 * 定時任務

 */
public class ScheduleJob extends QuartzJobBean {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		ScheduleJobEntity scheduleJob = (ScheduleJobEntity) context.getMergedJobDataMap()
				.get(ScheduleJobEntity.JOB_PARAM_KEY);

		//獲取spring bean
		ScheduleJobLogService scheduleJobLogService = (ScheduleJobLogService) SpringContextUtils.getBean("scheduleJobLogService");

		//數據庫保存執行記錄
		ScheduleJobLogEntity log = new ScheduleJobLogEntity();
		log.setJobId(scheduleJob.getJobId());
		log.setBeanName(scheduleJob.getBeanName());
		log.setParams(scheduleJob.getParams());
		log.setCreateTime(new Date());

		//任務開始時間
		long startTime = System.currentTimeMillis();

		try {
			//執行任務
			logger.debug("任務準備執行，任務ID：" + scheduleJob.getJobId());

			Object target = SpringContextUtils.getBean(scheduleJob.getBeanName());
			Method method = target.getClass().getDeclaredMethod("run", String.class);
			method.invoke(target, scheduleJob.getParams());

			//任務執行總時長
			long times = System.currentTimeMillis() - startTime;
			log.setTimes((int)times);
			//任務狀態    0：成功    1：失敗
			log.setStatus(0);

			logger.debug("任務執行完畢，任務ID：" + scheduleJob.getJobId() + "  總共耗時：" + times + "毫秒");
		} catch (Exception e) {
			logger.error("任務執行失敗，任務ID：" + scheduleJob.getJobId(), e);

			//任務執行總時長
			long times = System.currentTimeMillis() - startTime;
			log.setTimes((int)times);

			//任務狀態    0：成功    1：失敗
			log.setStatus(1);
			log.setError(StringUtils.substring(e.toString(), 0, 2000));
		}finally {
			scheduleJobLogService.save(log);
		}
	}
}
