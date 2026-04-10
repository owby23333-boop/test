package com.king.zxing;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.king.zxing.camera.d;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: CaptureHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class h implements i, k, j, SurfaceHolder.Callback {
    private ViewfinderView A;
    private SurfaceHolder B;
    private View C;
    private Collection<BarcodeFormat> D;
    private Map<DecodeHintType, Object> E;
    private String F;
    private boolean G;
    private float I;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private int T;
    private int U;
    private p X;
    private boolean Y;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Activity f16499s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private CaptureHandler f16500t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private q f16501u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private com.king.zxing.camera.d f16502v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private o f16503w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private g f16504x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private f f16505y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private SurfaceView f16506z;
    private boolean H = true;
    private boolean J = true;
    private boolean K = false;
    private boolean L = false;
    private boolean M = true;
    private float S = 0.9f;
    private float V = 45.0f;
    private float W = 100.0f;

    public h(Activity activity, SurfaceView surfaceView, ViewfinderView viewfinderView, View view) {
        this.f16499s = activity;
        this.f16506z = surfaceView;
        this.A = viewfinderView;
        this.C = view;
    }

    private void g() {
        this.f16502v = new com.king.zxing.camera.d(this.f16499s);
        this.f16502v.a(this.R);
        this.f16502v.a(this.S);
        this.f16502v.b(this.T);
        this.f16502v.a(this.U);
        View view = this.C;
        if (view == null || !this.Y) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.king.zxing.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f16453s.a(view2);
            }
        });
        this.f16502v.a(new d.a() { // from class: com.king.zxing.c
            @Override // com.king.zxing.camera.d.a
            public final void a(boolean z2, boolean z3, float f2) {
                this.a.a(z2, z3, f2);
            }
        });
        this.f16502v.a(new d.b() { // from class: com.king.zxing.e
            @Override // com.king.zxing.camera.d.b
            public final void a(boolean z2) {
                this.a.a(z2);
            }
        });
    }

    public /* synthetic */ void a(com.google.zxing.h hVar, Bitmap bitmap, float f2) {
        this.f16503w.a();
        this.f16504x.i();
        b(hVar, bitmap, f2);
    }

    public void b() {
        this.B = this.f16506z.getHolder();
        this.G = false;
        this.f16503w = new o(this.f16499s);
        this.f16504x = new g(this.f16499s);
        this.f16505y = new f(this.f16499s);
        this.Y = this.f16499s.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
        g();
        this.f16501u = new q() { // from class: com.king.zxing.a
            @Override // com.king.zxing.q
            public final void a(com.google.zxing.h hVar, Bitmap bitmap, float f2) {
                this.a.a(hVar, bitmap, f2);
            }
        };
        this.f16504x.a(this.N);
        this.f16504x.b(this.O);
        this.f16505y.b(this.V);
        this.f16505y.a(this.W);
    }

    public void c() {
        this.f16503w.d();
    }

    public void d() {
        CaptureHandler captureHandler = this.f16500t;
        if (captureHandler != null) {
            captureHandler.e();
            this.f16500t = null;
        }
        this.f16503w.b();
        this.f16505y.a();
        this.f16504x.close();
        this.f16502v.a();
        if (!this.G) {
            this.B.removeCallback(this);
        }
        View view = this.C;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.C.setSelected(false);
        this.C.setVisibility(4);
    }

    public void e() {
        this.f16504x.j();
        this.f16503w.c();
        if (this.G) {
            a(this.B);
        } else {
            this.B.addCallback(this);
        }
        this.f16505y.a(this.f16502v);
    }

    public void f() {
        CaptureHandler captureHandler = this.f16500t;
        if (captureHandler != null) {
            captureHandler.f();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            com.king.zxing.r.b.c("*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (this.G) {
            return;
        }
        this.G = true;
        a(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.G = false;
    }

    public boolean a(MotionEvent motionEvent) {
        Camera cameraA;
        if (!this.H || !this.f16502v.g() || (cameraA = this.f16502v.e().a()) == null || motionEvent.getPointerCount() <= 1) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 2) {
            float fB = b(motionEvent);
            float f2 = this.I;
            if (fB > f2 + 6.0f) {
                a(true, cameraA);
            } else if (fB < f2 - 6.0f) {
                a(false, cameraA);
            }
            this.I = fB;
        } else if (action == 5) {
            this.I = b(motionEvent);
        }
        return true;
    }

    private float b(MotionEvent motionEvent) {
        float x2 = motionEvent.getX(0) - motionEvent.getX(1);
        float y2 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x2 * x2) + (y2 * y2));
    }

    public /* synthetic */ void a(View view) {
        com.king.zxing.camera.d dVar = this.f16502v;
        if (dVar != null) {
            dVar.b(!this.C.isSelected());
        }
    }

    public /* synthetic */ void a(boolean z2, boolean z3, float f2) {
        if (z3) {
            if (this.C.getVisibility() != 0) {
                this.C.setVisibility(0);
            }
        } else {
            if (z2 || this.C.getVisibility() != 0) {
                return;
            }
            this.C.setVisibility(4);
        }
    }

    public void b(com.google.zxing.h hVar, Bitmap bitmap, float f2) {
        a(hVar);
    }

    public /* synthetic */ void a(boolean z2) {
        this.C.setSelected(z2);
    }

    private void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null) {
            if (this.f16502v.g()) {
                com.king.zxing.r.b.c("initCamera() while already open -- late SurfaceView callback?");
                return;
            }
            try {
                this.f16502v.a(surfaceHolder);
                if (this.f16500t == null) {
                    this.f16500t = new CaptureHandler(this.f16499s, this.A, this.f16501u, this.D, this.E, this.F, this.f16502v);
                    this.f16500t.d(this.P);
                    this.f16500t.a(this.Q);
                    this.f16500t.b(this.J);
                    this.f16500t.c(this.K);
                    return;
                }
                return;
            } catch (IOException e2) {
                com.king.zxing.r.b.b(e2);
                return;
            } catch (RuntimeException e3) {
                com.king.zxing.r.b.a("Unexpected error initializing camera", e3);
                return;
            }
        }
        throw new IllegalStateException("No SurfaceHolder provided");
    }

    private void a(boolean z2, Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        if (parameters.isZoomSupported()) {
            int maxZoom = parameters.getMaxZoom();
            int zoom = parameters.getZoom();
            if (z2 && zoom < maxZoom) {
                zoom++;
            } else if (zoom > 0) {
                zoom--;
            }
            parameters.setZoom(zoom);
            camera.setParameters(parameters);
            return;
        }
        com.king.zxing.r.b.b("zoom not supported");
    }

    public void a(com.google.zxing.h hVar) {
        CaptureHandler captureHandler;
        final String strE = hVar.e();
        if (this.L) {
            p pVar = this.X;
            if (pVar != null) {
                pVar.onResultCallback(strE);
            }
            if (this.M) {
                f();
                return;
            }
            return;
        }
        if (this.N && (captureHandler = this.f16500t) != null) {
            captureHandler.postDelayed(new Runnable() { // from class: com.king.zxing.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16490s.a(strE);
                }
            }, 100L);
            return;
        }
        p pVar2 = this.X;
        if (pVar2 == null || !pVar2.onResultCallback(strE)) {
            Intent intent = new Intent();
            intent.putExtra(CaptureActivity.KEY_RESULT, strE);
            this.f16499s.setResult(-1, intent);
            this.f16499s.finish();
        }
    }

    public /* synthetic */ void a(String str) {
        p pVar = this.X;
        if (pVar == null || !pVar.onResultCallback(str)) {
            Intent intent = new Intent();
            intent.putExtra(CaptureActivity.KEY_RESULT, str);
            this.f16499s.setResult(-1, intent);
            this.f16499s.finish();
        }
    }

    public h a(p pVar) {
        this.X = pVar;
        return this;
    }

    public com.king.zxing.camera.d a() {
        return this.f16502v;
    }
}
