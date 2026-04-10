package com.bytedance.adsdk.lottie.ga;

import android.graphics.Color;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class s implements j<com.bytedance.adsdk.lottie.d.bf.tg> {
    private int e;

    public s(int i) {
        this.e = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c9  */
    @Override // com.bytedance.adsdk.lottie.ga.j
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.adsdk.lottie.d.bf.tg bf(android.util.JsonReader r18, float r19) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.ga.s.bf(android.util.JsonReader, float):com.bytedance.adsdk.lottie.d.bf.tg");
    }

    private com.bytedance.adsdk.lottie.d.bf.tg e(com.bytedance.adsdk.lottie.d.bf.tg tgVar, List<Float> list) {
        int i = this.e * 4;
        if (list.size() <= i) {
            return tgVar;
        }
        float[] fArrE = tgVar.e();
        int[] iArrBf = tgVar.bf();
        int size = (list.size() - i) / 2;
        float[] fArr = new float[size];
        float[] fArr2 = new float[size];
        int i2 = 0;
        while (i < list.size()) {
            if (i % 2 == 0) {
                fArr[i2] = list.get(i).floatValue();
            } else {
                fArr2[i2] = list.get(i).floatValue();
                i2++;
            }
            i++;
        }
        float[] fArrE2 = e(tgVar.e(), fArr);
        int length = fArrE2.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            float f = fArrE2[i3];
            int iBinarySearch = Arrays.binarySearch(fArrE, f);
            int iBinarySearch2 = Arrays.binarySearch(fArr, f);
            if (iBinarySearch >= 0 && iBinarySearch2 <= 0) {
                iArr[i3] = e(f, iArrBf[iBinarySearch], fArr, fArr2);
            } else {
                if (iBinarySearch2 < 0) {
                    iBinarySearch2 = -(iBinarySearch2 + 1);
                }
                iArr[i3] = e(f, fArr2[iBinarySearch2], fArrE, iArrBf);
            }
        }
        return new com.bytedance.adsdk.lottie.d.bf.tg(fArrE2, iArr);
    }

    public int e(float f, float f2, float[] fArr, int[] iArr) {
        if (iArr.length >= 2 && f != fArr[0]) {
            for (int i = 1; i < fArr.length; i++) {
                float f3 = fArr[i];
                if (f3 >= f || i == fArr.length - 1) {
                    int i2 = i - 1;
                    float f4 = fArr[i2];
                    float f5 = (f - f4) / (f3 - f4);
                    int i3 = iArr[i];
                    int i4 = iArr[i2];
                    return Color.argb((int) (f2 * 255.0f), com.bytedance.adsdk.lottie.vn.bf.e(f5, Color.red(i4), Color.red(i3)), com.bytedance.adsdk.lottie.vn.bf.e(f5, Color.green(i4), Color.green(i3)), com.bytedance.adsdk.lottie.vn.bf.e(f5, Color.blue(i4), Color.blue(i3)));
                }
            }
            throw new IllegalArgumentException("Unreachable code.");
        }
        return iArr[0];
    }

    private int e(float f, int i, float[] fArr, float[] fArr2) {
        float fE;
        if (fArr2.length >= 2 && f > fArr[0]) {
            for (int i2 = 1; i2 < fArr.length; i2++) {
                float f2 = fArr[i2];
                if (f2 >= f || i2 == fArr.length - 1) {
                    if (f2 <= f) {
                        fE = fArr2[i2];
                    } else {
                        int i3 = i2 - 1;
                        float f3 = fArr[i3];
                        fE = com.bytedance.adsdk.lottie.vn.p.e(fArr2[i3], fArr2[i2], (f - f3) / (f2 - f3));
                    }
                    return Color.argb((int) (fE * 255.0f), Color.red(i), Color.green(i), Color.blue(i));
                }
            }
            throw new IllegalArgumentException("Unreachable code.");
        }
        return Color.argb((int) (fArr2[0] * 255.0f), Color.red(i), Color.green(i), Color.blue(i));
    }

    public static float[] e(float[] fArr, float[] fArr2) {
        if (fArr.length == 0) {
            return fArr2;
        }
        if (fArr2.length == 0) {
            return fArr;
        }
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            float f = i2 < fArr.length ? fArr[i2] : Float.NaN;
            float f2 = i3 < fArr2.length ? fArr2[i3] : Float.NaN;
            if (!Float.isNaN(f2) && f >= f2) {
                if (!Float.isNaN(f) && f2 >= f) {
                    fArr3[i4] = f;
                    i2++;
                    i3++;
                    i++;
                } else {
                    fArr3[i4] = f2;
                    i3++;
                }
            } else {
                fArr3[i4] = f;
                i2++;
            }
        }
        return i == 0 ? fArr3 : Arrays.copyOf(fArr3, length - i);
    }
}
