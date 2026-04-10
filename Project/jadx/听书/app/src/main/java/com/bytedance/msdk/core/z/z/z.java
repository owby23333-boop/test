package com.bytedance.msdk.core.z.z;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static m dl;
    private static m g;
    private static m z;

    public static m z(String str) {
        if (TextUtils.equals(str, MediationConstant.ADN_GDT)) {
            if (z == null) {
                z = new g();
            }
            return z;
        }
        if (TextUtils.equals(str, MediationConstant.ADN_KS)) {
            if (g == null) {
                g = new dl();
            }
            return g;
        }
        if (!TextUtils.equals(str, MediationConstant.ADN_XIAOMI)) {
            return null;
        }
        if (dl == null) {
            dl = new a();
        }
        return dl;
    }

    public static void z(Map<String, Object> map) {
        if (map != null) {
            m mVar = z;
            if (mVar != null && !TextUtils.isEmpty(mVar.e())) {
                map.put("unsupported_gdt_version", z.e());
                z.z((String) null);
            }
            m mVar2 = g;
            if (mVar2 != null && !TextUtils.isEmpty(mVar2.e())) {
                map.put("unsupported_ks_version", g.e());
                g.z((String) null);
            }
            m mVar3 = dl;
            if (mVar3 == null || TextUtils.isEmpty(mVar3.e())) {
                return;
            }
            map.put("unsupported_xiaomi_version", dl.e());
            dl.z((String) null);
        }
    }

    public static boolean g(String str) {
        return TextUtils.equals(str, MediationConstant.ADN_GDT) || TextUtils.equals(str, MediationConstant.ADN_KS) || TextUtils.equals(str, MediationConstant.ADN_XIAOMI);
    }
}
