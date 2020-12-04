package xyz.jiang.mall.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import xyz.jiang.mall.common.Constant;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Program: mall
 * @Classname MD5Utils
 * @Description: TODO
 * @Author: JiangKan
 * @Create: 2020-10-05
 **/
public class MD5Utils {
    public static String getMD5Str(String strValue) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return  Base64.encodeBase64String(md5.digest((strValue+ Constant.SALT).getBytes()));
    }
}
