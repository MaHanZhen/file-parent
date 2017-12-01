package com.mhz.manager.service;

import com.mhz.common.pojo.EasyUITreeNode;
import com.mhz.common.utils.Msg;

import java.util.List;

public interface NavigationService {

    public List<EasyUITreeNode> getNavigationTreeNode(int depId, int pid);

    public Msg createNavigationTreeNode(int depId,String navigation ,int parentId );
    public Msg updateNavigationTreeNode(int id,String navigation );

    public Msg deleteNavigationTreeNode(int id);
}
