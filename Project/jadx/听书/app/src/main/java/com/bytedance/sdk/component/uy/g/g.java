package com.bytedance.sdk.component.uy.g;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.l;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class g extends l implements dl {
    private final HandlerThread g;

    g(HandlerThread handlerThread, l.z zVar) {
        super(handlerThread.getLooper(), zVar);
        this.g = handlerThread;
    }

    @Override // com.bytedance.sdk.component.uy.g.dl
    public void z() {
        removeCallbacksAndMessages(null);
        if (this.z != null) {
            this.z.clear();
            this.z = null;
        }
    }

    public void z(l.z zVar) {
        this.z = new WeakReference<>(zVar);
    }

    public void g() {
        HandlerThread handlerThread = this.g;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }
}
