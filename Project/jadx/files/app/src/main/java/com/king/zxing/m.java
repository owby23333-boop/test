package com.king.zxing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import java.io.ByteArrayOutputStream;
import java.util.Map;

/* JADX INFO: compiled from: DecodeHandler.java */
/* JADX INFO: loaded from: classes2.dex */
final class m extends Handler {
    private final Context a;
    private final com.king.zxing.camera.d b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CaptureHandler f16513c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f16516f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f16515e = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.zxing.e f16514d = new com.google.zxing.e();

    m(Context context, com.king.zxing.camera.d dVar, CaptureHandler captureHandler, Map<DecodeHintType, Object> map) {
        this.f16514d.a((Map<DecodeHintType, ?>) map);
        this.a = context;
        this.b = dVar;
        this.f16513c = captureHandler;
    }

    private boolean a() {
        Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x < point.y;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws NotFoundException {
        if (message == null || !this.f16515e) {
            return;
        }
        int i2 = message.what;
        if (i2 == R$id.decode) {
            a((byte[]) message.obj, message.arg1, message.arg2, a(), this.f16513c.d());
        } else if (i2 == R$id.quit) {
            this.f16515e = false;
            Looper.myLooper().quit();
        }
    }

    private void a(byte[] bArr, int i2, int i3, boolean z2, boolean z3) throws NotFoundException {
        com.google.zxing.h hVarA;
        boolean z4;
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.google.zxing.f fVarA = a(bArr, i2, i3, z2);
        com.google.zxing.h hVarA2 = null;
        if (fVarA != null) {
            try {
                hVarA = this.f16514d.a(new com.google.zxing.b(new com.google.zxing.common.i(fVarA)));
                z4 = false;
            } catch (Exception unused) {
                hVarA = null;
                z4 = true;
            }
            if (z4 && this.f16513c.c()) {
                try {
                    hVarA = this.f16514d.a(new com.google.zxing.b(new com.google.zxing.common.i(fVarA.d())));
                    z4 = false;
                } catch (Exception unused2) {
                    z4 = true;
                }
            }
            if (z4) {
                try {
                    hVarA = this.f16514d.a(new com.google.zxing.b(new com.google.zxing.common.g(fVarA)));
                    z4 = false;
                } catch (Exception unused3) {
                    z4 = true;
                }
            }
            if (z4 && z3) {
                com.google.zxing.f fVarA2 = a(bArr, i2, i3, !z2);
                if (fVarA2 != null) {
                    try {
                        fVarA = fVarA2;
                        hVarA2 = this.f16514d.a(new com.google.zxing.b(new com.google.zxing.common.i(fVarA2)));
                    } catch (Exception unused4) {
                        fVarA = fVarA2;
                        hVarA2 = hVarA;
                    }
                    this.f16514d.reset();
                }
                fVarA = fVarA2;
                hVarA2 = hVarA;
                this.f16514d.reset();
            } else {
                hVarA2 = hVarA;
                this.f16514d.reset();
            }
        }
        if (hVarA2 != null) {
            com.king.zxing.r.b.a("Found barcode in " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
            BarcodeFormat barcodeFormatA = hVarA2.a();
            CaptureHandler captureHandler = this.f16513c;
            if (captureHandler != null && captureHandler.b() && barcodeFormatA == BarcodeFormat.QR_CODE) {
                com.google.zxing.i[] iVarArrD = hVarA2.d();
                if (iVarArrD.length >= 3) {
                    if (a((int) Math.max(Math.max(com.google.zxing.i.a(iVarArrD[0], iVarArrD[1]), com.google.zxing.i.a(iVarArrD[1], iVarArrD[2])), com.google.zxing.i.a(iVarArrD[0], iVarArrD[2])), i2)) {
                        Message messageObtain = Message.obtain();
                        messageObtain.what = R$id.decode_succeeded;
                        messageObtain.obj = hVarA2;
                        if (this.f16513c.a()) {
                            Bundle bundle = new Bundle();
                            a(fVarA, bundle);
                            messageObtain.setData(bundle);
                        }
                        this.f16513c.sendMessageDelayed(messageObtain, 300L);
                        return;
                    }
                }
            }
            CaptureHandler captureHandler2 = this.f16513c;
            if (captureHandler2 != null) {
                Message messageObtain2 = Message.obtain(captureHandler2, R$id.decode_succeeded, hVarA2);
                if (this.f16513c.a()) {
                    Bundle bundle2 = new Bundle();
                    a(fVarA, bundle2);
                    messageObtain2.setData(bundle2);
                }
                messageObtain2.sendToTarget();
                return;
            }
            return;
        }
        CaptureHandler captureHandler3 = this.f16513c;
        if (captureHandler3 != null) {
            Message.obtain(captureHandler3, R$id.decode_failed).sendToTarget();
        }
    }

    private com.google.zxing.f a(byte[] bArr, int i2, int i3, boolean z2) {
        if (z2) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i4 = 0; i4 < i3; i4++) {
                for (int i5 = 0; i5 < i2; i5++) {
                    bArr2[(((i5 * i3) + i3) - i4) - 1] = bArr[(i4 * i2) + i5];
                }
            }
            return this.b.a(bArr2, i3, i2);
        }
        return this.b.a(bArr, i2, i3);
    }

    private static void a(com.google.zxing.f fVar, Bundle bundle) {
        int[] iArrI = fVar.i();
        int iH = fVar.h();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArrI, 0, iH, iH, fVar.g(), Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray("barcode_bitmap", byteArrayOutputStream.toByteArray());
        bundle.putFloat("barcode_scaled_factor", iH / fVar.c());
    }

    private boolean a(int i2, int i3) {
        Camera cameraA;
        if (this.f16516f > System.currentTimeMillis() - 1000) {
            return true;
        }
        if (i2 >= i3 / 5 || (cameraA = this.b.e().a()) == null) {
            return false;
        }
        Camera.Parameters parameters = cameraA.getParameters();
        if (parameters.isZoomSupported()) {
            int maxZoom = parameters.getMaxZoom();
            parameters.setZoom(Math.min(parameters.getZoom() + (maxZoom / 5), maxZoom));
            cameraA.setParameters(parameters);
            this.f16516f = System.currentTimeMillis();
            return true;
        }
        com.king.zxing.r.b.a("Zoom not supported");
        return false;
    }
}
