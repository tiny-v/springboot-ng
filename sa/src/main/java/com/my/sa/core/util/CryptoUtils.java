package com.my.sa.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 公用函数，全局静态变量等的定义。
 * 
 * @author Medeson.Zh
 *
 */
public class CryptoUtils {
    
    /**
     * MD5 加密算法
     * 
     * @param plainText 需要加密的原文
     * @return 加密后的密文
     * @throws NoSuchAlgorithmException
     */
    public static final String encryptByMd5(String plainText) {
        if (plainText == null)
            return "";
        plainText = plainText.trim();
        StringBuffer buf = new StringBuffer("");

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            // 出错时返回原文
            return plainText;
        }
        md.update(plainText.getBytes());

        byte b[] = md.digest();
        int i;
        for (int offset = 0; offset < b.length; offset++) {
            i = b[offset];
            if (i < 0)
                i += 256;
            if (i < 16)
                buf.append("0");
            buf.append(Integer.toHexString(i));
        }

        return buf.toString();
    }
}
