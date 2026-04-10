package com.sntech.ads.impl;

import android.app.Activity;
import android.content.Context;
import com.sntech.ads.BuildConfig;
import com.sntech.ads.SNAdManager;
import com.sntech.ads.api.callback.RiskUserCallback;

/* JADX INFO: loaded from: classes.dex */
public final class SNAdManagerImpl implements SNAdManager {
    private static final String TAG = "SNAdManagerImpl";

    /* JADX INFO: loaded from: classes3.dex */
    public static class Holder {
        private static final SNAdManager sInstance = new SNAdManagerImpl();

        private Holder() {
        }
    }

    public static SNAdManager get() {
        return Holder.sInstance;
    }

    @Override // com.sntech.ads.SNAdManager
    public String did(Context context) {
        return SNADS.did();
    }

    @Override // com.sntech.ads.SNAdManager
    public String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.sntech.ads.SNAdManager
    public void isRiskUser(final RiskUserCallback riskUserCallback) {
        if (riskUserCallback == null) {
            throw new IllegalArgumentException("Callback is null");
        }
        SNADS.isRiskUser(new com.sntech.ads.callback.RiskUserCallback() { // from class: com.sntech.ads.impl.a
            @Override // com.sntech.ads.callback.RiskUserCallback
            public final void callback(boolean z2) {
                riskUserCallback.callback(z2);
            }
        });
    }

    @Override // com.sntech.ads.SNAdManager
    public void onRequestPermissionResult(Activity activity, int i2, String[] strArr, int[] iArr) {
        SNADS.onRequestPermissionResult(activity, i2, strArr, iArr);
    }

    @Override // com.sntech.ads.SNAdManager
    public void requestPermissionsIfNeed(Activity activity, String... strArr) {
        SNADS.requestPermissionsIfNeed(activity, strArr);
    }

    @Override // com.sntech.ads.SNAdManager
    public void setUserId(String str) {
        SNADS.setUserId(str);
    }
}
