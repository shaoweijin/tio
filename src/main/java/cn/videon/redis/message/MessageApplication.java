package cn.videon.redis.message;

import cn.videon.redis.message.config.ApplicationProperties;
import cn.videon.redis.message.tio.client.ClientMessage;
import cn.videon.redis.message.tio.server.ServerMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
@EnableConfigurationProperties({ApplicationProperties.class})
public class MessageApplication {

    private static final Logger log = LoggerFactory.getLogger(MessageApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class, args);
    }

    @Autowired
    private ApplicationProperties properties;

    @Autowired
    private ServerMessage serverMessage;

    @Autowired
    private ClientMessage clientMessage;

    @Bean(name = "message")
    public Object getMessage() {
        if (properties.getTio().getServer()) {
            log.info("server");
            return serverMessage.start();
        } else {
            log.info("client");
            return clientMessage.start();
        }
    }
}

