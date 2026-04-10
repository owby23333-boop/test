package com.amgcyo.cuttadon.sdk.self.video;

import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.NonNull;
import xyz.doikki.videoplayer.player.AbstractPlayer;
import xyz.doikki.videoplayer.render.IRenderView;

/* JADX INFO: compiled from: TikTokRenderView.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements IRenderView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final IRenderView f4202s;

    b(@NonNull IRenderView iRenderView) {
        this.f4202s = iRenderView;
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public void attachToPlayer(@NonNull AbstractPlayer abstractPlayer) {
        this.f4202s.attachToPlayer(abstractPlayer);
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public Bitmap doScreenShot() {
        return this.f4202s.doScreenShot();
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public View getView() {
        return this.f4202s.getView();
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public void release() {
        this.f4202s.release();
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public void setScaleType(int i2) {
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public void setVideoRotation(int i2) {
        this.f4202s.setVideoRotation(i2);
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public void setVideoSize(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f4202s.setVideoSize(i2, i3);
        if (i3 > i2) {
            this.f4202s.setScaleType(5);
        } else {
            this.f4202s.setScaleType(0);
        }
    }
}
