package miuix.core.util;

import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import com.iflytek.aikit.media.param.MscKeys;
import miuix.reflect.ReflectionHelper;

/* JADX INFO: loaded from: classes7.dex */
public class MiShadowUtils {
    public static final boolean SUPPORT_MI_SHADOW;
    private static final String TAG = "MiShadowHelper";

    static {
        boolean z = Boolean.parseBoolean(SystemProperties.get("persist.sys.mi_shadow_supported", MscKeys.VAL_FALSE));
        SUPPORT_MI_SHADOW = z;
        if (z) {
            return;
        }
        Log.d(TAG, "This device does not support mi shadow!");
    }

    private MiShadowUtils() {
    }

    public static void clearMiShadow(View view) {
        setMiShadow(view, 0, 0.0f, 0.0f, 0.0f);
    }

    public static void setMiShadow(View view, @ColorInt int i, float f) {
        setMiShadow(view, i, 0.0f, 0.0f, f);
    }

    public static void setMiShadow(View view, @ColorInt int i, float f, float f2, float f3) {
        setMiShadow(view, i, f, f2, f3, 1.0f);
    }

    public static void setMiShadow(View view, @ColorInt int i, float f, float f2, float f3, float f4) {
        if (SUPPORT_MI_SHADOW) {
            try {
                Class cls = Float.TYPE;
                ReflectionHelper.invoke(View.class, view, "setMiShadow", new Class[]{Integer.TYPE, cls, cls, cls, cls}, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
            } catch (Exception e) {
                Log.e(TAG, "Failed to call setMiShadow", e);
            }
        }
    }
}
