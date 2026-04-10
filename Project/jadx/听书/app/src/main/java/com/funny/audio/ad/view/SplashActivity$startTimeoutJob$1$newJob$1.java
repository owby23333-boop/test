package com.funny.audio.ad.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SplashActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.ad.view.SplashActivity$startTimeoutJob$1$newJob$1", f = "SplashActivity.kt", i = {0}, l = {68}, m = "invokeSuspend", n = {"time"}, s = {"J$0"})
final class SplashActivity$startTimeoutJob$1$newJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    int label;
    final /* synthetic */ SplashActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SplashActivity$startTimeoutJob$1$newJob$1(SplashActivity splashActivity, Continuation<? super SplashActivity$startTimeoutJob$1$newJob$1> continuation) {
        super(2, continuation);
        this.this$0 = splashActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashActivity$startTimeoutJob$1$newJob$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SplashActivity$startTimeoutJob$1$newJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0037 -> B:14:0x003a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L1a
            if (r1 != r2) goto L12
            long r3 = r7.J$0
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
            goto L3a
        L12:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1a:
            kotlin.ResultKt.throwOnFailure(r8)
            r3 = 0
            r8 = r7
        L20:
            com.funny.audio.ad.view.SplashActivity r1 = r8.this$0
            long r5 = com.funny.audio.ad.view.SplashActivity.access$getTotalTimeout$p(r1)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L3f
            r1 = r8
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r8.J$0 = r3
            r8.label = r2
            r5 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r5, r1)
            if (r1 != r0) goto L3a
            return r0
        L3a:
            r1 = 1000(0x3e8, float:1.401E-42)
            long r5 = (long) r1
            long r3 = r3 + r5
            goto L20
        L3f:
            com.funny.audio.view.DialogUtils r0 = com.funny.audio.view.DialogUtils.INSTANCE
            java.lang.String r1 = "开屏广告加载超时，请点击超时按钮进入app~"
            r0.tip(r1)
            com.funny.audio.ad.view.SplashActivity r8 = r8.this$0
            com.funny.audio.databinding.ActivitySplashBinding r8 = com.funny.audio.ad.view.SplashActivity.access$getBd(r8)
            com.qmuiteam.qmui.layout.QMUIFrameLayout r8 = r8.btnOverTime
            r0 = 0
            r8.setVisibility(r0)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.ad.view.SplashActivity$startTimeoutJob$1$newJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
