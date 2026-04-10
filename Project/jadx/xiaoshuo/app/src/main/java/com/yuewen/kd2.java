package com.yuewen;

import android.hardware.Camera;
import com.duokan.reader.ui.zxing.camera.open.CameraFacing;

/* JADX INFO: loaded from: classes5.dex */
public final class kd2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Camera f13452b;
    public final CameraFacing c;
    public final int d;

    public kd2(int i, Camera camera, CameraFacing cameraFacing, int i2) {
        this.f13451a = i;
        this.f13452b = camera;
        this.c = cameraFacing;
        this.d = i2;
    }

    public Camera a() {
        return this.f13452b;
    }

    public CameraFacing b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public String toString() {
        return "Camera #" + this.f13451a + " : " + this.c + ',' + this.d;
    }
}
