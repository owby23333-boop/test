package com.king.zxing.camera;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;

/* JADX INFO: compiled from: PreviewCallback.java */
/* JADX INFO: loaded from: classes2.dex */
final class e implements Camera.PreviewCallback {
    private final b a;
    private Handler b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16484c;

    e(b bVar) {
        this.a = bVar;
    }

    void a(Handler handler, int i2) {
        this.b = handler;
        this.f16484c = i2;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point pointA = this.a.a();
        Handler handler = this.b;
        if (pointA == null || handler == null) {
            com.king.zxing.r.b.a("Got preview callback, but no handler or resolution available");
        } else {
            handler.obtainMessage(this.f16484c, pointA.x, pointA.y, bArr).sendToTarget();
            this.b = null;
        }
    }
}
