package es.dmoral.toasty;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes4.dex */
final class ToastyUtils {
    private ToastyUtils() {
    }

    static Drawable tintIcon(Drawable drawable, int i) {
        drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        return drawable;
    }

    static Drawable tint9PatchDrawableFrame(Context context, int i) {
        return tintIcon((NinePatchDrawable) getDrawable(context, R.drawable.toast_frame), i);
    }

    static void setBackground(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    static Drawable getDrawable(Context context, int i) {
        return AppCompatResources.getDrawable(context, i);
    }

    static int getColor(Context context, int i) {
        return ContextCompat.getColor(context, i);
    }
}
