package com.mhz.select.service;

import com.mhz.common.pojo.EasyUIDataGridResult;

public interface ArticleService {

    public EasyUIDataGridResult getArticleDataGrid(int navId, Integer page, Integer rows);
}
