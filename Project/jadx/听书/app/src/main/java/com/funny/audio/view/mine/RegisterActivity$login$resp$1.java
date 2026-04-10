package com.funny.audio.view.mine;

import com.funny.audio.api.ApiManager;
import com.funny.audio.core.net.ResponseInfo;
import com.funny.audio.models.RegisterAccountReq;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RegisterActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/funny/audio/core/net/ResponseInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.mine.RegisterActivity$login$resp$1", f = "RegisterActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RegisterActivity$login$resp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResponseInfo>, Object> {
    final /* synthetic */ RegisterAccountReq $req;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RegisterActivity$login$resp$1(RegisterAccountReq registerAccountReq, Continuation<? super RegisterActivity$login$resp$1> continuation) {
        super(2, continuation);
        this.$req = registerAccountReq;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RegisterActivity$login$resp$1(this.$req, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResponseInfo> continuation) {
        return ((RegisterActivity$login$resp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return ApiManager.INSTANCE.getUser().register(this.$req);
    }
}
