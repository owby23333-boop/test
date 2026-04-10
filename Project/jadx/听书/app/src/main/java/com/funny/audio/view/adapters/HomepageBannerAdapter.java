package com.funny.audio.view.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.funny.audio.R;
import com.funny.audio.models.BannerInfo;
import com.funny.audio.view.ImageUtils;
import com.umeng.analytics.pro.d;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.util.BannerUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomepageBannerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/funny/audio/view/adapters/HomepageBannerAdapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "Lcom/funny/audio/models/BannerInfo;", "Lcom/funny/audio/view/adapters/HomepageBannerAdapter$HomepageBannerViewHolder;", "dataList", "", "(Ljava/util/List;)V", d.R, "Landroid/content/Context;", "onBindView", "", "holder", "data", "position", "", "size", "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "HomepageBannerViewHolder", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomepageBannerAdapter extends BannerAdapter<BannerInfo, HomepageBannerViewHolder> {
    private Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomepageBannerAdapter(List<BannerInfo> dataList) {
        super(dataList);
        Intrinsics.checkNotNullParameter(dataList, "dataList");
    }

    @Override // com.youth.banner.holder.IViewHolder
    public HomepageBannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNull(parent);
        View view = BannerUtils.getView(parent, R.layout.adapter_homepage_banner);
        this.context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new HomepageBannerViewHolder(view);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(HomepageBannerViewHolder holder, BannerInfo data, int position, int size) {
        ImageUtils imageUtils = ImageUtils.INSTANCE;
        Context context = this.context;
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNull(holder);
        ImageView cover = holder.getCover();
        Intrinsics.checkNotNull(cover);
        Intrinsics.checkNotNull(data);
        imageUtils.loadToView(context, cover, data.getBannerUrl());
    }

    /* JADX INFO: compiled from: HomepageBannerAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/funny/audio/view/adapters/HomepageBannerAdapter$HomepageBannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "cover", "Landroid/widget/ImageView;", "getCover", "()Landroid/widget/ImageView;", "setCover", "(Landroid/widget/ImageView;)V", "getView", "()Landroid/view/View;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class HomepageBannerViewHolder extends RecyclerView.ViewHolder {
        private ImageView cover;
        private final View view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomepageBannerViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
            this.cover = (ImageView) view.findViewById(R.id.ivCover);
        }

        public final View getView() {
            return this.view;
        }

        public final ImageView getCover() {
            return this.cover;
        }

        public final void setCover(ImageView imageView) {
            this.cover = imageView;
        }
    }
}
