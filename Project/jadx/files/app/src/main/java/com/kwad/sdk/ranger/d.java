package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.g;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static final String TAG = "d";

    private static void a(@NonNull c cVar) {
        try {
            a.a(cVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.e(TAG, Log.getStackTraceString(th));
        }
    }

    public static void c(@NonNull c cVar) {
        if (new Random().nextFloat() >= cVar.axo) {
            com.kwad.sdk.core.d.b.d(TAG, "config.sampleRate：" + cVar.axo + " return");
            return;
        }
        if (cVar.Cw()) {
            d(cVar);
        }
        if (cVar.Cx()) {
            a(cVar);
        }
    }

    public static void cs(final String str) {
        g.schedule(new av() { // from class: com.kwad.sdk.ranger.d.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    com.kwad.sdk.core.d.b.w(d.TAG, "config is empty");
                    return;
                }
                c cVarDZ = d.dZ(str2);
                if (cVarDZ != null) {
                    com.kwad.sdk.core.d.b.d(d.TAG, "config:" + cVarDZ.toJson().toString());
                }
                if (cVarDZ == null || cVarDZ.Cv()) {
                    return;
                }
                com.kwad.sdk.ranger.kwai.a.e(cVarDZ);
                d.c(cVarDZ);
            }
        }, 0L, TimeUnit.SECONDS);
    }

    private static void d(@NonNull c cVar) {
        List<String> list = cVar.axl;
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            RangerHelper.b(cVar);
            RangerHelper.replaceInternal();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.e(TAG, Log.getStackTraceString(th));
        }
    }

    public static c dZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVar = new c();
            cVar.parseJson(jSONObject);
            return cVar;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.w(TAG, e2);
            return null;
        }
    }
}
