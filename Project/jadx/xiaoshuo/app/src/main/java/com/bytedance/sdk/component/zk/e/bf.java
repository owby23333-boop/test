package com.bytedance.sdk.component.zk.e;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.za;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class bf extends za implements d {
    private final HandlerThread bf;

    public bf(HandlerThread handlerThread, za.e eVar) {
        super(handlerThread.getLooper(), eVar);
        this.bf = handlerThread;
    }

    public void bf() {
        HandlerThread handlerThread = this.bf;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    @Override // com.bytedance.sdk.component.zk.e.d
    public void e() {
        removeCallbacksAndMessages(null);
        WeakReference<za.e> weakReference = this.e;
        if (weakReference != null) {
            weakReference.clear();
            this.e = null;
        }
    }

    public void e(za.e eVar) {
        this.e = new WeakReference<>(eVar);
    }

    public void e(String str) {
        HandlerThread handlerThread = this.bf;
        if (handlerThread != null) {
            handlerThread.setName(str);
        }
    }
}
