package com.funny.audio.view.search;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.funny.audio.database.entities.SearchHistoryEntity;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.search.SearchActivity$initSearchHistory$2$1$1", f = "SearchActivity.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION}, m = "invokeSuspend", n = {}, s = {})
final class SearchActivity$initSearchHistory$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SearchHistoryEntity $searchHistoryEntity;
    int label;
    final /* synthetic */ SearchActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchActivity$initSearchHistory$2$1$1(SearchActivity searchActivity, SearchHistoryEntity searchHistoryEntity, Continuation<? super SearchActivity$initSearchHistory$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = searchActivity;
        this.$searchHistoryEntity = searchHistoryEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchActivity$initSearchHistory$2$1$1(this.this$0, this.$searchHistoryEntity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchActivity$initSearchHistory$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.isSearchKeyword = true;
            SearchActivity.access$getBd(this.this$0).etKeyword.setText(this.$searchHistoryEntity.getKeyword());
            this.label = 1;
            if (this.this$0.searchAlbum(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.isSearchKeyword = false;
        return Unit.INSTANCE;
    }
}
