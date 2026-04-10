package com.kwad.sdk.core.video.kwai;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.report.q;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static boolean QB = false;
    private static AtomicBoolean amB = null;
    private static int amC = -1;
    private static int amE;
    private static final AtomicBoolean Xg = new AtomicBoolean(false);
    private static final AtomicBoolean amD = new AtomicBoolean(false);

    public static c a(@NonNull Context context, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        c cVar;
        c cVar2;
        try {
            if (tQ() && z3 && yz()) {
                com.kwad.sdk.core.d.b.i("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                d dVar = new d(context);
                amE = 2;
                dVar.aT(z2);
                cVar2 = dVar;
            } else {
                com.kwad.sdk.core.d.b.i("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                b bVar = new b();
                amE = 1;
                cVar2 = bVar;
            }
            z5 = false;
            cVar = cVar2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.e("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            if (!QB) {
                QB = true;
                com.kwad.sdk.service.b.gatherException(th);
            }
            b bVar2 = new b();
            amE = 1;
            z5 = true;
            cVar = bVar2;
        }
        int iA = al.a(tQ(), ServiceProvider.get(com.kwad.sdk.service.kwai.e.class) != null && ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getIsExternal(), z3, yz(), z5, z4, cVar.getMediaPlayerType());
        com.kwad.sdk.core.d.b.bL("player v=" + Integer.toBinaryString(iA));
        if (amC != iA) {
            amC = iA;
            bx(iA);
        }
        return cVar;
    }

    private static void bx(int i2) {
        q qVar = new q(10212L);
        qVar.aiQ = i2;
        h.a(qVar);
    }

    private static boolean tQ() {
        return amD.get() || com.kwad.b.kwai.a.Hz.booleanValue();
    }

    public static int yy() {
        return amE;
    }

    private static boolean yz() {
        AtomicBoolean atomicBoolean = amB;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        amB = atomicBoolean2;
        return atomicBoolean2.get();
    }
}
