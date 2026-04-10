package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIProgressBar extends View {
    public static final int DEFAULT_BACKGROUND_COLOR = -7829368;
    public static final int DEFAULT_PROGRESS_COLOR = -16776961;
    public static int DEFAULT_STROKE_WIDTH = QMUIDisplayHelper.dpToPx(40);
    public static final int DEFAULT_TEXT_COLOR = -16777216;
    public static final int DEFAULT_TEXT_SIZE = 20;
    private static final int PENDING_VALUE_NOT_SET = -1;
    public static final int TOTAL_DURATION = 1000;
    public static final int TYPE_CIRCLE = 2;
    public static final int TYPE_FILL_CIRCLE = 3;
    public static final int TYPE_RECT = 0;
    public static final int TYPE_ROUND_RECT = 1;
    private int mAnimationDistance;
    private int mAnimationDuration;
    private long mAnimationStartTime;
    private RectF mArcOval;
    private int mBackgroundColor;
    private Paint mBackgroundPaint;
    RectF mBgRect;
    private Point mCenterPoint;
    private float mCircleRadius;
    private int mHeight;
    private int mMaxValue;
    private Runnable mNotifyProgressChangeAction;
    private OnProgressChangeListener mOnProgressChangeListener;
    private Paint mPaint;
    private int mPendingValue;
    private int mProgressColor;
    RectF mProgressRect;
    QMUIProgressBarTextGenerator mQMUIProgressBarTextGenerator;
    private boolean mRoundCap;
    private int mStrokeWidth;
    private String mText;
    private int mTextColor;
    private Paint mTextPaint;
    private int mTextSize;
    private int mType;
    private int mValue;
    private int mWidth;

    public interface OnProgressChangeListener {
        void onProgressChange(QMUIProgressBar qMUIProgressBar, int i, int i2);
    }

    public interface QMUIProgressBarTextGenerator {
        String generateText(QMUIProgressBar qMUIProgressBar, int i, int i2);
    }

    public QMUIProgressBar(Context context) {
        super(context);
        this.mBackgroundPaint = new Paint();
        this.mPaint = new Paint();
        this.mTextPaint = new Paint(1);
        this.mArcOval = new RectF();
        this.mText = "";
        this.mNotifyProgressChangeAction = new Runnable() { // from class: com.qmuiteam.qmui.widget.QMUIProgressBar.1
            @Override // java.lang.Runnable
            public void run() {
                if (QMUIProgressBar.this.mOnProgressChangeListener != null) {
                    OnProgressChangeListener onProgressChangeListener = QMUIProgressBar.this.mOnProgressChangeListener;
                    QMUIProgressBar qMUIProgressBar = QMUIProgressBar.this;
                    onProgressChangeListener.onProgressChange(qMUIProgressBar, qMUIProgressBar.mValue, QMUIProgressBar.this.mMaxValue);
                }
            }
        };
        setup(context, null);
    }

    public QMUIProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBackgroundPaint = new Paint();
        this.mPaint = new Paint();
        this.mTextPaint = new Paint(1);
        this.mArcOval = new RectF();
        this.mText = "";
        this.mNotifyProgressChangeAction = new Runnable() { // from class: com.qmuiteam.qmui.widget.QMUIProgressBar.1
            @Override // java.lang.Runnable
            public void run() {
                if (QMUIProgressBar.this.mOnProgressChangeListener != null) {
                    OnProgressChangeListener onProgressChangeListener = QMUIProgressBar.this.mOnProgressChangeListener;
                    QMUIProgressBar qMUIProgressBar = QMUIProgressBar.this;
                    onProgressChangeListener.onProgressChange(qMUIProgressBar, qMUIProgressBar.mValue, QMUIProgressBar.this.mMaxValue);
                }
            }
        };
        setup(context, attributeSet);
    }

    public QMUIProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBackgroundPaint = new Paint();
        this.mPaint = new Paint();
        this.mTextPaint = new Paint(1);
        this.mArcOval = new RectF();
        this.mText = "";
        this.mNotifyProgressChangeAction = new Runnable() { // from class: com.qmuiteam.qmui.widget.QMUIProgressBar.1
            @Override // java.lang.Runnable
            public void run() {
                if (QMUIProgressBar.this.mOnProgressChangeListener != null) {
                    OnProgressChangeListener onProgressChangeListener = QMUIProgressBar.this.mOnProgressChangeListener;
                    QMUIProgressBar qMUIProgressBar = QMUIProgressBar.this;
                    onProgressChangeListener.onProgressChange(qMUIProgressBar, qMUIProgressBar.mValue, QMUIProgressBar.this.mMaxValue);
                }
            }
        };
        setup(context, attributeSet);
    }

    public void setup(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIProgressBar);
        this.mType = typedArrayObtainStyledAttributes.getInt(R.styleable.QMUIProgressBar_qmui_type, 0);
        this.mProgressColor = typedArrayObtainStyledAttributes.getColor(R.styleable.QMUIProgressBar_qmui_progress_color, DEFAULT_PROGRESS_COLOR);
        this.mBackgroundColor = typedArrayObtainStyledAttributes.getColor(R.styleable.QMUIProgressBar_qmui_background_color, DEFAULT_BACKGROUND_COLOR);
        this.mMaxValue = typedArrayObtainStyledAttributes.getInt(R.styleable.QMUIProgressBar_qmui_max_value, 100);
        this.mValue = typedArrayObtainStyledAttributes.getInt(R.styleable.QMUIProgressBar_qmui_value, 0);
        this.mRoundCap = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUIProgressBar_qmui_stroke_round_cap, false);
        this.mTextSize = 20;
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.QMUIProgressBar_android_textSize)) {
            this.mTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIProgressBar_android_textSize, 20);
        }
        this.mTextColor = -16777216;
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.QMUIProgressBar_android_textColor)) {
            this.mTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.QMUIProgressBar_android_textColor, -16777216);
        }
        int i = this.mType;
        if (i == 2 || i == 3) {
            this.mStrokeWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIProgressBar_qmui_stroke_width, DEFAULT_STROKE_WIDTH);
        }
        typedArrayObtainStyledAttributes.recycle();
        configPaint(this.mTextColor, this.mTextSize, this.mRoundCap, this.mStrokeWidth);
        setProgress(this.mValue);
    }

    public void setOnProgressChangeListener(OnProgressChangeListener onProgressChangeListener) {
        this.mOnProgressChangeListener = onProgressChangeListener;
    }

    public void setStrokeWidth(int i) {
        if (this.mStrokeWidth != i) {
            this.mStrokeWidth = i;
            if (this.mWidth > 0) {
                configShape();
            }
            configPaint(this.mTextColor, this.mTextSize, this.mRoundCap, this.mStrokeWidth);
            invalidate();
        }
    }

    private void configShape() {
        int i = this.mType;
        if (i == 0 || i == 1) {
            this.mBgRect = new RectF(getPaddingLeft(), getPaddingTop(), this.mWidth + getPaddingLeft(), this.mHeight + getPaddingTop());
            this.mProgressRect = new RectF();
        } else {
            this.mCircleRadius = ((Math.min(this.mWidth, this.mHeight) - this.mStrokeWidth) / 2.0f) - 0.5f;
            this.mCenterPoint = new Point(this.mWidth / 2, this.mHeight / 2);
        }
    }

    private void configPaint(int i, int i2, boolean z, int i3) {
        this.mPaint.setColor(this.mProgressColor);
        this.mBackgroundPaint.setColor(this.mBackgroundColor);
        int i4 = this.mType;
        if (i4 == 0 || i4 == 1) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setStrokeCap(Paint.Cap.BUTT);
            this.mBackgroundPaint.setStyle(Paint.Style.FILL);
        } else if (i4 == 3) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStrokeCap(Paint.Cap.BUTT);
            this.mBackgroundPaint.setStyle(Paint.Style.STROKE);
            this.mBackgroundPaint.setStrokeWidth(i3);
            this.mBackgroundPaint.setAntiAlias(true);
        } else {
            this.mPaint.setStyle(Paint.Style.STROKE);
            float f = i3;
            this.mPaint.setStrokeWidth(f);
            this.mPaint.setAntiAlias(true);
            if (z) {
                this.mPaint.setStrokeCap(Paint.Cap.ROUND);
            } else {
                this.mPaint.setStrokeCap(Paint.Cap.BUTT);
            }
            this.mBackgroundPaint.setStyle(Paint.Style.STROKE);
            this.mBackgroundPaint.setStrokeWidth(f);
            this.mBackgroundPaint.setAntiAlias(true);
        }
        this.mTextPaint.setColor(i);
        this.mTextPaint.setTextSize(i2);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    public void setType(int i) {
        this.mType = i;
        configPaint(this.mTextColor, this.mTextSize, this.mRoundCap, this.mStrokeWidth);
        invalidate();
    }

    public void setBarColor(int i, int i2) {
        this.mBackgroundColor = i;
        this.mProgressColor = i2;
        this.mBackgroundPaint.setColor(i);
        this.mPaint.setColor(this.mProgressColor);
        invalidate();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        this.mBackgroundPaint.setColor(i);
        invalidate();
    }

    public void setProgressColor(int i) {
        this.mProgressColor = i;
        this.mPaint.setColor(i);
        invalidate();
    }

    public void setTextSize(int i) {
        this.mTextPaint.setTextSize(i);
        invalidate();
    }

    public void setTextColor(int i) {
        this.mTextPaint.setColor(i);
        invalidate();
    }

    public void setStrokeRoundCap(boolean z) {
        this.mPaint.setStrokeCap(z ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        invalidate();
    }

    public void setQMUIProgressBarTextGenerator(QMUIProgressBarTextGenerator qMUIProgressBarTextGenerator) {
        this.mQMUIProgressBarTextGenerator = qMUIProgressBarTextGenerator;
    }

    public QMUIProgressBarTextGenerator getQMUIProgressBarTextGenerator() {
        return this.mQMUIProgressBarTextGenerator;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mPendingValue != -1) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.mAnimationStartTime;
            int i = this.mAnimationDuration;
            if (jCurrentTimeMillis >= i) {
                this.mValue = this.mPendingValue;
                post(this.mNotifyProgressChangeAction);
                this.mPendingValue = -1;
            } else {
                this.mValue = (int) (this.mPendingValue - ((1.0f - (jCurrentTimeMillis / i)) * this.mAnimationDistance));
                post(this.mNotifyProgressChangeAction);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
        QMUIProgressBarTextGenerator qMUIProgressBarTextGenerator = this.mQMUIProgressBarTextGenerator;
        if (qMUIProgressBarTextGenerator != null) {
            this.mText = qMUIProgressBarTextGenerator.generateText(this, this.mValue, this.mMaxValue);
        }
        int i2 = this.mType;
        if (((i2 == 0 || i2 == 1) && this.mBgRect == null) || ((i2 == 2 || i2 == 3) && this.mCenterPoint == null)) {
            configShape();
        }
        int i3 = this.mType;
        if (i3 == 0) {
            drawRect(canvas);
        } else if (i3 == 1) {
            drawRoundRect(canvas);
        } else {
            drawCircle(canvas, i3 == 3);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.mHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        configShape();
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    private void drawRect(Canvas canvas) {
        canvas.drawRect(this.mBgRect, this.mBackgroundPaint);
        this.mProgressRect.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + parseValueToWidth(), getPaddingTop() + this.mHeight);
        canvas.drawRect(this.mProgressRect, this.mPaint);
        String str = this.mText;
        if (str == null || str.length() <= 0) {
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        canvas.drawText(this.mText, this.mBgRect.centerX(), (this.mBgRect.top + (((this.mBgRect.height() - fontMetricsInt.bottom) + fontMetricsInt.top) / 2.0f)) - fontMetricsInt.top, this.mTextPaint);
    }

    private void drawRoundRect(Canvas canvas) {
        float f = this.mHeight / 2.0f;
        canvas.drawRoundRect(this.mBgRect, f, f, this.mBackgroundPaint);
        this.mProgressRect.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + parseValueToWidth(), getPaddingTop() + this.mHeight);
        canvas.drawRoundRect(this.mProgressRect, f, f, this.mPaint);
        String str = this.mText;
        if (str == null || str.length() <= 0) {
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        canvas.drawText(this.mText, this.mBgRect.centerX(), (this.mBgRect.top + (((this.mBgRect.height() - fontMetricsInt.bottom) + fontMetricsInt.top) / 2.0f)) - fontMetricsInt.top, this.mTextPaint);
    }

    private void drawCircle(Canvas canvas, boolean z) {
        canvas.drawCircle(this.mCenterPoint.x, this.mCenterPoint.y, this.mCircleRadius, this.mBackgroundPaint);
        this.mArcOval.left = this.mCenterPoint.x - this.mCircleRadius;
        this.mArcOval.right = this.mCenterPoint.x + this.mCircleRadius;
        this.mArcOval.top = this.mCenterPoint.y - this.mCircleRadius;
        this.mArcOval.bottom = this.mCenterPoint.y + this.mCircleRadius;
        int i = this.mValue;
        if (i > 0) {
            canvas.drawArc(this.mArcOval, 270.0f, (i * 360.0f) / this.mMaxValue, z, this.mPaint);
        }
        String str = this.mText;
        if (str == null || str.length() <= 0) {
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        canvas.drawText(this.mText, this.mCenterPoint.x, (this.mArcOval.top + (((this.mArcOval.height() - fontMetricsInt.bottom) + fontMetricsInt.top) / 2.0f)) - fontMetricsInt.top, this.mTextPaint);
    }

    private int parseValueToWidth() {
        return (this.mWidth * this.mValue) / this.mMaxValue;
    }

    public int getProgress() {
        return this.mValue;
    }

    public void setProgress(int i) {
        setProgress(i, true);
    }

    public void setProgress(int i, boolean z) {
        int i2 = this.mMaxValue;
        if (i > i2 || i < 0) {
            return;
        }
        int i3 = this.mPendingValue;
        if (i3 == -1 && this.mValue == i) {
            return;
        }
        if (i3 == -1 || i3 != i) {
            if (!z) {
                this.mPendingValue = -1;
                this.mValue = i;
                this.mNotifyProgressChangeAction.run();
                invalidate();
                return;
            }
            this.mAnimationDuration = Math.abs((int) (((this.mValue - i) * 1000) / i2));
            this.mAnimationStartTime = System.currentTimeMillis();
            this.mAnimationDistance = i - this.mValue;
            this.mPendingValue = i;
            invalidate();
        }
    }

    public int getMaxValue() {
        return this.mMaxValue;
    }

    public void setMaxValue(int i) {
        this.mMaxValue = i;
    }
}
