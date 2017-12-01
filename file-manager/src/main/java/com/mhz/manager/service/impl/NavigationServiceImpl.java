package com.mhz.manager.service.impl;

import com.mhz.common.mapper.TbNavigationMapper;
import com.mhz.common.pojo.EasyUITreeNode;
import com.mhz.common.pojo.TbNavigation;
import com.mhz.common.pojo.TbNavigationExample;
import com.mhz.common.utils.HttpClientUtil;
import com.mhz.common.utils.JsonUtils;
import com.mhz.common.utils.Msg;
import com.mhz.manager.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NavigationServiceImpl implements NavigationService {

    @Autowired
    private TbNavigationMapper navigationMapper;

    @Value("${SELECT_BASE_URL}")
    private String SELECT_BASE_URL;
    @Value("${SELECT_NAVIGATION_TREE_NODE}")
    private String SELECT_NAVIGATION_TREE_NODE;

    @Override
    public List<EasyUITreeNode> getNavigationTreeNode(int depId, int pid) {

        String url = SELECT_BASE_URL+SELECT_NAVIGATION_TREE_NODE;
        Map<String, String> param = new HashMap<>();
        param.put("depId",depId+"");
        param.put("id",pid+"");
        String result = HttpClientUtil.doPost(url,param);

        if(!StringUtils.isEmpty(result)){
            List<EasyUITreeNode> treeNodes = JsonUtils.jsonToList(result,EasyUITreeNode.class);
            return treeNodes;
        }
        return  null;
    }

    @Override
    public Msg createNavigationTreeNode(int depId, String navigation, int parentId) {
        TbNavigation tbNavigation = new TbNavigation();
        tbNavigation.setDepId(depId);
        tbNavigation.setNavigation(navigation);
        tbNavigation.setPid(parentId);

        tbNavigation.setStatus((byte)1);
        tbNavigation.setIsParent((byte)0);

        navigationMapper.insert(tbNavigation);

        if(parentId!=0){
            TbNavigation parentNavigation = navigationMapper.selectByPrimaryKey(parentId);
            parentNavigation.setIsParent((byte) 1);
            navigationMapper.updateByPrimaryKey(parentNavigation);
        }

        return Msg.ok(tbNavigation);
    }

    @Override
    public Msg updateNavigationTreeNode(int id, String navigation) {
        TbNavigation tbNavigation = navigationMapper.selectByPrimaryKey(id);
        tbNavigation.setNavigation(navigation);
        navigationMapper.updateByPrimaryKey(tbNavigation);
        return Msg.ok();
    }

    @Override
    public Msg deleteNavigationTreeNode(int id) {
        TbNavigation tbNavigation = navigationMapper.selectByPrimaryKey(id);
        tbNavigation.setStatus((byte)0);
        navigationMapper.updateByPrimaryKey(tbNavigation);

        int pId = tbNavigation.getPid();

        if(pId!=0){
            //更新父导航
            TbNavigationExample example = new TbNavigationExample();
            TbNavigationExample.Criteria criteria = example.createCriteria();
            criteria.andPidEqualTo(pId);
            criteria.andStatusNotEqualTo((byte)0);
            List<TbNavigation> tbNavigations = navigationMapper.selectByExample(example);

            if(tbNavigations==null||tbNavigations.size() == 0){
                tbNavigation = navigationMapper.selectByPrimaryKey(tbNavigation.getPid());
                tbNavigation.setIsParent((byte)0);
                navigationMapper.updateByPrimaryKey(tbNavigation);
            }
        }


        return Msg.ok();
    }
}
