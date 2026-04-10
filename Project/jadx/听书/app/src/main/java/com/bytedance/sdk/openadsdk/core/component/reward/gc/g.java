package com.bytedance.sdk.openadsdk.core.component.reward.gc;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.uy;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static float[] z(Context context, float f, int i) {
        float fMin;
        float fMax;
        float[] fArr = new float[2];
        float fA = oq.a(context, oq.fo(context));
        float fA2 = oq.a(context, oq.uy(context));
        if (i == 2) {
            fMin = Math.max(fA, fA2);
            fMax = Math.min(fA, fA2);
        } else {
            fMin = Math.min(fA, fA2);
            fMax = Math.max(fA, fA2);
        }
        int iA = oq.a(context, oq.kb(context));
        if (oq.g() || f != 100.0f) {
            if (i != 2) {
                fMax -= iA;
            } else {
                if ("SM-A207F".equals(uy.g())) {
                    iA *= 2;
                }
                fMin -= iA;
            }
        }
        fArr[0] = fMin;
        fArr[1] = fMax;
        return fArr;
    }

    public static int[] z(Context context, float f, float f2, int i) {
        int iMax;
        float[] fArrZ = z(context, f, i);
        float f3 = fArrZ[0];
        float f4 = fArrZ[1];
        int[] iArr = new int[4];
        int iMin = (int) (Math.min(f3, f4) * f2);
        if (i != 2) {
            float f5 = iMin;
            iMax = (int) Math.max((f4 - (((f3 - f5) - f5) / f)) / 2.0f, 0.0f);
        } else {
            float f6 = iMin;
            iMin = (int) Math.max((f3 - (((f4 - f6) - f6) * f)) / 2.0f, 0.0f);
            iMax = iMin;
        }
        iArr[0] = iMin;
        iArr[1] = iMax;
        iArr[2] = iMin;
        iArr[3] = iMax;
        return iArr;
    }
}
