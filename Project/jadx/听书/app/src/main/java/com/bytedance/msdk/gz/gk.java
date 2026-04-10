package com.bytedance.msdk.gz;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gk {
    public static void z(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.core.uy.uy uyVar, com.bytedance.msdk.api.z.g gVar, boolean z) {
        if (dlVar == null || !dlVar.wx()) {
            return;
        }
        if (uyVar == null) {
            dlVar.z(0.0d);
        }
        String strGb = dlVar.gb();
        Map<String, String> mapH = uyVar.h();
        if (TextUtils.isEmpty(strGb)) {
            if (z) {
                com.bytedance.msdk.gc.m.z(uyVar, gVar, dlVar, 40061, com.bytedance.msdk.api.z.z(40061));
            }
            dlVar.i(com.bytedance.msdk.api.z.z(40061));
            dlVar.z(0.0d);
            return;
        }
        if (mapH == null) {
            if (z) {
                com.bytedance.msdk.gc.m.z(uyVar, gVar, dlVar, 40062, com.bytedance.msdk.api.z.z(40062));
            }
            dlVar.i(com.bytedance.msdk.api.z.z(40062));
            dlVar.z(0.0d);
            return;
        }
        String str = mapH.get(strGb);
        if (TextUtils.isEmpty(str)) {
            if (z) {
                com.bytedance.msdk.gc.m.z(uyVar, gVar, dlVar, 40062, com.bytedance.msdk.api.z.z(40062));
            }
            dlVar.z(0.0d);
        } else {
            try {
                dlVar.z(Double.valueOf(str).doubleValue());
            } catch (Exception unused) {
                dlVar.z(0.0d);
            }
        }
    }
}
