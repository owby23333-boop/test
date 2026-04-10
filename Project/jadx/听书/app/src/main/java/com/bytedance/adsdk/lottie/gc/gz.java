package com.bytedance.adsdk.lottie.gc;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.model.g.v;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    private static final PointF z = new PointF();

    public static boolean dl(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static float z(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int z(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static PointF z(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void z(v vVar, Path path) {
        path.reset();
        PointF pointFZ = vVar.z();
        path.moveTo(pointFZ.x, pointFZ.y);
        z.set(pointFZ.x, pointFZ.y);
        for (int i = 0; i < vVar.dl().size(); i++) {
            com.bytedance.adsdk.lottie.model.z zVar = vVar.dl().get(i);
            PointF pointFZ2 = zVar.z();
            PointF pointFG = zVar.g();
            PointF pointFDl = zVar.dl();
            PointF pointF = z;
            if (pointFZ2.equals(pointF) && pointFG.equals(pointFDl)) {
                path.lineTo(pointFDl.x, pointFDl.y);
            } else {
                path.cubicTo(pointFZ2.x, pointFZ2.y, pointFG.x, pointFG.y, pointFDl.x, pointFDl.y);
            }
            pointF.set(pointFDl.x, pointFDl.y);
        }
        if (vVar.g()) {
            path.close();
        }
    }

    static int z(float f, float f2) {
        return z((int) f, (int) f2);
    }

    private static int z(int i, int i2) {
        return i - (i2 * g(i, i2));
    }

    private static int g(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int z(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static float g(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }
}
