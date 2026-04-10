package com.scwang.smart.refresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.scwang.smart.refresh.header.material.CircleImageView;
import com.scwang.smart.refresh.header.material.MaterialProgressDrawable;
import com.scwang.smart.refresh.header.material.R;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshKernel;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;
import com.scwang.smart.refresh.layout.simple.SimpleComponent;
import com.scwang.smart.refresh.layout.util.SmartUtil;

/* JADX INFO: loaded from: classes4.dex */
public class MaterialHeader extends SimpleComponent implements RefreshHeader {
    protected static final int CIRCLE_BG_LIGHT = -328966;
    protected static final int CIRCLE_DIAMETER = 40;
    protected static final int CIRCLE_DIAMETER_LARGE = 56;
    protected static final float MAX_PROGRESS_ANGLE = 0.8f;
    public static final int SIZE_DEFAULT = 1;
    public static final int SIZE_LARGE = 0;
    protected Paint mBezierPaint;
    protected Path mBezierPath;
    protected int mCircleDiameter;
    protected ImageView mCircleView;
    protected boolean mFinished;
    protected int mHeadHeight;
    protected int mInitHeight;
    protected RefreshKernel mKernel;
    protected MaterialProgressDrawable mProgress;
    protected boolean mScrollableWhenRefreshing;
    protected boolean mShowBezierWave;
    protected RefreshState mState;
    protected int mWaveHeight;

    public MaterialHeader(Context context) {
        this(context, null);
    }

