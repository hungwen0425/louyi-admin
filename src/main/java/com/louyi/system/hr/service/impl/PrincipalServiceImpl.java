package com.louyi.system.hr.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.louyi.common.utils.PageUtils;
import com.louyi.common.utils.Query;

import com.louyi.system.hr.dao.PrincipalDao;
import com.louyi.system.hr.entity.PrincipalEntity;
import com.louyi.system.hr.service.PrincipalService;


@Service("principalService")
public class PrincipalServiceImpl extends ServiceImpl<PrincipalDao, PrincipalEntity> implements PrincipalService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PrincipalEntity> page = this.page(
                new Query<PrincipalEntity>().getPage(params),
                new QueryWrapper<PrincipalEntity>()
        );

        return new PageUtils(page);
    }

}