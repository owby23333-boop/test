package com.bytedance.sdk.openadsdk.core.component.reward.business.g;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.hh;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.core.component.reward.business.g.z;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.uy;
import com.bytedance.sdk.openadsdk.core.component.reward.z.gz;
import com.bytedance.sdk.openadsdk.core.i.a;
import com.bytedance.sdk.openadsdk.core.iq.gp;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.ls.dl.g.pf;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements z {
    private com.bytedance.sdk.openadsdk.core.component.reward.business.g.z.z g;
    private boolean gz;
    private int m;
    private final z.InterfaceC0151z z;
    private final AtomicBoolean dl = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f932a = new AtomicBoolean(false);
    private final AtomicBoolean gc = new AtomicBoolean(false);
    private int e = 0;
    private boolean fo = true;
    private String uy = "";
    private String kb = "";
    private String wp = "";
    private String i = "";
    private String v = "";

    public g(z.InterfaceC0151z interfaceC0151z) {
        this.z = interfaceC0151z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z
    public void z(boolean z) {
        this.gc.set(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z
    public void z(int i) {
        this.e = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z
    public void g(boolean z) {
        this.gz = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z
    public void g(int i) {
        this.m = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z
    public boolean z() {
        return this.gc.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z
    public boolean dl(int i) {
        z.InterfaceC0151z interfaceC0151z = this.z;
        if (interfaceC0151z == null || interfaceC0151z.getActivity() == null || this.z.z() == null || this.dl.get() || !this.fo) {
            return false;
        }
        if (i == 1) {
            z.InterfaceC0151z interfaceC0151z2 = this.z;
            interfaceC0151z2.z(0, z(interfaceC0151z2.getActivity()));
            fo();
            a.z(this.z.z(), "reward_endcard", "reward_again", "endcard");
        } else {
            if (i == 2) {
                return uy();
            }
            if (i == 3) {
                z.InterfaceC0151z interfaceC0151z3 = this.z;
                interfaceC0151z3.z(0, z(interfaceC0151z3.getActivity()));
                fo();
                a.z(this.z.z(), "reward_endcard", "reward_again", "videoplaying");
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z
    public boolean g() {
        return this.f932a.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z
    public void dl() {
        com.bytedance.sdk.openadsdk.core.component.reward.business.g.z.z zVar = this.g;
        if (zVar != null) {
            zVar.dl();
        }
        kb();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z
    public void a() {
        z.InterfaceC0151z interfaceC0151z = this.z;
        if (interfaceC0151z == null || interfaceC0151z.getActivity() == null || this.z.z() == null || !gp.z(this.z.z())) {
            return;
        }
        if (!this.gz) {
            boolean z = this.e == 0;
            this.z.z(z, null, null);
            this.fo = z;
        } else {
            this.fo = false;
            this.z.z(false, this.uy, this.kb);
            final int i = this.e + 1;
            e.g(new fo("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.g.g.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ls lsVarZ = com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z.z(com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z(zw.getContext()).z(5));
                        Bundle bundle = new Bundle();
                        bundle.putInt("callback_extra_key_next_play_again_count", i);
                        g.this.z(lsVarZ.g(gp.g(g.this.z.g()), "getPlayAgainCondition", bundle));
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z
    public boolean gc() {
        com.bytedance.sdk.openadsdk.core.component.reward.business.g.z.z zVar = this.g;
        if (zVar == null) {
            return false;
        }
        return zVar.g();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z
    public void z(String str) {
        this.wp = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z
    public void g(String str) {
        this.i = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z
    public String e() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z
    public String m() {
        return this.wp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Bundle bundle) {
        boolean z = bundle.getBoolean(TTRewardVideoAd.RewardAdPlayAgainController.KEY_PLAY_AGAIN_ALLOW);
        this.uy = bundle.getString(TTRewardVideoAd.RewardAdPlayAgainController.KEY_PLAY_AGAIN_REWARD_NAME);
        this.kb = bundle.getString(TTRewardVideoAd.RewardAdPlayAgainController.KEY_PLAY_AGAIN_REWARD_AMOUNT);
        this.v = bundle.getString("extra_info");
        this.fo = z;
        if (z) {
            com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.g.g.2
                @Override // java.lang.Runnable
                public void run() {
                    g.this.z.z(true, g.this.uy, g.this.kb);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fo() {
        try {
            this.dl.set(true);
            String strA = gp.a(this.z.z());
            if (TextUtils.isEmpty(strA)) {
                strA = String.valueOf(this.m);
            }
            if (TextUtils.isEmpty(strA)) {
                strA = String.valueOf(eo.fo(this.z.z()));
            }
            gz.z().z(com.bytedance.sdk.openadsdk.core.component.reward.z.z.z.z().z(strA), gp.dl(this.z.z()), this.e, new com.bytedance.sdk.openadsdk.core.component.reward.z.a(new com.bytedance.sdk.openadsdk.tb.z.g.z.e(null) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.g.g.3
                @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.e
                public void g(pf pfVar) {
                }

                @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.e
                public void z() {
                }

                @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.e
                public void z(int i, String str) {
                    com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.g.g.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.a("当前无新视频，请点击重试");
                            g.this.dl.set(false);
                            if (g.this.g != null) {
                                g.this.g.gc();
                            }
                            g.this.z.z(8, null);
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.e
                public void z(final pf pfVar) {
                    com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.g.g.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            pf pfVar2 = pfVar;
                            if (!(pfVar2 instanceof com.bytedance.sdk.openadsdk.core.component.reward.dl)) {
                                g.this.a("当前无新视频，请点击重试");
                                g.this.dl.set(false);
                            } else {
                                com.bytedance.sdk.openadsdk.core.component.reward.dl dlVar = (com.bytedance.sdk.openadsdk.core.component.reward.dl) pfVar2;
                                dlVar.z(true);
                                dlVar.z(g.this.m);
                                dlVar.g(g.this.e + 1);
                                dlVar.dl(g.this.z.g());
                                if (!TextUtils.isEmpty(g.this.uy) && !TextUtils.isEmpty(g.this.kb)) {
                                    dlVar.g(g.this.kb);
                                    dlVar.z(g.this.uy);
                                }
                                dlVar.g(g.this.gz);
                                dlVar.z(g.this.z.getActivity());
                                g.this.z.gc();
                                g.this.f932a.set(true);
                            }
                            g.this.z.z(8, null);
                        }
                    });
                }
            }));
        } catch (Throwable unused) {
            this.dl.set(false);
            a("当前无新视频，请退出后重试");
        }
    }

    private boolean uy() {
        if (!gp.g(this.z.z())) {
            return false;
        }
        if (this.dl.get()) {
            return true;
        }
        uy uyVar = new uy() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.g.g.4
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void z() {
                if (g.this.dl.get()) {
                    return;
                }
                if (g.this.g != null) {
                    g.this.g.a();
                }
                g.this.fo();
                a.z(g.this.z.z(), "reward_endcard", "reward_again", "popup");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void g() {
                if (g.this.dl.get()) {
                    return;
                }
                a.z(g.this.z.z(), "reward_endcard", "popup_cancel", (String) null);
                g.this.z.dl();
            }
        };
        com.bytedance.sdk.openadsdk.core.component.reward.business.g.z.g gVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.g.z.g(this.z.getActivity(), this.z.z());
        this.g = gVar;
        gVar.a(this.uy);
        this.g.dl(this.kb);
        this.g.z(this.v);
        this.z.a();
        return this.g.z(uyVar).dl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        z.InterfaceC0151z interfaceC0151z = this.z;
        if (interfaceC0151z == null || interfaceC0151z.getActivity() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.g.g.5
            @Override // java.lang.Runnable
            public void run() {
                hh.z(g.this.z.getActivity(), str, 0);
            }
        });
    }

    private TTProgressBar z(Context context) {
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(240, 240);
        layoutParams.gravity = 17;
        tTProgressBar.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#77000000"));
        gradientDrawable.setCornerRadius(oq.dl(context, 2.0f));
        tTProgressBar.setBackground(gradientDrawable);
        int iDl = oq.dl(context, 10.0f);
        tTProgressBar.setPadding(iDl, iDl, iDl, iDl);
        tTProgressBar.setIndeterminateDrawable(tb.dl(context, "tt_video_loading_progress_bar"));
        return tTProgressBar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z
    public String gz() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isPlayAgain", this.gc.get());
            jSONObject.put("mSourceRitId", this.m);
            jSONObject.put("mNowPlayAgainCount", this.e);
            jSONObject.put("isCustomPlayAgain", this.gz);
            jSONObject.put("isCanPlayAgain", this.fo);
            jSONObject.put("mPlayAgainRewardName", this.uy);
            jSONObject.put("mPlayAgainRewardAmount", this.kb);
            jSONObject.put("mLastRewardName", this.wp);
            jSONObject.put("mLastRewardAmount", this.i);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z
    public void dl(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.gc.set(jSONObject.getBoolean("isPlayAgain"));
            this.m = jSONObject.optInt("mSourceRitId");
            this.e = jSONObject.optInt("mNowPlayAgainCount");
            this.gz = jSONObject.optBoolean("isCustomPlayAgain");
            this.fo = jSONObject.optBoolean("isCanPlayAgain");
            this.uy = jSONObject.optString("mPlayAgainRewardName");
            this.kb = jSONObject.optString("mPlayAgainRewardAmount");
            this.wp = jSONObject.optString("mLastRewardName");
            this.kb = jSONObject.optString("mPlayAgainRewardAmount");
        } catch (Exception unused) {
        }
    }

    private void kb() {
        e.g(new fo("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.g.g.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z.z(com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z(zw.getContext()).z(5)).g(gp.g(g.this.z.g()), "recycleRes", null);
                } catch (Throwable unused) {
                }
            }
        }, 5);
    }
}
