package com.louyi.system.hr.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.louyi.system.hr.entity.PrincipalEntity;
import com.louyi.system.hr.service.PrincipalService;
import com.louyi.common.utils.PageUtils;
import com.louyi.common.utils.R;



/**
 * 員工基本資料
 *
 * @author Hungwen Tseng
 * @email alex@louyiai.com
 * @date 2021-02-04 08:54:28
 */
@RestController
@RequestMapping("hr/principal")
public class PrincipalController {
    @Autowired
    private PrincipalService principalService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = principalService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		PrincipalEntity principal = principalService.getById(id);

        return R.ok().put("principal", principal);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PrincipalEntity principal){
		principalService.save(principal);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PrincipalEntity principal){
		principalService.updateById(principal);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		principalService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
