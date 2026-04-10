package miuix.internal.util;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes8.dex */
public class AttributeResolver {
    private static final TypedValue TYPED_VALUE = new TypedValue();
    private static final ThreadLocal<TypedValue> TYPED_VALUE_THREAD_LOCAL = new ThreadLocal<>();

    public AttributeResolver() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    private static TypedValue getTypedValue(Context context) {
        if (context.getMainLooper().getThread() == Thread.currentThread()) {
            return TYPED_VALUE;
        }
        ThreadLocal<TypedValue> threadLocal = TYPED_VALUE_THREAD_LOCAL;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static Integer innerResolveColor(Context context, int i) {
        TypedValue typedValue = getTypedValue(context);
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        if (typedValue.resourceId > 0) {
            return Integer.valueOf(context.getResources().getColor(typedValue.resourceId));
        }
        int i2 = typedValue.type;
        if (i2 < 28 || i2 > 31) {
            return null;
        }
        return Integer.valueOf(typedValue.data);
    }

    public static int resolve(Context context, int i) {
        TypedValue typedValue = getTypedValue(context);
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue.resourceId;
        }
        return -1;
    }

    public static boolean resolveBoolean(Context context, int i, boolean z) {
        TypedValue typedValue = getTypedValue(context);
        return (context.getTheme().resolveAttribute(i, typedValue, true) && typedValue.type == 18) ? typedValue.resourceId > 0 ? context.getResources().getBoolean(typedValue.resourceId) : typedValue.data != 0 : z;
    }

    public static int resolveColor(Context context, int i) {
        Integer numInnerResolveColor = innerResolveColor(context, i);
        return numInnerResolveColor != null ? numInnerResolveColor.intValue() : context.getResources().getColor(-1);
    }

    public static float resolveDimension(Context context, int i) {
        TypedValue typedValueResolveTypedValue = resolveTypedValue(context, i);
        if (typedValueResolveTypedValue != null && typedValueResolveTypedValue.type == 5) {
            return typedValueResolveTypedValue.resourceId > 0 ? context.getResources().getDimension(typedValueResolveTypedValue.resourceId) : TypedValue.complexToDimension(typedValueResolveTypedValue.data, context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static int resolveDimensionPixelSize(Context context, int i) {
        TypedValue typedValueResolveTypedValue = resolveTypedValue(context, i);
        if (typedValueResolveTypedValue != null && typedValueResolveTypedValue.type == 5) {
            return typedValueResolveTypedValue.resourceId > 0 ? context.getResources().getDimensionPixelSize(typedValueResolveTypedValue.resourceId) : TypedValue.complexToDimensionPixelSize(typedValueResolveTypedValue.data, context.getResources().getDisplayMetrics());
        }
        return 0;
    }

    public static Drawable resolveDrawable(Context context, int i) {
        TypedValue typedValue = getTypedValue(context);
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        if (typedValue.resourceId > 0) {
            return context.getResources().getDrawable(typedValue.resourceId, context.getTheme());
        }
        int i2 = typedValue.type;
        if (i2 < 28 || i2 > 31) {
            return null;
        }
        return new ColorDrawable(typedValue.data);
    }

    public static float resolveFloat(Context context, int i, float f) {
        TypedValue typedValue = getTypedValue(context);
        return (context.getTheme().resolveAttribute(i, typedValue, true) && typedValue.type == 4) ? typedValue.resourceId > 0 ? Build.VERSION.SDK_INT >= 29 ? context.getResources().getFloat(typedValue.resourceId) : f : typedValue.data : f;
    }

    public static int resolveInt(Context context, int i, int i2) {
        TypedValue typedValue = getTypedValue(context);
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return i2;
        }
        if (typedValue.resourceId > 0) {
            return context.getResources().getInteger(typedValue.resourceId);
        }
        int i3 = typedValue.type;
        return (i3 < 16 || i3 > 31) ? i2 : typedValue.data;
    }

    @Nullable
    public static TypedValue resolveTypedValue(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static int resolveColor(Context context, int i, int i2) {
        Integer numInnerResolveColor = innerResolveColor(context, i);
        return numInnerResolveColor != null ? numInnerResolveColor.intValue() : i2;
    }
}
