package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.gc.z;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.iq.uy;
import com.bytedance.sdk.openadsdk.core.iq.y;
import com.bytedance.sdk.openadsdk.core.kb.gz;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.io;
import com.bytedance.sdk.openadsdk.core.p.z;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.l;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.un;
import com.bytedance.sdk.openadsdk.core.video.g.z;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f946a;
    protected final String dl;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.gc e;
    private com.bytedance.sdk.openadsdk.core.g.z fo;
    protected final na g;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.a gz;
    private long i;
    private ViewGroup kb;
    private boolean ls;
    private int m;
    private FullRewardExpressView p;
    private final boolean pf;
    private com.bytedance.sdk.openadsdk.core.kb.g.dl uy;
    private boolean wp;
    protected final TTBaseVideoActivity z;
    private final AtomicBoolean v = new AtomicBoolean(false);
    boolean gc = false;

    public g(final TTBaseVideoActivity tTBaseVideoActivity, na naVar, String str, boolean z, boolean z2) {
        this.uy = null;
        this.z = tTBaseVideoActivity;
        this.g = naVar;
        this.dl = str;
        this.pf = z;
        this.ls = z2;
        com.bytedance.sdk.openadsdk.core.nativeexpress.gc gcVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.gc(tTBaseVideoActivity, naVar, str, eo.g(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.g.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.gc, com.bytedance.sdk.openadsdk.core.g.g, com.bytedance.sdk.openadsdk.core.g.a
            public void z(View view, uy uyVar) {
                super.z(view, uyVar);
                tTBaseVideoActivity.z(2);
            }
        };
        this.e = gcVar;
        ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) gcVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(tTBaseVideoActivity.z(naVar));
        com.bytedance.sdk.openadsdk.core.nativeexpress.a aVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.a(tTBaseVideoActivity, naVar, str, eo.g(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.g.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a, com.bytedance.sdk.openadsdk.core.g.g, com.bytedance.sdk.openadsdk.core.g.a
            public void z(View view, uy uyVar) {
                super.z(view, uyVar);
                com.bytedance.sdk.openadsdk.core.g.z.g gVar = (com.bytedance.sdk.openadsdk.core.g.z.g) this.gz.z(com.bytedance.sdk.openadsdk.core.g.z.g.class);
                if (gVar == null || !gVar.g(view)) {
                    return;
                }
                tTBaseVideoActivity.z(2);
            }
        };
        this.gz = aVar;
        ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) aVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(tTBaseVideoActivity.z(naVar));
        com.bytedance.sdk.openadsdk.core.g.z zVar = new com.bytedance.sdk.openadsdk.core.g.z(tTBaseVideoActivity, naVar, str, 7);
        this.fo = zVar;
        tTBaseVideoActivity.z((com.bytedance.sdk.openadsdk.core.g.z.dl.dl) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.dl.class));
        ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) this.fo.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(tTBaseVideoActivity.z(naVar));
        if (naVar.lt() == 4) {
            this.uy = gz.z((Context) tTBaseVideoActivity, naVar, str, false);
            final String strMj = z().mj();
            this.uy.z(new com.bytedance.sdk.openadsdk.core.kb.g.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.g.3
                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void z() {
                    z.C0193z.z(strMj, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void z(long j, long j2, String str2, String str3) {
                    if (j > 0) {
                        z.C0193z.z(strMj, 3, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void g(long j, long j2, String str2, String str3) {
                    if (j > 0) {
                        z.C0193z.z(strMj, 2, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void dl(long j, long j2, String str2, String str3) {
                    if (j > 0) {
                        z.C0193z.z(strMj, 4, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void z(long j, String str2, String str3) {
                    z.C0193z.z(strMj, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void z(String str2, String str3) {
                    z.C0193z.z(strMj, 6, 100);
                }
            });
        }
    }

    public na z() {
        return this.g;
    }

    public String g() {
        return this.dl;
    }

    public com.bytedance.sdk.openadsdk.core.g.z dl() {
        return this.fo;
    }

    public int a() {
        if (!y.uy(this.g)) {
            return 1;
        }
        if (this.wp) {
            int iG = y.g(this.g) - this.m;
            this.m = y.g(this.g);
            return iG;
        }
        if (this.m >= y.g(this.g)) {
            return 0;
        }
        this.m++;
        return 1;
    }

    public void z(ViewGroup viewGroup, ViewGroup viewGroup2, FullRewardExpressView fullRewardExpressView) {
        this.kb = viewGroup2;
        if (viewGroup == null || fullRewardExpressView == null || z() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.uy;
        if (dlVar != null) {
            dlVar.z();
            if (fullRewardExpressView.getContext() != null && (fullRewardExpressView.getContext() instanceof Activity)) {
                this.uy.z((Activity) fullRewardExpressView.getContext());
            }
        }
        this.e.z(fullRewardExpressView);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.e.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.uy);
        fullRewardExpressView.setClickListener(this.e);
        this.gz.z(fullRewardExpressView);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.gz.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.uy);
        fullRewardExpressView.setClickCreativeListener(this.gz);
        this.fo.z(viewGroup);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.fo.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.uy);
        ImageView imageView = new ImageView(this.z);
        com.bytedance.sdk.openadsdk.gz.g.z(this.g.jz().get(0)).to(imageView);
        this.kb.addView(imageView);
    }

    public z.InterfaceC0210z gc() {
        return new z.InterfaceC0210z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.g.4
            @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
            public void dl() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
            public void z() {
                g.this.wp = true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
            public void z(int i, String str) {
                g.this.e();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
            public void g() {
                g.this.e();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
            public void z(long j, long j2) {
                oq.z((View) g.this.kb, 8);
                g.this.i = j;
            }
        };
    }

    public void z(boolean z) {
        this.f946a = z;
    }

    public boolean m() {
        return this.f946a;
    }

    public void e() {
        oq.z((View) this.kb, 0);
        this.z.i();
    }

    public void gz() {
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.uy;
        if (dlVar != null) {
            dlVar.g();
        }
        FullRewardExpressView fullRewardExpressView = this.p;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.i();
        }
        na naVar = this.g;
        un.g(naVar != null ? naVar.gc() : 0);
    }

    public void z(NativeExpressView nativeExpressView) {
        if (this.v.getAndSet(true)) {
            return;
        }
        Map<String, Object> mapZ = this.z.z(this.g);
        io.z(mapZ, this.g, nativeExpressView);
        com.bytedance.sdk.openadsdk.core.i.a.z(this.g, this.dl, mapZ, this.z.gp());
        com.bytedance.sdk.openadsdk.core.l.z.z().a();
        na naVar = this.g;
        un.z(naVar != null ? naVar.gc() : 0);
    }

    public void fo() {
        if (this.pf) {
            this.z.z(this.g, this.fo);
        }
    }

    public com.bykv.vk.openvk.component.video.api.dl.a uy() {
        com.bykv.vk.openvk.component.video.api.dl.a aVarZ = tf.z(1, this.g);
        aVarZ.g(this.g.mj());
        aVarZ.g(100);
        aVarZ.dl(100);
        aVarZ.dl(this.g.vk());
        aVarZ.g(this.f946a);
        return aVarZ;
    }

    public long kb() {
        return this.i;
    }

    public void g(boolean z) {
        this.g.wp(z);
    }

    public void wp() {
        if (this.ls) {
            return;
        }
        this.ls = true;
        com.bytedance.sdk.openadsdk.ls.dl.dl.g gVarZ = l.z(7);
        if (tf.v(this.g) != null) {
            com.bykv.vk.openvk.component.video.api.dl.a aVarZ = tf.z(1, this.g);
            aVarZ.z("material_meta", this.g);
            aVarZ.z("ad_slot", Integer.valueOf(gVarZ != null ? gVarZ.tb() : 0));
            com.bytedance.sdk.openadsdk.core.video.a.g.z(aVarZ, new z.InterfaceC0028z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.g.5
                @Override // com.bykv.vk.openvk.component.video.api.gc.z.InterfaceC0028z
                public void g(com.bykv.vk.openvk.component.video.api.dl.a aVar, int i) {
                }

                @Override // com.bykv.vk.openvk.component.video.api.gc.z.InterfaceC0028z
                public void z(com.bykv.vk.openvk.component.video.api.dl.a aVar, int i) {
                    aVar.ls();
                    aVar.m();
                }

                @Override // com.bykv.vk.openvk.component.video.api.gc.z.InterfaceC0028z
                public void z(com.bykv.vk.openvk.component.video.api.dl.a aVar, int i, String str) {
                    aVar.ls();
                    aVar.m();
                }
            });
        }
    }

    public void z(float f, float f2) {
        FullRewardExpressView fullRewardExpressView = new FullRewardExpressView(this.z, z(), l.z(7, String.valueOf(eo.fo(z())), f, f2), g(), false, null);
        this.p = fullRewardExpressView;
        fullRewardExpressView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.g.6
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
            public void z(View view, float f3, float f4) {
                g.this.gc = true;
            }
        });
        this.p.p();
    }

    public FullRewardExpressView g(float f, float f2) {
        if (this.p == null) {
            z(f, f2);
        }
        return this.p;
    }
}
