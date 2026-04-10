package com.dangdang.zframework.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.dangdang.zframework.R;
import com.dangdang.zframework.log.LogM;

/* JADX INFO: loaded from: classes10.dex */
public class MoreListView extends ListView implements AbsListView.OnScrollListener {
    public static int PageSize = 20;
    private RotateAnimation animation;
    private View bottomView;
    private boolean isNearby;
    private AbsListView.OnScrollListener mCustomOnScrollListener;
    private OnLoadListener mLoadListener;
    private DDTextView mLoadMoreView;
    private DDImageView mLoadingIv;
    private View moreView;
    private View view;

    public interface OnLoadListener {
        boolean isFinished();

        boolean isForbidLoad();

        void onLoad();
    }

    public MoreListView(Context context) {
        super(context);
        this.isNearby = false;
        init(context);
    }

    private RotateAnimation getRotateAnimation() {
        if (this.animation == null) {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.animation = rotateAnimation;
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.animation.setDuration(500L);
            this.animation.setFillAfter(true);
            this.animation.setRepeatCount(-1);
            this.animation.setRepeatMode(1);
        }
        return this.animation;
    }

    private void init(Context context) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        setOnScrollListener(this);
        View viewInflate = layoutInflaterFrom.inflate(R.layout.book_danglist_footer, (ViewGroup) null);
        this.view = viewInflate;
        this.bottomView = viewInflate.findViewById(R.id.loading_bottom);
        View viewFindViewById = this.view.findViewById(R.id.load_more_layout);
        this.moreView = viewFindViewById;
        this.mLoadingIv = (DDImageView) viewFindViewById.findViewById(R.id.load_more_iv);
        this.mLoadMoreView = (DDTextView) this.moreView.findViewById(R.id.load_more);
        this.moreView.setVisibility(8);
        addFooterView(this.view, null, false);
    }

    private void printLog(String str) {
        LogM.d(getClass().getSimpleName(), str);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (Exception e) {
            LogM.e(e.toString());
        } catch (StackOverflowError e2) {
            LogM.e(e2.toString());
        }
    }

    public void hideLoadMore() {
        View view = this.moreView;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        try {
            super.layoutChildren();
        } catch (Exception e) {
            try {
                ListAdapter adapter = getAdapter();
                if (adapter == null || !(adapter instanceof BaseAdapter)) {
                    return;
                }
                ((BaseAdapter) adapter).notifyDataSetChanged();
            } catch (Exception unused) {
                LogM.e(e.toString());
            }
        }
    }

    public void onLoad() {
        OnLoadListener onLoadListener = this.mLoadListener;
        if (onLoadListener != null) {
            if (onLoadListener.isFinished()) {
                onLoadComplete();
            } else {
                this.mLoadListener.onLoad();
                this.moreView.setVisibility(0);
                this.mLoadMoreView.setText(R.string.listview_footer_loading);
                this.mLoadingIv.setVisibility(0);
                this.mLoadingIv.startAnimation(getRotateAnimation());
            }
        }
        printLog(" onLoad() ");
    }

    public void onLoadComplete() {
        this.moreView.setVisibility(0);
        this.mLoadingIv.setVisibility(8);
        this.mLoadingIv.clearAnimation();
        this.mLoadMoreView.setText(R.string.listview_footer_loaded);
    }

    public void onLoadFailed() {
        this.mLoadingIv.setVisibility(8);
        this.mLoadingIv.clearAnimation();
        this.mLoadMoreView.setText(R.string.listview_footer_load_fail);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener = this.mCustomOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        printLog(" onScrollStateChanged ");
        if (i == 0) {
            int lastVisiblePosition = getLastVisiblePosition();
            int count = getCount();
            int i2 = PageSize;
            OnLoadListener onLoadListener = this.mLoadListener;
            if (onLoadListener != null && ((count >= i2 || !onLoadListener.isForbidLoad()) && lastVisiblePosition == count - 1 && count > 0)) {
                onLoad();
            } else if (this.isNearby && lastVisiblePosition == count - 1 && count > 0) {
                onLoad();
            } else {
                OnLoadListener onLoadListener2 = this.mLoadListener;
                if (onLoadListener2 != null && onLoadListener2.isFinished()) {
                    onLoadComplete();
                }
            }
        }
        AbsListView.OnScrollListener onScrollListener = this.mCustomOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            LogM.e(e.toString());
            return true;
        } catch (OutOfMemoryError e2) {
            LogM.e(e2.toString());
            return true;
        }
    }

    public void removeLoadMore() {
        hideLoadMore();
    }

    public void removeMyFooterView() {
        View view;
        if (getFooterViewsCount() <= 0 || (view = this.view) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void setBottomVisible(boolean z) {
        if (z) {
            this.bottomView.setVisibility(0);
        } else {
            this.bottomView.setVisibility(8);
        }
    }

    public void setCustomOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mCustomOnScrollListener = onScrollListener;
    }

    public void setLoadMoreTVColor(int i) {
        this.mLoadMoreView.setTextColor(i);
    }

    public void setLoading() {
        this.moreView.setVisibility(0);
        this.mLoadMoreView.setText(R.string.listview_footer_loading);
    }

    public void setNearby() {
        this.isNearby = true;
    }

    public void setOnLoadListener(OnLoadListener onLoadListener) {
        this.mLoadListener = onLoadListener;
    }

    public MoreListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isNearby = false;
        init(context);
    }
}
