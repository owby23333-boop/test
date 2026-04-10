package com.bytedance.sdk.openadsdk.core.component.reward.g;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.core.component.reward.a.fo;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.hh;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.iq;
import com.bytedance.sdk.openadsdk.core.un.oq;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f956a;
    private String dl;
    private AbstractEndCardFrameLayout e;
    private com.bytedance.sdk.openadsdk.core.component.reward.g.z fo;
    private na g;
    private int gc;
    private gc gz;
    private final com.bytedance.sdk.openadsdk.core.component.reward.view.z i;
    private boolean iq;
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.g kb;
    private int m;
    private boolean pf;
    private com.bytedance.sdk.openadsdk.core.g.g uy;
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.z v;
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl wp;
    private final TTBaseVideoActivity z;
    private int ls = -1;
    private boolean p = false;
    private final AtomicBoolean fv = new AtomicBoolean(false);
    private final AtomicBoolean js = new AtomicBoolean(false);
    private int q = 0;
    private boolean tb = false;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.reward.g.g$g, reason: collision with other inner class name */
    public interface InterfaceC0155g {
        gc dl();

        void g();

        void z();
    }

    public interface z {
        void z();
    }

    public g(TTBaseVideoActivity tTBaseVideoActivity) {
        this.z = tTBaseVideoActivity;
        this.i = new com.bytedance.sdk.openadsdk.core.component.reward.view.z(tTBaseVideoActivity);
    }

    public void z(gc gcVar, com.bytedance.sdk.openadsdk.core.component.reward.g.z zVar, boolean z2, String str, int i, int i2) {
        this.f956a = z2;
        this.gz = gcVar;
        this.fo = zVar;
        this.dl = str;
        this.gc = i;
        this.m = i2;
    }

    public void z(na naVar, com.bytedance.sdk.openadsdk.core.g.g gVar, com.bytedance.sdk.openadsdk.core.multipro.g.z zVar, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        if (this.tb) {
            return;
        }
        this.tb = true;
        this.g = naVar;
        this.uy = gVar;
        this.i.z(naVar);
        this.e = abstractEndCardFrameLayout;
        z(abstractEndCardFrameLayout);
        z(zVar);
        this.iq = com.bytedance.sdk.openadsdk.core.pf.a.z(String.valueOf(eo.fo(this.g)));
    }

    void z(AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        if (this.g.sy() == 1) {
            return;
        }
        if (iq.g(this.g)) {
            this.wp = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl(this.z, this.g, this.dl, this.gc, this.m, this.f956a, this.e);
        }
        if (!TextUtils.isEmpty(tf.z(this.g))) {
            this.kb = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.g(this.z, this.g, this.dl, this.gc, this.m, this.f956a, this.e);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.wp;
        if (zVar == null) {
            zVar = this.kb;
        }
        this.v = zVar;
    }

    public void z(long j, long j2, int i) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            zVar.z(j, j2, i);
        }
    }

    public void z(int i, int i2) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            zVar.z(i, i2);
        }
    }

    public void z(boolean z2) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            zVar.g(z2);
        }
    }

    public void z(com.bytedance.sdk.openadsdk.core.multipro.g.z zVar) {
        Map<String, Object> mapJ = this.z.j();
        this.i.z(this.uy);
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl dlVar = this.wp;
        if (dlVar != null) {
            dlVar.z(zVar);
            this.wp.z(this.f956a, mapJ, this.gz.a());
            this.wp.z(this.fo.e(), this.uy);
            this.wp.z(new z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.g.1
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.g.g.z
                public void z() {
                    g.this.gc(false);
                }
            });
            this.wp.z(new InterfaceC0155g() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.g.2
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.g.g.InterfaceC0155g
                public void z() {
                    g.this.z.g(true, true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.g.g.InterfaceC0155g
                public void g() {
                    g.this.z.wp();
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.g.g.InterfaceC0155g
                public gc dl() {
                    return g.this.gz;
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.g gVar = this.kb;
        if (gVar != null) {
            gVar.z(this.f956a, mapJ, this.gz.a());
            this.kb.z(this.fo.e(), this.uy);
        }
    }

    public void z() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl dlVar = this.wp;
        if (dlVar != null) {
            dlVar.hh();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.g gVar = this.kb;
        if (gVar != null) {
            gVar.l();
        }
    }

    public void g() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            zVar.wp();
        }
    }

    public void dl() {
        if (oq()) {
            return;
        }
        int i = this.ls;
        if (i >= 0) {
            this.z.g(i);
            z(0L);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            zVar.uf();
        }
    }

    public void a() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            zVar.i();
        }
    }

    public void g(boolean z2) {
        if (this.ls >= 0) {
            this.z.pf();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            zVar.a(z2);
        }
    }

    public void gc() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            zVar.fv();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar2 = this.v;
        if (zVar2 != null) {
            zVar2.v();
        }
    }

    public void m() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.g gVar = this.kb;
        if (gVar != null) {
            gVar.pf();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl dlVar = this.wp;
        if (dlVar != null) {
            dlVar.pf();
        }
    }

    public void e() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            zVar.ls();
        }
    }

    public void gz() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            zVar.sy();
        }
    }

    public int fo() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            return zVar.uy();
        }
        return 0;
    }

    public String uy() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        return zVar != null ? zVar.kb() : "";
    }

    public void z(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            zVar.z(map);
        }
    }

    public void kb() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            zVar.p();
        }
    }

    public void wp() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            zVar.js();
        }
    }

    public void z(boolean z2, int i, String str) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            zVar.z(z2, i, str);
        }
    }

    public void i() {
        if (!this.z.gb().bv()) {
            zw();
        }
        this.gz.dl(false);
        this.gz.m(false);
        this.gz.g(this.g.sz());
        this.gz.e(false);
        this.gz.gc(!(this.v instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.g));
        xl();
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            zVar.gc();
            this.v.z(1);
        }
    }

    public void dl(boolean z2) {
        this.pf = z2;
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl dlVar = this.wp;
        if (dlVar != null) {
            dlVar.m(z2);
        }
    }

    public boolean v() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            return zVar.e();
        }
        return false;
    }

    public void pf() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            zVar.gz();
        }
    }

    public boolean ls() {
        boolean zFv;
        if (tf.uy(this.g)) {
            zFv = p();
        } else {
            zFv = fv();
        }
        if (js()) {
            return zFv || iq.g(this.g);
        }
        return false;
    }

    public boolean p() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            return zVar.g();
        }
        return false;
    }

    public boolean fv() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            return zVar.dl();
        }
        return false;
    }

    public boolean js() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            return zVar.a();
        }
        return false;
    }

    public boolean tb() {
        if (this.p) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl) {
            return this.wp.gk();
        }
        return zVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.g;
    }

    public void q() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.g gVar = this.kb;
        if (gVar != null) {
            this.v = gVar;
        }
    }

    public void iq() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.g gVar = this.kb;
        if (gVar != null) {
            gVar.fo();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl dlVar = this.wp;
        if (dlVar != null) {
            dlVar.fo();
        }
    }

    public void zw() {
        if (iq.dl(this.g) || oq()) {
            return;
        }
        this.ls = Math.max(z(this.g), 0);
        z(0L);
    }

    private int z(na naVar) {
        return naVar.yd();
    }

    public void io() {
        dl(true);
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl dlVar = this.wp;
        if (dlVar != null && dlVar.dl()) {
            this.wp.z(this.z.gb() instanceof fo ? 2 : 0);
        } else {
            gc(false);
        }
        if (this.kb != null) {
            this.v = this.wp;
        }
    }

    public boolean uf() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl dlVar = this.wp;
        return dlVar != null && dlVar.dl();
    }

    public mc sy() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl dlVar = this.wp;
        if (dlVar != null) {
            return dlVar.x();
        }
        return null;
    }

    public void hh() {
        dl(false);
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl dlVar = this.wp;
        if (dlVar != null) {
            dlVar.m();
        }
        if (this.p) {
            un();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.g gVar = this.kb;
        if (gVar != null) {
            this.v = gVar;
        }
    }

    public boolean l() {
        return this.v instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl;
    }

    public boolean h() {
        return this.pf;
    }

    private void z(long j) {
        int i = this.ls / 1000;
        if (!gb.p(this.g)) {
            if (i > 0) {
                this.gz.z(false, i + "s", null, false, false);
            } else {
                this.gz.z(false, null, null, true, true);
            }
        }
        if (i > 0) {
            this.ls = (int) (((long) this.ls) - j);
            this.z.z(j);
        }
    }

    public boolean gk() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.g gVar = this.kb;
        if (gVar == null) {
            return false;
        }
        return gVar.q();
    }

    public void x() {
        z(1000L);
    }

    public boolean lq() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl dlVar = this.wp;
        if (dlVar != null) {
            return dlVar.lq();
        }
        return false;
    }

    public void a(boolean z2) {
        this.fv.set(z2);
    }

    public boolean mc() {
        return this.fv.get();
    }

    public void gc(boolean z2) {
        if (mc() || h()) {
            this.p = true;
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
            if (zVar != null) {
                zVar.tb();
                this.v.m();
            }
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl dlVar = this.wp;
            if (dlVar != null) {
                dlVar.zw();
            }
            gc gcVar = this.gz;
            if (gcVar != null) {
                gcVar.e();
            }
            v.z().m(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.g.3
                @Override // com.bytedance.sdk.openadsdk.kb.z.z
                public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                    com.bytedance.sdk.openadsdk.core.q.z.g gVarM = com.bytedance.sdk.openadsdk.core.q.z.g.g().z(g.this.f956a ? 7 : 8).dl(String.valueOf(eo.fo(g.this.g))).m(eo.i(g.this.g));
                    gVarM.g(g.this.fo()).e(g.this.uy());
                    gVarM.gz(g.this.g.vk()).a(g.this.g.mj());
                    return gVarM;
                }
            });
            this.i.z();
            if (js.z(this.g)) {
                this.z.wp(8);
            }
            this.gz.z(true);
            this.gz.e(false);
            this.z.eo().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.g.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.gz.z(true);
                    if (g.this.gz.gc()) {
                        return;
                    }
                    g.this.gz.z(false, null, null, true, true);
                    if (g.this.lq() && g.this.f956a) {
                        g.this.na();
                    }
                }
            }, 500L);
            if (z2) {
                if (!gb.p(this.g)) {
                    this.gz.z(false, null, null, true, true);
                }
                this.gz.gc(false);
                this.gz.g(this.g.sz());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na() {
        if (this.z.isDestroyed()) {
            return;
        }
        Toast toast = new Toast(this.z);
        toast.setDuration(1);
        toast.setGravity(17, 0, 0);
        LinearLayout linearLayout = new LinearLayout(this.z);
        linearLayout.setBackgroundColor(Color.parseColor("#CC161823"));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(oq.dl(this.z, 20.0f), oq.dl(this.z, 12.0f), oq.dl(this.z, 20.0f), oq.dl(this.z, 12.0f));
        TextView textView = new TextView(this.z);
        textView.setTextColor(-1);
        textView.setText("请求异常无法发放奖励，请关闭重试");
        textView.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.show();
        this.z.eo().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.g.5
            @Override // java.lang.Runnable
            public void run() {
                g.this.na();
            }
        }, 6000L);
    }

    public void un() {
        this.i.dl();
    }

    public void z(na naVar, com.bytedance.sdk.openadsdk.core.g.g gVar) {
        this.g = naVar;
        this.uy = gVar;
        this.i.z(naVar);
        this.i.z(this.uy);
        if (iq.g(naVar)) {
            if (this.wp == null) {
                this.wp = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl(this.z, naVar, this.dl, this.gc, this.m, this.f956a, this.e);
            }
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl dlVar = this.wp;
            this.v = dlVar;
            dlVar.z(new z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.g.6
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.g.g.z
                public void z() {
                    g.this.gc(false);
                }
            });
            this.wp.z(new InterfaceC0155g() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.g.7
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.g.g.InterfaceC0155g
                public void z() {
                    g.this.z.g(true, true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.g.g.InterfaceC0155g
                public void g() {
                    g.this.z.wp();
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.g.g.InterfaceC0155g
                public gc dl() {
                    return g.this.gz;
                }
            });
        } else {
            this.v = this.kb;
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
            if (zVar != null) {
                zVar.z(this.g);
                this.v.z(this.f956a, this.z.j(), this.gz.a());
                this.v.z(this.fo.e(), this.uy);
                z();
            }
        } catch (Throwable unused) {
        }
    }

    public void z(final String str) {
        this.z.eo().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.g.8
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                g.this.i.z(str);
            }
        });
    }

    public String ti() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        return zVar != null ? zVar.io() : "endcard";
    }

    public void m(boolean z2) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl dlVar = this.wp;
        if (dlVar != null) {
            dlVar.gc(z2);
        }
    }

    public void g(int i, int i2) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl dlVar = this.wp;
        if (dlVar != null) {
            dlVar.g(i, i2);
        }
    }

    public void z(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.z zVar = this.v;
        if (zVar != null) {
            zVar.z(jSONObject);
        }
    }

    public void eo() {
        this.q = gb.g(this.g, this.z.gb().ti());
        this.js.set(gb.q(this.g));
        com.bytedance.sdk.openadsdk.core.gz.a.dl = true;
    }

    public boolean oq() {
        return mc() && this.js.get();
    }

    public int wj() {
        return this.q;
    }

    public void z(com.bytedance.sdk.component.adexpress.g.v vVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.g gVar = this.kb;
        if (gVar == null) {
            return;
        }
        gVar.z(vVar);
    }

    private void xl() {
        try {
            if (!hh.z(this.g) || this.iq) {
                return;
            }
            float[] fArrZ = com.bytedance.sdk.openadsdk.core.component.reward.gc.g.z(this.z.getApplicationContext(), this.g.tk(), this.g.zr());
            float f = fArrZ[0];
            float f2 = fArrZ[1];
            if (this.g.tk() == 100.0f) {
                this.gc = (int) f;
                this.m = (int) f2;
                return;
            }
            int[] iArrZ = com.bytedance.sdk.openadsdk.core.component.reward.gc.g.z(this.z.getApplicationContext(), this.g.tk(), this.g.la(), this.g.zr());
            int i = iArrZ[0];
            int i2 = iArrZ[1];
            int i3 = iArrZ[2];
            int i4 = iArrZ[3];
            float f3 = i;
            float f4 = i3;
            this.gc = (int) ((f - f3) - f4);
            float f5 = i2;
            float f6 = i4;
            this.m = (int) ((f2 - f5) - f6);
            this.z.getWindow().getDecorView().setPadding(oq.dl(this.z, f3), oq.dl(this.z, f5), oq.dl(this.z, f4), oq.dl(this.z, f6));
        } catch (Throwable unused) {
        }
    }
}
