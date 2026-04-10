package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public class KsShadowImageView extends ImageView {
    private Paint DT;
    private BlurMaskFilter DU;
    private int DV;
    private boolean DW;
    private boolean DX;
    private boolean DY;
    private boolean DZ;
    private Rect Ea;
    private int Eb;

    public KsShadowImageView(Context context) {
        super(context);
        this.DZ = true;
        a(context, null, 0);
    }

    public KsShadowImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DZ = true;
        a(context, attributeSet, 0);
    }

    public KsShadowImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DZ = true;
        a(context, attributeSet, i);
    }

    public KsShadowImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.DZ = true;
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.DT = new Paint();
        this.DU = new BlurMaskFilter(50.0f, BlurMaskFilter.Blur.OUTER);
        this.Ea = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShadowImageView, i, 0);
        this.DV = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_KsShadowImageView_ksad_shadowSize, 20);
        this.Eb = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KsShadowImageView_ksad_shadowColor, Color.parseColor("#33000000"));
        this.DW = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableLeftShadow, true);
        this.DX = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableRightShadow, true);
        this.DY = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableTopShadow, true);
        this.DZ = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableBottomShadow, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.DT.setMaskFilter(this.DU);
        this.DT.setColor(this.Eb);
        this.DT.setStyle(Paint.Style.FILL);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.Ea.left = this.DW ? this.DV : 0;
        this.Ea.top = this.DY ? this.DV : 0;
        this.Ea.right = measuredWidth - (this.DX ? this.DV : 0);
        this.Ea.bottom = measuredHeight - (this.DZ ? this.DV : 0);
        canvas.drawRect(this.Ea, this.DT);
    }
}
