package xyz.doikki.videoplayer.render;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import xyz.doikki.videoplayer.player.AbstractPlayer;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"ViewConstructor"})
public class TextureRenderView extends TextureView implements IRenderView, TextureView.SurfaceTextureListener {
    private final MeasureHelper mMeasureHelper;

    @Nullable
    private AbstractPlayer mMediaPlayer;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;

    public TextureRenderView(Context context) {
        super(context);
        this.mMeasureHelper = new MeasureHelper();
        setSurfaceTextureListener(this);
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public void attachToPlayer(@NonNull AbstractPlayer abstractPlayer) {
        this.mMediaPlayer = abstractPlayer;
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public Bitmap doScreenShot() {
        return getBitmap();
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public View getView() {
        return this;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int[] iArrDoMeasure = this.mMeasureHelper.doMeasure(i2, i3);
        setMeasuredDimension(iArrDoMeasure[0], iArrDoMeasure[1]);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        SurfaceTexture surfaceTexture2 = this.mSurfaceTexture;
        if (surfaceTexture2 != null) {
            setSurfaceTexture(surfaceTexture2);
            return;
        }
        this.mSurfaceTexture = surfaceTexture;
        this.mSurface = new Surface(surfaceTexture);
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            abstractPlayer.setSurface(this.mSurface);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public void release() {
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public void setScaleType(int i2) {
        this.mMeasureHelper.setScreenScale(i2);
        requestLayout();
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public void setVideoRotation(int i2) {
        this.mMeasureHelper.setVideoRotation(i2);
        setRotation(i2);
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public void setVideoSize(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.mMeasureHelper.setVideoSize(i2, i3);
        requestLayout();
    }
}
