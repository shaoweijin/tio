package cn.videon.redis.message.tio.client;

import cn.videon.redis.message.tio.MessagePacket;
import cn.videon.redis.message.tio.util.TioUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.tio.client.intf.ClientAioHandler;
import org.tio.core.ChannelContext;
import org.tio.core.GroupContext;
import org.tio.core.exception.AioDecodeException;
import org.tio.core.intf.Packet;

import java.nio.ByteBuffer;
import java.util.Objects;


@Service
public class ClientMessageHandler implements ClientAioHandler {

    private static final Logger log = LoggerFactory.getLogger(ClientMessageHandler.class);

    private MessagePacket messagePacket = new MessagePacket();

    /**
     * 创建心跳包
     *
     * @return
     * @author tanyaowu
     */
    @Override
    public Packet heartbeatPacket() {
        return messagePacket;
    }

    /**
     * 根据ByteBuffer解码成业务需要的Packet对象.
     * 如果收到的数据不全，导致解码失败，请返回null，在下次消息来时框架层会自动续上前面的收到的数据
     *
     * @param buffer         参与本次希望解码的ByteBuffer
     * @param limit          ByteBuffer的limit
     * @param position       ByteBuffer的position，不一定是0哦
     * @param readableLength ByteBuffer参与本次解码的有效数据（= limit - position）
     * @param channelContext
     * @return
     * @throws AioDecodeException
     */
    @Override
    public Packet decode(ByteBuffer buffer, int limit, int position, int readableLength, ChannelContext channelContext) throws AioDecodeException {
        return TioUtil.decode(buffer, limit, position, readableLength, channelContext);
    }

    /**
     * 编码
     *
     * @param packet
     * @param groupContext
     * @param channelContext
     * @return
     * @author: tanyaowu
     */
    @Override
    public ByteBuffer encode(Packet packet, GroupContext groupContext, ChannelContext channelContext) {
        return TioUtil.encode(packet, groupContext, channelContext);
    }

    @Autowired
    @Qualifier("myRedisTemplate")
    private StringRedisTemplate redisTemplate;

    /**
     * 处理消息包
     *
     * @param packet
     * @param channelContext
     * @throws Exception
     * @author: tanyaowu
     */
    @Override
    public void handler(Packet packet, ChannelContext channelContext) throws Exception {
        MessagePacket helloPacket = (MessagePacket) packet;
        byte[] body = helloPacket.getBody();
        if (body != null) {
          // ...处理
        }
    }
}
