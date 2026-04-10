package com.scwang.smart.refresh.header.material;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes4.dex */
public class CircleImageView extends ImageView {
    protected static final int SHADOW_ELEVATION = 4;
    protected static final float SHADOW_RADIUS = 3.5f;
    int mShadowRadius;

    public CircleImageView(Context context, int i) {
        super(context);
        float f = getResources().getDisplayMetrics().density;
        this.mShadowRadius = (int) (SHADOW_RADIUS * f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        setElevation(f * 4.0f);
        shapeDrawable.getPaint().setColor(i);
        setBackground(shapeDrawable);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
