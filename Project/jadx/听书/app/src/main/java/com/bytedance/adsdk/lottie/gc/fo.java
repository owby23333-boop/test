package com.bytedance.adsdk.lottie.gc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.adsdk.lottie.z.z.q;
import com.bytedance.sdk.component.utils.wp;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes2.dex */
public final class fo {
    private static final ThreadLocal<PathMeasure> z = new ThreadLocal<PathMeasure>() { // from class: com.bytedance.adsdk.lottie.gc.fo.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    };
    private static final ThreadLocal<Path> g = new ThreadLocal<Path>() { // from class: com.bytedance.adsdk.lottie.gc.fo.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };
    private static final ThreadLocal<Path> dl = new ThreadLocal<Path>() { // from class: com.bytedance.adsdk.lottie.gc.fo.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<float[]> f149a = new ThreadLocal<float[]>() { // from class: com.bytedance.adsdk.lottie.gc.fo.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public float[] initialValue() {
            return new float[4];
        }
    };
    private static final float gc = (float) (Math.sqrt(2.0d) / 2.0d);

    public static int z(float f, float f2, float f3, float f4) {
        int i = f != 0.0f ? (int) (f * 527.0f) : 17;
        if (f2 != 0.0f) {
            i = (int) (i * 31 * f2);
        }
        if (f3 != 0.0f) {
            i = (int) (i * 31 * f3);
        }
        return f4 != 0.0f ? (int) (i * 31 * f4) : i;
    }

    public static boolean z(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i < i4) {
            return false;
        }
        if (i > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        return i2 > i5 || i3 >= i6;
    }

    public static Path z(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            path.cubicTo(pointF3.x + pointF.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    public static void z(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static float z(Matrix matrix) {
        float[] fArr = f149a.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = gc;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static boolean g(Matrix matrix) {
        float[] fArr = f149a.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static void z(Path path, q qVar) {
        if (qVar == null || qVar.gc()) {
            return;
        }
        z(path, ((com.bytedance.adsdk.lottie.z.g.a) qVar.g()).fo() / 100.0f, ((com.bytedance.adsdk.lottie.z.g.a) qVar.dl()).fo() / 100.0f, ((com.bytedance.adsdk.lottie.z.g.a) qVar.a()).fo() / 360.0f);
    }

    public static void z(Path path, float f, float f2, float f3) {
        com.bytedance.adsdk.lottie.gc.z("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = z.get();
        Path path2 = g.get();
        Path path3 = dl.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            com.bytedance.adsdk.lottie.gc.g("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f2 - f) - 1.0f) < 0.01d) {
            com.bytedance.adsdk.lottie.gc.g("applyTrimPathIfNeeded");
            return;
        }
        float f4 = f * length;
        float f5 = f2 * length;
        float f6 = f3 * length;
        float fMin = Math.min(f4, f5) + f6;
        float fMax = Math.max(f4, f5) + f6;
        if (fMin >= length && fMax >= length) {
            fMin = gz.z(fMin, length);
            fMax = gz.z(fMax, length);
        }
        if (fMin < 0.0f) {
            fMin = gz.z(fMin, length);
        }
        if (fMax < 0.0f) {
            fMax = gz.z(fMax, length);
        }
        if (fMin == fMax) {
            path.reset();
            com.bytedance.adsdk.lottie.gc.g("applyTrimPathIfNeeded");
            return;
        }
        if (fMin >= fMax) {
            fMin -= length;
        }
        path2.reset();
        pathMeasure.getSegment(fMin, fMax, path2, true);
        if (fMax > length) {
            path3.reset();
            pathMeasure.getSegment(0.0f, fMax % length, path3, true);
            path2.addPath(path3);
        } else if (fMin < 0.0f) {
            path3.reset();
            pathMeasure.getSegment(fMin + length, length, path3, true);
            path2.addPath(path3);
        }
        path.set(path2);
        com.bytedance.adsdk.lottie.gc.g("applyTrimPathIfNeeded");
    }

    public static float z() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float z(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static Bitmap z(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }

    public static boolean z(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    public static void z(Canvas canvas, RectF rectF, Paint paint) {
        z(canvas, rectF, paint, 31);
    }

    public static void z(Canvas canvas, RectF rectF, Paint paint, int i) {
        com.bytedance.adsdk.lottie.gc.z("Utils#saveLayer");
        canvas.saveLayer(rectF, paint);
        com.bytedance.adsdk.lottie.gc.g("Utils#saveLayer");
    }

    public static float z(String str, String str2, int i) {
        if (str2 != null) {
            try {
                if (str2.contains("%")) {
                    return (Integer.parseInt(str2.substring(0, str2.length() - 1)) / 100.0f) * i;
                }
                return Integer.parseInt(str2) * z();
            } catch (Throwable th) {
                wp.z(th);
            }
        }
        if (TextUtils.equals("x", str) || TextUtils.equals("y", str)) {
            return 0.0f;
        }
        return i;
    }
}
