package com.kwad.sdk.n;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class f {
    public static final String TAG = "Ranger_f";

    public static void cS(final String str) {
        h.schedule(new bg() { // from class: com.kwad.sdk.n.f.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    com.kwad.sdk.core.d.c.w(f.TAG, "config is empty");
                    return;
                }
                d dVarGH = f.gH(str2);
                if (dVarGH != null) {
                    com.kwad.sdk.core.d.c.d(f.TAG, "config:" + dVarGH.toJson().toString());
                }
                if (dVarGH == null || dVarGH.OX()) {
                    return;
                }
                f.d(dVarGH);
            }
        }, 0L, TimeUnit.SECONDS);
    }

    public static d gH(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w(TAG, e);
            return null;
        }
    }

    public static void d(d dVar) {
        if (new Random().nextFloat() >= dVar.sampleRate) {
            com.kwad.sdk.core.d.c.d(TAG, "config.sampleRate：" + dVar.sampleRate + " return");
            return;
        }
        if (dVar.OY()) {
            a(dVar);
        }
        if (dVar.OZ()) {
            e(dVar);
        }
        if (dVar.Pa()) {
            f(dVar);
        }
    }

    private static void a(d dVar) {
        try {
            a.a(dVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e(TAG, Log.getStackTraceString(th));
        }
    }

    private static void e(d dVar) {
        c.OV().c(dVar);
    }

    private static void f(final d dVar) {
        GlobalThreadPools.Jn().execute(new Runnable() { // from class: com.kwad.sdk.n.f.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    b.OQ().b(dVar);
                    b.OQ().OS();
                    b.OQ().clearAll();
                    b.OQ().start();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.e(f.TAG, Log.getStackTraceString(e));
                }
            }
        });
    }
}
