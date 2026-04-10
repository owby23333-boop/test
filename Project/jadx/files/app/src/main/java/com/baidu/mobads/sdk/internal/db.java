package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.tencent.smtt.sdk.TbsListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class db extends bf {
    private a A;
    private boolean B;
    private boolean C;
    RelativeLayout a;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f13066q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f13067r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f13068s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f13069t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f13070u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f13071v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f13072w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ExpressInterstitialListener f13073x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ExpressInterstitialAd.InterAdDownloadWindowListener f13074y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ExpressInterstitialAd.InterstitialAdDislikeListener f13075z;

    public db(Context context, RelativeLayout relativeLayout, String str) {
        super(context);
        this.f13068s = 8000;
        this.f13069t = IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
        this.f13071v = 600;
        this.f13072w = 500;
        this.B = false;
        this.a = relativeLayout;
        this.f13070u = str;
    }

    public void a(ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.f13074y = interAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i2) {
        ExpressInterstitialListener expressInterstitialListener = this.f13073x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdFailed(i2, str);
        }
        super.b(str, i2);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b_() {
        ExpressInterstitialListener expressInterstitialListener = this.f13073x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheSuccess();
            this.f13073x.onVideoDownloadSuccess();
        }
    }

    public void c(boolean z2) {
        this.B = z2;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void c_() {
        ExpressInterstitialListener expressInterstitialListener = this.f13073x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheFailed();
            this.f13073x.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void d(String str) {
    }

    public void d(boolean z2) {
        this.C = z2;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void e(IOAdEvent iOAdEvent) {
        this.f13067r = false;
        ExpressInterstitialListener expressInterstitialListener = this.f13073x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposed();
        }
    }

    public String f() {
        return this.f13069t;
    }

    public boolean g() {
        return this.f13067r;
    }

    public void h() {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.f13069t);
            jSONObject2.put("isNewInterstitial", true);
            this.f12898k.createProdHandler(jSONObject2);
            this.f12898k.setAdContainer(this.a);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f13069t);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f13070u);
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.f12902o)) {
                jSONObject.put("appid", this.f12902o);
            }
            if (cn.a().b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("at", "10");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + ax.b(this.f12895h));
            jSONObject.put("h", "" + ax.c(this.f12895h));
            jSONObject.put("msa", TbsListener.ErrorCode.NEEDDOWNLOAD_STATIC_INSTALLING);
            jSONObject.put("opt", 1);
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
            jSONObject.put("onlyLoadAd", this.f13066q);
            jSONObject.put("isNewInterstitial", true);
            jSONObject.put(SplashAd.KEY_POPDIALOG_DOWNLOAD, this.B);
            jSONObject.put("use_dialog_container", this.C);
            jSONObject.put("timeout", this.f13068s);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void u() {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.f13074y;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClose();
        }
    }

    public a w() {
        return this.A;
    }

    public void a(ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.f13075z = interstitialAdDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void c(IOAdEvent iOAdEvent) {
        ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener = this.f13075z;
        if (interstitialAdDislikeListener == null || iOAdEvent == null) {
            return;
        }
        interstitialAdDislikeListener.interstitialAdDislikeClick();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void d() {
        ExpressInterstitialListener expressInterstitialListener = this.f13073x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void f(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.f13073x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposureFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        ExpressInterstitialListener expressInterstitialListener = this.f13073x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClose();
        }
    }

    public void a(int i2) {
        this.f13068s = i2;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void h(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.f13073x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClick();
        }
    }

    public void a(ExpressInterstitialListener expressInterstitialListener) {
        this.f13073x = expressInterstitialListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, boolean z2) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.f13074y;
        if (interAdDownloadWindowListener != null) {
            if (z2) {
                interAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                interAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void e(String str) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.f13074y;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener == null) {
            this.f12899l = false;
            return;
        }
        this.f13067r = false;
        this.f12899l = true;
        iAdInterListener.loadAd(k(), l());
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.f13071v = width;
            this.f13072w = height;
        }
        a(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(int i2, String str) {
        ExpressInterstitialListener expressInterstitialListener = this.f13073x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onNoAd(i2, str);
        }
        super.a(i2, str);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(String str, boolean z2) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.f13074y;
        if (interAdDownloadWindowListener != null) {
            if (z2) {
                interAdDownloadWindowListener.onADPermissionShow();
            } else {
                interAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(IOAdEvent iOAdEvent) {
        List<a> listA;
        if (iOAdEvent != null && (listA = b.a(iOAdEvent.getMessage()).a()) != null && listA.size() > 0) {
            this.A = listA.get(0);
        }
        this.f13067r = true;
        ExpressInterstitialListener expressInterstitialListener = this.f13073x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADLoaded();
        }
    }

    public void a(boolean z2, String str) {
        a(z2, str, (HashMap<String, Object>) null);
    }

    public void a(boolean z2, String str, HashMap<String, Object> map) {
        a aVar = this.A;
        if (aVar != null) {
            a(aVar.G(), z2, str, map);
        }
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
