package com.bytedance.sdk.openadsdk.core.live;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static String z(Uri uri, String str) {
        return (uri == null || !uri.isHierarchical() || str == null) ? "" : uri.getQueryParameter(str);
    }

    public static Uri z(Uri uri, Map<String, String> map) {
        if (uri != null && map != null && map.size() > 0) {
            try {
                Uri.Builder builderBuildUpon = uri.buildUpon();
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        builderBuildUpon.appendQueryParameter(str, map.get(str));
                    }
                }
                return builderBuildUpon.build();
            } catch (Exception e) {
                wp.z(e);
            }
        }
        return uri;
    }
}