    public MaterialHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mShowBezierWave = false;
        this.mScrollableWhenRefreshing = true;
        this.mSpinnerStyle = SpinnerStyle.MatchLayout;
        setMinimumHeight(SmartUtil.dp2px(100.0f));
        MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(this);
        this.mProgress = materialProgressDrawable;
        materialProgressDrawable.setColorSchemeColors(-16737844, -48060, -10053376, -5609780, -30720);
        CircleImageView circleImageView = new CircleImageView(context, CIRCLE_BG_LIGHT);
        this.mCircleView = circleImageView;
        circleImageView.setImageDrawable(this.mProgress);
        this.mCircleView.setAlpha(0.0f);
        addView(this.mCircleView);
        this.mCircleDiameter = (int) (getResources().getDisplayMetrics().density * 40.0f);
        this.mBezierPath = new Path();
        Paint paint = new Paint();
        this.mBezierPaint = paint;
        paint.setAntiAlias(true);
        this.mBezierPaint.setStyle(Paint.Style.FILL);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialHeader);
        this.mShowBezierWave = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialHeader_srlShowBezierWave, this.mShowBezierWave);
        this.mScrollableWhenRefreshing = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialHeader_srlScrollableWhenRefreshing, this.mScrollableWhenRefreshing);
        this.mBezierPaint.setColor(typedArrayObtainStyledAttributes.getColor(R.styleable.MaterialHeader_srlPrimaryColor, -15614977));
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.MaterialHeader_srlShadowRadius)) {
            this.mBezierPaint.setShadowLayer(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialHeader_srlShadowRadius, 0), 0.0f, 0.0f, typedArrayObtainStyledAttributes.getColor(R.styleable.MaterialHeader_mhShadowColor, -16777216));
            setLayerType(1, null);
        }
        this.mShowBezierWave = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialHeader_mhShowBezierWave, this.mShowBezierWave);
        this.mScrollableWhenRefreshing = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialHeader_mhScrollableWhenRefreshing, this.mScrollableWhenRefreshing);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.MaterialHeader_mhPrimaryColor)) {
            this.mBezierPaint.setColor(typedArrayObtainStyledAttributes.getColor(R.styleable.MaterialHeader_mhPrimaryColor, -15614977));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.MaterialHeader_mhShadowRadius)) {
            this.mBezierPaint.setShadowLayer(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialHeader_mhShadowRadius, 0), 0.0f, 0.0f, typedArrayObtainStyledAttributes.getColor(R.styleable.MaterialHeader_mhShadowColor, -16777216));
            setLayerType(1, null);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824));
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (getChildCount() == 0) {
            return;
        }
        ImageView imageView = this.mCircleView;
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = imageView.getMeasuredWidth();
        int measuredHeight = imageView.getMeasuredHeight();
        if (isInEditMode() && (i5 = this.mHeadHeight) > 0) {
            int i6 = i5 - (measuredHeight / 2);
            int i7 = measuredWidth / 2;
            int i8 = measuredWidth2 / 2;
            imageView.layout(i7 - i8, i6, i7 + i8, measuredHeight + i6);
            this.mProgress.showArrow(true);
            this.mProgress.setStartEndTrim(0.0f, MAX_PROGRESS_ANGLE);
            this.mProgress.setArrowScale(1.0f);
            imageView.setAlpha(1.0f);
            imageView.setVisibility(0);
            return;
        }
        int i9 = measuredWidth / 2;
        int i10 = measuredWidth2 / 2;
        imageView.layout(i9 - i10, -measuredHeight, i9 + i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mShowBezierWave) {
            this.mBezierPath.reset();
            this.mBezierPath.lineTo(0.0f, this.mHeadHeight);
            this.mBezierPath.quadTo(getMeasuredWidth() / 2.0f, this.mHeadHeight + (this.mWaveHeight * 1.9f), getMeasuredWidth(), this.mHeadHeight);
            this.mBezierPath.lineTo(getMeasuredWidth(), 0.0f);
            canvas.drawPath(this.mBezierPath, this.mBezierPaint);
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, com.scwang.smart.refresh.layout.api.RefreshComponent
    public void onInitialized(RefreshKernel refreshKernel, int i, int i2) {
        if (!this.mShowBezierWave) {
            refreshKernel.requestDefaultTranslationContentFor(this, false);
        }
        if (isInEditMode()) {
            int i3 = i / 2;
            this.mHeadHeight = i3;
            this.mWaveHeight = i3;
        }
        this.mKernel = refreshKernel;
        this.mInitHeight = i;
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, com.scwang.smart.refresh.layout.api.RefreshComponent
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        if (this.mState == RefreshState.Refreshing) {
            return;
        }
        if (this.mShowBezierWave) {
            this.mHeadHeight = Math.min(i, i2);
            this.mWaveHeight = Math.max(0, i - i2);
            postInvalidate();
        }
        if (z || !(this.mProgress.isRunning() || this.mFinished)) {
            if (this.mState != RefreshState.Refreshing) {
                float f2 = i2;
                float fMax = (((float) Math.max(((double) Math.min(1.0f, Math.abs((i * 1.0f) / f2))) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
                double dMax = Math.max(0.0f, Math.min(Math.abs(i) - i2, f2 * 2.0f) / f2) / 4.0f;
                float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f;
                float f3 = fMax * MAX_PROGRESS_ANGLE;
                this.mProgress.showArrow(true);
                this.mProgress.setStartEndTrim(0.0f, Math.min(MAX_PROGRESS_ANGLE, f3));
                this.mProgress.setArrowScale(Math.min(1.0f, fMax));
                this.mProgress.setProgressRotation((((fMax * 0.4f) - 0.25f) + (fPow * 2.0f)) * 0.5f);
            }
            ImageView imageView = this.mCircleView;
            float f4 = i;
            imageView.setTranslationY(Math.min(f4, (f4 / 2.0f) + (this.mCircleDiameter / 2.0f)));
            imageView.setAlpha(Math.min(1.0f, (f4 * 4.0f) / this.mCircleDiameter));
        }
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, com.scwang.smart.refresh.layout.api.RefreshComponent
    public void onStartAnimator(RefreshLayout refreshLayout, int i, int i2) {
        this.mProgress.start();
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, com.scwang.smart.refresh.layout.listener.OnStateChangedListener
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        ImageView imageView = this.mCircleView;
        this.mState = refreshState2;
        if (AnonymousClass2.$SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState[refreshState2.ordinal()] != 4) {
            return;
        }
        this.mFinished = false;
        imageView.setVisibility(0);
        imageView.setTranslationY(0.0f);
        imageView.setScaleX(1.0f);
        imageView.setScaleY(1.0f);
    }

    /* JADX INFO: renamed from: com.scwang.smart.refresh.header.MaterialHeader$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState;

        static {
            int[] iArr = new int[RefreshState.values().length];
            $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState[RefreshState.ReleaseToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState[RefreshState.PullDownToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, com.scwang.smart.refresh.layout.api.RefreshComponent
    public int onFinish(RefreshLayout refreshLayout, boolean z) {
        ImageView imageView = this.mCircleView;
        this.mProgress.stop();
        imageView.animate().scaleX(0.0f).scaleY(0.0f);
        this.mFinished = true;
        return 0;
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, com.scwang.smart.refresh.layout.api.RefreshComponent
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.mBezierPaint.setColor(iArr[0]);
        }
    }

    public MaterialHeader setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), i));
        return this;
    }

    public MaterialHeader setProgressBackgroundColorSchemeColor(int i) {
        this.mCircleView.setBackgroundColor(i);
        return this;
    }

    public MaterialHeader setColorSchemeColors(int... iArr) {
        this.mProgress.setColorSchemeColors(iArr);
        return this;
    }

    public MaterialHeader setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = ContextCompat.getColor(context, iArr[i]);
        }
        return setColorSchemeColors(iArr2);
    }

    public MaterialHeader setSize(int i) {
        if (i != 0 && i != 1) {
            return this;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (i == 0) {
            this.mCircleDiameter = (int) (displayMetrics.density * 56.0f);
        } else {
            this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
        }
        this.mCircleView.setImageDrawable(null);
        this.mProgress.updateSizes(i);
        this.mCircleView.setImageDrawable(this.mProgress);
        return this;
    }

    public MaterialHeader setShowBezierWave(boolean z) {
        this.mShowBezierWave = z;
        return this;
    }

    public MaterialHeader setScrollableWhenRefreshing(boolean z) {
        this.mScrollableWhenRefreshing = z;
        return this;
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, com.scwang.smart.refresh.layout.api.RefreshComponent
    public boolean autoOpen(int i, float f, final boolean z) {
        if (this.mShowBezierWave || this.mKernel == null) {
            return false;
        }
        final ImageView imageView = this.mCircleView;
        imageView.setAlpha(1.0f);
        imageView.setScaleX(0.0f);
        imageView.setScaleY(0.0f);
        imageView.setTranslationY((this.mInitHeight / 2.0f) + (this.mCircleDiameter / 2.0f));
        imageView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(i).setListener(new AnimatorListenerAdapter() { // from class: com.scwang.smart.refresh.header.MaterialHeader.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                imageView.animate().setListener(null);
                MaterialHeader.this.mProgress.start();
                MaterialHeader.this.mKernel.onAutoRefreshAnimationEnd(animator, z);
            }
        });
        return true;
    }
}
