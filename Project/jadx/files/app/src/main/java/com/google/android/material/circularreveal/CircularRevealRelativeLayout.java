package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.b;

/* JADX INFO: loaded from: classes2.dex */
public class CircularRevealRelativeLayout extends RelativeLayout implements b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final CircularRevealHelper f15221s;

    public CircularRevealRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15221s = new CircularRevealHelper(this);
    }

    @Override // com.google.android.material.circularreveal.b
    public void a() {
        this.f15221s.a();
    }

    @Override // com.google.android.material.circularreveal.b
    public void b() {
        this.f15221s.b();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.a
    public boolean c() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        CircularRevealHelper circularRevealHelper = this.f15221s;
        if (circularRevealHelper != null) {
            circularRevealHelper.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f15221s.c();
    }

    @Override // com.google.android.material.circularreveal.b
    public int getCircularRevealScrimColor() {
        return this.f15221s.d();
    }

    @Override // com.google.android.material.circularreveal.b
    @Nullable
    public b.e getRevealInfo() {
        return this.f15221s.e();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        CircularRevealHelper circularRevealHelper = this.f15221s;
        return circularRevealHelper != null ? circularRevealHelper.f() : super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.b
    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.f15221s.a(drawable);
    }

    @Override // com.google.android.material.circularreveal.b
    public void setCircularRevealScrimColor(@ColorInt int i2) {
        this.f15221s.a(i2);
    }

    @Override // com.google.android.material.circularreveal.b
    public void setRevealInfo(@Nullable b.e eVar) {
        this.f15221s.a(eVar);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.a
    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
