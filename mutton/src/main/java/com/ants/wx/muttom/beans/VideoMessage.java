package com.ants.wx.muttom.beans;

import lombok.Data;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/1/26
 */
@Data
public class VideoMessage extends BaseMessage {
    // 视频消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;
    // 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
    private String ThumbMediaId;
}
