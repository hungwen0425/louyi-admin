package com.louyi.modules.job.utils;

import com.louyi.common.exception.RRException;
import com.louyi.common.utils.Constant;
import com.louyi.modules.job.entity.ScheduleJobEntity;
import org.quartz.*;

/**
 * 定時任務工具類

 */
public class ScheduleUtils {
    private final static String JOB_NAME = "TASK_";

    /**
     * 獲取觸發器key
     */
    public static TriggerKey getTriggerKey(Long jobId) {
        return TriggerKey.triggerKey(JOB_NAME + jobId);
    }

    /**
     * 獲取jobKey
     */
    public static JobKey getJobKey(Long jobId) {
        return JobKey.jobKey(JOB_NAME + jobId);
    }

    /**
     * 獲取表達式觸發器
     */
    public static CronTrigger getCronTrigger(Scheduler scheduler, Long jobId) {
        try {
            return (CronTrigger) scheduler.getTrigger(getTriggerKey(jobId));
        } catch (SchedulerException e) {
            throw new RRException("獲取定時任務CronTrigger出現異常", e);
        }
    }

    /**
     * 創建定時任務
     */
    public static void createScheduleJob(Scheduler scheduler, ScheduleJobEntity scheduleJob) {
        try {
            //構建job信息
            JobDetail jobDetail = JobBuilder.newJob(ScheduleJob.class).withIdentity(getJobKey(scheduleJob.getJobId())).build();

            //表達式調度構建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression())
                    .withMisfireHandlingInstructionDoNothing();

            //按新的cronExpression表達式構建一個新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(scheduleJob.getJobId())).withSchedule(scheduleBuilder).build();

            //放入參數，運行時的方法可以獲取
            jobDetail.getJobDataMap().put(ScheduleJobEntity.JOB_PARAM_KEY, scheduleJob);

            scheduler.scheduleJob(jobDetail, trigger);

            //暫停任務
            if(scheduleJob.getStatus() == Constant.ScheduleStatus.PAUSE.getValue()){
                pauseJob(scheduler, scheduleJob.getJobId());
            }
        } catch (SchedulerException e) {
            throw new RRException("創建定時任務失敗", e);
        }
    }

    /**
     * 更新定時任務
     */
    public static void updateScheduleJob(Scheduler scheduler, ScheduleJobEntity scheduleJob) {
        try {
            TriggerKey triggerKey = getTriggerKey(scheduleJob.getJobId());

            //表達式調度構建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression())
                    .withMisfireHandlingInstructionDoNothing();

            CronTrigger trigger = getCronTrigger(scheduler, scheduleJob.getJobId());

            //按新的cronExpression表達式重新構建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

            //參數
            trigger.getJobDataMap().put(ScheduleJobEntity.JOB_PARAM_KEY, scheduleJob);

            scheduler.rescheduleJob(triggerKey, trigger);

            //暫停任務
            if(scheduleJob.getStatus() == Constant.ScheduleStatus.PAUSE.getValue()){
                pauseJob(scheduler, scheduleJob.getJobId());
            }

        } catch (SchedulerException e) {
            throw new RRException("更新定時任務失敗", e);
        }
    }

    /**
     * 立即執行任務
     */
    public static void run(Scheduler scheduler, ScheduleJobEntity scheduleJob) {
        try {
            //參數
            JobDataMap dataMap = new JobDataMap();
            dataMap.put(ScheduleJobEntity.JOB_PARAM_KEY, scheduleJob);

            scheduler.triggerJob(getJobKey(scheduleJob.getJobId()), dataMap);
        } catch (SchedulerException e) {
            throw new RRException("立即執行定時任務失敗", e);
        }
    }

    /**
     * 暫停任務
     */
    public static void pauseJob(Scheduler scheduler, Long jobId) {
        try {
            scheduler.pauseJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new RRException("暫停定時任務失敗", e);
        }
    }

    /**
     * 恢復任務
     */
    public static void resumeJob(Scheduler scheduler, Long jobId) {
        try {
            scheduler.resumeJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new RRException("暫停定時任務失敗", e);
        }
    }

    /**
     * 刪除定時任務
     */
    public static void deleteScheduleJob(Scheduler scheduler, Long jobId) {
        try {
            scheduler.deleteJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new RRException("刪除定時任務失敗", e);
        }
    }
}
