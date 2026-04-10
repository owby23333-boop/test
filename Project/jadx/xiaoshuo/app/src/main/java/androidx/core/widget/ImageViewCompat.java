package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class ImageViewCompat {
    private ImageViewCompat() {
    }

    @Nullable
    public static ColorStateList getImageTintList(@NonNull ImageView view) {
        return view.getImageTintList();
    }

    @Nullable
    public static PorterDuff.Mode getImageTintMode(@NonNull ImageView view) {
        return view.getImageTintMode();
    }

    public static void setImageTintList(@NonNull ImageView view, @Nullable ColorStateList tintList) {
        view.setImageTintList(tintList);
    }

    public static void setImageTintMode(@NonNull ImageView view, @Nullable PorterDuff.Mode mode) {
        view.setImageTintMode(mode);
    }
}
