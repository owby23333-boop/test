package com.funny.audio.view.album;

import com.funny.audio.database.DbContext;
import com.funny.audio.database.entities.PlayHistoryEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AlbumTracksFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/funny/audio/database/entities/PlayHistoryEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.album.AlbumTracksFragment$loadData$history$1", f = "AlbumTracksFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AlbumTracksFragment$loadData$history$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PlayHistoryEntity>, Object> {
    int label;
    final /* synthetic */ AlbumTracksFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AlbumTracksFragment$loadData$history$1(AlbumTracksFragment albumTracksFragment, Continuation<? super AlbumTracksFragment$loadData$history$1> continuation) {
        super(2, continuation);
        this.this$0 = albumTracksFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlbumTracksFragment$loadData$history$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PlayHistoryEntity> continuation) {
        return ((AlbumTracksFragment$loadData$history$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return DbContext.INSTANCE.getCurrent().playHistory().album(this.this$0.getAlbumId());
    }
}
