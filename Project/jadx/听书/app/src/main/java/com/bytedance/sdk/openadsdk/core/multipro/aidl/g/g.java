package com.bytedance.sdk.openadsdk.core.multipro.aidl.g;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.un.e;
import com.bytedance.sdk.openadsdk.core.v;

/* JADX INFO: loaded from: classes2.dex */
public class g extends v.z {
    private e.z g;
    private Handler z = new Handler(Looper.getMainLooper());

    public g(e.z zVar) {
        this.g = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.v
    public void z() throws RemoteException {
        z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.g != null) {
                    g.this.g.onGranted();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.v
    public void z(final String str) throws RemoteException {
        z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.g.2
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.g != null) {
                    g.this.g.onDenied(str);
                }
            }
        });
    }

    private void z(Runnable runnable) {
        if (this.z == null) {
            this.z = new Handler(Looper.getMainLooper());
        }
        this.z.post(runnable);
    }
}
