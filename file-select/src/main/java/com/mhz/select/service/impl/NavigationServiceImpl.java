package com.mhz.select.service.impl;

import com.mhz.common.mapper.TbNavigationMapper;
import com.mhz.common.pojo.EasyUITreeNode;
import com.mhz.common.pojo.TbNavigation;
import com.mhz.common.pojo.TbNavigationExample;
import com.mhz.common.utils.Msg;
import com.mhz.select.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NavigationServiceImpl implements NavigationService {

    @Autowired
    private TbNavigationMapper navigationMapper;

    @Override
    public List<EasyUITreeNode> getNavigationTreeNode(int depId, int pid) {
        TbNavigationExample example = new TbNavigationExample();
        TbNavigationExample.Criteria criteria = example.createCriteria();
        criteria.andDepIdEqualTo(depId);
        criteria.andPidEqualTo(pid);
        criteria.andStatusEqualTo((byte)1);
        List<TbNavigation> tbNavigations = navigationMapper.selectByExample(example);

        List<EasyUITreeNode> treeNodes = new ArrayList<>();
        for(TbNavigation navigation:tbNavigations){
            EasyUITreeNode treeNode = new EasyUITreeNode();
            treeNode.setId((long)navigation.getId());
            treeNode.setText(navigation.getNavigation());
            treeNode.setState(navigation.getIsParent() !=0? "closed" : "open");
            treeNodes.add(treeNode);
        }

        return treeNodes;
    }

}
