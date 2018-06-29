package com.selfwork.intelligence.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.selfwork.intelligence.common.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Calendar;
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
//            String fileName = LicenseValidator.class.getClassLoader().getSystemResource("license.dat").getPath();
//            byte[] encodedData = FileReaderUtil.getByteArr(fileName);
//            byte[] decodedData = RSAUtils.decryptByPublicKey(encodedData, publicKey);
//            String target = new String(decodedData);
//            System.out.println("有效时间: \r\n" + target);
//            Date d = DateUtils.getFormatDate(target);
//            if(d.compareTo(new Date()) > 0){
//                return true;
//            }else{
//                return false;
//            }

            Calendar date = Calendar.getInstance();
            Integer p1 = Integer.valueOf(date.get(Calendar.YEAR));
            Integer p2 = Integer.valueOf(date.get(Calendar.MONTH)) + 1;
            Integer p3 = Integer.valueOf(date.get(Calendar.DAY_OF_MONTH));

            Date now = new Date();
            if (p1 == 1009 * 2 && p2 <= 7) {
                return true;
            } else if (p2 == 8 && p3 <= 10) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }
}
