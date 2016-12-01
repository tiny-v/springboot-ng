package com.my.sa.core.util;

import sun.misc.BASE64Encoder;


public class Image2Base64 {

    public static String transfer(byte[] data) throws Exception {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}
