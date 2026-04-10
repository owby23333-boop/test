package com.amgcyo.cuttadon.view.smilerefresh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
class CircleImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Animation.AnimationListener f5521s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f5522t;

    private class a extends OvalShape {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private RadialGradient f5523s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private Paint f5524t = new Paint();

        a(int i2) {
            CircleImageView.this.f5522t = i2;
            a((int) rect().width());
        }

        private void a(int i2) {
            float f2 = i2 / 2;
            this.f5523s = new RadialGradient(f2, f2, CircleImageView.this.f5522t, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f5524t.setShader(this.f5523s);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float width = CircleImageView.this.getWidth() / 2;
            float height = CircleImageView.this.getHeight() / 2;
            canvas.drawCircle(width, height, width, this.f5524t);
            canvas.drawCircle(width, height, r0 - CircleImageView.this.f5522t, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f2, float f3) {
            super.onResize(f2, f3);
            a((int) f2);
        }
    }

    public CircleImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f5521s;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f5521s;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.f5522t * 2), getMeasuredHeight() + (this.f5522t * 2));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i2);
        }
    }

    public CircleImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void a(Animation.AnimationListener animationListener) {
        this.f5521s = animationListener;
    }

    CircleImageView(Context context, int i2) {
        ShapeDrawable shapeDrawable;
        super(context);
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i3 = (int) (1.75f * f2);
        int i4 = (int) (0.0f * f2);
        this.f5522t = (int) (3.5f * f2);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, f2 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new a(this.f5522t));
            ViewCompat.setLayerType(this, 1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f5522t, i4, i3, 503316480);
            int i5 = this.f5522t;
            setPadding(i5, i5, i5, i5);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i2);
        setBackgroundDrawable(shapeDrawable);
    }
}
