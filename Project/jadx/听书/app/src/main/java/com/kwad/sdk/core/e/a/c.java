package com.kwad.sdk.core.e.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.kwad.sdk.core.e.b.c;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public C0402c aFR;
    public Context mContext;
    public final a aFS = new a();
    public final b aFT = new b();
    public final CountDownLatch mCountDownLatch = new CountDownLatch(2);

    /* JADX INFO: renamed from: com.kwad.sdk.core.e.a.c$c, reason: collision with other inner class name */
    public static final class C0402c {
        public boolean aFV;
        public String aoB;
    }

    public class a extends c.a {
        public a() {
        }

        @Override // com.kwad.sdk.core.e.b.c.a
        public final void a(int i, Bundle bundle) {
            com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDCallBack handleResult retCode = " + i + " retInfo = " + bundle);
            if (i == 0) {
                try {
                    C0402c c0402c = c.this.aFR;
                    if (c0402c != null) {
                        c0402c.aoB = bundle.getString("oa_id_flag");
                        com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDCallBack handleResult success");
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDCallBack handleResult error: " + th.getMessage());
                    return;
                }
            }
            c.a(c.this);
        }
    }

    public class b extends c.a {
        public b() {
        }

        @Override // com.kwad.sdk.core.e.b.c.a
        public final void a(int i, Bundle bundle) {
            com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult retCode=" + i + " retInfo= " + bundle);
            if (i == 0) {
                try {
                    if (c.this.aFR != null) {
                        boolean z = bundle.getBoolean("oa_id_limit_state");
                        c.this.aFR.aFV = z;
                        com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult success  isLimit=" + z);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult error:  " + th.getMessage());
                    return;
                }
            }
            c.a(c.this);
        }
    }

    public static boolean isAdvertisingIdAvailable(Context context) {
        PackageManager packageManager;
        Intent intent;
        try {
            packageManager = context.getPackageManager();
            intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
        } catch (Exception unused) {
        }
        return !packageManager.queryIntentServices(intent, 0).isEmpty();
    }

    public static void a(c cVar) {
        try {
            cVar.mCountDownLatch.countDown();
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "doCountDown  error:  " + e.getMessage());
        }
    }
}
