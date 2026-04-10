package com.bumptech.glide.request.k;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: DrawableImageViewTarget.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends f<Drawable> {
    public e(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.k.f
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void a(@Nullable Drawable drawable) {
        ((ImageView) this.f13879s).setImageDrawable(drawable);
    }
}
