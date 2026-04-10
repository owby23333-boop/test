package com.google.android.material.j;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.google.android.material.shape.o;

/* JADX INFO: compiled from: RippleDrawableCompat.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a extends Drawable implements o, TintAwareDrawable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private b f15548s;

    /* JADX INFO: compiled from: RippleDrawableCompat.java */
    static final class b extends Drawable.ConstantState {

        @NonNull
        MaterialShapeDrawable a;
        boolean b;

        public b(MaterialShapeDrawable materialShapeDrawable) {
            this.a = materialShapeDrawable;
            this.b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public a newDrawable() {
            return new a(new b(this));
        }

        public b(@NonNull b bVar) {
            this.a = (MaterialShapeDrawable) bVar.a.getConstantState().newDrawable();
            this.b = bVar.b;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f15548s;
        if (bVar.b) {
            bVar.a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f15548s;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f15548s.a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public /* bridge */ /* synthetic */ Drawable mutate() {
        mutate();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.f15548s.a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(@NonNull int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f15548s.a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zA = com.google.android.material.j.b.a(iArr);
        b bVar = this.f15548s;
        if (bVar.b == zA) {
            return zOnStateChange;
        }
        bVar.b = zA;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f15548s.a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f15548s.a.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.shape.o
    public void setShapeAppearanceModel(@NonNull l lVar) {
        this.f15548s.a.setShapeAppearanceModel(lVar);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i2) {
        this.f15548s.a.setTint(i2);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.f15548s.a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.f15548s.a.setTintMode(mode);
    }

    public a(l lVar) {
        this(new b(new MaterialShapeDrawable(lVar)));
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public a mutate() {
        this.f15548s = new b(this.f15548s);
        return this;
    }

    private a(b bVar) {
        this.f15548s = bVar;
    }
}
