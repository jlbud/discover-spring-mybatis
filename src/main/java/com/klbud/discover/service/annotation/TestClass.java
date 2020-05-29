package com.klbud.discover.service.annotation;

import com.klbud.discover.annotation.TestAnnotation;

/**
 * @author kevin
 * 2020/5/29 - 16:42
 */
// 测试自定义注解用
public class TestClass {
    @TestAnnotation()
    public void eat() {
        System.out.println("吃饭");
    }

    @TestAnnotation(TYPE = TestAnnotation.WAnno)
    public void watch() {
        System.out.println("电视");
    }
}
