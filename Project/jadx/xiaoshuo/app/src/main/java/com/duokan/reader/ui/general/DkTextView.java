package com.duokan.reader.ui.general;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.yuewen.iq0;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class DkTextView extends View implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final iq0 f5396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f5397b;

    public DkTextView(Context context) {
        this(context, null);
    }

    public String a(RectF rectF) {
        return this.f5396a.o(rectF);
    }

    public boolean b() {
        return this.f5396a.t();
    }

    public boolean getChsToChtChars() {
        return this.f5396a.c();
    }

    public double getFirstLineIndent() {
        return this.f5396a.g();
    }

    public int getLineCount() {
        return this.f5396a.h();
    }

    public double getLineGap() {
        return this.f5396a.i();
    }

    public double getParaSpacing() {
        return this.f5396a.j();
    }

    public double getTabStop() {
        return this.f5396a.l();
    }

    public String getText() {
        return this.f5396a.m();
    }

    public Rect getTextBounds() {
        this.f5397b.set(this.f5396a.n());
        this.f5397b.offset(this.f5396a.getBounds().left, this.f5396a.n().top);
        return this.f5397b;
    }

    public float getTextSize() {
        return this.f5396a.p();
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable2) {
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f5396a.draw(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        this.f5396a.setBounds(getPaddingLeft(), getPaddingTop(), (View.MeasureSpec.getMode(i) != 0 ? View.MeasureSpec.getSize(i) : Integer.MAX_VALUE) - getPaddingRight(), (View.MeasureSpec.getMode(i2) != 0 ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE) - getPaddingBottom());
        setMeasuredDimension(View.resolveSize(Math.max(getSuggestedMinimumWidth(), this.f5396a.getIntrinsicWidth() + paddingLeft), i), View.resolveSize(Math.max(getSuggestedMinimumHeight(), this.f5396a.getIntrinsicHeight() + paddingTop), i2));
        this.f5396a.setBounds(getPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable2, Runnable runnable, long j) {
        postDelayed(runnable, j);
    }

    public void setChsToChtChars(boolean z) {
        this.f5396a.x(z);
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        this.f5396a.y(truncateAt);
        if (this.f5396a.u()) {
            return;
        }
        requestLayout();
    }

    public void setEnTypefaceFile(File file) {
        this.f5396a.z(file);
        if (this.f5396a.u()) {
            return;
        }
        requestLayout();
    }

    public void setEndLineGradual(boolean z) {
        this.f5396a.A(z);
    }

    public void setEndingEllipsisBlank(boolean z) {
        this.f5396a.B(z);
        if (this.f5396a.u()) {
            return;
        }
        requestLayout();
    }

    public void setFirstLineIndent(double d) {
        this.f5396a.C(d);
        if (this.f5396a.u()) {
            return;
        }
        requestLayout();
    }

    public void setGravity(int i) {
        this.f5396a.D(i);
    }

    public void setLineGap(double d) {
        this.f5396a.E(d);
        if (this.f5396a.u()) {
            return;
        }
        requestLayout();
    }

    public void setMaxLines(int i) {
        this.f5396a.F(i);
        if (this.f5396a.u()) {
            return;
        }
        requestLayout();
    }

    public void setParaSpacing(double d) {
        this.f5396a.G(d);
        if (this.f5396a.u()) {
            return;
        }
        requestLayout();
    }

    public void setTabStop(double d) {
        this.f5396a.H(d);
        if (this.f5396a.u()) {
            return;
        }
        requestLayout();
    }

    public void setText(int i) {
        setText(getResources().getString(i));
    }

    public void setTextColor(int i) {
        this.f5396a.J(i);
    }

    public void setTextPixelSize(int i) {
        this.f5396a.K(i);
        if (this.f5396a.u()) {
            return;
        }
        requestLayout();
    }

    public void setTextSize(float f) {
        this.f5396a.K(Math.round(TypedValue.applyDimension(2, f, getResources().getDisplayMetrics())));
        if (this.f5396a.u()) {
            return;
        }
        requestLayout();
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable2, Runnable runnable) {
        removeCallbacks(runnable);
    }

    public DkTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        iq0 iq0Var = new iq0();
        this.f5396a = iq0Var;
        this.f5397b = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.textSize, R.attr.textColor, R.attr.ellipsize, R.attr.gravity, R.attr.text, R.attr.maxLines});
        int integer = typedArrayObtainStyledAttributes.getInteger(3, 3);
        int integer2 = typedArrayObtainStyledAttributes.getInteger(5, Integer.MAX_VALUE);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 16);
        int color = typedArrayObtainStyledAttributes.getColor(1, -16777216);
        String string = typedArrayObtainStyledAttributes.hasValue(4) ? typedArrayObtainStyledAttributes.getString(4) : "";
        int i = typedArrayObtainStyledAttributes.getInt(2, 0);
        TextUtils.TruncateAt truncateAt = i != 2 ? i != 3 ? TextUtils.TruncateAt.END : TextUtils.TruncateAt.END : TextUtils.TruncateAt.MIDDLE;
        typedArrayObtainStyledAttributes.recycle();
        iq0Var.D(integer);
        iq0Var.F(integer2);
        iq0Var.K(dimensionPixelSize);
        iq0Var.J(color);
        iq0Var.I(string);
        iq0Var.y(truncateAt);
        iq0Var.getIntrinsicWidth();
        iq0Var.setCallback(this);
        setWillNotDraw(false);
    }

    public void setText(String str) {
        this.f5396a.I(str);
        if (this.f5396a.u()) {
            return;
        }
        requestLayout();
    }
}
