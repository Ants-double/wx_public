package com.ants.wx.muttom.beans;

import lombok.Data;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/1/26
 */
@Data
public class VoiceMessageReq extends BaseMessage {
    // 语音消息媒体id，可以调用获取临时素材+接口拉取数据。
    private String MediaId;
    // 语音格式
    private String Format;
}