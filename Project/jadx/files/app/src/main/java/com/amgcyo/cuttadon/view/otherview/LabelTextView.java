package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes.dex */
public class LabelTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    LabelViewHelper f4994s;

    public LabelTextView(Context context) {
        this(context, null);
    }

    public int getLabelBackgroundColor() {
        return this.f4994s.a();
    }

    public int getLabelDistance() {
        return this.f4994s.b();
    }

    public int getLabelHeight() {
        return this.f4994s.c();
    }

    public int getLabelOrientation() {
        return this.f4994s.d();
    }

    public String getLabelText() {
        return this.f4994s.e();
    }

    public int getLabelTextColor() {
        return this.f4994s.f();
    }

    public int getLabelTextSize() {
        return this.f4994s.g();
    }

    public int getLabelTextStyle() {
        return this.f4994s.h();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f4994s.a(canvas, getMeasuredWidth(), getMeasuredHeight());
    }

    public void setLabelBackgroundColor(int i2) {
        this.f4994s.a(this, i2);
    }

    public void setLabelDistance(int i2) {
        this.f4994s.b(this, i2);
    }

    public void setLabelEnable(boolean z2) {
        this.f4994s.a(this, z2);
    }

    public void setLabelHeight(int i2) {
        this.f4994s.c(this, i2);
    }

    public void setLabelOrientation(int i2) {
        this.f4994s.d(this, i2);
    }

    public void setLabelText(String str) {
        this.f4994s.a(this, str);
    }

    public void setLabelTextColor(int i2) {
        this.f4994s.e(this, i2);
    }

    public void setLabelTextSize(int i2) {
        this.f4994s.f(this, i2);
    }

    public void setLabelTextStyle(int i2) {
        this.f4994s.g(this, i2);
    }

    public LabelTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LabelTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4994s = new LabelViewHelper(context, attributeSet, i2);
    }
}
