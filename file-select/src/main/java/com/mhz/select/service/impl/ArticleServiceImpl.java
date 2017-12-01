package com.mhz.select.service.impl;

import com.github.pagehelper.PageHelper;
import com.mhz.common.mapper.TbArticlesMapper;
import com.mhz.common.pojo.EasyUIDataGridResult;
import com.mhz.common.pojo.TbArticles;
import com.mhz.common.pojo.TbArticlesExample;
import com.mhz.select.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private TbArticlesMapper articlesMapper;

    @Override
    public EasyUIDataGridResult getArticleDataGrid(int navId,Integer page,Integer rows) {
        TbArticlesExample example = new TbArticlesExample();
        TbArticlesExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo((byte)1);
        criteria.andNavIdEqualTo(navId);
        PageHelper.startPage(page,rows);
        List<TbArticles> tbArticles = articlesMapper.selectByExample(example);
        EasyUIDataGridResult gridResult = new EasyUIDataGridResult();
        gridResult.setTotal(tbArticles.size());
        gridResult.setRows(tbArticles);
        return gridResult;
    }
}
