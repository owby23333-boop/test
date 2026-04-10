package com.bytedance.adsdk.lottie.a;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
class tb {
    private static SparseArray<WeakReference<Interpolator>> g;
    private static final Interpolator z = new LinearInterpolator();

    tb() {
    }

    private static SparseArray<WeakReference<Interpolator>> z() {
        if (g == null) {
            g = new SparseArray<>();
        }
        return g;
    }

    private static WeakReference<Interpolator> z(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (tb.class) {
            weakReference = z().get(i);
        }
        return weakReference;
    }

    private static void z(int i, WeakReference<Interpolator> weakReference) {
        synchronized (tb.class) {
            g.put(i, weakReference);
        }
    }

    static <T> com.bytedance.adsdk.lottie.m.z<T> z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, float f, xl<T> xlVar, boolean z2, boolean z3) throws IOException {
        if (z2 && z3) {
            return g(mVar, jsonReader, f, xlVar);
        }
        if (z2) {
            return z(mVar, jsonReader, f, xlVar);
        }
        return z(jsonReader, f, xlVar);
    }

    private static <T> com.bytedance.adsdk.lottie.m.z<T> z(com.bytedance.adsdk.lottie.m mVar, JsonReader jsonReader, float f, xl<T> xlVar) throws IOException {
        Interpolator interpolatorZ;
        jsonReader.beginObject();
        PointF pointFG = null;
        T tG = null;
        T tG2 = null;
        PointF pointFG2 = null;
        PointF pointFG3 = null;
        float fNextDouble = 0.0f;
        boolean z2 = false;
        PointF pointFG4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    tG = xlVar.g(jsonReader, f);
                    break;
                case "h":
                    if (jsonReader.nextInt() != 1) {
                        z2 = false;
                        break;
                    } else {
                        z2 = true;
                        break;
                    }
                    break;
                case "i":
                    pointFG4 = js.g(jsonReader, 1.0f);
                    break;
                case "o":
                    pointFG = js.g(jsonReader, 1.0f);
                    break;
                case "s":
                    tG2 = xlVar.g(jsonReader, f);
                    break;
                case "t":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "ti":
                    pointFG3 = js.g(jsonReader, f);
                    break;
                case "to":
                    pointFG2 = js.g(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (!z2) {
            if (pointFG != null && pointFG4 != null) {
                interpolatorZ = z(pointFG, pointFG4);
            }
            com.bytedance.adsdk.lottie.m.z<T> zVar = new com.bytedance.adsdk.lottie.m.z<>(mVar, tG2, tG, interpolatorZ, fNextDouble, null);
            zVar.gz = pointFG2;
            zVar.fo = pointFG3;
            return zVar;
        }
        tG = tG2;
        interpolatorZ = z;
        com.bytedance.adsdk.lottie.m.z<T> zVar2 = new com.bytedance.adsdk.lottie.m.z<>(mVar, tG2, tG, interpolatorZ, fNextDouble, null);
        zVar2.gz = pointFG2;
        zVar2.fo = pointFG3;
        return zVar2;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0262 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0273  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static <T> com.bytedance.adsdk.lottie.m.z<T> g(com.bytedance.adsdk.lottie.m r23, android.util.JsonReader r24, float r25, com.bytedance.adsdk.lottie.a.xl<T> r26) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 706
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.a.tb.g(com.bytedance.adsdk.lottie.m, android.util.JsonReader, float, com.bytedance.adsdk.lottie.a.xl):com.bytedance.adsdk.lottie.m.z");
    }

    private static Interpolator z(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = com.bytedance.adsdk.lottie.gc.gz.g(pointF.x, -1.0f, 1.0f);
        pointF.y = com.bytedance.adsdk.lottie.gc.gz.g(pointF.y, -100.0f, 100.0f);
        pointF2.x = com.bytedance.adsdk.lottie.gc.gz.g(pointF2.x, -1.0f, 1.0f);
        pointF2.y = com.bytedance.adsdk.lottie.gc.gz.g(pointF2.y, -100.0f, 100.0f);
        int iZ = com.bytedance.adsdk.lottie.gc.fo.z(pointF.x, pointF.y, pointF2.x, pointF2.y);
        WeakReference<Interpolator> weakReferenceZ = com.bytedance.adsdk.lottie.gc.z() ? null : z(iZ);
        Interpolator interpolator = weakReferenceZ != null ? weakReferenceZ.get() : null;
        if (weakReferenceZ == null || interpolator == null) {
            try {
                linearInterpolator = com.bytedance.adsdk.lottie.p.z(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                    linearInterpolator = com.bytedance.adsdk.lottie.p.z(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            if (!com.bytedance.adsdk.lottie.gc.z()) {
                try {
                    z(iZ, (WeakReference<Interpolator>) new WeakReference(interpolator));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator;
    }

    private static <T> com.bytedance.adsdk.lottie.m.z<T> z(JsonReader jsonReader, float f, xl<T> xlVar) throws IOException {
        return new com.bytedance.adsdk.lottie.m.z<>(xlVar.g(jsonReader, f));
    }
}
