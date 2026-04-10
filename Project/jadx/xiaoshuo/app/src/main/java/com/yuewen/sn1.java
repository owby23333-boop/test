package com.yuewen;

import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class sn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f17506a = Arrays.asList("@gmail.com", "@aol.com", "@outlook.com", "@yahoo.com.cn", "@yahoo.com", "@hotmail.com", "@163.com", "@126.com", "@qq.com", "@sina.com", "@sina.cn", "@sohu.com");

    public static String a(String str) {
        String strSubstring = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strReplaceAll = str.replaceAll("[^@]*(@.*$)", "$1");
        String strReplaceAll2 = str.replaceAll(strReplaceAll, "");
        if (strReplaceAll2.length() > 7) {
            strReplaceAll2 = strReplaceAll2.substring(0, 3) + "***" + strReplaceAll2.substring(strReplaceAll2.length() - 1);
        } else if (strReplaceAll2.length() >= 5) {
            strReplaceAll2 = strReplaceAll2.replaceAll("(?<=\\S{3})\\S(?=\\S)", ProxyConfig.MATCH_ALL_SCHEMES);
        } else if (strReplaceAll2.length() >= 4) {
            strReplaceAll2 = strReplaceAll2.replaceAll("(?<=\\S{2})\\S(?=\\S)", ProxyConfig.MATCH_ALL_SCHEMES);
        }
        if (!f17506a.contains(strReplaceAll)) {
            if (strReplaceAll.split(com.xiaomi.onetrack.util.z.f7779a).length >= 2) {
                String strSubstring2 = strReplaceAll.substring(0, (strReplaceAll.length() - r2[r2.length - 1].length()) - 1);
                strSubstring = strReplaceAll.substring(strSubstring2.length());
                strReplaceAll = strSubstring2;
            }
            strReplaceAll = strReplaceAll.replaceAll("(?<=\\S{2})\\S(?=\\S)", ProxyConfig.MATCH_ALL_SCHEMES) + strSubstring;
        }
        return strReplaceAll2 + strReplaceAll;
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.length() >= 6 ? str.replaceAll("(?<=\\d{2})\\d(?=\\d{3})", ProxyConfig.MATCH_ALL_SCHEMES) : str;
    }

    public static String c(String str) {
        String strSubstring;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("+")) {
            strSubstring = str.substring(0, 3);
            str = str.substring(3).trim();
        } else {
            strSubstring = null;
        }
        int length = str.length();
        if (length >= 11) {
            str = str.substring(0, 3) + "****" + str.substring(length - 4);
        } else if (length >= 9) {
            str = str.replaceAll("(?<=\\d{3})\\d(?=\\d{3})", ProxyConfig.MATCH_ALL_SCHEMES);
        } else if (length >= 7) {
            str = str.replaceAll("(?<=\\d{2})\\d(?=\\d{2})", ProxyConfig.MATCH_ALL_SCHEMES);
        }
        if (TextUtils.isEmpty(strSubstring)) {
            return str;
        }
        return strSubstring + " " + str;
    }
}
