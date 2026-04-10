package com.kwad.sdk.core.videocache.c;

import android.content.Context;
import com.kwad.sdk.core.videocache.f;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static f aLG;

    public static f bR(Context context) {
        return b(context, 0, 0);
    }

    public static f b(Context context, int i, int i2) {
        f fVar = aLG;
        if (fVar != null) {
            return fVar;
        }
        f fVarC = c(context, i, i2);
        aLG = fVarC;
        return fVarC;
    }

    private static f c(Context context, int i, int i2) {
        return new f.a(context).aJ(536870912L).dN(i).dO(i2).Kn();
    }
}
