package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
class ObjectAnimatorUtils {
    private ObjectAnimatorUtils() {
    }

    static <T> ObjectAnimator ofPointF(T t2, Property<T, PointF> property, Path path) {
        return Build.VERSION.SDK_INT >= 21 ? ObjectAnimator.ofObject(t2, property, (TypeConverter) null, path) : ObjectAnimator.ofFloat(t2, new PathProperty(property, path), 0.0f, 1.0f);
    }
}
