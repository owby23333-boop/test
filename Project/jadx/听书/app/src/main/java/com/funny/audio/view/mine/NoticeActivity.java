package com.funny.audio.view.mine;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.chad.library.adapter4.QuickAdapterHelper;
import com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter;
import com.chad.library.adapter4.util.ItemClickUtilsKt;
import com.funny.audio.AppManager;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.databinding.ActivityNoticeBinding;
import com.funny.audio.models.SystemNoticeInfo;
import com.funny.audio.models.SystemNoticeTypes;
import com.funny.audio.view.adapters.SystemNoticeAdapter;
import com.funny.audio.view.core.BaseActivity;
import com.funny.audio.view.core.LinearSpacingItemDecoration;
import com.funny.audio.view.core.MessageDialogFragment;
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

/* JADX INFO: compiled from: NoticeActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u0011\u0010\u0018\u001a\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/funny/audio/view/mine/NoticeActivity;", "Lcom/funny/audio/view/core/BaseActivity;", "Lcom/funny/audio/databinding/ActivityNoticeBinding;", "()V", "adapter", "Lcom/funny/audio/view/adapters/SystemNoticeAdapter;", "getAdapter", "()Lcom/funny/audio/view/adapters/SystemNoticeAdapter;", "helper", "Lcom/chad/library/adapter4/QuickAdapterHelper;", "getHelper", "()Lcom/chad/library/adapter4/QuickAdapterHelper;", "setHelper", "(Lcom/chad/library/adapter4/QuickAdapterHelper;)V", "page", "", "getPage", "()I", "setPage", "(I)V", "initData", "", "initStatusBar", "initView", "loadNotices", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoticeActivity extends BaseActivity<ActivityNoticeBinding> {
    private QuickAdapterHelper helper;
    private final SystemNoticeAdapter adapter = new SystemNoticeAdapter();
    private int page = 1;

    /* JADX INFO: renamed from: com.funny.audio.view.mine.NoticeActivity$loadNotices$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NoticeActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.mine.NoticeActivity", f = "NoticeActivity.kt", i = {0}, l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m = "loadNotices", n = {"this"}, s = {"L$0"})
    static final class C06201 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06201(Continuation<? super C06201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NoticeActivity.this.loadNotices(this);
        }
    }

    public final SystemNoticeAdapter getAdapter() {
        return this.adapter;
    }

    public final QuickAdapterHelper getHelper() {
        return this.helper;
    }

    public final void setHelper(QuickAdapterHelper quickAdapterHelper) {
        this.helper = quickAdapterHelper;
    }

    public final int getPage() {
        return this.page;
    }

    public final void setPage(int i) {
        this.page = i;
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initView() {
        initStatusBar();
        ImageView imageView = getBd().appBack;
        Intrinsics.checkNotNullExpressionValue(imageView, "bd.appBack");
        ViewKt.click$default(imageView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.NoticeActivity.initView.1
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
                NoticeActivity.this.finish();
            }
        }, 1, null);
        RecyclerView recyclerView = getBd().rvNotices;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "bd.rvNotices");
        ItemClickUtilsKt.setOnDebouncedItemClick$default(this.adapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.mine.NoticeActivity$$ExternalSyntheticLambda0
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                NoticeActivity.initView$lambda$1(this.f$0, baseQuickAdapter, view, i);
            }
        }, 1, null);
        QuickAdapterHelper quickAdapterHelperBuild = new QuickAdapterHelper.Builder(this.adapter).setTrailingLoadStateAdapter(new TrailingLoadStateAdapter.OnTrailingListener() { // from class: com.funny.audio.view.mine.NoticeActivity$initView$helper$1
            @Override // com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter.OnTrailingListener
            public void onFailRetry() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new NoticeActivity$initView$helper$1$onFailRetry$1(this.this$0, null), 3, null);
            }

            @Override // com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter.OnTrailingListener
            public void onLoad() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new NoticeActivity$initView$helper$1$onLoad$1(this.this$0, null), 3, null);
            }
        }).build();
        recyclerView.setAdapter(quickAdapterHelperBuild.getMAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new LinearSpacingItemDecoration(getContext(), 12.0f, 10.0f, 1));
        this.helper = quickAdapterHelperBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(NoticeActivity this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        SystemNoticeInfo systemNoticeInfo = (SystemNoticeInfo) adapter.getItem(i);
        if (systemNoticeInfo != null) {
            int type = systemNoticeInfo.getType();
            if (type == SystemNoticeTypes.INSTANCE.getH5()) {
                this$0.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(systemNoticeInfo.getContent())));
            } else if (type == SystemNoticeTypes.INSTANCE.getCONTENT()) {
                MessageDialogFragment content = new MessageDialogFragment().setTitle(systemNoticeInfo.getTitle()).setContent(systemNoticeInfo.getContent());
                FragmentManager supportFragmentManager = this$0.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "this.supportFragmentManager");
                content.show(supportFragmentManager);
            }
        }
    }

    private final void initStatusBar() {
        NoticeActivity noticeActivity = this;
        StatusBarUtils.INSTANCE.translucent(noticeActivity);
        if (AppManager.INSTANCE.isNightMode()) {
            StatusBarUtils.INSTANCE.setStatusBarDarkMode(noticeActivity);
        } else {
            StatusBarUtils.INSTANCE.setStatusBarLightMode(noticeActivity);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.mine.NoticeActivity$initData$1, reason: invalid class name */
    /* JADX INFO: compiled from: NoticeActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.mine.NoticeActivity$initData$1", f = "NoticeActivity.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoticeActivity.this.new AnonymousClass1(continuation);
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
                if (NoticeActivity.this.loadNotices(this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074 A[Catch: Exception -> 0x00dd, TryCatch #0 {Exception -> 0x00dd, blocks: (B:12:0x002a, B:21:0x006c, B:23:0x0074, B:25:0x0095, B:27:0x0099, B:29:0x00a6, B:28:0x009f, B:30:0x00bc, B:31:0x00cc), top: B:38:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cc A[Catch: Exception -> 0x00dd, TRY_LEAVE, TryCatch #0 {Exception -> 0x00dd, blocks: (B:12:0x002a, B:21:0x006c, B:23:0x0074, B:25:0x0095, B:27:0x0099, B:29:0x00a6, B:28:0x009f, B:30:0x00bc, B:31:0x00cc), top: B:38:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadNotices(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.mine.NoticeActivity.loadNotices(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
