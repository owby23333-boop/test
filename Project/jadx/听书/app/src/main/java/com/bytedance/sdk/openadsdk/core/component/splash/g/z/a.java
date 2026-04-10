package com.bytedance.sdk.openadsdk.core.component.splash.g.z;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.gc;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.fo;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.bytedance.sdk.openadsdk.core.component.splash.dl.g.z {
    private e z = new e();

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.g.z
    public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.g gVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl<gz, e> dlVar) {
        g(gVar, dlVar);
    }

    private void g(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.g gVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl<gz, e> dlVar) {
        com.bykv.vk.openvk.component.video.api.dl.a aVarZ;
        if (gVar == null || dlVar == null) {
            return;
        }
        this.z.g(gVar.v());
        this.z.z(gVar.g());
        int iFo = gVar.fo();
        com.bykv.vk.openvk.component.video.api.dl.dl dlVarGz = gVar.gz();
        this.z.z(true);
        if (dlVarGz == null) {
            this.z.g(2);
            this.z.z("no video info");
            dlVar.z(this.z);
            return;
        }
        String strWp = dlVarGz.wp();
        if (TextUtils.isEmpty(strWp)) {
            this.z.g(2);
            this.z.z("no video url");
            dlVar.z(this.z);
            return;
        }
        String strPf = dlVarGz.pf();
        if (TextUtils.isEmpty(strPf)) {
            strPf = gc.g(strWp);
        }
        if (TextUtils.isEmpty(strPf)) {
            this.z.g(2);
            this.z.z("no video cahce filename");
            dlVar.z(this.z);
            return;
        }
        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "加载视频素材");
        na naVarG = gVar.g();
        if (naVarG == null) {
            return;
        }
        boolean zUy = gVar.uy();
        dlVarGz.gc(1);
        if (dlVarGz.ls() == 0) {
            dlVarGz.a(307200);
        }
        if (zUy) {
            aVarZ = tf.z(2, naVarG);
        } else {
            aVarZ = tf.z(3, naVarG);
        }
        aVarZ.z("material_meta", naVarG);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (fo.z(naVarG.su()).z(aVarZ)) {
            gz gzVar = new gz(gVar.g(), gVar.v());
            gzVar.z(true);
            gzVar.dl(true);
            gzVar.z(gVar.z());
            gzVar.gc(gVar.dl());
            dlVar.g(gzVar);
            aVarZ.fo(1);
            com.bytedance.sdk.openadsdk.core.video.a.g.z(aVarZ, naVarG, SystemClock.elapsedRealtime() - jElapsedRealtime);
            return;
        }
        if (zw.g().gz(String.valueOf(iFo)) && !v.a(zw.getContext())) {
            this.z.g(2);
            this.z.z("network error");
            dlVar.z(this.z);
        } else {
            if (gVar.g() != null && gVar.g().nh() == 3) {
                gz gzVar2 = new gz(gVar.g(), gVar.v());
                gzVar2.z(true);
                gzVar2.dl(false);
                gzVar2.z(gVar.z());
                gzVar2.gc(gVar.dl());
                gzVar2.z(tf.z(gVar.g()));
                dlVar.g(gzVar2);
                return;
            }
            com.bykv.vk.openvk.component.video.z.z.z();
            z(aVarZ, gVar, gVar.g(), dlVar);
        }
    }

    private void z(com.bykv.vk.openvk.component.video.api.dl.a aVar, final com.bytedance.sdk.openadsdk.core.component.splash.dl.z.g gVar, na naVar, final com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl<gz, e> dlVar) {
        if (naVar == null || dlVar == null || gVar == null || aVar == null || tf.v(naVar) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.video.a.g.z(aVar, new com.bykv.vk.openvk.component.video.api.gc.g() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.g.z.a.1
            @Override // com.bykv.vk.openvk.component.video.api.gc.z.InterfaceC0028z
            public void z(com.bykv.vk.openvk.component.video.api.dl.a aVar2, int i) {
                if (dlVar != null) {
                    gz gzVar = new gz(gVar.g(), gVar.v());
                    gzVar.z(true);
                    gzVar.dl(false);
                    gzVar.z((com.bytedance.sdk.component.fo.g) null);
                    gzVar.z(gVar.z());
                    gzVar.gc(gVar.dl());
                    dlVar.g(gzVar);
                }
            }

            @Override // com.bykv.vk.openvk.component.video.api.gc.z.InterfaceC0028z
            public void z(com.bykv.vk.openvk.component.video.api.dl.a aVar2, int i, String str) {
                if (dlVar != null) {
                    a.this.z.g(2);
                    a.this.z.z("preload video fail");
                    dlVar.z(a.this.z);
                }
            }
        });
    }
}
