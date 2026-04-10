package com.dangdang.zframework.utils;

import com.alipay.sdk.m.w.a;
import com.iflytek.aikit.media.param.MscKeys;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class URLUtil {
    public static Map<String, String> splitQuery(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            String[] strArrSplit = new URL(str).getQuery().split(a.p);
            if (strArrSplit != null && strArrSplit.length > 0) {
                for (String str2 : strArrSplit) {
                    if (!StringUtil.isEmpty(str2)) {
                        int iIndexOf = str2.indexOf(MscKeys.KEY_VAL_SEP);
                        linkedHashMap.put(URLDecoder.decode(str2.substring(0, iIndexOf), "UTF-8"), URLDecoder.decode(str2.substring(iIndexOf + 1), "UTF-8"));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return linkedHashMap;
    }
}
