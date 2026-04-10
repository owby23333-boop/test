package com.bytedance.sdk.openadsdk.core.multipro.aidl.g;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.fv;
import com.bytedance.sdk.openadsdk.core.gk;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends fv.z {
    private Handler g = new Handler(Looper.getMainLooper());
    private com.bytedance.sdk.openadsdk.sy.z.g.z.z z;

    public gc(com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar) {
        this.z = zVar;
    }

    private void fo() {
        this.z = null;
        this.g = null;
    }

    private Handler uy() {
        Handler handler = this.g;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.g = handler2;
        return handler2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.fv
    public void z() throws RemoteException {
        fo();
    }

    @Override // com.bytedance.sdk.openadsdk.core.fv
    public void g() throws RemoteException {
        uy().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.gc.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar = gc.this.z;
                if (zVar != null) {
                    zVar.z();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fv
    public void dl() throws RemoteException {
        uy().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.gc.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar = gc.this.z;
                if (zVar != null) {
                    zVar.g();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fv
    public void a() throws RemoteException {
        uy().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.gc.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar = gc.this.z;
                if (zVar != null) {
                    zVar.dl();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fv
    public void gc() throws RemoteException {
        uy().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.gc.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar = gc.this.z;
                if (zVar != null) {
                    zVar.a();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fv
    public void m() throws RemoteException {
        uy().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.gc.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar = gc.this.z;
                if (zVar != null) {
                    zVar.gc();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fv
    public void e() throws RemoteException {
        uy().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.gc.6
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar = gc.this.z;
                if (zVar != null) {
                    zVar.m();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fv
    public void z(final boolean z, final int i, final String str, final int i2, final String str2) throws RemoteException {
        uy().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.gc.7
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar = gc.this.z;
                if (zVar != null) {
                    zVar.z(z, i, str, i2, str2);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.fv
    public void z(final boolean z, final int i, final Bundle bundle) {
        uy().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.gc.8
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar = gc.this.z;
                if (zVar == null || gk.dl < 4400) {
                    return;
                }
                try {
                    zVar.z(z, i, bundle);
                } catch (AbstractMethodError unused) {
                    wp.a("RewardVideoListenerImpl", "onRewardArrived 未实现！");
                }
            }
        });
    }
}
