package com.anythink.expressad.exoplayer;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    private i() {
    }

    @Deprecated
    private static ad a(Context context, com.anythink.expressad.exoplayer.i.h hVar, p pVar) {
        return a(new f(context), hVar, pVar);
    }

    private static ad b(ab abVar, com.anythink.expressad.exoplayer.i.h hVar, p pVar, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar) {
        return new ad(abVar, hVar, pVar, gVar, (byte) 0);
    }

    @Deprecated
    private static ad a(Context context, com.anythink.expressad.exoplayer.i.h hVar, p pVar, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar) {
        return a(new f(context), hVar, pVar, gVar);
    }

    @Deprecated
    private static ad a(Context context, com.anythink.expressad.exoplayer.i.h hVar, p pVar, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, int i2) {
        return a(new f(context, i2), hVar, pVar, gVar);
    }

    @Deprecated
    private static ad a(Context context, com.anythink.expressad.exoplayer.i.h hVar, p pVar, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, int i2, long j2) {
        return a(new f(context, i2, j2), hVar, pVar, gVar);
    }

    private static ad a(Context context, com.anythink.expressad.exoplayer.i.h hVar) {
        return a(new f(context), hVar, new d());
    }

    private static ad a(ab abVar, com.anythink.expressad.exoplayer.i.h hVar) {
        return a(abVar, hVar, new d());
    }

    private static ad a(ab abVar, com.anythink.expressad.exoplayer.i.h hVar, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar) {
        return a(abVar, hVar, new d(), gVar);
    }

    public static ad a(ab abVar, com.anythink.expressad.exoplayer.i.h hVar, p pVar) {
        return new ad(abVar, hVar, pVar, null);
    }

    private static ad a(ab abVar, com.anythink.expressad.exoplayer.i.h hVar, p pVar, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar) {
        return new ad(abVar, hVar, pVar, gVar);
    }

    private static h a(y[] yVarArr, com.anythink.expressad.exoplayer.i.h hVar) {
        return new j(yVarArr, hVar, new d(), com.anythink.expressad.exoplayer.k.c.a);
    }

    private static h a(y[] yVarArr, com.anythink.expressad.exoplayer.i.h hVar, p pVar) {
        return new j(yVarArr, hVar, pVar, com.anythink.expressad.exoplayer.k.c.a);
    }
}
