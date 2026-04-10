package com.jpardogo.android.googleprogressbar.library;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public class GoogleMusicDicesDrawable extends Drawable implements Drawable.Callback {
    private static final int ANIMATION_DURATION = 350;
    private static final int ANIMATION_START_DELAY = 150;
    private DiceRotation mDiceRotation;
    private int mDiceState;
    private DiceState[] mDiceStates;
    private Paint mPaint;
    private Paint mPaintCircle;
    private Paint mPaintShadow;
    private float mScale;
    private int mSize;
    private static final int DICE_SIDE_COLOR = Color.parseColor("#FFDBDBDB");
    private static final int DICE_SIDE_SHADOW_COLOR = Color.parseColor("#FFB8B8B9");
    private static final Interpolator ACCELERATE_INTERPOLATOR = new AccelerateInterpolator();

    /* JADX INFO: renamed from: com.jpardogo.android.googleprogressbar.library.GoogleMusicDicesDrawable$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleMusicDicesDrawable$DiceRotation;
        static final /* synthetic */ int[] $SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleMusicDicesDrawable$DiceSide = new int[DiceSide.values().length];

        static {
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleMusicDicesDrawable$DiceSide[DiceSide.ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleMusicDicesDrawable$DiceSide[DiceSide.TWO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleMusicDicesDrawable$DiceSide[DiceSide.THREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleMusicDicesDrawable$DiceSide[DiceSide.FOUR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleMusicDicesDrawable$DiceSide[DiceSide.FIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleMusicDicesDrawable$DiceSide[DiceSide.SIX.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleMusicDicesDrawable$DiceRotation = new int[DiceRotation.values().length];
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleMusicDicesDrawable$DiceRotation[DiceRotation.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleMusicDicesDrawable$DiceRotation[DiceRotation.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static class Builder {
        public Drawable build() {
            return new GoogleMusicDicesDrawable();
        }
    }

    private enum DiceRotation {
        LEFT,
        DOWN;

        DiceRotation invert() {
            DiceRotation diceRotation = LEFT;
            return this == diceRotation ? DOWN : diceRotation;
        }
    }

    private enum DiceSide {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX
    }

    private class DiceState {
        private DiceSide side1;
        private DiceSide side2;

        DiceState(DiceSide diceSide, DiceSide diceSide2) {
            this.side1 = diceSide;
            this.side2 = diceSide2;
        }
    }

    public GoogleMusicDicesDrawable() {
        init();
    }

    static /* synthetic */ int access$108(GoogleMusicDicesDrawable googleMusicDicesDrawable) {
        int i2 = googleMusicDicesDrawable.mDiceState;
        googleMusicDicesDrawable.mDiceState = i2 + 1;
        return i2;
    }

    private void drawDiceSide(Canvas canvas, DiceSide diceSide, boolean z2) {
        int i2 = this.mSize;
        int i3 = i2 / 10;
        canvas.drawRect(0.0f, 0.0f, i2, i2, z2 ? this.mPaintShadow : this.mPaint);
        switch (AnonymousClass2.$SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleMusicDicesDrawable$DiceSide[diceSide.ordinal()]) {
            case 1:
                int i4 = this.mSize;
                canvas.drawCircle(i4 / 2, i4 / 2, i3, this.mPaintCircle);
                break;
            case 2:
                int i5 = this.mSize;
                float f2 = i3;
                canvas.drawCircle(i5 / 4, i5 - (i5 / 4), f2, this.mPaintCircle);
                int i6 = this.mSize;
                canvas.drawCircle(i6 - (i6 / 4), i6 / 4, f2, this.mPaintCircle);
                break;
            case 3:
                int i7 = this.mSize;
                float f3 = i3;
                canvas.drawCircle(i7 / 2, i7 / 2, f3, this.mPaintCircle);
                int i8 = this.mSize;
                canvas.drawCircle(i8 / 4, i8 / 4, f3, this.mPaintCircle);
                int i9 = this.mSize;
                canvas.drawCircle(i9 - (i9 / 4), i9 - (i9 / 4), i9 / 10, this.mPaintCircle);
                break;
            case 4:
                int i10 = this.mSize;
                float f4 = i3;
                canvas.drawCircle(i10 / 4, i10 / 4, f4, this.mPaintCircle);
                int i11 = this.mSize;
                canvas.drawCircle(i11 / 4, i11 - (i11 / 4), f4, this.mPaintCircle);
                int i12 = this.mSize;
                canvas.drawCircle(i12 - (i12 / 4), i12 - (i12 / 4), f4, this.mPaintCircle);
                int i13 = this.mSize;
                canvas.drawCircle(i13 - (i13 / 4), i13 / 4, f4, this.mPaintCircle);
                break;
            case 5:
                int i14 = this.mSize;
                float f5 = i3;
                canvas.drawCircle(i14 / 2, i14 / 2, f5, this.mPaintCircle);
                int i15 = this.mSize;
                canvas.drawCircle(i15 / 4, i15 / 4, f5, this.mPaintCircle);
                int i16 = this.mSize;
                canvas.drawCircle(i16 / 4, i16 - (i16 / 4), f5, this.mPaintCircle);
                int i17 = this.mSize;
                canvas.drawCircle(i17 - (i17 / 4), i17 - (i17 / 4), f5, this.mPaintCircle);
                int i18 = this.mSize;
                canvas.drawCircle(i18 - (i18 / 4), i18 / 4, f5, this.mPaintCircle);
                break;
            case 6:
                int i19 = this.mSize;
                float f6 = i3;
                canvas.drawCircle(i19 / 4, i19 / 4, f6, this.mPaintCircle);
                int i20 = this.mSize;
                canvas.drawCircle(i20 / 4, i20 / 2, f6, this.mPaintCircle);
                int i21 = this.mSize;
                canvas.drawCircle(i21 / 4, i21 - (i21 / 4), f6, this.mPaintCircle);
                int i22 = this.mSize;
                canvas.drawCircle(i22 - (i22 / 4), i22 / 4, f6, this.mPaintCircle);
                int i23 = this.mSize;
                canvas.drawCircle(i23 - (i23 / 4), i23 / 2, f6, this.mPaintCircle);
                int i24 = this.mSize;
                canvas.drawCircle(i24 - (i24 / 4), i24 - (i24 / 4), f6, this.mPaintCircle);
                break;
        }
    }

    private void drawScaleX(Canvas canvas) {
        canvas.save();
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f - this.mScale, 1.0f, 0.0f, this.mSize / 2);
        canvas.concat(matrix);
        drawDiceSide(canvas, this.mDiceStates[this.mDiceState].side1, this.mScale > 0.1f);
        canvas.restore();
        canvas.save();
        Matrix matrix2 = new Matrix();
        matrix2.preScale(this.mScale, 1.0f, this.mSize, r4 / 2);
        canvas.concat(matrix2);
        drawDiceSide(canvas, this.mDiceStates[this.mDiceState].side2, false);
        canvas.restore();
    }

    private void drawScaleY(Canvas canvas) {
        canvas.save();
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, this.mScale, this.mSize / 2, 0.0f);
        canvas.concat(matrix);
        drawDiceSide(canvas, this.mDiceStates[this.mDiceState].side1, false);
        canvas.restore();
        canvas.save();
        Matrix matrix2 = new Matrix();
        matrix2.preScale(1.0f, 1.0f - this.mScale, r4 / 2, this.mSize);
        canvas.concat(matrix2);
        drawDiceSide(canvas, this.mDiceStates[this.mDiceState].side2, this.mScale > 0.1f);
        canvas.restore();
    }

    private void init() {
        this.mPaint = new Paint(1);
        this.mPaint.setColor(DICE_SIDE_COLOR);
        this.mPaintShadow = new Paint(1);
        this.mPaintShadow.setColor(DICE_SIDE_SHADOW_COLOR);
        this.mPaintCircle = new Paint(1);
        this.mPaintCircle.setColor(-1);
        this.mDiceStates = new DiceState[]{new DiceState(DiceSide.ONE, DiceSide.THREE), new DiceState(DiceSide.TWO, DiceSide.THREE), new DiceState(DiceSide.TWO, DiceSide.SIX), new DiceState(DiceSide.FOUR, DiceSide.SIX), new DiceState(DiceSide.FOUR, DiceSide.FIVE), new DiceState(DiceSide.ONE, DiceSide.FIVE)};
        this.mDiceRotation = DiceRotation.LEFT;
        initObjectAnimator();
    }

    private void initObjectAnimator() {
        final ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "scale", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(ACCELERATE_INTERPOLATOR);
        objectAnimatorOfFloat.setDuration(350L);
        objectAnimatorOfFloat.setStartDelay(150L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.jpardogo.android.googleprogressbar.library.GoogleMusicDicesDrawable.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                GoogleMusicDicesDrawable.this.mScale = 0.0f;
                GoogleMusicDicesDrawable.access$108(GoogleMusicDicesDrawable.this);
                if (GoogleMusicDicesDrawable.this.mDiceState == GoogleMusicDicesDrawable.this.mDiceStates.length) {
                    GoogleMusicDicesDrawable.this.mDiceState = 0;
                }
                GoogleMusicDicesDrawable googleMusicDicesDrawable = GoogleMusicDicesDrawable.this;
                googleMusicDicesDrawable.mDiceRotation = googleMusicDicesDrawable.mDiceRotation.invert();
                objectAnimatorOfFloat.start();
            }
        });
        objectAnimatorOfFloat.start();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        DiceRotation diceRotation = this.mDiceRotation;
        if (diceRotation != null) {
            int i2 = AnonymousClass2.$SwitchMap$com$jpardogo$android$googleprogressbar$library$GoogleMusicDicesDrawable$DiceRotation[diceRotation.ordinal()];
            if (i2 == 1) {
                drawScaleY(canvas);
            } else {
                if (i2 != 2) {
                    return;
                }
                drawScaleX(canvas);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    float getScale() {
        return this.mScale;
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
        this.mSize = rect.width();
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
        this.mPaint.setAlpha(i2);
        this.mPaintShadow.setAlpha(i2);
        this.mPaintCircle.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        this.mPaintShadow.setColorFilter(colorFilter);
        this.mPaintCircle.setColorFilter(colorFilter);
    }

    void setScale(float f2) {
        this.mScale = f2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
