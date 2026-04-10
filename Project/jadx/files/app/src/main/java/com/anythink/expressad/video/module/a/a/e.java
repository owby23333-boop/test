package com.anythink.expressad.video.module.a.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class e implements com.anythink.expressad.foundation.g.d.c {
    protected static final String b = "ImageLoaderListener";
    private com.anythink.expressad.foundation.d.c a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected WeakReference<ImageView> f11908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11909d;

    public e(ImageView imageView) {
        this.f11908c = new WeakReference<>(imageView);
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public void a(Bitmap bitmap, String str) {
        try {
            if (bitmap == null) {
                com.anythink.expressad.foundation.h.o.d(b, "bitmap=null");
            } else {
                if (this.f11908c == null || this.f11908c.get() == null || bitmap.isRecycled()) {
                    return;
                }
                this.f11908c.get().setImageBitmap(bitmap);
                this.f11908c.get().setVisibility(0);
            }
        } catch (Throwable th) {
            if (com.anythink.expressad.a.a) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public void a(String str, String str2) {
    }

    public e(ImageView imageView, com.anythink.expressad.foundation.d.c cVar, String str) {
        this.f11908c = new WeakReference<>(imageView);
        this.a = cVar;
        this.f11909d = str;
    }
}
