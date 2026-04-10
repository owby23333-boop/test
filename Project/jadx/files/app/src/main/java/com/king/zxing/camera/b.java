package com.king.zxing.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.WindowManager;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.king.zxing.camera.open.CameraFacing;

/* JADX INFO: compiled from: CameraConfigurationManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class b {
    private final Context a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Point f16463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Point f16464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Point f16465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Point f16466g;

    b(Context context) {
        this.a = context;
    }

    void a(com.king.zxing.camera.open.a aVar) {
        int i2;
        Camera.Parameters parameters = aVar.a().getParameters();
        Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
        int rotation = defaultDisplay.getRotation();
        if (rotation == 0) {
            i2 = 0;
        } else if (rotation == 1) {
            i2 = 90;
        } else if (rotation == 2) {
            i2 = 180;
        } else if (rotation == 3) {
            i2 = SubsamplingScaleImageView.ORIENTATION_270;
        } else {
            if (rotation % 90 != 0) {
                throw new IllegalArgumentException("Bad rotation: " + rotation);
            }
            i2 = (rotation + 360) % 360;
        }
        com.king.zxing.r.b.b("Display at: " + i2);
        int iC = aVar.c();
        com.king.zxing.r.b.b("Camera at: " + iC);
        if (aVar.b() == CameraFacing.FRONT) {
            iC = (360 - iC) % 360;
            com.king.zxing.r.b.b("Front camera overriden to: " + iC);
        }
        this.f16462c = ((iC + 360) - i2) % 360;
        com.king.zxing.r.b.b("Final display orientation: " + this.f16462c);
        if (aVar.b() == CameraFacing.FRONT) {
            com.king.zxing.r.b.b("Compensating rotation for front camera");
            this.b = (360 - this.f16462c) % 360;
        } else {
            this.b = this.f16462c;
        }
        com.king.zxing.r.b.b("Clockwise rotation from display to camera: " + this.b);
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.f16463d = point;
        com.king.zxing.r.b.b("Screen resolution in current orientation: " + this.f16463d);
        this.f16464e = c.a(parameters, this.f16463d);
        com.king.zxing.r.b.b("Camera resolution: " + this.f16464e);
        this.f16465f = c.a(parameters, this.f16463d);
        com.king.zxing.r.b.b("Best available preview size: " + this.f16465f);
        Point point2 = this.f16463d;
        boolean z2 = point2.x < point2.y;
        Point point3 = this.f16465f;
        if (z2 == (point3.x < point3.y)) {
            this.f16466g = this.f16465f;
        } else {
            Point point4 = this.f16465f;
            this.f16466g = new Point(point4.y, point4.x);
        }
        com.king.zxing.r.b.b("Preview size on screen: " + this.f16466g);
    }

    Point b() {
        return this.f16463d;
    }

    void a(com.king.zxing.camera.open.a aVar, boolean z2) {
        Camera cameraA = aVar.a();
        Camera.Parameters parameters = cameraA.getParameters();
        if (parameters == null) {
            com.king.zxing.r.b.c("Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        com.king.zxing.r.b.b("Initial camera parameters: " + parameters.flatten());
        if (z2) {
            com.king.zxing.r.b.c("In camera config safe mode -- most settings will not be honored");
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a);
        if (parameters.isZoomSupported()) {
            parameters.setZoom(parameters.getMaxZoom() / 10);
        }
        a(parameters, defaultSharedPreferences, z2);
        c.a(parameters, defaultSharedPreferences.getBoolean("preferences_auto_focus", true), defaultSharedPreferences.getBoolean("preferences_disable_continuous_focus", true), z2);
        if (!z2) {
            if (defaultSharedPreferences.getBoolean("preferences_invert_scan", false)) {
                c.c(parameters);
            }
            if (!defaultSharedPreferences.getBoolean("preferences_disable_barcode_scene_mode", true)) {
                c.a(parameters);
            }
            if (!defaultSharedPreferences.getBoolean("preferences_disable_metering", true)) {
                c.e(parameters);
                c.b(parameters);
                c.d(parameters);
            }
            parameters.setRecordingHint(true);
        }
        Point point = this.f16465f;
        parameters.setPreviewSize(point.x, point.y);
        cameraA.setParameters(parameters);
        cameraA.setDisplayOrientation(this.f16462c);
        Camera.Size previewSize = cameraA.getParameters().getPreviewSize();
        if (previewSize != null) {
            Point point2 = this.f16465f;
            if (point2.x == previewSize.width && point2.y == previewSize.height) {
                return;
            }
            com.king.zxing.r.b.c("Camera said it supported preview size " + this.f16465f.x + 'x' + this.f16465f.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height);
            Point point3 = this.f16465f;
            point3.x = previewSize.width;
            point3.y = previewSize.height;
        }
    }

    Point a() {
        return this.f16464e;
    }

    boolean a(Camera camera) {
        Camera.Parameters parameters;
        if (camera == null || (parameters = camera.getParameters()) == null) {
            return false;
        }
        String flashMode = parameters.getFlashMode();
        return "on".equals(flashMode) || "torch".equals(flashMode);
    }

    void a(Camera camera, boolean z2) {
        Camera.Parameters parameters = camera.getParameters();
        a(parameters, z2, false);
        camera.setParameters(parameters);
    }

    private void a(Camera.Parameters parameters, SharedPreferences sharedPreferences, boolean z2) {
        a(parameters, FrontLightMode.a(sharedPreferences) == FrontLightMode.ON, z2);
    }

    private void a(Camera.Parameters parameters, boolean z2, boolean z3) {
        c.b(parameters, z2);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a);
        if (z3 || defaultSharedPreferences.getBoolean("preferences_disable_exposure", true)) {
            return;
        }
        c.a(parameters, z2);
    }
}
