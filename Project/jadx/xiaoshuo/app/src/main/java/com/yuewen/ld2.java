package com.yuewen;

import android.hardware.Camera;
import android.util.Log;
import com.duokan.reader.ui.zxing.camera.open.CameraFacing;

/* JADX INFO: loaded from: classes5.dex */
public final class ld2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13895a = "com.yuewen.ld2";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f13896b = -1;

    public static kd2 a(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(f13895a, "No cameras!");
            return null;
        }
        if (i >= numberOfCameras) {
            Log.w(f13895a, "Requested camera does not exist: " + i);
            return null;
        }
        if (i <= -1) {
            i = 0;
            int i2 = 0;
            while (i2 < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if (CameraFacing.values()[cameraInfo.facing] == CameraFacing.BACK) {
                    break;
                }
                i2++;
            }
            if (i2 == numberOfCameras) {
                Log.i(f13895a, "No camera facing " + CameraFacing.BACK + "; returning camera #0");
            } else {
                i = i2;
            }
        }
        Log.i(f13895a, "Opening camera #" + i);
        Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo2);
        Camera cameraOpen = Camera.open(i);
        if (cameraOpen == null) {
            return null;
        }
        return new kd2(i, cameraOpen, CameraFacing.values()[cameraInfo2.facing], cameraInfo2.orientation);
    }
}
