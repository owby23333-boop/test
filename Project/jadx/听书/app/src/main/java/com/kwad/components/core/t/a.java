package com.kwad.components.core.t;

import android.content.Context;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.utils.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static volatile a YF;
    private com.kwad.sdk.utils.i YB;
    private List<WeakReference<OfflineOnAudioConflictListener>> YC = new ArrayList();
    private boolean YD = false;
    private boolean YE = false;

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.YE = true;
        return true;
    }

    private a(Context context) {
        init(context);
    }

    public static a aC(Context context) {
        if (YF == null) {
            synchronized (a.class) {
                if (YF == null) {
                    YF = new a(context.getApplicationContext());
                }
            }
        }
        return YF;
    }

    private void init(Context context) {
        this.YD = false;
        com.kwad.sdk.utils.i iVar = new com.kwad.sdk.utils.i(context);
        this.YB = iVar;
        iVar.c(new i.a() { // from class: com.kwad.components.core.t.a.1
            @Override // com.kwad.sdk.utils.i.a
            public final void onAudioBeOccupied() {
                Iterator it = a.this.YC.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null) {
                        it.remove();
                    } else {
                        OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                        if (offlineOnAudioConflictListener != null) {
                            offlineOnAudioConflictListener.onAudioBeOccupied();
                        } else {
                            it.remove();
                        }
                    }
                }
                a.a(a.this, true);
            }

            @Override // com.kwad.sdk.utils.i.a
            public final void onAudioBeReleased() {
                Iterator it = a.this.YC.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null) {
                        it.remove();
                    } else {
                        OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                        if (offlineOnAudioConflictListener != null) {
                            offlineOnAudioConflictListener.onAudioBeReleased();
                        } else {
                            it.remove();
                        }
                    }
                }
            }
        });
    }

    public final void a(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        this.YC.add(new WeakReference<>(offlineOnAudioConflictListener));
    }

    public final void b(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        Iterator<WeakReference<OfflineOnAudioConflictListener>> it = this.YC.iterator();
        while (it.hasNext()) {
            WeakReference<OfflineOnAudioConflictListener> next = it.next();
            if (next == null || next.get() == offlineOnAudioConflictListener) {
                it.remove();
            }
        }
    }

    public final boolean aQ(boolean z) {
        com.kwad.sdk.utils.i iVar = this.YB;
        if (iVar == null) {
            return false;
        }
        if (!z && this.YD) {
            return false;
        }
        this.YD = true;
        this.YE = false;
        return iVar.PF();
    }

    public final boolean sW() {
        return this.YE;
    }

    public final boolean sX() {
        return this.YD;
    }
}
