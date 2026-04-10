package com.funny.audio.view.core;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.funny.audio.core.ext.ViewKt;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DecorationUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/funny/audio/view/core/GridSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", d.R, "Landroid/content/Context;", "spanCount", "", "rowSpacingDp", "", "columnSpacingDp", "topSpacingDp", "includeEdge", "", "(Landroid/content/Context;IFFFZ)V", "columnSpacing", "rowSpacing", "topSpacing", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private final int columnSpacing;
    private final boolean includeEdge;
    private final int rowSpacing;
    private final int spanCount;
    private final int topSpacing;

    public /* synthetic */ GridSpacingItemDecoration(Context context, int i, float f, float f2, float f3, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, f, f2, (i2 & 16) != 0 ? 0.0f : f3, z);
    }

    public GridSpacingItemDecoration(Context context, int i, float f, float f2, float f3, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.spanCount = i;
        this.includeEdge = z;
        this.rowSpacing = ViewKt.dpToPx(context, f);
        this.columnSpacing = ViewKt.dpToPx(context, f2);
        this.topSpacing = ViewKt.dpToPx(context, f3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        int i = this.spanCount;
        int i2 = childAdapterPosition % i;
        if (this.includeEdge) {
            int i3 = this.columnSpacing;
            outRect.left = i3 - ((i2 * i3) / i);
            outRect.right = ((i2 + 1) * this.columnSpacing) / this.spanCount;
            if (childAdapterPosition < this.spanCount) {
                outRect.top = this.topSpacing;
            }
            outRect.bottom = this.rowSpacing;
            return;
        }
        outRect.left = (this.columnSpacing * i2) / i;
        int i4 = this.columnSpacing;
        outRect.right = i4 - (((i2 + 1) * i4) / this.spanCount);
        if (childAdapterPosition >= this.spanCount) {
            outRect.top = this.rowSpacing;
        } else {
            outRect.top = this.topSpacing;
        }
    }
}
