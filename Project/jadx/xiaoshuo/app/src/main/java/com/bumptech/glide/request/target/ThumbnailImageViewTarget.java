package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class ThumbnailImageViewTarget<T> extends ImageViewTarget<T> {
    public ThumbnailImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    public abstract Drawable getDrawable(T t);

    @Override // com.bumptech.glide.request.target.ImageViewTarget
    public void setResource(@Nullable T t) {
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.view).getLayoutParams();
        Drawable drawable2 = getDrawable(t);
        if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            drawable2 = new FixedSizeDrawable(drawable2, layoutParams.width, layoutParams.height);
        }
        ((ImageView) this.view).setImageDrawable(drawable2);
    }

    @Deprecated
    public ThumbnailImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
