package com.anythink.basead.mraid;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements IBannerJSBridge {
    c a;
    WeakReference<Activity> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f6075c;

    private void a(Activity activity) {
        this.b = new WeakReference<>(activity);
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void cai(Object obj, String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void click(Object obj, String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void close() {
        b bVar = this.f6075c;
        if (bVar != null) {
            bVar.close();
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void expand(String str, boolean z2) {
        Activity activity;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z2);
            if (this.b == null || (activity = this.b.get()) == null) {
                return;
            }
            if (this.a == null || !this.a.isShowing()) {
                this.a = new c(activity, bundle, this.f6075c);
                this.a.show();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void getFileInfo(Object obj, String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final com.anythink.expressad.foundation.d.c getMraidCampaign() {
        return null;
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void getNetstat(Object obj, String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void gial(Object obj, String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void handlerH5Exception(Object obj, String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void increaseOfferFrequence(Object obj, String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void init(Object obj, String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void install(Object obj, String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void onJSBridgeConnect(Object obj, String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void open(String str) {
        b bVar = this.f6075c;
        if (bVar != null) {
            bVar.open(str);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void openURL(Object obj, String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void readyStatus(Object obj, String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void reportUrls(Object obj, String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void resetCountdown(Object obj, String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void sendImpressions(Object obj, String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void toggleCloseBtn(Object obj, String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void triggerCloseBtn(Object obj, String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void unload() {
        close();
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void useCustomClose(boolean z2) {
        try {
            if (this.f6075c != null) {
                this.f6075c.useCustomClose(z2);
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.f6075c = bVar;
        }
    }
}
