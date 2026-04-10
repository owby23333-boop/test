package com.repack.huawei.hms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.Keep;
import java.io.IOException;
import s.b;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class AdvertisingIdClient {
    private static final String SETTINGS_AD_ID = "pps_oaid";
    private static final String SETTINGS_TRACK_LIMIT = "pps_track_limit";

    @Keep
    public static final class Info {
        private final String advertisingId;
        private final boolean limitAdTrackingEnabled;

        @Keep
        public Info(String str, boolean z2) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z2;
        }

        @Keep
        public final String getId() {
            return this.advertisingId;
        }

        @Keep
        public final boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }
    }

    public static class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final Context f17846s;

        public a(Context context) {
            this.f17846s = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AdvertisingIdClient.requestAdvertisingIdInfo(this.f17846s);
            } catch (Throwable unused) {
            }
        }
    }

    @Keep
    public static Info getAdvertisingIdInfo(Context context) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), SETTINGS_AD_ID);
                String string2 = Settings.Global.getString(context.getContentResolver(), SETTINGS_TRACK_LIMIT);
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    updateAdvertisingIdInfo(context);
                    return new Info(string, Boolean.valueOf(string2).booleanValue());
                }
            } catch (Throwable unused) {
            }
        }
        return requestAdvertisingIdInfo(context);
    }

    @Keep
    public static boolean isAdvertisingIdAvailable(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid");
            return !r4.queryIntentServices(r2, 0).isEmpty();
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    public static Info requestAdvertisingIdInfo(Context context) throws IOException {
        try {
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            b bVar = new b();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (!context.bindService(intent, bVar, 1)) {
                throw new IOException("bind failed");
            }
            try {
                try {
                    if (bVar.f21693s) {
                        throw new IllegalStateException();
                    }
                    bVar.f21693s = true;
                    u.a aVar = new u.a(bVar.f21694t.take());
                    Info info = new Info(aVar.getOaid(), aVar.isOaidTrackLimited());
                    try {
                        context.unbindService(bVar);
                    } catch (Throwable th) {
                        String str = "unbind " + th.getClass().getSimpleName();
                    }
                    return info;
                } catch (RemoteException unused) {
                    throw new IOException("bind hms service RemoteException");
                } catch (Throwable th2) {
                    try {
                        context.unbindService(bVar);
                    } catch (Throwable th3) {
                        String str2 = "unbind " + th3.getClass().getSimpleName();
                    }
                    throw th2;
                }
            } catch (InterruptedException unused2) {
                throw new IOException("bind hms service InterruptedException");
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            throw new IOException("Service not found");
        }
    }

    private static void updateAdvertisingIdInfo(Context context) {
        s.a.a.execute(new a(context));
    }

    @Keep
    public static boolean verifyAdId(Context context, String str, boolean z2) throws AdIdVerifyException {
        Info infoRequestAdvertisingIdInfo = requestAdvertisingIdInfo(context);
        if (infoRequestAdvertisingIdInfo == null || !TextUtils.equals(str, infoRequestAdvertisingIdInfo.getId())) {
            return false;
        }
        return z2 == infoRequestAdvertisingIdInfo.isLimitAdTrackingEnabled();
    }
}
