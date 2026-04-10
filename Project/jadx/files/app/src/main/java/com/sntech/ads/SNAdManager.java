package com.sntech.ads;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Keep;
import com.sntech.ads.api.callback.RiskUserCallback;

/* JADX INFO: loaded from: classes.dex */
@Keep
public interface SNAdManager {
    @Keep
    String did(Context context);

    @Keep
    String getSdkVersion();

    @Keep
    void isRiskUser(RiskUserCallback riskUserCallback);

    @Keep
    void onRequestPermissionResult(Activity activity, int i2, String[] strArr, int[] iArr);

    @Keep
    void requestPermissionsIfNeed(Activity activity, String... strArr);

    @Keep
    void setUserId(String str);
}
