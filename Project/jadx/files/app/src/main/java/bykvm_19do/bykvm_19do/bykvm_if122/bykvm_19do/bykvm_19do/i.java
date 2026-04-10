package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.banner.GMNativeToBannerListener;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.core.views.RefreshableBannerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class i {
    private int a;
    private final Activity b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f1375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AdSlot f1376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private GMAdSlotBase f1377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d f1378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d f1379g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private RefreshableBannerView f1380h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Handler f1381i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Handler f1382j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private GMBannerAdListener f1383k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private GMNativeToBannerListener f1384l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f1385m = new a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final GMBannerAdListener f1386n = new b();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Runnable f1387o = new c();

    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (i.this.a == 0) {
                return;
            }
            i.this.s();
            i.this.t();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            i.this.r();
        }
    }

    class b implements GMBannerAdListener {
        b() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdClicked() {
            if (i.this.f1383k != null) {
                i.this.f1383k.onAdClicked();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdClosed() {
            i.this.r();
            if (i.this.f1383k != null) {
                i.this.f1383k.onAdClosed();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdLeftApplication() {
            if (i.this.f1383k != null) {
                i.this.f1383k.onAdLeftApplication();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdOpened() {
            if (i.this.f1383k != null) {
                i.this.f1383k.onAdOpened();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdShow() {
            if (i.this.f1383k != null) {
                i.this.f1383k.onAdShow();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdShowFail(AdError adError) {
            if (i.this.f1383k != null) {
                i.this.f1383k.onAdShowFail(adError);
            }
        }
    }

    class c implements Runnable {

        class a implements Runnable {

            /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.i$c$a$a, reason: collision with other inner class name */
            class RunnableC0038a implements Runnable {
                RunnableC0038a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f1378f != null) {
                        i.this.f1378f.B();
                    }
                    i iVar = i.this;
                    iVar.f1378f = iVar.f1379g;
                    i.this.s();
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i.this.a == 0 || i.this.f1379g == null) {
                    return;
                }
                View viewE0 = i.this.f1379g.e0();
                if (viewE0 != null) {
                    if (i.this.f1380h != null) {
                        i.this.f1380h.a(viewE0);
                    }
                    i.this.f1382j.postDelayed(new RunnableC0038a(), 250L);
                } else {
                    if (i.this.f1379g != null) {
                        i.this.f1379g.B();
                    }
                    i.this.s();
                }
                i.this.t();
            }
        }

        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.f1382j.post(new a());
        }
    }

    class d implements RefreshableBannerView.c {
        d() {
        }

        @Override // com.bytedance.msdk.core.views.RefreshableBannerView.c
        public void a(boolean z2) {
            if (!z2) {
                i.this.r();
            } else {
                if (i.this.a == 0) {
                    return;
                }
                i.this.t();
            }
        }
    }

    public i(Activity activity, String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVarC;
        String str2;
        this.a = 0;
        this.b = activity;
        this.f1375c = str;
        this.f1378f = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d(activity, str);
        if (activity != null) {
            this.f1380h = new RefreshableBannerView(activity);
            this.f1380h.addOnAttachStateChangeListener(this.f1385m);
            this.f1380h.setVisibilityChangeListener(new d());
        }
        this.f1381i = new Handler(ThreadHelper.getMSDKThreadLooper());
        this.f1382j = new Handler(Looper.getMainLooper());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d dVarF = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f();
        if (dVarF == null || (cVarC = dVarF.c(this.f1375c)) == null) {
            return;
        }
        int iN = cVarC.n();
        if (iN < 10000 || iN > 180000) {
            str2 = "---==-----banner轮播时间下发不在10*1000～180*1000范围内：" + iN + "，禁止banner轮播";
        } else {
            this.a = iN;
            str2 = "---==-----banner轮播时间：" + this.a;
        }
        Logger.d("TMe", str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.f1381i.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.f1379g = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d(this.b, this.f1375c);
        this.f1379g.a(this.f1386n);
        this.f1379g.a(this.f1384l);
        this.f1379g.a(this.f1376d, this.f1377e, (GMBannerAdLoadCallback) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.f1381i.removeCallbacksAndMessages(null);
        this.f1381i.postDelayed(this.f1387o, this.a);
    }

    public void a() {
        this.f1382j.removeCallbacksAndMessages(null);
        r();
        RefreshableBannerView refreshableBannerView = this.f1380h;
        if (refreshableBannerView != null) {
            refreshableBannerView.removeOnAttachStateChangeListener(this.f1385m);
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        if (dVar != null) {
            dVar.B();
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar2 = this.f1379g;
        if (dVar2 != null) {
            dVar2.B();
        }
    }

    public void a(AdSlot adSlot, GMAdSlotBase gMAdSlotBase, GMBannerAdLoadCallback gMBannerAdLoadCallback) {
        this.f1376d = adSlot;
        this.f1377e = gMAdSlotBase;
        this.f1378f.a(adSlot, gMAdSlotBase, gMBannerAdLoadCallback);
    }

    public void a(GMBannerAdListener gMBannerAdListener) {
        this.f1383k = gMBannerAdListener;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        if (dVar != null) {
            dVar.a(this.f1386n);
        }
    }

    public void a(GMNativeToBannerListener gMNativeToBannerListener) {
        this.f1384l = gMNativeToBannerListener;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        if (dVar != null) {
            dVar.a(this.f1384l);
        }
    }

    public void a(boolean z2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        if (dVar != null) {
            dVar.a(z2);
        }
    }

    public List<AdLoadInfo> b() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        return dVar != null ? dVar.C() : new ArrayList();
    }

    public int c() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        if (dVar != null) {
            return dVar.E();
        }
        return -2;
    }

    @NonNull
    public String d() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        if (dVar != null) {
            return dVar.F();
        }
        return null;
    }

    @Nullable
    public View e() {
        RefreshableBannerView refreshableBannerView;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        if (dVar == null) {
            return null;
        }
        dVar.b((TTBaseAd) null);
        View viewE0 = this.f1378f.e0();
        if (viewE0 == null || (refreshableBannerView = this.f1380h) == null) {
            return null;
        }
        refreshableBannerView.removeAllViews();
        ViewParent parent = viewE0.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(viewE0);
        }
        this.f1380h.addView(viewE0);
        return this.f1380h;
    }

    public GMAdEcpmInfo f() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public List<GMAdEcpmInfo> g() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public Map<String, Object> h() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        return dVar != null ? dVar.G() : new HashMap();
    }

    public List<GMAdEcpmInfo> i() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        if (dVar != null) {
            return dVar.f();
        }
        return null;
    }

    @NonNull
    public String j() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        if (dVar != null) {
            return dVar.H();
        }
        return null;
    }

    public int k() {
        return this.a;
    }

    public GMAdEcpmInfo l() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        if (dVar != null) {
            return dVar.J();
        }
        return null;
    }

    public String m() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        if (dVar != null) {
            return dVar.l();
        }
        return null;
    }

    @VisibleForTesting
    public boolean n() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        if (dVar == null) {
            return false;
        }
        dVar.f0();
        return false;
    }

    public boolean o() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        if (dVar != null) {
            return dVar.g0();
        }
        return false;
    }

    public void p() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        if (dVar != null) {
            dVar.h0();
        }
    }

    public void q() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f1378f;
        if (dVar != null) {
            dVar.i0();
        }
    }
}
