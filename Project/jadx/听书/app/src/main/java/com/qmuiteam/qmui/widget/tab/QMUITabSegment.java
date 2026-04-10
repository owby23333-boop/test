package com.qmuiteam.qmui.widget.tab;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class QMUITabSegment extends QMUIBasicTabSegment {
    private static final String TAG = "QMUITabSegment";
    private AdapterChangeListener mAdapterChangeListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private PagerAdapter mPagerAdapter;
    private DataSetObserver mPagerAdapterObserver;
    private ViewPager mViewPager;
    private int mViewPagerScrollState;
    private OnTabSelectedListener mViewPagerSelectedListener;

    @Deprecated
    public interface OnTabClickListener extends QMUIBasicTabSegment.OnTabClickListener {
    }

    @Deprecated
    public interface OnTabSelectedListener extends QMUIBasicTabSegment.OnTabSelectedListener {
    }

    public QMUITabSegment(Context context) {
        super(context);
        this.mViewPagerScrollState = 0;
    }

    public QMUITabSegment(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mViewPagerScrollState = 0;
    }

    public QMUITabSegment(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mViewPagerScrollState = 0;
    }

    @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment
    protected boolean needPreventEvent() {
        return this.mViewPagerScrollState != 0;
    }

    @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment
    public void notifyDataChanged() {
        super.notifyDataChanged();
        populateFromPagerAdapter(false);
    }

    public void setupWithViewPager(ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    public void setupWithViewPager(ViewPager viewPager, boolean z) {
        setupWithViewPager(viewPager, z, true);
    }

    public void setupWithViewPager(ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 != null) {
            ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
            if (onPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(onPageChangeListener);
            }
            AdapterChangeListener adapterChangeListener = this.mAdapterChangeListener;
            if (adapterChangeListener != null) {
                this.mViewPager.removeOnAdapterChangeListener(adapterChangeListener);
            }
        }
        QMUIBasicTabSegment.OnTabSelectedListener onTabSelectedListener = this.mViewPagerSelectedListener;
        if (onTabSelectedListener != null) {
            removeOnTabSelectedListener(onTabSelectedListener);
            this.mViewPagerSelectedListener = null;
        }
        if (viewPager != null) {
            this.mViewPager = viewPager;
            if (this.mOnPageChangeListener == null) {
                this.mOnPageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            viewPager.addOnPageChangeListener(this.mOnPageChangeListener);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(viewPager);
            this.mViewPagerSelectedListener = viewPagerOnTabSelectedListener;
            addOnTabSelectedListener(viewPagerOnTabSelectedListener);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z, z2);
            }
            if (this.mAdapterChangeListener == null) {
                this.mAdapterChangeListener = new AdapterChangeListener(z);
            }
            this.mAdapterChangeListener.setAutoRefresh(z2);
            viewPager.addOnAdapterChangeListener(this.mAdapterChangeListener);
            return;
        }
        this.mViewPager = null;
        setPagerAdapter(null, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewPagerScrollState(int i) {
        this.mViewPagerScrollState = i;
        if (i == 0 && this.mPendingSelectedIndex != -1 && this.mSelectAnimator == null) {
            selectTab(this.mPendingSelectedIndex, true, false);
            this.mPendingSelectedIndex = -1;
        }
    }

    void populateFromPagerAdapter(boolean z) {
        PagerAdapter pagerAdapter = this.mPagerAdapter;
        if (pagerAdapter == null) {
            if (z) {
                reset();
                return;
            }
            return;
        }
        int count = pagerAdapter.getCount();
        if (z) {
            reset();
            for (int i = 0; i < count; i++) {
                addTab(this.mTabBuilder.setText(this.mPagerAdapter.getPageTitle(i)).build(getContext()));
            }
            super.notifyDataChanged();
        }
        ViewPager viewPager = this.mViewPager;
        if (viewPager == null || count <= 0) {
            return;
        }
        selectTab(viewPager.getCurrentItem(), true, false);
    }

    void setPagerAdapter(PagerAdapter pagerAdapter, boolean z, boolean z2) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.mPagerAdapter;
        if (pagerAdapter2 != null && (dataSetObserver = this.mPagerAdapterObserver) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.mPagerAdapter = pagerAdapter;
        if (z2 && pagerAdapter != null) {
            if (this.mPagerAdapterObserver == null) {
                this.mPagerAdapterObserver = new PagerAdapterObserver(z);
            }
            pagerAdapter.registerDataSetObserver(this.mPagerAdapterObserver);
        }
        populateFromPagerAdapter(z);
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private final WeakReference<QMUITabSegment> mTabSegmentRef;

        public TabLayoutOnPageChangeListener(QMUITabSegment qMUITabSegment) {
            this.mTabSegmentRef = new WeakReference<>(qMUITabSegment);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            QMUITabSegment qMUITabSegment = this.mTabSegmentRef.get();
            if (qMUITabSegment != null) {
                qMUITabSegment.setViewPagerScrollState(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            QMUITabSegment qMUITabSegment = this.mTabSegmentRef.get();
            if (qMUITabSegment != null) {
                qMUITabSegment.updateIndicatorPosition(i, f);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            QMUITabSegment qMUITabSegment = this.mTabSegmentRef.get();
            if (qMUITabSegment != null && qMUITabSegment.mPendingSelectedIndex != -1) {
                qMUITabSegment.mPendingSelectedIndex = i;
            } else {
                if (qMUITabSegment == null || qMUITabSegment.getSelectedIndex() == i || i >= qMUITabSegment.getTabCount()) {
                    return;
                }
                qMUITabSegment.selectTab(i, true, false);
            }
        }
    }

    private static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager mViewPager;

        @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
        public void onDoubleTap(int i) {
        }

        @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
        public void onTabReselected(int i) {
        }

        @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
        public void onTabUnselected(int i) {
        }

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.mViewPager = viewPager;
        }

        @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
        public void onTabSelected(int i) {
            this.mViewPager.setCurrentItem(i, false);
        }
    }

    private class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean mAutoRefresh;
        private final boolean mUseAdapterTitle;

        AdapterChangeListener(boolean z) {
            this.mUseAdapterTitle = z;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            if (QMUITabSegment.this.mViewPager == viewPager) {
                QMUITabSegment.this.setPagerAdapter(pagerAdapter2, this.mUseAdapterTitle, this.mAutoRefresh);
            }
        }

        void setAutoRefresh(boolean z) {
            this.mAutoRefresh = z;
        }
    }

    private class PagerAdapterObserver extends DataSetObserver {
        private final boolean mUseAdapterTitle;

        PagerAdapterObserver(boolean z) {
            this.mUseAdapterTitle = z;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            QMUITabSegment.this.populateFromPagerAdapter(this.mUseAdapterTitle);
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            QMUITabSegment.this.populateFromPagerAdapter(this.mUseAdapterTitle);
        }
    }
}
