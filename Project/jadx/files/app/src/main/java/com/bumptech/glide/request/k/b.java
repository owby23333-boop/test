package com.bumptech.glide.request.k;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: compiled from: BitmapImageViewTarget.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends f<Bitmap> {
    public b(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.k.f
    public void a(Bitmap bitmap) {
        ((ImageView) this.f13879s).setImageBitmap(bitmap);
    }
}
