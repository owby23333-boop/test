package miuix.appcompat.app;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import miuix.animation.styles.AlphaBlendingStateEffect;
import miuix.appcompat.R;
import miuix.internal.util.LiteUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes7.dex */
public class AlphaBlendingDrawable extends Drawable implements AlphaBlendingStateEffect.AlphaObserver {
    private static final boolean USE_FOLME = !LiteUtils.isCommonLiteStrategy();
    private float mActivatedAlpha;
    protected float[] mAllRadii;
    private float mCheckedAlpha;
    private float mFocusedAlpha;
    private float mHoveredAlpha;
    private float mHoveredCheckedAlpha;
    private int mInsetB;
    private int mInsetL;
    private int mInsetR;
    private int mInsetT;
    private float mNormalAlpha;
    private final Paint mPaint;
    private float mPressedAlpha;
    private int mRadius;
    protected final RectF mRect;
    private AlphaBlendingState mState;
    private AlphaBlendingStateEffect mStateEffect;
    private int mTintColor;

    public static final class AlphaBlendingState extends Drawable.ConstantState {
        float mActivatedAlpha;
        float mCheckedAlpha;
        float mFocusedAlpha;
        float mHoveredAlpha;
        float mHoveredCheckedAlpha;
        float mNormalAlpha;
        float mPressedAlpha;
        int mRadius;
        int mTintColor;

        public AlphaBlendingState() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new AlphaBlendingDrawable(new AlphaBlendingState(this), null);
        }

        public AlphaBlendingState(@NonNull AlphaBlendingState alphaBlendingState) {
            this.mTintColor = alphaBlendingState.mTintColor;
            this.mRadius = alphaBlendingState.mRadius;
            this.mNormalAlpha = alphaBlendingState.mNormalAlpha;
            this.mPressedAlpha = alphaBlendingState.mPressedAlpha;
            this.mHoveredAlpha = alphaBlendingState.mHoveredAlpha;
            this.mFocusedAlpha = alphaBlendingState.mFocusedAlpha;
            this.mActivatedAlpha = alphaBlendingState.mActivatedAlpha;
            this.mCheckedAlpha = alphaBlendingState.mCheckedAlpha;
            this.mHoveredCheckedAlpha = alphaBlendingState.mHoveredCheckedAlpha;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(@Nullable Resources resources) {
            return new AlphaBlendingDrawable(new AlphaBlendingState(this), resources);
        }
    }

    public AlphaBlendingDrawable() {
        this.mRect = new RectF();
        this.mAllRadii = new float[8];
        this.mPaint = new Paint();
        AlphaBlendingStateEffect alphaBlendingStateEffect = new AlphaBlendingStateEffect(this);
        this.mStateEffect = alphaBlendingStateEffect;
        alphaBlendingStateEffect.setEnableAnim(USE_FOLME);
        this.mState = new AlphaBlendingState();
    }

    private void init() {
        this.mPaint.setColor(this.mTintColor);
        AlphaBlendingStateEffect alphaBlendingStateEffect = this.mStateEffect;
        alphaBlendingStateEffect.normalAlpha = this.mNormalAlpha;
        alphaBlendingStateEffect.pressedAlpha = this.mPressedAlpha;
        alphaBlendingStateEffect.hoveredAlpha = this.mHoveredAlpha;
        alphaBlendingStateEffect.focusedAlpha = this.mFocusedAlpha;
        alphaBlendingStateEffect.checkedAlpha = this.mCheckedAlpha;
        alphaBlendingStateEffect.activatedAlpha = this.mActivatedAlpha;
        alphaBlendingStateEffect.hoveredCheckedAlpha = this.mHoveredCheckedAlpha;
        alphaBlendingStateEffect.initStates();
    }

