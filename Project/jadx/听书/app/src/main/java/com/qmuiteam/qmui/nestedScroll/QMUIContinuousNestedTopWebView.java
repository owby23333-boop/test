package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.webview.QMUIWebView;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIContinuousNestedTopWebView extends QMUIWebView implements IQMUIContinuousNestedTopView {
    public static final String KEY_SCROLL_INFO = "@qmui_scroll_info_top_webview";
    private IQMUIContinuousNestedScrollCommon.OnScrollNotifier mScrollNotifier;

    public QMUIContinuousNestedTopWebView(Context context) {
        super(context);
        init();
    }

    public QMUIContinuousNestedTopWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public QMUIContinuousNestedTopWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setVerticalScrollBarEnabled(false);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int consumeScroll(int i) {
        int iMin;
        int scrollY = getScrollY();
        int scrollOffsetRange = getScrollOffsetRange();
        int iMax = Math.max(0, Math.min(scrollY, scrollOffsetRange));
        if (i < 0) {
            iMin = Math.max(i, -iMax);
        } else {
            iMin = i > 0 ? Math.min(i, scrollOffsetRange - iMax) : 0;
        }
        scrollBy(0, iMin);
        return i - iMin;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int getCurrentScroll() {
        return Math.max(0, Math.min(getScrollY(), getScrollOffsetRange()));
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int getScrollOffsetRange() {
        return computeVerticalScrollRange() - getHeight();
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void injectScrollNotifier(IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
        this.mScrollNotifier = onScrollNotifier;
    }

    @Override // com.qmuiteam.qmui.widget.webview.QMUIWebView, android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier = this.mScrollNotifier;
        if (onScrollNotifier != null) {
            onScrollNotifier.notify(getCurrentScroll(), getScrollOffsetRange());
        }
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void saveScrollInfo(Bundle bundle) {
        bundle.putInt(KEY_SCROLL_INFO, getScrollY());
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void restoreScrollInfo(Bundle bundle) {
        exec("javascript:scrollTo(0, " + QMUIDisplayHelper.px2dp(getContext(), bundle.getInt(KEY_SCROLL_INFO, 0)) + ")");
    }

    private void exec(String str) {
        evaluateJavascript(str, null);
    }
}
