package com.funny.audio.view.homepage;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.chad.library.adapter4.util.ItemClickUtilsKt;
import com.funny.audio.AppManager;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.databinding.ActivityHomepageGroupMoreBinding;
import com.funny.audio.models.AlbumInfo;
import com.funny.audio.models.GroupInfo;
import com.funny.audio.view.NavigationUtils;
import com.funny.audio.view.adapters.HomepageGroupMoreAlbumAdapter;
import com.funny.audio.view.core.BaseActivity;
import com.funny.audio.view.core.LinearSpacingItemDecoration;
import com.funny.audio.view.core.StatusBarUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomepageGroupMoreActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/funny/audio/view/homepage/HomepageGroupMoreActivity;", "Lcom/funny/audio/view/core/BaseActivity;", "Lcom/funny/audio/databinding/ActivityHomepageGroupMoreBinding;", "()V", "adapter", "Lcom/funny/audio/view/adapters/HomepageGroupMoreAlbumAdapter;", "initData", "", "initStatusBar", "initView", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomepageGroupMoreActivity extends BaseActivity<ActivityHomepageGroupMoreBinding> {
    private final HomepageGroupMoreAlbumAdapter adapter = new HomepageGroupMoreAlbumAdapter();

    @Override // com.funny.audio.view.core.BaseActivity
    public void initView() {
        initStatusBar();
        ImageView imageView = getBd().appBack;
        Intrinsics.checkNotNullExpressionValue(imageView, "bd.appBack");
        ViewKt.click$default(imageView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.homepage.HomepageGroupMoreActivity.initView.1
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
                HomepageGroupMoreActivity.this.finish();
            }
        }, 1, null);
        RecyclerView recyclerView = getBd().rvAlbums;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "bd.rvAlbums");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(this.adapter);
        ItemClickUtilsKt.setOnDebouncedItemClick$default(this.adapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.homepage.HomepageGroupMoreActivity$$ExternalSyntheticLambda0
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                HomepageGroupMoreActivity.initView$lambda$1(this.f$0, baseQuickAdapter, view, i);
            }
        }, 1, null);
        recyclerView.addItemDecoration(new LinearSpacingItemDecoration(getContext(), 12.0f, 10.0f, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(HomepageGroupMoreActivity this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        AlbumInfo albumInfo = (AlbumInfo) adapter.getItem(i);
        if (albumInfo != null) {
            NavigationUtils.INSTANCE.toAlbumDetail(this$0, albumInfo.getId());
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initData() {
        GroupInfo groupInfo = AppManager.INSTANCE.getGroupInfo();
        if (groupInfo != null) {
            getBd().tvTitle.setText(groupInfo.getGroupName());
            this.adapter.submitList(groupInfo.getAlbums());
            this.adapter.notifyDataSetChanged();
        }
    }

    private final void initStatusBar() {
        HomepageGroupMoreActivity homepageGroupMoreActivity = this;
        StatusBarUtils.INSTANCE.translucent(homepageGroupMoreActivity);
        if (AppManager.INSTANCE.isNightMode()) {
            StatusBarUtils.INSTANCE.setStatusBarDarkMode(homepageGroupMoreActivity);
        } else {
            StatusBarUtils.INSTANCE.setStatusBarLightMode(homepageGroupMoreActivity);
        }
    }
}
