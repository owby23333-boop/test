package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class AutoResizeTextView extends TextView {
    private static final int a = 1000;
    private static final int b = 5;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextPaint f6089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f6090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f6091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f6093g;

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6090d = 1.0f;
        this.f6091e = 0.0f;
        this.f6092f = false;
        this.f6093g = false;
        a();
    }

    private void a() {
        this.f6089c = new TextPaint();
    }

    private void b() {
        CharSequence text = getText();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (width == 0 || height == 0 || TextUtils.isEmpty(text)) {
            return;
        }
        this.f6093g = true;
        int textSize = (int) getTextSize();
        while (textSize >= 5) {
            this.f6089c.setTextSize(textSize);
            int iMeasureText = (int) this.f6089c.measureText(text, 0, text.length());
            int height2 = new StaticLayout(text, this.f6089c, width, Layout.Alignment.ALIGN_NORMAL, this.f6090d, this.f6091e, true).getHeight();
            if (iMeasureText < width && height2 < height) {
                break;
            } else {
                textSize--;
            }
        }
        setTextSize(0, textSize);
        this.f6093g = false;
        this.f6092f = false;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f6093g) {
            return;
        }
        if (!this.f6092f) {
            super.onDraw(canvas);
            return;
        }
        CharSequence text = getText();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (width == 0 || height == 0 || TextUtils.isEmpty(text)) {
            return;
        }
        this.f6093g = true;
        int textSize = (int) getTextSize();
        while (textSize >= 5) {
            this.f6089c.setTextSize(textSize);
            int iMeasureText = (int) this.f6089c.measureText(text, 0, text.length());
            int height2 = new StaticLayout(text, this.f6089c, width, Layout.Alignment.ALIGN_NORMAL, this.f6090d, this.f6091e, true).getHeight();
            if (iMeasureText < width && height2 < height) {
                break;
            } else {
                textSize--;
            }
        }
        setTextSize(0, textSize);
        this.f6093g = false;
        this.f6092f = false;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f6092f = true;
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        this.f6092f = true;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f2, float f3) {
        super.setLineSpacing(f2, f3);
        this.f6090d = f3;
        this.f6091e = f2;
    }

    private int a(CharSequence charSequence, int i2) {
        return new StaticLayout(charSequence, this.f6089c, i2, Layout.Alignment.ALIGN_NORMAL, this.f6090d, this.f6091e, true).getHeight();
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6090d = 1.0f;
        this.f6091e = 0.0f;
        this.f6092f = false;
        this.f6093g = false;
        a();
    }

    public AutoResizeTextView(Context context) {
        super(context);
        this.f6090d = 1.0f;
        this.f6091e = 0.0f;
        this.f6092f = false;
        this.f6093g = false;
        a();
    }
}
