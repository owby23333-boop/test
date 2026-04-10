package com.yuewen;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.duokan.reader.ui.zxing.camera.FrontLightMode;
import com.duokan.reader.ui.zxing.camera.open.CameraFacing;

/* JADX INFO: loaded from: classes5.dex */
public final class ww {
    public static final String h = "CameraConfiguration";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19731b;
    public int c;
    public Point d;
    public Point e;
    public Point f;
    public Point g;

    public ww(Context context) {
        this.f19730a = context;
    }

    public final void a(Camera.Parameters parameters, boolean z, boolean z2) {
        xw.o(parameters, z);
        if (z2) {
            return;
        }
        xw.h(parameters, z);
    }

    public Point b() {
        return this.f;
    }

    public int c() {
        return this.f19731b;
    }

    public Point d() {
        return this.e;
    }

    public Point e() {
        return this.g;
    }

    public Point f() {
        return this.d;
    }

    public boolean g(Camera camera) {
        Camera.Parameters parameters;
        if (camera == null || (parameters = camera.getParameters()) == null) {
            return false;
        }
        String flashMode = parameters.getFlashMode();
        return "on".equals(flashMode) || "torch".equals(flashMode);
    }

    public void h(kd2 kd2Var) {
        int i;
        Camera.Parameters parameters = kd2Var.a().getParameters();
        Display defaultDisplay = ((WindowManager) this.f19730a.getSystemService(kl2.t9)).getDefaultDisplay();
        int rotation = defaultDisplay.getRotation();
        if (rotation == 0) {
            i = 0;
        } else if (rotation == 1) {
            i = 90;
        } else if (rotation == 2) {
            i = Opcodes.GETFIELD;
        } else if (rotation == 3) {
            i = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        } else {
            if (rotation % 90 != 0) {
                throw new IllegalArgumentException("Bad rotation: " + rotation);
            }
            i = (rotation + MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL) % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        }
        Log.i("CameraConfiguration", "Display at: " + i);
        int iC = kd2Var.c();
        Log.i("CameraConfiguration", "Camera at: " + iC);
        CameraFacing cameraFacingB = kd2Var.b();
        CameraFacing cameraFacing = CameraFacing.FRONT;
        if (cameraFacingB == cameraFacing) {
            iC = (360 - iC) % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
            Log.i("CameraConfiguration", "Front camera overriden to: " + iC);
        }
        this.c = ((iC + MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL) - i) % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        Log.i("CameraConfiguration", "Final display orientation: " + this.c);
        if (kd2Var.b() == cameraFacing) {
            Log.i("CameraConfiguration", "Compensating rotation for front camera");
            this.f19731b = (360 - this.c) % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        } else {
            this.f19731b = this.c;
        }
        Log.i("CameraConfiguration", "Clockwise rotation from display to camera: " + this.f19731b);
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.d = point;
        Log.i("CameraConfiguration", "Screen resolution in current orientation: " + this.d);
        this.e = xw.d(parameters, this.d);
        Log.i("CameraConfiguration", "Camera resolution: " + this.e);
        this.f = xw.d(parameters, this.d);
        Log.i("CameraConfiguration", "Best available preview size: " + this.f);
        Point point2 = this.d;
        boolean z = point2.x < point2.y;
        Point point3 = this.f;
        if (z == (point3.x < point3.y)) {
            this.g = point3;
        } else {
            Point point4 = this.f;
            this.g = new Point(point4.y, point4.x);
        }
        Log.i("CameraConfiguration", "Preview size on screen: " + this.g);
    }

    public final void i(Camera.Parameters parameters, boolean z) {
        a(parameters, FrontLightMode.readPref() == FrontLightMode.ON, z);
    }

    public void j(kd2 kd2Var, boolean z) {
        Camera cameraA = kd2Var.a();
        Camera.Parameters parameters = cameraA.getParameters();
        if (parameters == null) {
            Log.w("CameraConfiguration", "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        Log.i("CameraConfiguration", "Initial camera parameters: " + parameters.flatten());
        if (z) {
            Log.w("CameraConfiguration", "In camera config safe mode -- most settings will not be honored");
        }
        i(parameters, z);
        xw.k(parameters, true, true, z);
        if (!z) {
            xw.g(parameters);
            xw.p(parameters);
            xw.l(parameters);
            xw.n(parameters);
            parameters.setRecordingHint(true);
        }
        Point point = this.f;
        parameters.setPreviewSize(point.x, point.y);
        cameraA.setParameters(parameters);
        cameraA.setDisplayOrientation(this.c);
        Camera.Size previewSize = cameraA.getParameters().getPreviewSize();
        if (previewSize != null) {
            Point point2 = this.f;
            if (point2.x == previewSize.width && point2.y == previewSize.height) {
                return;
            }
            Log.w("CameraConfiguration", "Camera said it supported preview size " + this.f.x + 'x' + this.f.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height);
            Point point3 = this.f;
            point3.x = previewSize.width;
            point3.y = previewSize.height;
        }
    }

    public void k(Camera camera, boolean z) {
        Camera.Parameters parameters = camera.getParameters();
        a(parameters, z, false);
        camera.setParameters(parameters);
    }
}
