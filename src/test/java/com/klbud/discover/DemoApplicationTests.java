package com.klbud.discover;

import com.klbud.discover.service.annotation.ExplainMyAnnotation;
import com.klbud.discover.service.annotation.TestClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;

@SpringBootTest(classes = DiscoverApplication.class)
class DemoApplicationTests {

    @Test
    void aop() {
        ExplainMyAnnotation e = new ExplainMyAnnotation();
        TestClass t = new TestClass();
        Method[] m = t.getClass().getMethods();
        for (int i = 0; i < m.length; i++) {
            System.out.println("第" + i + "次");
            e.explain(m[i]);
        }
    }
}