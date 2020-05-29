package com.klbud.discover.service.annotation;

import com.klbud.discover.annotation.TestAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author kevin
 * 2020/5/29 - 16:45
 */
public class ExplainMyAnnotation {
    public void explain(Method method) {
        Annotation[] annotations = method.getAnnotations();
        for (Annotation anno : annotations) {
            if (anno instanceof TestAnnotation) {
                TestAnnotation myAnnotation = (TestAnnotation) anno;
                System.out.println(myAnnotation.TYPE());
                System.out.println(myAnnotation.toString());
            }
        }
    }
}
