package com.bykv.vk.openvk.component.video.api.renderview;

import android.view.SurfaceHolder;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class d implements SurfaceHolder.Callback {
    private final WeakReference<SurfaceHolder.Callback> e;

    public d(SurfaceHolder.Callback callback) {
        this.e = new WeakReference<>(callback);
    }

    public SurfaceHolder.Callback e() {
        return this.e.get();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        SurfaceHolder.Callback callback = this.e.get();
        if (callback != null) {
            callback.surfaceChanged(surfaceHolder, i, i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.e.get();
        if (callback != null) {
            callback.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.e.get();
        if (callback != null) {
            callback.surfaceDestroyed(surfaceHolder);
        }
    }
}
