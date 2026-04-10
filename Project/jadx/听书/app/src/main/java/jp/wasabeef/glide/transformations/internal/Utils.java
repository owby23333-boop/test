package jp.wasabeef.glide.transformations.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes4.dex */
public final class Utils {
    private Utils() {
    }

    public static Drawable getMaskDrawable(Context context, int i) {
        Drawable drawable = context.getDrawable(i);
        if (drawable != null) {
            return drawable;
        }
        throw new IllegalArgumentException("maskId is invalid");
    }
}
