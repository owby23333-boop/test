package com.amgcyo.cuttadon.j.itemdecoration;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Px;
import androidx.collection.ArraySet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.amgcyo.cuttadon.j.d.d, reason: from Kotlin metadata */
/* JADX INFO: compiled from: GridItemDecoration.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001(B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J(\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J(\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#H\u0002J \u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010'\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/amgcyo/cuttadon/utils/itemdecoration/GridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "builder", "Lcom/amgcyo/cuttadon/utils/itemdecoration/GridItemDecoration$Builder;", "(Lcom/amgcyo/cuttadon/utils/itemdecoration/GridItemDecoration$Builder;)V", "divider", "Landroid/graphics/drawable/Drawable;", "dividerSize", "", "hideDividerItemTypeSet", "Landroidx/collection/ArraySet;", "isIncludeEdge", "", "isSpace", "addTo", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "addToTest", "calculateHorizontalDividerSize", "calculateVerticalDividerSize", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", com.anythink.expressad.a.B, "Landroid/view/View;", "parent", CallMraidJS.b, "Landroidx/recyclerview/widget/RecyclerView$State;", "isHideItemType", "itemPosition", "isInLastRowOrColumn", "itemCount", "spanCount", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "onDraw", "c", "Landroid/graphics/Canvas;", "removeFrom", "Builder", "app_fmydRelease"}, k = 1, mv = {1, 1, 16})
public final class GridItemDecoration extends RecyclerView.ItemDecoration {
    private final boolean a;
    private final Drawable b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f4071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArraySet<Integer> f4072e;

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.j.d.d$a */
    /* JADX INFO: compiled from: GridItemDecoration.kt */
    public static final class a {
        private boolean a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4073c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f4074d;

        @NotNull
        private Drawable b = new ColorDrawable(0);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        private final ArraySet<Integer> f4075e = new ArraySet<>(1);

        @NotNull
        public final a a(@ColorInt int i2) {
            this.b = new ColorDrawable(i2);
            return this;
        }

        @NotNull
        public final Drawable b() {
            return this.b;
        }

        public final int c() {
            return this.f4073c;
        }

        @NotNull
        public final ArraySet<Integer> d() {
            return this.f4075e;
        }

        @NotNull
        public final a e() {
            this.f4074d = true;
            return this;
        }

        public final boolean f() {
            return this.f4074d;
        }

        public final boolean g() {
            return this.a;
        }

        @NotNull
        public final GridItemDecoration a() {
            return new GridItemDecoration(this);
        }

        @NotNull
        public final a b(@Px int i2) {
            this.f4073c = i2;
            return this;
        }
    }

    public GridItemDecoration(@NotNull a aVar) {
        this.a = aVar.g();
        this.b = aVar.b();
        this.f4070c = aVar.c();
        this.f4071d = aVar.f();
        this.f4072e = aVar.d();
    }

    @NotNull
    public final RecyclerView.ItemDecoration a(@NotNull RecyclerView recyclerView) {
        b(recyclerView);
        recyclerView.addItemDecoration(this);
        return this;
    }

    public final void b(@NotNull RecyclerView recyclerView) {
        recyclerView.removeItemDecoration(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        int i2;
        int i3;
        super.getItemOffsets(outRect, view, parent, state);
        int iA = b.a(parent);
        if (iA == 0) {
            return;
        }
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition == -1) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (!(layoutManager instanceof GridLayoutManager)) {
            layoutManager = null;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        if (gridLayoutManager != null) {
            int spanCount = gridLayoutManager.getSpanCount();
            int iA2 = b.a(gridLayoutManager, childAdapterPosition);
            int iB = b.b(gridLayoutManager, childAdapterPosition);
            int iB2 = b();
            int iA3 = a();
            if (gridLayoutManager.getOrientation() == 1) {
                if (iA3 % spanCount != 0) {
                    iA3 = (iA3 / spanCount) * spanCount;
                }
                if (iB == spanCount) {
                    i3 = this.f4071d ? iA3 * 2 : 0;
                } else {
                    i3 = (((this.f4071d ? 1 : -1) + spanCount) * iA3) / spanCount;
                }
                if (this.f4071d) {
                    outRect.left = ((iA2 + 1) * iA3) - (iA2 * i3);
                    outRect.right = i3 - outRect.left;
                    outRect.top = iA2 == childAdapterPosition ? iB2 : 0;
                    if (iB == spanCount && a(childAdapterPosition, parent)) {
                        outRect.bottom = 0;
                        return;
                    } else {
                        outRect.bottom = iB2;
                        return;
                    }
                }
                outRect.left = iA2 * (iA3 - i3);
                outRect.right = i3 - outRect.left;
                outRect.top = 0;
                if (iB == spanCount && a(childAdapterPosition, parent)) {
                    outRect.bottom = 0;
                    return;
                }
                if (a(childAdapterPosition, iA, spanCount, gridLayoutManager)) {
                    iB2 = 0;
                }
                outRect.bottom = iB2;
                return;
            }
            if (iB2 % spanCount != 0) {
                iB2 = (iB2 / spanCount) * spanCount;
            }
            if (iB == spanCount) {
                i2 = this.f4071d ? iB2 * 2 : 0;
            } else {
                i2 = (((this.f4071d ? 1 : -1) + spanCount) * iB2) / spanCount;
            }
            if (this.f4071d) {
                outRect.top = ((iA2 + 1) * iB2) - (iA2 * i2);
                outRect.bottom = i2 - outRect.top;
                outRect.left = iA2 == childAdapterPosition ? iA3 : 0;
                if (iB == spanCount && a(childAdapterPosition, parent)) {
                    outRect.right = 0;
                    return;
                } else {
                    outRect.right = iA3;
                    return;
                }
            }
            outRect.top = iA2 * (iB2 - i2);
            outRect.bottom = i2 - outRect.top;
            outRect.left = 0;
            if (iB == spanCount && a(childAdapterPosition, parent)) {
                outRect.right = 0;
                return;
            }
            if (a(childAdapterPosition, iA, spanCount, gridLayoutManager)) {
                iA3 = 0;
            }
            outRect.right = iA3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0157  */
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDraw(@org.jetbrains.annotations.NotNull android.graphics.Canvas r27, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView r28, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.State r29) {
        /*
            Method dump skipped, instruction units count: 572
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.j.itemdecoration.GridItemDecoration.onDraw(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    private final int b() {
        Drawable drawable = this.b;
        return drawable instanceof ColorDrawable ? this.f4070c : drawable.getIntrinsicHeight();
    }

    private final int a() {
        Drawable drawable = this.b;
        return drawable instanceof ColorDrawable ? this.f4070c : drawable.getIntrinsicWidth();
    }

    private final boolean a(int i2, RecyclerView recyclerView) {
        return this.f4072e.contains(Integer.valueOf(b.a(recyclerView, i2)));
    }

    private final boolean a(int i2, int i3, int i4, GridLayoutManager gridLayoutManager) {
        int i5 = i3 - 1;
        if (i2 == i5) {
            return true;
        }
        if (i5 - i2 >= i4) {
            return false;
        }
        int i6 = i5 - 1;
        int i7 = i5 - i4;
        if (i6 < i7) {
            i6 = -1;
            break;
        }
        while (b.a(gridLayoutManager, i6) + b.b(gridLayoutManager, i6) != i4) {
            if (i6 == i7) {
                i6 = -1;
                break;
            }
            i6--;
        }
        return i2 > i6;
    }
}
