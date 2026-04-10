package com.kwad.sdk.collector;

import android.os.Build;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.p;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static String bb(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return new String(com.kwad.sdk.core.kwai.c.vT().encode(m.k(p.P(new File(str)))));
            } catch (IOException e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        return null;
    }
}
