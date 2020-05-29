package com.klbud.discover.annotation;

import java.lang.annotation.*;

/**
 * @author kevin
 * 2020/5/29 - 11:57
 */
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String value() default "master"; //该值即key值
}
