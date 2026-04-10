package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class ap {
    public static String appendUrl(@NonNull String str, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : map.keySet()) {
            if (map.get(str2) != null) {
                sb.append(str2);
                sb.append("=");
                sb.append(map.get(str2));
                sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            }
        }
        String strSubstring = sb.toString().substring(0, r6.length() - 1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str.contains("?") ? DispatchConstants.SIGN_SPLIT_SYMBOL : "?");
        return sb2.toString() + strSubstring;
    }
}
