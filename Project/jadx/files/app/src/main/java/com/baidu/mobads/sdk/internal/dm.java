package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.ScreenVideoAdListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dm extends bf {
    private boolean a;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f13114q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f13115r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ScreenVideoAdListener f13116s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f13117t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f13118u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f13119v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f13120w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f13121x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private a f13122y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private RequestParameters f13123z;

    public dm(Context context, String str, boolean z2) {
        this(context, str, z2, IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO);
    }

    public void a(int i2) {
        this.f13114q = i2;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, int i2) {
        super.b(str, i2);
        ScreenVideoAdListener screenVideoAdListener = this.f13116s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b_() {
        ScreenVideoAdListener screenVideoAdListener = this.f13116s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void c_() {
        ScreenVideoAdListener screenVideoAdListener = this.f13116s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadFailed();
        }
    }

    public void f() {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    public boolean g() {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            return iAdInterListener.isAdReady();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void h(IOAdEvent iOAdEvent) {
        ScreenVideoAdListener screenVideoAdListener = this.f13116s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClick();
        }
    }

    public void i(String str) {
        this.f13121x = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.f13117t);
            this.f12898k.createProdHandler(jSONObject2);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f13117t);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f13115r);
            jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON");
            jSONObject.put("n", "1");
            jSONObject.put("at", "10");
            if (!TextUtils.isEmpty(this.f12902o)) {
                jSONObject.put("appid", this.f12902o);
            }
            Rect rectA = ax.a(this.f12895h);
            this.f13118u = rectA.width();
            this.f13119v = rectA.height();
            if (this.f12895h.getResources().getConfiguration().orientation == 2) {
                this.f13118u = rectA.height();
                this.f13119v = rectA.width();
            }
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f13118u);
            jSONObject.put("h", "" + this.f13119v);
            jSONObject.put("opt", 1);
            if (IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO.equals(this.f13117t)) {
                jSONObject.put("msa", 5285);
            }
            jSONObject = j.a(jSONObject, b(this.f12900m));
            b(jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", 8000);
            jSONObject.put("useSurfaceView", this.a);
            jSONObject.put("downloadConfirmPolicy", this.f13114q);
            jSONObject.put("userid", this.f13120w);
            jSONObject.put("extra", this.f13121x);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void q() {
        ScreenVideoAdListener screenVideoAdListener = this.f13116s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdShow();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void s() {
        ScreenVideoAdListener screenVideoAdListener = this.f13116s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.playCompletion();
        }
    }

    public dm(Context context, String str, boolean z2, String str2) {
        super(context);
        this.f13114q = 3;
        this.f13115r = str;
        this.a = z2;
        this.f13117t = str2;
    }

    public void a(String str) {
        this.f13120w = str;
    }

    public void a(ScreenVideoAdListener screenVideoAdListener) {
        this.f13116s = screenVideoAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void f(String str) {
        ScreenVideoAdListener screenVideoAdListener = this.f13116s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdSkip(Float.parseFloat(str));
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        float fFloatValue = (iOAdEvent == null || iOAdEvent.getData() == null) ? 0.0f : ((Float) iOAdEvent.getData().get("play_scale")).floatValue();
        ScreenVideoAdListener screenVideoAdListener = this.f13116s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClose(fFloatValue);
        }
    }

    public String h() {
        a aVar = this.f13122y;
        return aVar != null ? aVar.z() : "";
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener == null) {
            this.f12899l = false;
        } else {
            this.f12899l = true;
            iAdInterListener.loadAd(k(), l());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(boolean z2) {
        ScreenVideoAdListener screenVideoAdListener = this.f13116s;
        if (screenVideoAdListener == null || !(screenVideoAdListener instanceof RewardVideoAd.RewardVideoAdListener)) {
            return;
        }
        ((RewardVideoAd.RewardVideoAdListener) screenVideoAdListener).onRewardVerify(z2);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(IOAdEvent iOAdEvent) {
        List<a> listA;
        if (iOAdEvent != null && (listA = b.a(iOAdEvent.getMessage()).a()) != null && listA.size() > 0) {
            this.f13122y = listA.get(0);
        }
        ScreenVideoAdListener screenVideoAdListener = this.f13116s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdLoaded();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(int i2, String str) {
        super.a(i2, str);
        ScreenVideoAdListener screenVideoAdListener = this.f13116s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    public void a(boolean z2, String str) {
        a(z2, str, (HashMap<String, Object>) null);
    }

    public void a(boolean z2, String str, HashMap<String, Object> map) {
        a aVar = this.f13122y;
        if (aVar != null) {
            a(aVar.G(), z2, str, map);
        }
    }

    public void a(RequestParameters requestParameters) {
        this.f13123z = requestParameters;
        a(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(Map<String, String> map) {
        try {
            this.f12900m = j.a(map);
        } catch (Throwable unused) {
            this.f12900m = new HashMap<>();
        }
    }
}
