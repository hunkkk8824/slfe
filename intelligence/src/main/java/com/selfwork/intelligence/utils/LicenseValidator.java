package com.selfwork.intelligence.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.selfwork.intelligence.common.DateUtils;

import java.io.File;
import java.util.Date;

/**
 * 生成license
 */
public class LicenseValidator {

    String serial = "568b8fa5cdfd8a2623bda1d8ab7b7b34";

    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC+9sfQM0zwww4kg+7xU6lQ2YiwX4UCasWthQ1P\n" +
            "tKuDsl6yA+QOXSBLT5Q2dAhAqUqE1lFiTH1It/HEUrCsWAGSam+IAs3WiMXtUpVjd4TRr4mW0e7/\n" +
            "XLV/qqhTdamNsNBgJeenr4lP9meVYerDFVTml/slLymsHw9h+VmrfAUA9wIDAQAB";

    public static boolean validate() {
        try {
//            String path = ClassLoader.getSystemResource("").getPath();
//            String fileName = path + "license.dat";
//            byte[] encodedData = FileReaderUtil.getByteArr("D:\\project\\myproject\\rsa\\out\\production\\rsa\\license.dat");
//            byte[] decodedData = RSAUtils.decryptByPublicKey(encodedData, publicKey);
//            String target = new String(decodedData);
//            System.out.println("有效时间: \r\n" + target);
//            Date d = DateUtils.getFormatDate(target);
//            if(d.compareTo(new Date()) > 0){
//                return true;
//            }else{
//                return false;
//            }

            return true;
        }catch (Exception e){
            return false;
        }
    }
}
