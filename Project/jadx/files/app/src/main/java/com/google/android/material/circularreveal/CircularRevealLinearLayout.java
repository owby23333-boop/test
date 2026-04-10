package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.b;

/* JADX INFO: loaded from: classes2.dex */
public class CircularRevealLinearLayout extends LinearLayout implements b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final CircularRevealHelper f15220s;

    public CircularRevealLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15220s = new CircularRevealHelper(this);
    }

    @Override // com.google.android.material.circularreveal.b
    public void a() {
        this.f15220s.a();
    }

    @Override // com.google.android.material.circularreveal.b
    public void b() {
        this.f15220s.b();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.a
    public boolean c() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        CircularRevealHelper circularRevealHelper = this.f15220s;
        if (circularRevealHelper != null) {
            circularRevealHelper.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f15220s.c();
    }

    @Override // com.google.android.material.circularreveal.b
    public int getCircularRevealScrimColor() {
        return this.f15220s.d();
    }

    @Override // com.google.android.material.circularreveal.b
    @Nullable
    public b.e getRevealInfo() {
        return this.f15220s.e();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        CircularRevealHelper circularRevealHelper = this.f15220s;
        return circularRevealHelper != null ? circularRevealHelper.f() : super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.b
    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.f15220s.a(drawable);
    }

    @Override // com.google.android.material.circularreveal.b
    public void setCircularRevealScrimColor(@ColorInt int i2) {
        this.f15220s.a(i2);
    }

    @Override // com.google.android.material.circularreveal.b
    public void setRevealInfo(@Nullable b.e eVar) {
        this.f15220s.a(eVar);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.a
    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
