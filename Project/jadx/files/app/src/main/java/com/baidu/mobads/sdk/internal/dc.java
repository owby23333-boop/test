package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeAdPlacement;
import com.baidu.mobads.sdk.api.BaiduNativeH5AdView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dc extends bf {
    private boolean A;
    private BaiduNativeAdPlacement B;
    a a;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f13076q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f13077r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f13078s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f13079t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private BaiduNativeH5AdView f13080u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f13081v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f13082w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f13083x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BaiduNativeH5AdView.BaiduNativeH5EventListner f13084y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f13085z;

    public dc(Context context, String str, BaiduNativeH5AdView baiduNativeH5AdView) {
        super(context);
        this.f13081v = 1;
        this.f13082w = 1;
        this.f13083x = 1;
        this.f13085z = false;
        this.a = null;
        this.A = false;
        this.f13080u = baiduNativeH5AdView;
        this.f13077r = baiduNativeH5AdView.getAdPlacement().getApId();
        this.f13076q = str;
        this.f12894g = baiduNativeH5AdView.getAdPlacement().getAdView();
    }

    public void a(BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.f13084y = baiduNativeH5EventListner;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, int i2) {
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f13084y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdFail(str);
        }
    }

    public void c(boolean z2) {
        this.f13085z = z2;
    }

    public void d(int i2) {
        this.f13083x = i2;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void e(IOAdEvent iOAdEvent) {
        this.B.setWinSended(true);
    }

    public boolean f() {
        return this.f13085z;
    }

    public boolean g() {
        return this.A;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void h(IOAdEvent iOAdEvent) {
        this.B.setClicked(true);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f13084y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void q() {
        this.f13085z = true;
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f13084y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdShow();
        }
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.f13078s = width;
        this.f13079t = height;
    }

    public void c(int i2) {
        this.f13082w = i2;
    }

    public void a(int i2) {
        this.f13081v = i2;
    }

    public void a(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.B = baiduNativeAdPlacement;
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
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, this.f13076q);
            this.f12898k.createProdHandler(jSONObject3);
            this.f12898k.setAdContainer(this.f12894g);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f13076q);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f13077r);
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.f12902o)) {
                jSONObject.put("appid", this.f12902o);
            }
            jSONObject.put("at", "2");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f13078s);
            jSONObject.put("h", "" + this.f13079t);
            jSONObject = j.a(jSONObject, b(this.f12900m));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f12898k.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(IOAdEvent iOAdEvent) {
        this.A = true;
        this.f13080u.getAdPlacement().setAdResponse(b.a(iOAdEvent.getMessage()).a().get(0));
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f13084y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdDataLoaded();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(int i2, String str) {
        r();
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f13084y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdFail(str);
        }
    }
}
