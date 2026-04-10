package com.bytedance.sdk.openadsdk.core.component.reward.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.CommonEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.iq;
import com.bytedance.sdk.openadsdk.core.un.l;
import com.bytedance.sdk.openadsdk.core.un.oq;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f929a;
    protected int dl;
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.g fo;
    protected com.bytedance.sdk.openadsdk.core.component.reward.g.gc fv;
    protected na g;
    protected int gc;
    protected com.bytedance.sdk.openadsdk.core.g.gc gz;
    protected com.bytedance.sdk.openadsdk.core.component.reward.gc.dl h;
    protected boolean i;
    com.bytedance.sdk.openadsdk.core.component.reward.g.z io;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.gc iq;
    protected com.bytedance.sdk.openadsdk.core.component.reward.g.m js;
    protected AbstractEndCardFrameLayout kb;
    protected boolean ls;
    protected int m;
    protected boolean p;
    protected boolean pf;
    protected com.bytedance.sdk.openadsdk.core.component.reward.g.a q;
    protected com.bytedance.sdk.openadsdk.core.component.reward.g.g tb;
    protected com.bytedance.sdk.openadsdk.core.component.reward.layout.gc uy;
    protected boolean v;
    protected String wp;
    protected final TTBaseVideoActivity z;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.a zw;
    protected int e = -1;
    protected int uf = -5;
    protected boolean sy = false;
    protected boolean hh = false;
    protected int l = Integer.MIN_VALUE;
    private final com.bytedance.sdk.openadsdk.core.nativeexpress.uy gk = new com.bytedance.sdk.openadsdk.core.nativeexpress.uy() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.z.1
        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public void z(int i, String str) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public void z(boolean z) {
            if (z.this.i != z) {
                z.this.i = z;
                z.this.fv.g();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public void e() {
            v.z().dl(z.this.g, "stats_reward_full_click_express_close");
            z.this.fv.z();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public void gz() {
            v.z().dl(z.this.g, "stats_reward_full_click_express_close");
            z.this.z.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public void z(int i) {
            if (i != 1) {
                if (i == 2) {
                    z.this.js.sy();
                    return;
                }
                if (i == 3) {
                    z.this.js.hh();
                    return;
                } else if (i == 4) {
                    z.this.js.e();
                    return;
                } else if (i != 5) {
                    return;
                }
            }
            if (z.this.js.g() || z.this.js.dl() || z.this.js.na()) {
                return;
            }
            z.this.z.g(0L, false);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public long z() {
            z zVar = z.this;
            zVar.g(zVar.m(true));
            return z.this.h.z();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public void setPauseFromExpressView(boolean z) {
            z.this.z.pf(1);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public int g() {
            if (z.this.uy.g()) {
                return 4;
            }
            if (z.this.uy.dl()) {
                return 5;
            }
            if (z.this.js.a()) {
                return 1;
            }
            if (z.this.js.g()) {
                return 2;
            }
            z.this.js.dl();
            return 3;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public int dl() {
            return z.this.uf();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public long getActualPlayDuration() {
            return z.this.js.lq().t();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public void uy() {
            z.this.fv.dl();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public void kb() {
            z.this.z.gz(3);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public void z(float f, float f2, float f3, float f4, int i) {
            z.this.z.z(f, f2, f3, f4, i);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public void a() {
            z.this.sy = true;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public void g(int i) {
            if (gb.gc(z.this.g)) {
                z.this.z.a(1);
            } else {
                z.this.z.z(i, false);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public void gc() {
            z.this.sy = false;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public void z(float f) {
            if (z.this.h != null) {
                z.this.h.dl((int) (1000.0f / f));
            }
            z.this.z.ec().z(f);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public void m() {
            z.this.hh = true;
            z.this.z.qd();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public void dl(int i) {
            z.this.z.dl(i);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
        public void fo() {
            z.this.z.yx();
        }
    };

    public void dl(boolean z) {
    }

    public void ec() {
    }

    public void g(Map<String, Object> map) {
    }

    public boolean gk() {
        return false;
    }

    public int h() {
        return 0;
    }

    public void iq() {
    }

    public void lq() {
    }

    public com.bytedance.sdk.openadsdk.core.video.g.g mc() {
        return null;
    }

    public boolean p() {
        return false;
    }

    public void q() {
    }

    public void v() {
    }

    public boolean x() {
        return true;
    }

    public void z(int i) {
    }

    public void z(int i, int i2, Intent intent) {
    }

    public void z(View view) {
    }

    public void z(Map<String, Object> map) {
    }

    public void z(JSONObject jSONObject) {
    }

    public z(TTBaseVideoActivity tTBaseVideoActivity, na naVar) {
        this.z = tTBaseVideoActivity;
        this.g = naVar;
        this.dl = naVar.zr();
        this.f929a = naVar.tk();
    }

    public void z(com.bytedance.sdk.openadsdk.core.component.reward.g.gc gcVar, com.bytedance.sdk.openadsdk.core.component.reward.g.m mVar, com.bytedance.sdk.openadsdk.core.component.reward.g.g gVar, com.bytedance.sdk.openadsdk.core.component.reward.g.a aVar, com.bytedance.sdk.openadsdk.core.component.reward.g.z zVar) {
        this.fv = gcVar;
        this.js = mVar;
        this.tb = gVar;
        this.q = aVar;
        this.io = zVar;
    }

    public void z(String str, boolean z, boolean z2, com.bytedance.sdk.openadsdk.core.component.reward.gc.dl dlVar) {
        this.wp = str;
        this.i = z;
        this.v = z2;
        this.h = dlVar;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.g.gc z() {
        return this.fv;
    }

    public final void z(com.bytedance.sdk.openadsdk.core.g.gc gcVar) {
        this.gz = gcVar;
        TTBaseVideoActivity tTBaseVideoActivity = this.z;
        na naVar = this.g;
        String str = this.wp;
        this.iq = new com.bytedance.sdk.openadsdk.core.nativeexpress.gc(tTBaseVideoActivity, naVar, str, eo.g(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.z.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.gc, com.bytedance.sdk.openadsdk.core.g.g, com.bytedance.sdk.openadsdk.core.g.a
            public void z(View view, com.bytedance.sdk.openadsdk.core.iq.uy uyVar) {
                if (na.gc(this.z)) {
                    return;
                }
                super.z(view, uyVar);
                z.this.z.z(2);
            }
        };
        TTBaseVideoActivity tTBaseVideoActivity2 = this.z;
        na naVar2 = this.g;
        String str2 = this.wp;
        this.zw = new com.bytedance.sdk.openadsdk.core.nativeexpress.a(tTBaseVideoActivity2, naVar2, str2, eo.g(str2)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.z.3
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a, com.bytedance.sdk.openadsdk.core.g.g, com.bytedance.sdk.openadsdk.core.g.a
            public void z(View view, com.bytedance.sdk.openadsdk.core.iq.uy uyVar) {
                if (na.gc(this.z)) {
                    return;
                }
                super.z(view, uyVar);
                com.bytedance.sdk.openadsdk.core.g.z.g gVar = (com.bytedance.sdk.openadsdk.core.g.z.g) this.gz.z(com.bytedance.sdk.openadsdk.core.g.z.g.class);
                if (gVar == null || !gVar.g(view)) {
                    return;
                }
                z.this.z.z(2);
            }
        };
        this.kb.setClickListener(this.gz);
    }

    private void me() {
        this.fv.z(false);
        this.fo.m(8);
        this.fo.gc(8);
        this.fo.dl(8);
        lw();
    }

    public void g() {
        me();
        rv();
        if (zx()) {
            gb.z(this.g, true);
        }
        if (jq()) {
            this.tb.z();
        }
        if (m()) {
            gc();
        } else {
            this.z.tb();
            dl();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected void dl() {
        a();
    }

    protected void a() {
        boolean zM = this.uy.m();
        if (!this.tb.mc() && !zM) {
            ls();
        }
        this.tb.z(this.uy.kb());
        if (zM) {
            this.uy.z().setBackgroundColor(-16777216);
        }
        this.fo.dl(!zM);
        this.uy.dl(zM);
        this.fv.z(yx() || !zM);
        this.z.m();
    }

    protected void gc() {
        this.z.e(0);
        this.fv.z(yx());
        float f = this.gc;
        float f2 = this.m;
        float[] fArrJs = {f, f2};
        if (f < 10.0f || f2 < 10.0f) {
            fArrJs = js();
        }
        this.uy.z(this.g, l.z(this.z.sy() ? 7 : 8, String.valueOf(eo.fo(this.g)), fArrJs[0], fArrJs[1]), this.wp, this.i, this.z.z());
        this.fo.dl(false);
        this.uy.dl(true);
        this.uy.z(this.gk);
        this.uy.z(new com.bytedance.sdk.openadsdk.core.nativeexpress.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.z.4
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
            public void g(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
            public void z(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
            public void z(View view, String str, int i) {
                if (z.this.tb.mc()) {
                    return;
                }
                z.this.tb.z();
                z.this.z.tb();
                z.this.z.e(8);
                z.this.fv.z(true);
                com.bytedance.sdk.component.utils.gz.g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.z.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.z.js();
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
            public void z(View view, float f3, float f4) {
                if (z.this.tb.mc()) {
                    return;
                }
                z.this.tb.z();
                z.this.z.tb();
                z.this.z.e(8);
                z zVar = z.this;
                zVar.e = zVar.uy.fo();
                if (z.this.e == 0) {
                    gb.g(z.this.g, true);
                }
                z.this.dl();
            }
        });
        ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) this.iq.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(this.z.j());
        ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) this.zw.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(this.z.j());
        this.z.z((com.bytedance.sdk.openadsdk.core.g.z.dl.dl) this.iq.z(com.bytedance.sdk.openadsdk.core.g.z.dl.dl.class));
        this.z.z((com.bytedance.sdk.openadsdk.core.g.z.dl.dl) this.zw.z(com.bytedance.sdk.openadsdk.core.g.z.dl.dl.class));
        this.uy.z(this.iq, this.zw);
        this.uy.gz();
    }

    public boolean m() {
        return vm.z(this.g) == 2;
    }

    public boolean e() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.gc gcVar;
        return m() && (gcVar = this.uy) != null && gcVar.m();
    }

    public void gz() {
        if ((this.v || !gb.zw(this.g)) && !(this instanceof kb)) {
            return;
        }
        xl();
    }

    public View fo() {
        int iB = this.g.b();
        if (iB == 1) {
            return com.bytedance.sdk.openadsdk.res.gc.dl(this.z);
        }
        if (iB == 3) {
            return com.bytedance.sdk.openadsdk.res.gc.a(this.z);
        }
        return com.bytedance.sdk.openadsdk.res.gc.z(this.z);
    }

    public View uy() {
        if (this.kb == null) {
            this.kb = new CommonEndCardFrameLayout(this.z, this.g);
        }
        return this.kb;
    }

    public View kb() {
        return com.bytedance.sdk.openadsdk.res.gc.gc(this.z);
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.layout.g z(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.dl dlVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.dl(this.z, this.g, z);
        this.fo = dlVar;
        return dlVar;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.layout.gc wp() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.gc gcVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.gc(this.z);
        this.uy = gcVar;
        return gcVar;
    }

    public AbstractEndCardFrameLayout i() {
        return this.kb;
    }

    public void z(int i, int i2) {
        this.gc = i;
        this.m = i2;
    }

    public void g(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.gc gcVar = this.uy;
        if (gcVar != null) {
            gcVar.gc();
        }
    }

    public void pf() {
        AbstractEndCardFrameLayout abstractEndCardFrameLayout = this.kb;
        if (abstractEndCardFrameLayout != null) {
            abstractEndCardFrameLayout.g();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.layout.gc gcVar = this.uy;
        if (gcVar != null) {
            gcVar.a();
        }
        if (sv() || this.tb.mc()) {
            return;
        }
        this.tb.iq();
    }

    public void ls() {
        this.fo.ls();
    }

    public FrameLayout fv() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.gc gcVar;
        if (js.a(this.g)) {
            return this.kb.getVideoArea();
        }
        if (m() && (gcVar = this.uy) != null && gcVar.m()) {
            return this.uy.z();
        }
        return this.fo.wp();
    }

    public void a(boolean z) {
        if (z) {
            if (this.dl == 1) {
                this.fo.a(0);
            }
            if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.g)) {
                this.fo.m(0);
                return;
            }
            return;
        }
        if (this.dl == 1) {
            this.fo.a(8);
        }
    }

    protected float[] js() {
        TTBaseVideoActivity tTBaseVideoActivity = this.z;
        int iA = oq.a(tTBaseVideoActivity, oq.kb((Context) tTBaseVideoActivity));
        float f = this.m;
        float f2 = this.gc;
        int i = this.dl;
        if ((i == 1) != (f > f2)) {
            float f3 = f + f2;
            f2 = f3 - f2;
            f = f3 - f2;
        }
        if (i == 1) {
            f -= iA;
        } else {
            f2 -= iA;
        }
        return new float[]{f2, f};
    }

    public void tb() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.gc gcVar = this.uy;
        if (gcVar != null) {
            gcVar.z(this.h);
        }
        if (this.v) {
            this.fo.g((int) (this.js.gk() / 1000));
        }
    }

    public void gc(boolean z) {
        this.i = z;
        this.js.dl(z);
    }

    public final int zw() {
        return this.e;
    }

    public g.z z(na naVar, final com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.dl.dl dlVar = new com.bytedance.sdk.openadsdk.core.component.reward.dl.dl(this.z, naVar);
        dlVar.z(oq());
        dlVar.g(un());
        dlVar.dl(this.z.x());
        dlVar.a(this.z.lq());
        dlVar.dl(this.sy);
        dlVar.a(gb.sy(naVar) && !this.z.e.get());
        this.z.na();
        return dlVar.g(new com.bytedance.sdk.openadsdk.core.component.reward.dl.uy() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.z.5
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void z() {
                com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar2 = uyVar;
                if (uyVar2 != null) {
                    uyVar2.z();
                }
                z.this.z.xl();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void g() {
                com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar2 = uyVar;
                if (uyVar2 != null) {
                    uyVar2.g();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void z(int i) {
                com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar2 = uyVar;
                if (uyVar2 != null) {
                    uyVar2.z(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void dl() {
                com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar2 = uyVar;
                if (uyVar2 != null) {
                    uyVar2.dl();
                }
            }
        });
    }

    public void io() {
        bv();
    }

    protected int uf() {
        return this.h.gc() + this.h.g();
    }

    public int sy() {
        return this.h.m();
    }

    protected void hh() {
        if (this.uf < 0) {
            this.uf = this.tb.wj();
        }
        int i = this.uf;
        if (i > 0) {
            this.uf = i - 1;
            this.fv.z(false, this.uf + "s", null, true, true);
        } else if (i == 0) {
            this.z.a(0);
            this.fv.z(false, "奖励已领取", null, true, true);
        }
    }

    public void l() {
        this.pf = true;
    }

    public int un() {
        if (zx() && gb.p(this.g)) {
            return uf();
        }
        return wj() + t();
    }

    public int m(boolean z) {
        if (qd() && this.tb.oq()) {
            return this.uf;
        }
        if (zx() && gb.p(this.g)) {
            return Math.max(na() - uf(), 0);
        }
        return e(z);
    }

    public int ti() {
        if (qd() && this.tb.oq()) {
            return this.uf;
        }
        if (zx() && gb.p(this.g)) {
            return (int) Math.max((na() * (this.g.kg() / 100.0f)) - uf(), 0.0f);
        }
        return eo();
    }

    protected int e(boolean z) {
        if (z) {
            return gz(false);
        }
        return nh();
    }

    protected int eo() {
        return gz(true);
    }

    private int gz(boolean z) {
        long jGk = this.js.gk();
        if (z) {
            long jMax = Math.max(Math.min(gb.z(), (long) ((this.js.l() * 1000.0d) * ((double) (this.g.kg() / 100.0f)))) - (jGk + (((long) t()) * 1000)), 0L);
            return (int) Math.max(((long) ((int) (jMax / 1000))) + (((int) (jMax % 1000)) > 500 ? 1L : 0L), 0L);
        }
        long jMin = Math.min(gb.z(), (long) (this.js.l() * 1000.0d));
        long jT = ((long) t()) * 1000;
        long jL = (long) ((this.js.l() % 1.0d) * 1000.0d);
        if (jL > 0) {
            jGk -= 1000 - jL;
        }
        return Math.round((jMin - (jGk + jT)) / 1000.0f);
    }

    private int nh() {
        long jMax = Math.max(((long) (this.js.l() * 1000.0d)) - this.js.gk(), 0L);
        return Math.max((((int) (jMax / 1000)) + (((int) (jMax % 1000)) > 500 ? 1 : 0)) - t(), 0);
    }

    public void g(int i) {
        this.l = i;
    }

    public int oq() {
        int i = this.l;
        return i == Integer.MIN_VALUE ? m(true) : i;
    }

    protected int wj() {
        return (int) (this.js.gk() / 1000);
    }

    protected int na() {
        if (iq.dl(this.g)) {
            return iq.gc(this.g);
        }
        return gb.pf(this.g);
    }

    protected void xl() {
        if (this.p || Build.VERSION.SDK_INT == 26) {
            return;
        }
        TTBaseVideoActivity tTBaseVideoActivity = this.z;
        tTBaseVideoActivity.setTheme(tb.gz(tTBaseVideoActivity, "tt_full_screen_interaction"));
        oq.e((Activity) this.z);
        this.p = true;
    }

    public boolean j() {
        return !this.v && gb.zw(this.g) && this.dl == 1;
    }

    public com.bytedance.sdk.openadsdk.core.nativeexpress.uy gp() {
        return this.gk;
    }

    public void dl(int i) {
        this.h.z(i);
    }

    public int t() {
        return this.h.g();
    }

    public int vm() {
        return this.h.dl();
    }

    public boolean y() {
        return this.hh;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean bv() {
        return gb.p(this.g) || this.tb.oq();
    }

    public void gb() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.gc gcVar = this.uy;
        if (gcVar != null) {
            gcVar.z(this.h);
        }
        if (qd() && this.tb.oq()) {
            hh();
        } else {
            b();
        }
    }
}
