package com.mhz.select.service;

import com.mhz.common.pojo.EasyUITreeNode;
import com.mhz.common.utils.Msg;

import java.util.List;

public interface NavigationService {

    public List<EasyUITreeNode> getNavigationTreeNode(int depId, int pid);

}
