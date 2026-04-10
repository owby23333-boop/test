package com.google.android.material.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: DrawableAlphaProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> b = new e();
    private final WeakHashMap<Drawable, Integer> a;

    private e() {
        super(Integer.class, "drawableAlphaCompat");
        this.a = new WeakHashMap<>();
    }

    @Override // android.util.Property
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.a.containsKey(drawable)) {
            return this.a.get(drawable);
        }
        return 255;
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(@NonNull Drawable drawable, @NonNull Integer num) {
        if (Build.VERSION.SDK_INT < 19) {
            this.a.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }
}
