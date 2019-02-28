package cn.videon.redis.message.tio.server;

import cn.videon.redis.message.config.ApplicationProperties;
import cn.videon.redis.message.tio.util.TioUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tio.core.Tio;
import org.tio.server.ServerGroupContext;
import org.tio.server.TioServer;
import org.tio.server.intf.ServerAioListener;

import java.io.IOException;

@Component
public class ServerMessage {

    @Autowired
    private ApplicationProperties properties;

    private static final Logger log = LoggerFactory.getLogger(ServerMessage.class);

    //handler, 包括编码、解码、消息处理
    @Autowired
    private ServerMessageHandler aioHandler;

    //事件监听器，可以为null，但建议自己实现该接口，可以参考showcase了解些接口
    @Autowired
    private ServerAioListener aioListener;

    private ServerGroupContext serverGroupContext;


    /**
     * 启动程序入口
     */
    public ServerMessage start() {
        //一组连接共用的上下文对象
        log.debug("server properties is {}", properties);
        serverGroupContext = new ServerGroupContext("redis-tio-server", aioHandler, aioListener);
        serverGroupContext.setHeartbeatTimeout(properties.getTio().getHeartbeatTimeout());
        //tioServer对象
        TioServer tioServer = new TioServer(serverGroupContext);
        try {
            tioServer.start(properties.getTio().getServerHost(), properties.getTio().getPort());
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getLocalizedMessage());
        }
        return this;
    }

    /**
     * 发送消息
     *
     * @param value
     */
    public void send(Object value) {
        Tio.sendToAll(serverGroupContext, TioUtil.toPacket(value));
    }
}
