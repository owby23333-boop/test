package com.bykv.vk.openvk.component.video.api.renderview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.component.video.api.renderview.bf;

/* JADX INFO: loaded from: classes.dex */
public class SSRenderTextureView extends TextureView implements TextureView.SurfaceTextureListener, bf {
    private bf.e bf;
    private e e;

    public SSRenderTextureView(Context context) {
        this(context, null);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.bf
    public void e(e eVar) {
        this.e = eVar;
        setSurfaceTextureListener(this);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.bf
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.bf
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            th.printStackTrace();
            if (com.bykv.vk.openvk.component.video.api.vn.d.bf()) {
                com.bykv.vk.openvk.component.video.api.vn.d.bf("CSJ_VIDEO_TextureView", "rethrow exception for debug & local_test, (TextureView)", th);
            }
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        com.bykv.vk.openvk.component.video.api.vn.d.bf("CSJ_VIDEO_TextureView", "onSurfaceTextureAvailable: ");
        e eVar = this.e;
        if (eVar != null) {
            eVar.e(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.bykv.vk.openvk.component.video.api.vn.d.bf("CSJ_VIDEO_TextureView", "onSurfaceTextureDestroyed: ");
        e eVar = this.e;
        if (eVar != null) {
            return eVar.e(surfaceTexture);
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        com.bykv.vk.openvk.component.video.api.vn.d.bf("CSJ_VIDEO_TextureView", "onSurfaceTextureSizeChanged: ");
        e eVar = this.e;
        if (eVar != null) {
            eVar.bf(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        e eVar = this.e;
        if (eVar != null) {
            eVar.bf(surfaceTexture);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        bf.e eVar = this.bf;
        if (eVar != null) {
            eVar.e(i);
        }
    }

    public void setWindowVisibilityChangedListener(bf.e eVar) {
        this.bf = eVar;
    }

    public SSRenderTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.bf
    public void e(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }
}
