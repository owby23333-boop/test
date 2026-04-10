package com.king.zxing;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CaptureHandler extends Handler implements com.google.zxing.j {
    private boolean A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final q f16423s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final n f16424t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private State f16425u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final com.king.zxing.camera.d f16426v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final ViewfinderView f16427w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f16428x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f16429y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f16430z;

    private enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    CaptureHandler(Activity activity, ViewfinderView viewfinderView, q qVar, Collection<BarcodeFormat> collection, Map<DecodeHintType, Object> map, String str, com.king.zxing.camera.d dVar) {
        this.f16427w = viewfinderView;
        this.f16423s = qVar;
        this.f16424t = new n(activity, dVar, this, collection, map, str, this);
        this.f16424t.start();
        this.f16425u = State.SUCCESS;
        this.f16426v = dVar;
        dVar.h();
        f();
    }

    private com.google.zxing.i b(com.google.zxing.i iVar) {
        float fA;
        float fB;
        int iMax;
        Point pointF = this.f16426v.f();
        Point pointB = this.f16426v.b();
        int i2 = pointF.x;
        int i3 = pointF.y;
        if (i2 < i3) {
            fA = (iVar.a() * ((i2 * 1.0f) / pointB.y)) - (Math.max(pointF.x, pointB.y) / 2);
            fB = iVar.b() * ((i3 * 1.0f) / pointB.x);
            iMax = Math.min(pointF.y, pointB.x) / 2;
        } else {
            fA = (iVar.a() * ((i2 * 1.0f) / pointB.x)) - (Math.min(pointF.y, pointB.y) / 2);
            fB = iVar.b() * ((i3 * 1.0f) / pointB.y);
            iMax = Math.max(pointF.x, pointB.x) / 2;
        }
        return new com.google.zxing.i(fA, fB - iMax);
    }

    @Override // com.google.zxing.j
    public void a(com.google.zxing.i iVar) {
        if (this.f16427w != null) {
            this.f16427w.a(b(iVar));
        }
    }

    public boolean c() {
        return this.A;
    }

    public boolean d() {
        return this.f16428x;
    }

    public void e() {
        this.f16425u = State.DONE;
        this.f16426v.i();
        Message.obtain(this.f16424t.a(), R$id.quit).sendToTarget();
        try {
            this.f16424t.join(100L);
        } catch (InterruptedException unused) {
        }
        removeMessages(R$id.decode_succeeded);
        removeMessages(R$id.decode_failed);
    }

    public void f() {
        if (this.f16425u == State.SUCCESS) {
            this.f16425u = State.PREVIEW;
            this.f16426v.a(this.f16424t.a(), R$id.decode);
            ViewfinderView viewfinderView = this.f16427w;
            if (viewfinderView != null) {
                viewfinderView.a();
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == R$id.restart_preview) {
            f();
            return;
        }
        if (i2 != R$id.decode_succeeded) {
            if (i2 == R$id.decode_failed) {
                this.f16425u = State.PREVIEW;
                this.f16426v.a(this.f16424t.a(), R$id.decode);
                return;
            }
            return;
        }
        this.f16425u = State.SUCCESS;
        Bundle data = message.getData();
        float f2 = 1.0f;
        if (data != null) {
            byte[] byteArray = data.getByteArray("barcode_bitmap");
            bitmapCopy = byteArray != null ? BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, null).copy(Bitmap.Config.ARGB_8888, true) : null;
            f2 = data.getFloat("barcode_scaled_factor");
        }
        this.f16423s.a((com.google.zxing.h) message.obj, bitmapCopy, f2);
    }

    public void c(boolean z2) {
        this.A = z2;
    }

    public void d(boolean z2) {
        this.f16428x = z2;
    }

    public boolean a() {
        return this.f16429y;
    }

    public void a(boolean z2) {
        this.f16429y = z2;
    }

    public boolean b() {
        return this.f16430z;
    }

    public void b(boolean z2) {
        this.f16430z = z2;
    }
}
