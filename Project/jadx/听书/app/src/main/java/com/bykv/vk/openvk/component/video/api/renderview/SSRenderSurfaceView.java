package com.bykv.vk.openvk.component.video.api.renderview;

import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.component.video.api.renderview.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class SSRenderSurfaceView extends SSSurfaceView implements SurfaceHolder.Callback, g {
    private static final ArrayList<dl> dl = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g.z f99a;
    private dl g;
    private WeakReference<z> z;

    @Override // com.bykv.vk.openvk.component.video.api.renderview.g
    public View getView() {
        return this;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.g
    public void z(z zVar) {
        this.z = new WeakReference<>(zVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<dl> it = dl.iterator();
        while (it.hasNext()) {
            dl next = it.next();
            if (next != null && next.z() == null) {
                holder.removeCallback(next);
                it.remove();
            }
        }
        holder.addCallback(this.g);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.g
    public void z(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<z> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null) {
            this.z.get().z(surfaceHolder);
        }
        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_SurfaceView", "surfaceCreated: ");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_SurfaceView", "surfaceChanged: ");
        WeakReference<z> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.z.get().z(surfaceHolder, i, i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_SurfaceView", "surfaceDestroyed: ");
        WeakReference<z> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.z.get().g(surfaceHolder);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(g.z zVar) {
        this.f99a = zVar;
    }
}
