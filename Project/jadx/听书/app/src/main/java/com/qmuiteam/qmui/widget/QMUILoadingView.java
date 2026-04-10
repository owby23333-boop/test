package com.qmuiteam.qmui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.collection.SimpleArrayMap;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUILoadingView extends View implements IQMUISkinDefaultAttrProvider {
    private static final int DEGREE_PER_LINE = 30;
    private static final int LINE_COUNT = 12;
    private static SimpleArrayMap<String, Integer> sDefaultAttrs;
    private int mAnimateValue;
    private ValueAnimator mAnimator;
    private Paint mPaint;
    private int mPaintColor;
    private int mSize;
    private ValueAnimator.AnimatorUpdateListener mUpdateListener;

    static {
        SimpleArrayMap<String, Integer> simpleArrayMap = new SimpleArrayMap<>();
        sDefaultAttrs = simpleArrayMap;
        simpleArrayMap.put(QMUISkinValueBuilder.TINT_COLOR, Integer.valueOf(R.attr.qmui_skin_support_loading_color));
    }

    public QMUILoadingView(Context context) {
        this(context, null);
    }

    public QMUILoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUILoadingStyle);
    }

    public QMUILoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAnimateValue = 0;
        this.mUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.qmuiteam.qmui.widget.QMUILoadingView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                QMUILoadingView.this.mAnimateValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                QMUILoadingView.this.invalidate();
            }
        };
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.QMUILoadingView, i, 0);
        this.mSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUILoadingView_qmui_loading_view_size, QMUIDisplayHelper.dp2px(context, 32));
        this.mPaintColor = typedArrayObtainStyledAttributes.getInt(R.styleable.QMUILoadingView_android_color, -1);
        typedArrayObtainStyledAttributes.recycle();
        initPaint();
    }

    public QMUILoadingView(Context context, int i, int i2) {
        super(context);
        this.mAnimateValue = 0;
        this.mUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.qmuiteam.qmui.widget.QMUILoadingView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                QMUILoadingView.this.mAnimateValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                QMUILoadingView.this.invalidate();
            }
        };
        this.mSize = i;
        this.mPaintColor = i2;
        initPaint();
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(this.mPaintColor);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void setColor(int i) {
        this.mPaintColor = i;
        this.mPaint.setColor(i);
        invalidate();
    }

    public void setSize(int i) {
        this.mSize = i;
        requestLayout();
    }

    public void start() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator == null) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 11);
            this.mAnimator = valueAnimatorOfInt;
            valueAnimatorOfInt.addUpdateListener(this.mUpdateListener);
            this.mAnimator.setDuration(600L);
            this.mAnimator.setRepeatMode(1);
            this.mAnimator.setRepeatCount(-1);
            this.mAnimator.setInterpolator(new LinearInterpolator());
            this.mAnimator.start();
            return;
        }
        if (valueAnimator.isStarted()) {
            return;
        }
        this.mAnimator.start();
    }

    public void stop() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeUpdateListener(this.mUpdateListener);
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
    }

    private void drawLoading(Canvas canvas, int i) {
        int i2 = this.mSize;
        int i3 = i2 / 12;
        int i4 = i2 / 6;
        this.mPaint.setStrokeWidth(i3);
        int i5 = this.mSize;
        canvas.rotate(i, i5 / 2, i5 / 2);
        int i6 = this.mSize;
        canvas.translate(i6 / 2, i6 / 2);
        int i7 = 0;
        while (i7 < 12) {
            canvas.rotate(30.0f);
            i7++;
            this.mPaint.setAlpha((int) ((i7 * 255.0f) / 12.0f));
            int i8 = i3 / 2;
            canvas.translate(0.0f, ((-this.mSize) / 2) + i8);
            canvas.drawLine(0.0f, 0.0f, 0.0f, i4, this.mPaint);
            canvas.translate(0.0f, (this.mSize / 2) - i8);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.mSize;
        setMeasuredDimension(i3, i3);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        drawLoading(canvas, this.mAnimateValue * 30);
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        start();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            start();
        } else {
            stop();
        }
    }

    @Override // com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
    public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
        return sDefaultAttrs;
    }
}
