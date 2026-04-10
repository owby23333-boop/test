package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.internal.s;

/* JADX INFO: compiled from: MaterialShapeUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    @NonNull
    static d a(int i2) {
        return i2 != 0 ? i2 != 1 ? a() : new e() : new k();
    }

    @NonNull
    static f b() {
        return new f();
    }

    @NonNull
    static d a() {
        return new k();
    }

    public static void a(@NonNull View view, float f2) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) background).b(f2);
        }
    }

    public static void a(@NonNull View view) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            a(view, (MaterialShapeDrawable) background);
        }
    }

    public static void a(@NonNull View view, @NonNull MaterialShapeDrawable materialShapeDrawable) {
        if (materialShapeDrawable.t()) {
            materialShapeDrawable.d(s.d(view));
        }
    }
}
