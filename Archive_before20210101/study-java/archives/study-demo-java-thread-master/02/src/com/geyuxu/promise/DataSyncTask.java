package com.geyuxu.promise;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by temp on 2016/9/7.
 */
public class DataSyncTask implements Runnable{
    private final Map<String,String> taskParameters;

    public DataSyncTask(Map<String, String> taskParameters) {
        this.taskParameters = taskParameters;
    }

    @Override
    public void run() {
        String ftpServer = taskParameters.get("server");
        String ftpUserName = taskParameters.get("userName");
        String ftpPassword = taskParameters.get("password");

        Future<FtpClientUtil> ftpClientUtilPromise = FtpClientUtil.newInstance(ftpServer,ftpUserName,ftpPassword);

        generateFilesFromDb();

        FtpClientUtil ftpClientUtil = null;

        try {
            ftpClientUtil = ftpClientUtilPromise.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void generateFilesFromDb(){

    }

    private void uploadFiles(FtpClientUtil ftpClientUtil) throws IOException {
        Set<File> files = retrieveGeneratedFiles();
        for (File file :
                files) {
            try {
                ftpClientUtil.upload(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private  Set<File> retrieveGeneratedFiles(){
        Set<File> files = new HashSet<>();
        return files;
    }
}
