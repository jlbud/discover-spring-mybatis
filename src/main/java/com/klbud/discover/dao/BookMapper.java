package com.klbud.discover.dao;

import com.klbud.discover.entity.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author kevin
 * 2020/5/25 - 16:45
 */

@Mapper
public interface BookMapper {
    List<Question> getAllBooks();
}
