package com.my.sb.core.util;

import sun.misc.BASE64Encoder;

/**
 * Created by DK on 2015/11/13.
 */
public class Image2Base64 {

    public static String transfer(byte[] data) throws Exception {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}
