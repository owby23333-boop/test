package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;

/* JADX INFO: loaded from: classes5.dex */
public class QMUIContinuousNestedTopRecyclerView extends RecyclerView implements IQMUIContinuousNestedTopView {
    public static final String KEY_SCROLL_INFO_OFFSET = "@qmui_scroll_info_top_rv_offset";
    public static final String KEY_SCROLL_INFO_POSITION = "@qmui_scroll_info_top_rv_pos";
    private final int[] mScrollConsumed;
    private IQMUIContinuousNestedScrollCommon.OnScrollNotifier mScrollNotifier;

    public QMUIContinuousNestedTopRecyclerView(Context context) {
        this(context, null);
        init();
    }

    public QMUIContinuousNestedTopRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init();
    }

    public QMUIContinuousNestedTopRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScrollConsumed = new int[2];
        init();
    }

    private void init() {
        setVerticalScrollBarEnabled(false);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int consumeScroll(int i) {
        if (i == Integer.MIN_VALUE) {
            scrollToPosition(0);
            return Integer.MIN_VALUE;
        }
        boolean z = true;
        if (i == Integer.MAX_VALUE) {
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter != null) {
                scrollToPosition(adapter.getItemCount() - 1);
            }
            return Integer.MAX_VALUE;
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
        return 0;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int getCurrentScroll() {
        return computeVerticalScrollOffset();
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int getScrollOffsetRange() {
        return Math.max(0, computeVerticalScrollRange() - getHeight());
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void injectScrollNotifier(IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
        this.mScrollNotifier = onScrollNotifier;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i, int i2) {
        super.onScrolled(i, i2);
        IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier = this.mScrollNotifier;
        if (onScrollNotifier != null) {
            onScrollNotifier.notify(getCurrentScroll(), getScrollOffsetRange());
        }
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
            IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier = this.mScrollNotifier;
            if (onScrollNotifier != null) {
                onScrollNotifier.notify(getCurrentScroll(), getScrollOffsetRange());
            }
        }
    }
}
