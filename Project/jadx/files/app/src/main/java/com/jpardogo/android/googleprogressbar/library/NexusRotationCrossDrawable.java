package com.jpardogo.android.googleprogressbar.library;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes2.dex */
public class NexusRotationCrossDrawable extends Drawable implements Drawable.Callback {
    private static final int ANIMATION_DURATION = 150;
    private static final int ANIMATION_START_DELAY = 300;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private int mCenter;
    private Paint mPaint2;
    private Paint mPaint3;
    private Paint mPaint4;
    private int mRotationAngle;
    private Point[] mArrowPoints = new Point[5];
    private Path mPath = new Path();
    private Paint mPaint1 = new Paint(1);

    public static class Builder {
        private int[] mColors;

        public Builder(Context context) {
            initDefaults(context);
        }

        private void initDefaults(Context context) {
            this.mColors = context.getResources().getIntArray(R.array.google_colors);
        }

        public Drawable build() {
            return new NexusRotationCrossDrawable(this.mColors);
        }

        public Builder colors(int[] iArr) {
            if (iArr == null || iArr.length != 4) {
                throw new IllegalArgumentException("Your color array must contains 4 values");
            }
            this.mColors = iArr;
            return this;
        }
    }

    public NexusRotationCrossDrawable(int[] iArr) {
        this.mPaint1.setColor(iArr[0]);
        this.mPaint2 = new Paint(1);
        this.mPaint2.setColor(iArr[1]);
        this.mPaint3 = new Paint(1);
        this.mPaint3.setColor(iArr[2]);
        this.mPaint4 = new Paint(1);
        this.mPaint4.setColor(iArr[3]);
        initObjectAnimator();
    }

    private void drawArrows(Canvas canvas) {
        float f2 = this.mRotationAngle;
        int i2 = this.mCenter;
        canvas.rotate(f2, i2, i2);
        this.mPath.reset();
        Path path = this.mPath;
        Point[] pointArr = this.mArrowPoints;
        path.moveTo(pointArr[0].x, pointArr[0].y);
        int i3 = 1;
        while (true) {
            if (i3 >= this.mArrowPoints.length) {
                this.mPath.lineTo(r1[0].x, r1[0].y);
                canvas.save();
                canvas.drawPath(this.mPath, this.mPaint1);
                canvas.restore();
                canvas.save();
                int i4 = this.mCenter;
                canvas.rotate(90.0f, i4, i4);
                canvas.drawPath(this.mPath, this.mPaint2);
                canvas.restore();
                canvas.save();
                int i5 = this.mCenter;
                canvas.rotate(180.0f, i5, i5);
                canvas.drawPath(this.mPath, this.mPaint3);
                canvas.restore();
                canvas.save();
                int i6 = this.mCenter;
                canvas.rotate(270.0f, i6, i6);
                canvas.drawPath(this.mPath, this.mPaint4);
                canvas.restore();
                return;
            }
            this.mPath.lineTo(r1[i3].x, r1[i3].y);
            i3++;
        }
    }

    private void initObjectAnimator() {
        final ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "rotationAngle", 0, 180);
        objectAnimatorOfInt.setInterpolator(LINEAR_INTERPOLATOR);
        objectAnimatorOfInt.setDuration(150L);
        objectAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.jpardogo.android.googleprogressbar.library.NexusRotationCrossDrawable.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (NexusRotationCrossDrawable.this.mRotationAngle == 180) {
                    objectAnimatorOfInt.setIntValues(180, 360);
                    objectAnimatorOfInt.setStartDelay(600L);
                } else {
                    objectAnimatorOfInt.setIntValues(0, 180);
                    objectAnimatorOfInt.setStartDelay(300L);
                    NexusRotationCrossDrawable.this.mRotationAngle = 0;
                }
                objectAnimatorOfInt.start();
            }
        });
        objectAnimatorOfInt.start();
    }

    private void measureDrawable(Rect rect) {
        this.mCenter = rect.centerX();
        int iWidth = rect.width() / 50;
        int iWidth2 = rect.width() / 15;
        int i2 = this.mCenter;
        double d2 = i2;
        double dSqrt = Math.sqrt(2.0d);
        Double.isNaN(d2);
        int i3 = i2 - ((int) (d2 / dSqrt));
        Point[] pointArr = this.mArrowPoints;
        int i4 = this.mCenter;
        pointArr[0] = new Point(i4 - iWidth, i4 - iWidth);
        Point[] pointArr2 = this.mArrowPoints;
        pointArr2[1] = new Point(pointArr2[0].x, pointArr2[0].y - iWidth2);
        int i5 = i3 + iWidth2;
        this.mArrowPoints[2] = new Point(i5, i3);
        this.mArrowPoints[3] = new Point(i3, i5);
        Point[] pointArr3 = this.mArrowPoints;
        pointArr3[4] = new Point(pointArr3[0].x - iWidth2, pointArr3[0].y);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        drawArrows(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    int getRotationAngle() {
        return this.mRotationAngle;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        measureDrawable(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.mPaint1.setAlpha(i2);
        this.mPaint2.setAlpha(i2);
        this.mPaint3.setAlpha(i2);
        this.mPaint4.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint1.setColorFilter(colorFilter);
        this.mPaint2.setColorFilter(colorFilter);
        this.mPaint3.setColorFilter(colorFilter);
        this.mPaint4.setColorFilter(colorFilter);
    }

    void setRotationAngle(int i2) {
        this.mRotationAngle = i2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
