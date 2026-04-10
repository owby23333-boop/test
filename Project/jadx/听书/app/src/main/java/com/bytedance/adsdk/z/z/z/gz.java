package com.bytedance.adsdk.z.z.z;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bytedance.adsdk.z.z.g.e;
import com.bytedance.adsdk.z.z.g.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class gz<R extends com.bytedance.adsdk.z.z.g.m, W extends com.bytedance.adsdk.z.z.g.e> {
    protected final R e;
    public int fo;
    public int gz;
    public int kb;
    public int uy;
    public int wp;
    protected final Rect i = new Rect();
    protected final Rect v = new Rect();

    public abstract Bitmap z(Canvas canvas, Paint paint, int i, Bitmap bitmap, W w);

    public gz(R r) {
        this.e = r;
    }
}
