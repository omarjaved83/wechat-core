package com.jonnyliu.proj.wechat.example;

import com.jonnyliu.proj.wechat.annotation.MessageProcessor;
import com.jonnyliu.proj.wechat.enums.MessageType;
import com.jonnyliu.proj.wechat.handler.AbstractMessageHandler;
import com.jonnyliu.proj.wechat.message.request.BaseRequestMessage;
import com.jonnyliu.proj.wechat.message.request.LocationRequestMessage;
import com.jonnyliu.proj.wechat.message.response.BaseResponseMessage;
import com.jonnyliu.proj.wechat.utils.MessageUtils;
import org.springframework.stereotype.Component;

/**
 * 地理位置消息接收 的 code example
 * <p/>
 * User: jonnyliu@tcl.com <br/>
 * Date: on 2016-08-19 13:07.
 */
@Component
@MessageProcessor(messageType = MessageType.LOCATION_MESSAGE)
public class LocationMessageHandlerExample extends AbstractMessageHandler {
    @Override
    public BaseResponseMessage doHandleMessage(BaseRequestMessage baseRequestMessage) {
        //在这里实现你自己的业务逻辑
        LocationRequestMessage locationRequestMessage = (LocationRequestMessage) baseRequestMessage;
        String content = "您发送的地理位置消息如下：\nlabel:%s,\nlocation_x:%s,\nlocation_y:%s,\nscale:%s ";
        content = String.format(content,locationRequestMessage.getLabel(),locationRequestMessage.getLocation_X(),locationRequestMessage.getLocation_Y(),locationRequestMessage.getScale());
        return MessageUtils.buildTextResponseMessage(baseRequestMessage,content);
    }
}
