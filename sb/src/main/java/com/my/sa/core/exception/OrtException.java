package com.my.sa.core.exception;

import org.springframework.core.NestedRuntimeException;

public class OrtException extends NestedRuntimeException implements
		ExceptionInfoGetter {
	private static final long serialVersionUID = 1L;

	private Integer code;

	private Object[] args;

	private String content;

	public OrtException(String content) {
		super(content);

		this.content = content;
	}

	public OrtException(String content, Throwable throwable) {
		super(content, throwable);

		this.content = content;
	}

	public OrtException(Integer code, String content) {
		super(content);
		this.code = code;
		this.content = content;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public ExceptionInfo getInfo() {
		ExceptionInfo exceptionInfo = new ExceptionInfo(this.code, this.args,
				this.content);
		return exceptionInfo;
	}
}
