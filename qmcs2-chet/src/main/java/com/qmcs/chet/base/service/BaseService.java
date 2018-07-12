package com.qmcs.chet.base.service;

public interface BaseService {
	
	public final static String ERROR_MSG = "系统繁忙，请稍后再试！";
	
	// 增加
	public final static String INSERT = "insert";
	
	// 增加 批量
	public final static String INSERT_BATCH = "insert_batch";
	
	// 增加 选择参数
	public final static String INSERT_SEL = "insert_sel";
	
	// 增加 选择参数 批量
	public final static String INSERT_SEL_BATCH = "insert_sel_batch";
	
	
	// 修改
	public final static String UPDATE = "update";
	
	// 修改 选择参数
	public final static String UPDATE_SEl = "update_sel";
	
	// 修改 根据主键
	public final static String UPDATE_PK = "update_pk";
	
	// 修改 根据主键 选择参数 
	public final static String UPDATE_PK_SEl = "update_pk_sel";
	
	// 修改 根据主键 控制版本
	public final static String UPDATE_PK_VER = "update_pk_ver";
	
	// 修改 根据主键 选择参数 控制版本
	public final static String UPDATE_PK_SEl_VER = "update_pk_sel_ver";
	
	
	// 逻辑删除 根据主键 
	public final static String DELETE_PK_LOGIC = "delete_pk_logic";
	
	// 逻辑删除 根据主键 控制版本
	public final static String DELETE_PK_VER_LOGIC = "delete_pk_ver_logic";
	
	
	// 删除
	public final static String DELETE = "delete";
	
	// 删除 根据主键 
	public final static String DELETE_PK = "delete_pk";
	
	// 删除 根据主键 控制版本
	public final static String DELETE_PK_VER = "delete_pk_ver";
	

	public Object exe(String cmd, Object obj);
}
