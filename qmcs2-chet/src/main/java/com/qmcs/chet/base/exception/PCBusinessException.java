package com.qmcs.chet.base.exception;

/**
 * 网点PC端应用异常
 * @author suyl
 *
 */
public class PCBusinessException extends RuntimeException {

	private static final long serialVersionUID = -1222233942643293408L;
	// 消息 code
	private int code;
	// 消息 exceptionMsg
	private String exceptionMsg;

	public PCBusinessException() {
		super();
	}

	public PCBusinessException(int code, String exceptionMsg) {
		this.code = code;
		this.exceptionMsg = exceptionMsg;
	}

	public PCBusinessException(Throwable throwable) {
		super(throwable);
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
