package com.funny.audio.view.mine;

import com.funny.audio.models.CloudUpdateInfo;
import com.funny.audio.update.AppUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MineFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/funny/audio/models/CloudUpdateInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.mine.MineFragment$checkUpdate$updateInfo$1", f = "MineFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MineFragment$checkUpdate$updateInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CloudUpdateInfo>, Object> {
    int label;

    MineFragment$checkUpdate$updateInfo$1(Continuation<? super MineFragment$checkUpdate$updateInfo$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MineFragment$checkUpdate$updateInfo$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CloudUpdateInfo> continuation) {
        return ((MineFragment$checkUpdate$updateInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return AppUpdater.INSTANCE.loadUpdateInfo();
    }
}
