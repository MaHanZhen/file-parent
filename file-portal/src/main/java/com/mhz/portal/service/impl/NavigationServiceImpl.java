package com.mhz.portal.service.impl;

import com.mhz.common.pojo.EasyUITreeNode;
import com.mhz.portal.service.NavigationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavigationServiceImpl implements NavigationService {
    @Override
    public List<EasyUITreeNode> getNavigationTreeNode(int depId, int pid) {
        return null;
    }
}
