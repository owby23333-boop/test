package com.king.zxing.camera.open;

import android.hardware.Camera;

/* JADX INFO: compiled from: OpenCamera.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private final int a;
    private final Camera b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CameraFacing f16488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16489d;

    public a(int i2, Camera camera, CameraFacing cameraFacing, int i3) {
        this.a = i2;
        this.b = camera;
        this.f16488c = cameraFacing;
        this.f16489d = i3;
    }

    public Camera a() {
        return this.b;
    }

    public CameraFacing b() {
        return this.f16488c;
    }

    public int c() {
        return this.f16489d;
    }

    public String toString() {
        return "Camera #" + this.a + " : " + this.f16488c + ',' + this.f16489d;
    }
}
