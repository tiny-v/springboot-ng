package com.my.sb.core.security.anotation;

import java.lang.annotation.*;


@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SignInAccount {

    String value() default "";

}
