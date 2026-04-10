package com.funny.audio.view.player;

import com.funny.audio.database.DbContext;
import com.funny.audio.database.entities.BookshelfEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TrackPlayerActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/funny/audio/database/entities/BookshelfEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.player.TrackPlayerActivity$loadCollectFlag$2$bookshelfEntity$1", f = "TrackPlayerActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TrackPlayerActivity$loadCollectFlag$2$bookshelfEntity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BookshelfEntity>, Object> {
    final /* synthetic */ String $albumId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TrackPlayerActivity$loadCollectFlag$2$bookshelfEntity$1(String str, Continuation<? super TrackPlayerActivity$loadCollectFlag$2$bookshelfEntity$1> continuation) {
        super(2, continuation);
        this.$albumId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrackPlayerActivity$loadCollectFlag$2$bookshelfEntity$1(this.$albumId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BookshelfEntity> continuation) {
        return ((TrackPlayerActivity$loadCollectFlag$2$bookshelfEntity$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return DbContext.INSTANCE.getCurrent().bookshelf().get(this.$albumId);
    }
}
