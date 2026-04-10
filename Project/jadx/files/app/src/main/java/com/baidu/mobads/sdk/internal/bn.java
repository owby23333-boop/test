package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ExpressAdData;
import com.baidu.mobads.sdk.api.ExpressResponse;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class bn implements ExpressResponse {
    private Context a;
    private int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ExpressResponse.ExpressInteractionListener f12932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ExpressResponse.ExpressAdDownloadWindowListener f12933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ExpressResponse.ExpressDislikeListener f12934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final dd f12935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f12936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ViewGroup f12937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ExpressAdData f12938i;

    public bn(Context context, dd ddVar, a aVar) {
        this.a = context;
        this.f12935f = ddVar;
        this.f12936g = aVar;
    }

    public void a(int i2) {
        this.b = i2;
    }

    public void b() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f12932c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingSuccess(String str) {
        dd ddVar;
        a aVar = this.f12936g;
        if (aVar == null || (ddVar = this.f12935f) == null) {
            return;
        }
        ddVar.a(aVar.G(), true, str);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void bindInteractionActivity(Activity activity) {
        dd ddVar = this.f12935f;
        if (ddVar != null) {
            ddVar.b(activity);
        }
    }

    public void c() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f12932c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdExposed();
        }
    }

    public void d() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f12934e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowShow();
        }
    }

    public void e() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f12934e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowClose();
        }
    }

    public void f() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f12932c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdUnionClick();
        }
    }

    public void g() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f12933d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getAdActionType() {
        return this.b;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public ExpressAdData getAdData() {
        return this.f12938i;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public String getECPMLevel() {
        a aVar = this.f12936g;
        return aVar != null ? aVar.z() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public View getExpressAdView() {
        a aVar;
        if (this.f12937h == null && (aVar = this.f12936g) != null) {
            this.f12937h = this.f12935f.a(aVar);
        }
        return this.f12937h;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getStyleType() {
        a aVar = this.f12936g;
        if (aVar != null) {
            return aVar.v();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean isAdAvailable() {
        return this.f12936g != null && System.currentTimeMillis() - this.f12936g.y() <= this.f12936g.E();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void render() {
        a aVar;
        dd ddVar = this.f12935f;
        if (ddVar == null || (aVar = this.f12936g) == null) {
            return;
        }
        if (this.f12937h == null) {
            this.f12937h = ddVar.a(aVar);
        }
        this.f12935f.a(this.f12937h, this.f12936g);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdDislikeListener(ExpressResponse.ExpressDislikeListener expressDislikeListener) {
        this.f12934e = expressDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdPrivacyListener(ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener) {
        this.f12933d = expressAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setInteractionListener(ExpressResponse.ExpressInteractionListener expressInteractionListener) {
        this.f12932c = expressInteractionListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean switchTheme(int i2) {
        dd ddVar = this.f12935f;
        if (ddVar != null) {
            return ddVar.a(this.f12937h, this.f12936g, i2);
        }
        return false;
    }

    public String a() {
        a aVar = this.f12936g;
        return aVar != null ? aVar.G() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(String str, HashMap<String, Object> map) {
        dd ddVar;
        a aVar = this.f12936g;
        if (aVar == null || (ddVar = this.f12935f) == null) {
            return;
        }
        ddVar.a(aVar.G(), false, str, map);
    }

    public void b(boolean z2) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f12933d;
        if (expressAdDownloadWindowListener != null) {
            if (z2) {
                expressAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                expressAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    public void a(View view, int i2, int i3) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f12932c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderSuccess(view, i2, i3);
        }
    }

    public void a(View view, String str, int i2) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f12932c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderFail(view, str, i2);
        }
    }

    public void a(String str) {
        dd ddVar;
        a aVar = this.f12936g;
        if (aVar != null && (ddVar = this.f12935f) != null) {
            this.f12938i = new ExpressAdData(aVar, ddVar.h());
        }
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f12934e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeItemClick(str);
        }
    }

    public void a(boolean z2) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f12933d;
        if (expressAdDownloadWindowListener != null) {
            if (z2) {
                expressAdDownloadWindowListener.onADPermissionShow();
            } else {
                expressAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }
}
