package com.funny.audio.view.announcer;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.chad.library.adapter4.QuickAdapterHelper;
import com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter;
import com.chad.library.adapter4.util.ItemClickUtilsKt;
import com.funny.audio.AppManager;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.databinding.ActivityAnnouncerAlbumBinding;
import com.funny.audio.models.AlbumInfo;
import com.funny.audio.view.NavigationUtils;
import com.funny.audio.view.adapters.AnnouncerAlbumAdapter;
import com.funny.audio.view.core.BaseActivity;
import com.funny.audio.view.core.LinearSpacingItemDecoration;
import com.funny.audio.view.core.StatusBarUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AnnouncerAlbumActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0011\u0010\u0011\u001a\u00020\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/funny/audio/view/announcer/AnnouncerAlbumActivity;", "Lcom/funny/audio/view/core/BaseActivity;", "Lcom/funny/audio/databinding/ActivityAnnouncerAlbumBinding;", "()V", "adapter", "Lcom/funny/audio/view/adapters/AnnouncerAlbumAdapter;", "announcerId", "", "helper", "Lcom/chad/library/adapter4/QuickAdapterHelper;", "page", "", "pageSize", "initData", "", "initStatusBar", "initView", "loadAlbums", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnnouncerAlbumActivity extends BaseActivity<ActivityAnnouncerAlbumBinding> {
    private QuickAdapterHelper helper;
    private final AnnouncerAlbumAdapter adapter = new AnnouncerAlbumAdapter();
    private int page = 1;
    private int pageSize = 15;
    private String announcerId = "";

    /* JADX INFO: renamed from: com.funny.audio.view.announcer.AnnouncerAlbumActivity$loadAlbums$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnnouncerAlbumActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.announcer.AnnouncerAlbumActivity", f = "AnnouncerAlbumActivity.kt", i = {0}, l = {103}, m = "loadAlbums", n = {"this"}, s = {"L$0"})
    static final class C05871 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05871(Continuation<? super C05871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnnouncerAlbumActivity.this.loadAlbums(this);
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initView() {
        NavigationUtils navigationUtils = NavigationUtils.INSTANCE;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        this.announcerId = navigationUtils.getAnnouncerId(intent);
        initStatusBar();
        ImageView imageView = getBd().appBack;
        Intrinsics.checkNotNullExpressionValue(imageView, "bd.appBack");
        ViewKt.click$default(imageView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.announcer.AnnouncerAlbumActivity.initView.1
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
                AnnouncerAlbumActivity.this.finish();
            }
        }, 1, null);
        this.adapter.setItemAnimation(BaseQuickAdapter.AnimationType.ScaleIn);
        ItemClickUtilsKt.setOnDebouncedItemClick$default(this.adapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.announcer.AnnouncerAlbumActivity$$ExternalSyntheticLambda0
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AnnouncerAlbumActivity.initView$lambda$1(this.f$0, baseQuickAdapter, view, i);
            }
        }, 1, null);
        QuickAdapterHelper quickAdapterHelperBuild = new QuickAdapterHelper.Builder(this.adapter).setTrailingLoadStateAdapter(new TrailingLoadStateAdapter.OnTrailingListener() { // from class: com.funny.audio.view.announcer.AnnouncerAlbumActivity$initView$helper$1
            @Override // com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter.OnTrailingListener
            public void onFailRetry() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnnouncerAlbumActivity$initView$helper$1$onFailRetry$1(this.this$0, null), 3, null);
            }

            @Override // com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter.OnTrailingListener
            public void onLoad() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnnouncerAlbumActivity$initView$helper$1$onLoad$1(this.this$0, null), 3, null);
            }
        }).build();
        getBd().rvAlbums.setLayoutManager(new LinearLayoutManager(getContext()));
        getBd().rvAlbums.setAdapter(quickAdapterHelperBuild.getMAdapter());
        getBd().rvAlbums.addItemDecoration(new LinearSpacingItemDecoration(getContext(), 12.0f, 10.0f, 1));
        this.helper = quickAdapterHelperBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(AnnouncerAlbumActivity this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        AlbumInfo albumInfo = (AlbumInfo) adapter.getItem(i);
        if (albumInfo != null) {
            NavigationUtils.INSTANCE.toAlbumDetail(this$0, albumInfo.getId());
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.announcer.AnnouncerAlbumActivity$initData$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnnouncerAlbumActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.announcer.AnnouncerAlbumActivity$initData$1", f = "AnnouncerAlbumActivity.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AnnouncerAlbumActivity.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (AnnouncerAlbumActivity.this.loadAlbums(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initData() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(null), 3, null);
    }

    private final void initStatusBar() {
        AnnouncerAlbumActivity announcerAlbumActivity = this;
        StatusBarUtils.INSTANCE.translucent(announcerAlbumActivity);
        if (AppManager.INSTANCE.isNightMode()) {
            StatusBarUtils.INSTANCE.setStatusBarDarkMode(announcerAlbumActivity);
        } else {
            StatusBarUtils.INSTANCE.setStatusBarLightMode(announcerAlbumActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068 A[Catch: Exception -> 0x00d1, TryCatch #1 {Exception -> 0x00d1, blocks: (B:12:0x002a, B:21:0x0060, B:23:0x0068, B:25:0x0089, B:27:0x008d, B:29:0x009a, B:28:0x0093, B:30:0x00b0, B:31:0x00c0), top: B:40:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c0 A[Catch: Exception -> 0x00d1, TRY_LEAVE, TryCatch #1 {Exception -> 0x00d1, blocks: (B:12:0x002a, B:21:0x0060, B:23:0x0068, B:25:0x0089, B:27:0x008d, B:29:0x009a, B:28:0x0093, B:30:0x00b0, B:31:0x00c0), top: B:40:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadAlbums(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.announcer.AnnouncerAlbumActivity.loadAlbums(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
