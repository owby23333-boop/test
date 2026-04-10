package com.bytedance.adsdk.ugeno.gc;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.gc.m;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class wp {
    public static m.z z(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        m.z zVar = new m.z();
        String strZ = com.bytedance.adsdk.ugeno.a.g.z(str, jSONObject);
        Uri uri = Uri.parse(strZ);
        if (uri == null) {
            return null;
        }
        zVar.dl(strZ);
        if (!TextUtils.isEmpty(uri.getScheme())) {
            zVar.z(uri.getScheme());
        }
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            authority = uri.getPath();
        }
        zVar.g(authority);
        zVar.a(zVar.z() + "://" + zVar.g());
        HashMap map = new HashMap();
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (queryParameterNames != null && queryParameterNames.size() > 0) {
            for (String str2 : queryParameterNames) {
                map.put(str2, com.bytedance.adsdk.ugeno.a.g.z(uri.getQueryParameter(str2), jSONObject));
            }
        }
        zVar.z(map);
        return zVar;
    }
}
