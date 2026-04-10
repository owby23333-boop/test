package com.bytedance.adsdk.lottie.vn;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.d.bf.t;
import com.bytedance.adsdk.lottie.e.e.wu;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.yuewen.w51;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class p {
    private static final PointF e = new PointF();

    private static int bf(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static boolean d(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static float e(float f, float f2, @FloatRange(from = w51.l, to = 1.0d) float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int e(int i, int i2, @FloatRange(from = w51.l, to = 1.0d) float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static float bf(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static PointF e(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void e(t tVar, Path path) {
        path.reset();
        PointF pointFE = tVar.e();
        path.moveTo(pointFE.x, pointFE.y);
        e.set(pointFE.x, pointFE.y);
        for (int i = 0; i < tVar.d().size(); i++) {
            com.bytedance.adsdk.lottie.d.e eVar = tVar.d().get(i);
            PointF pointFE2 = eVar.e();
            PointF pointFBf = eVar.bf();
            PointF pointFD = eVar.d();
            PointF pointF = e;
            if (pointFE2.equals(pointF) && pointFBf.equals(pointFD)) {
                path.lineTo(pointFD.x, pointFD.y);
            } else {
                path.cubicTo(pointFE2.x, pointFE2.y, pointFBf.x, pointFBf.y, pointFD.x, pointFD.y);
            }
            pointF.set(pointFD.x, pointFD.y);
        }
        if (tVar.bf()) {
            path.close();
        }
    }

    public static int e(float f, float f2) {
        return e((int) f, (int) f2);
    }

    private static int e(int i, int i2) {
        return i - (i2 * bf(i, i2));
    }

    public static int e(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static void e(com.bytedance.adsdk.lottie.d.ga gaVar, int i, List<com.bytedance.adsdk.lottie.d.ga> list, com.bytedance.adsdk.lottie.d.ga gaVar2, wu wuVar) {
        if (gaVar.d(wuVar.bf(), i)) {
            list.add(gaVar2.e(wuVar.bf()).e(wuVar));
        }
    }
}
