package com.mhz.manager.controller;

import com.mhz.common.pojo.EasyUITreeNode;
import com.mhz.common.utils.Msg;
import com.mhz.manager.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/navigation")
public class NavigationController {
    @Autowired
    private NavigationService navigationService;

    @RequestMapping("/treeNode")
    @ResponseBody
    public List<EasyUITreeNode> getNavigationTreeNode(@RequestParam(value = "depId") int depId, @RequestParam(value = "id", defaultValue = "0") Integer pId) {
        return navigationService.getNavigationTreeNode(depId, pId);
    }

    @RequestMapping(value = "/create",params = {"depId","name","parentId"})
    @ResponseBody
    public Msg createNavigationTreeNode(Integer depId, String name, Integer parentId) {
        return navigationService.createNavigationTreeNode(depId, name, parentId);
    }

    @RequestMapping(value = "/update",params = {"id","name"})
    @ResponseBody
    public Msg updateNavigationTreeNode(int id ,String name) {
        return navigationService.updateNavigationTreeNode(id, name );
    }

    @RequestMapping(value = "/delete",params = {"id"})
    @ResponseBody
    public Msg deleteNavigationTreeNode(int id) {
        return navigationService.deleteNavigationTreeNode(id);
    }
}
