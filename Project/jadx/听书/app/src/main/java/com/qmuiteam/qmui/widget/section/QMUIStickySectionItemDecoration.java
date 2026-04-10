package com.qmuiteam.qmui.widget.section;

import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIStickySectionItemDecoration<VH extends QMUIStickySectionAdapter.ViewHolder> extends RecyclerView.ItemDecoration {
    private Callback<VH> mCallback;
    private VH mStickyHeaderViewHolder;
    private int mStickyHeaderViewPosition = -1;
    private int mTargetTop = 0;
    private WeakReference<ViewGroup> mWeakSectionContainer;

    public interface Callback<ViewHolder extends QMUIStickySectionAdapter.ViewHolder> {
        void bindViewHolder(ViewHolder viewholder, int i);

        ViewHolder createViewHolder(ViewGroup viewGroup, int i);

        int getItemViewType(int i);

        int getRelativeStickyItemPosition(int i);

        void invalidate();

        boolean isHeaderItem(int i);

        void onHeaderVisibilityChanged(boolean z);

        void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver);
    }

    public QMUIStickySectionItemDecoration(ViewGroup viewGroup, Callback<VH> callback) {
        this.mCallback = callback;
        this.mWeakSectionContainer = new WeakReference<>(viewGroup);
        this.mCallback.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration.1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition = -1;
                QMUIStickySectionItemDecoration.this.mCallback.invalidate();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                super.onItemRangeInserted(i, i2);
                if (i <= QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition) {
                    QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition = -1;
                    QMUIStickySectionItemDecoration.this.mCallback.invalidate();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i, int i2, int i3) {
                super.onItemRangeMoved(i, i2, i3);
                if (i == QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition || i2 == QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition) {
                    QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition = -1;
                    QMUIStickySectionItemDecoration.this.mCallback.invalidate();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2) {
                super.onItemRangeChanged(i, i2);
                if (QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition < i || QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition >= i + i2 || QMUIStickySectionItemDecoration.this.mStickyHeaderViewHolder == null || QMUIStickySectionItemDecoration.this.mWeakSectionContainer.get() == null) {
                    return;
                }
                QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition = -1;
                QMUIStickySectionItemDecoration.this.mCallback.invalidate();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i, int i2) {
                super.onItemRangeRemoved(i, i2);
                if (QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition < i || QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition >= i + i2) {
                    return;
                }
                QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition = -1;
                QMUIStickySectionItemDecoration.this.setHeaderVisibility(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeaderVisibility(boolean z) {
        ViewGroup viewGroup = this.mWeakSectionContainer.get();
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(z ? 0 : 8);
        this.mCallback.onHeaderVisibilityChanged(z);
    }

    public int getStickyHeaderViewPosition() {
        return this.mStickyHeaderViewPosition;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        ViewGroup viewGroup = this.mWeakSectionContainer.get();
        if (viewGroup == null) {
            return;
        }
        if (recyclerView.getChildCount() == 0) {
            setHeaderVisibility(false);
        }
        if (recyclerView.getAdapter() == null) {
            setHeaderVisibility(false);
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            setHeaderVisibility(false);
            return;
        }
        int iFindFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        if (iFindFirstVisibleItemPosition == -1) {
            setHeaderVisibility(false);
            return;
        }
        int relativeStickyItemPosition = this.mCallback.getRelativeStickyItemPosition(iFindFirstVisibleItemPosition);
        if (relativeStickyItemPosition == -1) {
            setHeaderVisibility(false);
            return;
        }
        int itemViewType = this.mCallback.getItemViewType(relativeStickyItemPosition);
        if (itemViewType == -1) {
            setHeaderVisibility(false);
            return;
        }
        VH vh = this.mStickyHeaderViewHolder;
        if (vh == null || vh.getItemViewType() != itemViewType) {
            this.mStickyHeaderViewHolder = (VH) createStickyViewHolder(recyclerView, relativeStickyItemPosition, itemViewType);
        }
        if (this.mStickyHeaderViewPosition != relativeStickyItemPosition) {
            this.mStickyHeaderViewPosition = relativeStickyItemPosition;
            bindStickyViewHolder(viewGroup, this.mStickyHeaderViewHolder, relativeStickyItemPosition);
        }
        setHeaderVisibility(true);
        View viewFindChildViewUnder = recyclerView.findChildViewUnder(recyclerView.getWidth() / 2, viewGroup.getHeight() - 1);
        if (viewFindChildViewUnder == null) {
            int top2 = recyclerView.getTop();
            this.mTargetTop = top2;
            ViewCompat.offsetTopAndBottom(viewGroup, top2 - viewGroup.getTop());
        } else if (this.mCallback.isHeaderItem(recyclerView.getChildAdapterPosition(viewFindChildViewUnder))) {
            int top3 = (viewFindChildViewUnder.getTop() + recyclerView.getTop()) - viewGroup.getHeight();
            this.mTargetTop = top3;
            ViewCompat.offsetTopAndBottom(viewGroup, top3 - viewGroup.getTop());
        } else {
            int top4 = recyclerView.getTop();
            this.mTargetTop = top4;
            ViewCompat.offsetTopAndBottom(viewGroup, top4 - viewGroup.getTop());
        }
    }

    public int getTargetTop() {
        return this.mTargetTop;
    }

    private VH createStickyViewHolder(RecyclerView recyclerView, int i, int i2) {
        VH vh = (VH) this.mCallback.createViewHolder(recyclerView, i2);
        vh.isForStickyHeader = true;
        return vh;
    }

    private void bindStickyViewHolder(ViewGroup viewGroup, VH vh, int i) {
        this.mCallback.bindViewHolder(vh, i);
        viewGroup.removeAllViews();
        viewGroup.addView(vh.itemView);
    }
}
