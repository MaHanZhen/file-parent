package com.mhz.common.mapper;

import com.mhz.common.pojo.TbArticles;
import com.mhz.common.pojo.TbArticlesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbArticlesMapper {
    int countByExample(TbArticlesExample example);

    int deleteByExample(TbArticlesExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbArticles record);

    int insertSelective(TbArticles record);

    List<TbArticles> selectByExampleWithBLOBs(TbArticlesExample example);

    List<TbArticles> selectByExample(TbArticlesExample example);

    TbArticles selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbArticles record, @Param("example") TbArticlesExample example);

    int updateByExampleWithBLOBs(@Param("record") TbArticles record, @Param("example") TbArticlesExample example);

    int updateByExample(@Param("record") TbArticles record, @Param("example") TbArticlesExample example);

    int updateByPrimaryKeySelective(TbArticles record);

    int updateByPrimaryKeyWithBLOBs(TbArticles record);

    int updateByPrimaryKey(TbArticles record);
}