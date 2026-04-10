package com.funny.audio.view.adapters;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.chad.library.adapter4.viewholder.QuickViewHolder;
import com.funny.audio.R;
import com.funny.audio.core.ext.LongKt;
import com.funny.audio.database.entities.PlayHistoryEntity;
import com.funny.audio.view.ImageUtils;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HistoryAlbumAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0014J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0014¨\u0006\u0011"}, d2 = {"Lcom/funny/audio/view/adapters/HistoryAlbumAdapter;", "Lcom/chad/library/adapter4/BaseQuickAdapter;", "Lcom/funny/audio/database/entities/PlayHistoryEntity;", "Lcom/chad/library/adapter4/viewholder/QuickViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "item", "onCreateViewHolder", d.R, "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "viewType", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HistoryAlbumAdapter extends BaseQuickAdapter<PlayHistoryEntity, QuickViewHolder> {
    public HistoryAlbumAdapter() {
        super(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public void onBindViewHolder(QuickViewHolder holder, int position, PlayHistoryEntity item) {
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (item != null) {
            ImageUtils.INSTANCE.loadToView(getContext(), (ImageView) holder.getView(R.id.ivCover), item.getCoverPath());
            holder.setText(R.id.tvTitle, item.getTitle());
            int trackIndex = item.getTrackIndex() + 1;
            if (trackIndex >= item.getTrackCount()) {
                str = "已听至最新章";
            } else {
                str = (item.getTrackCount() - trackIndex) + "集未听";
            }
            holder.setText(R.id.tvProgress, str);
            holder.setText(R.id.tvHistory, LongKt.toRelativeTimeDescription(item.getTime()) + "收听");
            holder.setText(R.id.tvUpdate, "最新章：" + item.getLastTrackTitle());
            LinearLayout linearLayout = (LinearLayout) holder.getView(R.id.lySelect);
            if (item.getIsEditMode()) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(8);
            }
            if (item.getIsSelected()) {
                holder.setImageResource(R.id.ivSelect, R.drawable.ic_edit_mode_selected);
            } else {
                holder.setImageResource(R.id.ivSelect, R.drawable.ic_edit_mode_normal);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public QuickViewHolder onCreateViewHolder(Context context, ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new QuickViewHolder(R.layout.adapter_history_album, parent);
    }
}
