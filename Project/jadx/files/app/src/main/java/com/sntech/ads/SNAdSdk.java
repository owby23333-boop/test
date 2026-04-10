package com.sntech.ads;

import android.app.Application;
import androidx.annotation.Keep;
import com.sntech.ads.impl.A4AdManagerImpl;
import com.sntech.ads.impl.SNADS;
import com.sntech.ads.impl.SNAdManagerImpl;
import com.sntech.ads.impl.SNEventManagerImpl;
import com.sntech.ads.impl.SNMediationManagerImpl;
import org.json.JSONObject;
import z0.o;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class SNAdSdk {
    private static SNAdConfig sConfig;

    private SNAdSdk() {
    }

    @Keep
    public static A4AdManager getA4AdManager() {
        return A4AdManagerImpl.get();
    }

    @Keep
    public static SNAdManager getAdManager() {
        return SNAdManagerImpl.get();
    }

    @Keep
    public static SNEventManager getEventManager() {
        return SNEventManagerImpl.get();
    }

    @Keep
    public static SNMediationManager getMediationManager() {
        return SNMediationManagerImpl.get();
    }

    @Keep
    public static void onApplicationAttachBaseContext(Application application, SNAdConfig sNAdConfig) {
        sConfig = sNAdConfig;
    }

    @Keep
    public static void onApplicationCreate(Application application) {
        if (sConfig == null) {
            throw new IllegalStateException("Call onApplicationAttachBaseContext first!");
        }
        SNADS.initSDK(application.getApplicationContext(), sConfig);
    }

    @Keep
    public static void onApplicationLowMemory(Application application) {
        o.a().a("APPLICATION_LOW_MEMORY", (JSONObject) null);
    }
}
