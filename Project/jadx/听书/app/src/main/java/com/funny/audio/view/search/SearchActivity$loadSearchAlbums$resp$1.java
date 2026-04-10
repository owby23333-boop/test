package com.funny.audio.view.search;

import com.funny.audio.api.ApiManager;
import com.funny.audio.core.net.PageData;
import com.funny.audio.core.net.Response;
import com.funny.audio.models.SearchAlbumInfo;
import com.funny.audio.models.SearchAlbumReq;
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
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lcom/funny/audio/core/net/Response;", "Lcom/funny/audio/core/net/PageData;", "Lcom/funny/audio/models/SearchAlbumInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.search.SearchActivity$loadSearchAlbums$resp$1", f = "SearchActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SearchActivity$loadSearchAlbums$resp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response<PageData<SearchAlbumInfo>>>, Object> {
    int label;
    final /* synthetic */ SearchActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchActivity$loadSearchAlbums$resp$1(SearchActivity searchActivity, Continuation<? super SearchActivity$loadSearchAlbums$resp$1> continuation) {
        super(2, continuation);
        this.this$0 = searchActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchActivity$loadSearchAlbums$resp$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Response<PageData<SearchAlbumInfo>>> continuation) {
        return ((SearchActivity$loadSearchAlbums$resp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        SearchAlbumReq searchAlbumReq = new SearchAlbumReq();
        searchAlbumReq.setKey(this.this$0.currentSearchKeyword);
        searchAlbumReq.setPage(this.this$0.page);
        return ApiManager.INSTANCE.getSearch().searchAlbums(searchAlbumReq);
    }
}
