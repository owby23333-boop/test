package com.bytedance.msdk.a;

import android.content.Context;
import android.location.Address;
import com.bytedance.msdk.gz.io;
import com.bytedance.msdk.gz.l;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bytedance.sdk.component.fo.dl.g {
    private Context g;
    String z = "sp_multi_ttmadnet_config";
    private final l dl = l.z("sp_multi_ttmadnet_config", getContext());

    @Override // com.bytedance.sdk.component.fo.dl.g
    public String dl() {
        return "android";
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public String g() {
        return "msdk";
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public String[] m() {
        return new String[]{"tnc3-bjlgy.zijieapi.com", "tnc3-alisc1.zijieapi.com", "tnc3-aliec2.zijieapi.com"};
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public int z() {
        return 4741;
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public Address z(Context context) {
        return null;
    }

    public z(Context context) {
        this.g = context;
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public Context getContext() {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public int a() {
        return com.bytedance.msdk.g.g.z();
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public String gc() {
        return io.z();
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public String z(Context context, String str, String str2) {
        return this.dl.g(str, str2);
    }

    @Override // com.bytedance.sdk.component.fo.dl.g
    public void z(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        this.dl.z(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        this.dl.z(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        this.dl.z(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        this.dl.z(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        this.dl.z(entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
