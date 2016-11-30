package com.my.sa.core.security.anotation;

import java.lang.annotation.*;


@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SignInAccount {

    String value() default "";

}
