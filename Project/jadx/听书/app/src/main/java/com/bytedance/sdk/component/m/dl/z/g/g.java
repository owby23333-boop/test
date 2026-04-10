package com.bytedance.sdk.component.m.dl.z.g;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.m.hh;

/* JADX INFO: loaded from: classes2.dex */
public class g implements hh {
    private com.bytedance.sdk.component.m.dl.z.dl<String, Bitmap> dl;
    private int g;
    private int z;

    public g(int i, int i2) {
        this.g = i;
        this.z = i2;
        this.dl = new com.bytedance.sdk.component.m.dl.z.dl<String, Bitmap>(i) { // from class: com.bytedance.sdk.component.m.dl.z.g.g.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.component.m.dl.z.dl
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public int g(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    return 0;
                }
                return g.z(bitmap);
            }
        };
    }

    @Override // com.bytedance.sdk.component.m.z
    public boolean z(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        this.dl.z(str, bitmap);
        return true;
    }

    @Override // com.bytedance.sdk.component.m.z
    public Bitmap z(String str) {
        return this.dl.z(str);
    }

    @Override // com.bytedance.sdk.component.m.z
    public boolean g(String str) {
        return this.dl.z(str) != null;
    }

    @Override // com.bytedance.sdk.component.m.z
    public void z(double d) {
        this.dl.z((int) (((double) this.g) * d));
    }

    public static int z(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getAllocationByteCount();
    }
}
