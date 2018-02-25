package org.haozf.weixin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurtityUtils {

    public static String sha1(String str) {
        try {
            StringBuffer sb = new StringBuffer();
            MessageDigest md = MessageDigest.getInstance("sha1");
            md.update(str.getBytes());
            byte[] msg = md.digest();
            for (byte m : msg) {
                sb.append(String.format("%02x", m));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static String SHA1(String sign) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(sign.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(SecurtityUtils.sha1("hello"));
    }

}
