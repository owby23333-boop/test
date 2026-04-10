package com.kwad.components.core.h;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.offline.api.core.imageplayer.IImagePlayer;
import com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements IImagePlayer {
    private c QQ = new c();

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void prepareToPlay() {
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void setEnableCache(boolean z) {
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final FrameLayout getImagePlayerView(Context context) {
        return this.QQ.getImagePlayerView(context);
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void setRadius(float f, float f2, float f3, float f4) {
        this.QQ.setRadius(f, f2, f3, f4);
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void setURLs(List<String> list) {
        this.QQ.setURLs(list);
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void setDuration(long j) {
        this.QQ.E(j * 1000);
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void setImageResize(int i) {
        if (i == 0) {
            this.QQ.setImageScaleType(ImageView.ScaleType.FIT_CENTER);
            return;
        }
        if (i == 1) {
            this.QQ.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (i == 2) {
            this.QQ.setImageScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            if (i != 3) {
                return;
            }
            this.QQ.setImageScaleType(ImageView.ScaleType.CENTER);
        }
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void setVerticalGravity(int i) {
        this.QQ.setVerticalGravity(i);
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void setHorizontalGravity(int i) {
        this.QQ.setHorizontalGravity(i);
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void play() {
        this.QQ.play();
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void pause() {
        this.QQ.pause();
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void resume() {
        this.QQ.resume();
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void stop() {
        this.QQ.stop();
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void registerMediaPlayStateListener(OfflineMediaPlayStateListener offlineMediaPlayStateListener) {
        this.QQ.c(com.kwad.components.core.o.b.c.d.a(offlineMediaPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void unregisterMediaPlayStateListener(OfflineMediaPlayStateListener offlineMediaPlayStateListener) {
        this.QQ.d(com.kwad.components.core.o.b.c.d.a(offlineMediaPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void destroy() {
        this.QQ.destroy();
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void setSpeed(float f) {
        this.QQ.setSpeed(f);
    }
}
