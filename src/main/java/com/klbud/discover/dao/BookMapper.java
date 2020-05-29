package com.klbud.discover.dao;

import com.klbud.discover.annotation.DbSource;
import com.klbud.discover.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kevin
 * 2020/5/25 - 16:45
 */

@Repository
public interface BookMapper {
    @DbSource
    List<Question> getList();
}
