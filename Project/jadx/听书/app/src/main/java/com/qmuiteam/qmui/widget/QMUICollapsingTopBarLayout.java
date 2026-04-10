package com.qmuiteam.qmui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.qmuiteam.qmui.QMUIInterpolatorStaticHolder;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.skin.IQMUISkinDispatchInterceptor;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.util.QMUICollapsingTextHelper;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.util.QMUIViewOffsetHelper;
import com.qmuiteam.qmui.util.QMUIWindowInsetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class QMUICollapsingTopBarLayout extends FrameLayout implements IQMUISkinDispatchInterceptor {
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    private int mCollapsedTextColorSkinAttr;
    final QMUICollapsingTextHelper mCollapsingTextHelper;
    private boolean mCollapsingTitleEnabled;
    private Drawable mContentScrim;
    private int mContentScrimSkinAttr;
    int mCurrentOffset;
    private int mExpandedMarginBottom;
    private int mExpandedMarginEnd;
    private int mExpandedMarginStart;
    private int mExpandedMarginTop;
    private int mExpandedTextColorSkinAttr;
    Insets mLastInsets;
    private AppBarLayout.OnOffsetChangedListener mOnOffsetChangedListener;
    private ArrayList<OnOffsetUpdateListener> mOnOffsetUpdateListeners;
    private boolean mRefreshToolbar;
    private int mScrimAlpha;
    private long mScrimAnimationDuration;
    private ValueAnimator mScrimAnimator;
    private ValueAnimator.AnimatorUpdateListener mScrimUpdateListener;
    private int mScrimVisibleHeightTrigger;
    private boolean mScrimsAreShown;
    Drawable mStatusBarScrim;
    private int mStatusBarScrimSkinAttr;
    private final Rect mTmpRect;
    private QMUITopBar mTopBar;
    private View mTopBarDirectChild;
    private int mTopBarId;

    public interface OnOffsetUpdateListener {
        void onOffsetChanged(QMUICollapsingTopBarLayout qMUICollapsingTopBarLayout, int i, float f);
    }

    public QMUICollapsingTopBarLayout(Context context) {
        this(context, null);
    }

    public QMUICollapsingTopBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUICollapsingTopBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRefreshToolbar = true;
        this.mTmpRect = new Rect();
        this.mScrimVisibleHeightTrigger = -1;
        this.mOnOffsetUpdateListeners = new ArrayList<>();
        this.mContentScrimSkinAttr = 0;
        this.mStatusBarScrimSkinAttr = 0;
        this.mCollapsedTextColorSkinAttr = 0;
        this.mExpandedTextColorSkinAttr = 0;
        QMUICollapsingTextHelper qMUICollapsingTextHelper = new QMUICollapsingTextHelper(this);
        this.mCollapsingTextHelper = qMUICollapsingTextHelper;
        qMUICollapsingTextHelper.setTextSizeInterpolator(QMUIInterpolatorStaticHolder.DECELERATE_INTERPOLATOR);
        QMUIViewHelper.checkAppCompatTheme(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUICollapsingTopBarLayout, i, 0);
        qMUICollapsingTextHelper.setExpandedTextGravity(typedArrayObtainStyledAttributes.getInt(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleGravity, 81));
        qMUICollapsingTextHelper.setCollapsedTextGravity(typedArrayObtainStyledAttributes.getInt(R.styleable.QMUICollapsingTopBarLayout_qmui_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMargin, 0);
        this.mExpandedMarginBottom = dimensionPixelSize;
        this.mExpandedMarginEnd = dimensionPixelSize;
        this.mExpandedMarginTop = dimensionPixelSize;
        this.mExpandedMarginStart = dimensionPixelSize;
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginStart)) {
            this.mExpandedMarginStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginStart, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginEnd)) {
            this.mExpandedMarginEnd = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginEnd, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginTop)) {
            this.mExpandedMarginTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginTop, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginBottom)) {
            this.mExpandedMarginBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginBottom, 0);
        }
        this.mCollapsingTitleEnabled = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUICollapsingTopBarLayout_qmui_titleEnabled, true);
        setTitle(typedArrayObtainStyledAttributes.getText(R.styleable.QMUICollapsingTopBarLayout_qmui_title));
        qMUICollapsingTextHelper.setExpandedTextAppearance(R.style.QMUI_CollapsingTopBarLayoutExpanded);
        qMUICollapsingTextHelper.setCollapsedTextAppearance(R.style.QMUI_CollapsingTopBarLayoutCollapsed);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleTextAppearance)) {
            qMUICollapsingTextHelper.setExpandedTextAppearance(typedArrayObtainStyledAttributes.getResourceId(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleTextAppearance, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.QMUICollapsingTopBarLayout_qmui_collapsedTitleTextAppearance)) {
            qMUICollapsingTextHelper.setCollapsedTextAppearance(typedArrayObtainStyledAttributes.getResourceId(R.styleable.QMUICollapsingTopBarLayout_qmui_collapsedTitleTextAppearance, 0));
        }
        this.mScrimVisibleHeightTrigger = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUICollapsingTopBarLayout_qmui_scrimVisibleHeightTrigger, -1);
        this.mScrimAnimationDuration = typedArrayObtainStyledAttributes.getInt(R.styleable.QMUICollapsingTopBarLayout_qmui_scrimAnimationDuration, 600);
        this.mTopBarId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.QMUICollapsingTopBarLayout_qmui_topBarId, -1);
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUICollapsingTopBarLayout_qmui_followTopBarCommonSkin, false)) {
            followTopBarCommonSkin();
        } else {
            setContentScrimInner(typedArrayObtainStyledAttributes.getDrawable(R.styleable.QMUICollapsingTopBarLayout_qmui_contentScrim));
            setStatusBarScrimInner(typedArrayObtainStyledAttributes.getDrawable(R.styleable.QMUICollapsingTopBarLayout_qmui_statusBarScrim));
        }
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        QMUIWindowInsetHelper.handleWindowInsets(this, WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.displayCutout(), new QMUIWindowInsetHelper.InsetHandler() { // from class: com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout.1
            @Override // com.qmuiteam.qmui.util.QMUIWindowInsetHelper.InsetHandler
            public void handleInset(View view, Insets insets) {
                Insets insets2 = ViewCompat.getFitsSystemWindows(view) ? insets : null;
                if (Objects.equals(QMUICollapsingTopBarLayout.this.mLastInsets, insets)) {
                    return;
                }
                QMUICollapsingTopBarLayout.this.mLastInsets = insets2;
                QMUICollapsingTopBarLayout.this.requestLayout();
            }
        }, true, false, true);
    }

    public void followTopBarCommonSkin() {
        setCollapsedTextColorSkinAttr(R.attr.qmui_skin_support_topbar_title_color);
        setExpandedTextColorSkinAttr(R.attr.qmui_skin_support_topbar_title_color);
        setContentScrimSkinAttr(R.attr.qmui_skin_support_topbar_bg);
        setStatusBarScrimSkinAttr(R.attr.qmui_skin_support_topbar_bg);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof QMUITopBar) {
            ((QMUITopBar) view).disableBackgroundSetter();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object parent = getParent();
        if (parent instanceof AppBarLayout) {
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View) parent));
            if (this.mOnOffsetChangedListener == null) {
                this.mOnOffsetChangedListener = new OffsetUpdateListener();
            }
            ((AppBarLayout) parent).addOnOffsetChangedListener(this.mOnOffsetChangedListener);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.mOnOffsetChangedListener;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int windowInsetTop;
        Drawable drawable;
        super.draw(canvas);
        ensureToolbar();
        if (this.mTopBar == null && (drawable = this.mContentScrim) != null && this.mScrimAlpha > 0) {
            drawable.mutate().setAlpha(this.mScrimAlpha);
            this.mContentScrim.draw(canvas);
        }
        if (this.mCollapsingTitleEnabled) {
            this.mCollapsingTextHelper.draw(canvas);
        }
        if (this.mStatusBarScrim == null || this.mScrimAlpha <= 0 || (windowInsetTop = getWindowInsetTop()) <= 0) {
            return;
        }
        this.mStatusBarScrim.setBounds(0, -this.mCurrentOffset, getWidth(), windowInsetTop - this.mCurrentOffset);
        this.mStatusBarScrim.mutate().setAlpha(this.mScrimAlpha);
        this.mStatusBarScrim.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWindowInsetTop() {
        Insets insets = this.mLastInsets;
        if (insets != null) {
            return insets.f59top;
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.mContentScrim == null || this.mScrimAlpha <= 0 || !isToolbarChild(view)) {
            z = false;
        } else {
            this.mContentScrim.mutate().setAlpha(this.mScrimAlpha);
            this.mContentScrim.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j) || z;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Drawable drawable = this.mContentScrim;
        if (drawable != null) {
            drawable.setBounds(0, 0, i, i2);
        }
    }

    private void ensureToolbar() {
        if (this.mRefreshToolbar) {
            QMUITopBar qMUITopBar = null;
            this.mTopBar = null;
            this.mTopBarDirectChild = null;
            int i = this.mTopBarId;
            if (i != -1) {
                QMUITopBar qMUITopBar2 = (QMUITopBar) findViewById(i);
                this.mTopBar = qMUITopBar2;
                if (qMUITopBar2 != null) {
                    this.mTopBarDirectChild = findDirectChild(qMUITopBar2);
                }
            }
            if (this.mTopBar == null) {
                int childCount = getChildCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i2);
                    if (childAt instanceof QMUITopBar) {
                        qMUITopBar = (QMUITopBar) childAt;
                        break;
                    }
                    i2++;
                }
                this.mTopBar = qMUITopBar;
            }
            this.mRefreshToolbar = false;
        }
    }

    private boolean isToolbarChild(View view) {
        View view2 = this.mTopBarDirectChild;
        if (view2 == null || view2 == this) {
            if (view == this.mTopBar) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    private View findDirectChild(View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        ensureToolbar();
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        super.dispatchApplyWindowInsets(windowInsets);
        return windowInsets;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mLastInsets != null) {
            int windowInsetTop = getWindowInsetTop();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < windowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, windowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i6 = 0; i6 < childCount2; i6++) {
            getViewOffsetHelper(getChildAt(i6)).onViewLayout(false);
        }
        if (this.mCollapsingTitleEnabled) {
            View view = this.mTopBarDirectChild;
            if (view == null) {
                view = this.mTopBar;
            }
            int maxOffsetForPinChild = getMaxOffsetForPinChild(view);
            QMUIViewHelper.getDescendantRect(this, this.mTopBar, this.mTmpRect);
            Rect titleContainerRect = this.mTopBar.getTitleContainerRect();
            this.mCollapsingTextHelper.setCollapsedBounds(this.mTmpRect.left + titleContainerRect.left, this.mTmpRect.top + maxOffsetForPinChild + titleContainerRect.top, this.mTmpRect.left + titleContainerRect.right, this.mTmpRect.top + maxOffsetForPinChild + titleContainerRect.bottom);
            this.mCollapsingTextHelper.setExpandedBounds(this.mExpandedMarginStart, this.mTmpRect.top + this.mExpandedMarginTop, (i3 - i) - this.mExpandedMarginEnd, (i4 - i2) - this.mExpandedMarginBottom);
            this.mCollapsingTextHelper.recalculate();
        }
        if (this.mTopBar != null) {
            if (this.mCollapsingTitleEnabled && TextUtils.isEmpty(this.mCollapsingTextHelper.getText())) {
                this.mCollapsingTextHelper.setText(this.mTopBar.getTitle());
            }
            View view2 = this.mTopBarDirectChild;
            if (view2 == null || view2 == this) {
                setMinimumHeight(getHeightWithMargins(this.mTopBar));
            } else {
                setMinimumHeight(getHeightWithMargins(view2));
            }
        }
        updateScrimVisibility();
        int childCount3 = getChildCount();
        for (int i7 = 0; i7 < childCount3; i7++) {
            getViewOffsetHelper(getChildAt(i7)).applyOffsets();
        }
    }

    private static int getHeightWithMargins(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return view.getHeight();
    }

    static QMUIViewOffsetHelper getViewOffsetHelper(View view) {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = (QMUIViewOffsetHelper) view.getTag(R.id.qmui_view_offset_helper);
        if (qMUIViewOffsetHelper != null) {
            return qMUIViewOffsetHelper;
        }
        QMUIViewOffsetHelper qMUIViewOffsetHelper2 = new QMUIViewOffsetHelper(view);
        view.setTag(R.id.qmui_view_offset_helper, qMUIViewOffsetHelper2);
        return qMUIViewOffsetHelper2;
    }

    public void setTitle(CharSequence charSequence) {
        this.mCollapsingTextHelper.setText(charSequence);
    }

    public CharSequence getTitle() {
        if (this.mCollapsingTitleEnabled) {
            return this.mCollapsingTextHelper.getText();
        }
        return null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.mCollapsingTitleEnabled) {
            this.mCollapsingTitleEnabled = z;
            requestLayout();
        }
    }

    public boolean isTitleEnabled() {
        return this.mCollapsingTitleEnabled;
    }

    public void setScrimsShown(boolean z) {
        setScrimsShown(z, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setScrimsShown(boolean z, boolean z2) {
        if (this.mScrimsAreShown != z) {
            if (z2) {
                animateScrim(z ? 255 : 0);
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.mScrimsAreShown = z;
        }
    }

    public void setScrimUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = this.mScrimUpdateListener;
        if (animatorUpdateListener2 != animatorUpdateListener) {
            ValueAnimator valueAnimator = this.mScrimAnimator;
            if (valueAnimator == null) {
                this.mScrimUpdateListener = animatorUpdateListener;
                return;
            }
            if (animatorUpdateListener2 != null) {
                valueAnimator.removeUpdateListener(animatorUpdateListener2);
            }
            this.mScrimUpdateListener = animatorUpdateListener;
            if (animatorUpdateListener != null) {
                this.mScrimAnimator.addUpdateListener(animatorUpdateListener);
            }
        }
    }

    private void animateScrim(int i) {
        Interpolator interpolator;
        ensureToolbar();
        ValueAnimator valueAnimator = this.mScrimAnimator;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.mScrimAnimator = valueAnimator2;
            valueAnimator2.setDuration(this.mScrimAnimationDuration);
            ValueAnimator valueAnimator3 = this.mScrimAnimator;
            if (i > this.mScrimAlpha) {
                interpolator = QMUIInterpolatorStaticHolder.FAST_OUT_LINEAR_IN_INTERPOLATOR;
            } else {
                interpolator = QMUIInterpolatorStaticHolder.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
            }
            valueAnimator3.setInterpolator(interpolator);
            this.mScrimAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator4) {
                    QMUICollapsingTopBarLayout.this.setScrimAlpha(((Integer) valueAnimator4.getAnimatedValue()).intValue());
                }
            });
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.mScrimUpdateListener;
            if (animatorUpdateListener != null) {
                this.mScrimAnimator.addUpdateListener(animatorUpdateListener);
            }
        } else if (valueAnimator.isRunning()) {
            this.mScrimAnimator.cancel();
        }
        this.mScrimAnimator.setIntValues(this.mScrimAlpha, i);
        this.mScrimAnimator.start();
    }

    void setScrimAlpha(int i) {
        QMUITopBar qMUITopBar;
        if (i != this.mScrimAlpha) {
            if (this.mContentScrim != null && (qMUITopBar = this.mTopBar) != null) {
                ViewCompat.postInvalidateOnAnimation(qMUITopBar);
            }
            this.mScrimAlpha = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    int getScrimAlpha() {
        return this.mScrimAlpha;
    }

    public void setContentScrimSkinAttr(int i) {
        this.mContentScrimSkinAttr = i;
        if (i != 0) {
            setStatusBarScrimInner(QMUISkinHelper.getSkinDrawable(this, i));
        }
    }

    public void setContentScrim(Drawable drawable) {
        this.mContentScrimSkinAttr = 0;
        setContentScrimInner(drawable);
    }

    private void setContentScrimInner(Drawable drawable) {
        Drawable drawable2 = this.mContentScrim;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.mContentScrim = drawableMutate;
            if (drawableMutate != null) {
                drawableMutate.setBounds(0, 0, getWidth(), getHeight());
                this.mContentScrim.setCallback(this);
                this.mContentScrim.setAlpha(this.mScrimAlpha);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public Drawable getContentScrim() {
        return this.mContentScrim;
    }

    public void setStatusBarScrim(Drawable drawable) {
        this.mStatusBarScrimSkinAttr = 0;
        setStatusBarScrimInner(drawable);
    }

    private void setStatusBarScrimInner(Drawable drawable) {
        Drawable drawable2 = this.mStatusBarScrim;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.mStatusBarScrim = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.mStatusBarScrim.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.mStatusBarScrim, ViewCompat.getLayoutDirection(this));
                this.mStatusBarScrim.setVisible(getVisibility() == 0, false);
                this.mStatusBarScrim.setCallback(this);
                this.mStatusBarScrim.setAlpha(this.mScrimAlpha);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimSkinAttr(int i) {
        this.mStatusBarScrimSkinAttr = i;
        if (i != 0) {
            setStatusBarScrimInner(QMUISkinHelper.getSkinDrawable(this, i));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarScrim;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.mContentScrim;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        QMUICollapsingTextHelper qMUICollapsingTextHelper = this.mCollapsingTextHelper;
        if (qMUICollapsingTextHelper != null) {
            state |= qMUICollapsingTextHelper.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mContentScrim || drawable == this.mStatusBarScrim;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.mStatusBarScrim;
        if (drawable != null && drawable.isVisible() != z) {
            this.mStatusBarScrim.setVisible(z, false);
        }
        Drawable drawable2 = this.mContentScrim;
        if (drawable2 == null || drawable2.isVisible() == z) {
            return;
        }
        this.mContentScrim.setVisible(z, false);
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public Drawable getStatusBarScrim() {
        return this.mStatusBarScrim;
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.mCollapsingTextHelper.setCollapsedTextAppearance(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.mCollapsedTextColorSkinAttr = 0;
        this.mCollapsingTextHelper.setCollapsedTextColor(colorStateList);
    }

    public void setCollapsedTextColorSkinAttr(int i) {
        this.mCollapsedTextColorSkinAttr = i;
        if (i != 0) {
            this.mCollapsingTextHelper.setCollapsedTextColor(QMUISkinHelper.getSkinColorStateList(this, i));
        }
    }

    public void setCollapsedTitleGravity(int i) {
        this.mCollapsingTextHelper.setCollapsedTextGravity(i);
    }

    public int getCollapsedTitleGravity() {
        return this.mCollapsingTextHelper.getCollapsedTextGravity();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.mCollapsingTextHelper.setExpandedTextAppearance(i);
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.mExpandedTextColorSkinAttr = 0;
        this.mCollapsingTextHelper.setExpandedTextColor(colorStateList);
    }

    public void setExpandedTextColorSkinAttr(int i) {
        this.mExpandedTextColorSkinAttr = i;
        if (i != 0) {
            this.mCollapsingTextHelper.setExpandedTextColor(QMUISkinHelper.getSkinColorStateList(this, i));
        }
    }

    public void setExpandedTitleGravity(int i) {
        this.mCollapsingTextHelper.setExpandedTextGravity(i);
    }

    public int getExpandedTitleGravity() {
        return this.mCollapsingTextHelper.getExpandedTextGravity();
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.mCollapsingTextHelper.setCollapsedTypeface(typeface);
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.mCollapsingTextHelper.getCollapsedTypeface();
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.mCollapsingTextHelper.setExpandedTypeface(typeface);
    }

    public Typeface getExpandedTitleTypeface() {
        return this.mCollapsingTextHelper.getExpandedTypeface();
    }

    public void setExpandedTitleMargin(int i, int i2, int i3, int i4) {
        this.mExpandedMarginStart = i;
        this.mExpandedMarginTop = i2;
        this.mExpandedMarginEnd = i3;
        this.mExpandedMarginBottom = i4;
        requestLayout();
    }

    public int getExpandedTitleMarginStart() {
        return this.mExpandedMarginStart;
    }

    public void setExpandedTitleMarginStart(int i) {
        this.mExpandedMarginStart = i;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.mExpandedMarginTop;
    }

    public void setExpandedTitleMarginTop(int i) {
        this.mExpandedMarginTop = i;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.mExpandedMarginEnd;
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.mExpandedMarginEnd = i;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.mExpandedMarginBottom;
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.mExpandedMarginBottom = i;
        requestLayout();
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.mScrimVisibleHeightTrigger != i) {
            this.mScrimVisibleHeightTrigger = i;
            updateScrimVisibility();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        int i = this.mScrimVisibleHeightTrigger;
        if (i >= 0) {
            return i;
        }
        int windowInsetTop = getWindowInsetTop();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight > 0) {
            return Math.min((minimumHeight * 2) + windowInsetTop, getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long j) {
        this.mScrimAnimationDuration = j;
    }

    public long getScrimAnimationDuration() {
        return this.mScrimAnimationDuration;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        int mCollapseMode;
        float mParallaxMult;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mCollapseMode = 0;
            this.mParallaxMult = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUICollapsingTopBarLayout_Layout);
            this.mCollapseMode = typedArrayObtainStyledAttributes.getInt(R.styleable.QMUICollapsingTopBarLayout_Layout_qmui_layout_collapseMode, 0);
            setParallaxMultiplier(typedArrayObtainStyledAttributes.getFloat(R.styleable.QMUICollapsingTopBarLayout_Layout_qmui_layout_collapseParallaxMultiplier, 0.5f));
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mCollapseMode = 0;
            this.mParallaxMult = 0.5f;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2, i3);
            this.mCollapseMode = 0;
            this.mParallaxMult = 0.5f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mCollapseMode = 0;
            this.mParallaxMult = 0.5f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mCollapseMode = 0;
            this.mParallaxMult = 0.5f;
        }

        public LayoutParams(FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.mCollapseMode = 0;
            this.mParallaxMult = 0.5f;
        }

        public void setCollapseMode(int i) {
            this.mCollapseMode = i;
        }

        public int getCollapseMode() {
            return this.mCollapseMode;
        }

        public void setParallaxMultiplier(float f) {
            this.mParallaxMult = f;
        }

        public float getParallaxMultiplier() {
            return this.mParallaxMult;
        }
    }

    final void updateScrimVisibility() {
        if (this.mContentScrim == null && this.mStatusBarScrim == null) {
            return;
        }
        setScrimsShown(getHeight() + this.mCurrentOffset < getScrimVisibleHeightTrigger());
    }

    final int getMaxOffsetForPinChild(View view) {
        return ((getHeight() - getViewOffsetHelper(view).getLayoutTop()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    public void addOnOffsetUpdateListener(OnOffsetUpdateListener onOffsetUpdateListener) {
        this.mOnOffsetUpdateListeners.add(onOffsetUpdateListener);
    }

    public void removeOnOffsetUpdateListener(OnOffsetUpdateListener onOffsetUpdateListener) {
        this.mOnOffsetUpdateListeners.remove(onOffsetUpdateListener);
    }

    private class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        OffsetUpdateListener() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            QMUICollapsingTopBarLayout.this.mCurrentOffset = i;
            int windowInsetTop = QMUICollapsingTopBarLayout.this.getWindowInsetTop();
            int childCount = QMUICollapsingTopBarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = QMUICollapsingTopBarLayout.this.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                QMUIViewOffsetHelper viewOffsetHelper = QMUICollapsingTopBarLayout.getViewOffsetHelper(childAt);
                int i3 = layoutParams.mCollapseMode;
                if (i3 == 1) {
                    viewOffsetHelper.setTopAndBottomOffset(QMUILangHelper.constrain(-i, 0, QMUICollapsingTopBarLayout.this.getMaxOffsetForPinChild(childAt)));
                } else if (i3 == 2) {
                    viewOffsetHelper.setTopAndBottomOffset(Math.round((-i) * layoutParams.mParallaxMult));
                }
            }
            QMUICollapsingTopBarLayout.this.updateScrimVisibility();
            if (QMUICollapsingTopBarLayout.this.mStatusBarScrim != null && windowInsetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(QMUICollapsingTopBarLayout.this);
            }
            float fAbs = Math.abs(i) / ((QMUICollapsingTopBarLayout.this.getHeight() - ViewCompat.getMinimumHeight(QMUICollapsingTopBarLayout.this)) - windowInsetTop);
            QMUICollapsingTopBarLayout.this.mCollapsingTextHelper.setExpansionFraction(fAbs);
            Iterator it = QMUICollapsingTopBarLayout.this.mOnOffsetUpdateListeners.iterator();
            while (it.hasNext()) {
                ((OnOffsetUpdateListener) it.next()).onOffsetChanged(QMUICollapsingTopBarLayout.this, i, fAbs);
            }
        }
    }

    @Override // com.qmuiteam.qmui.skin.IQMUISkinDispatchInterceptor
    public boolean intercept(int i, Resources.Theme theme) {
        if (this.mContentScrimSkinAttr != 0) {
            setContentScrimInner(QMUIResHelper.getAttrDrawable(getContext(), theme, this.mContentScrimSkinAttr));
        }
        if (this.mStatusBarScrimSkinAttr != 0) {
            setStatusBarScrimInner(QMUIResHelper.getAttrDrawable(getContext(), theme, this.mStatusBarScrimSkinAttr));
        }
        int i2 = this.mCollapsedTextColorSkinAttr;
        if (i2 != 0) {
            this.mCollapsingTextHelper.setCollapsedTextColor(QMUISkinHelper.getSkinColorStateList(this, i2));
        }
        int i3 = this.mExpandedTextColorSkinAttr;
        if (i3 == 0) {
            return false;
        }
        this.mCollapsingTextHelper.setExpandedTextColor(QMUISkinHelper.getSkinColorStateList(this, i3));
        return false;
    }
}
