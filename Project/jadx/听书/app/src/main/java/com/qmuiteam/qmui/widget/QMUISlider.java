package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.collection.SimpleArrayMap;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUILayoutHelper;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.util.QMUIViewOffsetHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISlider extends FrameLayout implements IQMUISkinDefaultAttrProvider {
    public static final int PROGRESS_NOT_SET = -1;
    private static SimpleArrayMap<String, Integer> sDefaultSkinAttrs;
    private int mBarHeight;
    private int mBarNormalColor;
    private Paint mBarPaint;
    private int mBarProgressColor;
    private Callback mCallback;
    private boolean mClickToChangeProgress;
    private boolean mConstraintThumbInMoving;
    private int mCurrentProgress;
    private int mDownTouchX;
    private boolean mIsMoving;
    private boolean mIsProgressFirstSet;
    private boolean mIsThumbTouched;
    private int mLastTouchX;
    private LongPressAction mLongPressAction;
    private boolean mLongTouchToChangeProgress;
    private int mRecordProgress;
    private int mRecordProgressColor;
    private RectF mTempRect;
    private IThumbView mThumbView;
    private QMUIViewOffsetHelper mThumbViewOffsetHelper;
    private int mTickCount;
    private int mTouchSlop;

    public interface Callback {
        void onLongTouch(QMUISlider qMUISlider, int i, int i2);

        void onProgressChange(QMUISlider qMUISlider, int i, int i2, boolean z);

        void onStartMoving(QMUISlider qMUISlider, int i, int i2);

        void onStopMoving(QMUISlider qMUISlider, int i, int i2);

        void onTouchDown(QMUISlider qMUISlider, int i, int i2, boolean z);

        void onTouchUp(QMUISlider qMUISlider, int i, int i2);
    }

    public static class DefaultCallback implements Callback {
        @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
        public void onLongTouch(QMUISlider qMUISlider, int i, int i2) {
        }

        @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
        public void onProgressChange(QMUISlider qMUISlider, int i, int i2, boolean z) {
        }

        @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
        public void onStartMoving(QMUISlider qMUISlider, int i, int i2) {
        }

        @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
        public void onStopMoving(QMUISlider qMUISlider, int i, int i2) {
        }

        @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
        public void onTouchDown(QMUISlider qMUISlider, int i, int i2, boolean z) {
        }

        @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
        public void onTouchUp(QMUISlider qMUISlider, int i, int i2) {
        }
    }

    public interface IThumbView {
        int getLeftRightMargin();

        void render(int i, int i2);

        void setPress(boolean z);
    }

    protected void drawTick(Canvas canvas, int i, int i2, int i3, int i4, float f, Paint paint, int i5, int i6) {
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    protected void onLayoutCustomChildren(boolean z, int i, int i2, int i3, int i4) {
    }

    static {
        SimpleArrayMap<String, Integer> simpleArrayMap = new SimpleArrayMap<>(2);
        sDefaultSkinAttrs = simpleArrayMap;
        simpleArrayMap.put(QMUISkinValueBuilder.BACKGROUND, Integer.valueOf(R.attr.qmui_skin_support_slider_bar_bg_color));
        sDefaultSkinAttrs.put(QMUISkinValueBuilder.PROGRESS_COLOR, Integer.valueOf(R.attr.qmui_skin_support_slider_bar_progress_color));
        sDefaultSkinAttrs.put(QMUISkinValueBuilder.HINT_COLOR, Integer.valueOf(R.attr.qmui_skin_support_slider_record_progress_color));
    }

    public QMUISlider(Context context) {
        this(context, null);
    }

    public QMUISlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUISliderStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QMUISlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mConstraintThumbInMoving = true;
        this.mCurrentProgress = 0;
        this.mIsProgressFirstSet = false;
        this.mClickToChangeProgress = false;
        this.mLongTouchToChangeProgress = false;
        this.mRecordProgress = -1;
        this.mDownTouchX = 0;
        this.mLastTouchX = 0;
        this.mIsThumbTouched = false;
        this.mIsMoving = false;
        this.mTempRect = new RectF();
        this.mLongPressAction = new LongPressAction();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.QMUISlider, i, 0);
        this.mBarHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUISlider_qmui_slider_bar_height, QMUIDisplayHelper.dp2px(context, 2));
        this.mBarNormalColor = typedArrayObtainStyledAttributes.getColor(R.styleable.QMUISlider_qmui_slider_bar_normal_color, -1);
        this.mBarProgressColor = typedArrayObtainStyledAttributes.getColor(R.styleable.QMUISlider_qmui_slider_bar_progress_color, QMUIProgressBar.DEFAULT_PROGRESS_COLOR);
        this.mRecordProgressColor = typedArrayObtainStyledAttributes.getColor(R.styleable.QMUISlider_qmui_slider_bar_record_progress_color, QMUIProgressBar.DEFAULT_BACKGROUND_COLOR);
        this.mTickCount = typedArrayObtainStyledAttributes.getInt(R.styleable.QMUISlider_qmui_slider_bar_tick_count, 100);
        this.mConstraintThumbInMoving = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUISlider_qmui_slider_bar_constraint_thumb_in_moving, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUISlider_qmui_slider_bar_thumb_size, QMUIDisplayHelper.dp2px(getContext(), 24));
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.QMUISlider_qmui_slider_bar_thumb_style_attr);
        int identifier = string != null ? getResources().getIdentifier(string, "attr", context.getPackageName()) : 0;
        if (!typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUISlider_qmui_slider_bar_use_clip_children_by_developer, false)) {
            int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.QMUISlider_qmui_slider_bar_padding_hor_for_thumb_shadow, 0);
            int dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.QMUISlider_qmui_slider_bar_padding_ver_for_thumb_shadow, 0);
            setPadding(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
        }
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mBarPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mBarPaint.setAntiAlias(true);
        this.mTouchSlop = QMUIDisplayHelper.dp2px(context, 2);
        setWillNotDraw(false);
        setClipToPadding(false);
        setClipChildren(false);
        IThumbView iThumbViewOnCreateThumbView = onCreateThumbView(context, dimensionPixelSize, identifier);
        if (!(iThumbViewOnCreateThumbView instanceof View)) {
            throw new IllegalArgumentException("thumbView must be a instance of View");
        }
        this.mThumbView = iThumbViewOnCreateThumbView;
        View view = (View) iThumbViewOnCreateThumbView;
        this.mThumbViewOffsetHelper = new QMUIViewOffsetHelper(view);
        addView(view, onCreateThumbLayoutParams());
        iThumbViewOnCreateThumbView.render(this.mCurrentProgress, this.mTickCount);
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setCurrentProgress(int i) {
        if (this.mIsMoving) {
            return;
        }
        int iConstrain = QMUILangHelper.constrain(i, 0, this.mTickCount);
        if (this.mCurrentProgress == iConstrain && this.mIsProgressFirstSet) {
            return;
        }
        this.mIsProgressFirstSet = true;
        safeSetCurrentProgress(iConstrain);
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onProgressChange(this, iConstrain, this.mTickCount, false);
        }
        invalidate();
    }

    public void setRecordProgress(int i) {
        if (i != this.mRecordProgress) {
            if (i != -1) {
                i = QMUILangHelper.constrain(i, 0, this.mTickCount);
            }
            this.mRecordProgress = i;
            invalidate();
        }
    }

    public int getCurrentProgress() {
        return this.mCurrentProgress;
    }

    public void setTickCount(int i) {
        if (this.mTickCount != i) {
            this.mTickCount = i;
            setCurrentProgress(QMUILangHelper.constrain(this.mCurrentProgress, 0, i));
            this.mThumbView.render(this.mCurrentProgress, this.mTickCount);
            invalidate();
        }
    }

    public int getTickCount() {
        return this.mTickCount;
    }

    public void setThumbSkin(QMUISkinValueBuilder qMUISkinValueBuilder) {
        QMUISkinHelper.setSkinValue(convertThumbToView(), qMUISkinValueBuilder);
    }

    private void safeSetCurrentProgress(int i) {
        this.mCurrentProgress = i;
        this.mThumbView.render(i, this.mTickCount);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        int i3 = this.mBarHeight;
        if (measuredHeight < i3) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i3 + getPaddingTop() + getPaddingBottom(), 1073741824));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        onLayoutCustomChildren(z, i, i2, i3, i4);
        View viewConvertThumbToView = convertThumbToView();
        int paddingTop = getPaddingTop();
        int measuredHeight = viewConvertThumbToView.getMeasuredHeight();
        int measuredWidth = viewConvertThumbToView.getMeasuredWidth();
        int paddingLeft = getPaddingLeft() + this.mThumbView.getLeftRightMargin();
        int paddingBottom = paddingTop + (((((i4 - i2) - paddingTop) - getPaddingBottom()) - viewConvertThumbToView.getMeasuredHeight()) / 2);
        viewConvertThumbToView.layout(paddingLeft, paddingBottom, measuredWidth + paddingLeft, measuredHeight + paddingBottom);
        this.mThumbViewOffsetHelper.onViewLayout();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            int x = (int) motionEvent.getX();
            this.mDownTouchX = x;
            this.mLastTouchX = x;
            boolean zIsThumbTouched = isThumbTouched(motionEvent.getX(), motionEvent.getY());
            this.mIsThumbTouched = zIsThumbTouched;
            if (zIsThumbTouched) {
                this.mThumbView.setPress(true);
            } else if (this.mLongTouchToChangeProgress) {
                removeCallbacks(this.mLongPressAction);
                postOnAnimationDelayed(this.mLongPressAction, 300L);
            }
            Callback callback = this.mCallback;
            if (callback != null) {
                callback.onTouchDown(this, this.mCurrentProgress, this.mTickCount, this.mIsThumbTouched);
            }
        } else if (action == 2) {
            int x2 = (int) motionEvent.getX();
            int i3 = x2 - this.mLastTouchX;
            this.mLastTouchX = x2;
            if (!this.mIsMoving && this.mIsThumbTouched && Math.abs(x2 - this.mDownTouchX) > this.mTouchSlop) {
                removeCallbacks(this.mLongPressAction);
                this.mIsMoving = true;
                Callback callback2 = this.mCallback;
                if (callback2 != null) {
                    callback2.onStartMoving(this, this.mCurrentProgress, this.mTickCount);
                }
                i3 = i3 > 0 ? i3 - this.mTouchSlop : i3 + this.mTouchSlop;
            }
            if (this.mIsMoving) {
                QMUIViewHelper.safeRequestDisallowInterceptTouchEvent(this, true);
                int maxThumbOffset = getMaxThumbOffset();
                int i4 = this.mCurrentProgress;
                if (this.mConstraintThumbInMoving) {
                    checkTouch(x2, maxThumbOffset);
                } else {
                    QMUIViewOffsetHelper qMUIViewOffsetHelper = this.mThumbViewOffsetHelper;
                    qMUIViewOffsetHelper.setLeftAndRightOffset(QMUILangHelper.constrain(qMUIViewOffsetHelper.getLeftAndRightOffset() + i3, 0, maxThumbOffset));
                    calculateByThumbPosition(maxThumbOffset);
                }
                Callback callback3 = this.mCallback;
                if (callback3 != null && i4 != (i2 = this.mCurrentProgress)) {
                    callback3.onProgressChange(this, i2, this.mTickCount, true);
                }
                invalidate();
            }
        } else if (action == 1 || action == 3) {
            removeCallbacks(this.mLongPressAction);
            this.mLastTouchX = -1;
            QMUIViewHelper.safeRequestDisallowInterceptTouchEvent(this, false);
            if (this.mIsMoving) {
                this.mIsMoving = false;
                Callback callback4 = this.mCallback;
                if (callback4 != null) {
                    callback4.onStopMoving(this, this.mCurrentProgress, this.mTickCount);
                }
            }
            if (this.mIsThumbTouched) {
                this.mIsThumbTouched = false;
                this.mThumbView.setPress(false);
            } else if (action == 1) {
                int x3 = (int) motionEvent.getX();
                boolean zIsRecordProgressClicked = isRecordProgressClicked(x3);
                if (Math.abs(x3 - this.mDownTouchX) < this.mTouchSlop && (this.mClickToChangeProgress || zIsRecordProgressClicked)) {
                    int i5 = this.mCurrentProgress;
                    if (zIsRecordProgressClicked) {
                        safeSetCurrentProgress(this.mRecordProgress);
                    } else {
                        checkTouch(x3, getMaxThumbOffset());
                    }
                    invalidate();
                    Callback callback5 = this.mCallback;
                    if (callback5 != null && i5 != (i = this.mCurrentProgress)) {
                        callback5.onProgressChange(this, i, this.mTickCount, true);
                    }
                }
            }
            Callback callback6 = this.mCallback;
            if (callback6 != null) {
                callback6.onTouchUp(this, this.mCurrentProgress, this.mTickCount);
            }
        } else {
            removeCallbacks(this.mLongPressAction);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTouch(int i, int i2) {
        if (this.mThumbView == null) {
            return;
        }
        float f = i2 / this.mTickCount;
        float paddingLeft = (i - getPaddingLeft()) - this.mThumbView.getLeftRightMargin();
        float f2 = f / 2.0f;
        if (paddingLeft <= f2) {
            this.mThumbViewOffsetHelper.setLeftAndRightOffset(0);
            safeSetCurrentProgress(0);
        } else if (i >= ((getWidth() - getPaddingRight()) - this.mThumbView.getLeftRightMargin()) - f2) {
            this.mThumbViewOffsetHelper.setLeftAndRightOffset(i2);
            safeSetCurrentProgress(this.mTickCount);
        } else {
            int width = (int) ((this.mTickCount * (paddingLeft / (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.mThumbView.getLeftRightMargin() * 2)))) + 0.5f);
            this.mThumbViewOffsetHelper.setLeftAndRightOffset((int) (width * f));
            safeSetCurrentProgress(width);
        }
    }

    public void setClickToChangeProgress(boolean z) {
        this.mClickToChangeProgress = z;
    }

    public void setLongTouchToChangeProgress(boolean z) {
        this.mLongTouchToChangeProgress = z;
    }

    public boolean isLongTouchToChangeProgress() {
        return this.mLongTouchToChangeProgress;
    }

    public boolean isClickToChangeProgress() {
        return this.mClickToChangeProgress;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int i = this.mBarHeight;
        int i2 = paddingTop + ((height - i) / 2);
        this.mBarPaint.setColor(this.mBarNormalColor);
        float f = paddingLeft;
        float f2 = i2;
        float f3 = i + i2;
        this.mTempRect.set(f, f2, width, f3);
        drawRect(canvas, this.mTempRect, this.mBarHeight, this.mBarPaint, false);
        float maxThumbOffset = getMaxThumbOffset() / this.mTickCount;
        int i3 = (int) (this.mCurrentProgress * maxThumbOffset);
        this.mBarPaint.setColor(this.mBarProgressColor);
        View viewConvertThumbToView = convertThumbToView();
        if (viewConvertThumbToView != null && viewConvertThumbToView.getVisibility() == 0) {
            if (!this.mIsMoving) {
                this.mThumbViewOffsetHelper.setLeftAndRightOffset(i3);
            }
            this.mTempRect.set(f, f2, (viewConvertThumbToView.getRight() + viewConvertThumbToView.getLeft()) / 2.0f, f3);
            drawRect(canvas, this.mTempRect, this.mBarHeight, this.mBarPaint, true);
        } else {
            this.mTempRect.set(f, f2, i3 + paddingLeft, f3);
            drawRect(canvas, this.mTempRect, this.mBarHeight, this.mBarPaint, true);
        }
        drawTick(canvas, this.mCurrentProgress, this.mTickCount, paddingLeft, width, this.mTempRect.centerY(), this.mBarPaint, this.mBarNormalColor, this.mBarProgressColor);
        if (this.mRecordProgress == -1 || viewConvertThumbToView == null) {
            return;
        }
        this.mBarPaint.setColor(this.mRecordProgressColor);
        float paddingLeft2 = getPaddingLeft() + this.mThumbView.getLeftRightMargin() + ((int) (maxThumbOffset * this.mRecordProgress));
        this.mTempRect.set(paddingLeft2, viewConvertThumbToView.getTop(), viewConvertThumbToView.getWidth() + paddingLeft2, viewConvertThumbToView.getBottom());
        drawRecordProgress(canvas, this.mTempRect, this.mBarPaint);
    }

    protected void drawRect(Canvas canvas, RectF rectF, int i, Paint paint, boolean z) {
        float f = i / 2;
        canvas.drawRoundRect(rectF, f, f, paint);
    }

    protected void drawRecordProgress(Canvas canvas, RectF rectF, Paint paint) {
        float fHeight = rectF.height() / 2.0f;
        canvas.drawRoundRect(rectF, fHeight, fHeight, paint);
    }

    public void setBarHeight(int i) {
        if (this.mBarHeight != i) {
            this.mBarHeight = i;
            requestLayout();
        }
    }

    public int getBarHeight() {
        return this.mBarHeight;
    }

    public void setBarNormalColor(int i) {
        if (this.mBarNormalColor != i) {
            this.mBarNormalColor = i;
            invalidate();
        }
    }

    public int getBarNormalColor() {
        return this.mBarNormalColor;
    }

    public void setBarProgressColor(int i) {
        if (this.mBarProgressColor != i) {
            this.mBarProgressColor = i;
            invalidate();
        }
    }

    public int getBarProgressColor() {
        return this.mBarProgressColor;
    }

    public void setRecordProgressColor(int i) {
        if (this.mRecordProgressColor != i) {
            this.mRecordProgressColor = i;
            invalidate();
        }
    }

    public int getRecordProgressColor() {
        return this.mRecordProgressColor;
    }

    public int getRecordProgress() {
        return this.mRecordProgress;
    }

    public void setConstraintThumbInMoving(boolean z) {
        this.mConstraintThumbInMoving = z;
    }

    private void calculateByThumbPosition(int i) {
        convertThumbToView();
        float leftAndRightOffset = (this.mThumbViewOffsetHelper.getLeftAndRightOffset() * 1.0f) / i;
        int i2 = this.mTickCount;
        safeSetCurrentProgress(QMUILangHelper.constrain((int) ((i2 * leftAndRightOffset) + 0.5f), 0, i2));
    }

    protected IThumbView onCreateThumbView(Context context, int i, int i2) {
        return new DefaultThumbView(context, i, i2);
    }

    protected FrameLayout.LayoutParams onCreateThumbLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    private View convertThumbToView() {
        return (View) this.mThumbView;
    }

    private boolean isThumbTouched(float f, float f2) {
        return isThumbViewTouched(convertThumbToView(), f, f2);
    }

    protected boolean isThumbViewTouched(View view, float f, float f2) {
        return view.getVisibility() == 0 && ((float) view.getLeft()) <= f && ((float) view.getRight()) >= f && ((float) view.getTop()) <= f2 && ((float) view.getBottom()) >= f2;
    }

    protected boolean isRecordProgressClicked(int i) {
        if (this.mRecordProgress == -1) {
            return false;
        }
        float width = (((getWidth() - getPaddingLeft()) - getPaddingRight()) * ((this.mRecordProgress * 1.0f) / this.mTickCount)) - (r0.getWidth() / 2.0f);
        float f = i;
        return f >= width && f <= ((float) convertThumbToView().getWidth()) + width;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMaxThumbOffset() {
        return (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.mThumbView.getLeftRightMargin() * 2)) - convertThumbToView().getWidth();
    }

    public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
        return sDefaultSkinAttrs;
    }

    public static class DefaultThumbView extends View implements IThumbView, IQMUISkinDefaultAttrProvider {
        private static SimpleArrayMap<String, Integer> sDefaultSkinAttrs;
        private final QMUILayoutHelper mLayoutHelper;
        private final int mSize;

        @Override // com.qmuiteam.qmui.widget.QMUISlider.IThumbView
        public int getLeftRightMargin() {
            return 0;
        }

        @Override // com.qmuiteam.qmui.widget.QMUISlider.IThumbView
        public void render(int i, int i2) {
        }

        @Override // com.qmuiteam.qmui.widget.QMUISlider.IThumbView
        public void setPress(boolean z) {
        }

        static {
            SimpleArrayMap<String, Integer> simpleArrayMap = new SimpleArrayMap<>(2);
            sDefaultSkinAttrs = simpleArrayMap;
            simpleArrayMap.put(QMUISkinValueBuilder.BACKGROUND, Integer.valueOf(R.attr.qmui_skin_support_slider_thumb_bg_color));
            sDefaultSkinAttrs.put(QMUISkinValueBuilder.BORDER, Integer.valueOf(R.attr.qmui_skin_support_slider_thumb_border_color));
        }

        public DefaultThumbView(Context context, int i, int i2) {
            super(context, null, i2);
            this.mSize = i;
            QMUILayoutHelper qMUILayoutHelper = new QMUILayoutHelper(context, null, i2, this);
            this.mLayoutHelper = qMUILayoutHelper;
            qMUILayoutHelper.setRadius(i / 2);
            setPress(false);
        }

        @Override // android.view.View
        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            this.mLayoutHelper.drawDividers(canvas, getWidth(), getHeight());
            this.mLayoutHelper.dispatchRoundBorderDraw(canvas);
        }

        public void setBorderColor(int i) {
            this.mLayoutHelper.setBorderColor(i);
            invalidate();
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            int i3 = this.mSize;
            setMeasuredDimension(i3, i3);
        }

        @Override // com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
        public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
            return sDefaultSkinAttrs;
        }
    }

    class LongPressAction implements Runnable {
        LongPressAction() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QMUISlider.this.mIsMoving = true;
            int i = QMUISlider.this.mCurrentProgress;
            QMUISlider qMUISlider = QMUISlider.this;
            qMUISlider.checkTouch(qMUISlider.mLastTouchX, QMUISlider.this.getMaxThumbOffset());
            QMUISlider.this.mIsThumbTouched = true;
            QMUISlider.this.mThumbView.setPress(true);
            if (QMUISlider.this.mCallback == null || i == QMUISlider.this.mCurrentProgress) {
                return;
            }
            Callback callback = QMUISlider.this.mCallback;
            QMUISlider qMUISlider2 = QMUISlider.this;
            callback.onLongTouch(qMUISlider2, qMUISlider2.mCurrentProgress, QMUISlider.this.mTickCount);
        }
    }
}
