package com.mhz.manager.controller;

import com.mhz.common.pojo.EasyUIDataGridResult;
import com.mhz.manager.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/dataGridList",params = {"navId"})
    @ResponseBody
    public EasyUIDataGridResult getArticleDataGrid(int navId, Integer page, Integer rows) {
        return articleService.getArticleDataGrid(navId, page, rows);
    }
}
