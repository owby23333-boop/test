package com.bytedance.sdk.openadsdk.core.multipro.aidl.bf;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.core.pe;

/* JADX INFO: loaded from: classes10.dex */
public class vn extends pe.e {
    private Handler bf = new Handler(Looper.getMainLooper());
    private volatile TTAppDownloadListener e;

    public vn(TTAppDownloadListener tTAppDownloadListener) {
        this.e = tTAppDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(TTAppDownloadListener tTAppDownloadListener) {
        return tTAppDownloadListener != null;
    }

    private Handler tg() {
        Handler handler = this.bf;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.bf = handler2;
        return handler2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pe
    public void bf(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.e != null) {
            tg().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.vn.3
                @Override // java.lang.Runnable
                public void run() {
                    TTAppDownloadListener tTAppDownloadListener = vn.this.e;
                    if (vn.this.e(tTAppDownloadListener)) {
                        tTAppDownloadListener.onDownloadPaused(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pe
    public void d(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.e != null) {
            tg().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.vn.4
                @Override // java.lang.Runnable
                public void run() {
                    TTAppDownloadListener tTAppDownloadListener = vn.this.e;
                    if (vn.this.e(tTAppDownloadListener)) {
                        tTAppDownloadListener.onDownloadFailed(j, j2, str, str2);
                    }
                }
            });
        }
    }

    public void d() {
        this.e = null;
        this.bf = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pe
    public void e() throws RemoteException {
        if (this.e != null) {
            tg().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.vn.1
                @Override // java.lang.Runnable
                public void run() {
                    TTAppDownloadListener tTAppDownloadListener = vn.this.e;
                    if (vn.this.e(tTAppDownloadListener)) {
                        tTAppDownloadListener.onIdle();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pe
    public void e(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.e != null) {
            tg().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.vn.2
                @Override // java.lang.Runnable
                public void run() {
                    TTAppDownloadListener tTAppDownloadListener = vn.this.e;
                    if (vn.this.e(tTAppDownloadListener)) {
                        tTAppDownloadListener.onDownloadActive(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pe
    public void e(final long j, final String str, final String str2) throws RemoteException {
        if (this.e != null) {
            tg().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.vn.5
                @Override // java.lang.Runnable
                public void run() {
                    TTAppDownloadListener tTAppDownloadListener = vn.this.e;
                    if (vn.this.e(tTAppDownloadListener)) {
                        tTAppDownloadListener.onDownloadFinished(j, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pe
    public void e(final String str, final String str2) throws RemoteException {
        if (this.e != null) {
            tg().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.vn.6
                @Override // java.lang.Runnable
                public void run() {
                    TTAppDownloadListener tTAppDownloadListener = vn.this.e;
                    if (vn.this.e(tTAppDownloadListener)) {
                        String str3 = str;
                        if (str3 == null) {
                            str3 = "";
                        }
                        String str4 = str2;
                        tTAppDownloadListener.onInstalled(str3, str4 != null ? str4 : "");
                    }
                }
            });
        }
    }
}
