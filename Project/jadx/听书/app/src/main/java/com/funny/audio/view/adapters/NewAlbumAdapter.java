package com.funny.audio.view.adapters;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.chad.library.adapter4.viewholder.QuickViewHolder;
import com.funny.audio.R;
import com.funny.audio.models.AlbumInfo;
import com.funny.audio.view.ImageUtils;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewAlbumAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0014J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0014¨\u0006\u0011"}, d2 = {"Lcom/funny/audio/view/adapters/NewAlbumAdapter;", "Lcom/chad/library/adapter4/BaseQuickAdapter;", "Lcom/funny/audio/models/AlbumInfo;", "Lcom/chad/library/adapter4/viewholder/QuickViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "item", "onCreateViewHolder", d.R, "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "viewType", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NewAlbumAdapter extends BaseQuickAdapter<AlbumInfo, QuickViewHolder> {
    public NewAlbumAdapter() {
        super(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public void onBindViewHolder(QuickViewHolder holder, int position, AlbumInfo item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (item != null) {
            ImageUtils.INSTANCE.loadToView(getContext(), (ImageView) holder.getView(R.id.ivCover), item.getCoverPath());
            ((TextView) holder.getView(R.id.tvTitle)).setText(item.getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public QuickViewHolder onCreateViewHolder(Context context, ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new QuickViewHolder(R.layout.adapter_homepage_new_album, parent);
    }
}
