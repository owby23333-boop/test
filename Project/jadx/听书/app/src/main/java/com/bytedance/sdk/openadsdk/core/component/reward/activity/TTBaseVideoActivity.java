package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import androidx.media3.exoplayer.ExoPlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.a.fo;
import com.bytedance.sdk.openadsdk.core.component.reward.a.gz;
import com.bytedance.sdk.openadsdk.core.component.reward.a.kb;
import com.bytedance.sdk.openadsdk.core.component.reward.business.g.z;
import com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.dl;
import com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.g.dl;
import com.bytedance.sdk.openadsdk.core.component.reward.g.m;
import com.bytedance.sdk.openadsdk.core.component.reward.g.z;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardAuthToastLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog;
import com.bytedance.sdk.openadsdk.core.dislike.ui.z;
import com.bytedance.sdk.openadsdk.core.g.gc;
import com.bytedance.sdk.openadsdk.core.g.z.dl.dl;
import com.bytedance.sdk.openadsdk.core.gz.g;
import com.bytedance.sdk.openadsdk.core.i.z;
import com.bytedance.sdk.openadsdk.core.iq.fo;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.gp;
import com.bytedance.sdk.openadsdk.core.iq.hh;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.iq.uy;
import com.bytedance.sdk.openadsdk.core.iq.x;
import com.bytedance.sdk.openadsdk.core.iq.y;
import com.bytedance.sdk.openadsdk.core.iq.zw;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.multipro.g.z;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.io;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.iq;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.un;
import com.bytedance.sdk.openadsdk.core.video.g.z;
import com.bytedance.sdk.openadsdk.fo.z.g;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTBaseVideoActivity extends BaseThemeActivity implements l.z, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final ConcurrentHashMap<Integer, Boolean> f930a;
    private int b;
    private Double bm;
    protected a bv;
    protected final AtomicBoolean dl;
    public final AtomicBoolean e;
    protected gc ec;
    com.bytedance.sdk.openadsdk.core.component.reward.g.a eo;
    protected final z f;
    protected final AtomicBoolean fo;
    protected final AtomicBoolean fv;
    protected final l g;
    protected com.bytedance.sdk.openadsdk.core.playable.g.g gb;
    com.bytedance.sdk.openadsdk.core.component.reward.layout.gc gk;
    protected String gp;
    protected final AtomicBoolean gz;
    com.bytedance.sdk.openadsdk.core.component.reward.layout.g h;
    protected int hh;
    protected final AtomicBoolean i;
    protected boolean io;
    protected boolean iq;
    protected int j;
    private long ja;
    protected z.InterfaceC0210z jq;
    protected final AtomicBoolean js;
    protected final AtomicBoolean kb;
    RewardFullBaseLayout l;
    com.bytedance.sdk.openadsdk.core.component.reward.g.gc lq;
    protected final AtomicBoolean ls;
    private com.bytedance.sdk.openadsdk.core.g.g lw;
    protected final ConcurrentHashMap<Integer, Boolean> m;
    com.bytedance.sdk.openadsdk.core.component.reward.g.g mc;
    private float me;
    protected TTBaseVideoActivity na;
    private com.bytedance.sdk.openadsdk.hh.z nb;
    private int nh;
    protected dl oq;
    protected final AtomicBoolean p;
    protected final AtomicBoolean pf;
    protected final AtomicBoolean q;
    private final AtomicBoolean qd;
    private int r;
    private z.g rv;
    private g.z sd;
    protected com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z sv;
    protected boolean sy;
    protected String t;
    protected final AtomicBoolean tb;
    private z.InterfaceC0156z tc;
    private long tf;
    m ti;
    protected long uf;
    com.bytedance.sdk.openadsdk.core.component.reward.g.z un;
    protected final AtomicBoolean uy;
    protected final AtomicBoolean v;
    protected com.bytedance.sdk.openadsdk.core.dislike.ui.z vm;
    private AtomicBoolean vo;
    protected com.bytedance.sdk.openadsdk.core.component.reward.a.z wj;
    private com.bytedance.sdk.openadsdk.core.component.reward.gc.a wn;
    protected final AtomicBoolean wp;
    AbstractEndCardFrameLayout x;
    protected com.bytedance.sdk.openadsdk.core.component.reward.gc.dl xl;
    protected int y;
    protected final com.bytedance.sdk.openadsdk.core.component.reward.business.g.z yx;
    private int yz;
    protected final String z;
    protected boolean zw;
    private boolean zx;
    private final z.InterfaceC0190z zz;

    public void a(int i) {
    }

    protected abstract void a(String str);

    public void dl(int i) {
    }

    protected abstract void dl(boolean z);

    public String gk() {
        return "";
    }

    public void gz(int i) {
    }

    public int h() {
        return 0;
    }

    protected abstract void hh();

    public boolean l() {
        return false;
    }

    public String lq() {
        return "";
    }

    public abstract boolean sy();

    public void t() {
    }

    public String x() {
        return "";
    }

    public String z() {
        return null;
    }

    public TTBaseVideoActivity() {
        this.z = sy() ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.g = new l(Looper.getMainLooper(), this);
        this.dl = new AtomicBoolean(false);
        this.f930a = new ConcurrentHashMap<>();
        this.m = new ConcurrentHashMap<>();
        this.e = new AtomicBoolean(false);
        this.gz = new AtomicBoolean(false);
        this.fo = new AtomicBoolean(false);
        this.qd = new AtomicBoolean(false);
        this.uy = new AtomicBoolean(false);
        this.kb = new AtomicBoolean(false);
        this.wp = new AtomicBoolean(false);
        this.i = new AtomicBoolean(false);
        this.v = new AtomicBoolean(false);
        this.pf = new AtomicBoolean(false);
        this.ls = new AtomicBoolean(false);
        this.p = new AtomicBoolean(false);
        this.fv = new AtomicBoolean(false);
        this.js = new AtomicBoolean(false);
        this.tb = new AtomicBoolean(false);
        this.q = new AtomicBoolean(false);
        this.hh = -1;
        this.nh = 1;
        this.bm = null;
        this.tf = 0L;
        this.jq = new z.InterfaceC0210z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
            public void z() {
                TTBaseVideoActivity.this.g.removeMessages(300);
                TTBaseVideoActivity.this.ls();
                if (!TTBaseVideoActivity.this.ti.wp()) {
                    if (TTBaseVideoActivity.this.ja()) {
                        TTBaseVideoActivity.this.ti.g(TTBaseVideoActivity.this.ti.x());
                    } else {
                        TTBaseVideoActivity.this.ti.g(TTBaseVideoActivity.this.ti.gk() + 1000);
                    }
                }
                if (TTBaseVideoActivity.this.wj.m() && !TTBaseVideoActivity.this.ti.wp()) {
                    TTBaseVideoActivity.this.gk.g(true);
                }
                TTBaseVideoActivity.this.zx();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
            public void z(int i, String str) {
                if (TTBaseVideoActivity.this.zw) {
                    TTBaseVideoActivity.this.g.removeMessages(300);
                    TTBaseVideoActivity.this.i();
                    TTBaseVideoActivity.this.ti.z(5);
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    tTBaseVideoActivity.g(tTBaseVideoActivity.ti.g());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
            public void g() {
                TTBaseVideoActivity.this.g.removeMessages(300);
                TTBaseVideoActivity.this.ls();
                TTBaseVideoActivity.this.z(false, false);
                TTBaseVideoActivity.this.ti.z(6);
                TTBaseVideoActivity.this.ti.fo();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
            public void z(long j, long j2) {
                if (!TTBaseVideoActivity.this.zw && TTBaseVideoActivity.this.ti.g()) {
                    TTBaseVideoActivity.this.ti.z((Map<String, Object>) null);
                }
                boolean z = true;
                if (TTBaseVideoActivity.this.mc.mc()) {
                    TTBaseVideoActivity.this.ti.dl(true);
                    return;
                }
                TTBaseVideoActivity.this.g.removeMessages(300);
                if (j != TTBaseVideoActivity.this.ti.gk()) {
                    TTBaseVideoActivity.this.ls();
                }
                if (TTBaseVideoActivity.this.ti.g() || j2 == j) {
                    TTBaseVideoActivity.this.ti.g(j);
                    if (TTBaseVideoActivity.this.yw()) {
                        com.bytedance.sdk.openadsdk.core.component.reward.layout.gc gcVar = TTBaseVideoActivity.this.gk;
                        String strValueOf = String.valueOf(TTBaseVideoActivity.this.ti.h());
                        int iGk = (int) (TTBaseVideoActivity.this.ti.gk() / 1000);
                        if (j != j2 && !TTBaseVideoActivity.this.ti.mc()) {
                            z = false;
                        }
                        gcVar.z(strValueOf, iGk, 0, z);
                    }
                    TTBaseVideoActivity.this.dl(0);
                    TTBaseVideoActivity.this.t();
                    TTBaseVideoActivity.this.wj.tb();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
            public void dl() {
                if (TTBaseVideoActivity.this.bv == null || TTBaseVideoActivity.this.bv.z() == null) {
                    return;
                }
                TTBaseVideoActivity.this.bv.z().z();
            }
        };
        this.sv = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.12
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z
            public void z(ViewGroup viewGroup) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void z(int i) {
                TTBaseVideoActivity.this.wj.gp().z(i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public long z() {
                return TTBaseVideoActivity.this.wj.gp().z();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public int g() {
                return TTBaseVideoActivity.this.wj.gp().g();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public int dl() {
                return TTBaseVideoActivity.this.wj.gp().dl();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public long getActualPlayDuration() {
                return TTBaseVideoActivity.this.wj.gp().getActualPlayDuration();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void a() {
                TTBaseVideoActivity.this.wj.gp().a();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void g(int i) {
                TTBaseVideoActivity.this.wj.gp().g(i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void gc() {
                TTBaseVideoActivity.this.wj.gp().gc();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void z(int i, String str) {
                TTBaseVideoActivity.this.wj.gp().z(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void setPauseFromExpressView(boolean z) {
                TTBaseVideoActivity.this.wj.gp().setPauseFromExpressView(z);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void z(float f) {
                TTBaseVideoActivity.this.wj.gp().z(f);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void m() {
                TTBaseVideoActivity.this.wj.gp().m();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z
            public void z(View view) {
                TTBaseVideoActivity.this.z(2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void dl(int i) {
                TTBaseVideoActivity.this.dl(i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z
            public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar) {
                uy uyVar;
                if (TTBaseVideoActivity.this.ec != null) {
                    if (dlVar instanceof zw) {
                        zw zwVar = (zw) dlVar;
                        uyVar = new uy();
                        uyVar.z(zwVar.z);
                        uyVar.g(zwVar.g);
                        uyVar.dl(zwVar.dl);
                        uyVar.a(zwVar.f1208a);
                        uyVar.z(zwVar.gc);
                        uyVar.g(zwVar.m);
                        uyVar.z(zwVar.pf);
                    } else {
                        uyVar = null;
                    }
                    TTBaseVideoActivity.this.ec.z(view, uyVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z
            public void g(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar) {
                uy uyVar;
                if ((i == 1 || i == 2) && (dlVar instanceof zw)) {
                    zw zwVar = (zw) dlVar;
                    uyVar = new uy();
                    uyVar.z(zwVar.z);
                    uyVar.g(zwVar.g);
                    uyVar.dl(zwVar.dl);
                    uyVar.a(zwVar.f1208a);
                    uyVar.z(zwVar.gc);
                    uyVar.g(zwVar.m);
                    uyVar.z(zwVar.pf);
                } else {
                    uyVar = null;
                }
                if (i == 2) {
                    TTBaseVideoActivity.this.ec.z(view, uyVar);
                }
                if (i == 1) {
                    TTBaseVideoActivity.this.ec.z(view, uyVar);
                }
            }
        };
        this.zz = new z.InterfaceC0190z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.15
            @Override // com.bytedance.sdk.openadsdk.core.multipro.g.z.InterfaceC0190z
            public boolean h() {
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.multipro.g.z.InterfaceC0190z
            public com.bytedance.sdk.openadsdk.core.multipro.g.z x() {
                com.bytedance.sdk.openadsdk.core.multipro.g.z zVar = new com.bytedance.sdk.openadsdk.core.multipro.g.z();
                if (TTBaseVideoActivity.this.ti != null) {
                    zVar.e = TTBaseVideoActivity.this.ti.ls();
                    zVar.z = TTBaseVideoActivity.this.ti.z();
                    zVar.gz = TTBaseVideoActivity.this.iq;
                }
                return zVar;
            }
        };
        this.f = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.g(new z.InterfaceC0154z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.16
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z.InterfaceC0154z
            public TTBaseVideoActivity getActivity() {
                return TTBaseVideoActivity.this.na;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z.InterfaceC0154z
            public RewardFullBaseLayout z() {
                return TTBaseVideoActivity.this.l;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z.InterfaceC0154z
            public boolean g() {
                return TTBaseVideoActivity.this.sy();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z.InterfaceC0154z
            public na dl() {
                return TTBaseVideoActivity.this.gc;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z.InterfaceC0154z
            public boolean a() {
                return TTBaseVideoActivity.this.zx;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z.InterfaceC0154z
            public int gc() {
                return TTBaseVideoActivity.this.wj.sy();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z.InterfaceC0154z
            public int m() {
                return TTBaseVideoActivity.this.wj.m(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z.InterfaceC0154z
            public boolean e() {
                return TTBaseVideoActivity.this.tb.get();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z.InterfaceC0154z
            public boolean gz() {
                return TTBaseVideoActivity.this.jq();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z.InterfaceC0154z
            public boolean fo() {
                return TTBaseVideoActivity.this.wj.y();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z.InterfaceC0154z
            public void z(int i, int i2) {
                if (i == 3) {
                    TTBaseVideoActivity.this.i(2);
                }
                TTBaseVideoActivity.this.z(i, i2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z.InterfaceC0154z
            public void z(int i) {
                if (i == 3) {
                    TTBaseVideoActivity.this.v(2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z.InterfaceC0154z
            public void uy() {
                if (TTBaseVideoActivity.this.wj instanceof kb) {
                    ((kb) TTBaseVideoActivity.this.wj).me();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z.InterfaceC0154z
            public void kb() {
                if (TTBaseVideoActivity.this.wj instanceof kb) {
                    ((kb) TTBaseVideoActivity.this.wj).nh();
                }
            }
        });
        this.yx = new com.bytedance.sdk.openadsdk.core.component.reward.business.g.g(new z.InterfaceC0151z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.17
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z.InterfaceC0151z
            public Activity getActivity() {
                return TTBaseVideoActivity.this.na;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z.InterfaceC0151z
            public na z() {
                return TTBaseVideoActivity.this.gc;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z.InterfaceC0151z
            public String g() {
                return TTBaseVideoActivity.this.gp;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z.InterfaceC0151z
            public void dl() {
                TTBaseVideoActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z.InterfaceC0151z
            public void z(int i, TTProgressBar tTProgressBar) {
                try {
                    TTBaseVideoActivity.this.l.z(i, tTProgressBar);
                } catch (Exception unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z.InterfaceC0151z
            public void z(boolean z, String str, String str2) {
                if (iq.dl(TTBaseVideoActivity.this.gc)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("visible", z);
                    jSONObject.put("entrance_text", gp.z(TTBaseVideoActivity.this.gc, str, str2));
                } catch (JSONException e) {
                    wp.z(e);
                }
                TTBaseVideoActivity.this.gk.z("showPlayAgainEntrance", jSONObject);
                TTBaseVideoActivity.this.mc.z(jSONObject);
                if (TTBaseVideoActivity.this.mc.mc()) {
                    return;
                }
                TTBaseVideoActivity.this.lq.e(z);
                TTBaseVideoActivity.this.lq.z(gp.z(TTBaseVideoActivity.this.gc, str, str2));
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z.InterfaceC0151z
            public void a() {
                TTBaseVideoActivity.this.na();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z.InterfaceC0151z
            public void gc() {
                if (TTBaseVideoActivity.this.ti != null) {
                    TTBaseVideoActivity.this.ti.e();
                }
            }
        });
        this.vo = new AtomicBoolean(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.na = this;
        me();
        z(getIntent());
        g(bundle);
        g(getIntent());
        if (z(bundle)) {
            yz();
            nh();
            sd();
            fo();
            this.wj.z(this.r, this.yz);
            setContentView(this.l);
            a();
            this.wj.g();
            com.bytedance.sdk.openadsdk.core.component.reward.layout.gc gcVar = this.gk;
            if (gcVar != null) {
                gcVar.z(this.zz);
            }
            if (tc()) {
                this.wn = new com.bytedance.sdk.openadsdk.core.component.reward.gc.a();
            }
            SaasAuthRewardDialog saasAuthRewardDialog = (SaasAuthRewardDialog) findViewById(2114387968);
            if (saasAuthRewardDialog != null) {
                saasAuthRewardDialog.z(this.gc, this.z, sy() ? 7 : 5);
            }
            if (x.g(sy(), this.gc, true)) {
                mc().getSceneFrameContainer().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.18
                    @Override // java.lang.Runnable
                    public void run() {
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, TTBaseVideoActivity.this.mc().getSceneFrameContainer().getHeight(), 0.0f);
                        translateAnimation.setDuration(300L);
                        translateAnimation.setFillAfter(true);
                        TTBaseVideoActivity.this.mc().getSceneFrameContainer().startAnimation(translateAnimation);
                    }
                });
            }
        }
    }

    private boolean tc() {
        if (this.gc != null && com.bytedance.sdk.openadsdk.core.live.g.z().g(this.gc)) {
            String strVj = this.gc.vj();
            if (TextUtils.isEmpty(strVj)) {
                return false;
            }
            try {
                return new JSONObject(strVj).optInt("saas_play_time_type") == 1;
            } catch (JSONException e) {
                wp.g("TTBaseVideoActivity", e);
            }
        }
        return false;
    }

    private void me() {
        this.l = new RewardFullBaseLayout(this.na);
        this.lq = new com.bytedance.sdk.openadsdk.core.component.reward.g.gc(this.na);
        this.mc = new com.bytedance.sdk.openadsdk.core.component.reward.g.g(this.na);
        this.un = new com.bytedance.sdk.openadsdk.core.component.reward.g.z(this.na);
        this.ti = new m(this.na);
        this.eo = new com.bytedance.sdk.openadsdk.core.component.reward.g.a(this.na);
        this.oq = new dl(this.na);
    }

    public void g() {
        finish();
    }

    public void dl() {
        this.ti.wj();
        this.ti.z(2);
        this.ti.fo();
        v();
        m(2);
    }

    public void onSkipBorderClick(View view) {
        this.wj.z(view);
    }

    protected boolean z(Bundle bundle) {
        this.un.z(this.gc, this.z, this.gp);
        if (bundle != null) {
            this.un.z();
        }
        com.bytedance.sdk.openadsdk.core.a.z().g(this.gc);
        if (this.gc != null) {
            return true;
        }
        wp.a("TTBaseVideoActivity", "mMaterialMeta is null , no data to display ,the TTBaseVideoActivity finished !!");
        g();
        return false;
    }

    private void nh() {
        com.bytedance.sdk.openadsdk.core.component.reward.a.z zVarZ = com.bytedance.sdk.openadsdk.core.component.reward.a.a.z(this.na, this.gc);
        this.wj = zVarZ;
        if (zVarZ == null) {
            wp.a("TTBaseVideoActivity", "initAdType failed , finish activity");
            finish();
            return;
        }
        zVarZ.getClass().getSimpleName();
        if (!x.g(sy(), this.gc, true)) {
            this.iq = com.bytedance.sdk.openadsdk.core.zw.g().z(this.gc, this.j);
        }
        this.wj.z(this.lq, this.ti, this.mc, this.eo, this.un);
        com.bytedance.sdk.openadsdk.core.component.reward.gc.dl dlVar = new com.bytedance.sdk.openadsdk.core.component.reward.gc.dl(sy(), this.gc, this.ti, this.wj);
        this.xl = dlVar;
        dlVar.g(this.b);
        this.wj.z(this.z, this.iq, sy(), this.xl);
        this.wj.gz();
    }

    private void r() {
        if (this.gc == null || this.l == null) {
            return;
        }
        String strVj = this.gc.vj();
        if (TextUtils.isEmpty(strVj)) {
            return;
        }
        try {
            int iOptInt = new JSONObject(strVj).optInt("auth_reward_gold");
            if (iOptInt > 0) {
                this.l.addView(new RewardAuthToastLayout(this.na, iOptInt));
            }
        } catch (JSONException e) {
            wp.g("TTBaseVideoActivity", e);
        }
    }

    protected void a() {
        this.l.z(this.wj);
        r();
        this.h = this.wj.z(sy());
        this.gk = this.wj.wp();
        this.x = this.wj.i();
        this.h.z();
        e();
        this.h.z(this.ec, this.lw);
        this.h.z(this.un.e());
        this.lq.z(this.gc, this.mc, sy(), this.ec);
        this.lq.a(this.iq);
        if (this.un.dl()) {
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.ec.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.un.g());
            this.un.z(this.tc);
        }
        this.un.z(this.rv);
        this.un.z(this.zz);
        this.mc.z(this.lq, this.un, sy(), this.z, this.r, this.yz);
        this.mc.z(this.gc, this.ec, this.zz.x(), this.x);
        this.eo.z(this.mc, this.gc, this.z, this.lq);
        this.oq.z(this.gc, this.z, this.h.i());
        this.ti.z(this.gc);
        this.nb = new com.bytedance.sdk.openadsdk.hh.z();
        this.bv = new a(this.gc, false, this.sv);
        this.gb = new com.bytedance.sdk.openadsdk.core.playable.g.g(this.z);
    }

    protected void gc() {
        com.bytedance.sdk.openadsdk.core.component.reward.g.g gVar;
        v.z().dl(this.gc, "stats_reward_full_show_endcard");
        if (isDestroyed() || isFinishing() || (gVar = this.mc) == null || gVar.mc()) {
            return;
        }
        if (!js.a(this.gc)) {
            this.mc.a(true);
        }
        this.wj.io();
        if (this.wj instanceof kb) {
            this.f.g(true);
            this.f.m();
        }
        if (!(this.wj instanceof gz) || !this.mc.js() || (this.wj instanceof fo)) {
            this.mc.q();
        }
        this.lq.z(true);
        this.eo.z(this.iq);
        this.mc.kb();
        if ((this.wj instanceof gz) && this.mc.l()) {
            this.mc.gz();
            return;
        }
        this.lq.z(2);
        com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar = this.vm;
        if (zVar != null) {
            zVar.g();
        }
        g.z zVar2 = this.sd;
        if (zVar2 != null) {
            zVar2.gc();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.layout.g gVar2 = this.h;
        if (gVar2 != null) {
            gVar2.gc(8);
        }
        this.mc.dl(false);
        if (this.mc.ls()) {
            if (!tf.uy(this.gc) && !iq.g(this.gc)) {
                this.mc.z(true, 0, (String) null);
            }
            this.mc.i();
            this.g.sendEmptyMessageDelayed(500, 100L);
            return;
        }
        if (!tf.uy(this.gc)) {
            this.mc.z(false, TTAdConstant.INTERACTION_TYPE_CODE, "end_card_timeout");
        }
        this.mc.gc(true);
        this.ti.gz();
    }

    public void m() {
        if (!this.wj.f()) {
            if (iq.e(this.gc)) {
                return;
            }
            g(true, true);
        } else {
            if (g(this.ti.m(), false)) {
                return;
            }
            z(true, true);
        }
    }

    protected boolean z(long j, boolean z) {
        if (!this.ti.zw()) {
            return false;
        }
        if (!z || !this.ti.io()) {
            tf();
        }
        boolean z2 = this.ti.z(j, this.iq, this.wj.zw());
        if (z2 && !z) {
            if (iq.e(this.gc)) {
                return true;
            }
            g(true, true);
        }
        return z2;
    }

    void e() {
        gc gcVar = new gc(this.na, this.gc, this.z, sy() ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.19
            @Override // com.bytedance.sdk.openadsdk.core.g.gc
            public void g(View view, uy uyVar) {
                TTBaseVideoActivity.this.z(2);
                TTBaseVideoActivity.this.un.z(view, TTBaseVideoActivity.this.tc, uyVar);
            }
        };
        this.ec = gcVar;
        if (this.wj instanceof com.bytedance.sdk.openadsdk.core.component.reward.a.m) {
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) gcVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.zz);
        }
        z((com.bytedance.sdk.openadsdk.core.g.z.dl.dl) this.ec.z(com.bytedance.sdk.openadsdk.core.g.z.dl.dl.class));
        this.ec.z(this.h.i());
        ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) this.ec.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(j());
        com.bytedance.sdk.openadsdk.core.g.g gVar = new com.bytedance.sdk.openadsdk.core.g.g(this.na, this.gc, this.z, sy() ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.20
            @Override // com.bytedance.sdk.openadsdk.core.g.g, com.bytedance.sdk.openadsdk.core.g.a
            public void z(View view, uy uyVar) {
                TTBaseVideoActivity.this.oq.z(view, uyVar);
            }
        };
        this.lw = gVar;
        z((com.bytedance.sdk.openadsdk.core.g.z.dl.dl) gVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.dl.class));
        this.tc = new z.InterfaceC0156z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.21
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.g.z.InterfaceC0156z
            public void z(String str, JSONObject jSONObject) {
                TTBaseVideoActivity.this.oq.z(str, jSONObject);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.g.z.InterfaceC0156z
            public void z(View view, uy uyVar) {
                TTBaseVideoActivity.this.oq.z(view, uyVar);
            }
        };
        this.rv = new z.g() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.g.z.g
            public void z(boolean z) {
                if (z) {
                    TTBaseVideoActivity.this.mc.z(1, 0);
                }
                TTBaseVideoActivity.this.z("点击开始下载");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.g.z.g
            public void z(boolean z, long j, long j2, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.mc.z(j2, j, 3);
                }
                if (j > 0) {
                    TTBaseVideoActivity.this.z("已下载" + ((int) ((j2 * 100) / j)) + "%");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.g.z.g
            public void g(boolean z, long j, long j2, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.mc.z(j2, j, 2);
                }
                TTBaseVideoActivity.this.z("下载暂停");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.g.z.g
            public void dl(boolean z, long j, long j2, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.mc.z(j2, j, 4);
                }
                TTBaseVideoActivity.this.z("下载失败");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.g.z.g
            public void z(boolean z, long j, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.mc.z(5, 100);
                }
                TTBaseVideoActivity.this.z("点击安装");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.g.z.g
            public void z(boolean z, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.mc.z(6, 100);
                }
                TTBaseVideoActivity.this.z("点击打开");
            }
        };
        this.wj.z(this.ec);
    }

    public void z(final com.bytedance.sdk.openadsdk.core.g.z.dl.dl dlVar) {
        dlVar.z(new dl.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.3
            @Override // com.bytedance.sdk.openadsdk.core.g.z.dl.dl.z
            public boolean z() {
                dlVar.z(TTBaseVideoActivity.this.gz());
                dlVar.z(TTBaseVideoActivity.this.z);
                dlVar.z(TTBaseVideoActivity.this.bm);
                return TTBaseVideoActivity.this.qd.get();
            }
        });
    }

    public Map<String, Object> gz() {
        Map<String, Object> mapJ = j();
        if (this.uf > 0) {
            mapJ.put("object_media_holder_time", Long.valueOf((System.currentTimeMillis() - this.uf) / 1000));
        }
        com.bytedance.sdk.openadsdk.core.component.reward.a.z zVar = this.wj;
        if (zVar != null && zVar.m() && this.gk != null) {
            io.z(mapJ, this.gc, this.gk.wp());
        }
        return mapJ;
    }

    public void z(String str) {
        this.mc.z(str);
    }

    private void yz() {
        com.bytedance.sdk.openadsdk.core.i.a.z(this.gc, getClass().getName());
        this.j = eo.fo(this.gc);
        this.me = this.gc.tk();
        this.nh = this.gc.zr();
        gb.z(this.gc, false);
        gb.g(this.gc, false);
        com.bytedance.sdk.openadsdk.core.gz.a.dl = false;
        com.bytedance.sdk.openadsdk.core.gz.a.g = 0;
        com.bytedance.sdk.openadsdk.core.gz.a.z = 0;
        com.bytedance.sdk.openadsdk.core.gz.a.f1113a = false;
    }

    protected void fo() {
        float[] fArrZ = com.bytedance.sdk.openadsdk.core.component.reward.gc.g.z(this.na.getApplicationContext(), this.me, this.nh);
        float f = fArrZ[0];
        float f2 = fArrZ[1];
        if (this.me == 100.0f) {
            this.r = (int) f;
            this.yz = (int) f2;
            return;
        }
        int[] iArrZ = com.bytedance.sdk.openadsdk.core.component.reward.gc.g.z(this.na.getApplicationContext(), this.me, this.gc.la(), this.nh);
        int i = iArrZ[0];
        int i2 = iArrZ[1];
        int i3 = iArrZ[2];
        int i4 = iArrZ[3];
        float f3 = i;
        float f4 = i3;
        this.r = (int) ((f - f3) - f4);
        float f5 = i2;
        float f6 = i4;
        this.yz = (int) ((f2 - f5) - f6);
        if (!hh.z(this.gc) || com.bytedance.sdk.openadsdk.core.pf.a.z(String.valueOf(this.j))) {
            try {
                this.l.z(oq.dl(this.na, f3), oq.dl(this.na, f5), oq.dl(this.na, f4), oq.dl(this.na, f6));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (sy() && this.yx.g()) {
            g();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mc.wp();
        com.bytedance.sdk.openadsdk.hh.z zVar = this.nb;
        if (zVar != null) {
            zVar.z();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f.gc()) {
            g();
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.gc.a aVar = this.wn;
        if (aVar != null) {
            aVar.a();
            int iZ = (int) this.wn.z(TimeUnit.SECONDS);
            z(iZ, false);
            this.wn.gc();
            if (this.gk != null && !gb.p(this.gc)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", iZ);
                } catch (JSONException e) {
                    wp.z(e);
                }
                this.gk.z("reduceTime", jSONObject);
            }
        }
        this.zw = true;
        this.mc.g();
        this.un.a();
        com.bytedance.sdk.openadsdk.core.component.reward.a.z zVar = this.wj;
        if (zVar != null) {
            zVar.g(this.f930a.containsKey(0));
            xl();
            this.eo.z();
            nb();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.a aVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.a();
        aVar2.z = x.z(sy()) > 0;
        aVar2.g = x.z(sy());
        z(1, aVar2);
        this.g.sendEmptyMessageDelayed(1300, this.xl.fo());
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        na();
        this.zw = false;
        com.bytedance.sdk.openadsdk.core.component.reward.a.z zVar = this.wj;
        if (zVar != null) {
            zVar.v();
        }
        this.un.gc();
        this.mc.a();
        com.bytedance.sdk.openadsdk.core.component.reward.gc.a aVar = this.wn;
        if (aVar != null) {
            aVar.dl();
        }
        this.g.removeMessages(1300);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.core.component.reward.a.z zVar = this.wj;
        if (zVar != null) {
            zVar.dl(this.e.get());
        }
        this.mc.gc();
        com.bytedance.sdk.openadsdk.hh.z zVar2 = this.nb;
        if (zVar2 != null) {
            zVar2.g();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.bytedance.sdk.openadsdk.core.component.reward.a.z zVar = this.wj;
        if (zVar != null) {
            zVar.pf();
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar2 = this.vm;
        if (zVar2 != null) {
            zVar2.g();
        }
        bm();
    }

    private void bm() {
        v.z().dl(this.gc, "stats_reward_full_destroy");
        com.bytedance.sdk.openadsdk.core.gz.a.dl = false;
        com.bytedance.sdk.openadsdk.core.gz.a.g = 0;
        com.bytedance.sdk.openadsdk.core.gz.a.z = 0;
        com.bytedance.sdk.openadsdk.core.gz.a.f1113a = false;
        this.g.removeCallbacksAndMessages(null);
        this.ti.uf();
        this.un.m();
        this.mc.m();
        a aVar = this.bv;
        if (aVar != null) {
            aVar.g();
        }
        dl(true);
        hh();
        a("recycleRes");
        if (this.gc != null) {
            com.bytedance.sdk.openadsdk.core.io.z(this.gc.dc());
            un.g(this.gc.gc());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("multi_process_key", this.gp);
            bundle.putBoolean("is_preload", this.io);
            bundle.putLong("object_create_ts", this.uf);
            bundle.putBoolean("is_adm", this.sy);
            bundle.putInt("key_video_cache_callback", this.hh);
            bundle.putLong("video_current", this.ti.ls());
            bundle.putBoolean("is_mute", this.iq);
            bundle.putString("rit_scene", this.t);
            Double d = this.bm;
            bundle.putString("_client_bidding_aution_price", d == null ? "" : String.valueOf(d));
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.bytedance.sdk.openadsdk.core.playable.g.g gVar = this.gb;
        if (gVar != null) {
            gVar.z(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gc == null) {
            return;
        }
        if (na.dl(this.gc) || this.gc.da() == 1 || (this.wj instanceof fo)) {
            this.mc.pf();
        }
        com.bytedance.sdk.openadsdk.core.playable.g.g gVar = this.gb;
        if ((gVar == null || !gVar.g(this.na, this.gc)) && js.kb(this.gc)) {
            uy();
        }
    }

    public void uy() {
        if (this.mc.v()) {
            this.mc.pf();
            return;
        }
        if (!this.mc.uf() && !com.bytedance.sdk.openadsdk.core.ugeno.uy.gc(this.gc) && !com.bytedance.sdk.openadsdk.core.ugeno.uy.a(this.gc)) {
            g();
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar = new com.bytedance.sdk.openadsdk.core.component.reward.dl.uy() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void z() {
                if (js.kb(TTBaseVideoActivity.this.gc)) {
                    new z.C0178z().gc(TTBaseVideoActivity.this.gc.mj()).z("rewarded_video").g("popup_play").a(TTBaseVideoActivity.this.gc.vk()).z((com.bytedance.sdk.openadsdk.m.z.z) null);
                    if (com.bytedance.sdk.openadsdk.core.ugeno.uy.gc(TTBaseVideoActivity.this.gc) || com.bytedance.sdk.openadsdk.core.ugeno.uy.a(TTBaseVideoActivity.this.gc)) {
                        return;
                    }
                    TTBaseVideoActivity.this.g("onClickModalCallback");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void g() {
                if (js.kb(TTBaseVideoActivity.this.gc)) {
                    new z.C0178z().gc(TTBaseVideoActivity.this.gc.mj()).z("rewarded_video").g("popup_cancel").a(TTBaseVideoActivity.this.gc.vk()).z((com.bytedance.sdk.openadsdk.m.z.z) null);
                    TTBaseVideoActivity.this.v();
                    TTBaseVideoActivity.this.g();
                }
            }
        };
        if (com.bytedance.sdk.openadsdk.core.ugeno.uy.gc(this.gc) || com.bytedance.sdk.openadsdk.core.ugeno.uy.a(this.gc)) {
            z(uyVar);
        } else {
            g(uyVar);
        }
    }

    private void z(com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar) {
        int iTi = this.wj.ti();
        TTBaseVideoActivity tTBaseVideoActivity = this.na;
        if (tTBaseVideoActivity != null && tTBaseVideoActivity.getIntent() != null) {
            this.na.getIntent().putExtra("remainTime", iTi);
        }
        if (iTi > 0) {
            if (z(this.gc, uyVar)) {
                return;
            }
            uyVar.g();
            return;
        }
        g();
    }

    /* JADX WARN: Type inference failed for: r9v2, types: [com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity$6] */
    private void g(final com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar) {
        final boolean[] zArr = {false};
        com.bytedance.sdk.openadsdk.fo.z.g.z(new g.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.fo.z.g.z
            public void z() {
                zArr[0] = true;
                uyVar.g();
            }

            @Override // com.bytedance.sdk.openadsdk.fo.z.g.z
            public void z(int i) {
                zArr[0] = true;
                if (TTBaseVideoActivity.this.na != null && TTBaseVideoActivity.this.na.getIntent() != null) {
                    TTBaseVideoActivity.this.na.getIntent().putExtra("remainTime", i);
                }
                if (i > 0) {
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    if (tTBaseVideoActivity.z(tTBaseVideoActivity.gc, uyVar)) {
                        return;
                    }
                }
                uyVar.g();
            }
        });
        g("onClickBrowseClose");
        new CountDownTimer(1000L, 1000L) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.6
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (zArr[0]) {
                    return;
                }
                TTBaseVideoActivity.this.g();
            }
        }.start();
    }

    public void g(String str) {
        mc mcVarSy = this.mc.sy();
        if (mcVarSy == null || isFinishing()) {
            g();
            return;
        }
        try {
            mcVarSy.g(str, (JSONObject) null);
        } catch (Exception e) {
            g();
            wp.z(e);
        }
    }

    public boolean z(na naVar, final com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar) {
        if (!sy() || !com.bytedance.sdk.openadsdk.core.zw.g().e(String.valueOf(this.j)) || this.f930a.containsKey(0) || isFinishing()) {
            return false;
        }
        if (System.currentTimeMillis() - this.tf < 1000) {
            return true;
        }
        this.tf = System.currentTimeMillis();
        g.z zVarZ = this.wj.z(naVar, new com.bytedance.sdk.openadsdk.core.component.reward.dl.uy() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void dl() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void z() {
                com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar2 = uyVar;
                if (uyVar2 != null) {
                    uyVar2.z();
                }
                TTBaseVideoActivity.this.oq.z("reward_retain_dialog_cancel", TTBaseVideoActivity.this.sd.z(), TTBaseVideoActivity.this.sd.g());
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void g() {
                TTBaseVideoActivity.this.v.set(true);
                com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar2 = uyVar;
                if (uyVar2 != null) {
                    uyVar2.g();
                }
                TTBaseVideoActivity.this.oq.z("reward_retain_dialog_skip", TTBaseVideoActivity.this.sd.z(), TTBaseVideoActivity.this.sd.g());
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void z(int i) {
                TTBaseVideoActivity.this.z(i, true);
                TTBaseVideoActivity.this.lq.g("恭喜您，可提前" + i + "s获得奖励～");
            }
        });
        this.sd = zVarZ;
        this.oq.z("reward_retain_dialog_show", zVarZ.z(), this.sd.g());
        return this.sd.dl();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        oq.g((Activity) this.na);
        try {
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.8
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i == 0) {
                        if (TTBaseVideoActivity.this.gb != null) {
                            TTBaseVideoActivity.this.gb.z();
                        }
                        try {
                            if (TTBaseVideoActivity.this.isFinishing()) {
                                return;
                            }
                            if (TTBaseVideoActivity.this.nh == 2) {
                                TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.8.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        oq.z((Activity) TTBaseVideoActivity.this.na);
                                    }
                                }, 2500L);
                            } else {
                                TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.8.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        oq.g((Activity) TTBaseVideoActivity.this.na);
                                    }
                                }, 500L);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private void sd() {
        final View decorView;
        if (this.gc == null || !this.gc.a()) {
            final int iEn = com.bytedance.sdk.openadsdk.core.zw.g().en();
            try {
                requestWindowFeature(1);
                getWindow().addFlags(16777216);
                getWindow().addFlags(128);
                com.bytedance.sdk.openadsdk.core.zw.z(this.na);
                if (!this.wj.j()) {
                    getWindow().addFlags(1024);
                    if (iEn == 1) {
                        if (Build.VERSION.SDK_INT >= 30) {
                            getWindow().setDecorFitsSystemWindows(true);
                        }
                        getWindow().getDecorView().setFitsSystemWindows(true);
                    }
                }
            } catch (Throwable unused) {
            }
            if (iEn == 1) {
                return;
            }
            try {
                decorView = getWindow().getDecorView();
            } catch (Throwable unused2) {
                decorView = null;
            }
            if (decorView == null) {
                return;
            }
            decorView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (oq.g() && TTBaseVideoActivity.this.nh == 1 && TTBaseVideoActivity.this.na.getResources().getConfiguration().orientation == 1) {
                            int height = TTBaseVideoActivity.this.getWindow().getDecorView().getHeight();
                            if (iEn == 1) {
                                Rect rect = new Rect();
                                TTBaseVideoActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                                height = rect.bottom - rect.top;
                            }
                            if (Math.abs(oq.fo((Context) TTBaseVideoActivity.this.na) - height) == 0 && decorView.isAttachedToWindow()) {
                                View view = decorView;
                                view.setPadding(view.getPaddingLeft(), (int) (decorView.getPaddingTop() + oq.kb((Context) TTBaseVideoActivity.this.na)), decorView.getPaddingRight(), decorView.getPaddingBottom());
                            }
                        }
                    } catch (Throwable unused3) {
                    }
                }
            });
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Map<String, Object> mapJ = j();
        com.bytedance.sdk.openadsdk.core.component.reward.g.g gVar = this.mc;
        if (gVar != null) {
            gVar.z(mapJ);
            this.mc.a();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.a.z zVar = this.wj;
        if (zVar != null) {
            zVar.g(mapJ);
        }
        com.bytedance.sdk.openadsdk.core.i.a.m(this.gc, this.z, "click_close", mapJ);
        hh();
        super.finish();
    }

    public void kb() {
        if (this.wj.f()) {
            this.ti.z(3);
            this.ti.js();
            this.ti.dl(true);
            z(false, false);
        }
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        int i = message.what;
        int i2 = message.what;
        if (i2 == 300) {
            kb();
            return;
        }
        if (i2 == 400) {
            this.ti.fo();
            if (this.wj.m()) {
                this.gk.z(true);
            }
            z(false, true);
            return;
        }
        if (i2 == 500) {
            this.mc.e();
            this.ti.gz();
            this.h.dl(false);
            this.gk.dl(false);
            this.gk.a();
            return;
        }
        if (i2 == 600) {
            this.lq.z(false, null, null, true, true);
            return;
        }
        if (i2 == 700) {
            this.mc.x();
            return;
        }
        if (i2 == 1200) {
            if (gb.p(this.gc)) {
                return;
            }
            if (this.mc.h()) {
                z(1, false);
                this.eo.z(oq(), this.wj.ti());
                dl(0);
            }
            this.g.sendEmptyMessageDelayed(1200, 1000L);
            return;
        }
        if (i2 != 1300) {
            return;
        }
        this.g.sendEmptyMessageDelayed(1300, this.xl.fo());
        if (io()) {
            return;
        }
        this.xl.gz();
        if (!sv()) {
            this.xl.e();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.a aVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.a();
        if (x.g(sy()) > 0) {
            int iGc = x.gc(this.gc) / 1000;
            int iG = x.g(sy());
            if (iGc < iG) {
                iG = iGc;
            }
            if (iGc - iG <= this.wj.sy()) {
                aVar.z = true;
                aVar.g = iG;
            }
        }
        z(2, aVar);
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.a aVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.a();
        aVar2.z = true;
        z(3, aVar2);
        this.f.e();
        this.wj.gb();
    }

    public void g(int i) {
        if (i <= 0) {
            this.lq.z(false, null, null, true, true);
        } else {
            this.g.sendEmptyMessageDelayed(600, i);
        }
    }

    public void wp() {
        v.z().z(this.gc, "stats_reward_full_completed", this.oq.z(new JSONObject()));
        if (this.kb.getAndSet(true)) {
            return;
        }
        a("onVideoComplete");
    }

    public void i() {
        if (this.uy.getAndSet(true)) {
            return;
        }
        a("onVideoError");
    }

    public void v() {
        if (this.kb.get() || this.fo.getAndSet(true)) {
            return;
        }
        a("onSkippedVideo");
    }

    public void pf() {
        this.g.removeMessages(700);
        this.g.removeMessages(600);
    }

    public void z(long j) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 700;
        this.g.sendMessageDelayed(messageObtain, j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gz.g
    public void z(boolean z) {
        if (z) {
            if (this.gk.m()) {
                return;
            }
            this.wj.a(true);
            return;
        }
        if (this.gk.m() && this.ti.ti() != null) {
            this.ti.ti().z(8);
        }
        this.wj.a(false);
        if (this.gk.m() || this.nh == 2 || !com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.gc)) {
            return;
        }
        this.h.m(8);
    }

    protected void g(boolean z) {
        Message message = new Message();
        message.what = MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL;
        this.g.sendMessageDelayed(message, z ? ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS : 0L);
    }

    protected void ls() {
        this.g.removeMessages(MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL);
    }

    private void tf() {
        if (this.mc.mc() || !this.zw || sv() || !this.wj.f() || this.ti.na()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.a.z zVar = this.wj;
        if ((zVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.a.dl) || (zVar instanceof kb)) {
            return;
        }
        this.g.removeMessages(300);
        this.g.sendEmptyMessageDelayed(300, 5000L);
    }

    public int gc(int i) {
        boolean z = i == 2;
        boolean zSv = this.wj.sv();
        int i2 = 4;
        switch (this.gc.d()) {
            case 1:
                i2 = 1;
                break;
            case 2:
            default:
                i2 = 2;
                break;
            case 3:
                i2 = !z ? 2 : 1;
                break;
            case 4:
            case 5:
                i2 = !z ? 3 : 1;
                break;
            case 6:
                if (z) {
                    i2 = 1;
                }
                break;
            case 7:
                i2 = (!z || !this.v.get()) ? 2 : 1;
                break;
            case 8:
            case 9:
                if (!ja()) {
                    i2 = !z ? 2 : 1;
                } else {
                    int iWn = wn();
                    if (z) {
                        i2 = 1;
                    } else if (iWn > 0) {
                        i2 = 2;
                    }
                }
                break;
        }
        if (i2 == 2 && !zSv) {
            i2 = 1;
        }
        return ((this.wj instanceof com.bytedance.sdk.openadsdk.core.component.reward.a.m) && com.bytedance.sdk.openadsdk.hh.uy.z(this.gc)) ? z ? 1 : 3 : i2;
    }

    public void m(int i) {
        int iGc = gc(i);
        if (i != 2) {
            if (this.eo.a()) {
                return;
            }
            if (this.ti.wp()) {
                this.ti.uy();
                return;
            }
            if (gb.p(this.gc)) {
                if (this.wp.get() && !this.i.get()) {
                    if (iGc == 1 && !this.f930a.containsKey(0) && sy()) {
                        this.lq.g((this.gc.lt() == 3 && gb.fv(this.gc)) ? "奖励就快来了\n去详情页看看也累计时长哦～" : "奖励还在路上狂奔\n再等一下下哦～");
                    }
                    this.ti.xl();
                }
                if (!this.wp.get() && this.i.get() && (!ja() || i == 3)) {
                    return;
                }
                if (iGc == 1 && (!this.wp.get() || !this.i.get())) {
                    return;
                }
            }
        }
        if (iGc == 1) {
            g();
            return;
        }
        if (iGc == 2) {
            if (this.gz.get()) {
                this.mc.q();
            }
            gc();
        } else if (iGc == 3) {
            this.ti.xl();
        } else if (iGc == 4 && i != 3) {
            p();
        }
    }

    protected void p() {
        if (!ja()) {
            fv();
        }
        this.ti.uy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ja() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVarOq = ec().oq();
        if (dlVarOq instanceof com.bytedance.sdk.openadsdk.core.video.g.z) {
            return ((com.bytedance.sdk.openadsdk.core.video.g.z) dlVarOq).mc();
        }
        return false;
    }

    public void fv() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.gc gcVar = this.gk;
        if (gcVar != null) {
            gcVar.z("videoLoopBegin", (JSONObject) null);
        }
    }

    private int wn() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVarOq = ec().oq();
        if (dlVarOq instanceof com.bytedance.sdk.openadsdk.core.video.g.z) {
            return ((com.bytedance.sdk.openadsdk.core.video.g.z) dlVarOq).y();
        }
        return 0;
    }

    protected void z(boolean z, boolean z2) {
        this.ti.g(z2);
        i();
        if (z) {
            this.pf.set(true);
            if (gb.p(this.gc)) {
                this.wj.l();
            }
            this.lq.z(false, null, null, true, true);
            gc();
            return;
        }
        if (gb.q(this.gc)) {
            this.mc.eo();
        } else {
            this.lq.z(false, null, null, true, true);
            a(0);
        }
        if (this.ti.na()) {
            return;
        }
        if (gb.p(this.gc)) {
            this.wj.l();
        }
        gc();
    }

    public void js() {
        gc();
    }

    public void tb() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.gc gcVar;
        if (this.bv == null || (gcVar = this.gk) == null || gcVar.wp() == null) {
            return;
        }
        this.gk.wp().setEasyPlayableSender(this.bv.z());
        this.bv.z(mc().getEasyPlayableContainer(), null);
    }

    public void e(int i) {
        this.l.z(i);
    }

    protected boolean q() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar = this.vm;
        if (zVar != null) {
            return zVar.dl();
        }
        return false;
    }

    public void dl(String str) {
        if (isFinishing()) {
            return;
        }
        if (this.vm == null) {
            this.vm = new com.bytedance.sdk.openadsdk.core.dislike.ui.z(this.na, this.gc.ct(), this.z, true);
            com.bytedance.sdk.openadsdk.core.dislike.dl.z(this.na, this.gc, this.vm);
            this.vm.z(new z.InterfaceC0168z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.10
                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
                public void z() {
                    TTBaseVideoActivity.this.na();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
                public void z(int i, String str2, boolean z) {
                    TTBaseVideoActivity.this.g.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TTBaseVideoActivity.this.xl();
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
                public void g() {
                    TTBaseVideoActivity.this.xl();
                }
            });
        }
        this.vm.z(str);
        this.vm.z();
    }

    public void iq() {
        this.lq.z(1);
        if (!gb.p(this.gc)) {
            this.lq.z(false, null, null, true, true);
        }
        this.lq.z(true);
        this.lq.gc(true);
        this.lq.m(false);
        this.lq.g(this.gc.sz());
        this.eo.z(this.iq, this.f930a.containsKey(0));
        this.g.sendEmptyMessage(1200);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", 1);
            this.gk.z("playableStateChange", jSONObject);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public void zw() {
        this.eo.dl();
        this.mc.un();
        this.lq.z(1);
        this.g.removeMessages(1200);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", 0);
            if (sy()) {
                jSONObject.put("reduce_duration", this.wj.t());
            }
            this.gk.z("playableStateChange", jSONObject);
        } catch (Exception e) {
            wp.z(e);
        }
        if (!this.f.z(1)) {
            this.ls.set(true);
        }
        z(1, (com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.a) null);
    }

    protected boolean io() {
        return zz() || q() || this.wj.gk();
    }

    public void z(int i, com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.a aVar) {
        if (iq.dl(this.gc) || this.v.get() || this.uy.get()) {
            return;
        }
        int iUy = 0;
        if (i == 1) {
            if (!this.ls.get()) {
                return;
            }
            if (aVar == null || !aVar.z) {
                this.ls.set(false);
            }
        }
        int iZ = this.f.z(i, aVar != null && aVar.f934a);
        if (iZ == 0) {
            return;
        }
        if (iZ == 3 && aVar != null && aVar.dl) {
            iUy = x.uy();
        }
        this.f.z(new dl.z().z(this.gp).z(this.wj.ti()).g(iUy).z(this.kb.get()).z(this.f930a.keySet()).g(this.iq).z(this.yx).dl(iZ).a(this.wj.sy()).dl(this.f.a() ? this.zx : na.g(this.gc)).z(), iZ, aVar);
    }

    public boolean uf() {
        if (io() || this.ti.na()) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.a.z zVar = this.wj;
        if ((zVar != null && !zVar.f()) || this.eo.a() || this.mc.mc()) {
            return false;
        }
        if (this.ti.zw()) {
            if ((!this.ti.dl() && !this.ti.g()) || this.ti.g()) {
                return false;
            }
            this.ti.dl();
        }
        return true;
    }

    private void nb() {
        final View decorView;
        try {
            decorView = getWindow().getDecorView();
        } catch (Throwable unused) {
            decorView = null;
        }
        if (decorView == null) {
            return;
        }
        decorView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    decorView.findViewById(R.id.statusBarBackground).setVisibility(8);
                } catch (Exception unused2) {
                }
            }
        });
        decorView.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    decorView.findViewById(R.id.statusBarBackground).setVisibility(8);
                } catch (Exception unused2) {
                }
            }
        }, 300L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gz.g
    public void z(int i) {
        this.tb.set(true);
        if (System.currentTimeMillis() - this.ja > 50) {
            this.ja = System.currentTimeMillis();
            a("onAdVideoBarClick");
        }
        if (!isFinishing()) {
            e.z(this.gk.wp());
        }
        if (!this.e.get()) {
            this.e.set(true);
        }
        if (!this.f.z(1)) {
            this.ls.set(true);
        }
        dl(0);
        fo(i);
    }

    public void fo(int i) {
        com.bytedance.sdk.openadsdk.core.video.g.g gVarMc;
        com.bytedance.sdk.openadsdk.core.component.reward.a.z zVar = this.wj;
        if (!(zVar instanceof fo) || (gVarMc = zVar.mc()) == null) {
            return;
        }
        if (gVarMc.kb() == 1 && i == 1 && this.vo.getAndSet(false)) {
            int iGz = oq.gz(com.bytedance.sdk.openadsdk.core.zw.getContext());
            float fM = oq.m(com.bytedance.sdk.openadsdk.core.zw.getContext());
            float fE = oq.e(com.bytedance.sdk.openadsdk.core.zw.getContext());
            Map<String, Object> mapJ = j();
            mapJ.putAll(gVarMc.e());
            com.bytedance.sdk.openadsdk.core.i.a.z("click", this.gc, new fo.z().m(-1.0f).gc(-1.0f).a(-1.0f).dl(-1.0f).g(-1L).z(-1L).dl(-1).a(-1).gc(-1024).g(com.bytedance.sdk.openadsdk.core.uy.ls().dl() ? 1 : 2).z(iGz).z(fM).g(fE).z(), this.z, true, mapJ, -1, false);
        }
    }

    public void g(boolean z, boolean z2) {
        Integer numValueOf;
        int iValueOf = 1;
        if (z) {
            Map<String, Object> mapGz = gz();
            this.qd.set(true);
            try {
                String strAq = this.gc.aq();
                Integer numRemove = com.bytedance.sdk.openadsdk.core.gz.a.gc.remove(strAq);
                if (numRemove == null) {
                    numValueOf = 1;
                } else {
                    numValueOf = Integer.valueOf(numRemove.intValue() + 1);
                }
                com.bytedance.sdk.openadsdk.core.gz.a.gc.put(strAq, numValueOf);
                mapGz.put("meta_show_count", numValueOf);
                String strUy = eo.uy(this.gc);
                Integer numRemove2 = com.bytedance.sdk.openadsdk.core.gz.a.m.remove(strUy);
                if (numRemove2 != null) {
                    iValueOf = Integer.valueOf(numRemove2.intValue() + 1);
                }
                com.bytedance.sdk.openadsdk.core.gz.a.m.put(strUy, iValueOf);
                mapGz.put("meta_origin_show_count", iValueOf);
            } catch (Throwable unused) {
            }
            mapGz.put("cache_strategy", Integer.valueOf(com.bytedance.sdk.openadsdk.core.component.reward.z.gc.z(sy())));
            mapGz.put("is_adm", Boolean.valueOf(this.sy));
            mapGz.put("is_play_again", Boolean.valueOf(l()));
            mapGz.put("if_cache_callback", Integer.valueOf(this.hh == 1 ? 1 : 0));
            mapGz.put("src_req_id", this.gc.ux());
            mapGz.put("is_map", Boolean.valueOf(this.gc.gd()));
            mapGz.put("is_repeat", Boolean.valueOf(this.js.getAndSet(true)));
            com.bytedance.sdk.openadsdk.core.i.a.z(this.gc, this.z, mapGz, this.bm);
            com.bytedance.sdk.openadsdk.core.l.z.z().a();
            un.z(this.gc.gc());
        }
        if (z2) {
            if (!x.g(sy(), this.gc, true)) {
                boolean zPd = com.bytedance.sdk.openadsdk.core.zw.g().pd();
                if (!this.fv.getAndSet(true) || zPd) {
                    a("onAdShow");
                } else {
                    v.z().dl(this.gc, "stats_callback_repeat");
                }
            }
            if (this.wj.m()) {
                this.gk.e();
            }
            a aVar = this.bv;
            if (aVar != null && aVar.z() != null) {
                this.bv.z().a();
            }
        }
        dl(false);
    }

    private boolean zz() {
        g.z zVar = this.sd;
        return zVar != null && zVar.a();
    }

    public boolean g(long j, boolean z) {
        this.ti.z(this.ec);
        this.ti.z(this.wj.fv(), this.z, sy());
        this.ti.g(gz());
        if (this.wj.m()) {
            this.gk.z(this.ti.oq());
        }
        this.ti.z(this.jq);
        boolean z2 = z(j, z);
        if (z2 && !z) {
            this.y = (int) (System.currentTimeMillis() / 1000);
        }
        return z2;
    }

    public RewardFullBaseLayout mc() {
        return this.l;
    }

    protected void z(Intent intent) {
        if (intent != null) {
            this.t = intent.getStringExtra("rit_scene");
            this.io = intent.getBooleanExtra("is_preload", false);
            this.uf = intent.getLongExtra("object_create_ts", 0L);
            this.sy = intent.getBooleanExtra("is_adm", false);
            this.gp = intent.getStringExtra("multi_process_key");
            this.hh = intent.getIntExtra("key_video_cache_callback", -1);
            String stringExtra = intent.getStringExtra("_client_bidding_aution_price");
            this.bm = TextUtils.isEmpty(stringExtra) ? null : Double.valueOf(Double.parseDouble(stringExtra));
        }
    }

    protected void g(Bundle bundle) {
        if (bundle != null) {
            this.gp = bundle.getString("multi_process_key");
            this.io = bundle.getBoolean("is_preload");
            this.uf = bundle.getLong("object_create_ts");
            this.sy = bundle.getBoolean("is_adm");
            this.hh = bundle.getInt("key_video_cache_callback", -1);
            this.t = bundle.getString("rit_scene");
            String string = bundle.getString("_client_bidding_aution_price");
            this.bm = TextUtils.isEmpty(string) ? null : Double.valueOf(Double.parseDouble(string));
            this.iq = bundle.getBoolean("is_mute");
            long j = bundle.getLong("video_current");
            if (j > 0) {
                this.ti.z(j);
            }
        }
    }

    protected void g(Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getStringExtra("insert_ad_bundle"))) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.dl dlVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.dl(intent.getStringExtra("insert_ad_bundle"));
        this.gp = dlVar.z();
        if (x.z(this.gc) == 1) {
            this.b = dlVar.uy();
        }
        this.zx = dlVar.kb();
        this.kb.set(dlVar.a());
        this.f930a.putAll(dlVar.gz());
        this.f.z(dlVar);
        this.iq = dlVar.gc();
        this.yx.dl(dlVar.m());
    }

    public void un() {
        boolean z = !this.iq;
        this.iq = z;
        this.wj.gc(z);
    }

    public void ti() {
        this.eo.g();
    }

    public l eo() {
        return this.g;
    }

    public void z(int i, boolean z) {
        kb(i);
        if (z) {
            uy(i);
        }
    }

    public void uy(int i) {
        if (this.gk != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", i);
            } catch (JSONException e) {
                wp.z(e);
            }
            this.gk.z("reduceTime", jSONObject);
        }
    }

    public void kb(int i) {
        this.wj.dl(i);
        dl(0);
    }

    public int oq() {
        return Math.max(this.wj.vm() - (((int) (this.ti.gk() / 1000)) + this.wj.t()), 0);
    }

    public void wp(int i) {
        this.h.gc(i);
    }

    public void wj() {
        this.g.removeMessages(600);
    }

    public void z(float f, float f2, float f3, float f4, int i) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.gc gcVar = this.gk;
        if (gcVar == null || gcVar.z() == null) {
            return;
        }
        int measuredWidth = this.gk.z().getMeasuredWidth();
        int measuredHeight = this.gk.z().getMeasuredHeight();
        if (this.ti.oq() instanceof com.bytedance.sdk.openadsdk.core.video.g.z ? ((com.bytedance.sdk.openadsdk.core.video.g.z) this.ti.oq()).gb() : false) {
            this.gk.z().animate().translationY(-(measuredHeight * (1.0f - f2))).setDuration(i).start();
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f2, measuredWidth * f3, measuredHeight * f4);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(i);
        this.gk.z().startAnimation(scaleAnimation);
    }

    public void i(int i) {
        com.bytedance.sdk.openadsdk.core.component.reward.a.z zVar;
        if (this.ti.g()) {
            HashMap map = new HashMap();
            map.put("pause_from", Integer.valueOf(i));
            this.ti.z(map);
        }
        this.g.removeMessages(300);
        this.g.removeMessages(1200);
        pf(i);
        if ((sv() && gb.p(this.gc) && this.eo.a()) || (zVar = this.wj) == null) {
            return;
        }
        zVar.q();
        this.mc.g(sv());
    }

    public void na() {
        i(0);
    }

    public void xl() {
        v(0);
    }

    public void v(int i) {
        ls(i);
        if (this.wj instanceof com.bytedance.sdk.openadsdk.core.component.reward.a.fo) {
            this.g.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.14
                @Override // java.lang.Runnable
                public void run() {
                    TTBaseVideoActivity.this.vo();
                }
            }, 500L);
        } else {
            vo();
        }
        if (io()) {
            return;
        }
        if (this.mc.h()) {
            this.g.sendEmptyMessageDelayed(1200, 1000L);
        }
        if (!sv() || this.mc.mc() || this.mc.h()) {
            this.wj.iq();
        }
        this.mc.dl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vo() {
        if (uf()) {
            tf();
            this.ti.z(false, this);
        }
    }

    public Map<String, Object> j() {
        return z(this.gc);
    }

    public Map<String, Object> z(na naVar) {
        HashMap map = new HashMap();
        String str = this.t;
        if (str != null) {
            map.put("rit_scene", str);
        }
        map.put("insert_ad_control", Integer.valueOf(x.z(naVar)));
        map.put("carousel_pos", Integer.valueOf(x.a(naVar)));
        map.put("refresh_ad_control", Integer.valueOf(x.g(naVar)));
        if (this.f.g() != 0) {
            map.put("carousel_type", Integer.valueOf(this.f.g()));
        } else if (y.gz(naVar)) {
            map.put("carousel_type", 4);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.g.dl dlVar = this.oq;
        if (dlVar != null) {
            dlVar.z(map);
        }
        return map;
    }

    public Double gp() {
        return this.bm;
    }

    public void z(na naVar, com.bytedance.sdk.openadsdk.core.g.g gVar) {
        this.mc.z(naVar, gVar);
        this.eo.z(naVar);
    }

    private void lk() {
        this.wp.set(true);
    }

    public void vm() {
        if (this.i.getAndSet(true)) {
            return;
        }
        m(3);
    }

    public boolean y() {
        return this.eo.a() || this.mc.mc();
    }

    public m ec() {
        return this.ti;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.g.dl bv() {
        return this.oq;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.a.z gb() {
        return this.wj;
    }

    public boolean jq() {
        return this.f930a.containsKey(0);
    }

    public boolean sv() {
        com.bytedance.sdk.openadsdk.core.component.reward.a.z zVar = this.wj;
        return (zVar != null && zVar.tc()) || !this.m.isEmpty();
    }

    public void pf(int i) {
        if (i == 0) {
            return;
        }
        this.m.put(Integer.valueOf(i), Boolean.TRUE);
    }

    public void ls(int i) {
        if (i == 0) {
            return;
        }
        this.m.remove(Integer.valueOf(i));
    }

    public void f() {
        this.lq.m();
    }

    public void yx() {
        this.tb.set(true);
    }

    public void qd() {
        this.f.dl();
    }

    public void zx() {
        if (ja()) {
            u();
            return;
        }
        if (!this.ti.un() && !this.ti.wp()) {
            sf();
        }
        m(1);
    }

    private void u() {
        if (this.ti.lq().jq()) {
            if (this.gc.d() == 9 && this.ti.un()) {
                this.gk.g(true);
                this.ti.wj();
            } else {
                this.gk.g(false);
            }
            m(1);
            return;
        }
        this.gk.g(true);
        if (this.ti.lq().y() < 2) {
            sf();
        }
        if (this.gc.d() == 8) {
            m(1);
        } else {
            fv();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void sf() {
        /*
            r7 = this;
            com.bytedance.sdk.openadsdk.core.iq.na r0 = r7.gc
            boolean r0 = com.bytedance.sdk.openadsdk.core.iq.js.a(r0)
            if (r0 == 0) goto Le
            com.bytedance.sdk.openadsdk.core.component.reward.g.m r0 = r7.ti
            r0.xl()
            return
        Le:
            r7.wp()
            com.bytedance.sdk.openadsdk.core.iq.na r0 = r7.gc
            boolean r0 = com.bytedance.sdk.openadsdk.core.iq.gb.p(r0)
            if (r0 != 0) goto L3c
            com.bytedance.sdk.openadsdk.core.component.reward.g.m r0 = r7.ec()
            com.bykv.vk.openvk.component.video.api.a.dl r0 = r0.oq()
            boolean r1 = r0 instanceof com.bytedance.sdk.openadsdk.core.video.z.z
            if (r1 == 0) goto L2d
            com.bytedance.sdk.openadsdk.core.video.z.z r0 = (com.bytedance.sdk.openadsdk.core.video.z.z) r0
            boolean r0 = r0.mc()
            if (r0 != 0) goto L3c
        L2d:
            r0 = 0
            r7.dl(r0)
            com.bytedance.sdk.openadsdk.core.component.reward.g.gc r1 = r7.lq
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 1
            r6 = 1
            r1.z(r2, r3, r4, r5, r6)
            goto L3f
        L3c:
            r7.lk()
        L3f:
            com.bytedance.sdk.openadsdk.core.iq.na r0 = r7.gc
            boolean r0 = com.bytedance.sdk.openadsdk.core.iq.gb.e(r0)
            if (r0 == 0) goto L5c
            com.bytedance.sdk.openadsdk.core.component.reward.g.m r0 = r7.ti
            long r0 = r0.q()
            com.bytedance.sdk.openadsdk.core.iq.na r2 = r7.gc
            int r2 = com.bytedance.sdk.openadsdk.core.iq.gb.uy(r2)
            long r2 = (long) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L5c
            r0 = 2
            r7.dl(r0)
        L5c:
            com.bytedance.sdk.openadsdk.core.component.reward.a.z r0 = r7.wj
            r0.lq()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.sf():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yw() {
        return (this.gc.ou() == 180 && gb.p(this.gc) && com.bytedance.sdk.openadsdk.hh.uy.z(this.gc) && this.gk.fo() == 7) ? false : true;
    }

    public void z(int i, int i2) {
        this.f.z(i, i2, 0);
    }

    public void z(int i, int i2, int i3) {
        this.f.z(i, i2, i3);
    }

    public void b() {
        this.f.g(false);
    }

    public void lw() {
        this.wj.ec();
    }

    public void rv() {
        this.f.z(this.l);
    }
}
