package com.bytedance.sdk.openadsdk.core.ugeno.express.z;

import com.bytedance.adsdk.ugeno.gc.m;
import com.bytedance.sdk.openadsdk.core.fv.z.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.nativeexpress.uy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static final HashSet<String> z = new HashSet<>(Arrays.asList("interactiveFinish", "nextVideoCancel"));

    public static void z(uy uyVar, g gVar, na naVar, String str, m.z zVar) {
        if (zVar == null) {
            return;
        }
        Map<String, String> mapDl = zVar.dl();
        str.hashCode();
        if (str.equals("nextVideoCancel")) {
            if (gVar != null) {
                gVar.z();
            }
        } else if (str.equals("interactiveFinish")) {
            int iZ = 0;
            if (mapDl != null) {
                try {
                    iZ = js.z(naVar, Integer.parseInt(mapDl.get("reduce_duration")));
                } catch (NumberFormatException unused) {
                }
            }
            if (uyVar != null) {
                uyVar.g(iZ);
            }
        }
    }
}
