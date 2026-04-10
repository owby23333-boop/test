package com.dangdang.zframework.view.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase;

/* JADX INFO: loaded from: classes10.dex */
public class PullToRefreshListView extends PullToRefreshBase<ListView> implements AbsListView.OnScrollListener {
    protected int mFirstVisiblePosition;
    protected ListView mListView;
    protected int mTop;
    protected int visibleLastIndex;

    public PullToRefreshListView(Context context) {
        super(context);
    }

    private boolean isFirstItemVisible() {
        ListAdapter adapter = this.mListView.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return this.mListView.getChildCount() <= 0 || this.mListView.getChildAt(0).getTop() >= 0;
        }
        return ((this.mListView.getChildCount() <= 0 || this.mListView.getFirstVisiblePosition() != 0) ? -1 : this.mListView.getChildAt(0).getTop()) >= 0;
    }

    private boolean isLastItemVisible() {
        int count = ((ListView) this.refreshableView).getCount();
        int lastVisiblePosition = ((ListView) this.refreshableView).getLastVisiblePosition();
        if (count == 0) {
            return true;
        }
        if (lastVisiblePosition == count - 1) {
            View childAt = ((ListView) this.refreshableView).getChildAt(lastVisiblePosition - ((ListView) this.refreshableView).getFirstVisiblePosition());
            return childAt != null && childAt.getBottom() <= ((ListView) this.refreshableView).getBottom();
        }
        return false;
    }

    public int getMyTop() {
        return this.mTop;
    }

    public void init(PullToRefreshBase.OnRefreshListener onRefreshListener) {
        setOnRefreshListener(onRefreshListener);
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
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        PullToRefreshBase.ReadyForPullDownRefreshListener readyForPullDownRefreshListener = this.mReadyForPullDownRefreshListener;
        if (readyForPullDownRefreshListener != null) {
            readyForPullDownRefreshListener.onReadyForPullDown(true);
        }
        this.visibleLastIndex = i2 + i;
        this.mFirstVisiblePosition = i;
        if (i < 0 || (childAt = absListView.getChildAt(absListView.getFirstVisiblePosition())) == null) {
            return;
        }
        this.mTop = childAt.getTop();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        ListAdapter adapter = ((ListView) this.refreshableView).getAdapter();
        if (adapter != null) {
            adapter.getCount();
        }
    }

    public PullToRefreshListView(Context context, int i) {
        super(context, i);
    }

    @Override // com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase
    public ListView createRefreshableView(Context context, AttributeSet attributeSet) {
        ListView listView = new ListView(context);
        this.mListView = listView;
        listView.setCacheColorHint(0);
        this.mListView.setDivider(null);
        this.mListView.setOnScrollListener(this);
        this.mListView.setVerticalFadingEdgeEnabled(false);
        this.mListView.setOverScrollMode(2);
        return this.mListView;
    }

    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
