package com.qmuiteam.qmui.widget.dialog;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIBottomSheetListAdapter extends RecyclerView.Adapter<VH> {
    public static final int ITEM_TYPE_FOOTER = 2;
    public static final int ITEM_TYPE_HEADER = 1;
    public static final int ITEM_TYPE_NORMAL = 3;
    private View mFooterView;
    private final boolean mGravityCenter;
    private View mHeaderView;
    private final boolean mNeedMark;
    private OnItemClickListener mOnItemClickListener;
    private List<QMUIBottomSheetListItemModel> mData = new ArrayList();
    private int mCheckedIndex = -1;

    public interface OnItemClickListener {
        void onClick(VH vh, int i, QMUIBottomSheetListItemModel qMUIBottomSheetListItemModel);
    }

    public QMUIBottomSheetListAdapter(boolean z, boolean z2) {
        this.mNeedMark = z;
        this.mGravityCenter = z2;
    }

    public void setCheckedIndex(int i) {
        this.mCheckedIndex = i;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setData(View view, View view2, List<QMUIBottomSheetListItemModel> list) {
        this.mHeaderView = view;
        this.mFooterView = view2;
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.mHeaderView == null || i != 0) {
            return (i != getItemCount() - 1 || this.mFooterView == null) ? 3 : 2;
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new VH(this.mHeaderView);
        }
        if (i == 2) {
            return new VH(this.mFooterView);
        }
        final VH vh = new VH(new QMUIBottomSheetListItemView(viewGroup.getContext(), this.mNeedMark, this.mGravityCenter));
        vh.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIBottomSheetListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QMUIBottomSheetListAdapter.this.mOnItemClickListener != null) {
                    int adapterPosition = vh.getAdapterPosition();
                    if (QMUIBottomSheetListAdapter.this.mHeaderView != null) {
                        adapterPosition--;
                    }
                    QMUIBottomSheetListAdapter.this.mOnItemClickListener.onClick(vh, adapterPosition, (QMUIBottomSheetListItemModel) QMUIBottomSheetListAdapter.this.mData.get(adapterPosition));
                }
            }
        });
        return vh;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH vh, int i) {
        if (vh.getItemViewType() != 3) {
            return;
        }
        if (this.mHeaderView != null) {
            i--;
        }
        ((QMUIBottomSheetListItemView) vh.itemView).render(this.mData.get(i), i == this.mCheckedIndex);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size() + (this.mHeaderView != null ? 1 : 0) + (this.mFooterView == null ? 0 : 1);
    }

    public static class VH extends RecyclerView.ViewHolder {
        public VH(View view) {
            super(view);
        }
    }
}
