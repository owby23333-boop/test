package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.b;

/* JADX INFO: loaded from: classes2.dex */
public class CircularRevealGridLayout extends GridLayout implements b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final CircularRevealHelper f15211s;

    public CircularRevealGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15211s = new CircularRevealHelper(this);
    }

    @Override // com.google.android.material.circularreveal.b
    public void a() {
        this.f15211s.a();
    }

    @Override // com.google.android.material.circularreveal.b
    public void b() {
        this.f15211s.b();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.a
    public boolean c() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        CircularRevealHelper circularRevealHelper = this.f15211s;
        if (circularRevealHelper != null) {
            circularRevealHelper.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f15211s.c();
    }

    @Override // com.google.android.material.circularreveal.b
    public int getCircularRevealScrimColor() {
        return this.f15211s.d();
    }

    @Override // com.google.android.material.circularreveal.b
    @Nullable
    public b.e getRevealInfo() {
        return this.f15211s.e();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        CircularRevealHelper circularRevealHelper = this.f15211s;
        return circularRevealHelper != null ? circularRevealHelper.f() : super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.b
    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.f15211s.a(drawable);
    }

    @Override // com.google.android.material.circularreveal.b
    public void setCircularRevealScrimColor(@ColorInt int i2) {
        this.f15211s.a(i2);
    }

    @Override // com.google.android.material.circularreveal.b
    public void setRevealInfo(@Nullable b.e eVar) {
        this.f15211s.a(eVar);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.a
    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
