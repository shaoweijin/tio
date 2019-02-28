package cn.videon.redis.message.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

@ConfigurationProperties("application")
public class ApplicationProperties implements Serializable {

    private final Tio tio = new Tio();

    private final Redis redis = new Redis();


    public Tio getTio() {
        return tio;
    }

    public Redis getRedis() {
        return redis;
    }

    public static class Redis implements Serializable{
        private String channel;

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        @Override
        public String toString() {
            return "Redis{" +
                    "channel='" + channel + '\'' +
                    '}';
        }
    }

    public static class Tio implements Serializable {
        private boolean server;
        private Integer port;
        private Integer heartbeatTimeout;
        private String serverHost;

        public boolean getServer() {
            return server;
        }

        public void setServer(boolean server) {
            this.server = server;
        }

        public Integer getHeartbeatTimeout() {
            return heartbeatTimeout;
        }

        public void setHeartbeatTimeout(Integer heartbeatTimeout) {
            this.heartbeatTimeout = heartbeatTimeout;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }

        @Override
        public String toString() {
            return "Tio{" +
                    "server=" + server +
                    ", port=" + port +
                    ", heartbeatTimeout=" + heartbeatTimeout +
                    ", serverHost='" + serverHost + '\'' +
                    '}';
        }

        public String getServerHost() {
            return serverHost;
        }

        public void setServerHost(String serverHost) {
            this.serverHost = serverHost;
        }
    }

    @Override
    public String toString() {
        return "ApplicationProperties{" +
                "tio=" + tio +
                ", redis=" + redis +
                '}';
    }
}