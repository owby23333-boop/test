package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.qmuiteam.qmui.util.QMUIWindowInsetHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIViewPager extends ViewPager {
    private static final int DEFAULT_INFINITE_RATIO = 100;
    private boolean mEnableLoop;
    private int mInfiniteRatio;
    private boolean mIsInMeasure;
    private boolean mIsSwipeable;

    public QMUIViewPager(Context context) {
        this(context, null);
    }

    public QMUIViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsSwipeable = true;
        this.mIsInMeasure = false;
        this.mEnableLoop = false;
        this.mInfiniteRatio = 100;
        QMUIWindowInsetHelper.overrideWithDoNotHandleWindowInsets(this);
    }

    public void setSwipeable(boolean z) {
        this.mIsSwipeable = z;
    }

    public int getInfiniteRatio() {
        return this.mInfiniteRatio;
    }

    public void setInfiniteRatio(int i) {
        this.mInfiniteRatio = i;
    }

    public boolean isEnableLoop() {
        return this.mEnableLoop;
    }

    public void setEnableLoop(boolean z) {
        if (this.mEnableLoop != z) {
            this.mEnableLoop = z;
            if (getAdapter() != null) {
                getAdapter().notifyDataSetChanged();
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ViewCompat.requestApplyInsets(view);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.mIsSwipeable) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.mIsSwipeable) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mIsInMeasure = true;
        super.onMeasure(i, i2);
        this.mIsInMeasure = false;
    }

    public boolean isInMeasure() {
        return this.mIsInMeasure;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        if (pagerAdapter instanceof QMUIPagerAdapter) {
            super.setAdapter(new WrapperPagerAdapter((QMUIPagerAdapter) pagerAdapter));
        } else {
            super.setAdapter(pagerAdapter);
        }
    }

    class WrapperPagerAdapter extends PagerAdapter {
        private QMUIPagerAdapter mAdapter;

        public WrapperPagerAdapter(QMUIPagerAdapter qMUIPagerAdapter) {
            this.mAdapter = qMUIPagerAdapter;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            int count = this.mAdapter.getCount();
            return (!QMUIViewPager.this.mEnableLoop || count <= 3) ? count : count * QMUIViewPager.this.mInfiniteRatio;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (QMUIViewPager.this.mEnableLoop && this.mAdapter.getCount() != 0) {
                i %= this.mAdapter.getCount();
            }
            return this.mAdapter.instantiateItem(viewGroup, i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (QMUIViewPager.this.mEnableLoop && this.mAdapter.getCount() != 0) {
                i %= this.mAdapter.getCount();
            }
            this.mAdapter.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return this.mAdapter.isViewFromObject(view, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
            this.mAdapter.restoreState(parcelable, classLoader);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Parcelable saveState() {
            return this.mAdapter.saveState();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void startUpdate(ViewGroup viewGroup) {
            this.mAdapter.startUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(ViewGroup viewGroup) {
            this.mAdapter.finishUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.mAdapter.getPageTitle(i % this.mAdapter.getCount());
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i) {
            return this.mAdapter.getPageWidth(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            this.mAdapter.setPrimaryItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.mAdapter.unregisterDataSetObserver(dataSetObserver);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.mAdapter.registerDataSetObserver(dataSetObserver);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            this.mAdapter.notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return this.mAdapter.getItemPosition(obj);
        }
    }
}
