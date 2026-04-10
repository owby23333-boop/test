package com.amgcyo.cuttadon.sdk.self.video;

import android.content.Context;
import com.danikula.videocache.f;

/* JADX INFO: compiled from: ProxyVideoCacheManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static f a;

    public static f a(Context context) {
        f fVar = a;
        if (fVar != null) {
            return fVar;
        }
        f fVarB = b(context);
        a = fVarB;
        return fVarB;
    }

    private static f b(Context context) {
        f.b bVar = new f.b(context);
        bVar.a(536870912L);
        return bVar.a();
    }
}
