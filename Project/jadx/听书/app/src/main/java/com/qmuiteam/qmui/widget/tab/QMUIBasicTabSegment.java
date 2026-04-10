package com.qmuiteam.qmui.widget.tab;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.collection.SimpleArrayMap;
import com.qmuiteam.qmui.QMUIInterpolatorStaticHolder;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.IQMUILayout;
import com.qmuiteam.qmui.layout.QMUILayoutHelper;
import com.qmuiteam.qmui.skin.IQMUISkinHandlerView;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider;
import com.qmuiteam.qmui.util.QMUIColorHelper;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIBasicTabSegment extends HorizontalScrollView implements IQMUILayout, IQMUISkinHandlerView, IQMUISkinDefaultAttrProvider {
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    public static final int NO_POSITION = -1;
    private static final String TAG = "QMUIBasicTabSegment";
    private static SimpleArrayMap<String, Integer> sDefaultSkinAttrs;
    private Container mContentLayout;
    protected int mCurrentSelectedIndex;
    private boolean mHideIndicatorWhenTabCountLessTwo;
    private QMUITabIndicator mIndicator;
    private boolean mIsInSelectTab;
    private int mItemSpaceInScrollMode;
    private QMUILayoutHelper mLayoutHelper;
    private int mMode;
    private OnTabClickListener mOnTabClickListener;
    protected int mPendingSelectedIndex;
    protected Animator mSelectAnimator;
    private boolean mSelectNoAnimation;
    private final ArrayList<OnTabSelectedListener> mSelectedListeners;
    private QMUITabAdapter mTabAdapter;
    protected QMUITabBuilder mTabBuilder;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public interface OnTabClickListener {
        boolean onTabClick(QMUITabView qMUITabView, int i);
    }

    public interface OnTabSelectedListener {
        void onDoubleTap(int i);

        void onTabReselected(int i);

        void onTabSelected(int i);

        void onTabUnselected(int i);
    }

    public interface TabBuilderUpdater {
        void update(QMUITabBuilder qMUITabBuilder);
    }

    protected boolean needPreventEvent() {
        return false;
    }

    static {
        SimpleArrayMap<String, Integer> simpleArrayMap = new SimpleArrayMap<>(3);
        sDefaultSkinAttrs = simpleArrayMap;
        simpleArrayMap.put(QMUISkinValueBuilder.BOTTOM_SEPARATOR, Integer.valueOf(R.attr.qmui_skin_support_tab_separator_color));
        sDefaultSkinAttrs.put(QMUISkinValueBuilder.TOP_SEPARATOR, Integer.valueOf(R.attr.qmui_skin_support_tab_separator_color));
        sDefaultSkinAttrs.put(QMUISkinValueBuilder.BACKGROUND, Integer.valueOf(R.attr.qmui_skin_support_tab_bg));
    }

    public QMUIBasicTabSegment(Context context) {
        this(context, null);
    }

    public QMUIBasicTabSegment(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUITabSegmentStyle);
    }

    public QMUIBasicTabSegment(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSelectedListeners = new ArrayList<>();
        this.mCurrentSelectedIndex = -1;
        this.mPendingSelectedIndex = -1;
        this.mIndicator = null;
        this.mHideIndicatorWhenTabCountLessTwo = true;
        this.mMode = 1;
        this.mIsInSelectTab = false;
        setWillNotDraw(false);
        this.mLayoutHelper = new QMUILayoutHelper(context, attributeSet, i, this);
        init(context, attributeSet, i);
        setHorizontalScrollBarEnabled(false);
        setClipToPadding(false);
        setClipChildren(false);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUITabSegment, i, 0);
        this.mIndicator = createTabIndicatorFromXmlInfo(typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUITabSegment_qmui_tab_has_indicator, false), typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITabSegment_qmui_tab_indicator_height, getResources().getDimensionPixelSize(R.dimen.qmui_tab_segment_indicator_height)), typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUITabSegment_qmui_tab_indicator_top, false), typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUITabSegment_qmui_tab_indicator_with_follow_content, false));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITabSegment_qmui_tab_normal_text_size, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITabSegment_android_textSize, getResources().getDimensionPixelSize(R.dimen.qmui_tab_segment_text_size)));
        this.mTabBuilder = new QMUITabBuilder(context).setTextSize(dimensionPixelSize, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITabSegment_qmui_tab_selected_text_size, dimensionPixelSize)).setIconPosition(typedArrayObtainStyledAttributes.getInt(R.styleable.QMUITabSegment_qmui_tab_icon_position, 0));
        this.mMode = typedArrayObtainStyledAttributes.getInt(R.styleable.QMUITabSegment_qmui_tab_mode, 1);
        this.mItemSpaceInScrollMode = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITabSegment_qmui_tab_space, QMUIDisplayHelper.dp2px(context, 10));
        this.mSelectNoAnimation = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUITabSegment_qmui_tab_select_no_animation, false);
        typedArrayObtainStyledAttributes.recycle();
        Container container = new Container(context);
        this.mContentLayout = container;
        addView(container, new FrameLayout.LayoutParams(-2, -1));
        this.mTabAdapter = createTabAdapter(this.mContentLayout);
    }

    public void setDefaultTextSize(int i, int i2) {
        this.mTabBuilder.setTextSize(i, i2);
    }

    public void setDefaultTabIconPosition(int i) {
        this.mTabBuilder.setIconPosition(i);
    }

    public void updateParentTabBuilder(TabBuilderUpdater tabBuilderUpdater) {
        tabBuilderUpdater.update(this.mTabBuilder);
    }

    protected QMUITabAdapter createTabAdapter(ViewGroup viewGroup) {
        return new QMUITabAdapter(this, viewGroup);
    }

    protected QMUITabIndicator createTabIndicatorFromXmlInfo(boolean z, int i, boolean z2, boolean z3) {
        if (z) {
            return new QMUITabIndicator(i, z2, z3);
        }
        return null;
    }

    public QMUITabBuilder tabBuilder() {
        return new QMUITabBuilder(this.mTabBuilder);
    }

    public void setIndicator(QMUITabIndicator qMUITabIndicator) {
        this.mIndicator = qMUITabIndicator;
        this.mContentLayout.requestLayout();
    }

    public void setHideIndicatorWhenTabCountLessTwo(boolean z) {
        this.mHideIndicatorWhenTabCountLessTwo = z;
    }

    public void setItemSpaceInScrollMode(int i) {
        this.mItemSpaceInScrollMode = i;
    }

    public void reset() {
        this.mTabAdapter.clear();
        this.mCurrentSelectedIndex = -1;
        Animator animator = this.mSelectAnimator;
        if (animator != null) {
            animator.cancel();
            this.mSelectAnimator = null;
        }
    }

    public void resetSelect() {
        this.mCurrentSelectedIndex = -1;
        Animator animator = this.mSelectAnimator;
        if (animator != null) {
            animator.cancel();
            this.mSelectAnimator = null;
        }
    }

    public QMUIBasicTabSegment addTab(QMUITab qMUITab) {
        this.mTabAdapter.addItem(qMUITab);
        return this;
    }

    public void notifyDataChanged() {
        int i = this.mCurrentSelectedIndex;
        resetSelect();
        this.mTabAdapter.setup();
        selectTab(i);
    }

    public void addOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        if (this.mSelectedListeners.contains(onTabSelectedListener)) {
            return;
        }
        this.mSelectedListeners.add(onTabSelectedListener);
    }

    public void removeOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.mSelectedListeners.remove(onTabSelectedListener);
    }

    public void clearOnTabSelectedListeners() {
        this.mSelectedListeners.clear();
    }

    public int getMode() {
        return this.mMode;
    }

    public void setMode(int i) {
        if (this.mMode != i) {
            this.mMode = i;
            if (i == 0) {
                this.mTabBuilder.setGravity(3);
            }
            this.mContentLayout.invalidate();
        }
    }

    protected void onClickTab(QMUITabView qMUITabView, int i) {
        if (this.mSelectAnimator != null || needPreventEvent()) {
            return;
        }
        OnTabClickListener onTabClickListener = this.mOnTabClickListener;
        if ((onTabClickListener == null || !onTabClickListener.onTabClick(qMUITabView, i)) && this.mTabAdapter.getItem(i) != null) {
            selectTab(i, this.mSelectNoAnimation, true);
        }
    }

    void onDoubleClick(int i) {
        if (this.mSelectedListeners.isEmpty() || this.mTabAdapter.getItem(i) == null) {
            return;
        }
        dispatchTabDoubleTap(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchTabSelected(int i) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).onTabSelected(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchTabUnselected(int i) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).onTabUnselected(i);
        }
    }

    private void dispatchTabReselected(int i) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).onTabReselected(i);
        }
    }

    private void dispatchTabDoubleTap(int i) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).onDoubleTap(i);
        }
    }

    public void setSelectNoAnimation(boolean z) {
        this.mSelectNoAnimation = z;
    }

    public void selectTab(int i) {
        selectTab(i, this.mSelectNoAnimation, false);
    }

    public void selectTab(final int i, boolean z, boolean z2) {
        if (this.mIsInSelectTab) {
            return;
        }
        this.mIsInSelectTab = true;
        List<QMUITabView> views = this.mTabAdapter.getViews();
        if (views.size() != this.mTabAdapter.getSize()) {
            this.mTabAdapter.setup();
            views = this.mTabAdapter.getViews();
        }
        if (views.size() == 0 || views.size() <= i) {
            this.mIsInSelectTab = false;
            return;
        }
        if (this.mSelectAnimator != null || needPreventEvent()) {
            this.mPendingSelectedIndex = i;
            this.mIsInSelectTab = false;
            return;
        }
        int i2 = this.mCurrentSelectedIndex;
        if (i2 == i) {
            if (z2) {
                dispatchTabReselected(i);
            }
            this.mIsInSelectTab = false;
            this.mContentLayout.invalidate();
            return;
        }
        if (i2 > views.size()) {
            Log.i(TAG, "selectTab: current selected index is bigger than views size.");
            this.mCurrentSelectedIndex = -1;
        }
        final int i3 = this.mCurrentSelectedIndex;
        if (i3 == -1) {
            layoutIndicator(this.mTabAdapter.getItem(i), true);
            QMUITabView qMUITabView = views.get(i);
            qMUITabView.setSelected(true);
            qMUITabView.setSelectFraction(1.0f);
            dispatchTabSelected(i);
            this.mCurrentSelectedIndex = i;
            this.mIsInSelectTab = false;
            return;
        }
        final QMUITab item = this.mTabAdapter.getItem(i3);
        final QMUITabView qMUITabView2 = views.get(i3);
        final QMUITab item2 = this.mTabAdapter.getItem(i);
        final QMUITabView qMUITabView3 = views.get(i);
        if (z) {
            dispatchTabUnselected(i3);
            dispatchTabSelected(i);
            qMUITabView2.setSelectFraction(0.0f);
            qMUITabView2.setSelected(false);
            qMUITabView3.setSelectFraction(1.0f);
            qMUITabView3.setSelected(true);
            if (this.mMode == 0) {
                int scrollX = getScrollX();
                int width = getWidth();
                int width2 = this.mContentLayout.getWidth();
                int left = qMUITabView3.getLeft();
                int width3 = qMUITabView3.getWidth();
                int paddingLeft = getPaddingLeft() + getPaddingRight();
                int size = this.mTabAdapter.getSize();
                int i4 = (width2 - width) + paddingLeft;
                if (i > i3) {
                    if (i >= size - 2) {
                        smoothScrollBy(i4 - scrollX, 0);
                    } else {
                        int width4 = views.get(i + 1).getWidth();
                        int iMin = Math.min(i4, left - ((((width - (getPaddingRight() * 2)) - width4) - width3) - this.mItemSpaceInScrollMode)) - (width4 - width3);
                        if (scrollX < iMin) {
                            smoothScrollBy(iMin - scrollX, 0);
                        }
                    }
                } else if (i <= 1) {
                    smoothScrollBy(-scrollX, 0);
                } else {
                    int iMax = Math.max(0, (left - views.get(i - 1).getWidth()) - this.mItemSpaceInScrollMode);
                    if (iMax < scrollX) {
                        smoothScrollBy(iMax - scrollX, 0);
                    }
                }
            }
            this.mCurrentSelectedIndex = i;
            this.mIsInSelectTab = false;
            layoutIndicator(item2, true);
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(QMUIInterpolatorStaticHolder.LINEAR_INTERPOLATOR);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                qMUITabView2.setSelectFraction(1.0f - fFloatValue);
                qMUITabView3.setSelectFraction(fFloatValue);
                QMUIBasicTabSegment.this.layoutIndicatorInTransition(item, item2, fFloatValue);
            }
        });
        valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                QMUIBasicTabSegment.this.mSelectAnimator = animator;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                qMUITabView2.setSelectFraction(0.0f);
                qMUITabView2.setSelected(false);
                qMUITabView3.setSelectFraction(1.0f);
                qMUITabView3.setSelected(true);
                QMUIBasicTabSegment.this.mSelectAnimator = null;
                QMUIBasicTabSegment.this.mCurrentSelectedIndex = i;
                QMUIBasicTabSegment.this.dispatchTabSelected(i);
                QMUIBasicTabSegment.this.dispatchTabUnselected(i3);
                if (QMUIBasicTabSegment.this.mPendingSelectedIndex == -1 || QMUIBasicTabSegment.this.needPreventEvent()) {
                    return;
                }
                QMUIBasicTabSegment qMUIBasicTabSegment = QMUIBasicTabSegment.this;
                qMUIBasicTabSegment.selectTab(qMUIBasicTabSegment.mPendingSelectedIndex, true, false);
                QMUIBasicTabSegment.this.mPendingSelectedIndex = -1;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                QMUIBasicTabSegment.this.mSelectAnimator = null;
                qMUITabView2.setSelectFraction(1.0f);
                qMUITabView2.setSelected(true);
                qMUITabView3.setSelectFraction(0.0f);
                qMUITabView3.setSelected(false);
                QMUIBasicTabSegment.this.layoutIndicator(item, true);
            }
        });
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.start();
        this.mIsInSelectTab = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void layoutIndicator(QMUITab qMUITab, boolean z) {
        QMUITabIndicator qMUITabIndicator;
        if (qMUITab == null || (qMUITabIndicator = this.mIndicator) == null) {
            return;
        }
        qMUITabIndicator.updateInfo(qMUITab.contentLeft, qMUITab.contentWidth, qMUITab.selectedColorAttr == 0 ? qMUITab.selectColor : QMUISkinHelper.getSkinColor(this, qMUITab.selectedColorAttr), 0.0f);
        if (z) {
            this.mContentLayout.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void layoutIndicatorInTransition(QMUITab qMUITab, QMUITab qMUITab2, float f) {
        if (this.mIndicator == null) {
            return;
        }
        this.mIndicator.updateInfo((int) (qMUITab.contentLeft + ((qMUITab2.contentLeft - qMUITab.contentLeft) * f)), (int) (qMUITab.contentWidth + ((qMUITab2.contentWidth - qMUITab.contentWidth) * f)), QMUIColorHelper.computeColor(qMUITab.selectedColorAttr == 0 ? qMUITab.selectColor : QMUISkinHelper.getSkinColor(this, qMUITab.selectedColorAttr), qMUITab2.selectedColorAttr == 0 ? qMUITab2.selectColor : QMUISkinHelper.getSkinColor(this, qMUITab2.selectedColorAttr), f), f);
        this.mContentLayout.invalidate();
    }

    public void updateIndicatorPosition(int i, float f) {
        int i2;
        if (this.mSelectAnimator != null || this.mIsInSelectTab || f == 0.0f) {
            return;
        }
        if (f < 0.0f) {
            i2 = i - 1;
            f = -f;
        } else {
            i2 = i + 1;
        }
        List<QMUITabView> views = this.mTabAdapter.getViews();
        if (views.size() <= i || views.size() <= i2) {
            return;
        }
        QMUITab item = this.mTabAdapter.getItem(i);
        QMUITab item2 = this.mTabAdapter.getItem(i2);
        QMUITabView qMUITabView = views.get(i);
        QMUITabView qMUITabView2 = views.get(i2);
        qMUITabView.setSelectFraction(1.0f - f);
        qMUITabView2.setSelectFraction(f);
        layoutIndicatorInTransition(item, item2, f);
    }

    public void updateTabText(int i, String str) {
        QMUITab item = this.mTabAdapter.getItem(i);
        if (item == null) {
            return;
        }
        item.setText(str);
        notifyDataChanged();
    }

    public void replaceTab(int i, QMUITab qMUITab) {
        try {
            if (this.mCurrentSelectedIndex == i) {
                this.mCurrentSelectedIndex = -1;
            }
            this.mTabAdapter.replaceItem(i, qMUITab);
            notifyDataChanged();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.mOnTabClickListener = onTabClickListener;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            childAt.measure(View.MeasureSpec.makeMeasureSpec(size - paddingLeft, 1073741824), i2);
            if (mode == Integer.MIN_VALUE) {
                setMeasuredDimension(Math.min(size, childAt.getMeasuredWidth() + paddingLeft), i2);
                return;
            }
        }
        setMeasuredDimension(i, i2);
    }

    public int getSelectedIndex() {
        return this.mCurrentSelectedIndex;
    }

    public int getTabCount() {
        return this.mTabAdapter.getSize();
    }

    public QMUITab getTab(int i) {
        return this.mTabAdapter.getItem(i);
    }

    public void showSignCountView(Context context, int i, int i2) {
        this.mTabAdapter.getItem(i).setSignCount(i2);
        notifyDataChanged();
    }

    public void clearSignCountView(int i) {
        this.mTabAdapter.getItem(i).clearSignCountOrRedPoint();
        notifyDataChanged();
    }

    public int getSignCount(int i) {
        return this.mTabAdapter.getItem(i).getSignCount();
    }

    public boolean isRedPointShowing(int i) {
        return this.mTabAdapter.getItem(i).isRedPointShowing();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mCurrentSelectedIndex == -1 || this.mMode != 0) {
            return;
        }
        QMUITabView qMUITabView = this.mTabAdapter.getViews().get(this.mCurrentSelectedIndex);
        if (getScrollX() > qMUITabView.getLeft()) {
            scrollTo(qMUITabView.getLeft(), 0);
            return;
        }
        int width = (getWidth() - getPaddingRight()) - getPaddingLeft();
        if (getScrollX() + width < qMUITabView.getRight()) {
            scrollBy((qMUITabView.getRight() - width) - getScrollX(), 0);
        }
    }

    private final class Container extends ViewGroup {
        public Container(Context context) {
            super(context);
            setClipChildren(false);
            setWillNotDraw(false);
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            List<QMUITabView> views = QMUIBasicTabSegment.this.mTabAdapter.getViews();
            int size3 = views.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size3; i4++) {
                if (views.get(i4).getVisibility() == 0) {
                    i3++;
                }
            }
            if (size3 == 0 || i3 == 0) {
                setMeasuredDimension(size, size2);
                return;
            }
            int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            if (QMUIBasicTabSegment.this.mMode != 1) {
                int measuredWidth = 0;
                float f = 0.0f;
                for (int i5 = 0; i5 < size3; i5++) {
                    QMUITabView qMUITabView = views.get(i5);
                    if (qMUITabView.getVisibility() == 0) {
                        qMUITabView.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824));
                        measuredWidth += qMUITabView.getMeasuredWidth() + QMUIBasicTabSegment.this.mItemSpaceInScrollMode;
                        QMUITab item = QMUIBasicTabSegment.this.mTabAdapter.getItem(i5);
                        f += item.leftSpaceWeight + item.rightSpaceWeight;
                        item.leftAddonMargin = 0;
                        item.rightAddonMargin = 0;
                    }
                }
                int i6 = measuredWidth - QMUIBasicTabSegment.this.mItemSpaceInScrollMode;
                if (f <= 0.0f || i6 >= size) {
                    size = i6;
                } else {
                    int i7 = size - i6;
                    for (int i8 = 0; i8 < size3; i8++) {
                        if (views.get(i8).getVisibility() == 0) {
                            QMUITab item2 = QMUIBasicTabSegment.this.mTabAdapter.getItem(i8);
                            float f2 = i7;
                            item2.leftAddonMargin = (int) ((item2.leftSpaceWeight * f2) / f);
                            item2.rightAddonMargin = (int) ((f2 * item2.rightSpaceWeight) / f);
                        }
                    }
                }
            } else {
                int i9 = size / i3;
                for (int i10 = 0; i10 < size3; i10++) {
                    QMUITabView qMUITabView2 = views.get(i10);
                    if (qMUITabView2.getVisibility() == 0) {
                        qMUITabView2.measure(View.MeasureSpec.makeMeasureSpec(i9, 1073741824), View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824));
                        QMUITab item3 = QMUIBasicTabSegment.this.mTabAdapter.getItem(i10);
                        item3.leftAddonMargin = 0;
                        item3.rightAddonMargin = 0;
                    }
                }
            }
            setMeasuredDimension(size, size2);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            List<QMUITabView> views = QMUIBasicTabSegment.this.mTabAdapter.getViews();
            int size = views.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                if (views.get(i6).getVisibility() == 0) {
                    i5++;
                }
            }
            if (size == 0 || i5 == 0) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            for (int i7 = 0; i7 < size; i7++) {
                QMUITabView qMUITabView = views.get(i7);
                if (qMUITabView.getVisibility() == 0) {
                    int measuredWidth = qMUITabView.getMeasuredWidth();
                    QMUITab item = QMUIBasicTabSegment.this.mTabAdapter.getItem(i7);
                    int contentViewLeft = paddingLeft + item.leftAddonMargin;
                    int i8 = contentViewLeft + measuredWidth;
                    qMUITabView.layout(contentViewLeft, getPaddingTop(), i8, (i4 - i2) - getPaddingBottom());
                    int i9 = item.contentLeft;
                    int i10 = item.contentWidth;
                    if (QMUIBasicTabSegment.this.mMode == 1 && QMUIBasicTabSegment.this.mIndicator != null && QMUIBasicTabSegment.this.mIndicator.isIndicatorWidthFollowContent()) {
                        contentViewLeft += qMUITabView.getContentViewLeft();
                        measuredWidth = qMUITabView.getContentViewWidth();
                    }
                    if (i9 != contentViewLeft || i10 != measuredWidth) {
                        item.contentLeft = contentViewLeft;
                        item.contentWidth = measuredWidth;
                    }
                    paddingLeft = i8 + item.rightAddonMargin + (QMUIBasicTabSegment.this.mMode == 0 ? QMUIBasicTabSegment.this.mItemSpaceInScrollMode : 0);
                }
            }
            if (QMUIBasicTabSegment.this.mCurrentSelectedIndex == -1 || QMUIBasicTabSegment.this.mSelectAnimator != null || QMUIBasicTabSegment.this.needPreventEvent()) {
                return;
            }
            QMUIBasicTabSegment qMUIBasicTabSegment = QMUIBasicTabSegment.this;
            qMUIBasicTabSegment.layoutIndicator(qMUIBasicTabSegment.mTabAdapter.getItem(QMUIBasicTabSegment.this.mCurrentSelectedIndex), false);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (QMUIBasicTabSegment.this.mIndicator != null) {
                if (!QMUIBasicTabSegment.this.mHideIndicatorWhenTabCountLessTwo || QMUIBasicTabSegment.this.mTabAdapter.getSize() > 1) {
                    QMUIBasicTabSegment.this.mIndicator.draw(this, canvas, getPaddingTop(), getHeight() - getPaddingBottom());
                }
            }
        }
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void updateTopDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.updateTopDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void updateBottomDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.updateBottomDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void updateLeftDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.updateLeftDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void updateRightDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.updateRightDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void onlyShowTopDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.onlyShowTopDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void onlyShowBottomDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.onlyShowBottomDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void onlyShowLeftDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.onlyShowLeftDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void onlyShowRightDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.onlyShowRightDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setTopDividerAlpha(int i) {
        this.mLayoutHelper.setTopDividerAlpha(i);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setBottomDividerAlpha(int i) {
        this.mLayoutHelper.setBottomDividerAlpha(i);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setLeftDividerAlpha(int i) {
        this.mLayoutHelper.setLeftDividerAlpha(i);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setRightDividerAlpha(int i) {
        this.mLayoutHelper.setRightDividerAlpha(i);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setRadiusAndShadow(int i, int i2, float f) {
        this.mLayoutHelper.setRadiusAndShadow(i, i2, f);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setRadiusAndShadow(int i, int i2, int i3, float f) {
        this.mLayoutHelper.setRadiusAndShadow(i, i2, i3, f);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setRadiusAndShadow(int i, int i2, int i3, int i4, float f) {
        this.mLayoutHelper.setRadiusAndShadow(i, i2, i3, i4, f);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setRadius(int i) {
        this.mLayoutHelper.setRadius(i);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setRadius(int i, int i2) {
        this.mLayoutHelper.setRadius(i, i2);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public int getRadius() {
        return this.mLayoutHelper.getRadius();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setOutlineInset(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.setOutlineInset(i, i2, i3, i4);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setHideRadiusSide(int i) {
        this.mLayoutHelper.setHideRadiusSide(i);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public int getHideRadiusSide() {
        return this.mLayoutHelper.getHideRadiusSide();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setBorderColor(int i) {
        this.mLayoutHelper.setBorderColor(i);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setBorderWidth(int i) {
        this.mLayoutHelper.setBorderWidth(i);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setShowBorderOnlyBeforeL(boolean z) {
        this.mLayoutHelper.setShowBorderOnlyBeforeL(z);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public boolean setWidthLimit(int i) {
        if (!this.mLayoutHelper.setWidthLimit(i)) {
            return true;
        }
        requestLayout();
        invalidate();
        return true;
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public boolean setHeightLimit(int i) {
        if (!this.mLayoutHelper.setHeightLimit(i)) {
            return true;
        }
        requestLayout();
        invalidate();
        return true;
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setUseThemeGeneralShadowElevation() {
        this.mLayoutHelper.setUseThemeGeneralShadowElevation();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setOutlineExcludePadding(boolean z) {
        this.mLayoutHelper.setOutlineExcludePadding(z);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setShadowElevation(int i) {
        this.mLayoutHelper.setShadowElevation(i);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public int getShadowElevation() {
        return this.mLayoutHelper.getShadowElevation();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setShadowAlpha(float f) {
        this.mLayoutHelper.setShadowAlpha(f);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public float getShadowAlpha() {
        return this.mLayoutHelper.getShadowAlpha();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setShadowColor(int i) {
        this.mLayoutHelper.setShadowColor(i);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public int getShadowColor() {
        return this.mLayoutHelper.getShadowColor();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setOuterNormalColor(int i) {
        this.mLayoutHelper.setOuterNormalColor(i);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void updateBottomSeparatorColor(int i) {
        this.mLayoutHelper.updateBottomSeparatorColor(i);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void updateLeftSeparatorColor(int i) {
        this.mLayoutHelper.updateLeftSeparatorColor(i);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void updateRightSeparatorColor(int i) {
        this.mLayoutHelper.updateRightSeparatorColor(i);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void updateTopSeparatorColor(int i) {
        this.mLayoutHelper.updateTopSeparatorColor(i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mLayoutHelper.drawDividers(canvas, getWidth(), getHeight());
        this.mLayoutHelper.dispatchRoundBorderDraw(canvas);
        super.onDraw(canvas);
    }

    @Override // com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
    public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
        return sDefaultSkinAttrs;
    }

    @Override // com.qmuiteam.qmui.skin.IQMUISkinHandlerView
    public void handle(QMUISkinManager qMUISkinManager, int i, Resources.Theme theme, SimpleArrayMap<String, Integer> simpleArrayMap) {
        qMUISkinManager.defaultHandleSkinAttrs(this, theme, simpleArrayMap);
        QMUITabIndicator qMUITabIndicator = this.mIndicator;
        if (qMUITabIndicator != null) {
            qMUITabIndicator.handleSkinChange(qMUISkinManager, i, theme, this.mTabAdapter.getItem(this.mCurrentSelectedIndex));
            this.mContentLayout.invalidate();
        }
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public boolean hasBorder() {
        return this.mLayoutHelper.hasBorder();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public boolean hasLeftSeparator() {
        return this.mLayoutHelper.hasLeftSeparator();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public boolean hasTopSeparator() {
        return this.mLayoutHelper.hasTopSeparator();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public boolean hasRightSeparator() {
        return this.mLayoutHelper.hasRightSeparator();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public boolean hasBottomSeparator() {
        return this.mLayoutHelper.hasBottomSeparator();
    }
}
