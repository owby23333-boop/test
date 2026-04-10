package com.dangdang.zframework.view.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase;

/* JADX INFO: loaded from: classes10.dex */
public abstract class PullToRefreshAdapterViewBase<T extends AbsListView> extends PullToRefreshBase<T> implements AbsListView.OnScrollListener {
    protected int lastSavedFirstVisibleItem;
    private ImageView mTopImageView;
    private PullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener;
    private AbsListView.OnScrollListener onScrollListener;
    private FrameLayout refreshableViewHolder;

    public PullToRefreshAdapterViewBase(Context context) {
        super(context);
        this.lastSavedFirstVisibleItem = -1;
        ((AbsListView) this.refreshableView).setOnScrollListener(this);
    }

    private boolean isFirstItemVisible() {
        View childAt;
        if (((AbsListView) this.refreshableView).getCount() == 0) {
            return true;
        }
        return ((AbsListView) this.refreshableView).getFirstVisiblePosition() == 0 && (childAt = ((AbsListView) this.refreshableView).getChildAt(0)) != null && childAt.getTop() >= ((AbsListView) this.refreshableView).getTop();
    }

    private boolean isLastItemVisible() {
        int count = ((AbsListView) this.refreshableView).getCount();
        int lastVisiblePosition = ((AbsListView) this.refreshableView).getLastVisiblePosition();
        if (count == 0) {
            return true;
        }
        if (lastVisiblePosition == count - 1) {
            View childAt = ((AbsListView) this.refreshableView).getChildAt(lastVisiblePosition - ((AbsListView) this.refreshableView).getFirstVisiblePosition());
            return childAt != null && childAt.getBottom() <= ((AbsListView) this.refreshableView).getBottom();
        }
        return false;
    }

    @Override // android.view.View
    public abstract ContextMenu.ContextMenuInfo getContextMenuInfo();

    public ImageView getmTopImageView() {
        return this.mTopImageView;
    }

    @Override // com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullDown() {
        return isFirstItemVisible() && isPullToRefreshEnabled();
    }

    @Override // com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullUp() {
        return isLastItemVisible() && isPullUpToRefreshEnabled();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        PullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener = this.onLastItemVisibleListener;
        if (onLastItemVisibleListener != null && i2 > 0 && i + i2 == i3 && i != this.lastSavedFirstVisibleItem) {
            this.lastSavedFirstVisibleItem = i;
            onLastItemVisibleListener.onLastItemVisible();
        }
        AbsListView.OnScrollListener onScrollListener = this.onScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener = this.onScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    public void setBackToTopView(ImageView imageView) {
        setmTopImageView(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.dangdang.zframework.view.pulltorefresh.PullToRefreshAdapterViewBase.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                T t = PullToRefreshAdapterViewBase.this.refreshableView;
                if (t instanceof ListView) {
                    ((ListView) t).setSelection(0);
                } else if (t instanceof GridView) {
                    ((GridView) t).setSelection(0);
                }
            }
        });
    }

    public final void setEmptyView(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(view);
            }
            this.refreshableViewHolder.addView(view, -1, -1);
        }
        T t = this.refreshableView;
        if (t instanceof EmptyViewMethodAccessor) {
            ((EmptyViewMethodAccessor) t).setEmptyViewInternal(view);
        } else {
            ((AbsListView) t).setEmptyView(view);
        }
    }

    public final void setOnLastItemVisibleListener(PullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener) {
        this.onLastItemVisibleListener = onLastItemVisibleListener;
    }

    public final void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    public void setmTopImageView(ImageView imageView) {
        this.mTopImageView = imageView;
    }

    @Override // com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase
    public void addRefreshableView(Context context, T t) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.refreshableViewHolder = frameLayout;
        frameLayout.addView(t, -1, -1);
        addView(this.refreshableViewHolder, new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }

    public PullToRefreshAdapterViewBase(Context context, int i) {
        super(context, i);
        this.lastSavedFirstVisibleItem = -1;
        ((AbsListView) this.refreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lastSavedFirstVisibleItem = -1;
        ((AbsListView) this.refreshableView).setOnScrollListener(this);
    }
}
