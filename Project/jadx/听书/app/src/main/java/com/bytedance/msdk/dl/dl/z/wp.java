package com.bytedance.msdk.dl.dl.z;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.media3.common.C;
import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.msdk.dl.dl.z.z;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class wp implements z {
    private final long z = 500;

    @Override // com.bytedance.msdk.dl.dl.z.z
    public void z(z.InterfaceC0102z interfaceC0102z) {
        com.bytedance.msdk.dl.m.z.g gVarZ = interfaceC0102z.z();
        if (gVarZ.wp() == null && gVarZ.js().iq() == 3 && !com.bytedance.msdk.core.g.g().l() && gVarZ.gk() != null) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "执行开启开屏兜底...............");
            z(interfaceC0102z, gVarZ, gVarZ.js(), gVarZ.gk());
        } else {
            interfaceC0102z.z(gVarZ);
        }
    }

    protected void z(final z.InterfaceC0102z interfaceC0102z, final com.bytedance.msdk.dl.m.z.g gVar, com.bytedance.msdk.api.z.g gVar2, com.bytedance.msdk.api.a.kb kbVar) {
        if (kbVar != null && gVar2 != null) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(gVar2.zw()) + "settings config.......AdUnitId = " + gVar2.zw() + "  开屏广告走了开发者自定义兜底方案   adnName:" + com.bytedance.msdk.g.z.z(kbVar.z()));
        }
        com.bytedance.msdk.gc.m.g(gVar2, -4);
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "开屏广告走了开发者自定义开屏兜底，数据为: getAdNetworkFlatFromId = " + kbVar.z() + " getAppId = " + kbVar.dl() + " getAppKey = " + kbVar.a() + " getAdNetworkSlotId = " + kbVar.g());
        if (kbVar == null || TextUtils.isEmpty(kbVar.g()) || (TextUtils.isEmpty(kbVar.dl()) && TextUtils.isEmpty(kbVar.a()))) {
            z(gVar, 840027);
            gVar.z(new com.bytedance.msdk.api.z(840027, com.bytedance.msdk.api.z.z(840027)));
            return;
        }
        int iZ = kbVar.z();
        final String strZ = com.bytedance.msdk.g.z.z(iZ);
        final String strG = kbVar.g();
        if (TextUtils.isEmpty(strZ)) {
            z(gVar, 840027);
            gVar.z(new com.bytedance.msdk.api.z(840027, com.bytedance.msdk.api.z.z(840027)));
            return;
        }
        if (iZ == 3) {
            new com.bytedance.msdk.m.z.z(kbVar).z(kbVar);
            Looper looperG = com.bytedance.msdk.z.gc.m.g();
            if (looperG != null) {
                new Handler(looperG).postDelayed(new Runnable() { // from class: com.bytedance.msdk.dl.dl.z.wp.1
                    @Override // java.lang.Runnable
                    public void run() {
                        wp.this.z(interfaceC0102z, gVar, strZ, strG);
                    }
                }, 500L);
                return;
            }
            return;
        }
        if (iZ == 7 || iZ == 6 || iZ == 4 || iZ == 8) {
            new com.bytedance.msdk.m.z.z(kbVar).z(kbVar);
            z(interfaceC0102z, gVar, strZ, strG);
        } else if (iZ == 1 || iZ == 9) {
            new com.bytedance.msdk.m.z.z(kbVar).z(kbVar, new com.bytedance.msdk.z.z.dl() { // from class: com.bytedance.msdk.dl.dl.z.wp.2
                @Override // com.bytedance.msdk.z.z.dl
                public void z() {
                    wp.this.z(interfaceC0102z, gVar, strZ, strG);
                }

                @Override // com.bytedance.msdk.z.z.dl
                public void z(com.bytedance.msdk.api.z zVar) {
                    wp.this.z(gVar, 840027);
                    gVar.z(new com.bytedance.msdk.api.z(840027, com.bytedance.msdk.api.z.z(840027)));
                }
            });
        } else {
            z(gVar, 840027);
            gVar.z(new com.bytedance.msdk.api.z(840027, com.bytedance.msdk.api.z.z(840027)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.msdk.dl.m.z.g gVar, int i) {
        com.bytedance.msdk.gc.m.z(gVar.js(), (String) null, !gVar.zw(), gVar.un().z, i, (Map<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(z.InterfaceC0102z interfaceC0102z, com.bytedance.msdk.dl.m.z.g gVar, String str, String str2) {
        gVar.z(z(gVar.js().zw(), str, str2));
        interfaceC0102z.z(gVar);
    }

    @Override // com.bytedance.msdk.dl.dl.z.z
    public void g(z.InterfaceC0102z interfaceC0102z) {
        interfaceC0102z.z((String) null);
    }

    private com.bytedance.msdk.core.uy.g z(String str, String str2, String str3) {
        com.bytedance.msdk.core.uy.uy uyVarZ = com.bytedance.msdk.core.e.dl.z(str3, str2, -4, -4);
        if (uyVarZ == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(uyVarZ);
        com.bytedance.msdk.core.uy.g gVar = new com.bytedance.msdk.core.uy.g();
        gVar.a(str);
        gVar.pf(3);
        gVar.a(400L);
        gVar.gc(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        gVar.m(5000L);
        gVar.e(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        gVar.z(arrayList);
        return gVar;
    }
}
