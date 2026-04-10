package com.funny.audio.view.mine;

import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.funny.audio.AppManager;
import com.funny.audio.R;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.databinding.ActivityFeedbackBinding;
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

/* JADX INFO: compiled from: FeedbackActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0011\u0010\n\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/funny/audio/view/mine/FeedbackActivity;", "Lcom/funny/audio/view/core/BaseActivity;", "Lcom/funny/audio/databinding/ActivityFeedbackBinding;", "()V", "feedbackType", "", "initData", "", "initStatusBar", "initView", "submit", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FeedbackActivity extends BaseActivity<ActivityFeedbackBinding> {
    private int feedbackType;

    /* JADX INFO: renamed from: com.funny.audio.view.mine.FeedbackActivity$submit$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FeedbackActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.mine.FeedbackActivity", f = "FeedbackActivity.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK}, m = "submit", n = {"this"}, s = {"L$0"})
    static final class C06111 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06111(Continuation<? super C06111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FeedbackActivity.this.submit(this);
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initData() {
    }

    public static final /* synthetic */ ActivityFeedbackBinding access$getBd(FeedbackActivity feedbackActivity) {
        return feedbackActivity.getBd();
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initView() {
        initStatusBar();
        ImageView imageView = getBd().appBack;
        Intrinsics.checkNotNullExpressionValue(imageView, "bd.appBack");
        ViewKt.click$default(imageView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.FeedbackActivity.initView.1
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
                FeedbackActivity.this.finish();
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout = getBd().lyType0;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout, "bd.lyType0");
        ViewKt.click$default(qMUIFrameLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.FeedbackActivity.initView.2
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
                FeedbackActivity.this.feedbackType = 0;
                FeedbackActivity.access$getBd(FeedbackActivity.this).lyType0.setBackgroundResource(R.color.filter_box_background_selected_color);
                FeedbackActivity.access$getBd(FeedbackActivity.this).tvType0.setTextColor(ContextCompat.getColor(FeedbackActivity.this.getContext(), R.color.filter_box_text_selected_color));
                FeedbackActivity.access$getBd(FeedbackActivity.this).lyType1.setBackgroundResource(R.color.filter_box_background_normal_color);
                FeedbackActivity.access$getBd(FeedbackActivity.this).tvType1.setTextColor(ContextCompat.getColor(FeedbackActivity.this.getContext(), R.color.filter_box_text_normal_color));
                FeedbackActivity.access$getBd(FeedbackActivity.this).lyType2.setBackgroundResource(R.color.filter_box_background_normal_color);
                FeedbackActivity.access$getBd(FeedbackActivity.this).tvType2.setTextColor(ContextCompat.getColor(FeedbackActivity.this.getContext(), R.color.filter_box_text_normal_color));
                FeedbackActivity.access$getBd(FeedbackActivity.this).lyType3.setBackgroundResource(R.color.filter_box_background_normal_color);
                FeedbackActivity.access$getBd(FeedbackActivity.this).tvType3.setTextColor(ContextCompat.getColor(FeedbackActivity.this.getContext(), R.color.filter_box_text_normal_color));
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout2 = getBd().lyType1;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout2, "bd.lyType1");
        ViewKt.click$default(qMUIFrameLayout2, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.FeedbackActivity.initView.3
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
                FeedbackActivity.this.feedbackType = 1;
                FeedbackActivity.access$getBd(FeedbackActivity.this).lyType0.setBackgroundResource(R.color.filter_box_background_normal_color);
                FeedbackActivity.access$getBd(FeedbackActivity.this).tvType0.setTextColor(ContextCompat.getColor(FeedbackActivity.this.getContext(), R.color.filter_box_text_normal_color));
                FeedbackActivity.access$getBd(FeedbackActivity.this).lyType1.setBackgroundResource(R.color.filter_box_background_selected_color);
                FeedbackActivity.access$getBd(FeedbackActivity.this).tvType1.setTextColor(ContextCompat.getColor(FeedbackActivity.this.getContext(), R.color.filter_box_text_selected_color));
                FeedbackActivity.access$getBd(FeedbackActivity.this).lyType2.setBackgroundResource(R.color.filter_box_background_normal_color);
                FeedbackActivity.access$getBd(FeedbackActivity.this).tvType2.setTextColor(ContextCompat.getColor(FeedbackActivity.this.getContext(), R.color.filter_box_text_normal_color));
                FeedbackActivity.access$getBd(FeedbackActivity.this).lyType3.setBackgroundResource(R.color.filter_box_background_normal_color);
                FeedbackActivity.access$getBd(FeedbackActivity.this).tvType3.setTextColor(ContextCompat.getColor(FeedbackActivity.this.getContext(), R.color.filter_box_text_normal_color));
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout3 = getBd().lyType2;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout3, "bd.lyType2");
        ViewKt.click$default(qMUIFrameLayout3, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.FeedbackActivity.initView.4
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
                FeedbackActivity.this.feedbackType = 2;
                FeedbackActivity.access$getBd(FeedbackActivity.this).lyType0.setBackgroundResource(R.color.filter_box_background_normal_color);
                FeedbackActivity.access$getBd(FeedbackActivity.this).tvType0.setTextColor(ContextCompat.getColor(FeedbackActivity.this.getContext(), R.color.filter_box_text_normal_color));
                FeedbackActivity.access$getBd(FeedbackActivity.this).lyType1.setBackgroundResource(R.color.filter_box_background_normal_color);
                FeedbackActivity.access$getBd(FeedbackActivity.this).tvType1.setTextColor(ContextCompat.getColor(FeedbackActivity.this.getContext(), R.color.filter_box_text_normal_color));
                FeedbackActivity.access$getBd(FeedbackActivity.this).lyType2.setBackgroundResource(R.color.filter_box_background_selected_color);
                FeedbackActivity.access$getBd(FeedbackActivity.this).tvType2.setTextColor(ContextCompat.getColor(FeedbackActivity.this.getContext(), R.color.filter_box_text_selected_color));
                FeedbackActivity.access$getBd(FeedbackActivity.this).lyType3.setBackgroundResource(R.color.filter_box_background_normal_color);
                FeedbackActivity.access$getBd(FeedbackActivity.this).tvType3.setTextColor(ContextCompat.getColor(FeedbackActivity.this.getContext(), R.color.filter_box_text_normal_color));
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout4 = getBd().lyType3;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout4, "bd.lyType3");
        ViewKt.click$default(qMUIFrameLayout4, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.FeedbackActivity.initView.5
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
                FeedbackActivity.this.feedbackType = 3;
                FeedbackActivity.access$getBd(FeedbackActivity.this).lyType0.setBackgroundResource(R.color.filter_box_background_normal_color);
                FeedbackActivity.access$getBd(FeedbackActivity.this).tvType0.setTextColor(ContextCompat.getColor(FeedbackActivity.this.getContext(), R.color.filter_box_text_normal_color));
                FeedbackActivity.access$getBd(FeedbackActivity.this).lyType1.setBackgroundResource(R.color.filter_box_background_normal_color);
                FeedbackActivity.access$getBd(FeedbackActivity.this).tvType1.setTextColor(ContextCompat.getColor(FeedbackActivity.this.getContext(), R.color.filter_box_text_normal_color));
                FeedbackActivity.access$getBd(FeedbackActivity.this).lyType2.setBackgroundResource(R.color.filter_box_background_normal_color);
                FeedbackActivity.access$getBd(FeedbackActivity.this).tvType2.setTextColor(ContextCompat.getColor(FeedbackActivity.this.getContext(), R.color.filter_box_text_normal_color));
                FeedbackActivity.access$getBd(FeedbackActivity.this).lyType3.setBackgroundResource(R.color.filter_box_background_selected_color);
                FeedbackActivity.access$getBd(FeedbackActivity.this).tvType3.setTextColor(ContextCompat.getColor(FeedbackActivity.this.getContext(), R.color.filter_box_text_selected_color));
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout5 = getBd().btnSubmit;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout5, "bd.btnSubmit");
        ViewKt.click$default(qMUIFrameLayout5, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.FeedbackActivity.initView.6
            {
                super(0);
            }

            /* JADX INFO: renamed from: com.funny.audio.view.mine.FeedbackActivity$initView$6$1, reason: invalid class name */
            /* JADX INFO: compiled from: FeedbackActivity.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.mine.FeedbackActivity$initView$6$1", f = "FeedbackActivity.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_FIND_STREAM_INFO}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ FeedbackActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(FeedbackActivity feedbackActivity, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = feedbackActivity;
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

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(FeedbackActivity.this, null), 3, null);
            }
        }, 1, null);
    }

    private final void initStatusBar() {
        FeedbackActivity feedbackActivity = this;
        StatusBarUtils.INSTANCE.translucent(feedbackActivity);
        if (AppManager.INSTANCE.isNightMode()) {
            StatusBarUtils.INSTANCE.setStatusBarDarkMode(feedbackActivity);
        } else {
            StatusBarUtils.INSTANCE.setStatusBarLightMode(feedbackActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object submit(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.mine.FeedbackActivity.submit(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
