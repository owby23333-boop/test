package com.bytedance.sdk.openadsdk.core.un;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class p {
    public static String z(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        return map.get(TextUtils.isEmpty(map.get("content-type")) ? HttpHeaders.CONTENT_TYPE : "content-type");
    }
}
