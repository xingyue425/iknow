package com.zk.config.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.Properties;

public class SftpFactory extends BasePooledObjectFactory<ChannelSftp> {

    private SftpConfigProperties sftpConfigProperties;

    public SftpFactory(SftpConfigProperties sftpConfigProperties){
        this.sftpConfigProperties=sftpConfigProperties;
    }

    public SftpConfigProperties getSftpConfigProperties() {
        return sftpConfigProperties;
    }

    public void setSftpConfigProperties(SftpConfigProperties sftpConfigProperties) {
        this.sftpConfigProperties = sftpConfigProperties;
    }

    @Override
    public ChannelSftp create() {
        try {
            JSch jsch = new JSch();
            Session sshSession = jsch.getSession(sftpConfigProperties.getUserName(), sftpConfigProperties.getHost(),
                    sftpConfigProperties.getPort());
            sshSession.setPassword(sftpConfigProperties.getPassword());
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            ChannelSftp channel = (ChannelSftp) sshSession.openChannel("sftp");
            channel.connect();
            return channel;
        } catch (JSchException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PooledObject<ChannelSftp> wrap(ChannelSftp channelSftp) {
        return new DefaultPooledObject<>(channelSftp);
    }

    // 销毁对象
    @Override
    public void destroyObject(PooledObject<ChannelSftp> p) {
        ChannelSftp channelSftp = p.getObject();
        channelSftp.disconnect();
    }
}
