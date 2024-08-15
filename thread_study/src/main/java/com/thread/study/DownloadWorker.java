package com.thread.study;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadWorker implements Runnable{
    private String url;

    DownloadWorker(String url)
    {
        this.url = url;
    }

    @Override
    public void run() {
       String fileName = url.substring(url.lastIndexOf("/")+1); //url의 마지막/위치값을 찾아 반환하여 ~까지 문자열 추출

       try
       (
        InputStream inputStream = new URL(url).openStream();
        FileOutputStream outputStream = new FileOutputStream(fileName)) 
       {
        byte[] buffer = new byte[2048];
        int length;
        while((length = inputStream.read(buffer))!= -1)
        {
            outputStream.write(buffer,0,length);
        }

        inputStream.close();
        outputStream.close();

        System.out.println(fileName + " 다운로드 완료");
       } catch (Exception e) {
            e.printStackTrace();
       }
    }

    public static void main(String[] args) {
        String[] urls = {
            "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.go2pyBWXRZ6IXN3whxDFtg",
            "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.YQloTWfJRz24Xhq2aVSGgw",
            "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.DwdVMtMaTmOFS_mQebo56w",
            "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.e2pbYnmHT_mRPWZZ3Z511Q",
            "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.p0sB3Ke2Tt64uXFPa1sU5A"};

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(String url : urls)
        {
            Runnable worker = new DownloadWorker(url);
            executor.execute(worker);
        }

        executor.shutdown();
        while(!executor.isTerminated()){}
    }
}
