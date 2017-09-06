package com.ys.haier.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by lzc on 2017-08-24.
 */

public class Escaped {
    String strGBK;
    String strUTF8;
    public  String getEscapedString(String str) {
        try {
            strGBK = URLEncoder.encode(str, "GBK");
            strUTF8 = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strUTF8;
    }
}


