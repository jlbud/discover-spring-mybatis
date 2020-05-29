package com.klbud.discover.aop;

import com.klbud.discover.annotation.DbSource;
import com.klbud.discover.utils.DbSourceContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Aspect
@Component
@Order(-1)
public class DynamicDataSourceAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("@annotation(dbSource)")
    public void switchDataSource(JoinPoint point, DbSource dbSource) {
        // 注解中的默认值
        if (!StringUtils.isEmpty(dbSource.value())) {
            DbSourceContext.setDbContext(dbSource.value());
            return;
        }

        String postfix = "00";
        if (!StringUtils.isEmpty(postfix)) {
            DbSourceContext.setDbContext(postfix);
        }
    }

    @After("@annotation(dbSource)")
    public void restoreDataSource(JoinPoint point, DbSource dbSource) {
        DbSourceContext.clearDbSource();
    }
}
