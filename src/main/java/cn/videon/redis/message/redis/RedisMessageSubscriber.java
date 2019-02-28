package cn.videon.redis.message.redis;

import cn.videon.redis.message.config.ApplicationProperties;
import cn.videon.redis.message.domain.Record;
import cn.videon.redis.message.service.RecordService;
import cn.videon.redis.message.tio.client.ClientMessage;
import cn.videon.redis.message.tio.server.ServerMessage;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisMessageSubscriber implements MessageListener {

    private final Logger log = LoggerFactory.getLogger(RedisMessageSubscriber.class);

    /**
     * @description: 接收redis中的消息
     * @param:
     * @return:
     * @author: Limy
     * @date: 18/3/23
     */
    @Override
    public void onMessage(final Message message, final byte[] bytes) {

    }
}
