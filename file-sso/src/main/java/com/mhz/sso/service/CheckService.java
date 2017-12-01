package com.mhz.sso.service;


import com.mhz.common.utils.Msg;
/*类目：CheckService
* 验证传入的数据在数据库中是否存在
* */
public interface CheckService {
    /*
    * type:类型(1:用户名,2:邮箱)
    * value:值
    * */
    public Msg checkData(int type,int value);
}
