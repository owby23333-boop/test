package com.bykv.vk.openvk.component.video.api.renderview;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.component.video.api.renderview.bf;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class SSRenderSurfaceView extends SSSurfaceView implements SurfaceHolder.Callback, bf {
    private static final ArrayList<d> d = new ArrayList<>();
    private d bf;
    private WeakReference<e> e;
    private bf.e tg;

    public SSRenderSurfaceView(Context context) {
        super(context);
        com.bykv.vk.openvk.component.video.api.vn.d.bf("CSJ_VIDEO_SurfaceView", "SSRenderSurfaceView: ");
        e();
    }

    private void e() {
        d dVar = new d(this);
        this.bf = dVar;
        d.add(dVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.bf
    public View getView() {
        return this;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        bf.e eVar = this.tg;
        if (eVar != null) {
            eVar.e(i);
        }
    }

    public void setWindowVisibilityChangedListener(bf.e eVar) {
        this.tg = eVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        com.bykv.vk.openvk.component.video.api.vn.d.bf("CSJ_VIDEO_SurfaceView", "surfaceChanged: ");
        WeakReference<e> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.e.get().e(surfaceHolder, i, i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<e> weakReference = this.e;
        if (weakReference != null && weakReference.get() != null) {
            this.e.get().e(surfaceHolder);
        }
        com.bykv.vk.openvk.component.video.api.vn.d.bf("CSJ_VIDEO_SurfaceView", "surfaceCreated: ");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        com.bykv.vk.openvk.component.video.api.vn.d.bf("CSJ_VIDEO_SurfaceView", "surfaceDestroyed: ");
        WeakReference<e> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.e.get().bf(surfaceHolder);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.bf
    public void e(e eVar) {
        this.e = new WeakReference<>(eVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<d> it = d.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null && next.e() == null) {
                holder.removeCallback(next);
                it.remove();
            }
        }
        holder.addCallback(this.bf);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.bf
    public void e(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }
}
