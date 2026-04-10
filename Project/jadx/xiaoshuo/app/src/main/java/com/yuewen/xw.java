package com.yuewen;

import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes5.dex */
public final class xw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20146a = "CameraConfiguration";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f20147b = Pattern.compile(";");
    public static final int c = 153600;
    public static final float d = 0.5f;
    public static final float e = 0.0f;
    public static final double f = 0.15d;
    public static final int g = 10;
    public static final int h = 20;
    public static final int i = 400;

    public static List<Camera.Area> a(int i2) {
        int i3 = -i2;
        return Collections.singletonList(new Camera.Area(new Rect(i3, i3, i2, i2), 1));
    }

    public static String b(Camera.Parameters parameters) {
        return c(parameters.flatten());
    }

    public static String c(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(1000);
        sb.append("BOARD=");
        sb.append(Build.BOARD);
        sb.append('\n');
        sb.append("BRAND=");
        sb.append(Build.BRAND);
        sb.append('\n');
        sb.append("CPU_ABI=");
        sb.append(Build.CPU_ABI);
        sb.append('\n');
        sb.append("DEVICE=");
        sb.append(Build.DEVICE);
        sb.append('\n');
        sb.append("DISPLAY=");
        sb.append(Build.DISPLAY);
        sb.append('\n');
        sb.append("FINGERPRINT=");
        sb.append(Build.FINGERPRINT);
        sb.append('\n');
        sb.append("HOST=");
        sb.append(Build.HOST);
        sb.append('\n');
        sb.append("ID=");
        sb.append(Build.ID);
        sb.append('\n');
        sb.append("MANUFACTURER=");
        sb.append(Build.MANUFACTURER);
        sb.append('\n');
        sb.append("MODEL=");
        sb.append(Build.MODEL);
        sb.append('\n');
        sb.append("PRODUCT=");
        sb.append(Build.PRODUCT);
        sb.append('\n');
        sb.append("TAGS=");
        sb.append(Build.TAGS);
        sb.append('\n');
        sb.append("TIME=");
        sb.append(Build.TIME);
        sb.append('\n');
        sb.append("TYPE=");
        sb.append(Build.TYPE);
        sb.append('\n');
        sb.append("USER=");
        sb.append(Build.USER);
        sb.append('\n');
        sb.append("VERSION.CODENAME=");
        sb.append(Build.VERSION.CODENAME);
        sb.append('\n');
        sb.append("VERSION.INCREMENTAL=");
        sb.append(Build.VERSION.INCREMENTAL);
        sb.append('\n');
        sb.append("VERSION.RELEASE=");
        sb.append(Build.VERSION.RELEASE);
        sb.append('\n');
        sb.append("VERSION.SDK_INT=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append('\n');
        if (charSequence != null) {
            String[] strArrSplit = f20147b.split(charSequence);
            Arrays.sort(strArrSplit);
            for (String str : strArrSplit) {
                sb.append(str);
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    public static Point d(Camera.Parameters parameters, Point point) {
        Camera.Size size;
        Iterator<Camera.Size> it;
        String str;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        String str2 = "Parameters contained no preview size!";
        if (supportedPreviewSizes == null) {
            Log.w("CameraConfiguration", "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        if (Log.isLoggable("CameraConfiguration", 4)) {
            StringBuilder sb = new StringBuilder();
            for (Camera.Size size2 : supportedPreviewSizes) {
                sb.append(size2.width);
                sb.append('x');
                sb.append(size2.height);
                sb.append(' ');
            }
            Log.i("CameraConfiguration", "Supported preview sizes: " + ((Object) sb));
        }
        double d2 = ((double) point.x) / ((double) point.y);
        Iterator<Camera.Size> it2 = supportedPreviewSizes.iterator();
        Camera.Size size3 = null;
        int i2 = 0;
        while (it2.hasNext()) {
            Camera.Size next = it2.next();
            int i3 = next.width;
            int i4 = next.height;
            int i5 = i3 * i4;
            if (i5 < 153600) {
                it = it2;
                str = str2;
                size = size3;
            } else {
                boolean z = i3 < i4;
                int i6 = z ? i3 : i4;
                size = size3;
                int i7 = z ? i4 : i3;
                it = it2;
                str = str2;
                if (Math.abs((((double) i6) / ((double) i7)) - d2) <= 0.15d) {
                    if (i6 == point.x && i7 == point.y) {
                        Point point2 = new Point(i3, i4);
                        Log.i("CameraConfiguration", "Found preview size exactly matching screen size: " + point2);
                        return point2;
                    }
                    if (i5 > i2) {
                        size3 = next;
                        i2 = i5;
                    }
                }
                str2 = str;
                it2 = it;
            }
            size3 = size;
            str2 = str;
            it2 = it;
        }
        String str3 = str2;
        Camera.Size size4 = size3;
        if (size4 != null) {
            Point point3 = new Point(size4.width, size4.height);
            Log.i("CameraConfiguration", "Using largest suitable preview size: " + point3);
            return point3;
        }
        Camera.Size previewSize2 = parameters.getPreviewSize();
        if (previewSize2 == null) {
            throw new IllegalStateException(str3);
        }
        Point point4 = new Point(previewSize2.width, previewSize2.height);
        Log.i("CameraConfiguration", "No suitable preview sizes, using default: " + point4);
        return point4;
    }

    public static String e(String str, Collection<String> collection, String... strArr) {
        Log.i("CameraConfiguration", "Requesting " + str + " value from among: " + Arrays.toString(strArr));
        Log.i("CameraConfiguration", "Supported " + str + " values: " + collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    Log.i("CameraConfiguration", "Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        Log.i("CameraConfiguration", "No supported values match");
        return null;
    }

    public static Integer f(Camera.Parameters parameters, double d2) {
        List<Integer> zoomRatios = parameters.getZoomRatios();
        Log.i("CameraConfiguration", "Zoom ratios: " + zoomRatios);
        int maxZoom = parameters.getMaxZoom();
        if (zoomRatios == null || zoomRatios.isEmpty() || zoomRatios.size() != maxZoom + 1) {
            Log.w("CameraConfiguration", "Invalid zoom ratios!");
            return null;
        }
        double d3 = d2 * 100.0d;
        double d4 = Double.POSITIVE_INFINITY;
        int i2 = 0;
        for (int i3 = 0; i3 < zoomRatios.size(); i3++) {
            double dAbs = Math.abs(((double) zoomRatios.get(i3).intValue()) - d3);
            if (dAbs < d4) {
                i2 = i3;
                d4 = dAbs;
            }
        }
        Log.i("CameraConfiguration", "Chose zoom ratio of " + (((double) zoomRatios.get(i2).intValue()) / 100.0d));
        return Integer.valueOf(i2);
    }

    public static void g(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            Log.i("CameraConfiguration", "Barcode scene mode already set");
            return;
        }
        String strE = e("scene mode", parameters.getSupportedSceneModes(), "barcode");
        if (strE != null) {
            parameters.setSceneMode(strE);
        }
    }

    public static void h(Camera.Parameters parameters, boolean z) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (minExposureCompensation != 0 || maxExposureCompensation != 0) {
            if (exposureCompensationStep > 0.0f) {
                int iRound = Math.round((z ? 0.0f : 0.5f) / exposureCompensationStep);
                float f2 = exposureCompensationStep * iRound;
                int iMax = Math.max(Math.min(iRound, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == iMax) {
                    Log.i("CameraConfiguration", "Exposure compensation already set to " + iMax + " / " + f2);
                    return;
                }
                Log.i("CameraConfiguration", "Setting exposure compensation to " + iMax + " / " + f2);
                parameters.setExposureCompensation(iMax);
                return;
            }
        }
        Log.i("CameraConfiguration", "Camera does not support exposure compensation");
    }

    public static void i(Camera.Parameters parameters) {
        j(parameters, 10, 20);
    }

    public static void j(Camera.Parameters parameters, int i2, int i3) {
        int[] next;
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        Log.i("CameraConfiguration", "Supported FPS ranges: " + s(supportedPreviewFpsRange));
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.isEmpty()) {
            return;
        }
        Iterator<int[]> it = supportedPreviewFpsRange.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            int i4 = next[0];
            int i5 = next[1];
            if (i4 >= i2 * 1000 && i5 <= i3 * 1000) {
                break;
            }
        }
        if (next == null) {
            Log.i("CameraConfiguration", "No suitable FPS range?");
            return;
        }
        int[] iArr = new int[2];
        parameters.getPreviewFpsRange(iArr);
        if (Arrays.equals(iArr, next)) {
            Log.i("CameraConfiguration", "FPS range already set to " + Arrays.toString(next));
            return;
        }
        Log.i("CameraConfiguration", "Setting FPS range to " + Arrays.toString(next));
        parameters.setPreviewFpsRange(next[0], next[1]);
    }

    public static void k(Camera.Parameters parameters, boolean z, boolean z2, boolean z3) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String strE = z ? (z3 || z2) ? e("focus mode", supportedFocusModes, "auto") : e("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto") : null;
        if (!z3 && strE == null) {
            strE = e("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (strE != null) {
            if (!strE.equals(parameters.getFocusMode())) {
                parameters.setFocusMode(strE);
                return;
            }
            Log.i("CameraConfiguration", "Focus mode already set to " + strE);
        }
    }

    public static void l(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() <= 0) {
            Log.i("CameraConfiguration", "Device does not support focus areas");
            return;
        }
        Log.i("CameraConfiguration", "Old focus areas: " + r(parameters.getFocusAreas()));
        List<Camera.Area> listA = a(400);
        Log.i("CameraConfiguration", "Setting focus area to : " + r(listA));
        parameters.setFocusAreas(listA);
    }

    public static void m(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            Log.i("CameraConfiguration", "Negative effect already set");
            return;
        }
        String strE = e("color effect", parameters.getSupportedColorEffects(), "negative");
        if (strE != null) {
            parameters.setColorEffect(strE);
        }
    }

    public static void n(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() <= 0) {
            Log.i("CameraConfiguration", "Device does not support metering areas");
            return;
        }
        Log.i("CameraConfiguration", "Old metering areas: " + parameters.getMeteringAreas());
        List<Camera.Area> listA = a(400);
        Log.i("CameraConfiguration", "Setting metering area to : " + r(listA));
        parameters.setMeteringAreas(listA);
    }

    public static void o(Camera.Parameters parameters, boolean z) {
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        String strE = z ? e("flash mode", supportedFlashModes, "torch", "on") : e("flash mode", supportedFlashModes, DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        if (strE != null) {
            if (strE.equals(parameters.getFlashMode())) {
                Log.i("CameraConfiguration", "Flash mode already set to " + strE);
                return;
            }
            Log.i("CameraConfiguration", "Setting flash mode to " + strE);
            parameters.setFlashMode(strE);
        }
    }

    public static void p(Camera.Parameters parameters) {
        if (!parameters.isVideoStabilizationSupported()) {
            Log.i("CameraConfiguration", "This device does not support video stabilization");
        } else if (parameters.getVideoStabilization()) {
            Log.i("CameraConfiguration", "Video stabilization already enabled");
        } else {
            Log.i("CameraConfiguration", "Enabling video stabilization...");
            parameters.setVideoStabilization(true);
        }
    }

    public static void q(Camera.Parameters parameters, double d2) {
        if (!parameters.isZoomSupported()) {
            Log.i("CameraConfiguration", "Zoom is not supported");
            return;
        }
        Integer numF = f(parameters, d2);
        if (numF == null) {
            return;
        }
        if (parameters.getZoom() == numF.intValue()) {
            Log.i("CameraConfiguration", "Zoom is already set to " + numF);
            return;
        }
        Log.i("CameraConfiguration", "Setting zoom to " + numF);
        parameters.setZoom(numF.intValue());
    }

    public static String r(Iterable<Camera.Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Camera.Area area : iterable) {
            sb.append(area.rect);
            sb.append(':');
            sb.append(area.weight);
            sb.append(' ');
        }
        return sb.toString();
    }

    public static String s(Collection<int[]> collection) {
        if (collection == null || collection.isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator<int[]> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(Arrays.toString(it.next()));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
