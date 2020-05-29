package com.klbud.discover.config;

import com.klbud.discover.utils.DbSourceContext;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DbSourceContext.getDbContext();
    }
}
