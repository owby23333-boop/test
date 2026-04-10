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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/funny/audio/view/core/LinearSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", d.R, "Landroid/content/Context;", "spacingDp", "", "topSpacingDp", "orientation", "", "(Landroid/content/Context;FFI)V", "spacingPx", "topSpacingPx", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LinearSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private final int orientation;
    private final float spacingDp;
    private final int spacingPx;
    private final float topSpacingDp;
    private final int topSpacingPx;

    public /* synthetic */ LinearSpacingItemDecoration(Context context, float f, float f2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, f, (i2 & 4) != 0 ? 0.0f : f2, (i2 & 8) != 0 ? 1 : i);
    }

    public LinearSpacingItemDecoration(Context context, float f, float f2, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.spacingDp = f;
        this.topSpacingDp = f2;
        this.orientation = i;
        this.spacingPx = ViewKt.dpToPx(context, f);
        this.topSpacingPx = ViewKt.dpToPx(context, f2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition == -1) {
            return;
        }
        if (this.orientation == 1) {
            if (childAdapterPosition == 0) {
                outRect.top = this.topSpacingPx;
            }
            outRect.bottom = this.spacingPx;
        } else {
            if (childAdapterPosition == 0) {
                outRect.left = this.topSpacingPx;
            }
            outRect.right = this.spacingPx;
        }
    }
}
