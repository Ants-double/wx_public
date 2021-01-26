package com.ants.wx.muttom.beans;

import lombok.Data;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/1/26
 */
@Data
public class LinkMessageReq extends BaseMessage {
    // 消息标题
    private String Title;
    // 消息描述
    private String Description;
    // 消息链接
    private String Url;
}
