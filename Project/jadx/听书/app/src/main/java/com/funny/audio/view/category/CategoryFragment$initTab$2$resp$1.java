package com.funny.audio.view.category;

import com.funny.audio.api.ApiManager;
import com.funny.audio.core.net.Response;
import com.funny.audio.models.CategoryItem;
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

/* JADX INFO: compiled from: CategoryFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lcom/funny/audio/core/net/Response;", "", "Lcom/funny/audio/models/CategoryItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.category.CategoryFragment$initTab$2$resp$1", f = "CategoryFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CategoryFragment$initTab$2$resp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response<List<CategoryItem>>>, Object> {
    int label;

    CategoryFragment$initTab$2$resp$1(Continuation<? super CategoryFragment$initTab$2$resp$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CategoryFragment$initTab$2$resp$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Response<List<CategoryItem>>> continuation) {
        return ((CategoryFragment$initTab$2$resp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return ApiManager.INSTANCE.getBusiness().getCategories();
    }
}
