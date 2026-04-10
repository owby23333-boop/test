package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.utils.ax;

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    final RecyclerView Vb;
    final RecyclerView.LayoutManager Vc;

    private f(RecyclerView recyclerView) {
        this.Vb = recyclerView;
        this.Vc = recyclerView.getLayoutManager();
    }

    public static f b(RecyclerView recyclerView) {
        ax.checkNotNull(recyclerView);
        return new f(recyclerView);
    }

    public final int findFirstVisibleItemPosition() {
        View viewA = a(0, this.Vc.getChildCount(), false, true);
        if (viewA == null) {
            return -1;
        }
        return this.Vb.getChildAdapterPosition(viewA);
    }

    public final int findLastVisibleItemPosition() {
        View viewA = a(this.Vc.getChildCount() - 1, -1, false, true);
        if (viewA == null) {
            return -1;
        }
        return this.Vb.getChildAdapterPosition(viewA);
    }

    private View a(int i, int i2, boolean z, boolean z2) {
        OrientationHelper orientationHelperCreateHorizontalHelper;
        if (this.Vc.canScrollVertically()) {
            orientationHelperCreateHorizontalHelper = OrientationHelper.createVerticalHelper(this.Vc);
        } else {
            orientationHelperCreateHorizontalHelper = OrientationHelper.createHorizontalHelper(this.Vc);
        }
        int startAfterPadding = orientationHelperCreateHorizontalHelper.getStartAfterPadding();
        int endAfterPadding = orientationHelperCreateHorizontalHelper.getEndAfterPadding();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View childAt = this.Vc.getChildAt(i);
            int decoratedStart = orientationHelperCreateHorizontalHelper.getDecoratedStart(childAt);
            int decoratedEnd = orientationHelperCreateHorizontalHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                return childAt;
            }
            i += i3;
        }
        return null;
    }
}
