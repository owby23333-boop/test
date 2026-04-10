package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: CalendarStyle.java */
/* JADX INFO: loaded from: classes2.dex */
final class b {

    @NonNull
    final a a;

    @NonNull
    final a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    final a f15300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    final a f15301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    final a f15302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    final a f15303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    final a f15304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    final Paint f15305h;

    b(@NonNull Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(com.google.android.material.i.b.a(context, R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R$styleable.MaterialCalendar);
        this.a = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayStyle, 0));
        this.f15304g = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.b = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f15300c = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateListA = com.google.android.material.i.c.a(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendar_rangeFillColor);
        this.f15301d = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearStyle, 0));
        this.f15302e = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f15303f = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearTodayStyle, 0));
        this.f15305h = new Paint();
        this.f15305h.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
