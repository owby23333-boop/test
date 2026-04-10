package com.bytedance.sdk.component.m.z;

import com.bytedance.sdk.component.m.fv;
import com.bytedance.sdk.component.m.wp;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static fv z() {
        return new fv() { // from class: com.bytedance.sdk.component.m.z.g.1
            private WeakHashMap<String, String> z = new WeakHashMap<>();

            @Override // com.bytedance.sdk.component.m.fv
            public String z(wp wpVar) {
                return z(wpVar.getUrl() + "#width=" + wpVar.getWidth() + "#height=" + wpVar.getHeight() + "#scaletype=" + wpVar.getScaleType() + "#bitmapConfig=" + wpVar.getBitmapConfig());
            }

            @Override // com.bytedance.sdk.component.m.fv
            public String g(wp wpVar) {
                return z(wpVar.getUrl());
            }

            private String z(String str) {
                String str2 = this.z.get(str);
                if (str2 != null) {
                    return str2;
                }
                String strZ = com.bytedance.sdk.component.m.dl.dl.dl.z(str);
                this.z.put(str, strZ);
                return strZ;
            }
        };
    }
}
