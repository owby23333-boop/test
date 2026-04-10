package com.kwad.sdk.utils.kwai;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.kwai.c;
import com.kwad.sdk.utils.p;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    static ExecutorService aBu = Executors.newSingleThreadExecutor();
    static boolean axr = Ft();

    private static boolean Ft() {
        d.setExecutor(aBu);
        d.a(new c.d() { // from class: com.kwad.sdk.utils.kwai.e.1
            @Override // com.kwad.sdk.utils.kwai.c.d
            public final void a(String str, Exception exc) {
                com.kwad.sdk.core.d.b.w("Ks_UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(exc));
            }

            @Override // com.kwad.sdk.utils.kwai.c.d
            public final void b(String str, Exception exc) {
                com.kwad.sdk.core.d.b.e("Ks_UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(exc));
            }

            @Override // com.kwad.sdk.utils.kwai.c.d
            public final void i(String str, String str2) {
                com.kwad.sdk.core.d.b.i("Ks_UnionKv", "name:" + str + " msg:" + str2);
            }
        });
        axr = true;
        return true;
    }

    public static c ar(@NonNull Context context, String str) {
        if (!axr) {
            Ft();
        }
        return new c.a(p.E(context, "ks_union"), str).Fr();
    }
}
