package com.zk.knowobjectpool.config.sftp;

import com.jcraft.jsch.ChannelSftp;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("ftp") //指明前缀
public class SftpProperties {

    private String host;
    private int port;
    private String username;
    private String password;
    private int timeout;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    private Pool pool = new Pool();

    public static class Pool extends GenericObjectPoolConfig<ChannelSftp> {

        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public Pool() {
            super();
            this.setTestWhileIdle(true);
            this.setTestOnCreate(true);
            this.setTestOnBorrow(true);
            this.setTestOnReturn(true);
        }
        @Override
        public int getMaxTotal() {
            return maxTotal;
        }
        @Override
        public void setMaxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
        }
        @Override
        public int getMaxIdle() {
            return maxIdle;
        }
        @Override
        public void setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
        }
        @Override
        public int getMinIdle() {
            return minIdle;
        }
        @Override
        public void setMinIdle(int minIdle) {
            this.minIdle = minIdle;
        }
    }
}