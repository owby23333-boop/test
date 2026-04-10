package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.google.android.material.a.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BaseMotionStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class b implements f {
    private final Context a;

    @NonNull
    private final ExtendedFloatingActionButton b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<Animator.AnimatorListener> f15364c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.a f15365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private h f15366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private h f15367f;

    b(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton, com.google.android.material.floatingactionbutton.a aVar) {
        this.b = extendedFloatingActionButton;
        this.a = extendedFloatingActionButton.getContext();
        this.f15365d = aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @CallSuper
    public void b() {
        this.f15365d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public AnimatorSet c() {
        return b(i());
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @Nullable
    public h e() {
        return this.f15367f;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @NonNull
    public final List<Animator.AnimatorListener> h() {
        return this.f15364c;
    }

    public final h i() {
        h hVar = this.f15367f;
        if (hVar != null) {
            return hVar;
        }
        if (this.f15366e == null) {
            this.f15366e = h.a(this.a, g());
        }
        return (h) Preconditions.checkNotNull(this.f15366e);
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @CallSuper
    public void onAnimationStart(Animator animator) {
        this.f15365d.a(animator);
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final void a(@Nullable h hVar) {
        this.f15367f = hVar;
    }

    @NonNull
    AnimatorSet b(@NonNull h hVar) {
        ArrayList arrayList = new ArrayList();
        if (hVar.c("opacity")) {
            arrayList.add(hVar.a("opacity", this.b, (Property<ExtendedFloatingActionButton, ?>) View.ALPHA));
        }
        if (hVar.c("scale")) {
            arrayList.add(hVar.a("scale", this.b, (Property<ExtendedFloatingActionButton, ?>) View.SCALE_Y));
            arrayList.add(hVar.a("scale", this.b, (Property<ExtendedFloatingActionButton, ?>) View.SCALE_X));
        }
        if (hVar.c("width")) {
            arrayList.add(hVar.a("width", this.b, (Property<ExtendedFloatingActionButton, ?>) ExtendedFloatingActionButton.f15340a0));
        }
        if (hVar.c("height")) {
            arrayList.add(hVar.a("height", this.b, (Property<ExtendedFloatingActionButton, ?>) ExtendedFloatingActionButton.f15341b0));
        }
        if (hVar.c("paddingStart")) {
            arrayList.add(hVar.a("paddingStart", this.b, (Property<ExtendedFloatingActionButton, ?>) ExtendedFloatingActionButton.f15342c0));
        }
        if (hVar.c("paddingEnd")) {
            arrayList.add(hVar.a("paddingEnd", this.b, (Property<ExtendedFloatingActionButton, ?>) ExtendedFloatingActionButton.f15343d0));
        }
        if (hVar.c("labelOpacity")) {
            arrayList.add(hVar.a("labelOpacity", this.b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @CallSuper
    public void a() {
        this.f15365d.b();
    }

    /* JADX INFO: compiled from: BaseMotionStrategy.java */
    class a extends Property<ExtendedFloatingActionButton, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            return Float.valueOf(com.google.android.material.a.a.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.V.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.b.V.getDefaultColor()))));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f2) {
            int colorForState = extendedFloatingActionButton.V.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.b.V.getDefaultColor());
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.argb((int) (com.google.android.material.a.a.a(0.0f, Color.alpha(colorForState) / 255.0f, f2.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f2.floatValue() == 1.0f) {
                extendedFloatingActionButton.a(extendedFloatingActionButton.V);
            } else {
                extendedFloatingActionButton.a(colorStateListValueOf);
            }
        }
    }
}
