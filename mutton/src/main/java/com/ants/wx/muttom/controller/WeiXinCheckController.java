package com.ants.wx.muttom.controller;

import com.ants.wx.muttom.util.EventDispatcher;
import com.ants.wx.muttom.util.MessageUtil;
import com.ants.wx.muttom.util.MsgDispatcher;
import com.ants.wx.muttom.util.WeiXinSha1;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/1/25
 */
@RestController
@RequestMapping(value = "/check")
public class WeiXinCheckController {


    @Value("${weiXin.token}")
    private String token;

    private static final Logger logger = LoggerFactory.getLogger(WeiXinCheckController.class);

    @GetMapping(value = {"/checkToken"})
    public String doGet(HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException {

        String signature = httpServletRequest.getParameter("signature");
        String timestamp = httpServletRequest.getParameter("timestamp");
        String nonce = httpServletRequest.getParameter("nonce");
        String echostr = httpServletRequest.getParameter("echostr");

        logger.debug(signature);
        logger.debug(timestamp);
        logger.debug(nonce);
        logger.debug(echostr);
        String[] temp = new String[]{token, timestamp, nonce};
        Arrays.sort(temp);
        String str = temp[0]+temp[1]+temp[2];
        logger.debug(str);
        String sha1Hex = WeiXinSha1.encode(str);
        logger.debug(sha1Hex);
        if (sha1Hex.equalsIgnoreCase(signature)) {
            return echostr;
        } else {
            return "";
        }


    }

    @PostMapping(value = {"/checkToken"})
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            Map<String, String> messageMap = MessageUtil.parseXml(request);
            logger.debug("报文："+messageMap);
            logger.debug("消息："+messageMap.get("Content"));
            String type = messageMap.get("MsgType");
            if(MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(type)){
                //事件处理
                EventDispatcher.processEvent(messageMap);
            }else {
                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
                //消息处理
                String data = MsgDispatcher.processMessage(messageMap);
                PrintWriter out = response.getWriter();
                out.print(data);
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    @GetMapping(value = "index")
    public String index(HttpServletRequest httpServletRequest) {
        logger.debug(token);
        return token;
    }
}
