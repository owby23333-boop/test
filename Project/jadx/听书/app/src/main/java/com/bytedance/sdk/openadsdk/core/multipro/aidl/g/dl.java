package com.bytedance.sdk.openadsdk.core.multipro.aidl.g;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.pf;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends pf.z {
    private Handler g = new Handler(Looper.getMainLooper());
    private com.bytedance.sdk.openadsdk.zw.z.g.z.z z;

    public dl(com.bytedance.sdk.openadsdk.zw.z.g.z.z zVar) {
        this.z = zVar;
    }

    private void gz() {
        this.z = null;
        this.g = null;
    }

    private Handler fo() {
        Handler handler = this.g;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.g = handler2;
        return handler2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pf
    public void z() throws RemoteException {
        gz();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pf
    public void g() throws RemoteException {
        fo().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.dl.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.zw.z.g.z.z zVar = dl.this.z;
                if (zVar != null) {
                    zVar.z();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.pf
    public void dl() throws RemoteException {
        fo().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.dl.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.zw.z.g.z.z zVar = dl.this.z;
                if (zVar != null) {
                    zVar.g();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.pf
    public void a() throws RemoteException {
        fo().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.dl.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.zw.z.g.z.z zVar = dl.this.z;
                if (zVar != null) {
                    zVar.dl();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.pf
    public void gc() throws RemoteException {
        fo().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.dl.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.zw.z.g.z.z zVar = dl.this.z;
                if (zVar != null) {
                    zVar.a();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.pf
    public void m() throws RemoteException {
        fo().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.dl.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.zw.z.g.z.z zVar = dl.this.z;
                if (zVar != null) {
                    zVar.gc();
                }
            }
        });
    }
}
