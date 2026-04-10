package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bk;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ViewConstructor"})
public final class f extends com.kwad.components.core.video.a implements bk.a {
    private boolean DG;
    private View Ru;
    private boolean Rx;
    private final bk gH;
    private final AtomicBoolean mIsViewDetached;

    public interface a extends a.c {
        void onVideoPlayError(int i2, int i3);
    }

    public f(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, adTemplate, cVar);
        this.gH = new bk(this);
        this.mIsViewDetached = new AtomicBoolean(true);
        this.DG = false;
        this.Rx = false;
        this.Ru = this;
    }

    private void onViewAttached() {
        if (this.mIsViewDetached.getAndSet(false)) {
            com.kwad.sdk.core.d.b.i("InterstitialVideoPlayerController", "onViewAttached");
            this.gH.sendEmptyMessage(1);
        }
    }

    private void onViewDetached() {
        if (this.mIsViewDetached.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.b.i("InterstitialVideoPlayerController", "onViewDetached");
        this.gH.removeCallbacksAndMessages(null);
        release();
    }

    private void qQ() {
        this.DG = false;
    }

    @Override // com.kwad.sdk.utils.bk.a
    public final void a(Message message) {
        if (!this.DG && message.what == 1) {
            if (com.kwad.sdk.b.kwai.a.m(this.Ru, 70)) {
                qr();
            } else {
                qt();
            }
            this.gH.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.components.core.video.a
    protected final void eU() {
        if (this.Rx) {
            super.eU();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.b.i("InterstitialVideoPlayerController", "onAttachedToWindow");
        qQ();
        onViewAttached();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.b.i("InterstitialVideoPlayerController", "onDetachedFromWindow");
        onViewDetached();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.b.i("InterstitialVideoPlayerController", "onFinishTemporaryDetach");
        onViewAttached();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.b.i("InterstitialVideoPlayerController", "onStartTemporaryDetach");
        onViewDetached();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
    }

    @Override // com.kwad.components.core.video.a
    protected final void ql() {
        super.ql();
        ImageView imageView = this.nk;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.ksad_interstitial_video_play);
        }
        TextView textView = this.nl;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void qr() {
        super.qr();
    }

    @Override // com.kwad.components.core.video.a
    public final void qt() {
        super.qt();
    }

    @Override // com.kwad.components.core.video.a
    public final void release() {
        super.release();
        this.DG = true;
    }
}
