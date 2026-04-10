package com.bytedance.sdk.component.ga.d.e.bf;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.ga.l;

/* JADX INFO: loaded from: classes.dex */
public class bf implements l {
    private int bf;
    private int d;
    private int e;
    private com.bytedance.sdk.component.ga.d.e.d<String, Bitmap> tg;

    public bf(int i, int i2) {
        this.d = i;
        this.e = i2;
        this.tg = new com.bytedance.sdk.component.ga.d.e.d<String, Bitmap>(i) { // from class: com.bytedance.sdk.component.ga.d.e.bf.bf.1
            @Override // com.bytedance.sdk.component.ga.d.e.d
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public int bf(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    return 0;
                }
                return bf.e(bitmap);
            }
        };
    }

    @Override // com.bytedance.sdk.component.ga.e
    public boolean e(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        this.tg.e(str, bitmap);
        return true;
    }

    @Override // com.bytedance.sdk.component.ga.e
    public Bitmap e(String str) {
        return this.tg.e(str);
    }

    public static int e(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getAllocationByteCount();
    }
}
