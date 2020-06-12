package com.zk.knowobjectpool.config.sftp;

import com.jcraft.jsch.ChannelSftp;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class SftpPool  extends GenericKeyedObjectPool<String,ChannelSftp> {

    public SftpPool(PooledObjectFactory factory, GenericObjectPoolConfig config) {
        super(factory,config);
    }

    @Override
    public ChannelSftp borrowObject() throws Exception {
        return super.borrowObject();
    }

    @Override
    public void returnObject(ChannelSftp obj) {
        super.returnObject(obj);
    }
    //还包含其他的一些操作
}
