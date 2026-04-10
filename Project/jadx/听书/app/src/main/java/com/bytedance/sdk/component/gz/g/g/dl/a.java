package com.bytedance.sdk.component.gz.g.g.dl;

import android.os.HandlerThread;

/* JADX INFO: loaded from: classes2.dex */
public class a extends HandlerThread {
    private gc z;

    public a() {
        super("csj_openlog");
    }

    public void z(gc gcVar) {
        this.z = gcVar;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        gc gcVar = this.z;
        if (gcVar != null) {
            gcVar.dl();
        }
    }
}
