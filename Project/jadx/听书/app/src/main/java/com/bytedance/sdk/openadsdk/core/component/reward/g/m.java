package com.bytedance.sdk.openadsdk.core.component.reward.g;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.video.g.z;
import com.bytedance.sdk.openadsdk.hh.fo;
import com.bytedance.sdk.openadsdk.hh.uy;
import com.bytedance.sdk.openadsdk.m.dl.p;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long f958a;
    com.bykv.vk.openvk.component.video.api.a.dl e;
    protected int gc;
    long gz;
    private String i;
    private na kb;
    private com.bykv.vk.openvk.component.video.api.dl.a ls;
    boolean m;
    private com.bytedance.sdk.openadsdk.core.g.z pf;
    private TTBaseVideoActivity uy;
    private long v;
    private FrameLayout wp;
    private final int fo = 210;
    boolean z = false;
    protected boolean g = false;
    protected boolean dl = false;
    private boolean p = false;

    public m(TTBaseVideoActivity tTBaseVideoActivity) {
        this.uy = tTBaseVideoActivity;
    }

    public void z(na naVar) {
        this.kb = naVar;
    }

    public void z(FrameLayout frameLayout, String str, boolean z) {
        if (this.p) {
            return;
        }
        this.p = true;
        this.wp = frameLayout;
        this.i = str;
        this.m = z;
        if (z) {
            this.e = new com.bytedance.sdk.openadsdk.core.component.reward.m.g(this.uy, this.wp, this.kb, this.pf);
        } else {
            this.e = new com.bytedance.sdk.openadsdk.core.component.reward.m.z(this.uy, this.wp, this.kb, this.pf);
        }
        this.gc = (int) l();
    }

    public boolean z() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        return (dlVar == null || dlVar.p() == null || !this.e.p().fo()) ? false : true;
    }

    public boolean g() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        return (dlVar == null || dlVar.p() == null || !this.e.p().i()) ? false : true;
    }

    public boolean dl() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        return (dlVar == null || dlVar.p() == null || !this.e.p().v()) ? false : true;
    }

    public boolean a() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        return dlVar != null && dlVar.iq();
    }

    public boolean gc() {
        return this.g;
    }

    public void z(boolean z) {
        this.g = z;
    }

    public long m() {
        return this.gz;
    }

    public void z(long j) {
        this.gz = j;
    }

    public void g(boolean z) {
        int i;
        if (this.e == null) {
            return;
        }
        if (z) {
            i = eo() ? 2 : 4;
        } else {
            i = eo() ? 0 : 1;
        }
        p.z zVar = new p.z();
        zVar.g(p());
        long jTb = tb();
        zVar.dl(jTb);
        long jLs = ls();
        if (lq() != null) {
            zVar.z(lq().z(jLs, jTb));
        }
        zVar.dl(1 ^ (eo() ? 1 : 0));
        zVar.a(i);
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (!(dlVar instanceof com.bytedance.sdk.openadsdk.core.video.g.z) || ((com.bytedance.sdk.openadsdk.core.video.g.z) dlVar).q.z(128)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.video.g.z) this.e).q.dl(128);
        com.bytedance.sdk.openadsdk.m.g.a.dl(this.e.fv(), zVar);
    }

    private void gp() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar == null || dlVar.p() == null) {
            return;
        }
        this.gz = this.e.kb();
        if (this.e.p().uy() || !this.e.p().fo()) {
            this.e.m();
            this.e.fo();
            this.g = true;
        }
    }

    public void e() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar == null) {
            return;
        }
        dlVar.fo();
        this.e = null;
    }

    public void gz() {
        if (this.e != null && g()) {
            this.e.g(true);
        }
    }

    public void fo() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar != null) {
            dlVar.uy();
        }
    }

    public void z(long j, boolean z) {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar == null || this.dl) {
            return;
        }
        if (j != 0) {
            dlVar.z(j);
            this.e.g(z);
        } else {
            dlVar.gz();
        }
    }

    public void z(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar == null || this.dl) {
            return;
        }
        dlVar.z(map);
    }

    public void uy() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar != null) {
            dlVar.g();
        }
    }

    public boolean kb() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar != null) {
            return dlVar.a();
        }
        return false;
    }

    public boolean wp() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar != null) {
            return dlVar.gc();
        }
        return false;
    }

    public void g(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar != null) {
            dlVar.g(map);
        }
    }

    public void z(z.InterfaceC0210z interfaceC0210z) {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar instanceof com.bytedance.sdk.openadsdk.core.video.g.z) {
            ((com.bytedance.sdk.openadsdk.core.video.g.z) dlVar).z(interfaceC0210z);
        }
    }

    public void dl(boolean z) {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar != null) {
            dlVar.g(z);
        }
    }

    public boolean i() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar != null) {
            return dlVar.js();
        }
        return false;
    }

    public long v() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar != null) {
            return dlVar.v();
        }
        return 0L;
    }

    public int pf() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar != null) {
            return dlVar.pf();
        }
        return 0;
    }

    public long ls() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar != null) {
            return dlVar.kb();
        }
        return this.gz;
    }

    public long p() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar != null) {
            return dlVar.wp();
        }
        return 0L;
    }

    public int fv() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar != null) {
            return dlVar.i();
        }
        return 0;
    }

    public void js() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar == null || dlVar.p() == null) {
            return;
        }
        this.e.p().a();
    }

    public long tb() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar != null) {
            return dlVar.v() + this.e.wp();
        }
        return 0L;
    }

    public long q() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar != null) {
            return dlVar.v();
        }
        return 0L;
    }

    public boolean iq() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar != null) {
            if (dlVar.p() != null) {
                com.bykv.vk.openvk.component.video.api.z zVarP = this.e.p();
                if (zVarP.v() || zVarP.pf()) {
                    ((com.bytedance.sdk.openadsdk.core.video.g.z) this.e).bv();
                    return true;
                }
            } else if (gc()) {
                z(false);
                ((com.bytedance.sdk.openadsdk.core.video.g.z) this.e).bv();
                return true;
            }
        }
        return false;
    }

    public boolean zw() {
        return this.e != null;
    }

    public boolean io() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        return dlVar != null && dlVar.p() == null;
    }

    public boolean z(long j, boolean z, int i) {
        if (this.e == null || tf.v(this.kb) == null) {
            return false;
        }
        com.bykv.vk.openvk.component.video.api.dl.a aVarZ = this.ls;
        if (aVarZ == null) {
            File file = new File(fo.z(this.kb.su()).z(), tf.e(this.kb));
            if (file.exists() && file.length() > 0) {
                this.z = true;
            }
            aVarZ = tf.z(1, this.kb);
            aVarZ.g(this.kb.mj());
            FrameLayout frameLayout = this.wp;
            aVarZ.g(frameLayout == null ? 100 : frameLayout.getWidth());
            FrameLayout frameLayout2 = this.wp;
            aVarZ.dl(frameLayout2 != null ? frameLayout2.getHeight() : 100);
            aVarZ.dl(this.kb.vk());
            aVarZ.z(j);
            aVarZ.g(z);
            if (uy.z(this.kb)) {
                aVarZ.z(true);
            }
        }
        return this.e.z(aVarZ);
    }

    public void uf() {
        e();
    }

    public void sy() {
        try {
            this.uy.i(1);
        } catch (Throwable th) {
            wp.a("TTBaseVideoActivity", "onPause throw Exception :" + th.getMessage());
        }
    }

    public void hh() {
        try {
            this.uy.v(1);
        } catch (Throwable th) {
            wp.a("TTBaseVideoActivity", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public void z(boolean z, TTBaseVideoActivity tTBaseVideoActivity) {
        boolean zA;
        long jGc;
        boolean zM;
        if (z || this.uy.sv()) {
            return;
        }
        if (dl()) {
            com.bytedance.sdk.openadsdk.core.video.g.g gVarMc = this.uy.gb().mc();
            if (gVarMc != null) {
                zA = gVarMc.a();
                jGc = gVarMc.gc();
                zM = gVarMc.m();
            } else {
                zA = false;
                jGc = 0;
                zM = false;
            }
            if (zA) {
                gp();
                z(tTBaseVideoActivity);
            } else {
                z(jGc, zM);
            }
            wp.z("TTBaseVideoActivity", "resumeOrRestartVideo: continue play");
            return;
        }
        gp();
        z(tTBaseVideoActivity);
        wp.z("TTBaseVideoActivity", "resumeOrRestartVideo: recreate video player & exec play");
    }

    protected void z(TTBaseVideoActivity tTBaseVideoActivity) {
        if (!iq() || tTBaseVideoActivity == null) {
            return;
        }
        tTBaseVideoActivity.g(m(), true);
    }

    public double l() {
        double dM = tf.m(this.kb);
        return (tf.v(this.kb) == null || this.kb.qz() <= 0 || dM <= ((double) this.kb.qz())) ? dM : this.kb.qz();
    }

    public int h() {
        return this.gc;
    }

    public long gk() {
        long jX = x();
        com.bytedance.sdk.openadsdk.core.video.g.z zVarLq = lq();
        return (zVarLq == null || !zVarLq.mc()) ? jX : zVarLq.z(this.f958a, q());
    }

    public long x() {
        if (kb()) {
            double dM = tf.ls(this.kb).m() * 1000.0d * ((double) lq().y());
            long j = this.f958a;
            if (dM - j > 210.0d) {
                long j2 = (long) (j + dM);
                this.v = j2;
                return j2;
            }
        }
        return Math.max(this.f958a, this.v);
    }

    public void g(long j) {
        this.f958a = j;
        com.bytedance.sdk.openadsdk.core.video.g.z zVarLq = lq();
        if (!wp() && kb()) {
            this.gc = (int) Math.max(0L, Math.round(l() - ((this.f958a + (tf.ls(this.kb).m() * 1000.0d)) / 1000.0d)));
        } else if (zVarLq != null && !(this.uy.gb() instanceof com.bytedance.sdk.openadsdk.core.component.reward.a.fo)) {
            this.gc = Math.max(0, (int) (l() - (zVarLq.t() / 1000)));
        } else {
            this.gc = Math.max(0, (int) (l() - (this.f958a / 1000)));
        }
    }

    public com.bytedance.sdk.openadsdk.core.video.g.z lq() {
        return (com.bytedance.sdk.openadsdk.core.video.g.z) oq();
    }

    public boolean mc() {
        com.bytedance.sdk.openadsdk.core.video.g.z zVarLq = lq();
        if (zVarLq == null) {
            return false;
        }
        return zVarLq.qd();
    }

    public boolean un() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar == null) {
            return false;
        }
        return dlVar.dl();
    }

    public com.bykv.vk.openvk.component.video.api.a.g ti() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar != null) {
            return dlVar.fv();
        }
        return null;
    }

    public boolean eo() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar == null || dlVar.p() == null) {
            return false;
        }
        return this.e.p().m();
    }

    public void z(int i) {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar != null) {
            dlVar.z(i);
        }
    }

    public com.bykv.vk.openvk.component.video.api.a.dl oq() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void wj() {
        boolean z;
        p.z zVar = new p.z();
        long jTb = tb();
        long jLs = ls();
        if (lq() != null) {
            zVar.z(lq().z(jLs, jTb));
        }
        zVar.dl(jTb);
        zVar.g(p());
        zVar.gc(3);
        zVar.m(fv());
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
        if (dlVar instanceof com.bytedance.sdk.openadsdk.core.video.g.z) {
            ((com.bytedance.sdk.openadsdk.core.video.g.z) dlVar).q.dl(32);
            z = ((com.bytedance.sdk.openadsdk.core.video.g.z) this.e).q.z(2);
        } else {
            z = 0;
        }
        com.bytedance.sdk.openadsdk.m.g.a.z(ti(), zVar, this.uy.gz(), !z);
    }

    public boolean na() {
        return this.dl;
    }

    public void xl() {
        this.dl = true;
    }

    public void j() {
        try {
            com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.e;
            if (dlVar instanceof com.bytedance.sdk.openadsdk.core.video.g.z) {
                ((com.bytedance.sdk.openadsdk.core.video.g.z) dlVar).b();
            }
        } catch (Throwable unused) {
        }
    }

    public void z(na naVar, com.bykv.vk.openvk.component.video.api.a.dl dlVar, com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        this.kb = naVar;
        this.e = dlVar;
        this.ls = aVar;
    }

    public void z(com.bytedance.sdk.openadsdk.core.g.z zVar) {
        this.pf = zVar;
    }

    public void z(float f) {
        if (this.e.p() != null) {
            this.e.p().z(f);
        }
    }
}
