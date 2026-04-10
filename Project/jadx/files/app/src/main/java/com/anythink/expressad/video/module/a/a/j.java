package com.anythink.expressad.video.module.a.a;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends e {
    private int a;

    public j(ImageView imageView, int i2) {
        super(imageView);
        this.a = i2;
    }

    @Override // com.anythink.expressad.video.module.a.a.e, com.anythink.expressad.foundation.g.d.c
    public final void a(Bitmap bitmap, String str) {
        Bitmap bitmapA;
        if (bitmap == null) {
            return;
        }
        try {
            if (this.f11908c == null || this.f11908c.get() == null || bitmap.isRecycled() || (bitmapA = com.anythink.expressad.foundation.h.n.a(bitmap, this.a)) == null) {
                return;
            }
            this.f11908c.get().setImageBitmap(bitmapA);
        } catch (Throwable th) {
            if (com.anythink.expressad.a.a) {
                th.printStackTrace();
            }
        }
    }
}
