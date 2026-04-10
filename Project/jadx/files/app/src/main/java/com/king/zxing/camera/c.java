package com.king.zxing.camera;

import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import anet.channel.entity.ConnType;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: CameraConfigurationUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    static {
        Pattern.compile(";");
    }

    public static void a(Camera.Parameters parameters, boolean z2, boolean z3, boolean z4) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String strA = z2 ? (z4 || z3) ? a("focus mode", supportedFocusModes, ConnType.PK_AUTO) : a("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", ConnType.PK_AUTO) : null;
        if (!z4 && strA == null) {
            strA = a("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (strA != null) {
            if (!strA.equals(parameters.getFocusMode())) {
                parameters.setFocusMode(strA);
                return;
            }
            com.king.zxing.r.b.a("Focus mode already set to " + strA);
        }
    }

    public static void b(Camera.Parameters parameters, boolean z2) {
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        String strA = z2 ? a("flash mode", supportedFlashModes, "torch", "on") : a("flash mode", supportedFlashModes, "off");
        if (strA != null) {
            if (strA.equals(parameters.getFlashMode())) {
                com.king.zxing.r.b.a("Flash mode already set to " + strA);
                return;
            }
            com.king.zxing.r.b.a("Setting flash mode to " + strA);
            parameters.setFlashMode(strA);
        }
    }

    public static void c(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            com.king.zxing.r.b.a("Negative effect already set");
            return;
        }
        String strA = a("color effect", parameters.getSupportedColorEffects(), "negative");
        if (strA != null) {
            parameters.setColorEffect(strA);
        }
    }

    public static void d(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() <= 0) {
            com.king.zxing.r.b.a("Device does not support metering areas");
            return;
        }
        com.king.zxing.r.b.a("Old metering areas: " + parameters.getMeteringAreas());
        List<Camera.Area> listA = a(TbsListener.ErrorCode.INFO_CODE_BASE);
        com.king.zxing.r.b.a("Setting metering area to : " + a(listA));
        parameters.setMeteringAreas(listA);
    }

    public static void e(Camera.Parameters parameters) {
        if (!parameters.isVideoStabilizationSupported()) {
            com.king.zxing.r.b.a("This device does not support video stabilization");
        } else if (parameters.getVideoStabilization()) {
            com.king.zxing.r.b.a("Video stabilization already enabled");
        } else {
            com.king.zxing.r.b.a("Enabling video stabilization...");
            parameters.setVideoStabilization(true);
        }
    }

    public static void a(Camera.Parameters parameters, boolean z2) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (minExposureCompensation != 0 || maxExposureCompensation != 0) {
            if (exposureCompensationStep > 0.0f) {
                int iRound = Math.round((z2 ? 0.0f : 1.5f) / exposureCompensationStep);
                float f2 = exposureCompensationStep * iRound;
                int iMax = Math.max(Math.min(iRound, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == iMax) {
                    com.king.zxing.r.b.a("Exposure compensation already set to " + iMax + " / " + f2);
                    return;
                }
                com.king.zxing.r.b.a("Setting exposure compensation to " + iMax + " / " + f2);
                parameters.setExposureCompensation(iMax);
                return;
            }
        }
        com.king.zxing.r.b.a("Camera does not support exposure compensation");
    }

    public static void b(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() > 0) {
            com.king.zxing.r.b.a("Old focus areas: " + a(parameters.getFocusAreas()));
            List<Camera.Area> listA = a(TbsListener.ErrorCode.INFO_CODE_BASE);
            com.king.zxing.r.b.a("Setting focus area to : " + a(listA));
            parameters.setFocusAreas(listA);
            return;
        }
        com.king.zxing.r.b.a("Device does not support focus areas");
    }

    private static List<Camera.Area> a(int i2) {
        int i3 = -i2;
        return Collections.singletonList(new Camera.Area(new Rect(i3, i3, i2, i2), 1));
    }

    public static void a(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            com.king.zxing.r.b.a("Barcode scene mode already set");
            return;
        }
        String strA = a("scene mode", parameters.getSupportedSceneModes(), "barcode");
        if (strA != null) {
            parameters.setSceneMode(strA);
        }
    }

    public static Point a(Camera.Parameters parameters, Point point) {
        double d2;
        double d3;
        int i2;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            com.king.zxing.r.b.c("Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        if (com.king.zxing.r.b.b()) {
            StringBuilder sb = new StringBuilder();
            for (Camera.Size size : supportedPreviewSizes) {
                sb.append(size.width);
                sb.append('x');
                sb.append(size.height);
                sb.append(' ');
            }
            com.king.zxing.r.b.a("Supported preview sizes: " + ((Object) sb));
        }
        int i3 = point.x;
        int i4 = point.y;
        if (i3 < i4) {
            double d4 = i3;
            double d5 = i4;
            Double.isNaN(d4);
            Double.isNaN(d5);
            d2 = d4 / d5;
        } else {
            double d6 = i4;
            double d7 = i3;
            Double.isNaN(d6);
            Double.isNaN(d7);
            d2 = d6 / d7;
        }
        com.king.zxing.r.b.a("screenAspectRatio: " + d2);
        Camera.Size size2 = null;
        char c2 = 0;
        int i5 = 0;
        for (Camera.Size size3 : supportedPreviewSizes) {
            int i6 = size3.width;
            int i7 = size3.height;
            int i8 = i6 * i7;
            if (i8 < 153600) {
                d3 = d2;
                i2 = i5;
            } else {
                boolean z2 = i6 < i7;
                int i9 = z2 ? i6 : i7;
                int i10 = z2 ? i7 : i6;
                Object[] objArr = new Object[2];
                objArr[c2] = Integer.valueOf(i9);
                objArr[1] = Integer.valueOf(i10);
                com.king.zxing.r.b.a(String.format("maybeFlipped:%d * %d", objArr));
                d3 = d2;
                double d8 = i9;
                i2 = i5;
                double d9 = i10;
                Double.isNaN(d8);
                Double.isNaN(d9);
                double d10 = d8 / d9;
                com.king.zxing.r.b.a("aspectRatio: " + d10);
                double dAbs = Math.abs(d10 - d3);
                com.king.zxing.r.b.a("distortion: " + dAbs);
                if (dAbs <= 0.05d) {
                    if (i9 == point.x && i10 == point.y) {
                        Point point2 = new Point(i6, i7);
                        com.king.zxing.r.b.a("Found preview size exactly matching screen size: " + point2);
                        return point2;
                    }
                    if (i8 > i2) {
                        size2 = size3;
                        i5 = i8;
                    }
                }
                d2 = d3;
                c2 = 0;
            }
            i5 = i2;
            d2 = d3;
            c2 = 0;
        }
        if (size2 != null) {
            Point point3 = new Point(size2.width, size2.height);
            com.king.zxing.r.b.a("Using largest suitable preview size: " + point3);
            return point3;
        }
        Camera.Size previewSize2 = parameters.getPreviewSize();
        if (previewSize2 != null) {
            Point point4 = new Point(previewSize2.width, previewSize2.height);
            com.king.zxing.r.b.a("No suitable preview sizes, using default: " + point4);
            return point4;
        }
        throw new IllegalStateException("Parameters contained no preview size!");
    }

    private static String a(String str, Collection<String> collection, String... strArr) {
        com.king.zxing.r.b.a("Requesting " + str + " value from among: " + Arrays.toString(strArr));
        com.king.zxing.r.b.a("Supported " + str + " values: " + collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    com.king.zxing.r.b.a("Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        com.king.zxing.r.b.a("No supported values match");
        return null;
    }

    private static String a(Iterable<Camera.Area> iterable) {
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
}
