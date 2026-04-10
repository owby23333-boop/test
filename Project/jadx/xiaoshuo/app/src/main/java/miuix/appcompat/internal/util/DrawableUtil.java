package miuix.appcompat.internal.util;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import miuix.appcompat.internal.graphics.drawable.PlaceholderDrawable;

/* JADX INFO: loaded from: classes7.dex */
public class DrawableUtil {
    private DrawableUtil() {
    }

    public static boolean isPlaceholder(Drawable drawable2) {
        return (drawable2 instanceof PlaceholderDrawable) || ((drawable2 instanceof ColorDrawable) && ((ColorDrawable) drawable2).getColor() == 0);
    }
}
