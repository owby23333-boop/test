package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.AdView;
import com.baidu.mobads.sdk.api.AdViewListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class cp extends bf {
    private RelativeLayout a;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f13042q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f13043r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private AdViewListener f13044s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f13045t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f13046u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private AdView f13047v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private RequestParameters f13048w;

    public cp(AdView adView, Context context, RelativeLayout relativeLayout, String str, boolean z2) {
        super(context);
        this.f13047v = adView;
        this.a = relativeLayout;
        this.f13042q = str;
        this.f13043r = z2;
    }

    public void a(int i2) {
        this.f13045t = i2;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, int i2) {
        AdViewListener adViewListener = this.f13044s;
        if (adViewListener != null) {
            adViewListener.onAdFailed(str);
        }
    }

    public void c(int i2) {
        this.f13046u = i2;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        AdViewListener adViewListener = this.f13044s;
        if (adViewListener != null) {
            adViewListener.onAdClose(new JSONObject());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void h(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener = this.f13044s;
        if (adViewListener != null) {
            adViewListener.onAdClick(new JSONObject());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void q() {
        AdViewListener adViewListener = this.f13044s;
        if (adViewListener != null) {
            adViewListener.onAdSwitch();
            this.f13044s.onAdShow(new JSONObject());
        }
    }

    public void a(AdViewListener adViewListener) {
        this.f13044s = adViewListener;
    }

    public void a(RequestParameters requestParameters) {
        this.f13048w = requestParameters;
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
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, "banner");
            this.f12898k.createProdHandler(jSONObject3);
            this.f12898k.setAdContainer(this.a);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "banner");
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f13042q);
            jSONObject.put("at", "2");
            jSONObject.put("ABILITY", "BANNER_CLOSE,PAUSE,UNLIMITED_BANNER_SIZE,");
            jSONObject.put("AP", this.f13043r);
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f13045t);
            jSONObject.put("h", "" + this.f13046u);
            if (!TextUtils.isEmpty(this.f12902o)) {
                jSONObject.put("appid", this.f12902o);
            }
            if (this.f13048w != null) {
                a(this.f13048w.getExtras());
            }
            jSONObject2 = b(this.f12900m);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f12898k.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener = this.f13044s;
        if (adViewListener != null) {
            adViewListener.onAdReady(this.f13047v);
        }
    }
}
