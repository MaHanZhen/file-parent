package com.mhz.common.mapper;

import com.mhz.common.pojo.TbArticlesDecs;
import com.mhz.common.pojo.TbArticlesDecsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbArticlesDecsMapper {
    int countByExample(TbArticlesDecsExample example);

    int deleteByExample(TbArticlesDecsExample example);

    int insert(TbArticlesDecs record);

    int insertSelective(TbArticlesDecs record);

    List<TbArticlesDecs> selectByExampleWithBLOBs(TbArticlesDecsExample example);

    List<TbArticlesDecs> selectByExample(TbArticlesDecsExample example);

    int updateByExampleSelective(@Param("record") TbArticlesDecs record, @Param("example") TbArticlesDecsExample example);

    int updateByExampleWithBLOBs(@Param("record") TbArticlesDecs record, @Param("example") TbArticlesDecsExample example);

    int updateByExample(@Param("record") TbArticlesDecs record, @Param("example") TbArticlesDecsExample example);
}