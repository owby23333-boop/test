package com.bytedance.sdk.openadsdk.core.io;

import android.content.Context;
import android.location.Address;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.tb;
import com.bytedance.sdk.openadsdk.core.un.x;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.bytedance.sdk.component.fo.dl.g {
    private Context dl;
    String z = "sp_multi_ttadnet_config";
    com.bytedance.sdk.component.a.g.dl g = x.z("sp_multi_ttadnet_config");

    @Override // com.bytedance.sdk.component.fo.dl.g
    public String dl() {
        return "android";
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public String g() {
        return "openadsdk";
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public String[] m() {
        return new String[]{"tnc3-bjlgy.zijieapi.com", "tnc3-alisc1.zijieapi.com", "tnc3-aliec2.zijieapi.com"};
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public Address z(Context context) {
        return null;
    }

    public a(Context context) {
        this.dl = context;
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public Context getContext() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public int z() {
        return Integer.parseInt("1371");
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public int a() {
        return gk.dl;
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public String gc() {
        return tb.dl();
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public String z(Context context, String str, String str2) {
        return this.g.get(str, str2);
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public void z(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        this.g.put(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        this.g.put(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        this.g.put(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        this.g.put(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        this.g.put(entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
