package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.utils.an;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    final RecyclerView MV;
    final RecyclerView.LayoutManager MW;

    private f(RecyclerView recyclerView) {
        this.MV = recyclerView;
        this.MW = recyclerView.getLayoutManager();
    }

    private View a(int i2, int i3, boolean z2, boolean z3) {
        OrientationHelper orientationHelperCreateVerticalHelper = this.MW.canScrollVertically() ? OrientationHelper.createVerticalHelper(this.MW) : OrientationHelper.createHorizontalHelper(this.MW);
        int startAfterPadding = orientationHelperCreateVerticalHelper.getStartAfterPadding();
        int endAfterPadding = orientationHelperCreateVerticalHelper.getEndAfterPadding();
        int i4 = i3 > i2 ? 1 : -1;
        while (i2 != i3) {
            View childAt = this.MW.getChildAt(i2);
            int decoratedStart = orientationHelperCreateVerticalHelper.getDecoratedStart(childAt);
            int decoratedEnd = orientationHelperCreateVerticalHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                return childAt;
            }
            i2 += i4;
        }
        return null;
    }

    public static f b(RecyclerView recyclerView) {
        an.checkNotNull(recyclerView);
        return new f(recyclerView);
    }

    public final int findFirstVisibleItemPosition() {
        View viewA = a(0, this.MW.getChildCount(), false, true);
        if (viewA == null) {
            return -1;
        }
        return this.MV.getChildAdapterPosition(viewA);
    }

    public final int findLastVisibleItemPosition() {
        View viewA = a(this.MW.getChildCount() - 1, -1, false, true);
        if (viewA == null) {
            return -1;
        }
        return this.MV.getChildAdapterPosition(viewA);
    }
}
