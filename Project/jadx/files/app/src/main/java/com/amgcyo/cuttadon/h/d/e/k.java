package com.amgcyo.cuttadon.h.d.e;

import android.app.Activity;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAd;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdSlotSplash;

/* JADX INFO: compiled from: AdWakeupManager.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    private GMSplashAd a;
    private Activity b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private GMSplashAdLoadCallback f3923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private GMSplashAdListener f3924e;

    public k(Activity activity, boolean z2, GMSplashAdLoadCallback gMSplashAdLoadCallback, GMSplashAdListener gMSplashAdListener) {
        this.b = activity;
        this.f3922c = z2;
        this.f3923d = gMSplashAdLoadCallback;
        this.f3924e = gMSplashAdListener;
    }

    public void a(String str, int i2, int i3) {
        this.a = new GMSplashAd(this.b, str);
        this.a.setAdSplashListener(this.f3924e);
        this.a.loadAd(new GMAdSlotSplash.Builder().setImageAdSize(i2, i3).setTimeOut(4000).setSplashButtonType(1).setDownloadType(1).setForceLoadBottom(this.f3922c).setBidNotify(true).setSplashShakeButton(true).build(), this.f3923d);
    }

    public GMSplashAd b() {
        return this.a;
    }

    public void c() {
    }

    public void a() {
        GMSplashAd gMSplashAd = this.a;
        if (gMSplashAd != null) {
            gMSplashAd.destroy();
        }
        this.b = null;
        this.f3923d = null;
        this.f3924e = null;
    }
}
