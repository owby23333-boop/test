package com.dangdang.zframework.view.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.dangdang.zframework.R;
import com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase;

/* JADX INFO: loaded from: classes10.dex */
public class PullToRefreshScrollView extends PullToRefreshBase<ScrollView> {
    public PullToRefreshScrollView(Context context) {
        super(context);
    }

    public void init(PullToRefreshBase.OnRefreshListener onRefreshListener) {
        setOnRefreshListener(onRefreshListener);
    }

    @Override // com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullDown() {
        return ((ScrollView) this.refreshableView).getScrollY() == 0;
    }

    @Override // com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullUp() {
        View childAt = ((ScrollView) this.refreshableView).getChildAt(0);
        return childAt != null && ((ScrollView) this.refreshableView).getScrollY() >= childAt.getHeight() - getHeight();
    }

    public PullToRefreshScrollView(Context context, int i) {
        super(context, i);
    }

    @Override // com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase
    public ScrollView createRefreshableView(Context context, AttributeSet attributeSet) {
        ScrollView scrollView = new ScrollView(context, attributeSet);
        scrollView.setId(R.id.scrollview);
        return scrollView;
    }

    public PullToRefreshScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
