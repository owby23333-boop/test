package com.dangdang.zframework.view.pulltorefresh;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes10.dex */
public abstract class LoadingLayout extends FrameLayout {
    protected View mLoadingView;
    protected TextView mPromptView;
    protected String mPullLabel;
    protected String mRefreshingLabel;
    protected String mReleaseLabel;

    public LoadingLayout(Context context, int i, String str, String str2, String str3) {
        super(context);
        init(context, i, str, str2, str3);
        pullToRefresh();
    }

    public abstract void init(Context context, int i, String str, String str2, String str3);

    public void pullToRefresh() {
        this.mPromptView.setText(this.mPullLabel);
    }

    public void refreshing() {
        this.mPromptView.setText(this.mRefreshingLabel);
    }

    public void releaseToRefresh() {
        this.mPromptView.setText(this.mReleaseLabel);
    }

    public void reset() {
        this.mPromptView.setText(this.mPullLabel);
    }

    public void scrollPullHeader(int i, int i2) {
    }

    public void setLoadingBackgroundColor(int i) {
        View view = this.mLoadingView;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setPullLabel(String str) {
        this.mPullLabel = str;
    }

    public abstract void setRefreshValid(int i);

    public void setRefreshingLabel(String str) {
        this.mRefreshingLabel = str;
    }

    public void setReleaseLabel(String str) {
        this.mReleaseLabel = str;
    }

    public void setTextColor(int i) {
        this.mPromptView.setTextColor(i);
    }
}
