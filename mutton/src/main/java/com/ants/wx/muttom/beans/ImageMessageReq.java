package com.ants.wx.muttom.beans;

import lombok.Data;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/1/26
 */
@Data
public class ImageMessageReq extends BaseMessage {
    // 图片链接
    private String PicUrl;
    //图片消息媒体id，可以调用获取临时素材接口拉取数据。
    private String MediaId;
}
