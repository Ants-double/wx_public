package com.ants.wx.muttom.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/1/26
 */
@Component
@Data
@ConfigurationProperties(prefix = "wechat")
public class WeChatConfiguration {
    private String appid;

    private String AppSecret;

    private String tokenUrl;

}
