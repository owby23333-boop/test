package androidx.core.view;

import android.R;
import android.content.Context;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class ViewConfigurationCompat {
    private static final String TAG = "ViewConfigCompat";
    private static Method sGetScaledScrollFactorMethod;

    private ViewConfigurationCompat() {
    }

    private static float getLegacyScrollFactor(ViewConfiguration config, Context context) {
        if (sGetScaledScrollFactorMethod != null) {
            try {
                return ((Integer) r0.invoke(config, new Object[0])).intValue();
            } catch (Exception unused) {
                Log.i(TAG, "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static float getScaledHorizontalScrollFactor(@NonNull ViewConfiguration config, @NonNull Context context) {
        return config.getScaledHorizontalScrollFactor();
    }

    public static int getScaledHoverSlop(ViewConfiguration config) {
        return config.getScaledHoverSlop();
    }

    @Deprecated
    public static int getScaledPagingTouchSlop(ViewConfiguration config) {
        return config.getScaledPagingTouchSlop();
    }

    public static float getScaledVerticalScrollFactor(@NonNull ViewConfiguration config, @NonNull Context context) {
        return config.getScaledVerticalScrollFactor();
    }

    @Deprecated
    public static boolean hasPermanentMenuKey(ViewConfiguration config) {
        return config.hasPermanentMenuKey();
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration config, @NonNull Context context) {
        return config.shouldShowMenuShortcutsWhenKeyboardPresent();
    }
}
