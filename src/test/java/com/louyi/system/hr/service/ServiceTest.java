package com.louyi.system.hr.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.louyi.system.hr.entity.PrincipalEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    PrincipalService principalService;

    @Test
    public void contextLoads(){

//        PrincipalEntity principalEntity = new PrincipalEntity();
//        principalEntity.setEmployId("T028");
//        principalEntity.setName("曾泓雯");
//        principalEntity.setDateOfEmployment("2021/01/04");
//        principalEntity.setJobTitle("技術經理");
//        principalEntity.setIdNumber("N120784689");
//        principalEntity.setBirth("1974/4/25");
//        principalEntity.setBloodType("B");
//        principalEntity.setEmergencyContact("曾婉玲/妹妹");
//        principalEntity.setEmergencyContactPhone("0930-330-486");
//        principalEntity.setAddress("彰化縣員林市大榮街32巷42號");
//        principalEntity.setEducation("碩士");
//        principalEntity.setGraduateSchoolDepartment("中原大學/工業工程研究所");
//        principalEntity.setProbation("2021/4/4");
//        principalEntity.setSeniority(0.1);
//        principalEntity.setAge(46.8);
//        principalService.save(principalEntity);
//        principalEntity = principalService.getById(2);
//        System.out.println(principalEntity.toString());
        System.out.println(principalService.list(new QueryWrapper<PrincipalEntity>().eq("id",3)));
    }


}
