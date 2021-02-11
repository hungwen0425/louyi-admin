package com.louyi.system.hr.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 員工基本資料
 * 
 * @author Hungwen Tseng
 * @email alex@louyiai.com
 * @date 2021-02-04 08:54:28
 */
@Data
@TableName("principal")
public class PrincipalEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 序號
	 */
	@TableId
	private Long id;
	/**
	 * 員工編號
	 */
	private String employId;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 到職日期
	 */
	private String dateOfEmployment;
	/**
	 * 離職日期
	 */
	private String resignationDate;
	/**
	 * 職稱
	 */
	private String jobTitle;
	/**
	 * 身份證字號
	 */
	private String idNumber;
	/**
	 * 出生年月日
	 */
	private String birth;
	/**
	 * 血型
	 */
	private String bloodType;
	/**
	 * 行動電話
	 */
	private String mobileNumber;
	/**
	 * 連絡電話
	 */
	private Integer contactNumber;
	/**
	 * 緊急連絡人/關係
	 */
	private String emergencyContact;
	/**
	 * 緊急連絡人電話
	 */
	private String emergencyContactPhone;
	/**
	 * 連絡地址
	 */
	private String address;
	/**
	 * 學歷
	 */
	private String education;
	/**
	 * 畢業學校/科系
	 */
	private String graduateSchoolDepartment;
	/**
	 * 試用期滿日
	 */
	private String probation;
	/**
	 * 年資
	 */
	private Double seniority;
	/**
	 * 年齡
	 */
	private Double age;
	/**
	 * 個人Email
	 */
	private String email;

}
