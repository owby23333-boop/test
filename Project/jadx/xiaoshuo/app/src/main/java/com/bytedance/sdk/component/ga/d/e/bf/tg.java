package com.bytedance.sdk.component.ga.d.e.bf;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.ga.l;

/* JADX INFO: loaded from: classes.dex */
public class tg implements l {
    private final com.bytedance.sdk.component.ga.d.e.bf bf;
    private final l e;

    public tg(l lVar) {
        this(lVar, null);
    }

    public tg(l lVar, com.bytedance.sdk.component.ga.d.e.bf bfVar) {
        this.e = lVar;
        this.bf = bfVar;
    }

    @Override // com.bytedance.sdk.component.ga.e
    public boolean e(String str, Bitmap bitmap) {
        boolean zE = this.e.e(str, bitmap);
        com.bytedance.sdk.component.ga.d.e.bf bfVar = this.bf;
        if (bfVar != null) {
            bfVar.e(str, Boolean.valueOf(zE));
        }
        return zE;
    }

    @Override // com.bytedance.sdk.component.ga.e
    public Bitmap e(String str) {
        Bitmap bitmapE = this.e.e(str);
        com.bytedance.sdk.component.ga.d.e.bf bfVar = this.bf;
        if (bfVar != null) {
            bfVar.bf(str, bitmapE);
        }
        return bitmapE;
    }
}
