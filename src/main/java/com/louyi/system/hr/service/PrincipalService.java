package com.louyi.system.hr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.louyi.common.utils.PageUtils;
import com.louyi.system.hr.entity.PrincipalEntity;

import java.util.Map;

/**
 * 員工基本資料
 *
 * @author Hungwen Tseng
 * @email alex@louyiai.com
 * @date 2021-02-04 08:54:28
 */
public interface PrincipalService extends IService<PrincipalEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

