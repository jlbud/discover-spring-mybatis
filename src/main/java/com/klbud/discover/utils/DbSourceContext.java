package com.klbud.discover.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kevin
 * 2020/5/29 - 14:27
 */
public class DbSourceContext {
    private static final Logger logger = LoggerFactory.getLogger(DbSourceContext.class);

    private static final ThreadLocal<String> dbContext = new ThreadLocal<String>();

    public static void setDbContext(String source) {
        logger.debug("set source ====>" + source);
        dbContext.set(source);
    }

    public static String getDbContext() {
        logger.debug("get source ====>" + dbContext.get());
        return dbContext.get();
    }

    public static void clearDbSource() {
        dbContext.remove();
    }

}
