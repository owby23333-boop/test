package com.dangdang.zframework.view.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.dangdang.zframework.view.DDWebView;
import com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase;

/* JADX INFO: loaded from: classes10.dex */
public class PullToRefreshWebView extends PullToRefreshBase<DDWebView> {
    public PullToRefreshWebView(Context context) {
        super(context);
    }

    public void init(PullToRefreshBase.OnRefreshListener onRefreshListener) {
        setOnRefreshListener(onRefreshListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullDown() {
        return ((DDWebView) this.refreshableView).getScrollY() == 0 && isPullToRefreshEnabled();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullUp() {
        return ((DDWebView) this.refreshableView).getScrollY() >= ((DDWebView) this.refreshableView).getContentHeight() - ((DDWebView) this.refreshableView).getHeight() && isPullUpToRefreshEnabled();
    }

    public PullToRefreshWebView(Context context, int i) {
        super(context, i);
    }

    @Override // com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase
    public DDWebView createRefreshableView(Context context, AttributeSet attributeSet) {
        return new DDWebView(context, attributeSet);
    }

    public PullToRefreshWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
