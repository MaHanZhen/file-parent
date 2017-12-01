package com.mhz.manager.utils;

import com.mhz.common.pojo.EasyUIDataGridResult;
import com.mhz.common.utils.HttpClientUtil;
import com.mhz.common.utils.JsonUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/*
* 处理HTTP请求结果
* */
public class HttpResultUtils {

    /*获取一个EasyUIDataGridResult结果
    * url:请求路径
    * page:页面
    * rows:一页多少行
    * param:扩展参数,以一对形式插入 如... "navId","233"
    * */
    public static EasyUIDataGridResult getEasyUIDataGridResult(String url,Integer page,Integer rows,String ...param){
        Map map = new HashMap();
        map.put("page", page.toString());
        map.put("rows", rows.toString());
        if(param!=null){
           for(int i =0;i<param.length;i+=2){
               map.put(param[i],param[i+1]);
           }
        }
        String result = HttpClientUtil.doPost(url,map);
        if(!StringUtils.isEmpty(result)){
            EasyUIDataGridResult gridResult = JsonUtils.jsonToPojo(result,EasyUIDataGridResult.class);
            return gridResult;
        }
        return null;
    }
}
