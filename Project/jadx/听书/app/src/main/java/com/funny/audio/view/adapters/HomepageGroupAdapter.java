package com.funny.audio.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.chad.library.adapter4.util.ItemClickUtilsKt;
import com.chad.library.adapter4.viewholder.QuickViewHolder;
import com.funny.audio.AppManager;
import com.funny.audio.R;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.models.GroupInfo;
import com.funny.audio.view.NavigationUtils;
import com.funny.audio.view.core.GridSpacingItemDecoration;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomepageGroupAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0014J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0014¨\u0006\u0011"}, d2 = {"Lcom/funny/audio/view/adapters/HomepageGroupAdapter;", "Lcom/chad/library/adapter4/BaseQuickAdapter;", "Lcom/funny/audio/models/GroupInfo;", "Lcom/chad/library/adapter4/viewholder/QuickViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "item", "onCreateViewHolder", d.R, "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "viewType", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomepageGroupAdapter extends BaseQuickAdapter<GroupInfo, QuickViewHolder> {
    public HomepageGroupAdapter() {
        super(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public void onBindViewHolder(QuickViewHolder holder, int position, final GroupInfo item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (item != null) {
            ((TextView) holder.getView(R.id.tvGroupName)).setText(item.getGroupName());
            GroupAlbumAdapter groupAlbumAdapter = new GroupAlbumAdapter();
            ItemClickUtilsKt.setOnDebouncedItemClick$default(groupAlbumAdapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.adapters.HomepageGroupAdapter$$ExternalSyntheticLambda0
                @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
                public final void onClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    HomepageGroupAdapter.onBindViewHolder$lambda$1$lambda$0(item, this, baseQuickAdapter, view, i);
                }
            }, 1, null);
            RecyclerView recyclerView = (RecyclerView) holder.getView(R.id.rvGroupItems);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(getContext(), 3, 10.0f, 8.0f, 0.0f, false));
            recyclerView.setAdapter(groupAlbumAdapter);
            ViewKt.click$default((LinearLayout) holder.getView(R.id.lyMore), 0, new Function0<Unit>() { // from class: com.funny.audio.view.adapters.HomepageGroupAdapter$onBindViewHolder$1$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    NavigationUtils navigationUtils = NavigationUtils.INSTANCE;
                    Activity mainActivity = AppManager.INSTANCE.getMainActivity();
                    Intrinsics.checkNotNull(mainActivity);
                    navigationUtils.toHomepageGroupMore(mainActivity, item);
                }
            }, 1, null);
            groupAlbumAdapter.submitList(item.getAlbums().subList(0, 6));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(GroupInfo groupInfo, HomepageGroupAdapter this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(groupInfo, "$groupInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        NavigationUtils.INSTANCE.toAlbumDetail(this$0.getContext(), groupInfo.getAlbums().get(i).getId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public QuickViewHolder onCreateViewHolder(Context context, ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new QuickViewHolder(R.layout.adapter_homepage_group, parent);
    }
}
