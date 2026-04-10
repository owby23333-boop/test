package com.bumptech.glide.request.k;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: ImageViewTargetFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    @NonNull
    public <Z> k<ImageView, Z> a(@NonNull ImageView imageView, @NonNull Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new b(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new e(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
