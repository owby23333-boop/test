package com.anythink.splashad.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATMediationRequestInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.i;
import com.anythink.core.common.l;
import com.anythink.core.common.v;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    boolean a;
    b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f12751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    com.anythink.core.common.e.b f12752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f12753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f12754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f12755g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f12756h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f12757i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    String f12758j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f12759k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Map<String, Object> f12760l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Context f12761m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f12762n;

    /* JADX INFO: renamed from: com.anythink.splashad.a.d$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b bVar = d.this.b;
            if (bVar != null) {
                bVar.onAdLoaded();
            }
            d.this.b = null;
        }
    }

    /* JADX INFO: renamed from: com.anythink.splashad.a.d$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ CustomSplashAdapter a;
        final /* synthetic */ AdError b;

        AnonymousClass2(CustomSplashAdapter customSplashAdapter, AdError adError) {
            this.a = customSplashAdapter;
            this.b = adError;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CustomSplashAdapter customSplashAdapter = this.a;
            if (customSplashAdapter != null) {
                customSplashAdapter.destory();
            }
            b bVar = d.this.b;
            if (bVar != null) {
                bVar.onAdLoadFail(this.b);
            }
            d.this.b = null;
        }
    }

    private class a implements ATCustomLoadListener {
        CustomSplashAdapter a;

        public a(CustomSplashAdapter customSplashAdapter) {
            this.a = customSplashAdapter;
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdCacheLoaded(BaseAd... baseAdArr) {
            d.this.a(this.a, baseAdArr);
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdDataLoaded() {
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdLoadError(String str, String str2) {
            d.this.a(this.a, ErrorCode.getErrorCode(ErrorCode.noADError, str, str2));
        }
    }

    public d(Context context) {
        this.f12761m = context.getApplicationContext();
    }

    private void b() {
        n.a().a(new AnonymousClass1());
    }

    private void c() {
        this.b = null;
    }

    private void d() {
        this.f12752d = null;
    }

    private void e() {
        com.anythink.core.common.e.e eVar = new com.anythink.core.common.e.e();
        eVar.x(this.f12754f);
        eVar.y(this.f12753e);
        eVar.z("4");
        eVar.w("0");
        eVar.a(true);
        com.anythink.core.common.j.c.a(eVar, ErrorCode.getErrorCode(ErrorCode.timeOutError, "", "Splash FetchAd Timeout."));
    }

    private com.anythink.core.common.e.b f() {
        com.anythink.core.common.e.b bVar = this.f12752d;
        if (bVar == null || bVar.d() > 0) {
            return null;
        }
        return this.f12752d;
    }

    private com.anythink.core.common.e.b g() {
        return this.f12752d;
    }

    public final void a(CustomSplashAdapter customSplashAdapter, BaseAd... baseAdArr) {
        if (this.a) {
            return;
        }
        if (customSplashAdapter != null) {
            customSplashAdapter.getTrackingInfo().d(SystemClock.elapsedRealtime() - this.f12751c);
            customSplashAdapter.getTrackingInfo().g(customSplashAdapter.getNetworkPlacementId());
            com.anythink.core.common.k.g.a(customSplashAdapter.getTrackingInfo(), g.i.b, g.i.f6860f, "");
            com.anythink.core.common.j.a.a(this.f12761m).a(12, customSplashAdapter.getTrackingInfo());
            com.anythink.core.common.j.a.a(this.f12761m).a(2, customSplashAdapter.getTrackingInfo());
            com.anythink.core.common.e.b bVar = new com.anythink.core.common.e.b();
            bVar.b(0);
            bVar.a(customSplashAdapter);
            bVar.c(System.currentTimeMillis());
            bVar.b(TTAdConstant.AD_MAX_EVENT_TIME);
            bVar.a(customSplashAdapter.getTrackingInfo().X());
            bVar.a(TTAdConstant.AD_MAX_EVENT_TIME);
            if (baseAdArr != null && baseAdArr.length > 0) {
                baseAdArr[0].setTrackingInfo(customSplashAdapter.getTrackingInfo().N());
                bVar.a(baseAdArr[0]);
            }
            this.f12752d = bVar;
        }
        this.a = true;
        this.f12762n = false;
        n.a().a(new AnonymousClass1());
    }

    private void b(CustomSplashAdapter customSplashAdapter, AdError adError) {
        n.a().a(new AnonymousClass2(customSplashAdapter, adError));
    }

    public final void a(CustomSplashAdapter customSplashAdapter, AdError adError) {
        if (this.a) {
            return;
        }
        if (customSplashAdapter != null) {
            com.anythink.core.common.k.g.a(customSplashAdapter.getTrackingInfo(), g.i.b, g.i.f6861g, adError.printStackTrace());
        }
        this.a = true;
        this.f12762n = false;
        n.a().a(new AnonymousClass2(customSplashAdapter, adError));
    }

    protected final boolean a() {
        return this.f12762n;
    }

    public final void a(Context context, String str, String str2, ATMediationRequestInfo aTMediationRequestInfo, String str3, b bVar, int i2) {
        this.b = bVar;
        this.f12753e = str2;
        this.f12754f = str;
        if (!TextUtils.isEmpty(str3)) {
            this.f12755g = "0";
            this.f12760l = new HashMap(1);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                this.f12755g = jSONObject.optString("unit_id");
                this.f12756h = jSONObject.optInt("nw_firm_id");
                this.f12757i = jSONObject.optString(l.f7770z);
                this.f12758j = jSONObject.optString("content");
                this.f12759k = jSONObject.optInt("ad_type", -1);
                this.f12760l = h.c(this.f12758j);
                this.f12760l.put("ad_type", Integer.valueOf(this.f12759k));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if (aTMediationRequestInfo != null) {
            this.f12755g = aTMediationRequestInfo.getAdSourceId();
            this.f12756h = aTMediationRequestInfo.getNetworkFirmId();
            this.f12757i = aTMediationRequestInfo.getClassName();
            this.f12760l = aTMediationRequestInfo.getRequestParamMap();
            this.f12759k = 4;
            this.f12760l.put("ad_type", Integer.valueOf(this.f12759k));
        }
        n.a();
        n.n(this.f12755g);
        com.anythink.core.common.e.e eVar = new com.anythink.core.common.e.e();
        eVar.x(str);
        eVar.y(str2);
        eVar.u(this.f12756h);
        eVar.z("4");
        eVar.l(TextUtils.isEmpty(this.f12755g) ? "0" : this.f12755g);
        eVar.w("0");
        eVar.a(true);
        if (!TextUtils.isEmpty(this.f12758j)) {
            eVar.n(this.f12758j);
        }
        if (!TextUtils.isEmpty(str3)) {
            eVar.c(8);
        }
        eVar.w(this.f12759k);
        try {
            ATBaseAdAdapter aTBaseAdAdapterA = i.a(this.f12757i);
            if (aTBaseAdAdapterA instanceof CustomSplashAdapter) {
                ((CustomSplashAdapter) aTBaseAdAdapterA).setFetchAdTimeout(i2);
                this.f12762n = true;
                this.a = false;
                this.f12751c = SystemClock.elapsedRealtime();
                try {
                    eVar.v(aTBaseAdAdapterA.getNetworkName());
                    eVar.f7247u = aTBaseAdAdapterA.getNetworkSDKVersion();
                    eVar.f7243q = 2;
                } catch (Throwable unused) {
                }
                aTBaseAdAdapterA.setTrackingInfo(eVar);
                com.anythink.core.common.k.g.a(eVar, g.i.a, g.i.f6862h, "");
                com.anythink.core.common.j.a.a(this.f12761m).a(10, eVar);
                com.anythink.core.common.j.a.a(this.f12761m).a(1, eVar);
                aTBaseAdAdapterA.internalLoad(context, this.f12760l, v.a().c(str), new a((CustomSplashAdapter) aTBaseAdAdapterA));
                return;
            }
            throw new Exception("The class isn't instanceof CustomSplashAdapter");
        } catch (Throwable th2) {
            if (this.b != null) {
                this.b.onAdLoadFail(ErrorCode.getErrorCode("2002", "", th2.getMessage()));
            }
            this.b = null;
        }
    }

    private void a(String str) {
        this.f12755g = "0";
        this.f12760l = new HashMap(1);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f12755g = jSONObject.optString("unit_id");
            this.f12756h = jSONObject.optInt("nw_firm_id");
            this.f12757i = jSONObject.optString(l.f7770z);
            this.f12758j = jSONObject.optString("content");
            this.f12759k = jSONObject.optInt("ad_type", -1);
            this.f12760l = h.c(this.f12758j);
            this.f12760l.put("ad_type", Integer.valueOf(this.f12759k));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(ATMediationRequestInfo aTMediationRequestInfo) {
        this.f12755g = aTMediationRequestInfo.getAdSourceId();
        this.f12756h = aTMediationRequestInfo.getNetworkFirmId();
        this.f12757i = aTMediationRequestInfo.getClassName();
        this.f12760l = aTMediationRequestInfo.getRequestParamMap();
        this.f12759k = 4;
        this.f12760l.put("ad_type", Integer.valueOf(this.f12759k));
    }
}
