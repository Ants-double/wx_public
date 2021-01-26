package com.ants.wx.muttom.server.impl;

import com.alibaba.fastjson.JSONObject;
import com.ants.wx.muttom.configs.WeChatConfiguration;
import com.ants.wx.muttom.server.TaskService;
import com.ants.wx.muttom.util.HttpUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/1/26
 */
@Service("TaskService")
public class TaskServiceImpl implements TaskService {

    @Resource
    private WeChatConfiguration weChatConfiguration;

    @Override
    public void getToken() throws Exception {
        Map<String, String> params = new HashMap<String, String>();

        params.put("grant_type", "client_credential");
        params.put("appid", weChatConfiguration.getAppid());
        params.put("secret", weChatConfiguration.getAppSecret());

        String json = HttpUtils.sendGet(weChatConfiguration.getTokenUrl(), params);
        String access_token = JSONObject.parseObject(json).getString("access_token");

        System.out.println(LocalDateTime.now() +"token为=============================="+access_token);
    }
}
