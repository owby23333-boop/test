package com.bytedance.sdk.openadsdk.core.multipro.aidl.bf;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.core.l;

/* JADX INFO: loaded from: classes10.dex */
public class d extends l.e {
    private Handler bf = new Handler(Looper.getMainLooper());
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e;

    public d(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.e = fullScreenVideoAdInteractionListener;
    }

    private void v() {
        this.e = null;
        this.bf = null;
    }

    private Handler zk() {
        Handler handler = this.bf;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.bf = handler2;
        return handler2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l
    public void bf() throws RemoteException {
        zk().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.d.1
            @Override // java.lang.Runnable
            public void run() {
                TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = d.this.e;
                if (fullScreenVideoAdInteractionListener != null) {
                    fullScreenVideoAdInteractionListener.onAdShow();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.l
    public void d() throws RemoteException {
        zk().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.d.2
            @Override // java.lang.Runnable
            public void run() {
                TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = d.this.e;
                if (fullScreenVideoAdInteractionListener != null) {
                    fullScreenVideoAdInteractionListener.onAdVideoBarClick();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.l
    public void ga() throws RemoteException {
        zk().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.d.4
            @Override // java.lang.Runnable
            public void run() {
                TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = d.this.e;
                if (fullScreenVideoAdInteractionListener != null) {
                    fullScreenVideoAdInteractionListener.onVideoComplete();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.l
    public void tg() throws RemoteException {
        zk().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.d.3
            @Override // java.lang.Runnable
            public void run() {
                TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = d.this.e;
                if (fullScreenVideoAdInteractionListener != null) {
                    fullScreenVideoAdInteractionListener.onAdClose();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.l
    public void vn() throws RemoteException {
        zk().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.d.5
            @Override // java.lang.Runnable
            public void run() {
                TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = d.this.e;
                if (fullScreenVideoAdInteractionListener != null) {
                    fullScreenVideoAdInteractionListener.onSkippedVideo();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.l
    public void e() throws RemoteException {
        v();
    }
}
