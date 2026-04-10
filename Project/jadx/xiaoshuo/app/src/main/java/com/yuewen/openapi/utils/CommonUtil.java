package com.yuewen.openapi.utils;

import android.content.Context;
import com.alibaba.android.arouter.utils.Consts;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes8.dex */
public class CommonUtil {
    public static String getIPAddress(Context context) {
        return "";
    }

    public static String getString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return sb.toString();
            }
            sb.append(line);
        }
    }

    public static String intIP2StringIP(int i) {
        return (i & 255) + Consts.DOT + ((i >> 8) & 255) + Consts.DOT + ((i >> 16) & 255) + Consts.DOT + ((i >> 24) & 255);
    }
}
