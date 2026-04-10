package com.funny.audio.view.mine;

import com.funny.audio.api.ApiManager;
import com.funny.audio.core.net.Response;
import com.funny.audio.models.LoginAccountReq;
import com.funny.audio.models.UserInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LoginActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lcom/funny/audio/core/net/Response;", "Lcom/funny/audio/models/UserInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.mine.LoginActivity$login$resp$1", f = "LoginActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LoginActivity$login$resp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response<UserInfo>>, Object> {
    final /* synthetic */ LoginAccountReq $req;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoginActivity$login$resp$1(LoginAccountReq loginAccountReq, Continuation<? super LoginActivity$login$resp$1> continuation) {
        super(2, continuation);
        this.$req = loginAccountReq;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginActivity$login$resp$1(this.$req, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Response<UserInfo>> continuation) {
        return ((LoginActivity$login$resp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$req.getEmail().length() > 0) {
            return ApiManager.INSTANCE.getUser().loginByEmail(this.$req);
        }
        return ApiManager.INSTANCE.getUser().loginByPhone(this.$req);
    }
}
