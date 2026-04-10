package com.jpardogo.android.googleprogressbar.library;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ChromeFloatingCirclesDrawable extends Drawable implements Drawable.Callback {
    private static final int ACCELERATION_LEVEL = 2;
    private static final int ALPHA_OPAQUE = 255;
    private static final int CENT_LEVEL = 5000;
    private static final int MAX_LEVEL = 10000;
    private static final int MID_LEVEL = 2500;
    private int colorSign;
    private Point[] mArrowPoints;
    private ColorFilter mColorFilter;
    private Paint mPaint1;
    private Paint mPaint2;
    private Paint mPaint3;
    private Paint mPaint4;
    private double max_speed;
    private int offset;
    private double offsetPercentage;
    private double unit;
    private int width;
    private int x_beg;
    private int x_end;
    private int y_beg;
    private int y_end;
    private int mAlpha = 255;
    private int acceleration = 2;
    private double distance = 6250000.0d;
    private ProgressStates currentProgressStates = ProgressStates.GREEN_TOP;

    /* JADX INFO: renamed from: com.jpardogo.android.googleprogressbar.library.ChromeFloatingCirclesDrawable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$jpardogo$android$googleprogressbar$library$ChromeFloatingCirclesDrawable$ProgressStates = new int[ProgressStates.values().length];

        static {
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$ChromeFloatingCirclesDrawable$ProgressStates[ProgressStates.GREEN_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$ChromeFloatingCirclesDrawable$ProgressStates[ProgressStates.YELLOW_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$ChromeFloatingCirclesDrawable$ProgressStates[ProgressStates.RED_TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$jpardogo$android$googleprogressbar$library$ChromeFloatingCirclesDrawable$ProgressStates[ProgressStates.BLUE_TOP.ordinal()] = 4;
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
            return new ChromeFloatingCirclesDrawable(this.mColors);
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
        GREEN_TOP,
        YELLOW_TOP,
        RED_TOP,
        BLUE_TOP
    }

    public ChromeFloatingCirclesDrawable(int[] iArr) {
        initCirclesProgress(iArr);
    }

    private void changeTopColor() {
        int i2 = AnonymousClass1.$SwitchMap$com$jpardogo$android$googleprogressbar$library$ChromeFloatingCirclesDrawable$ProgressStates[this.currentProgressStates.ordinal()];
        if (i2 == 1) {
            this.currentProgressStates = ProgressStates.YELLOW_TOP;
            return;
        }
        if (i2 == 2) {
            this.currentProgressStates = ProgressStates.RED_TOP;
        } else if (i2 == 3) {
            this.currentProgressStates = ProgressStates.BLUE_TOP;
        } else {
            if (i2 != 4) {
                return;
            }
            this.currentProgressStates = ProgressStates.GREEN_TOP;
        }
    }

    private void initCirclesProgress(int[] iArr) {
        initColors(iArr);
        setAlpha(this.mAlpha);
        setColorFilter(this.mColorFilter);
        setAcceleration(2);
        this.offsetPercentage = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        this.colorSign = 1;
    }

    private void initColors(int[] iArr) {
        this.mPaint1 = new Paint(1);
        this.mPaint1.setColor(iArr[0]);
        this.mPaint1.setAntiAlias(true);
        this.mPaint2 = new Paint(1);
        this.mPaint2.setColor(iArr[1]);
        this.mPaint2.setAntiAlias(true);
        this.mPaint3 = new Paint(1);
        this.mPaint3.setColor(iArr[2]);
        this.mPaint3.setAntiAlias(true);
        this.mPaint4 = new Paint(1);
        this.mPaint4.setColor(iArr[3]);
        this.mPaint4.setAntiAlias(true);
    }

    private void measureCircleProgress(int i2, int i3) {
        if (i2 > i3) {
            this.width = i3 - 1;
            this.x_beg = ((i2 - i3) / 2) + 1;
            this.y_beg = 1;
            int i4 = this.x_beg;
            int i5 = this.width;
            this.x_end = i4 + i5;
            this.y_end = i5;
        } else {
            this.width = i2 - 1;
            this.x_beg = 1;
            this.y_beg = ((i3 - i2) / 2) + 1;
            int i6 = this.width;
            this.x_end = i6;
            this.y_end = this.y_beg + i6;
        }
        double d2 = this.width;
        Double.isNaN(d2);
        this.unit = d2 / 5.0d;
        this.mArrowPoints = new Point[4];
        Point[] pointArr = this.mArrowPoints;
        double d3 = this.unit;
        pointArr[0] = new Point(((int) d3) + this.x_beg, ((int) d3) + this.y_beg);
        Point[] pointArr2 = this.mArrowPoints;
        double d4 = this.unit;
        pointArr2[1] = new Point(((int) (d4 * 4.0d)) + this.x_beg, ((int) (d4 * 4.0d)) + this.y_beg);
        Point[] pointArr3 = this.mArrowPoints;
        double d5 = this.unit;
        pointArr3[2] = new Point(((int) d5) + this.x_beg, ((int) (d5 * 4.0d)) + this.y_beg);
        Point[] pointArr4 = this.mArrowPoints;
        double d6 = this.unit;
        pointArr4[3] = new Point(((int) (4.0d * d6)) + this.x_beg, ((int) d6) + this.y_beg);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.currentProgressStates != ProgressStates.RED_TOP) {
            Point[] pointArr = this.mArrowPoints;
            canvas.drawCircle(pointArr[0].x, pointArr[0].y, (float) this.unit, this.mPaint1);
        }
        if (this.currentProgressStates != ProgressStates.BLUE_TOP) {
            Point[] pointArr2 = this.mArrowPoints;
            canvas.drawCircle(pointArr2[1].x, pointArr2[1].y, (float) this.unit, this.mPaint2);
        }
        if (this.currentProgressStates != ProgressStates.YELLOW_TOP) {
            Point[] pointArr3 = this.mArrowPoints;
            canvas.drawCircle(pointArr3[2].x, pointArr3[2].y, (float) this.unit, this.mPaint3);
        }
        if (this.currentProgressStates != ProgressStates.GREEN_TOP) {
            Point[] pointArr4 = this.mArrowPoints;
            canvas.drawCircle(pointArr4[3].x, pointArr4[3].y, (float) this.unit, this.mPaint4);
        }
        int i2 = AnonymousClass1.$SwitchMap$com$jpardogo$android$googleprogressbar$library$ChromeFloatingCirclesDrawable$ProgressStates[this.currentProgressStates.ordinal()];
        if (i2 == 1) {
            Point[] pointArr5 = this.mArrowPoints;
            canvas.drawCircle(pointArr5[3].x, pointArr5[3].y, (float) this.unit, this.mPaint4);
            return;
        }
        if (i2 == 2) {
            Point[] pointArr6 = this.mArrowPoints;
            canvas.drawCircle(pointArr6[2].x, pointArr6[2].y, (float) this.unit, this.mPaint3);
        } else if (i2 == 3) {
            Point[] pointArr7 = this.mArrowPoints;
            canvas.drawCircle(pointArr7[0].x, pointArr7[0].y, (float) this.unit, this.mPaint1);
        } else {
            if (i2 != 4) {
                return;
            }
            Point[] pointArr8 = this.mArrowPoints;
            canvas.drawCircle(pointArr8[1].x, pointArr8[1].y, (float) this.unit, this.mPaint2);
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
        int i3 = this.acceleration;
        int i4 = i2 % (10000 / i3);
        int i5 = i4 % (2500 / i3);
        int i6 = (int) (this.unit * 3.0d);
        if (i4 < 5000 / i3) {
            if (i4 < 2500 / i3) {
                if (this.colorSign == 15) {
                    changeTopColor();
                    this.colorSign = 1;
                }
                double d2 = this.acceleration;
                Double.isNaN(d2);
                double d3 = i5;
                Double.isNaN(d3);
                Double.isNaN(d3);
                this.offsetPercentage = (((d2 * 0.5d) * d3) * d3) / this.distance;
                double d4 = this.offsetPercentage;
                double d5 = i6;
                Double.isNaN(d5);
                this.offset = (int) ((d4 * d5) / 2.0d);
            } else {
                this.colorSign |= 2;
                double d6 = this.max_speed;
                double d7 = i5;
                Double.isNaN(d7);
                double d8 = i3;
                Double.isNaN(d8);
                Double.isNaN(d7);
                Double.isNaN(d7);
                this.offsetPercentage = (((d6 * d7) - (((d8 * 0.5d) * d7) * d7)) / this.distance) + 1.0d;
                double d9 = this.offsetPercentage;
                double d10 = i6;
                Double.isNaN(d10);
                this.offset = (int) ((d9 * d10) / 2.0d);
            }
        } else if (i4 < 7500 / i3) {
            if (this.colorSign == 3) {
                changeTopColor();
                this.colorSign |= 4;
            }
            double d11 = this.acceleration;
            Double.isNaN(d11);
            double d12 = i5;
            Double.isNaN(d12);
            Double.isNaN(d12);
            this.offsetPercentage = (((d11 * 0.5d) * d12) * d12) / this.distance;
            double d13 = i6;
            double d14 = this.offsetPercentage;
            Double.isNaN(d13);
            Double.isNaN(d13);
            this.offset = (int) (d13 - ((d14 * d13) / 2.0d));
        } else {
            this.colorSign |= 8;
            double d15 = this.max_speed;
            double d16 = i5;
            Double.isNaN(d16);
            double d17 = i3;
            Double.isNaN(d17);
            Double.isNaN(d16);
            Double.isNaN(d16);
            this.offsetPercentage = (((d15 * d16) - (((d17 * 0.5d) * d16) * d16)) / this.distance) + 1.0d;
            double d18 = this.offsetPercentage;
            if (d18 == 1.0d) {
                d18 = 2.0d;
            }
            this.offsetPercentage = d18;
            double d19 = i6;
            double d20 = this.offsetPercentage;
            Double.isNaN(d19);
            Double.isNaN(d19);
            this.offset = (int) (d19 - ((d20 * d19) / 2.0d));
        }
        Point point = this.mArrowPoints[0];
        double d21 = this.unit;
        int i7 = ((int) d21) + this.x_beg;
        int i8 = this.offset;
        point.set(i7 + i8, ((int) d21) + this.y_beg + i8);
        Point point2 = this.mArrowPoints[1];
        double d22 = this.unit;
        int i9 = ((int) (d22 * 4.0d)) + this.x_beg;
        int i10 = this.offset;
        point2.set(i9 - i10, (((int) (d22 * 4.0d)) + this.y_beg) - i10);
        Point point3 = this.mArrowPoints[2];
        double d23 = this.unit;
        int i11 = ((int) d23) + this.x_beg;
        int i12 = this.offset;
        point3.set(i11 + i12, (((int) (d23 * 4.0d)) + this.y_beg) - i12);
        Point point4 = this.mArrowPoints[3];
        double d24 = this.unit;
        int i13 = ((int) (4.0d * d24)) + this.x_beg;
        int i14 = this.offset;
        point4.set(i13 - i14, ((int) d24) + this.y_beg + i14);
        return true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    public void setAcceleration(int i2) {
        this.acceleration = i2;
        double d2 = i2;
        Double.isNaN(d2);
        double d3 = 2500 / i2;
        Double.isNaN(d3);
        Double.isNaN(d3);
        this.distance = d2 * 0.5d * d3 * d3;
        this.max_speed = i2 * r2;
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
        this.mColorFilter = colorFilter;
        this.mPaint1.setColorFilter(colorFilter);
        this.mPaint2.setColorFilter(colorFilter);
        this.mPaint3.setColorFilter(colorFilter);
        this.mPaint4.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
