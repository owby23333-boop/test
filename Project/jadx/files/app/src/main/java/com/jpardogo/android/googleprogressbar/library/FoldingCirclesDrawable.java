package com.jpardogo.android.googleprogressbar.library;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class FoldingCirclesDrawable extends Drawable implements Drawable.Callback {
    private static final int ALPHA_ABOVE_DEFAULT = 235;
    private static final int ALPHA_OPAQUE = 255;
    private static final float MAX_LEVEL = 10000.0f;
    private static int mColor1;
    private static int mColor2;
    private static int mColor3;
    private static int mColor4;
    private int fstColor;
    private boolean goesBackward;
    private Paint mAbovePaint;
    private int mAxisValue;
    private ColorFilter mColorFilter;
    private int mControlPointMaximum;
    private int mControlPointMinimum;
    private ProgressStates mCurrentState;
    private int mDiameter;
    private Paint mFstHalfPaint;
    private int mHalf;
    private Path mPath;
    private Paint mScndHalfPaint;
    private int scndColor;
    private static final float CIRCLE_COUNT = ProgressStates.values().length;
    private static final float MAX_LEVEL_PER_CIRCLE = 10000.0f / CIRCLE_COUNT;
    private RectF mOval = new RectF();
    private int mAlpha = 255;

    /* JADX INFO: renamed from: com.jpardogo.android.googleprogressbar.library.FoldingCirclesDrawable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$jpardogo$android$googleprogressbar$library$FoldingCirclesDrawable$ProgressStates = new int[ProgressStates.values().length];

        static {
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$FoldingCirclesDrawable$ProgressStates[ProgressStates.FOLDING_DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$FoldingCirclesDrawable$ProgressStates[ProgressStates.FOLDING_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$FoldingCirclesDrawable$ProgressStates[ProgressStates.FOLDING_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$FoldingCirclesDrawable$ProgressStates[ProgressStates.FOLDING_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class Builder {
        private int[] mColors;

        public Builder(Context context) {
            initDefaults(context);
        }

        private void initDefaults(Context context) {
            this.mColors = context.getResources().getIntArray(R.array.google_colors);
        }

        public Drawable build() {
            return new FoldingCirclesDrawable(this.mColors);
        }

        public Builder colors(int[] iArr) {
            if (iArr == null || iArr.length == 0) {
                throw new IllegalArgumentException("Your color array must contains at least 4 values");
            }
            this.mColors = iArr;
            return this;
        }
    }

    private enum ProgressStates {
        FOLDING_DOWN,
        FOLDING_LEFT,
        FOLDING_UP,
        FOLDING_RIGHT
    }

    public FoldingCirclesDrawable(int[] iArr) {
        initCirclesProgress(iArr);
    }

    private void drawXMotion(Canvas canvas) {
        canvas.drawArc(this.mOval, 90.0f, 180.0f, true, this.mFstHalfPaint);
        canvas.drawArc(this.mOval, -270.0f, -180.0f, true, this.mScndHalfPaint);
        this.mPath.reset();
        this.mPath.moveTo(this.mHalf, 0.0f);
        Path path = this.mPath;
        int i2 = this.mAxisValue;
        float f2 = i2;
        float f3 = i2;
        int i3 = this.mDiameter;
        path.cubicTo(f2, 0.0f, f3, i3, this.mHalf, i3);
        this.mPath.moveTo(this.mHalf + 1, 0.0f);
        Path path2 = this.mPath;
        int i4 = this.mAxisValue;
        float f4 = i4;
        float f5 = i4;
        int i5 = this.mDiameter;
        path2.cubicTo(f4, 0.0f, f5, i5, this.mHalf + 1, i5);
    }

    private void drawYMotion(Canvas canvas) {
        canvas.drawArc(this.mOval, 0.0f, -180.0f, true, this.mFstHalfPaint);
        canvas.drawArc(this.mOval, -180.0f, -180.0f, true, this.mScndHalfPaint);
        this.mPath.reset();
        this.mPath.moveTo(0.0f, this.mHalf);
        Path path = this.mPath;
        int i2 = this.mAxisValue;
        int i3 = this.mDiameter;
        path.cubicTo(0.0f, i2, i3, i2, i3, this.mHalf);
        this.mPath.moveTo(0.0f, this.mHalf + 1);
        Path path2 = this.mPath;
        int i4 = this.mAxisValue;
        int i5 = this.mDiameter;
        path2.cubicTo(0.0f, i4, i5, i4, i5, this.mHalf + 1);
    }

    private void initCirclesProgress(int[] iArr) {
        initColors(iArr);
        this.mPath = new Path();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.mFstHalfPaint = new Paint(paint);
        this.mScndHalfPaint = new Paint(paint);
        this.mAbovePaint = new Paint(paint);
        setAlpha(this.mAlpha);
        setColorFilter(this.mColorFilter);
    }

    private void initColors(int[] iArr) {
        mColor1 = iArr[0];
        mColor2 = iArr[1];
        mColor3 = iArr[2];
        mColor4 = iArr[3];
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void makeCirclesProgress(android.graphics.Canvas r3) {
        /*
            r2 = this;
            int[] r0 = com.jpardogo.android.googleprogressbar.library.FoldingCirclesDrawable.AnonymousClass1.$SwitchMap$com$jpardogo$android$googleprogressbar$library$FoldingCirclesDrawable$ProgressStates
            com.jpardogo.android.googleprogressbar.library.FoldingCirclesDrawable$ProgressStates r1 = r2.mCurrentState
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L1b
            r1 = 2
            if (r0 == r1) goto L17
            r1 = 3
            if (r0 == r1) goto L1b
            r1 = 4
            if (r0 == r1) goto L17
            goto L1e
        L17:
            r2.drawXMotion(r3)
            goto L1e
        L1b:
            r2.drawYMotion(r3)
        L1e:
            android.graphics.Path r0 = r2.mPath
            android.graphics.Paint r1 = r2.mAbovePaint
            r3.drawPath(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jpardogo.android.googleprogressbar.library.FoldingCirclesDrawable.makeCirclesProgress(android.graphics.Canvas):void");
    }

    private void measureCircleProgress(int i2, int i3) {
        this.mDiameter = Math.min(i2, i3);
        int i4 = this.mDiameter;
        this.mHalf = i4 / 2;
        this.mOval.set(0.0f, 0.0f, i4, i4);
        int i5 = this.mDiameter;
        this.mControlPointMinimum = (-i5) / 6;
        this.mControlPointMaximum = i5 + (i5 / 6);
    }

    private void resetColor(ProgressStates progressStates) {
        int i2 = AnonymousClass1.$SwitchMap$com$jpardogo$android$googleprogressbar$library$FoldingCirclesDrawable$ProgressStates[progressStates.ordinal()];
        if (i2 == 1) {
            this.fstColor = mColor1;
            this.scndColor = mColor2;
            this.goesBackward = false;
            return;
        }
        if (i2 == 2) {
            this.fstColor = mColor1;
            this.scndColor = mColor3;
            this.goesBackward = true;
        } else if (i2 == 3) {
            this.fstColor = mColor3;
            this.scndColor = mColor4;
            this.goesBackward = true;
        } else {
            if (i2 != 4) {
                return;
            }
            this.fstColor = mColor2;
            this.scndColor = mColor4;
            this.goesBackward = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mCurrentState != null) {
            makeCirclesProgress(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
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
        measureCircleProgress(rect.width(), rect.height());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        if (i2 == 10000.0f) {
            i2 = 0;
        }
        float f2 = i2;
        this.mCurrentState = ProgressStates.values()[(int) (f2 / MAX_LEVEL_PER_CIRCLE)];
        resetColor(this.mCurrentState);
        float f3 = MAX_LEVEL_PER_CIRCLE;
        int i3 = (int) (f2 % f3);
        if (this.goesBackward) {
            z = i3 == ((int) (f2 % (f3 / 2.0f)));
            i3 = (int) (MAX_LEVEL_PER_CIRCLE - i3);
        } else if (i3 != ((int) (f2 % (f3 / 2.0f)))) {
            z = true;
        }
        this.mFstHalfPaint.setColor(this.fstColor);
        this.mScndHalfPaint.setColor(this.scndColor);
        if (z) {
            this.mAbovePaint.setColor(this.mFstHalfPaint.getColor());
        } else {
            this.mAbovePaint.setColor(this.mScndHalfPaint.getColor());
        }
        setAlpha(this.mAlpha);
        this.mAxisValue = (int) (this.mControlPointMinimum + ((this.mControlPointMaximum - r7) * (i3 / MAX_LEVEL_PER_CIRCLE)));
        return true;
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
        this.mAlpha = i2;
        this.mFstHalfPaint.setAlpha(i2);
        this.mScndHalfPaint.setAlpha(i2);
        this.mAbovePaint.setAlpha((i2 * 235) / 255);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.mFstHalfPaint.setColorFilter(colorFilter);
        this.mScndHalfPaint.setColorFilter(colorFilter);
        this.mAbovePaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
