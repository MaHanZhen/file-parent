package com.mhz.manager.service.impl;

import com.mhz.common.pojo.EasyUIDataGridResult;
import com.mhz.manager.service.ArticleService;
import com.mhz.manager.utils.HttpResultUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {


    @Value("${SELECT_BASE_URL}")
    private String SELECT_BASE_URL;
    @Value("${SELECT_ARTICLE_DATA_GRID_LIST}")
    private String SELECT_ARTICLE_DATA_GRID_LIST;

    @Override
    public EasyUIDataGridResult getArticleDataGrid(int navId,Integer page,Integer rows) {
        String url = SELECT_BASE_URL+SELECT_ARTICLE_DATA_GRID_LIST;
        return HttpResultUtils.getEasyUIDataGridResult(url,page,rows,"navId",navId+"");
    }
}
