package com.louyi.modules.job.controller;

import com.louyi.common.annotation.SysLog;
import com.louyi.common.utils.PageUtils;
import com.louyi.common.utils.R;
import com.louyi.common.validator.ValidatorUtils;
import com.louyi.modules.job.entity.ScheduleJobEntity;
import com.louyi.modules.job.service.ScheduleJobService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 定時任務

 */
@RestController
@RequestMapping("/sys/schedule")
public class ScheduleJobController {
	@Autowired
	private ScheduleJobService scheduleJobService;

	/**
	 * 定時任務列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:schedule:list")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = scheduleJobService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 定時任務信息
	 */
	@RequestMapping("/info/{jobId}")
	@RequiresPermissions("sys:schedule:info")
	public R info(@PathVariable("jobId") Long jobId){
		ScheduleJobEntity schedule = scheduleJobService.getById(jobId);

		return R.ok().put("schedule", schedule);
	}

	/**
	 * 保存定時任務
	 */
	@SysLog("保存定時任務")
	@RequestMapping("/save")
	@RequiresPermissions("sys:schedule:save")
	public R save(@RequestBody ScheduleJobEntity scheduleJob){
		ValidatorUtils.validateEntity(scheduleJob);

		scheduleJobService.saveJob(scheduleJob);

		return R.ok();
	}

	/**
	 * 修改定時任務
	 */
	@SysLog("修改定時任務")
	@RequestMapping("/update")
	@RequiresPermissions("sys:schedule:update")
	public R update(@RequestBody ScheduleJobEntity scheduleJob){
		ValidatorUtils.validateEntity(scheduleJob);

		scheduleJobService.update(scheduleJob);

		return R.ok();
	}

	/**
	 * 刪除定時任務
	 */
	@SysLog("刪除定時任務")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:schedule:delete")
	public R delete(@RequestBody Long[] jobIds){
		scheduleJobService.deleteBatch(jobIds);

		return R.ok();
	}

	/**
	 * 立即執行任務
	 */
	@SysLog("立即執行任務")
	@RequestMapping("/run")
	@RequiresPermissions("sys:schedule:run")
	public R run(@RequestBody Long[] jobIds){
		scheduleJobService.run(jobIds);

		return R.ok();
	}

	/**
	 * 暫停定時任務
	 */
	@SysLog("暫停定時任務")
	@RequestMapping("/pause")
	@RequiresPermissions("sys:schedule:pause")
	public R pause(@RequestBody Long[] jobIds){
		scheduleJobService.pause(jobIds);

		return R.ok();
	}

	/**
	 * 恢復定時任務
	 */
	@SysLog("恢復定時任務")
	@RequestMapping("/resume")
	@RequiresPermissions("sys:schedule:resume")
	public R resume(@RequestBody Long[] jobIds){
		scheduleJobService.resume(jobIds);

		return R.ok();
	}

}