    private void updateLocalState() {
        AlphaBlendingState alphaBlendingState = this.mState;
        alphaBlendingState.mTintColor = this.mTintColor;
        alphaBlendingState.mRadius = this.mRadius;
        alphaBlendingState.mNormalAlpha = this.mNormalAlpha;
        alphaBlendingState.mPressedAlpha = this.mPressedAlpha;
        alphaBlendingState.mHoveredAlpha = this.mHoveredAlpha;
        alphaBlendingState.mFocusedAlpha = this.mFocusedAlpha;
        alphaBlendingState.mActivatedAlpha = this.mActivatedAlpha;
        alphaBlendingState.mCheckedAlpha = this.mCheckedAlpha;
        alphaBlendingState.mHoveredCheckedAlpha = this.mHoveredCheckedAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (isVisible()) {
            RectF rectF = this.mRect;
            int i = this.mRadius;
            canvas.drawRoundRect(rectF, i, i, this.mPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.mState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray typedArrayObtainStyledAttributes = theme != null ? theme.obtainStyledAttributes(attributeSet, R.styleable.StateTransitionDrawable, 0, 0) : resources.obtainAttributes(attributeSet, R.styleable.StateTransitionDrawable);
        this.mTintColor = typedArrayObtainStyledAttributes.getColor(R.styleable.StateTransitionDrawable_tintColor, -16777216);
        this.mRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StateTransitionDrawable_tintRadius, 0);
        this.mNormalAlpha = typedArrayObtainStyledAttributes.getFloat(R.styleable.StateTransitionDrawable_normalAlpha, 0.0f);
        this.mPressedAlpha = typedArrayObtainStyledAttributes.getFloat(R.styleable.StateTransitionDrawable_pressedAlpha, 0.0f);
        float f = typedArrayObtainStyledAttributes.getFloat(R.styleable.StateTransitionDrawable_hoveredAlpha, 0.0f);
        this.mHoveredAlpha = f;
        this.mFocusedAlpha = typedArrayObtainStyledAttributes.getFloat(R.styleable.StateTransitionDrawable_focusedAlpha, f);
        this.mActivatedAlpha = typedArrayObtainStyledAttributes.getFloat(R.styleable.StateTransitionDrawable_activatedAlpha, 0.0f);
        this.mCheckedAlpha = typedArrayObtainStyledAttributes.getFloat(R.styleable.StateTransitionDrawable_checkedAlpha, 0.0f);
        this.mHoveredCheckedAlpha = typedArrayObtainStyledAttributes.getFloat(R.styleable.StateTransitionDrawable_hoveredCheckedAlpha, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        int i = this.mRadius;
        this.mAllRadii = new float[]{i, i, i, i, i, i, i, i};
        init();
        updateLocalState();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.mStateEffect.jumpToCurrentState();
    }

    @Override // miuix.animation.styles.AlphaBlendingStateEffect.AlphaObserver
    public void onAlphaChanged(float f) {
        this.mPaint.setAlpha((int) (f * 255.0f));
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        this.mRect.set(rect);
        RectF rectF = this.mRect;
        rectF.left += this.mInsetL;
        rectF.top += this.mInsetT;
        rectF.right -= this.mInsetR;
        rectF.bottom -= this.mInsetB;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@NonNull int[] iArr) {
        return this.mStateEffect.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    public void setInset(int i, int i2, int i3, int i4) {
        this.mInsetL = i;
        this.mInsetT = i2;
        this.mInsetR = i3;
        this.mInsetB = i4;
    }

    public void setRadius(int i) {
        if (this.mRadius == i) {
            return;
        }
        this.mRadius = i;
        this.mState.mRadius = i;
        invalidateSelf();
    }

    public AlphaBlendingDrawable(AlphaBlendingState alphaBlendingState, Resources resources) {
        this.mRect = new RectF();
        this.mAllRadii = new float[8];
        this.mPaint = new Paint();
        AlphaBlendingStateEffect alphaBlendingStateEffect = new AlphaBlendingStateEffect(this);
        this.mStateEffect = alphaBlendingStateEffect;
        alphaBlendingStateEffect.setEnableAnim(USE_FOLME);
        this.mTintColor = alphaBlendingState.mTintColor;
        this.mRadius = alphaBlendingState.mRadius;
        this.mNormalAlpha = alphaBlendingState.mNormalAlpha;
        this.mPressedAlpha = alphaBlendingState.mPressedAlpha;
        this.mHoveredAlpha = alphaBlendingState.mHoveredAlpha;
        this.mFocusedAlpha = alphaBlendingState.mFocusedAlpha;
        this.mActivatedAlpha = alphaBlendingState.mActivatedAlpha;
        this.mCheckedAlpha = alphaBlendingState.mCheckedAlpha;
        this.mHoveredCheckedAlpha = alphaBlendingState.mHoveredCheckedAlpha;
        this.mState = new AlphaBlendingState();
        updateLocalState();
        init();
    }
}
