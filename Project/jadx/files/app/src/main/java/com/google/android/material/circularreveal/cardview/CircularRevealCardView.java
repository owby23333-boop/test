package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.b;

/* JADX INFO: loaded from: classes2.dex */
public class CircularRevealCardView extends MaterialCardView implements b {

    @NonNull
    private final CircularRevealHelper B;

    public CircularRevealCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = new CircularRevealHelper(this);
    }

    @Override // com.google.android.material.circularreveal.b
    public void a() {
        this.B.a();
    }

    @Override // com.google.android.material.circularreveal.b
    public void b() {
        this.B.b();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.a
    public boolean c() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        CircularRevealHelper circularRevealHelper = this.B;
        if (circularRevealHelper != null) {
            circularRevealHelper.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.B.c();
    }

    @Override // com.google.android.material.circularreveal.b
    public int getCircularRevealScrimColor() {
        return this.B.d();
    }

    @Override // com.google.android.material.circularreveal.b
    @Nullable
    public b.e getRevealInfo() {
        return this.B.e();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        CircularRevealHelper circularRevealHelper = this.B;
        return circularRevealHelper != null ? circularRevealHelper.f() : super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.b
    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.B.a(drawable);
    }

    @Override // com.google.android.material.circularreveal.b
    public void setCircularRevealScrimColor(@ColorInt int i2) {
        this.B.a(i2);
    }

    @Override // com.google.android.material.circularreveal.b
    public void setRevealInfo(@Nullable b.e eVar) {
        this.B.a(eVar);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.a
    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
