package com.mhz.common.mapper;

import com.mhz.common.pojo.TbNavigation;
import com.mhz.common.pojo.TbNavigationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbNavigationMapper {
    int countByExample(TbNavigationExample example);

    int deleteByExample(TbNavigationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbNavigation record);

    int insertSelective(TbNavigation record);

    List<TbNavigation> selectByExample(TbNavigationExample example);

    TbNavigation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbNavigation record, @Param("example") TbNavigationExample example);

    int updateByExample(@Param("record") TbNavigation record, @Param("example") TbNavigationExample example);

    int updateByPrimaryKeySelective(TbNavigation record);

    int updateByPrimaryKey(TbNavigation record);
}