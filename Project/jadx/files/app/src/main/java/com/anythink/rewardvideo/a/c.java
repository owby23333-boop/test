package com.anythink.rewardvideo.a;

import android.content.Context;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.n;
import com.anythink.rewardvideo.api.ATRewardVideoAutoEventListener;
import com.anythink.rewardvideo.api.ATRewardVideoExListener;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ATRewardVideoExListener {
    ATRewardVideoAutoEventListener a;

    protected c(ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener) {
        this.a = aTRewardVideoAutoEventListener;
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
    public final void onAgainReward(final ATAdInfo aTAdInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.c.11
            @Override // java.lang.Runnable
            public final void run() {
                ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener = c.this.a;
                if (aTRewardVideoAutoEventListener != null) {
                    aTRewardVideoAutoEventListener.onAgainReward(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
    public final void onDeeplinkCallback(final ATAdInfo aTAdInfo, final boolean z2) {
        n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener = c.this.a;
                if (aTRewardVideoAutoEventListener != null) {
                    aTRewardVideoAutoEventListener.onDeeplinkCallback(aTAdInfo, z2);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
    public final void onDownloadConfirm(final Context context, final ATAdInfo aTAdInfo, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.c.6
            @Override // java.lang.Runnable
            public final void run() {
                ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener = c.this.a;
                if (aTRewardVideoAutoEventListener != null) {
                    aTRewardVideoAutoEventListener.onDownloadConfirm(context, aTAdInfo, aTNetworkConfirmInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
    public final void onReward(final ATAdInfo aTAdInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.c.5
            @Override // java.lang.Runnable
            public final void run() {
                ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener = c.this.a;
                if (aTRewardVideoAutoEventListener != null) {
                    aTRewardVideoAutoEventListener.onReward(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
    public final void onRewardedVideoAdAgainPlayClicked(final ATAdInfo aTAdInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.c.10
            @Override // java.lang.Runnable
            public final void run() {
                ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener = c.this.a;
                if (aTRewardVideoAutoEventListener != null) {
                    aTRewardVideoAutoEventListener.onRewardedVideoAdAgainPlayClicked(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
    public final void onRewardedVideoAdAgainPlayEnd(final ATAdInfo aTAdInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.c.8
            @Override // java.lang.Runnable
            public final void run() {
                ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener = c.this.a;
                if (aTRewardVideoAutoEventListener != null) {
                    aTRewardVideoAutoEventListener.onRewardedVideoAdAgainPlayEnd(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
    public final void onRewardedVideoAdAgainPlayFailed(final AdError adError, final ATAdInfo aTAdInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.c.9
            @Override // java.lang.Runnable
            public final void run() {
                ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener = c.this.a;
                if (aTRewardVideoAutoEventListener != null) {
                    aTRewardVideoAutoEventListener.onRewardedVideoAdAgainPlayFailed(adError, aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
    public final void onRewardedVideoAdAgainPlayStart(final ATAdInfo aTAdInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.c.7
            @Override // java.lang.Runnable
            public final void run() {
                ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener = c.this.a;
                if (aTRewardVideoAutoEventListener != null) {
                    aTRewardVideoAutoEventListener.onRewardedVideoAdAgainPlayStart(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
    public final void onRewardedVideoAdClosed(final ATAdInfo aTAdInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.c.3
            @Override // java.lang.Runnable
            public final void run() {
                ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener = c.this.a;
                if (aTRewardVideoAutoEventListener != null) {
                    aTRewardVideoAutoEventListener.onRewardedVideoAdClosed(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
    public final void onRewardedVideoAdFailed(AdError adError) {
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
    public final void onRewardedVideoAdLoaded() {
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
    public final void onRewardedVideoAdPlayClicked(final ATAdInfo aTAdInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.c.4
            @Override // java.lang.Runnable
            public final void run() {
                ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener = c.this.a;
                if (aTRewardVideoAutoEventListener != null) {
                    aTRewardVideoAutoEventListener.onRewardedVideoAdPlayClicked(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
    public final void onRewardedVideoAdPlayEnd(final ATAdInfo aTAdInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.c.13
            @Override // java.lang.Runnable
            public final void run() {
                ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener = c.this.a;
                if (aTRewardVideoAutoEventListener != null) {
                    aTRewardVideoAutoEventListener.onRewardedVideoAdPlayEnd(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
    public final void onRewardedVideoAdPlayFailed(final AdError adError, final ATAdInfo aTAdInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.c.2
            @Override // java.lang.Runnable
            public final void run() {
                ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener = c.this.a;
                if (aTRewardVideoAutoEventListener != null) {
                    aTRewardVideoAutoEventListener.onRewardedVideoAdPlayFailed(adError, aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
    public final void onRewardedVideoAdPlayStart(final ATAdInfo aTAdInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.c.12
            @Override // java.lang.Runnable
            public final void run() {
                ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener = c.this.a;
                if (aTRewardVideoAutoEventListener != null) {
                    aTRewardVideoAutoEventListener.onRewardedVideoAdPlayStart(aTAdInfo);
                }
            }
        });
    }
}
