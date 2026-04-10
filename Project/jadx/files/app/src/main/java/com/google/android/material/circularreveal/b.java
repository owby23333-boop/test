package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.CircularRevealHelper;

/* JADX INFO: compiled from: CircularRevealWidget.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b extends CircularRevealHelper.a {

    /* JADX INFO: renamed from: com.google.android.material.circularreveal.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class C0322b implements TypeEvaluator<e> {
        public static final TypeEvaluator<e> b = new C0322b();
        private final e a = new e();

        @Override // android.animation.TypeEvaluator
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f2, @NonNull e eVar, @NonNull e eVar2) {
            this.a.a(com.google.android.material.h.a.b(eVar.a, eVar2.a, f2), com.google.android.material.h.a.b(eVar.b, eVar2.b, f2), com.google.android.material.h.a.b(eVar.f15223c, eVar2.f15223c, f2));
            return this.a;
        }
    }

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class c extends Property<b, e> {
        public static final Property<b, e> a = new c("circularReveal");

        private c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(@NonNull b bVar) {
            return bVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull b bVar, @Nullable e eVar) {
            bVar.setRevealInfo(eVar);
        }
    }

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class d extends Property<b, Integer> {
        public static final Property<b, Integer> a = new d("circularRevealScrimColor");

        private d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(@NonNull b bVar) {
            return Integer.valueOf(bVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull b bVar, @NonNull Integer num) {
            bVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class e {
        public float a;
        public float b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f15223c;

        public void a(float f2, float f3, float f4) {
            this.a = f2;
            this.b = f3;
            this.f15223c = f4;
        }

        private e() {
        }

        public e(float f2, float f3, float f4) {
            this.a = f2;
            this.b = f3;
            this.f15223c = f4;
        }

        public void a(@NonNull e eVar) {
            a(eVar.a, eVar.b, eVar.f15223c);
        }

        public boolean a() {
            return this.f15223c == Float.MAX_VALUE;
        }

        public e(@NonNull e eVar) {
            this(eVar.a, eVar.b, eVar.f15223c);
        }
    }

    void a();

    void b();

    @ColorInt
    int getCircularRevealScrimColor();

    @Nullable
    e getRevealInfo();

    void setCircularRevealOverlayDrawable(@Nullable Drawable drawable);

    void setCircularRevealScrimColor(@ColorInt int i2);

    void setRevealInfo(@Nullable e eVar);
}
