package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class DrawableCompat {
    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    private DrawableCompat() {
    }

    public static void applyTheme(@NonNull Drawable drawable2, @NonNull Resources.Theme theme) {
        drawable2.applyTheme(theme);
    }

    public static boolean canApplyTheme(@NonNull Drawable drawable2) {
        return drawable2.canApplyTheme();
    }

    public static void clearColorFilter(@NonNull Drawable drawable2) {
        drawable2.clearColorFilter();
    }

    public static int getAlpha(@NonNull Drawable drawable2) {
        return drawable2.getAlpha();
    }

    public static ColorFilter getColorFilter(@NonNull Drawable drawable2) {
        return drawable2.getColorFilter();
    }

    public static int getLayoutDirection(@NonNull Drawable drawable2) {
        return drawable2.getLayoutDirection();
    }

    public static void inflate(@NonNull Drawable drawable2, @NonNull Resources res, @NonNull XmlPullParser parser, @NonNull AttributeSet attrs, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        drawable2.inflate(res, parser, attrs, theme);
    }

    public static boolean isAutoMirrored(@NonNull Drawable drawable2) {
        return drawable2.isAutoMirrored();
    }

    @Deprecated
    public static void jumpToCurrentState(@NonNull Drawable drawable2) {
        drawable2.jumpToCurrentState();
    }

    public static void setAutoMirrored(@NonNull Drawable drawable2, boolean mirrored) {
        drawable2.setAutoMirrored(mirrored);
    }

    public static void setHotspot(@NonNull Drawable drawable2, float x, float y) {
        drawable2.setHotspot(x, y);
    }

    public static void setHotspotBounds(@NonNull Drawable drawable2, int left, int top, int right, int bottom) {
        drawable2.setHotspotBounds(left, top, right, bottom);
    }

    public static boolean setLayoutDirection(@NonNull Drawable drawable2, int layoutDirection) {
        return drawable2.setLayoutDirection(layoutDirection);
    }

    public static void setTint(@NonNull Drawable drawable2, @ColorInt int tint) {
        drawable2.setTint(tint);
    }

    public static void setTintList(@NonNull Drawable drawable2, @Nullable ColorStateList tint) {
        drawable2.setTintList(tint);
    }

    public static void setTintMode(@NonNull Drawable drawable2, @NonNull PorterDuff.Mode tintMode) {
        drawable2.setTintMode(tintMode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T unwrap(@NonNull Drawable drawable2) {
        return drawable2 instanceof WrappedDrawable ? (T) ((WrappedDrawable) drawable2).getWrappedDrawable() : drawable2;
    }

    public static Drawable wrap(@NonNull Drawable drawable2) {
        return drawable2;
    }
}
