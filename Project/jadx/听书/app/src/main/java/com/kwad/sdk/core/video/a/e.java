package com.kwad.sdk.core.video.a;

import android.content.Context;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.av;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    private static boolean ZG = false;
    private static AtomicBoolean aKu = null;
    private static int aKv = -1;
    private static final AtomicBoolean aKw = new AtomicBoolean(false);
    private static final AtomicBoolean aKx = new AtomicBoolean(false);
    private static int aKy;

    public static int Ka() {
        return aKy;
    }

    public static boolean Kb() {
        AtomicBoolean atomicBoolean = aKu;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        aKu = atomicBoolean2;
        return atomicBoolean2.get();
    }

    public static boolean DH() {
        return aKx.get() || com.kwad.framework.a.a.MY.booleanValue();
    }

    public static c a(Context context, boolean z, boolean z2, boolean z3, int i) {
        boolean z4;
        c cVar;
        c cVar2;
        try {
            if (DH() && z2 && Kb()) {
                com.kwad.sdk.core.d.c.i("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                d dVar = new d(i);
                aKy = 2;
                dVar.bu(z);
                cVar2 = dVar;
            } else {
                com.kwad.sdk.core.d.c.i("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                b bVar = new b();
                aKy = 1;
                cVar2 = bVar;
            }
            z4 = false;
            cVar = cVar2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            if (!ZG) {
                ZG = true;
                com.kwad.sdk.service.d.gatherException(th);
            }
            b bVar2 = new b();
            aKy = 1;
            z4 = true;
            cVar = bVar2;
        }
        int iA = av.a(DH(), ServiceProvider.get(com.kwad.sdk.service.a.f.class) != null && ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bk(), z2, Kb(), z4, z3, cVar.getMediaPlayerType());
        com.kwad.sdk.core.d.c.T("KwaiPlayHelper", "player v=" + Integer.toBinaryString(iA));
        if (aKv != iA) {
            aKv = iA;
            dL(iA);
        }
        return cVar;
    }

    private static void dL(int i) {
        n nVar = new n(10212L);
        nVar.aHl = i;
        g.a(nVar);
    }
}
