package com.kwad.sdk.core.diskcache.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.diskcache.kwai.a;
import com.kwad.sdk.core.network.kwai.a;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    static File a(@NonNull com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull String str) {
        try {
            a.c cVarBq = aVar.bq(str);
            if (cVarBq != null) {
                return cVarBq.aV(0);
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    static void a(@NonNull final com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull final String str, @NonNull final String str2) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.core.diskcache.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                OutputStream outputStreamAS = null;
                try {
                    a.C0435a c0435aBr = aVar.br(str2);
                    if (c0435aBr != null) {
                        outputStreamAS = c0435aBr.aS(0);
                        if (b.a(str, outputStreamAS, new a.C0442a())) {
                            c0435aBr.commit();
                        } else {
                            c0435aBr.abort();
                        }
                        aVar.flush();
                    }
                } catch (IOException unused) {
                } finally {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStreamAS);
                }
            }
        });
    }

    static boolean a(@NonNull com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull String str, @NonNull String str2, a.C0442a c0442a) {
        boolean z2 = false;
        OutputStream outputStreamAS = null;
        try {
            try {
                a.C0435a c0435aBr = aVar.br(str2);
                if (c0435aBr != null) {
                    outputStreamAS = c0435aBr.aS(0);
                    if (a(str, outputStreamAS, c0442a)) {
                        c0435aBr.commit();
                        z2 = true;
                    } else {
                        c0435aBr.abort();
                    }
                    aVar.flush();
                }
            } catch (IOException e2) {
                c0442a.msg = e2.getMessage();
            }
            return z2;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStreamAS);
        }
    }

    public static boolean a(String str, OutputStream outputStream, a.C0442a c0442a) {
        return com.kwad.sdk.core.network.kwai.a.a(str, outputStream, c0442a, -1);
    }
}
