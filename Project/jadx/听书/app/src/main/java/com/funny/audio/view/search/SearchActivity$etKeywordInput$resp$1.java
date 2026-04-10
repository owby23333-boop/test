package com.funny.audio.view.search;

import com.funny.audio.api.ApiManager;
import com.funny.audio.core.net.Response;
import com.funny.audio.models.AssociateInfo;
import com.funny.audio.models.SearchAssociateReq;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SearchActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lcom/funny/audio/core/net/Response;", "", "Lcom/funny/audio/models/AssociateInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.search.SearchActivity$etKeywordInput$resp$1", f = "SearchActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SearchActivity$etKeywordInput$resp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response<List<? extends AssociateInfo>>>, Object> {
    final /* synthetic */ SearchAssociateReq $req;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchActivity$etKeywordInput$resp$1(SearchAssociateReq searchAssociateReq, Continuation<? super SearchActivity$etKeywordInput$resp$1> continuation) {
        super(2, continuation);
        this.$req = searchAssociateReq;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchActivity$etKeywordInput$resp$1(this.$req, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Response<List<? extends AssociateInfo>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Response<List<AssociateInfo>>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Response<List<AssociateInfo>>> continuation) {
        return ((SearchActivity$etKeywordInput$resp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return ApiManager.INSTANCE.getSearch().querySearchAssociates(this.$req);
    }
}
