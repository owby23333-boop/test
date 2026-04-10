package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: ShapeAppearanceModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final com.google.android.material.shape.c f15721m = new j(0.5f);
    d a;
    d b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    d f15722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    d f15723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    com.google.android.material.shape.c f15724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    com.google.android.material.shape.c f15725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    com.google.android.material.shape.c f15726g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    com.google.android.material.shape.c f15727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    f f15728i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    f f15729j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    f f15730k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    f f15731l;

    /* JADX INFO: compiled from: ShapeAppearanceModel.java */
    public static final class b {

        @NonNull
        private d a;

        @NonNull
        private d b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        private d f15732c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NonNull
        private d f15733d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NonNull
        private com.google.android.material.shape.c f15734e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NonNull
        private com.google.android.material.shape.c f15735f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NonNull
        private com.google.android.material.shape.c f15736g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @NonNull
        private com.google.android.material.shape.c f15737h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @NonNull
        private f f15738i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @NonNull
        private f f15739j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @NonNull
        private f f15740k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @NonNull
        private f f15741l;

        public b() {
            this.a = h.a();
            this.b = h.a();
            this.f15732c = h.a();
            this.f15733d = h.a();
            this.f15734e = new com.google.android.material.shape.a(0.0f);
            this.f15735f = new com.google.android.material.shape.a(0.0f);
            this.f15736g = new com.google.android.material.shape.a(0.0f);
            this.f15737h = new com.google.android.material.shape.a(0.0f);
            this.f15738i = h.b();
            this.f15739j = h.b();
            this.f15740k = h.b();
            this.f15741l = h.b();
        }

        private static float f(d dVar) {
            if (dVar instanceof k) {
                return ((k) dVar).a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).a;
            }
            return -1.0f;
        }

        @NonNull
        public b a(int i2, @Dimension float f2) {
            a(h.a(i2));
            a(f2);
            return this;
        }

        @NonNull
        public b b(@Dimension float f2) {
            this.f15737h = new com.google.android.material.shape.a(f2);
            return this;
        }

        @NonNull
        public b c(@Dimension float f2) {
            this.f15736g = new com.google.android.material.shape.a(f2);
            return this;
        }

        @NonNull
        public b d(@Dimension float f2) {
            this.f15734e = new com.google.android.material.shape.a(f2);
            return this;
        }

        @NonNull
        public b e(@Dimension float f2) {
            this.f15735f = new com.google.android.material.shape.a(f2);
            return this;
        }

        @NonNull
        public b b(@NonNull com.google.android.material.shape.c cVar) {
            this.f15737h = cVar;
            return this;
        }

        @NonNull
        public b c(@NonNull com.google.android.material.shape.c cVar) {
            this.f15736g = cVar;
            return this;
        }

        @NonNull
        public b d(@NonNull com.google.android.material.shape.c cVar) {
            this.f15734e = cVar;
            return this;
        }

        @NonNull
        public b e(@NonNull com.google.android.material.shape.c cVar) {
            this.f15735f = cVar;
            return this;
        }

        @NonNull
        public b a(@NonNull d dVar) {
            d(dVar);
            e(dVar);
            c(dVar);
            b(dVar);
            return this;
        }

        @NonNull
        public b b(int i2, @NonNull com.google.android.material.shape.c cVar) {
            c(h.a(i2));
            c(cVar);
            return this;
        }

        @NonNull
        public b c(int i2, @NonNull com.google.android.material.shape.c cVar) {
            d(h.a(i2));
            d(cVar);
            return this;
        }

        @NonNull
        public b d(@NonNull d dVar) {
            this.a = dVar;
            float f2 = f(dVar);
            if (f2 != -1.0f) {
                d(f2);
            }
            return this;
        }

        @NonNull
        public b e(@NonNull d dVar) {
            this.b = dVar;
            float f2 = f(dVar);
            if (f2 != -1.0f) {
                e(f2);
            }
            return this;
        }

        @NonNull
        public b b(@NonNull d dVar) {
            this.f15733d = dVar;
            float f2 = f(dVar);
            if (f2 != -1.0f) {
                b(f2);
            }
            return this;
        }

        @NonNull
        public b c(@NonNull d dVar) {
            this.f15732c = dVar;
            float f2 = f(dVar);
            if (f2 != -1.0f) {
                c(f2);
            }
            return this;
        }

        @NonNull
        public b d(int i2, @NonNull com.google.android.material.shape.c cVar) {
            e(h.a(i2));
            e(cVar);
            return this;
        }

        @NonNull
        public b a(@NonNull com.google.android.material.shape.c cVar) {
            d(cVar);
            e(cVar);
            c(cVar);
            b(cVar);
            return this;
        }

        @NonNull
        public b b(@NonNull f fVar) {
            this.f15738i = fVar;
            return this;
        }

        @NonNull
        public b a(@Dimension float f2) {
            d(f2);
            e(f2);
            c(f2);
            b(f2);
            return this;
        }

        public b(@NonNull l lVar) {
            this.a = h.a();
            this.b = h.a();
            this.f15732c = h.a();
            this.f15733d = h.a();
            this.f15734e = new com.google.android.material.shape.a(0.0f);
            this.f15735f = new com.google.android.material.shape.a(0.0f);
            this.f15736g = new com.google.android.material.shape.a(0.0f);
            this.f15737h = new com.google.android.material.shape.a(0.0f);
            this.f15738i = h.b();
            this.f15739j = h.b();
            this.f15740k = h.b();
            this.f15741l = h.b();
            this.a = lVar.a;
            this.b = lVar.b;
            this.f15732c = lVar.f15722c;
            this.f15733d = lVar.f15723d;
            this.f15734e = lVar.f15724e;
            this.f15735f = lVar.f15725f;
            this.f15736g = lVar.f15726g;
            this.f15737h = lVar.f15727h;
            this.f15738i = lVar.f15728i;
            this.f15739j = lVar.f15729j;
            this.f15740k = lVar.f15730k;
            this.f15741l = lVar.f15731l;
        }

        @NonNull
        public b a(int i2, @NonNull com.google.android.material.shape.c cVar) {
            b(h.a(i2));
            b(cVar);
            return this;
        }

        @NonNull
        public b a(@NonNull f fVar) {
            this.f15740k = fVar;
            return this;
        }

        @NonNull
        public l a() {
            return new l(this);
        }
    }

    /* JADX INFO: compiled from: ShapeAppearanceModel.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface c {
        @NonNull
        com.google.android.material.shape.c a(@NonNull com.google.android.material.shape.c cVar);
    }

    @NonNull
    public static b a(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        return a(context, attributeSet, i2, i3, 0);
    }

    @NonNull
    public static b n() {
        return new b();
    }

    @NonNull
    public d b() {
        return this.f15723d;
    }

    @NonNull
    public com.google.android.material.shape.c c() {
        return this.f15727h;
    }

    @NonNull
    public d d() {
        return this.f15722c;
    }

    @NonNull
    public com.google.android.material.shape.c e() {
        return this.f15726g;
    }

    @NonNull
    public f f() {
        return this.f15731l;
    }

    @NonNull
    public f g() {
        return this.f15729j;
    }

    @NonNull
    public f h() {
        return this.f15728i;
    }

    @NonNull
    public d i() {
        return this.a;
    }

    @NonNull
    public com.google.android.material.shape.c j() {
        return this.f15724e;
    }

    @NonNull
    public d k() {
        return this.b;
    }

    @NonNull
    public com.google.android.material.shape.c l() {
        return this.f15725f;
    }

    @NonNull
    public b m() {
        return new b(this);
    }

    private l(@NonNull b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.f15722c = bVar.f15732c;
        this.f15723d = bVar.f15733d;
        this.f15724e = bVar.f15734e;
        this.f15725f = bVar.f15735f;
        this.f15726g = bVar.f15736g;
        this.f15727h = bVar.f15737h;
        this.f15728i = bVar.f15738i;
        this.f15729j = bVar.f15739j;
        this.f15730k = bVar.f15740k;
        this.f15731l = bVar.f15741l;
    }

    @NonNull
    public static b a(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3, int i4) {
        return a(context, attributeSet, i2, i3, new com.google.android.material.shape.a(i4));
    }

    @NonNull
    public static b a(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3, @NonNull com.google.android.material.shape.c cVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, i2, i3);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, cVar);
    }

    @NonNull
    public static b a(Context context, @StyleRes int i2, @StyleRes int i3) {
        return a(context, i2, i3, 0);
    }

    @NonNull
    private static b a(Context context, @StyleRes int i2, @StyleRes int i3, int i4) {
        return a(context, i2, i3, new com.google.android.material.shape.a(i4));
    }

    @NonNull
    private static b a(Context context, @StyleRes int i2, @StyleRes int i3, @NonNull com.google.android.material.shape.c cVar) {
        if (i3 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
            i2 = i3;
            context = contextThemeWrapper;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.ShapeAppearance);
        try {
            int i4 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamily, 0);
            int i5 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopLeft, i4);
            int i6 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopRight, i4);
            int i7 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomRight, i4);
            int i8 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomLeft, i4);
            com.google.android.material.shape.c cVarA = a(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSize, cVar);
            com.google.android.material.shape.c cVarA2 = a(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopLeft, cVarA);
            com.google.android.material.shape.c cVarA3 = a(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopRight, cVarA);
            com.google.android.material.shape.c cVarA4 = a(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomRight, cVarA);
            com.google.android.material.shape.c cVarA5 = a(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomLeft, cVarA);
            b bVar = new b();
            bVar.c(i5, cVarA2);
            bVar.d(i6, cVarA3);
            bVar.b(i7, cVarA4);
            bVar.a(i8, cVarA5);
            return bVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public l() {
        this.a = h.a();
        this.b = h.a();
        this.f15722c = h.a();
        this.f15723d = h.a();
        this.f15724e = new com.google.android.material.shape.a(0.0f);
        this.f15725f = new com.google.android.material.shape.a(0.0f);
        this.f15726g = new com.google.android.material.shape.a(0.0f);
        this.f15727h = new com.google.android.material.shape.a(0.0f);
        this.f15728i = h.b();
        this.f15729j = h.b();
        this.f15730k = h.b();
        this.f15731l = h.b();
    }

    @NonNull
    private static com.google.android.material.shape.c a(TypedArray typedArray, int i2, @NonNull com.google.android.material.shape.c cVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        if (typedValuePeekValue == null) {
            return cVar;
        }
        int i3 = typedValuePeekValue.type;
        if (i3 == 5) {
            return new com.google.android.material.shape.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i3 == 6 ? new j(typedValuePeekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    @NonNull
    public f a() {
        return this.f15730k;
    }

    @NonNull
    public l a(float f2) {
        b bVarM = m();
        bVarM.a(f2);
        return bVarM.a();
    }

    @NonNull
    public l a(@NonNull com.google.android.material.shape.c cVar) {
        b bVarM = m();
        bVarM.a(cVar);
        return bVarM.a();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public l a(@NonNull c cVar) {
        b bVarM = m();
        bVarM.d(cVar.a(j()));
        bVarM.e(cVar.a(l()));
        bVarM.b(cVar.a(c()));
        bVarM.c(cVar.a(e()));
        return bVarM.a();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean a(@NonNull RectF rectF) {
        boolean z2 = this.f15731l.getClass().equals(f.class) && this.f15729j.getClass().equals(f.class) && this.f15728i.getClass().equals(f.class) && this.f15730k.getClass().equals(f.class);
        float fA = this.f15724e.a(rectF);
        return z2 && ((this.f15725f.a(rectF) > fA ? 1 : (this.f15725f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f15727h.a(rectF) > fA ? 1 : (this.f15727h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f15726g.a(rectF) > fA ? 1 : (this.f15726g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.b instanceof k) && (this.a instanceof k) && (this.f15722c instanceof k) && (this.f15723d instanceof k));
    }
}
