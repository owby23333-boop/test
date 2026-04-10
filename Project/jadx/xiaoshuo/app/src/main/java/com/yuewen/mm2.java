package com.yuewen;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

/* JADX INFO: loaded from: classes5.dex */
public final class mm2 implements Camera.PreviewCallback {
    public static final String d = "mm2";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ww f14403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f14404b;
    public int c;

    public mm2(ww wwVar) {
        this.f14403a = wwVar;
    }

    public void a(Handler handler, int i) {
        this.f14404b = handler;
        this.c = i;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point pointD = this.f14403a.d();
        Handler handler = this.f14404b;
        if (pointD == null || handler == null) {
            Log.d(d, "Got preview callback, but no handler or resolution available");
        } else {
            handler.obtainMessage(this.c, pointD.x, pointD.y, bArr).sendToTarget();
            this.f14404b = null;
        }
    }
}
