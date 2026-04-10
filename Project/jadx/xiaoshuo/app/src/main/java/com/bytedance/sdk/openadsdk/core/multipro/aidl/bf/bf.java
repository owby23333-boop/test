package com.bytedance.sdk.openadsdk.core.multipro.aidl.bf;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.a.p;
import com.bytedance.sdk.openadsdk.core.w;

/* JADX INFO: loaded from: classes10.dex */
public class bf extends w.e {
    private p.e bf;
    private Handler e = new Handler(Looper.getMainLooper());

    public bf(p.e eVar) {
        this.bf = eVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w
    public void e() throws RemoteException {
        e(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.bf.1
            @Override // java.lang.Runnable
            public void run() {
                if (bf.this.bf != null) {
                    bf.this.bf.e();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.w
    public void e(final String str) throws RemoteException {
        e(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.bf.2
            @Override // java.lang.Runnable
            public void run() {
                if (bf.this.bf != null) {
                    bf.this.bf.e(str);
                }
            }
        });
    }

    private void e(Runnable runnable) {
        if (this.e == null) {
            this.e = new Handler(Looper.getMainLooper());
        }
        this.e.post(runnable);
    }
}
