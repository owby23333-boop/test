package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R$color;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import java.util.ArrayList;

/* JADX INFO: compiled from: FloatingActionButtonImplLollipop.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
class e extends d {

    /* JADX INFO: compiled from: FloatingActionButtonImplLollipop.java */
    static class a extends MaterialShapeDrawable {
        a(l lVar) {
            super(lVar);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    e(FloatingActionButton floatingActionButton, com.google.android.material.k.b bVar) {
        super(floatingActionButton, bVar);
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void a(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable layerDrawable;
        this.b = a();
        this.b.setTintList(colorStateList);
        if (mode != null) {
            this.b.setTintMode(mode);
        }
        this.b.a(this.f15404y.getContext());
        if (i2 > 0) {
            this.f15383d = a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.f15383d), (Drawable) Preconditions.checkNotNull(this.b)});
        } else {
            this.f15383d = null;
            layerDrawable = this.b;
        }
        this.f15382c = new RippleDrawable(com.google.android.material.j.b.b(colorStateList2), layerDrawable, null);
        this.f15384e = this.f15382c;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void b(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f15382c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(com.google.android.material.j.b.b(colorStateList));
        } else {
            super.b(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public float c() {
        return this.f15404y.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void l() {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void n() {
        x();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean s() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean t() {
        return this.f15405z.a() || !u();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void v() {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void a(float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT == 21) {
            this.f15404y.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(d.G, a(f2, f4));
            stateListAnimator.addState(d.H, a(f2, f3));
            stateListAnimator.addState(d.I, a(f2, f3));
            stateListAnimator.addState(d.J, a(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.f15404y, "elevation", f2).setDuration(0L));
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 22 && i2 <= 24) {
                FloatingActionButton floatingActionButton = this.f15404y;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.f15404y, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(d.F);
            stateListAnimator.addState(d.K, animatorSet);
            stateListAnimator.addState(d.L, a(0.0f, 0.0f));
            this.f15404y.setStateListAnimator(stateListAnimator);
        }
        if (t()) {
            x();
        }
    }

    @NonNull
    private Animator a(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f15404y, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f15404y, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(d.F);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void a(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (this.f15404y.isEnabled()) {
                this.f15404y.setElevation(this.f15387h);
                if (this.f15404y.isPressed()) {
                    this.f15404y.setTranslationZ(this.f15389j);
                    return;
                } else if (!this.f15404y.isFocused() && !this.f15404y.isHovered()) {
                    this.f15404y.setTranslationZ(0.0f);
                    return;
                } else {
                    this.f15404y.setTranslationZ(this.f15388i);
                    return;
                }
            }
            this.f15404y.setElevation(0.0f);
            this.f15404y.setTranslationZ(0.0f);
        }
    }

    @NonNull
    c a(int i2, ColorStateList colorStateList) {
        Context context = this.f15404y.getContext();
        c cVar = new c((l) Preconditions.checkNotNull(this.a));
        cVar.a(ContextCompat.getColor(context, R$color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, R$color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, R$color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, R$color.design_fab_stroke_end_outer_color));
        cVar.a(i2);
        cVar.a(colorStateList);
        return cVar;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    @NonNull
    MaterialShapeDrawable a() {
        return new a((l) Preconditions.checkNotNull(this.a));
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void a(@NonNull Rect rect) {
        if (this.f15405z.a()) {
            super.a(rect);
        } else if (!u()) {
            int sizeDimension = (this.f15390k - this.f15404y.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }
}
