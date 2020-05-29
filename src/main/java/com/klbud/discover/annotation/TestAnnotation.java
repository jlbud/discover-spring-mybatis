package com.klbud.discover.annotation;

import java.lang.annotation.*;

/**
 * @author kevin
 * 2020/5/29 - 16:39
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {
    String TYPE() default TestAnnotation.EAnno;

    public static final String EAnno = "E";
    public static final String WAnno = "W";
}

