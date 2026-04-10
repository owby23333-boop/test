package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class CompoundButtonCompat {
    private static final String TAG = "CompoundButtonCompat";
    private static Field sButtonDrawableField;
    private static boolean sButtonDrawableFieldFetched;

    private CompoundButtonCompat() {
    }

    @Nullable
    public static Drawable getButtonDrawable(@NonNull CompoundButton button) {
        return button.getButtonDrawable();
    }

    @Nullable
    public static ColorStateList getButtonTintList(@NonNull CompoundButton button) {
        return button.getButtonTintList();
    }

    @Nullable
    public static PorterDuff.Mode getButtonTintMode(@NonNull CompoundButton button) {
        return button.getButtonTintMode();
    }

    public static void setButtonTintList(@NonNull CompoundButton button, @Nullable ColorStateList tint) {
        button.setButtonTintList(tint);
    }

    public static void setButtonTintMode(@NonNull CompoundButton button, @Nullable PorterDuff.Mode tintMode) {
        button.setButtonTintMode(tintMode);
    }
}
