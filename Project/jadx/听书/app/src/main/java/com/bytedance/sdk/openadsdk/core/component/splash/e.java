package com.bytedance.sdk.openadsdk.core.component.splash;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.iq.yx;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static void z(long j, boolean z, boolean z2, na naVar, long j2, String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        String str2 = z ? z2 ? "load_video_success" : "load_video_error" : z2 ? "download_video_image_success" : "download_video_image_fail";
        if (z) {
            Map<String, Object> mapZ = eo.z(z2, naVar, jElapsedRealtime, j2, str);
            mapZ.put("splash_show_type", 1);
            com.bytedance.sdk.openadsdk.core.i.a.gc(naVar, "splash_ad", str2, mapZ);
        } else {
            Map<String, Object> mapG = eo.g(z2, naVar, jElapsedRealtime, j2, str);
            mapG.put("splash_show_type", 2);
            com.bytedance.sdk.openadsdk.core.i.a.a(naVar, "splash_ad", str2, mapG);
        }
    }

    public static void z(com.bytedance.sdk.openadsdk.core.iq.z zVar) {
        com.bykv.vk.openvk.component.video.api.dl.a aVarZ;
        if (g(zVar)) {
            na naVar = zVar.g().get(0);
            int iFo = eo.fo(naVar);
            com.bykv.vk.openvk.component.video.api.dl.dl dlVarV = tf.v(naVar);
            if (dlVarV != null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                String strWp = dlVarV.wp();
                if (TextUtils.isEmpty(strWp)) {
                    z(jElapsedRealtime, true, false, naVar, -1L, "preLoadVideo videoUrl is null");
                    return;
                }
                if (TextUtils.isEmpty(dlVarV.pf())) {
                    com.bytedance.sdk.component.utils.gc.g(strWp);
                }
                if (naVar.jv()) {
                    aVarZ = tf.z(2, naVar);
                } else {
                    aVarZ = tf.z(3, naVar);
                }
                aVarZ.z("material_meta", naVar);
                if (!zw.g().gz(String.valueOf(iFo)) || v.a(zw.getContext())) {
                    dlVarV.gc(0);
                    com.bykv.vk.openvk.component.video.z.z.z();
                    com.bytedance.sdk.openadsdk.core.video.a.g.z(aVarZ, new com.bykv.vk.openvk.component.video.api.gc.g() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.e.1
                        @Override // com.bykv.vk.openvk.component.video.api.gc.z.InterfaceC0028z
                        public void z(com.bykv.vk.openvk.component.video.api.dl.a aVar, int i) {
                        }

                        @Override // com.bykv.vk.openvk.component.video.api.gc.z.InterfaceC0028z
                        public void z(com.bykv.vk.openvk.component.video.api.dl.a aVar, int i, String str) {
                        }
                    });
                }
            }
        }
    }

    public static boolean g(com.bytedance.sdk.openadsdk.core.iq.z zVar) {
        return (zVar == null || zVar.g() == null || zVar.g().isEmpty() || zVar.g().get(0) == null) ? false : true;
    }

    public static int z(yx yxVar) {
        if (yxVar == null) {
            return 0;
        }
        int iDl = dl(yxVar.g());
        return iDl <= 0 ? z(yxVar.z()) : iDl;
    }

    public static int z(na naVar) {
        if (naVar != null) {
            return eo.fo(naVar);
        }
        return 0;
    }

    public static int dl(com.bytedance.sdk.openadsdk.core.iq.z zVar) {
        if (zVar != null) {
            return zVar.z();
        }
        return 0;
    }

    public static boolean g(na naVar) {
        if (naVar == null || naVar.nh() == 1 || tf.v(naVar) == null || TextUtils.isEmpty(tf.z(naVar))) {
            return true;
        }
        naVar.fo(true);
        return false;
    }
}
