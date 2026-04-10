package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;

/* JADX INFO: loaded from: classes5.dex */
public class QMUIContinuousNestedBottomRecyclerView extends RecyclerView implements IQMUIContinuousNestedBottomView {
    public static final String KEY_SCROLL_INFO_OFFSET = "@qmui_scroll_info_bottom_rv_offset";
    public static final String KEY_SCROLL_INFO_POSITION = "@qmui_scroll_info_bottom_rv_pos";
    private IQMUIContinuousNestedScrollCommon.OnScrollNotifier mOnScrollNotifier;
    private final int[] mScrollConsumed;

    public QMUIContinuousNestedBottomRecyclerView(Context context) {
        super(context);
        this.mScrollConsumed = new int[2];
        init();
    }

    public QMUIContinuousNestedBottomRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScrollConsumed = new int[2];
        init();
    }

    public QMUIContinuousNestedBottomRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScrollConsumed = new int[2];
        init();
    }

    private void init() {
        setVerticalScrollBarEnabled(false);
        addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (QMUIContinuousNestedBottomRecyclerView.this.mOnScrollNotifier != null) {
                    if (i == 0) {
                        QMUIContinuousNestedBottomRecyclerView.this.mOnScrollNotifier.onScrollStateChange(recyclerView, 0);
                    } else if (i == 2) {
                        QMUIContinuousNestedBottomRecyclerView.this.mOnScrollNotifier.onScrollStateChange(recyclerView, 2);
                    } else if (i == 1) {
                        QMUIContinuousNestedBottomRecyclerView.this.mOnScrollNotifier.onScrollStateChange(recyclerView, 1);
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                if (QMUIContinuousNestedBottomRecyclerView.this.mOnScrollNotifier != null) {
                    QMUIContinuousNestedBottomRecyclerView.this.mOnScrollNotifier.notify(recyclerView.computeVerticalScrollOffset(), Math.max(0, recyclerView.computeVerticalScrollRange() - recyclerView.getHeight()));
                }
            }
        });
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public void consumeScroll(int i) {
        if (i == Integer.MIN_VALUE) {
            scrollToPosition(0);
            return;
        }
        boolean z = true;
        if (i == Integer.MAX_VALUE) {
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter != null) {
                scrollToPosition(adapter.getItemCount() - 1);
                return;
            }
            return;
        }
        if (hasNestedScrollingParent(0)) {
            z = false;
        } else {
            startNestedScroll(2, 0);
            int[] iArr = this.mScrollConsumed;
            iArr[0] = 0;
            iArr[1] = 0;
            dispatchNestedPreScroll(0, i, iArr, null, 0);
            i -= this.mScrollConsumed[1];
        }
        scrollBy(0, i);
        if (z) {
            stopNestedScroll(0);
        }
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public int getContentHeight() {
        if (getAdapter() == null || getLayoutManager() == null) {
            return 0;
        }
        int iComputeVerticalScrollRange = computeVerticalScrollRange();
        if (iComputeVerticalScrollRange > getHeight()) {
            return -1;
        }
        return iComputeVerticalScrollRange;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void injectScrollNotifier(IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
        this.mOnScrollNotifier = onScrollNotifier;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public int getCurrentScroll() {
        return computeVerticalScrollOffset();
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public int getScrollOffsetRange() {
        return Math.max(0, computeVerticalScrollRange() - getHeight());
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public void smoothScrollYBy(int i, int i2) {
        startNestedScroll(2, 1);
        smoothScrollBy(0, i, null);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void saveScrollInfo(Bundle bundle) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            View viewFindViewByPosition = linearLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
            int top2 = viewFindViewByPosition == null ? 0 : viewFindViewByPosition.getTop();
            bundle.putInt(KEY_SCROLL_INFO_POSITION, iFindFirstVisibleItemPosition);
            bundle.putInt(KEY_SCROLL_INFO_OFFSET, top2);
        }
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void restoreScrollInfo(Bundle bundle) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(bundle.getInt(KEY_SCROLL_INFO_POSITION, 0), bundle.getInt(KEY_SCROLL_INFO_OFFSET, 0));
            IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier = this.mOnScrollNotifier;
            if (onScrollNotifier != null) {
                onScrollNotifier.notify(getCurrentScroll(), getScrollOffsetRange());
            }
        }
    }
}
