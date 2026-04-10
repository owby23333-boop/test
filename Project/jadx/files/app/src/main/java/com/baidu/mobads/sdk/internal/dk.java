package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.AdSize;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.InterstitialAd;
import com.baidu.mobads.sdk.api.InterstitialAdListener;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dk extends bf implements y {
    private static final String a = "preload_end";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private AdSize f13107q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f13108r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f13109s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f13110t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private RelativeLayout f13111u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private InterstitialAd f13112v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private InterstitialAdListener f13113w;

    public dk(Context context, RelativeLayout relativeLayout, InterstitialAd interstitialAd, String str) {
        this(context, relativeLayout, interstitialAd, AdSize.InterstitialGame, str);
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void a(String str) {
        super.g(str);
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void a_() {
        if (!this.f13109s || this.f13110t) {
            if (this.f13110t) {
                this.f12896i.b("interstitial ad is showing now");
                return;
            } else {
                if (this.f13109s) {
                    return;
                }
                this.f12896i.b("interstitial ad is not ready");
                return;
            }
        }
        this.f13110t = true;
        this.f13109s = false;
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void b() {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public boolean c() {
        return this.f13109s;
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void f() {
        a();
    }

    public void g() {
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void g(IOAdEvent iOAdEvent) {
        this.f13110t = false;
        InterstitialAdListener interstitialAdListener = this.f13113w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdDismissed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void h(IOAdEvent iOAdEvent) {
        InterstitialAdListener interstitialAdListener = this.f13113w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdClick(this.f13112v);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void q() {
        InterstitialAdListener interstitialAdListener = this.f13113w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdPresent();
        }
    }

    public dk(Context context, RelativeLayout relativeLayout, InterstitialAd interstitialAd, AdSize adSize, String str) {
        super(context);
        this.f13109s = false;
        this.f13110t = false;
        this.f13112v = interstitialAd;
        this.f13111u = relativeLayout;
        this.f13107q = adSize;
        this.f13108r = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        if (this.f12898k == null) {
            this.f12899l = false;
            return;
        }
        this.f12899l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            this.f12898k.createProdHandler(jSONObject3);
            this.f12898k.setAdContainer(this.f13111u);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f13108r);
            jSONObject.put("at", "2");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "0");
            jSONObject.put("h", "0");
            if (!TextUtils.isEmpty(this.f12902o)) {
                jSONObject.put("appid", this.f12902o);
            }
            if (AdSize.InterstitialGame.equals(this.f13107q)) {
                jSONObject2.put("ABILITY", "PAUSE,");
            }
            jSONObject2.put("APT", this.f13107q.getValue());
            jSONObject2.put("onlyLoadAd", true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f12898k.loadAd(jSONObject, jSONObject2);
    }

    @Deprecated
    public void b(Activity activity) {
        a_();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, int i2) {
        InterstitialAdListener interstitialAdListener = this.f13113w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdFailed(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void a(int i2, int i3) {
        if (this.f12898k == null || this.f13109s || this.f13110t) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, i2);
            jSONObject.put("h", i3);
        } catch (JSONException unused) {
        }
        a(jSONObject);
        this.f12898k.showAd();
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void a(RelativeLayout relativeLayout) {
        JSONObject jSONObject = new JSONObject();
        HashMap map = new HashMap();
        try {
            jSONObject.putOpt("event_type", "interstitial_set_video_parent");
            map.put("interstitial_video_parent", relativeLayout);
        } catch (JSONException e2) {
            bq.a().a(e2);
        }
        a(jSONObject, map);
        a_();
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void a(InterstitialAdListener interstitialAdListener) {
        this.f13113w = interstitialAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(IOAdEvent iOAdEvent) {
        if (a.equals(iOAdEvent.getMessage())) {
            this.f13109s = true;
            InterstitialAdListener interstitialAdListener = this.f13113w;
            if (interstitialAdListener != null) {
                interstitialAdListener.onAdReady();
            }
        }
    }
}
