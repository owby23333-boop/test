package com.funny.audio.view.mine;

import android.widget.ImageView;
import com.funny.audio.AppManager;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.databinding.ActivityPleaseAlbumBinding;
import com.funny.audio.view.core.BaseActivity;
import com.funny.audio.view.core.StatusBarUtils;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
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

/* JADX INFO: compiled from: PleaseAlbumActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0011\u0010\b\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/funny/audio/view/mine/PleaseAlbumActivity;", "Lcom/funny/audio/view/core/BaseActivity;", "Lcom/funny/audio/databinding/ActivityPleaseAlbumBinding;", "()V", "initData", "", "initStatusBar", "initView", "submit", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PleaseAlbumActivity extends BaseActivity<ActivityPleaseAlbumBinding> {

    /* JADX INFO: renamed from: com.funny.audio.view.mine.PleaseAlbumActivity$submit$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PleaseAlbumActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.mine.PleaseAlbumActivity", f = "PleaseAlbumActivity.kt", i = {0}, l = {97}, m = "submit", n = {"this"}, s = {"L$0"})
    static final class C06211 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06211(Continuation<? super C06211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PleaseAlbumActivity.this.submit(this);
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initData() {
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initView() {
        initStatusBar();
        ImageView imageView = getBd().appBack;
        Intrinsics.checkNotNullExpressionValue(imageView, "bd.appBack");
        ViewKt.click$default(imageView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.PleaseAlbumActivity.initView.1
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
                PleaseAlbumActivity.this.finish();
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout = getBd().btnSubmit;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout, "bd.btnSubmit");
        ViewKt.click$default(qMUIFrameLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.PleaseAlbumActivity.initView.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.funny.audio.view.mine.PleaseAlbumActivity$initView$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: PleaseAlbumActivity.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.mine.PleaseAlbumActivity$initView$2$1", f = "PleaseAlbumActivity.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ PleaseAlbumActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PleaseAlbumActivity pleaseAlbumActivity, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = pleaseAlbumActivity;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
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
                        if (this.this$0.submit(this) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(PleaseAlbumActivity.this, null), 3, null);
            }
        }, 1, null);
    }

    private final void initStatusBar() {
        PleaseAlbumActivity pleaseAlbumActivity = this;
        StatusBarUtils.INSTANCE.translucent(pleaseAlbumActivity);
        if (AppManager.INSTANCE.isNightMode()) {
            StatusBarUtils.INSTANCE.setStatusBarDarkMode(pleaseAlbumActivity);
        } else {
            StatusBarUtils.INSTANCE.setStatusBarLightMode(pleaseAlbumActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object submit(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.mine.PleaseAlbumActivity.submit(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
