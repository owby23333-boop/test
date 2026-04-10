package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.l;
import com.google.android.material.internal.m;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.h;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialToolbar extends Toolbar {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f14971v = R$style.Widget_MaterialComponents_Toolbar;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private Integer f14972s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f14973t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f14974u;

    public MaterialToolbar(@NonNull Context context) {
        this(context, null);
    }

    private void a() {
        if (this.f14973t || this.f14974u) {
            TextView textViewB = m.b(this);
            TextView textViewA = m.a(this);
            if (textViewB == null && textViewA == null) {
                return;
            }
            Pair<Integer, Integer> pairA = a(textViewB, textViewA);
            if (this.f14973t && textViewB != null) {
                a(textViewB, pairA);
            }
            if (!this.f14974u || textViewA == null) {
                return;
            }
            a(textViewA, pairA);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.a(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        a();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        h.a(this, f2);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(a(drawable));
    }

    public void setNavigationIconTint(@ColorInt int i2) {
        this.f14972s = Integer.valueOf(i2);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z2) {
        if (this.f14974u != z2) {
            this.f14974u = z2;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z2) {
        if (this.f14973t != z2) {
            this.f14973t = z2;
            requestLayout();
        }
    }

    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, f14971v), attributeSet, i2);
        Context context2 = getContext();
        TypedArray typedArrayC = l.c(context2, attributeSet, R$styleable.MaterialToolbar, i2, f14971v, new int[0]);
        if (typedArrayC.hasValue(R$styleable.MaterialToolbar_navigationIconTint)) {
            setNavigationIconTint(typedArrayC.getColor(R$styleable.MaterialToolbar_navigationIconTint, -1));
        }
        this.f14973t = typedArrayC.getBoolean(R$styleable.MaterialToolbar_titleCentered, false);
        this.f14974u = typedArrayC.getBoolean(R$styleable.MaterialToolbar_subtitleCentered, false);
        typedArrayC.recycle();
        a(context2);
    }

    private Pair<Integer, Integer> a(@Nullable TextView textView, @Nullable TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i2 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i2 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i2 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void a(View view, Pair<Integer, Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i2 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i3 = measuredWidth2 + i2;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i2, 0), Math.max(i3 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i2 += iMax;
            i3 -= iMax;
            view.measure(View.MeasureSpec.makeMeasureSpec(i3 - i2, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i2, view.getTop(), i3, view.getBottom());
    }

    private void a(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.a(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            materialShapeDrawable.a(context);
            materialShapeDrawable.b(ViewCompat.getElevation(this));
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable) {
        if (drawable == null || this.f14972s == null) {
            return drawable;
        }
        Drawable drawableWrap = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawableWrap, this.f14972s.intValue());
        return drawableWrap;
    }
}
