package com.king.zxing.camera;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.view.SurfaceHolder;
import androidx.annotation.FloatRange;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.google.zxing.f;
import java.io.IOException;

/* JADX INFO: compiled from: CameraManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private final Context a;
    private final com.king.zxing.camera.b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.king.zxing.camera.open.a f16467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.king.zxing.camera.a f16468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Rect f16469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Rect f16470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f16471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f16472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f16473i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f16474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f16475k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f16476l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f16477m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f16478n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f16479o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final e f16480p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private b f16481q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private a f16482r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f16483s;

    /* JADX INFO: compiled from: CameraManager.java */
    public interface a {
        void a(boolean z2, boolean z3, float f2);
    }

    /* JADX INFO: compiled from: CameraManager.java */
    public interface b {
        void a(boolean z2);
    }

    public d(Context context) {
        this.a = context.getApplicationContext();
        this.b = new com.king.zxing.camera.b(context);
        this.f16480p = new e(this.b);
    }

    public void a(SurfaceHolder surfaceHolder) throws IOException {
        int i2;
        com.king.zxing.camera.open.a aVarA = this.f16467c;
        if (aVarA == null) {
            aVarA = com.king.zxing.camera.open.b.a(this.f16473i);
            if (aVarA == null) {
                throw new IOException("Camera.open() failed to return object from driver");
            }
            this.f16467c = aVarA;
        }
        if (!this.f16471g) {
            this.f16471g = true;
            this.b.a(aVarA);
            int i3 = this.f16474j;
            if (i3 > 0 && (i2 = this.f16475k) > 0) {
                a(i3, i2);
                this.f16474j = 0;
                this.f16475k = 0;
            }
        }
        Camera cameraA = aVarA.a();
        Camera.Parameters parameters = cameraA.getParameters();
        String strFlatten = parameters == null ? null : parameters.flatten();
        try {
            this.b.a(aVarA, false);
        } catch (RuntimeException unused) {
            com.king.zxing.r.b.c("Camera rejected parameters. Setting only minimal safe-mode parameters");
            com.king.zxing.r.b.b("Resetting to saved camera params: " + strFlatten);
            if (strFlatten != null) {
                Camera.Parameters parameters2 = cameraA.getParameters();
                parameters2.unflatten(strFlatten);
                try {
                    cameraA.setParameters(parameters2);
                    this.b.a(aVarA, true);
                } catch (RuntimeException unused2) {
                    com.king.zxing.r.b.c("Camera rejected even safe-mode parameters! No configuration");
                }
            }
        }
        cameraA.setPreviewDisplay(surfaceHolder);
    }

    public synchronized void b(boolean z2) {
        com.king.zxing.camera.open.a aVar = this.f16467c;
        if (aVar != null && z2 != this.b.a(aVar.a())) {
            boolean z3 = this.f16468d != null;
            if (z3) {
                this.f16468d.b();
                this.f16468d = null;
            }
            this.f16483s = z2;
            this.b.a(aVar.a(), z2);
            if (z3) {
                this.f16468d = new com.king.zxing.camera.a(this.a, aVar.a());
                this.f16468d.a();
            }
            if (this.f16481q != null) {
                this.f16481q.a(z2);
            }
        }
    }

    public synchronized Rect c() {
        if (this.f16469e == null) {
            if (this.f16467c == null) {
                return null;
            }
            Point pointA = this.b.a();
            if (pointA == null) {
                return null;
            }
            int i2 = pointA.x;
            int i3 = pointA.y;
            if (this.f16476l) {
                this.f16469e = new Rect(0, 0, i2, i3);
            } else {
                int iMin = (int) (Math.min(i2, i3) * this.f16477m);
                int i4 = ((i2 - iMin) / 2) + this.f16479o;
                int i5 = ((i3 - iMin) / 2) + this.f16478n;
                this.f16469e = new Rect(i4, i5, i4 + iMin, iMin + i5);
            }
        }
        return this.f16469e;
    }

    public synchronized Rect d() {
        if (this.f16470f == null) {
            Rect rectC = c();
            if (rectC == null) {
                return null;
            }
            Rect rect = new Rect(rectC);
            Point pointA = this.b.a();
            Point pointB = this.b.b();
            if (pointA != null && pointB != null) {
                rect.left = (rect.left * pointA.y) / pointB.x;
                rect.right = (rect.right * pointA.y) / pointB.x;
                rect.top = (rect.top * pointA.x) / pointB.y;
                rect.bottom = (rect.bottom * pointA.x) / pointB.y;
                this.f16470f = rect;
            }
            return null;
        }
        return this.f16470f;
    }

    public com.king.zxing.camera.open.a e() {
        return this.f16467c;
    }

    public Point f() {
        return this.b.b();
    }

    public synchronized boolean g() {
        return this.f16467c != null;
    }

    public void h() {
        com.king.zxing.camera.open.a aVar = this.f16467c;
        if (aVar == null || this.f16472h) {
            return;
        }
        aVar.a().startPreview();
        this.f16472h = true;
        this.f16468d = new com.king.zxing.camera.a(this.a, aVar.a());
    }

    public void i() {
        com.king.zxing.camera.a aVar = this.f16468d;
        if (aVar != null) {
            aVar.b();
            this.f16468d = null;
        }
        com.king.zxing.camera.open.a aVar2 = this.f16467c;
        if (aVar2 == null || !this.f16472h) {
            return;
        }
        aVar2.a().stopPreview();
        this.f16480p.a(null, 0);
        this.f16472h = false;
    }

    public void b(int i2) {
        this.f16478n = i2;
    }

    public Point b() {
        return this.b.a();
    }

    public void a() {
        com.king.zxing.camera.open.a aVar = this.f16467c;
        if (aVar != null) {
            aVar.a().release();
            this.f16467c = null;
            this.f16469e = null;
            this.f16470f = null;
        }
        this.f16483s = false;
        b bVar = this.f16481q;
        if (bVar != null) {
            bVar.a(false);
        }
    }

    public synchronized void a(Handler handler, int i2) {
        com.king.zxing.camera.open.a aVar = this.f16467c;
        if (aVar != null && this.f16472h) {
            this.f16480p.a(handler, i2);
            aVar.a().setOneShotPreviewCallback(this.f16480p);
        }
    }

    public void a(boolean z2) {
        this.f16476l = z2;
    }

    public void a(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        this.f16477m = f2;
    }

    public void a(int i2) {
        this.f16479o = i2;
    }

    public synchronized void a(int i2, int i3) {
        if (this.f16471g) {
            Point pointB = this.b.b();
            if (i2 > pointB.x) {
                i2 = pointB.x;
            }
            if (i3 > pointB.y) {
                i3 = pointB.y;
            }
            int i4 = (pointB.x - i2) / 2;
            int i5 = (pointB.y - i3) / 2;
            this.f16469e = new Rect(i4, i5, i2 + i4, i3 + i5);
            com.king.zxing.r.b.a("Calculated manual framing rect: " + this.f16469e);
            this.f16470f = null;
        } else {
            this.f16474j = i2;
            this.f16475k = i3;
        }
    }

    public f a(byte[] bArr, int i2, int i3) {
        if (d() == null) {
            return null;
        }
        if (this.f16476l) {
            return new f(bArr, i2, i3, 0, 0, i2, i3, false);
        }
        int iMin = (int) (Math.min(i2, i3) * this.f16477m);
        return new f(bArr, i2, i3, ((i2 - iMin) / 2) + this.f16479o, ((i3 - iMin) / 2) + this.f16478n, iMin, iMin, false);
    }

    public void a(b bVar) {
        this.f16481q = bVar;
    }

    public void a(a aVar) {
        this.f16482r = aVar;
    }

    public void a(boolean z2, float f2) {
        a aVar = this.f16482r;
        if (aVar != null) {
            aVar.a(this.f16483s, z2, f2);
        }
    }
}
