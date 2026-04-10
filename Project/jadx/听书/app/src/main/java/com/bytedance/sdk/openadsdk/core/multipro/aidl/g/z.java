package com.bytedance.sdk.openadsdk.core.multipro.aidl.g;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.un.m;

/* JADX INFO: loaded from: classes2.dex */
public class z extends i.z {
    private m.z g;
    private Handler z = new Handler(Looper.getMainLooper());

    public z(m.z zVar) {
        this.g = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.i
    public void z() throws RemoteException {
        z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.z.1
            @Override // java.lang.Runnable
            public void run() {
                if (z.this.g != null) {
                    z.this.g.onDialogBtnYes();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.i
    public void g() throws RemoteException {
        z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.z.2
            @Override // java.lang.Runnable
            public void run() {
                if (z.this.g != null) {
                    z.this.g.onDialogBtnNo();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.i
    public void dl() throws RemoteException {
        z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.z.3
            @Override // java.lang.Runnable
            public void run() {
                if (z.this.g != null) {
                    z.this.g.onDialogCancel();
                }
            }
        });
    }

    private void z(Runnable runnable) {
        this.z.post(runnable);
    }
}
