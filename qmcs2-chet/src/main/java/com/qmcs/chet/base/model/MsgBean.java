package com.qmcs.chet.base.model;


public class MsgBean {
	
	private String code;
	
	private String field;
	
	private String des;
	
	public MsgBean(String code) {
		this(code, null, null);
	}
	
	public MsgBean(String code, String field) {
		this(code, null, field);
	}
	
	public MsgBean(String code, String[] params) {
		this(code, params, null);
	}
	
	public MsgBean(String code, String[] params, String field) {
		this.code = code;
		this.field = field;
		
		//des = MsgUtil.getValue(code);
		if (params != null && params.length > 0) {
			for (int i=0; i<params.length; i++) {
				des = des.replaceAll("\\{" + i + "\\}", params[i]);
			}
		}
	}

	public String getCode() {
		return code;
	}
	
	public String getField() {
		return field;
	}

	public String getDes() {
		return des;
	}
}