package com.bytedance.adsdk.lottie.model.z;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends v<com.bytedance.adsdk.lottie.model.g.a, com.bytedance.adsdk.lottie.model.g.a> {
    @Override // com.bytedance.adsdk.lottie.model.z.v, com.bytedance.adsdk.lottie.model.z.i
    public /* bridge */ /* synthetic */ List dl() {
        return super.dl();
    }

    @Override // com.bytedance.adsdk.lottie.model.z.v, com.bytedance.adsdk.lottie.model.z.i
    public /* bridge */ /* synthetic */ boolean g() {
        return super.g();
    }

    @Override // com.bytedance.adsdk.lottie.model.z.v
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public dl(List<com.bytedance.adsdk.lottie.m.z<com.bytedance.adsdk.lottie.model.g.a>> list) {
        super(z(list));
    }

    private static List<com.bytedance.adsdk.lottie.m.z<com.bytedance.adsdk.lottie.model.g.a>> z(List<com.bytedance.adsdk.lottie.m.z<com.bytedance.adsdk.lottie.model.g.a>> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, z(list.get(i)));
        }
        return list;
    }

    private static com.bytedance.adsdk.lottie.m.z<com.bytedance.adsdk.lottie.model.g.a> z(com.bytedance.adsdk.lottie.m.z<com.bytedance.adsdk.lottie.model.g.a> zVar) {
        com.bytedance.adsdk.lottie.model.g.a aVar = zVar.z;
        com.bytedance.adsdk.lottie.model.g.a aVar2 = zVar.g;
        if (aVar == null || aVar2 == null || aVar.z().length == aVar2.z().length) {
            return zVar;
        }
        float[] fArrZ = z(aVar.z(), aVar2.z());
        return zVar.z(aVar.z(fArrZ), aVar2.z(fArrZ));
    }

    static float[] z(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f = Float.NaN;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = fArr3[i2];
            if (f2 != f) {
                fArr3[i] = f2;
                i++;
                f = fArr3[i2];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i);
    }

    @Override // com.bytedance.adsdk.lottie.model.z.i
    public com.bytedance.adsdk.lottie.z.g.z<com.bytedance.adsdk.lottie.model.g.a, com.bytedance.adsdk.lottie.model.g.a> z() {
        return new com.bytedance.adsdk.lottie.z.g.gc(this.z);
    }
}
