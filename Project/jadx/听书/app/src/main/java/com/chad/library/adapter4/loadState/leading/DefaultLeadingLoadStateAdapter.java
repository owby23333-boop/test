package com.chad.library.adapter4.loadState.leading;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter4.R;
import com.chad.library.adapter4.loadState.LoadState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultLeadingLoadStateAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"Lcom/chad/library/adapter4/loadState/leading/DefaultLeadingLoadStateAdapter;", "Lcom/chad/library/adapter4/loadState/leading/LeadingLoadStateAdapter;", "Lcom/chad/library/adapter4/loadState/leading/DefaultLeadingLoadStateAdapter$LeadingLoadStateVH;", "()V", "getStateViewType", "", "loadState", "Lcom/chad/library/adapter4/loadState/LoadState;", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "LeadingLoadStateVH", "com.github.CymChad.brvah"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DefaultLeadingLoadStateAdapter extends LeadingLoadStateAdapter<LeadingLoadStateVH> {

    /* JADX INFO: compiled from: DefaultLeadingLoadStateAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/chad/library/adapter4/loadState/leading/DefaultLeadingLoadStateAdapter$LeadingLoadStateVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "loadingProgress", "getLoadingProgress", "()Landroid/view/View;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class LeadingLoadStateVH extends RecyclerView.ViewHolder {
        private final View loadingProgress;

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ LeadingLoadStateVH(ViewGroup viewGroup, View view, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 2) != 0) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.brvah_leading_load_more, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
            }
            this(viewGroup, view);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LeadingLoadStateVH(ViewGroup parent, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = this.itemView.findViewById(R.id.loading_progress);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.loadingProgress = viewFindViewById;
        }

        public final View getLoadingProgress() {
            return this.loadingProgress;
        }
    }

    @Override // com.chad.library.adapter4.loadState.LoadStateAdapter
    public LeadingLoadStateVH onCreateViewHolder(ViewGroup parent, LoadState loadState) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        return new LeadingLoadStateVH(parent, null, 2, 0 == true ? 1 : 0);
    }

    @Override // com.chad.library.adapter4.loadState.LoadStateAdapter
    public void onBindViewHolder(LeadingLoadStateVH holder, LoadState loadState) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        if (loadState instanceof LoadState.Loading) {
            holder.getLoadingProgress().setVisibility(0);
        } else {
            holder.getLoadingProgress().setVisibility(8);
        }
    }

    @Override // com.chad.library.adapter4.loadState.LoadStateAdapter
    public int getStateViewType(LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        return R.layout.brvah_leading_load_more;
    }
}
