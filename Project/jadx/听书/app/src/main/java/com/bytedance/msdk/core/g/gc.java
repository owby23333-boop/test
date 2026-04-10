package com.bytedance.msdk.core.g;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private final int[] dl;
    private final float[] g;
    private final String z;

    public gc(String str, JSONArray jSONArray, JSONArray jSONArray2) {
        this.z = str;
        this.g = new float[jSONArray.length()];
        this.dl = new int[jSONArray2.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            this.g[i] = (float) jSONArray.optDouble(i);
        }
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            this.dl[i2] = jSONArray2.optInt(i2);
        }
    }

    public int z(float f) {
        int[] iArr;
        int i;
        float[] fArr = this.g;
        int i2 = -1;
        if (fArr == null || fArr.length == 0 || (iArr = this.dl) == null || iArr.length == 0) {
            return -1;
        }
        int length = fArr.length;
        int i3 = 0;
        while (i3 < length) {
            float[] fArr2 = this.g;
            float f2 = fArr2[i3];
            if (f > f2 && (i = i3 + 1) < length && f <= fArr2[i]) {
                int[] iArr2 = this.dl;
                return i3 < iArr2.length ? iArr2[i3] : i2;
            }
            if (i3 == length - 1 && f > f2) {
                i2 = this.dl[i3];
            }
            i3++;
        }
        return i2;
    }
}
