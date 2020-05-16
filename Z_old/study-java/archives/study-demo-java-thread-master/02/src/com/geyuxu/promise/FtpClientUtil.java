package com.geyuxu.promise;



import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by temp on 2016/9/7.
 */
public class FtpClientUtil {
    private final  FTPClient ftp = new  FTPClient();

    private final Map<String,Boolean> dirCreateMap = new HashMap<>();

    private FtpClientUtil(){}

    public static Future<FtpClientUtil> newInstance(final String ftpServer,final String ftpUserName,final String ftpPassword){

        Callable<FtpClientUtil> callable = new Callable<FtpClientUtil>() {
            @Override
            public FtpClientUtil call() throws Exception {
                FtpClientUtil self = new FtpClientUtil();
                self.init(ftpServer,ftpUserName,ftpPassword);
                return self;
            }
        };

        final FutureTask<FtpClientUtil> task = new FutureTask<FtpClientUtil>(callable);

        new Thread(task).start();

        return task;
    }

    private void init (String ftpServer,String userName,String password) throws IOException {
        FTPClientConfig config = new FTPClientConfig();
        ftp.configure(config);

        int reply;
        ftp.connect(ftpServer);

        System.out.println(ftp.getReplyString());

        reply = ftp.getReplyCode();

        if(!FTPReply.isPositiveCompletion(reply)){
            ftp.disconnect();
            throw new RuntimeException("FTP Server refused connection.");
        }
        boolean isOK = ftp.login(userName,password);
        if(isOK){
            System.out.println(ftp.getReplyString());
        }else{
            throw new RuntimeException("Failed to login." + ftp.getReplyString());
        }

        reply = ftp.cwd("~/subspsync");
        if(!FTPReply.isPositiveCompletion(reply)){
            ftp.disconnect();
            throw new RuntimeException("Failed to change working directory.reply:" + reply);
        }else{
            System.out.println(ftp.getReplyString());
        }
        ftp.setFileType(FTP.ASCII_FILE_TYPE);
    }


    public void upload(File file) throws IOException {
        InputStream dataIn = new BufferedInputStream(new FileInputStream(file),1024 * 8);
        boolean isOK;
        String dirName = file.getParentFile().getName();
        String fileName = dirName + '/' + file.getName();
        ByteArrayInputStream checkFileInputStream = new ByteArrayInputStream("".getBytes());

        try{
            if(!dirCreateMap.containsKey(dirName)){
                ftp.makeDirectory(dirName);
                dirCreateMap.put(dirName,null);
            }
            isOK = ftp.storeFile(fileName,dataIn);
            if(isOK){
                ftp.storeFile(fileName + ".c",checkFileInputStream);
            }else{
                throw  new RuntimeException("Failed to upload " + file + ",reply : " + "," + ftp.getReplyString());
            }
        }finally{
            dataIn.close();
        }

    }

    public void disconnect(){
        if(ftp.isConnected()){
            try {
                ftp.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
