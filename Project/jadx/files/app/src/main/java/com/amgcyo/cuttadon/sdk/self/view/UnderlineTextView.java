package com.amgcyo.cuttadon.sdk.self.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import com.amgcyo.cuttadon.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class UnderlineTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Paint f4239s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f4240t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f4241u;

    public UnderlineTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.UnderlineTextView);
        this.f4241u = typedArrayObtainStyledAttributes.getColor(0, getTextColors().getDefaultColor());
        this.f4240t = (int) typedArrayObtainStyledAttributes.getDimension(1, TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f4239s.setAntiAlias(true);
        this.f4239s.setDither(true);
        this.f4239s.setColor(this.f4241u);
        canvas.drawRect(0.0f, getHeight() - this.f4240t, getWidth(), getHeight(), this.f4239s);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, this.f4240t);
    }

    public void setUnderLineColor(int i2) {
        this.f4241u = i2;
        postInvalidate();
    }

    public void setUnderlineHeights(int i2) {
        this.f4240t = i2;
        postInvalidate();
    }

    public UnderlineTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4239s = new Paint();
        this.f4240t = 0;
    }
}
