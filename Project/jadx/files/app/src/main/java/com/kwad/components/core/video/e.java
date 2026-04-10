package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.bk;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ViewConstructor"})
public final class e extends a implements bk.a {
    private View Ru;
    private boolean Rv;
    private boolean Rw;
    private final KsAdVideoPlayConfig dY;
    private final bk gH;
    private final AtomicBoolean mIsViewDetached;

    public e(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context, adTemplate, cVar);
        this.gH = new bk(this);
        this.mIsViewDetached = new AtomicBoolean(true);
        this.Rw = true;
        this.Ru = this;
        this.dY = ksAdVideoPlayConfig;
    }

    private void onViewAttached() {
        if (this.mIsViewDetached.getAndSet(false)) {
            com.kwad.sdk.core.d.b.i("FeedVideoPlayerController", "onViewAttached");
            this.gH.sendEmptyMessage(1);
        }
    }

    private boolean qM() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dY;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return af.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return af.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return kSAdVideoPlayConfigImpl.isDataFlowAutoStart() ? af.isNetworkConnected(this.mContext) : af.isWifiConnected(this.mContext);
            }
        }
        if (com.kwad.sdk.core.response.a.a.bG(this.mAdInfo)) {
            return af.isNetworkConnected(this.mContext);
        }
        if (com.kwad.sdk.core.response.a.a.bH(this.mAdInfo)) {
            return af.isWifiConnected(this.mContext);
        }
        return false;
    }

    @Override // com.kwad.sdk.utils.bk.a
    public final void a(Message message) {
        if (!this.Ql && message.what == 1) {
            if (!com.kwad.sdk.b.kwai.a.m(this.Ru, 30)) {
                qt();
            } else if (!this.Rv) {
                qr();
            }
            this.gH.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.b.i("FeedVideoPlayerController", "onAttachedToWindow");
        onViewAttached();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.b.i("FeedVideoPlayerController", "onDetachedFromWindow");
        onViewDetached();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.b.i("FeedVideoPlayerController", "onFinishTemporaryDetach");
        onViewAttached();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.b.i("FeedVideoPlayerController", "onStartTemporaryDetach");
        onViewDetached();
    }

    public final void onViewDetached() {
        if (this.mIsViewDetached.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.b.i("FeedVideoPlayerController", "onViewDetached");
        this.gH.removeCallbacksAndMessages(null);
        if (this.Rw) {
            release();
        } else {
            this.amO.pause();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
    }

    public final void qL() {
        this.gH.removeCallbacksAndMessages(null);
        if (this.Rw) {
            release();
        } else {
            this.amO.pause();
        }
    }

    public final void qN() {
        this.amO.pause();
        this.Rv = true;
    }

    public final void qO() {
        qr();
        this.Rv = false;
    }

    public final void qP() {
        this.Rv = false;
    }

    @Override // com.kwad.components.core.video.a
    protected final void qr() {
        if (!this.amO.isIdle()) {
            if (this.amO.isPaused() || this.amO.yC()) {
                qs();
                this.amO.restart();
                return;
            }
            return;
        }
        if (!af.isNetworkConnected(this.mContext)) {
            qn();
            return;
        }
        qo();
        if (!this.Ql && !qM() && !this.Qj) {
            qp();
        } else {
            qs();
            this.amO.start();
        }
    }

    public final void setAutoRelease(boolean z2) {
        this.Rw = z2;
    }
}
