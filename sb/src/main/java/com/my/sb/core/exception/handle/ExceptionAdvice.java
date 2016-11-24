package com.my.sb.core.exception.handle;

import com.my.sb.core.exception.ExceptionInfo;
import com.my.sb.core.exception.ExceptionInfoGetter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.UndeclaredThrowableException;

@ComponentScan
@ControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ExceptionData handleException(Exception ex) {
		ExceptionData exceptionData = null;
		Throwable exception = getHasInfoException(ex);
		if (exception == null) {
			exceptionData = new ExceptionData(HttpStatus.BAD_REQUEST.value(),
					"发生未知的错误");
		} else {
			ExceptionInfo exceptionInfo = ((ExceptionInfoGetter) exception)
					.getInfo();
			String message = exceptionInfo.getMessage();

			Integer code = exceptionInfo.getCode();

			if (StringUtils.isEmpty(message)) {
				message = "发生未知的错误";
			}
			exceptionData = new ExceptionData(code, message);
		}
        ex.printStackTrace();
		return exceptionData;
	}

	private Throwable getHasInfoException(Throwable throwable) {
		Throwable exception = null;

		if (throwable instanceof ExceptionInfoGetter) {
			exception = (Exception) throwable;
		}

		Throwable childThrowable = null;
		if (throwable instanceof UndeclaredThrowableException) {
			childThrowable = ((UndeclaredThrowableException) throwable)
					.getUndeclaredThrowable();
		} else {
			childThrowable = throwable.getCause();
		}
		if (childThrowable != null) {
			Throwable childExp = getHasInfoException(childThrowable);
			if (childExp != null) {
				return childExp;
			}
		}

		return exception;
	}
}
