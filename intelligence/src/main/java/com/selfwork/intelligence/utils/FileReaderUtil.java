package com.selfwork.intelligence.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReaderUtil {

    public static byte[] getByteArr(String fileName) throws IOException {
        File file = new File(fileName);
        long fileSize = file.length();
        if (fileSize > Integer.MAX_VALUE) {
            System.out.println("file too big...");
            return null;
        }
        FileInputStream fi = null;
        byte[] buffer = new byte[(int) fileSize];

        try{
            fi = new FileInputStream(file);
            int offset = 0;
            int numRead = 0;
            while (offset < buffer.length
                    && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
                offset += numRead;
            }
            // 确保所有数据均被读取
            if (offset != buffer.length) {
                throw new IOException("Could not completely read file "
                        + file.getName());
            }
        }catch (Exception e){
            System.out.println("找不到指定文件" + fileName);
            System.exit(-1);
        }finally {
            if(fi != null){
                fi.close();
            }
        }
        return buffer;
    }
}
