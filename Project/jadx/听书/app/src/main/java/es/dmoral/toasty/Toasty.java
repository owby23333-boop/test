package es.dmoral.toasty;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/* JADX INFO: loaded from: classes4.dex */
public class Toasty {
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    private static final Typeface LOADED_TOAST_TYPEFACE;
    private static boolean allowQueue;
    private static Typeface currentTypeface;
    private static boolean isRTL;
    private static Toast lastToast;
    private static boolean supportDarkTheme;
    private static int textSize;
    private static boolean tintIcon;
    private static int toastGravity;
    private static int xOffset;
    private static int yOffset;

    static {
        Typeface typefaceCreate = Typeface.create("sans-serif-condensed", 0);
        LOADED_TOAST_TYPEFACE = typefaceCreate;
        currentTypeface = typefaceCreate;
        textSize = 16;
        tintIcon = true;
        allowQueue = true;
        toastGravity = -1;
        xOffset = -1;
        yOffset = -1;
        supportDarkTheme = true;
        isRTL = false;
        lastToast = null;
    }

    private Toasty() {
    }

    public static Toast normal(Context context, int i) {
        return normal(context, (CharSequence) context.getString(i), 0, (Drawable) null, false);
    }

    public static Toast normal(Context context, CharSequence charSequence) {
        return normal(context, charSequence, 0, (Drawable) null, false);
    }

    public static Toast normal(Context context, int i, Drawable drawable) {
        return normal(context, (CharSequence) context.getString(i), 0, drawable, true);
    }

    public static Toast normal(Context context, CharSequence charSequence, Drawable drawable) {
        return normal(context, charSequence, 0, drawable, true);
    }

    public static Toast normal(Context context, int i, int i2) {
        return normal(context, (CharSequence) context.getString(i), i2, (Drawable) null, false);
    }

    public static Toast normal(Context context, CharSequence charSequence, int i) {
        return normal(context, charSequence, i, (Drawable) null, false);
    }

    public static Toast normal(Context context, int i, int i2, Drawable drawable) {
        return normal(context, (CharSequence) context.getString(i), i2, drawable, true);
    }

    public static Toast normal(Context context, CharSequence charSequence, int i, Drawable drawable) {
        return normal(context, charSequence, i, drawable, true);
    }

    public static Toast normal(Context context, int i, int i2, Drawable drawable, boolean z) {
        return normalWithDarkThemeSupport(context, context.getString(i), drawable, i2, z);
    }

    public static Toast normal(Context context, CharSequence charSequence, int i, Drawable drawable, boolean z) {
        return normalWithDarkThemeSupport(context, charSequence, drawable, i, z);
    }

    public static Toast warning(Context context, int i) {
        return warning(context, (CharSequence) context.getString(i), 0, true);
    }

    public static Toast warning(Context context, CharSequence charSequence) {
        return warning(context, charSequence, 0, true);
    }

    public static Toast warning(Context context, int i, int i2) {
        return warning(context, (CharSequence) context.getString(i), i2, true);
    }

    public static Toast warning(Context context, CharSequence charSequence, int i) {
        return warning(context, charSequence, i, true);
    }

