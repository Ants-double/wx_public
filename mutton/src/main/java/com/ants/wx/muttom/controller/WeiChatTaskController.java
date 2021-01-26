package com.ants.wx.muttom.controller;

import com.ants.wx.muttom.server.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/1/26
 */
@Component
@Slf4j
public class WeiChatTaskController {
    @Resource
    private TaskService taskService;


    @PostMapping("/getToken")
    @Scheduled(fixedDelay=2*60*60*1000)
    public void getToken() throws Exception {
        log.info("定时任务：重新获取token");
        taskService.getToken();
    }
}
