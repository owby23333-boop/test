package com.king.zxing.camera.open;

import android.hardware.Camera;

/* JADX INFO: compiled from: OpenCameraInterface.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static a a(int i2) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            com.king.zxing.r.b.c("No cameras!");
            return null;
        }
        if (i2 >= numberOfCameras) {
            com.king.zxing.r.b.c("Requested camera does not exist: " + i2);
            return null;
        }
        if (i2 <= -1) {
            i2 = 0;
            while (i2 < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if (CameraFacing.values()[cameraInfo.facing] == CameraFacing.BACK) {
                    break;
                }
                i2++;
            }
            if (i2 == numberOfCameras) {
                com.king.zxing.r.b.b("No camera facing " + CameraFacing.BACK + "; returning camera #0");
                i2 = 0;
            }
        }
        com.king.zxing.r.b.b("Opening camera #" + i2);
        Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo2);
        Camera cameraOpen = Camera.open(i2);
        if (cameraOpen == null) {
            return null;
        }
        return new a(i2, cameraOpen, CameraFacing.values()[cameraInfo2.facing], cameraInfo2.orientation);
    }
}
