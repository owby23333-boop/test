package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: compiled from: CalendarItemStyle.java */
/* JADX INFO: loaded from: classes2.dex */
final class a {

    @NonNull
    private final Rect a;
    private final ColorStateList b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ColorStateList f15296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ColorStateList f15297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f15298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.material.shape.l f15299f;

    private a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i2, com.google.android.material.shape.l lVar, @NonNull Rect rect) {
        Preconditions.checkArgumentNonnegative(rect.left);
        Preconditions.checkArgumentNonnegative(rect.top);
        Preconditions.checkArgumentNonnegative(rect.right);
        Preconditions.checkArgumentNonnegative(rect.bottom);
        this.a = rect;
        this.b = colorStateList2;
        this.f15296c = colorStateList;
        this.f15297d = colorStateList3;
        this.f15298e = i2;
        this.f15299f = lVar;
    }

    @NonNull
    static a a(@NonNull Context context, @StyleRes int i2) {
        Preconditions.checkArgument(i2 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateListA = com.google.android.material.i.c.a(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateListA2 = com.google.android.material.i.c.a(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateListA3 = com.google.android.material.i.c.a(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        com.google.android.material.shape.l lVarA = com.google.android.material.shape.l.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).a();
        typedArrayObtainStyledAttributes.recycle();
        return new a(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, lVarA, rect);
    }

    int b() {
        return this.a.top;
    }

    void a(@NonNull TextView textView) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable();
        materialShapeDrawable.setShapeAppearanceModel(this.f15299f);
        materialShapeDrawable2.setShapeAppearanceModel(this.f15299f);
        materialShapeDrawable.a(this.f15296c);
        materialShapeDrawable.a(this.f15298e, this.f15297d);
        textView.setTextColor(this.b);
        Drawable rippleDrawable = Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.b.withAlpha(30), materialShapeDrawable, materialShapeDrawable2) : materialShapeDrawable;
        Rect rect = this.a;
        ViewCompat.setBackground(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }

    int a() {
        return this.a.bottom;
    }
}
