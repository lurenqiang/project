package com.lurenqiang.car.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
@Slf4j
public class CarUtils {
    /**
     * 加密解密算法 执行一次加密
     */
    public String MD5Encyption(String str)
    {   log.info("MD5加密前的参数:【{}】",str);
        MessageDigest md5 ;
        try {
             md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
            e.printStackTrace();
            return "";
        }
        char[] charArray = str.toCharArray();
        byte[] byteArray =  new byte[charArray.length];
        for(int i=0;i<charArray.length;i++){
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuilder hexValue = new StringBuilder();
        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        log.info("MD5加密后的结果:【{}】",hexValue.toString());
        return hexValue.toString();
    }


}
