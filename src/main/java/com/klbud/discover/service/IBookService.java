package com.klbud.discover.service;

import com.klbud.discover.entity.Question;

import java.util.List;

/**
 * @author kevin
 * 2020/5/25 - 16:47
 */
//@Mapper
public interface IBookService {

    List<Question> getList();
}
