package com.klbud.discover.controller;

import com.klbud.discover.entity.Question;
import com.klbud.discover.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kevin
 * 2020/5/25 - 16:34
 */
@RestController
public class HelloController {
    @Autowired
    public IBookService service;

    @GetMapping("/hello")
    public List<Question> hello() {
        List<Question> questions = service.getList();
        return questions;
    }
}
