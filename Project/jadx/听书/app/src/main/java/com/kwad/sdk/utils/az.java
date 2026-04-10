package com.kwad.sdk.utils;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class az {
    public static String appendUrl(String str, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (map.get(next) != null) {
                sb.append(next).append("=").append(map.get(next)).append("&");
            }
        }
        return (str + (str.contains("?") ? "&" : "?")) + sb.toString().substring(0, r7.length() - 1);
    }
}
