package com.bytedance.sdk.openadsdk.core.component.splash.dl.z;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.me;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.nh;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.un.eo;

/* JADX INFO: loaded from: classes2.dex */
public class g extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1004a;
    private int e;
    private int fo;
    private com.bytedance.sdk.openadsdk.i.g gc;
    private com.bykv.vk.openvk.component.video.api.dl.dl gz;
    private boolean i;
    private com.bytedance.sdk.openadsdk.core.iq.z kb;
    private int m;
    private boolean uy;
    private boolean wp;

    public g(na naVar, boolean z) {
        if (naVar == null) {
            return;
        }
        this.g = naVar;
        this.i = z;
        this.wp = vm.z(naVar) == 2;
        g(naVar);
    }

    private void g(na naVar) {
        int iNh = naVar.nh();
        me meVarM = vm.m(naVar);
        nh nhVarE = vm.e(naVar);
        if (TextUtils.isEmpty(tf.z(naVar))) {
            this.f1004a = 1;
        } else if (dl(naVar)) {
            if (z(meVarM) || z(nhVarE)) {
                this.f1004a = 2;
            } else {
                if (g(meVarM) || g(nhVarE)) {
                    vm.z(naVar, 1);
                }
                this.f1004a = 1;
            }
        } else if (iNh == 1) {
            this.f1004a = 1;
        } else {
            this.f1004a = 2;
        }
        a(naVar);
    }

    public boolean a() {
        return this.f1004a == 2;
    }

    private boolean z(me meVar) {
        return meVar != null && z(meVar.gz()) == 2;
    }

    private boolean z(nh nhVar) {
        return nhVar != null && nhVar.e() == 2;
    }

    private boolean g(me meVar) {
        return meVar != null && z(meVar.gz()) == 0;
    }

    private boolean g(nh nhVar) {
        return nhVar != null && nhVar.e() == 0;
    }

    private int z(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private boolean dl(na naVar) {
        return vm.z(naVar) == 2;
    }

    private void a(na naVar) {
        gc(naVar);
        m(naVar);
    }

    private void gc(na naVar) {
        gk gkVar;
        if (naVar.jz() == null || (gkVar = naVar.jz().get(0)) == null) {
            return;
        }
        String strZ = gkVar.z();
        if (TextUtils.isEmpty(strZ)) {
            return;
        }
        this.m = gkVar.g();
        this.e = gkVar.dl();
        this.gc = new com.bytedance.sdk.openadsdk.i.g(strZ, gkVar.e());
    }

    private void m(na naVar) {
        this.gz = tf.v(naVar);
        this.fo = eo.fo(naVar);
        this.uy = naVar.jv();
    }

    public com.bytedance.sdk.openadsdk.i.g gc() {
        return this.gc;
    }

    public int m() {
        return this.m;
    }

    public int e() {
        return this.e;
    }

    public com.bykv.vk.openvk.component.video.api.dl.dl gz() {
        return this.gz;
    }

    public int fo() {
        return this.fo;
    }

    public boolean uy() {
        return this.uy;
    }

    public int kb() {
        return this.f1004a;
    }

    public com.bytedance.sdk.openadsdk.core.iq.z wp() {
        return this.kb;
    }

    public void z(com.bytedance.sdk.openadsdk.core.iq.z zVar) {
        this.kb = zVar;
    }

    public boolean i() {
        return this.wp;
    }

    public boolean v() {
        return this.i;
    }

    public void z(boolean z) {
        this.i = z;
    }
}
