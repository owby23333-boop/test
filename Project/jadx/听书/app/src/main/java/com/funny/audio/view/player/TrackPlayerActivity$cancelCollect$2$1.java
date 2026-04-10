package com.funny.audio.view.player;

import com.funny.audio.database.DbContext;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.player.TrackPlayerActivity$cancelCollect$2$1", f = "TrackPlayerActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TrackPlayerActivity$cancelCollect$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $albumId;
    int label;
    final /* synthetic */ TrackPlayerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TrackPlayerActivity$cancelCollect$2$1(String str, TrackPlayerActivity trackPlayerActivity, Continuation<? super TrackPlayerActivity$cancelCollect$2$1> continuation) {
        super(2, continuation);
        this.$albumId = str;
        this.this$0 = trackPlayerActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrackPlayerActivity$cancelCollect$2$1(this.$albumId, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TrackPlayerActivity$cancelCollect$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        DbContext.INSTANCE.getCurrent().bookshelf().remove(this.$albumId);
        this.this$0.isCollect = false;
        return Unit.INSTANCE;
    }
}
