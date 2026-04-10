package com.bykv.vk.component.ttvideo.player;

import android.view.SurfaceHolder;

/* JADX INFO: loaded from: classes.dex */
public interface ISurfaceListener {
    void onSurfaceChanged(SurfaceHolder surfaceHolder);

    void onSurfaceCreated(SurfaceHolder surfaceHolder);

    void onSurfaceDestroyed(SurfaceHolder surfaceHolder);
}
