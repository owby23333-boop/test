package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.ugeno.e.z;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.z;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class z extends g {
    private com.bytedance.sdk.openadsdk.core.ugeno.fo.g fv;
    private com.bytedance.sdk.openadsdk.core.component.reward.g.gc io;
    private AtomicBoolean iq;
    private AtomicBoolean js;
    private com.bytedance.sdk.openadsdk.core.ugeno.fo.a ls;
    private com.bytedance.sdk.openadsdk.core.ugeno.gz.z p;
    private com.bytedance.sdk.openadsdk.core.i.m pf;
    private RewardLpBottomView q;
    private String tb;
    private boolean uf;
    private com.bytedance.sdk.openadsdk.core.ugeno.m.z v;
    private AtomicBoolean zw;

    public z(TTBaseVideoActivity tTBaseVideoActivity, na naVar, boolean z, com.bytedance.sdk.openadsdk.core.i.m mVar, com.bytedance.sdk.openadsdk.core.component.reward.g.gc gcVar) {
        super(tTBaseVideoActivity, naVar, z);
        this.v = naVar.hh();
        this.pf = mVar;
        this.g.e(0);
        this.js = new AtomicBoolean();
        this.iq = new AtomicBoolean();
        this.zw = new AtomicBoolean();
        this.io = gcVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void z() {
        super.z();
        this.tb = eo.z(eo.g(this.z));
        com.bytedance.sdk.openadsdk.core.ugeno.m.z zVar = this.v;
        if (zVar == null) {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.g.e(8);
                    z.this.g.js();
                }
            });
            return;
        }
        int iA = zVar.a();
        if (iA == 2) {
            p();
            return;
        }
        if (iA == 3) {
            fv();
        } else if (iA == 4) {
            js();
        } else {
            this.g.e(8);
            this.g.js();
        }
    }

    private void p() {
        com.bytedance.sdk.openadsdk.core.ugeno.fo.a aVar = new com.bytedance.sdk.openadsdk.core.ugeno.fo.a(this.g, this.e, this.pf, this.dl, this.tb, eo.g(this.z));
        this.ls = aVar;
        aVar.g(true);
        this.ls.z(new com.bytedance.sdk.openadsdk.core.ugeno.a.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.z.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.a.z
            public void z(View view) {
                z.this.g.e(8);
                z.this.js.set(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.a.z
            public void z(int i) {
                q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.z.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.g.e(8);
                        z.this.g.js();
                    }
                });
                z.this.js.set(false);
            }
        });
        this.ls.i();
    }

    private void fv() {
        FrameLayout frameLayout = new FrameLayout(this.g);
        this.e.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ugeno.fo.g gVar = new com.bytedance.sdk.openadsdk.core.ugeno.fo.g(this.g, frameLayout, this.pf, this.dl, this.tb, eo.g(this.z));
        this.fv = gVar;
        gVar.g(true);
        this.fv.z(new com.bytedance.sdk.openadsdk.core.ugeno.e.g() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.z.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.g
            public void z() {
                z.this.g.na();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.g
            public void g() {
                z.this.g.xl();
                z.this.iq.set(true);
                z.this.fv.tb();
            }
        });
        this.fv.z(new com.bytedance.sdk.openadsdk.core.ugeno.a.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.z.4
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.a.z
            public void z(View view) {
                z.this.g.e(8);
                z.this.js.set(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.a.z
            public void z(int i) {
                q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.z.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.g.e(8);
                        z.this.fv.p();
                        z.this.fv.z(tb.z(z.this.g, "tt_ecomm_page_reward_acquire"));
                        z.this.g.a(0);
                    }
                });
                z.this.js.set(false);
            }
        });
        this.fv.z(new z.InterfaceC0202z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.z.5
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.z.InterfaceC0202z
            public void z() {
                q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.z.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z.this.g.jq()) {
                            z.this.fv.z(tb.z(z.this.g, "tt_ecomm_page_reward_acquire"));
                            return;
                        }
                        z.this.fv.z(String.format(tb.z(z.this.g, "tt_ecomm_page_reward_tip"), Integer.valueOf(z.this.g.gb().ti())));
                    }
                });
            }
        });
        this.fv.i();
        com.bytedance.sdk.openadsdk.core.uy.ls().a().g(new z.g() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.z.6
            @Override // com.bytedance.sdk.openadsdk.core.un.z.g
            public void g() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.z.g
            public void z() {
                if (z.this.iq.get() || !z.this.fv.v()) {
                    z.this.zw.set(false);
                } else {
                    z.this.zw.set(true);
                }
            }
        });
        if (TextUtils.equals(this.v.z(), "3")) {
            return;
        }
        g();
    }

    public void g() {
        final ImageView imageView = new ImageView(this.g);
        float fDl = oq.dl(this.g, 18.0f);
        float fDl2 = oq.dl(this.g, 20.0f);
        int i = (int) fDl;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 53;
        int i2 = (int) fDl2;
        layoutParams.setMargins(i2, i2, i2, i2);
        this.e.addView(imageView, layoutParams);
        tb.z((Context) this.g, "tt_unmute", imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.z.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z.this.uf = !r3.uf;
                tb.z((Context) z.this.g, z.this.uf ? "tt_mute" : "tt_unmute", imageView);
                z.this.fv.dl(z.this.uf);
            }
        });
    }

    private void js() {
        com.bytedance.sdk.openadsdk.core.ugeno.gz.z zVar = new com.bytedance.sdk.openadsdk.core.ugeno.gz.z(this.g, tb(), this.v, this.dl);
        this.p = zVar;
        zVar.z(this.g.j());
        this.p.z(new com.bytedance.sdk.openadsdk.core.ugeno.a.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.z.8
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.a.z
            public void z(View view) {
                com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.z.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.g.e(8);
                        z.this.js.set(true);
                        if (z.this.q != null) {
                            z.this.q.z();
                        }
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.a.z
            public void z(int i) {
                q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.z.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.g.e(8);
                        z.this.g.js();
                    }
                });
                z.this.js.set(false);
            }
        });
        this.p.z();
    }

    private ViewGroup tb() {
        if (this.e == null) {
            return null;
        }
        PlayableEndcardFrameLayout playableEndcardFrameLayout = new PlayableEndcardFrameLayout(this.g);
        this.e.addView(playableEndcardFrameLayout);
        this.q = new RewardLpBottomView(this.g);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.e.addView(this.q, layoutParams);
        this.q.z(this.dl, this.tb);
        playableEndcardFrameLayout.z(new PlayableEndcardFrameLayout.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.z.9
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout.z
            public void z() {
                if (z.this.q != null) {
                    z.this.q.g();
                }
            }
        });
        return playableEndcardFrameLayout;
    }

    public boolean dl() {
        return this.zw.get();
    }

    public void z(boolean z) {
        this.zw.set(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void z(com.bytedance.sdk.openadsdk.core.g.g gVar, com.bytedance.sdk.openadsdk.core.g.g gVar2) {
        super.z(gVar, gVar2);
        com.bytedance.sdk.openadsdk.core.ugeno.fo.a aVar = this.ls;
        if (aVar != null) {
            aVar.z(this.g.j());
        }
        com.bytedance.sdk.openadsdk.core.ugeno.fo.g gVar3 = this.fv;
        if (gVar3 != null) {
            gVar3.z(this.g.j());
        }
        com.bytedance.sdk.openadsdk.core.ugeno.gz.z zVar = this.p;
        if (zVar != null) {
            zVar.z(gVar);
        }
    }

    public boolean a() {
        com.bytedance.sdk.openadsdk.core.ugeno.fo.g gVar = this.fv;
        if (gVar != null) {
            return gVar.v();
        }
        return false;
    }

    public AtomicInteger gc() {
        return new AtomicInteger(0);
    }

    public void z(int i) {
        if (this.ls == null || !com.bytedance.sdk.openadsdk.core.ugeno.uy.gc(this.dl)) {
            return;
        }
        this.ls.a(i);
    }

    public void g(boolean z) {
        if (this.fv == null || !com.bytedance.sdk.openadsdk.core.ugeno.uy.a(this.dl)) {
            return;
        }
        this.fv.dl(z);
    }

    public boolean m() {
        return this.js.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void z(DownloadListener downloadListener) {
        com.bytedance.sdk.openadsdk.core.ugeno.gz.z zVar = this.p;
        if (zVar != null) {
            zVar.z(downloadListener);
        }
    }

    public void e() {
        com.bytedance.sdk.openadsdk.core.ugeno.fo.g gVar = this.fv;
        if (gVar != null) {
            gVar.js();
        }
    }

    public void gz() {
        com.bytedance.sdk.openadsdk.core.ugeno.fo.g gVar = this.fv;
        if (gVar != null) {
            gVar.fv();
        }
    }

    public void fo() {
        com.bytedance.sdk.openadsdk.core.ugeno.fo.g gVar = this.fv;
        if (gVar != null) {
            gVar.q();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void uy() {
        com.bytedance.sdk.openadsdk.core.ugeno.gz.z zVar = this.p;
        if (zVar != null) {
            zVar.g();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.fo.g gVar = this.fv;
        if (gVar != null) {
            gVar.ls();
        }
        RewardLpBottomView rewardLpBottomView = this.q;
        if (rewardLpBottomView != null) {
            rewardLpBottomView.g();
        }
    }
}