    public static Toast warning(Context context, int i, int i2, boolean z) {
        return custom(context, (CharSequence) context.getString(i), ToastyUtils.getDrawable(context, R.drawable.ic_error_outline_white_24dp), ToastyUtils.getColor(context, R.color.warningColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i2, z, true);
    }

    public static Toast warning(Context context, CharSequence charSequence, int i, boolean z) {
        return custom(context, charSequence, ToastyUtils.getDrawable(context, R.drawable.ic_error_outline_white_24dp), ToastyUtils.getColor(context, R.color.warningColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i, z, true);
    }

    public static Toast info(Context context, int i) {
        return info(context, (CharSequence) context.getString(i), 0, true);
    }

    public static Toast info(Context context, CharSequence charSequence) {
        return info(context, charSequence, 0, true);
    }

    public static Toast info(Context context, int i, int i2) {
        return info(context, (CharSequence) context.getString(i), i2, true);
    }

    public static Toast info(Context context, CharSequence charSequence, int i) {
        return info(context, charSequence, i, true);
    }

    public static Toast info(Context context, int i, int i2, boolean z) {
        return custom(context, (CharSequence) context.getString(i), ToastyUtils.getDrawable(context, R.drawable.ic_info_outline_white_24dp), ToastyUtils.getColor(context, R.color.infoColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i2, z, true);
    }

    public static Toast info(Context context, CharSequence charSequence, int i, boolean z) {
        return custom(context, charSequence, ToastyUtils.getDrawable(context, R.drawable.ic_info_outline_white_24dp), ToastyUtils.getColor(context, R.color.infoColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i, z, true);
    }

    public static Toast success(Context context, int i) {
        return success(context, (CharSequence) context.getString(i), 0, true);
    }

    public static Toast success(Context context, CharSequence charSequence) {
        return success(context, charSequence, 0, true);
    }

    public static Toast success(Context context, int i, int i2) {
        return success(context, (CharSequence) context.getString(i), i2, true);
    }

    public static Toast success(Context context, CharSequence charSequence, int i) {
        return success(context, charSequence, i, true);
    }

    public static Toast success(Context context, int i, int i2, boolean z) {
        return custom(context, (CharSequence) context.getString(i), ToastyUtils.getDrawable(context, R.drawable.ic_check_white_24dp), ToastyUtils.getColor(context, R.color.successColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i2, z, true);
    }

    public static Toast success(Context context, CharSequence charSequence, int i, boolean z) {
        return custom(context, charSequence, ToastyUtils.getDrawable(context, R.drawable.ic_check_white_24dp), ToastyUtils.getColor(context, R.color.successColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i, z, true);
    }

    public static Toast error(Context context, int i) {
        return error(context, (CharSequence) context.getString(i), 0, true);
    }

    public static Toast error(Context context, CharSequence charSequence) {
        return error(context, charSequence, 0, true);
    }

    public static Toast error(Context context, int i, int i2) {
        return error(context, (CharSequence) context.getString(i), i2, true);
    }

    public static Toast error(Context context, CharSequence charSequence, int i) {
        return error(context, charSequence, i, true);
    }

    public static Toast error(Context context, int i, int i2, boolean z) {
        return custom(context, (CharSequence) context.getString(i), ToastyUtils.getDrawable(context, R.drawable.ic_clear_white_24dp), ToastyUtils.getColor(context, R.color.errorColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i2, z, true);
    }

    public static Toast error(Context context, CharSequence charSequence, int i, boolean z) {
        return custom(context, charSequence, ToastyUtils.getDrawable(context, R.drawable.ic_clear_white_24dp), ToastyUtils.getColor(context, R.color.errorColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i, z, true);
    }

    public static Toast custom(Context context, int i, Drawable drawable, int i2, boolean z) {
        return custom(context, (CharSequence) context.getString(i), drawable, -1, ToastyUtils.getColor(context, R.color.defaultTextColor), i2, z, false);
    }

    public static Toast custom(Context context, CharSequence charSequence, Drawable drawable, int i, boolean z) {
        return custom(context, charSequence, drawable, -1, ToastyUtils.getColor(context, R.color.defaultTextColor), i, z, false);
    }

    public static Toast custom(Context context, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return custom(context, context.getString(i), ToastyUtils.getDrawable(context, i2), ToastyUtils.getColor(context, i3), ToastyUtils.getColor(context, R.color.defaultTextColor), i4, z, z2);
    }

    public static Toast custom(Context context, CharSequence charSequence, int i, int i2, int i3, boolean z, boolean z2) {
        return custom(context, charSequence, ToastyUtils.getDrawable(context, i), ToastyUtils.getColor(context, i2), ToastyUtils.getColor(context, R.color.defaultTextColor), i3, z, z2);
    }

    public static Toast custom(Context context, int i, Drawable drawable, int i2, int i3, boolean z, boolean z2) {
        return custom(context, context.getString(i), drawable, ToastyUtils.getColor(context, i2), ToastyUtils.getColor(context, R.color.defaultTextColor), i3, z, z2);
    }

    public static Toast custom(Context context, int i, Drawable drawable, int i2, int i3, int i4, boolean z, boolean z2) {
        return custom(context, context.getString(i), drawable, ToastyUtils.getColor(context, i2), ToastyUtils.getColor(context, i3), i4, z, z2);
    }

    public static Toast custom(Context context, CharSequence charSequence, Drawable drawable, int i, int i2, int i3, boolean z, boolean z2) {
        Drawable drawable2;
        Toast toastMakeText = Toast.makeText(context, "", i3);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.toast_layout, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.toast_root);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.toast_icon);
        TextView textView = (TextView) viewInflate.findViewById(R.id.toast_text);
        if (z2) {
            drawable2 = ToastyUtils.tint9PatchDrawableFrame(context, i);
        } else {
            drawable2 = ToastyUtils.getDrawable(context, R.drawable.toast_frame);
        }
        ToastyUtils.setBackground(viewInflate, drawable2);
        if (!z) {
            imageView.setVisibility(8);
        } else {
            if (drawable == null) {
                throw new IllegalArgumentException("Avoid passing 'icon' as null if 'withIcon' is set to true");
            }
            if (isRTL) {
                linearLayout.setLayoutDirection(1);
            }
            if (tintIcon) {
                drawable = ToastyUtils.tintIcon(drawable, i2);
            }
            ToastyUtils.setBackground(imageView, drawable);
        }
        textView.setText(charSequence);
        textView.setTextColor(i2);
        textView.setTypeface(currentTypeface);
        textView.setTextSize(2, textSize);
        toastMakeText.setView(viewInflate);
        if (!allowQueue) {
            Toast toast = lastToast;
            if (toast != null) {
                toast.cancel();
            }
            lastToast = toastMakeText;
        }
        int gravity = toastGravity;
        if (gravity == -1) {
            gravity = toastMakeText.getGravity();
        }
        int xOffset2 = xOffset;
        if (xOffset2 == -1) {
            xOffset2 = toastMakeText.getXOffset();
        }
        int yOffset2 = yOffset;
        if (yOffset2 == -1) {
            yOffset2 = toastMakeText.getYOffset();
        }
        toastMakeText.setGravity(gravity, xOffset2, yOffset2);
        return toastMakeText;
    }

    private static Toast normalWithDarkThemeSupport(Context context, CharSequence charSequence, Drawable drawable, int i, boolean z) {
        if (supportDarkTheme && Build.VERSION.SDK_INT >= 29) {
            if ((context.getResources().getConfiguration().uiMode & 48) == 16) {
                return withLightTheme(context, charSequence, drawable, i, z);
            }
            return withDarkTheme(context, charSequence, drawable, i, z);
        }
        if (Build.VERSION.SDK_INT >= 27) {
            return withLightTheme(context, charSequence, drawable, i, z);
        }
        return withDarkTheme(context, charSequence, drawable, i, z);
    }

    private static Toast withLightTheme(Context context, CharSequence charSequence, Drawable drawable, int i, boolean z) {
        return custom(context, charSequence, drawable, ToastyUtils.getColor(context, R.color.defaultTextColor), ToastyUtils.getColor(context, R.color.normalColor), i, z, true);
    }

    private static Toast withDarkTheme(Context context, CharSequence charSequence, Drawable drawable, int i, boolean z) {
        return custom(context, charSequence, drawable, ToastyUtils.getColor(context, R.color.normalColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i, z, true);
    }

    public static class Config {
        private Typeface typeface = Toasty.currentTypeface;
        private int textSize = Toasty.textSize;
        private boolean tintIcon = Toasty.tintIcon;
        private boolean allowQueue = true;
        private int toastGravity = Toasty.toastGravity;
        private int xOffset = Toasty.xOffset;
        private int yOffset = Toasty.yOffset;
        private boolean supportDarkTheme = true;
        private boolean isRTL = false;

        private Config() {
        }

        public static Config getInstance() {
            return new Config();
        }

        public static void reset() {
            Typeface unused = Toasty.currentTypeface = Toasty.LOADED_TOAST_TYPEFACE;
            int unused2 = Toasty.textSize = 16;
            boolean unused3 = Toasty.tintIcon = true;
            boolean unused4 = Toasty.allowQueue = true;
            int unused5 = Toasty.toastGravity = -1;
            int unused6 = Toasty.xOffset = -1;
            int unused7 = Toasty.yOffset = -1;
            boolean unused8 = Toasty.supportDarkTheme = true;
            boolean unused9 = Toasty.isRTL = false;
        }

        public Config setToastTypeface(Typeface typeface) {
            this.typeface = typeface;
            return this;
        }

        public Config setTextSize(int i) {
            this.textSize = i;
            return this;
        }

        public Config tintIcon(boolean z) {
            this.tintIcon = z;
            return this;
        }

        public Config allowQueue(boolean z) {
            this.allowQueue = z;
            return this;
        }

        public Config setGravity(int i, int i2, int i3) {
            this.toastGravity = i;
            this.xOffset = i2;
            this.yOffset = i3;
            return this;
        }

        public Config setGravity(int i) {
            this.toastGravity = i;
            return this;
        }

        public Config supportDarkTheme(boolean z) {
            this.supportDarkTheme = z;
            return this;
        }

        public Config setRTL(boolean z) {
            this.isRTL = z;
            return this;
        }

        public void apply() {
            Typeface unused = Toasty.currentTypeface = this.typeface;
            int unused2 = Toasty.textSize = this.textSize;
            boolean unused3 = Toasty.tintIcon = this.tintIcon;
            boolean unused4 = Toasty.allowQueue = this.allowQueue;
            int unused5 = Toasty.toastGravity = this.toastGravity;
            int unused6 = Toasty.xOffset = this.xOffset;
            int unused7 = Toasty.yOffset = this.yOffset;
            boolean unused8 = Toasty.supportDarkTheme = this.supportDarkTheme;
            boolean unused9 = Toasty.isRTL = this.isRTL;
        }
    }
}
