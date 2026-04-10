package com.bytedance.sdk.openadsdk.core.multipro.aidl.g;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.js;

/* JADX INFO: loaded from: classes2.dex */
public class m extends js.z {
    private Handler g = new Handler(Looper.getMainLooper());
    private volatile com.bytedance.sdk.openadsdk.core.kb.g.z z;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(com.bytedance.sdk.openadsdk.core.kb.g.z zVar) {
        return zVar != null;
    }

    private Handler a() {
        Handler handler = this.g;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.g = handler2;
        return handler2;
    }

    public m(com.bytedance.sdk.openadsdk.core.kb.g.z zVar) {
        this.z = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.js
    public void z() throws RemoteException {
        if (this.z != null) {
            a().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.m.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.kb.g.z zVar = m.this.z;
                    if (m.this.z(zVar)) {
                        zVar.z();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.js
    public void z(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.z != null) {
            a().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.m.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.kb.g.z zVar = m.this.z;
                    if (m.this.z(zVar)) {
                        zVar.z(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.js
    public void g(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.z != null) {
            a().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.m.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.kb.g.z zVar = m.this.z;
                    if (m.this.z(zVar)) {
                        zVar.g(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.js
    public void dl(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.z != null) {
            a().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.m.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.kb.g.z zVar = m.this.z;
                    if (m.this.z(zVar)) {
                        zVar.dl(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.js
    public void z(final long j, final String str, final String str2) throws RemoteException {
        if (this.z != null) {
            a().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.m.5
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.kb.g.z zVar = m.this.z;
                    if (m.this.z(zVar)) {
                        zVar.z(j, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.js
    public void z(final String str, final String str2) throws RemoteException {
        if (this.z != null) {
            a().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.m.6
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.kb.g.z zVar = m.this.z;
                    if (m.this.z(zVar)) {
                        String str3 = str;
                        if (str3 == null) {
                            str3 = "";
                        }
                        String str4 = str2;
                        zVar.z(str3, str4 != null ? str4 : "");
                    }
                }
            });
        }
    }

    public void dl() {
        this.z = null;
        this.g = null;
    }
}
