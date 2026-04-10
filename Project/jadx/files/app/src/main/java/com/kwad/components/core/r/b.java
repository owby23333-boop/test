package com.kwad.components.core.r;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.utils.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static volatile b PM;
    private com.kwad.sdk.utils.h PI;
    private List<WeakReference<OfflineOnAudioConflictListener>> PJ = new ArrayList();
    private boolean PK = false;
    private boolean PL = false;

    private b(@NonNull Context context) {
        init(context);
    }

    static /* synthetic */ boolean a(b bVar, boolean z2) {
        bVar.PL = true;
        return true;
    }

    public static b ar(@NonNull Context context) {
        if (PM == null) {
            synchronized (b.class) {
                if (PM == null) {
                    PM = new b(context.getApplicationContext());
                }
            }
        }
        return PM;
    }

    private void init(Context context) {
        this.PK = false;
        this.PI = new com.kwad.sdk.utils.h(context);
        this.PI.c(new h.a() { // from class: com.kwad.components.core.r.b.1
            @Override // com.kwad.sdk.utils.h.a
            public final void onAudioBeOccupied() {
                OfflineOnAudioConflictListener offlineOnAudioConflictListener;
                Iterator it = b.this.PJ.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        offlineOnAudioConflictListener.onAudioBeOccupied();
                    }
                }
                b.a(b.this, true);
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void onAudioBeReleased() {
                OfflineOnAudioConflictListener offlineOnAudioConflictListener;
                Iterator it = b.this.PJ.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        offlineOnAudioConflictListener.onAudioBeReleased();
                    }
                }
            }
        });
    }

    public final void a(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        this.PJ.add(new WeakReference<>(offlineOnAudioConflictListener));
    }

    public final boolean aI(boolean z2) {
        if (this.PI == null) {
            return false;
        }
        if (!z2 && this.PK) {
            return false;
        }
        this.PK = true;
        this.PL = false;
        return this.PI.CU();
    }

    public final void b(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        Iterator<WeakReference<OfflineOnAudioConflictListener>> it = this.PJ.iterator();
        while (it.hasNext()) {
            WeakReference<OfflineOnAudioConflictListener> next = it.next();
            if (next == null || next.get() == offlineOnAudioConflictListener) {
                it.remove();
            }
        }
    }

    public final boolean pY() {
        return this.PL;
    }

    public final boolean pZ() {
        return this.PK;
    }
}
