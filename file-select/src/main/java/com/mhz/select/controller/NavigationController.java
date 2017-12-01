package com.mhz.select.controller;

import com.mhz.common.pojo.EasyUITreeNode;
import com.mhz.select.service.NavigationService;
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

}
