package com.funny.audio.view;

import android.app.Application;
import com.funny.audio.AppManager;
import com.funny.audio.ad.AdManager;
import com.funny.audio.api.ApiManager;
import com.funny.audio.core.utils.DeviceUtils;
import com.funny.audio.database.DbContext;
import com.funny.audio.databinding.ActivityWelcomeBinding;
import com.funny.audio.media_player.MediaPlayerManager;
import com.funny.audio.update.AppUpdater;
import com.funny.audio.user.UserManager;
import com.funny.audio.view.core.BaseActivity;
import com.funny.audio.view.core.StatusBarUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: WelcomeActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0002¨\u0006\b"}, d2 = {"Lcom/funny/audio/view/WelcomeActivity;", "Lcom/funny/audio/view/core/BaseActivity;", "Lcom/funny/audio/databinding/ActivityWelcomeBinding;", "()V", "initData", "", "initView", "jumpApp", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WelcomeActivity extends BaseActivity<ActivityWelcomeBinding> {
    @Override // com.funny.audio.view.core.BaseActivity
    public void initView() {
        StatusBarUtils.INSTANCE.fullscreenToolbar(this);
    }

    /* JADX INFO: renamed from: com.funny.audio.view.WelcomeActivity$initData$1, reason: invalid class name */
    /* JADX INFO: compiled from: WelcomeActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.WelcomeActivity$initData$1", f = "WelcomeActivity.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WelcomeActivity.this.new AnonymousClass1(continuation);
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
                if (BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C02411(null), 3, null).await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            WelcomeActivity.this.jumpApp();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.funny.audio.view.WelcomeActivity$initData$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WelcomeActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.funny.audio.view.WelcomeActivity$initData$1$1", f = "WelcomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C02411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            C02411(Continuation<? super C02411> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02411(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Application context = AppManager.INSTANCE.getContext();
                Intrinsics.checkNotNull(context);
                DbContext.INSTANCE.init(context);
                ApiManager.INSTANCE.init(context);
                DeviceUtils.INSTANCE.init(context);
                UserManager.INSTANCE.init(context);
                ApiManager.INSTANCE.cloudUpdate();
                AdManager.INSTANCE.init(context);
                AppUpdater.INSTANCE.init(context);
                DialogUtils.INSTANCE.init(context);
                MediaPlayerManager.INSTANCE.init(context);
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initData() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void jumpApp() {
        NavigationUtils.INSTANCE.toMain(getContext());
        finish();
    }
}
