package com.bytedance.sdk.openadsdk.core.a;

import android.text.TextUtils;
import com.iflytek.aikit.media.param.MscKeys;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class fy {
    public static String bf(String str) {
        return str.contains("?") ? str.substring(0, str.indexOf("?")) : str;
    }

    private static URL d(String str) {
        if (str != null && str.length() != 0 && str.contains("://")) {
            try {
                return new URL("http" + str.substring(str.indexOf("://")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Map<String, String> e(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        URL urlD = d(str);
        if (urlD == null) {
            return linkedHashMap;
        }
        try {
            String query = urlD.getQuery();
            if (query == null) {
                return linkedHashMap;
            }
            if (query.contains("url=")) {
                int iIndexOf = query.indexOf("url=");
                linkedHashMap.put("url", URLDecoder.decode(query.substring(iIndexOf + 4), "UTF-8"));
                query = query.substring(0, iIndexOf);
            }
            if (query.length() > 0) {
                for (String str2 : query.split(com.alipay.sdk.m.w.a.p)) {
                    int iIndexOf2 = str2.indexOf(MscKeys.KEY_VAL_SEP);
                    if (iIndexOf2 > 0 && iIndexOf2 < str2.length() - 1) {
                        String strSubstring = str2.substring(0, iIndexOf2);
                        int i = iIndexOf2 + 1;
                        String strSubstring2 = str2.substring(i);
                        if ("live_short_touch_params".equals(strSubstring) || "extra_pangle_scheme_params".equals(strSubstring)) {
                            linkedHashMap.put(URLDecoder.decode(str2.substring(0, iIndexOf2), "UTF-8"), URLDecoder.decode(str2.substring(i), "UTF-8"));
                        } else {
                            linkedHashMap.put(strSubstring, strSubstring2);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linkedHashMap;
    }

    public static String e(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || map == null || map.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bf(str));
        sb.append("?");
        try {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                String key = next.getKey();
                String value = next.getValue();
                if (it.hasNext()) {
                    if (!"live_short_touch_params".equals(key) && !"extra_pangle_scheme_params".equals(key)) {
                        sb.append(key + MscKeys.KEY_VAL_SEP + value + com.alipay.sdk.m.w.a.p);
                    } else {
                        sb.append(URLEncoder.encode(next.getKey(), "UTF-8") + MscKeys.KEY_VAL_SEP + URLEncoder.encode(next.getValue(), "UTF-8") + com.alipay.sdk.m.w.a.p);
                    }
                } else if (!"live_short_touch_params".equals(key) && !"extra_pangle_scheme_params".equals(key)) {
                    sb.append(key + MscKeys.KEY_VAL_SEP + value);
                } else {
                    sb.append(URLEncoder.encode(next.getKey(), "UTF-8") + MscKeys.KEY_VAL_SEP + URLEncoder.encode(next.getValue(), "UTF-8"));
                }
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }
}
