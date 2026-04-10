package com.lxj.easyadapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.b.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.lxj.easyadapter.e, reason: from Kotlin metadata */
/* JADX INFO: compiled from: WrapperUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J[\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062K\u0010\u0007\u001aG\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000f0\bJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, d2 = {"Lcom/lxj/easyadapter/WrapperUtils;", "", "()V", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "fn", "Lkotlin/Function3;", "Landroidx/recyclerview/widget/GridLayoutManager;", "Lkotlin/ParameterName;", "name", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "oldLookup", "", "position", "setFullSpan", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "easy-adapter_release"}, k = 1, mv = {1, 1, 15})
public final class WrapperUtils {
    public static final WrapperUtils a = new WrapperUtils();

    /* JADX INFO: renamed from: com.lxj.easyadapter.e$a */
    /* JADX INFO: compiled from: WrapperUtils.kt */
    public static final class a extends GridLayoutManager.SpanSizeLookup {
        final /* synthetic */ q a;
        final /* synthetic */ RecyclerView.LayoutManager b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ GridLayoutManager.SpanSizeLookup f17315c;

        a(q qVar, RecyclerView.LayoutManager layoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.a = qVar;
            this.b = layoutManager;
            this.f17315c = spanSizeLookup;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            return ((Number) this.a.a(this.b, this.f17315c, Integer.valueOf(i2))).intValue();
        }
    }

    private WrapperUtils() {
    }

    public final void a(@NotNull RecyclerView recyclerView, @NotNull q<? super GridLayoutManager, ? super GridLayoutManager.SpanSizeLookup, ? super Integer, Integer> qVar) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new a(qVar, layoutManager, gridLayoutManager.getSpanSizeLookup()));
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }

    public final void a(@NotNull RecyclerView.ViewHolder viewHolder) {
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams == null || !(layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            return;
        }
        ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
    }
}
