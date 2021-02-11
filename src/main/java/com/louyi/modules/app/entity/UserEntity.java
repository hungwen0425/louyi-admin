package com.louyi.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 用戶
 */
@Data
@TableName("tb_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用戶ID
	 */
	@TableId
	private Long userId;
	/**
	 * 用戶名
	 */
	private String username;
	/**
	 * 手機號
	 */
	private String mobile;
	/**
	 * 密碼
	 */
	private String password;
	/**
	 * 創建時間
	 */
	private Date createTime;

}
