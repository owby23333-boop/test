package com.scwang.smart.refresh.header.material;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.widget.ImageView;
import androidx.annotation.ColorInt;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ViewConstructor", "AppCompatCustomView"})
public class CircleImageView extends ImageView {
    protected static final int FILL_SHADOW_COLOR = 1023410176;
    protected static final int KEY_SHADOW_COLOR = 503316480;
    protected static final int SHADOW_ELEVATION = 4;
    protected static final float SHADOW_RADIUS = 3.5f;
    protected static final float X_OFFSET = 0.0f;
    protected static final float Y_OFFSET = 1.75f;
    int mShadowRadius;

    public class OvalShadow extends OvalShape {
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint = new Paint();

        public OvalShadow(int i) {
            CircleImageView.this.mShadowRadius = i;
            updateRadialGradient((int) super.rect().width());
        }

        private void updateRadialGradient(int i) {
            float f = i / 2.0f;
            RadialGradient radialGradient = new RadialGradient(f, f, CircleImageView.this.mShadowRadius, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.mRadialGradient = radialGradient;
            this.mShadowPaint.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            CircleImageView circleImageView = CircleImageView.this;
            float width = circleImageView.getWidth() / 2.0f;
            float height = circleImageView.getHeight() / 2.0f;
            canvas.drawCircle(width, height, width, this.mShadowPaint);
            canvas.drawCircle(width, height, width - CircleImageView.this.mShadowRadius, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void onResize(float f, float f2) {
            super.onResize(f, f2);
            updateRadialGradient((int) f);
        }
    }

    public CircleImageView(Context context, int i) {
        super(context);
        float f = getResources().getDisplayMetrics().density;
        this.mShadowRadius = (int) (3.5f * f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        setElevation(f * 4.0f);
        shapeDrawable.getPaint().setColor(i);
        setBackground(shapeDrawable);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
