package com.selfwork.intelligence.config;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by zzc on 2018/5/3.
 */
@Component
public class RuleFileLoader {

    private static ArrayList<File> fileList = new ArrayList<File>();

    static {
        // 读取规则文件
        String path = ClassLoader.getSystemResource("rule").getPath();
        readFile(path);

        // 解析规则文件
    }

    public static void readFile(String filepath) {
        File file= new File(filepath);
        if(!file.isDirectory()){
            fileList.add(file);
        }else if(file.isDirectory()){
            File[] files =file.listFiles();
            for(File fileIndex:files){
                //如果这个文件是目录，则进行递归搜索
                if(fileIndex.isDirectory()){
                    readFile(fileIndex.getPath());
                }else {
                    //如果文件是普通文件，则将文件句柄放入集合
                    fileList.add(fileIndex);
                }
            }
        }
    }
}
