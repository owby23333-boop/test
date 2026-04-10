package com.kwad.sdk.core.videocache.b;

import android.content.Context;
import com.kwad.sdk.core.videocache.f;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static f anJ;

    public static f bl(Context context) {
        f fVar = anJ;
        if (fVar != null) {
            return fVar;
        }
        f fVarBm = bm(context);
        anJ = fVarBm;
        return fVarBm;
    }

    private static f bm(Context context) {
        return new f.a(context).T(104857600L).yK();
    }
}
