package com.mardous.discreteseekbar.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.mardous.discreteseekbar.R$attr;
import com.mardous.discreteseekbar.R$style;
import com.mardous.discreteseekbar.R$styleable;
import com.mardous.discreteseekbar.a.d.b;

/* JADX INFO: compiled from: Marker.java */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ViewConstructor"})
public class a extends ViewGroup implements b.InterfaceC0500b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f17616s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f17617t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f17618u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private com.mardous.discreteseekbar.a.d.b f17619v;

    public a(Context context, AttributeSet attributeSet, int i2, String str, int i3, int i4) {
        super(context, attributeSet, i2);
        setVisibility(0);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DiscreteSeekBar, R$attr.discreteSeekBarStyle, R$style.Widget_DiscreteSeekBar);
        int i5 = ((int) (displayMetrics.density * 4.0f)) * 2;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.DiscreteSeekBar_dsb_indicatorTextAppearance, R$style.Widget_DiscreteIndicatorTextAppearance);
        this.f17616s = new TextView(context);
        this.f17616s.setPadding(i5, 0, i5, 0);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f17616s.setTextAppearance(resourceId);
        } else {
            this.f17616s.setTextAppearance(context, resourceId);
        }
        this.f17616s.setGravity(17);
        this.f17616s.setText(str);
        this.f17616s.setMaxLines(1);
        this.f17616s.setSingleLine(true);
        if (Build.VERSION.SDK_INT >= 17) {
            this.f17616s.setTextDirection(5);
        }
        this.f17616s.setVisibility(4);
        setPadding(i5, i5, i5, i5);
        a(str);
        this.f17618u = i4;
        this.f17619v = new com.mardous.discreteseekbar.a.d.b(typedArrayObtainStyledAttributes.getColorStateList(R$styleable.DiscreteSeekBar_dsb_indicatorColor), i3);
        this.f17619v.setCallback(this);
        this.f17619v.a(this);
        this.f17619v.b(i5);
        ViewCompat.setElevation(this, typedArrayObtainStyledAttributes.getDimension(R$styleable.DiscreteSeekBar_dsb_indicatorElevation, displayMetrics.density * 8.0f));
        typedArrayObtainStyledAttributes.recycle();
    }

    public void a(String str) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f17616s.setText("-" + str);
        this.f17616s.measure(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE));
        this.f17617t = Math.max(this.f17616s.getMeasuredWidth(), this.f17616s.getMeasuredHeight());
        removeView(this.f17616s);
        TextView textView = this.f17616s;
        int i2 = this.f17617t;
        addView(textView, new FrameLayout.LayoutParams(i2, i2, 51));
    }

    @Override // com.mardous.discreteseekbar.a.d.b.InterfaceC0500b
    public void b() {
        this.f17616s.setVisibility(0);
        if (getParent() instanceof b.InterfaceC0500b) {
            ((b.InterfaceC0500b) getParent()).b();
        }
    }

    void c() {
        this.f17619v.stop();
        this.f17616s.setVisibility(4);
        this.f17619v.a();
    }

    void d() {
        this.f17619v.stop();
        this.f17619v.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f17619v.draw(canvas);
        super.dispatchDraw(canvas);
    }

    public CharSequence getValue() {
        return this.f17616s.getText();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f17619v.stop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        TextView textView = this.f17616s;
        int i6 = this.f17617t;
        textView.layout(paddingLeft, paddingTop, paddingLeft + i6, i6 + paddingTop);
        this.f17619v.setBounds(paddingLeft, paddingTop, width, height);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        measureChildren(i2, i3);
        int paddingLeft = this.f17617t + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.f17617t + getPaddingTop() + getPaddingBottom();
        int i4 = this.f17617t;
        setMeasuredDimension(paddingLeft, paddingTop + (((int) ((i4 * 1.41f) - i4)) / 2) + this.f17618u);
    }

    void setValue(CharSequence charSequence) {
        this.f17616s.setText(charSequence);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f17619v || super.verifyDrawable(drawable);
    }

    @Override // com.mardous.discreteseekbar.a.d.b.InterfaceC0500b
    public void a() {
        if (getParent() instanceof b.InterfaceC0500b) {
            ((b.InterfaceC0500b) getParent()).a();
        }
    }
}
