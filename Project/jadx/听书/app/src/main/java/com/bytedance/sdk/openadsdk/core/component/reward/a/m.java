package com.bytedance.sdk.openadsdk.core.component.reward.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class m extends z {
    public static int g(na naVar) {
        return 4;
    }

    public m(TTBaseVideoActivity tTBaseVideoActivity, na naVar) {
        super(tTBaseVideoActivity, naVar);
    }

    public static boolean z(na naVar) {
        return (naVar == null || naVar.tk() == 100.0f) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean jq() {
        return sv() && vm.z(this.g) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public View fo() {
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.g)) {
            return com.bytedance.sdk.openadsdk.res.gc.zw(this.z);
        }
        int i = (int) (this.f929a * 1000.0f);
        if (this.dl == 1) {
            if (i == 666) {
                return com.bytedance.sdk.openadsdk.res.gc.io(this.z);
            }
            if (i == 1000) {
                return com.bytedance.sdk.openadsdk.res.gc.sy(this.z);
            }
            if (i == 1500) {
                return com.bytedance.sdk.openadsdk.res.gc.uf(this.z);
            }
            if (i == 1777) {
                return com.bytedance.sdk.openadsdk.res.gc.hh(this.z);
            }
            return com.bytedance.sdk.openadsdk.res.gc.l(this.z);
        }
        if (i == 562) {
            return com.bytedance.sdk.openadsdk.res.gc.x(this.z);
        }
        if (i == 666) {
            return com.bytedance.sdk.openadsdk.res.gc.h(this.z);
        }
        if (i == 1000) {
            return com.bytedance.sdk.openadsdk.res.gc.sy(this.z);
        }
        if (i == 1500) {
            return com.bytedance.sdk.openadsdk.res.gc.gk(this.z);
        }
        return com.bytedance.sdk.openadsdk.res.gc.lq(this.z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected void rv() {
        if (this.iq != null) {
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.iq.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z((Object) this.z);
        }
        if (this.zw != null) {
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.zw.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z((Object) this.z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.g z(boolean z) {
        this.fo = new com.bytedance.sdk.openadsdk.core.component.reward.layout.e(this.z, this.g, z);
        return this.fo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean sv() {
        return me();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean f() {
        return me() || nh();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public boolean j() {
        return this.dl == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public void lw() {
        this.fo.gc(8);
        this.fo.m(8);
        if (m()) {
            this.fv.z(false);
            return;
        }
        this.fv.g(this.g.sz());
        this.fv.gc(me() || nh());
        if (me()) {
            return;
        }
        this.fv.z(false, null, null, true, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void gz() {
        super.gz();
        xl();
        try {
            final View decorView = this.z.getWindow().getDecorView();
            if (decorView != null) {
                decorView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.m.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int iKb = (int) (oq.kb((Context) m.this.z) / 2.0f);
                        int paddingLeft = decorView.getPaddingLeft();
                        int paddingRight = decorView.getPaddingRight();
                        int paddingTop = decorView.getPaddingTop();
                        int paddingBottom = decorView.getPaddingBottom();
                        if (m.this.dl == 1 && !oq.g()) {
                            paddingTop += iKb;
                            paddingBottom += iKb;
                        }
                        if (m.this.dl == 2 && !oq.g()) {
                            paddingLeft += iKb;
                            paddingRight += iKb;
                        }
                        decorView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    private boolean me() {
        return na.g(this.g);
    }

    private boolean nh() {
        return com.bytedance.sdk.openadsdk.hh.uy.z(this.g);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void dl(boolean z) {
        super.dl(z);
        if (zw.g().kb(eo.fo(this.g)) || this.v) {
            if (com.bytedance.sdk.openadsdk.core.kb.dl.dl.m.dl && com.bytedance.sdk.openadsdk.core.kb.dl.dl.m.g && dl(this.g)) {
                com.bytedance.sdk.openadsdk.core.kb.dl.dl.m.g = false;
                com.bytedance.sdk.openadsdk.core.kb.dl.dl.m.dl = false;
                this.z.finish();
            } else if (z && !com.bytedance.sdk.openadsdk.core.kb.dl.dl.m.dl) {
                this.z.finish();
            } else {
                if (!this.tb.gk() || com.bytedance.sdk.openadsdk.core.kb.dl.dl.m.dl) {
                    return;
                }
                this.z.finish();
            }
        }
    }

    private boolean dl(na naVar) {
        return (naVar.lt() == 4) && !TextUtils.isEmpty(naVar.po());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void ls() {
        super.ls();
        this.fv.g(this.g.sz());
        if (me() || nh()) {
            this.fv.gc(true);
        }
        if (!me()) {
            this.fv.z(false, null, null, true, true);
        }
        if (me()) {
            this.fo.m(0);
            this.fo.gc(0);
            this.fo.dl(0);
        } else {
            this.fo.m(8);
            this.fo.gc(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void a(boolean z) {
        if (this.dl == 1) {
            this.fo.a(z ? 0 : 8);
        } else {
            this.fo.a(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public int h() {
        return g(this.g);
    }
}
