package com.qmuiteam.qmui.nestedScroll;

/* JADX INFO: loaded from: classes4.dex */
public interface IQMUIContinuousNestedBottomView extends IQMUIContinuousNestedScrollCommon {
    public static final int HEIGHT_IS_ENOUGH_TO_SCROLL = -1;

    void consumeScroll(int i);

    int getContentHeight();

    int getCurrentScroll();

    int getScrollOffsetRange();

    void smoothScrollYBy(int i, int i2);

    void stopScroll();
}
