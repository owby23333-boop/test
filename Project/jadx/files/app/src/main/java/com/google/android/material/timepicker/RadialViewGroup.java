package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.j;

/* JADX INFO: loaded from: classes2.dex */
class RadialViewGroup extends ConstraintLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Runnable f16044s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f16045t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private MaterialShapeDrawable f16046u;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RadialViewGroup.this.b();
        }
    }

    public RadialViewGroup(@NonNull Context context) {
        this(context, null);
    }

    private Drawable c() {
        this.f16046u = new MaterialShapeDrawable();
        this.f16046u.a(new j(0.5f));
        this.f16046u.a(ColorStateList.valueOf(-1));
        return this.f16046u;
    }

    private void d() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f16044s);
            handler.post(this.f16044s);
        }
    }

    public void a(@Dimension int i2) {
        this.f16045t = i2;
        b();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.generateViewId());
        }
        d();
    }

    protected void b() {
        int childCount = getChildCount();
        int i2 = 1;
        for (int i3 = 0; i3 < childCount; i3++) {
            if (a(getChildAt(i3))) {
                i2++;
            }
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        float f2 = 0.0f;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getId() != R$id.circle_center && !a(childAt)) {
                constraintSet.constrainCircle(childAt.getId(), R$id.circle_center, this.f16045t, f2);
                f2 += 360.0f / (childCount - i2);
            }
        }
        constraintSet.applyTo(this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        b();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        d();
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i2) {
        this.f16046u.a(ColorStateList.valueOf(i2));
    }

    public RadialViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RadialViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater.from(context).inflate(R$layout.material_radial_view_group, this);
        ViewCompat.setBackground(this, c());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RadialViewGroup, i2, 0);
        this.f16045t = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.RadialViewGroup_materialCircleRadius, 0);
        this.f16044s = new a();
        typedArrayObtainStyledAttributes.recycle();
    }

    @Dimension
    public int a() {
        return this.f16045t;
    }

    private static boolean a(View view) {
        return "skip".equals(view.getTag());
    }
}
