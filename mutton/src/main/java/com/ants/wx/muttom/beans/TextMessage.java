package com.ants.wx.muttom.beans;

import lombok.Data;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/1/26
 */
@Data
public class TextMessage  extends BaseMessage{
    // 消息内容
    private String Content;
}
