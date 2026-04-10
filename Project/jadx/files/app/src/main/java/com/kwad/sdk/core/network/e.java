package com.kwad.sdk.core.network;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.ba;
import java.io.File;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    private static volatile e afL;
    private String afM = wq();

    private e() {
    }

    @WorkerThread
    private static void bN(String str) {
        try {
            com.kwad.sdk.utils.p.a(new File(au.cV(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext())), str, Charset.forName("UTF-8"), false);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    public static e wo() {
        if (afL == null) {
            synchronized (e.class) {
                if (afL == null) {
                    afL = new e();
                }
            }
        }
        return afL;
    }

    @Nullable
    @WorkerThread
    private static String wq() {
        try {
            return com.kwad.sdk.utils.p.a(new File(au.cV(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext())), Charset.forName("UTF-8"));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    @WorkerThread
    public final void bM(String str) {
        if (ba.isEquals(this.afM, str)) {
            return;
        }
        this.afM = str;
        bN(str);
    }

    @Nullable
    @WorkerThread
    public final String wp() {
        return this.afM;
    }
}
