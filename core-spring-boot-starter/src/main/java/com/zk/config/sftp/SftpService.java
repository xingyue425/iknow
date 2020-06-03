package com.zk.config.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class SftpService {

    private SftpPool pool;

    public SftpService(){}

    public SftpService(SftpPool pool){
        this.pool=pool;
    }

    /**
     * sftp一个目录下的所有文件名称
     * @param dir
     * @return
     */
    public List<String> listFiles(String dir){

        List<String> files=new ArrayList<String>();
        ChannelSftp sftp = pool.borrowObject();
        try {
            Vector vec=sftp.ls(dir);
            if(vec!=null && !vec.isEmpty()){
                Iterator i$ = vec.iterator();
                while(i$.hasNext()) {
                    Object item = i$.next();
                    if (item instanceof ChannelSftp.LsEntry) {
                        String fileName = ((ChannelSftp.LsEntry)item).getFilename();
                        if (!fileName.equals(".") && !fileName.equals("..")) {
                            files.add(fileName);
                        }
                    }
                }
            }else{
                //TODO
            }
        } catch (SftpException e) {
            //TODO
        }finally {
            pool.returnObject(sftp);
        }
        return files;
    }

    /**
     * 下载文件
     * @param remotePath 远程目录
     * @param name 远程文件名
     * @param localPath 下载目录
     * @return 文件字节数组
     */
    public void download(String remotePath, String localPath, String name) {
        ChannelSftp sftp = pool.borrowObject();
        try {
            sftp.cd(remotePath);
            sftp.get(name,localPath+name);

            return;
        } catch (SftpException e) {
            //TODO
        }finally {
            try {
                sftp.cd(sftp.getHome());
            } catch (SftpException e) {
                e.printStackTrace();
            }
            pool.returnObject(sftp);
        }
    }
    public boolean downloadFiles(String remotePath, String localPath, List<String> files){
        ChannelSftp sftp = pool.borrowObject();
        try {
            sftp.cd(remotePath);
            if(files!=null && files.size()>0){
                for(String name:files){

                    try {
                        sftp.get(name, localPath + name);
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
            return true;
        } catch (Exception e) {
            //TODO
        } finally {
            try {
                sftp.cd(sftp.getHome());
            } catch (SftpException e) {
                e.printStackTrace();
            }
            pool.returnObject(sftp);
        }
        return false;
    }

    /**
     * 上传文件
     * @param dir 远程目录
     * @param name 远程文件名
     * @param localPath 本地目录
     */
    public void upload(String dir, String name, String localPath) {
        ChannelSftp sftp = pool.borrowObject();
        try {
            sftp.cd(dir);
            sftp.put(localPath+name,name);
        } catch (SftpException e) {
            //TODO
        } finally {
            try {
                sftp.cd(sftp.getHome());
            } catch (SftpException e) {
                e.printStackTrace();
            }
            pool.returnObject(sftp);
        }
    }
    public void uploadFiles(String dir, List<String> files, String localPath) {
        ChannelSftp sftp = pool.borrowObject();
        try {
            sftp.cd(dir);
            if(files!=null && files.size()>0){
                for(String name:files) {
                    sftp.put(localPath + name, name);
                    Thread.sleep(100);
                }
            }
        } catch (Exception e) {
            //TODO
        } finally {
            try {
                sftp.cd(sftp.getHome());
            } catch (SftpException e) {
                e.printStackTrace();
            }
            pool.returnObject(sftp);
        }
    }

    /**
     * 删除文件
     * @param dir 远程目录
     * @param name 远程文件名
     */
    public void delete(String dir, String name) {
        ChannelSftp sftp = pool.borrowObject();
        try {
            sftp.cd(dir);
            sftp.rm(name);
        } catch (SftpException e) {
            //TODO
        } finally {
            try {
                sftp.cd(sftp.getHome());
            } catch (SftpException e) {
                e.printStackTrace();
            }
            pool.returnObject(sftp);
        }
    }
    public void deleteAll(String dir,List<String> files) {
        ChannelSftp sftp = pool.borrowObject();
        try {
            sftp.cd(dir);
            if(files!=null && files.size()>0) {
                for(String name:files) {
                    sftp.rm(name);
                    Thread.sleep(100);
                }
            }
        } catch (SftpException e) {
            //TODO
        } catch (InterruptedException e) {
            //TODO
        } finally {
            try {
                sftp.cd(sftp.getHome());
            } catch (SftpException e) {
                e.printStackTrace();
            }
            pool.returnObject(sftp);
        }
    }
}
