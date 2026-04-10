package com.qmuiteam.qmui.widget.tab;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager2.widget.ViewPager2;
import com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class QMUITabSegment2 extends QMUIBasicTabSegment {
    private static final String TAG = "QMUITabSegment";
    private ViewPager2.OnPageChangeCallback mOnPageChangeListener;
    private ViewPager2 mViewPager;
    private int mViewPagerScrollState;
    private QMUIBasicTabSegment.OnTabSelectedListener mViewPagerSelectedListener;

    public QMUITabSegment2(Context context) {
        super(context);
        this.mViewPagerScrollState = 0;
    }

    public QMUITabSegment2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mViewPagerScrollState = 0;
    }

    public QMUITabSegment2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mViewPagerScrollState = 0;
    }

    @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment
    protected boolean needPreventEvent() {
        return this.mViewPagerScrollState != 0;
    }

    public void setupWithViewPager(ViewPager2 viewPager2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback;
        ViewPager2 viewPager22 = this.mViewPager;
        if (viewPager22 != null && (onPageChangeCallback = this.mOnPageChangeListener) != null) {
            viewPager22.unregisterOnPageChangeCallback(onPageChangeCallback);
        }
        QMUIBasicTabSegment.OnTabSelectedListener onTabSelectedListener = this.mViewPagerSelectedListener;
        if (onTabSelectedListener != null) {
            removeOnTabSelectedListener(onTabSelectedListener);
            this.mViewPagerSelectedListener = null;
        }
        if (viewPager2 != null) {
            this.mViewPager = viewPager2;
            if (this.mOnPageChangeListener == null) {
                this.mOnPageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            viewPager2.registerOnPageChangeCallback(this.mOnPageChangeListener);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(viewPager2);
            this.mViewPagerSelectedListener = viewPagerOnTabSelectedListener;
            addOnTabSelectedListener(viewPagerOnTabSelectedListener);
            selectTab(this.mViewPager.getCurrentItem(), true, false);
            return;
        }
        this.mViewPager = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewPagerScrollState(int i) {
        this.mViewPagerScrollState = i;
        if (i == 0 && this.mPendingSelectedIndex != -1 && this.mSelectAnimator == null) {
            selectTab(this.mPendingSelectedIndex, true, false);
            this.mPendingSelectedIndex = -1;
        }
    }

    public static class TabLayoutOnPageChangeListener extends ViewPager2.OnPageChangeCallback {
        private final WeakReference<QMUITabSegment2> mTabSegmentRef;

        public TabLayoutOnPageChangeListener(QMUITabSegment2 qMUITabSegment2) {
            this.mTabSegmentRef = new WeakReference<>(qMUITabSegment2);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            QMUITabSegment2 qMUITabSegment2 = this.mTabSegmentRef.get();
            if (qMUITabSegment2 != null) {
                qMUITabSegment2.setViewPagerScrollState(i);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i, float f, int i2) {
            QMUITabSegment2 qMUITabSegment2 = this.mTabSegmentRef.get();
            if (qMUITabSegment2 != null) {
                qMUITabSegment2.updateIndicatorPosition(i, f);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            QMUITabSegment2 qMUITabSegment2 = this.mTabSegmentRef.get();
            if (qMUITabSegment2 != null && qMUITabSegment2.mPendingSelectedIndex != -1) {
                qMUITabSegment2.mPendingSelectedIndex = i;
            } else {
                if (qMUITabSegment2 == null || qMUITabSegment2.getSelectedIndex() == i || i >= qMUITabSegment2.getTabCount()) {
                    return;
                }
                qMUITabSegment2.selectTab(i, true, false);
            }
        }
    }

    private static class ViewPagerOnTabSelectedListener implements QMUIBasicTabSegment.OnTabSelectedListener {
        private final ViewPager2 mViewPager;

        @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
        public void onDoubleTap(int i) {
        }

        @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
        public void onTabReselected(int i) {
        }

        @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
        public void onTabUnselected(int i) {
        }

        public ViewPagerOnTabSelectedListener(ViewPager2 viewPager2) {
            this.mViewPager = viewPager2;
        }

        @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
        public void onTabSelected(int i) {
            this.mViewPager.setCurrentItem(i, false);
        }
    }
}
