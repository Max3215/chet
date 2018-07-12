package com.qmcs.chet.base.exception;

import com.qmcs.common.code.Code;

/**
 * 应用异常
 * @author suyl
 *
 */
public class AppException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = -1222233942643293408L;

	// 消息 map
	private String exceptionMsg;

	//
	private Integer exceptionCode;

	public AppException() {
		super();
	}

	public AppException(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public AppException(Code code){
		this.exceptionMsg = code.getMsg();
	}

	public AppException(Throwable throwable) {
		super(throwable);
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
}
