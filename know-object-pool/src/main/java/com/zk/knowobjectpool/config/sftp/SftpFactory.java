package com.zk.knowobjectpool.config.sftp;

import com.jcraft.jsch.ChannelSftp;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;

public class SftpFactory implements PooledObjectFactory<ChannelSftp> {

    @Override
    public PooledObject<ChannelSftp> makeObject() throws Exception {
        return null;
    }

    @Override
    public void destroyObject(PooledObject<ChannelSftp> pooledObject) throws Exception {

    }

    @Override
    public boolean validateObject(PooledObject<ChannelSftp> pooledObject) {
        return false;
    }

    @Override
    public void activateObject(PooledObject<ChannelSftp> pooledObject) throws Exception {

    }

    @Override
    public void passivateObject(PooledObject<ChannelSftp> pooledObject) throws Exception {

    }
}
