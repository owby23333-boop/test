package com.bytedance.sdk.openadsdk.core.multipro.aidl.bf;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.core.dt;
import com.bytedance.sdk.openadsdk.core.hb;

/* JADX INFO: loaded from: classes10.dex */
public class ga extends dt.e {
    private Handler bf = new Handler(Looper.getMainLooper());
    private TTRewardVideoAd.RewardAdInteractionListener e;

    public ga(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.e = rewardAdInteractionListener;
    }

    private Handler m() {
        Handler handler = this.bf;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.bf = handler2;
        return handler2;
    }

    private void zk() {
        this.e = null;
        this.bf = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dt
    public void bf() throws RemoteException {
        m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.ga.1
            @Override // java.lang.Runnable
            public void run() {
                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = ga.this.e;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onAdShow();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.dt
    public void d() throws RemoteException {
        m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.ga.2
            @Override // java.lang.Runnable
            public void run() {
                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = ga.this.e;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onAdVideoBarClick();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.dt
    public void ga() throws RemoteException {
        m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.ga.4
            @Override // java.lang.Runnable
            public void run() {
                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = ga.this.e;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onVideoComplete();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.dt
    public void p() throws RemoteException {
        m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.ga.6
            @Override // java.lang.Runnable
            public void run() {
                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = ga.this.e;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onSkippedVideo();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.dt
    public void tg() throws RemoteException {
        m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.ga.3
            @Override // java.lang.Runnable
            public void run() {
                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = ga.this.e;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onAdClose();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.dt
    public void vn() throws RemoteException {
        m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.ga.5
            @Override // java.lang.Runnable
            public void run() {
                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = ga.this.e;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onVideoError();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.dt
    public void e() throws RemoteException {
        zk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.dt
    public void e(final boolean z, final int i, final String str, final int i2, final String str2) throws RemoteException {
        m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.ga.7
            @Override // java.lang.Runnable
            public void run() {
                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = ga.this.e;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onRewardVerify(z, i, str, i2, str2);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.dt
    public void e(final boolean z, final int i, final Bundle bundle) {
        m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.ga.8
            @Override // java.lang.Runnable
            public void run() {
                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = ga.this.e;
                if (rewardAdInteractionListener == null || hb.e < 4400) {
                    return;
                }
                try {
                    rewardAdInteractionListener.onRewardArrived(z, i, bundle);
                } catch (AbstractMethodError unused) {
                    Log.e("RewardVideoListenerImpl", "onRewardArrived 未实现！");
                }
            }
        });
    }
}
